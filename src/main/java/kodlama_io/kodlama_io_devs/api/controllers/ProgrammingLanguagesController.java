package kodlama_io.kodlama_io_devs.api.controllers;

import kodlama_io.kodlama_io_devs.entities.ProgrammingLanguage;
import kodlama_io.kodlama_io_devs.services.abstracts.ProgrammingLanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService){
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll(){
        return this.programmingLanguageService.getAll();
    }
}
