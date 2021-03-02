package home.example.authorbookspring.controller;



import home.example.authorbookspring.model.Author;
import home.example.authorbookspring.model.Book;
import home.example.authorbookspring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    public final BookRepository bookRepository;



    @GetMapping("/All Books")
    public String authorPage(ModelMap modelMap) {
        List<Book> all = bookRepository.findAll();
        modelMap.addAttribute("books", all);
        return "All Books";
    }


    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/save/book")
    public String saveBook(@RequestParam(value = "id",required = false) Integer id, ModelMap modelMap) {
        if(id != null){
            modelMap.addAttribute("book",bookRepository.getOne(id));
        }else {
            modelMap.addAttribute("book",new Book());
        }
        return "/saveBook";
    }

    @GetMapping("/book/delete")
    public String deleteBook(@RequestParam(value = "id",required = false) int id ){
        bookRepository.deleteById(id);
        return "redirect:/All Books";

    }
}





