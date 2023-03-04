package com.mustafahincal.api.controllers;

import com.mustafahincal.business.abstracts.ProgrammingLanguageService;
import com.mustafahincal.business.requests.ProgrammingLanguageCreateRequest;
import com.mustafahincal.business.responses.ProgrammingLanguageGetAllResponse;
import com.mustafahincal.business.responses.ProgrammingLanguageGetByIdResponse;
import com.mustafahincal.business.rules.ProgrammingLanguageBusinessRules;
import com.mustafahincal.entities.ProgrammingLanguage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService){
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping()
    public List<ProgrammingLanguageGetAllResponse> getAll(){
        return this.programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguageGetByIdResponse getById(@PathVariable int id){
        return this.programmingLanguageService.getById(id);
    }

    /*@GetMapping()
    public ProgrammingLanguageGetByIdResponse getById(@RequestParam(name = "id") int id){
        return this.programmingLanguageService.getById(id);
    }*/

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid ProgrammingLanguageCreateRequest programmingLanguageCreateRequest){
        this.programmingLanguageService.add(programmingLanguageCreateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.programmingLanguageService.delete(id);
    }
}
