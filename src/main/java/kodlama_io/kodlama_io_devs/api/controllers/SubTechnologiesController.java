package kodlama_io.kodlama_io_devs.api.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kodlama_io.kodlama_io_devs.entities.SubTechnology;
import kodlama_io.kodlama_io_devs.services.abstracts.SubTechnologyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
