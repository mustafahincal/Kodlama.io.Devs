package com.mustafahincal.api.controllers;

import com.mustafahincal.business.abstracts.SubTechnologyService;
import com.mustafahincal.business.requests.ProgrammingLanguageCreateRequest;
import com.mustafahincal.business.requests.SubTechnologyCreateRequest;
import com.mustafahincal.business.responses.SubTechnologyGetAllResponse;
import com.mustafahincal.entities.SubTechnology;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtechnology")
public class SubTechnologyController {
    private SubTechnologyService subTechnologyService;

    public SubTechnologyController(SubTechnologyService subTechnologyService){
        this.subTechnologyService = subTechnologyService;
    }

    @GetMapping()
    public List<SubTechnologyGetAllResponse> getAll(){

        return this.subTechnologyService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody SubTechnologyCreateRequest subTechnologyCreateRequest){
        this.subTechnologyService.add(subTechnologyCreateRequest);
    }
}
