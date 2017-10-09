package com.toxin.crud.controller;

import com.toxin.crud.model.Book;
import com.toxin.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;
    private int currentPage = 0;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(@RequestParam(required = false) Integer page, Model model) {
        model.addAttribute("book", new Book());
        List<Book> books = this.bookService.listBooks();
        setPaging(page, model, books);

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if(book.getId() == 0){
            this.bookService.addBook(book);
        }else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@RequestParam(required = false) Integer page, @PathVariable("id") int id, Model model){
        Book book = this.bookService.getBookById(id);
        this.bookService.makeRead(true, book);
        model.addAttribute("book", book);
        List<Book> books = this.bookService.listBooks();
        setPaging(page, model, books);

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        Book book = this.bookService.getBookById(id);
        this.bookService.makeRead(false, book);
        model.addAttribute("book", book);

        return "bookdata";
    }

    @RequestMapping(value = "books/search")
    public String searchUser(@RequestParam("searchTitle") String searchTitle, Model model) {
        Book book = (Book) this.bookService.getBookByName(searchTitle);
        model.addAttribute("book", book);

        return "bookdata";
    }

    private void setPaging(Integer page, Model model, List<Book> books) {
        PagedListHolder<Book> pagedListHolder = new PagedListHolder<Book>(books);
        pagedListHolder.setPageSize(10);

        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;

        model.addAttribute("page", page);
        currentPage = page;

        pagedListHolder.setPage(page - 1);
        model.addAttribute("listBooks", pagedListHolder.getPageList());
    }
}
