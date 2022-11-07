package kodlama_io.kodlama_io_devs.api.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kodlama_io.kodlama_io_devs.entities.SubTechnology;
import kodlama_io.kodlama_io_devs.requests.*;
import kodlama_io.kodlama_io_devs.services.abstracts.SubTechnologyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtechnologies")
public class SubTechnologiesController {

    private SubTechnologyService subTechnologyService;
    public SubTechnologiesController(SubTechnologyService subTechnologyService){
        this.subTechnologyService = subTechnologyService;
    }

    @GetMapping("/getall")
    public List<SubTechnology> getAll(){
        return this.subTechnologyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody SubTechnologyAddRequest subTechnologyAddRequest){
        this.subTechnologyService.add(subTechnologyAddRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody SubTechnologyDeleteRequest subTechnologyDeleteRequest){
        this.subTechnologyService.delete(subTechnologyDeleteRequest);
    }
    @PostMapping("/update")
    public void update(@RequestBody SubTechnologyUpdateRequest subTechnologyUpdateRequest){
        this.subTechnologyService.update(subTechnologyUpdateRequest);
    }
}
