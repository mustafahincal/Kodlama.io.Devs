package kodlama_io.kodlama_io_devs.api.controllers;

import kodlama_io.kodlama_io_devs.entities.ProgrammingLanguage;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageAddRequest;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageDeleteRequest;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageUpdateRequest;
import kodlama_io.kodlama_io_devs.services.abstracts.ProgrammingLanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService){
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll(){
        return this.programmingLanguageService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody ProgrammingLanguageAddRequest programmingLanguageAddRequest){
        this.programmingLanguageService.add(programmingLanguageAddRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody ProgrammingLanguageDeleteRequest programmingLanguageDeleteRequest){
        this.programmingLanguageService.delete(programmingLanguageDeleteRequest);
    }
    @PostMapping("/update")
    public void update(@RequestBody ProgrammingLanguageUpdateRequest programmingLanguageUpdateRequest){
        this.programmingLanguageService.update(programmingLanguageUpdateRequest);
    }
}
