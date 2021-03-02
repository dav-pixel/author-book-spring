package home.example.authorbookspring.controller;


import home.example.authorbookspring.model.Author;
import home.example.authorbookspring.repository.AuthorRepository;
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
public class AuthorController {

    public final AuthorRepository authorRepository;


    @GetMapping("/")
    public String authorPage() {

        return "author";
    }

    @GetMapping("/All Authors")
    public String authorPage(ModelMap modelMap) {
        List<Author> all = authorRepository.findAll();
        modelMap.addAttribute("authors", all);
        return "All Authors";
    }


    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/";
    }

    @GetMapping("/save/author")
    public String saveAuthor(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.addAttribute("author", authorRepository.getOne(id));


        } else {
            modelMap.addAttribute("author", new Author());
        }
        return "/saveAuthor";
    }

    @GetMapping("/author/delete")
    public String deleteAuthor(@RequestParam(value = "id", required = false) int id) {
        authorRepository.deleteById(id);
        return "redirect:/All Authors";

    }


}





