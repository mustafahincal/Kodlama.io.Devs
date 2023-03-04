package com.mustafahincal.business.concretes;

import com.mustafahincal.business.abstracts.SubTechnologyService;
import com.mustafahincal.business.requests.ProgrammingLanguageCreateRequest;
import com.mustafahincal.business.requests.SubTechnologyCreateRequest;
import com.mustafahincal.business.responses.ProgrammingLanguageGetAllResponse;
import com.mustafahincal.business.responses.SubTechnologyGetAllResponse;
import com.mustafahincal.core.utilities.mappers.ModelMapperService;
import com.mustafahincal.entities.SubTechnology;
import com.mustafahincal.repositories.SubTechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubTechnologyServiceImpl implements SubTechnologyService {
    private SubTechnologyRepository subTechnologyRepository;
    private ModelMapperService modelMapperService;

    public SubTechnologyServiceImpl(SubTechnologyRepository subTechnologyRepository, ModelMapperService modelMapperService){
        this.subTechnologyRepository = subTechnologyRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<SubTechnologyGetAllResponse> getAll() {
        List<SubTechnology> subTechnologies =  this.subTechnologyRepository.findAll();
        List<SubTechnologyGetAllResponse> subTechnologyGetAllResponses = subTechnologies.stream().map(subTechnology -> this.modelMapperService.forResponse().map(subTechnology,SubTechnologyGetAllResponse.class)).collect(Collectors.toList());

        return subTechnologyGetAllResponses;
    }

    @Override
    public void add(SubTechnologyCreateRequest subTechnologyCreateRequest) {
        SubTechnology subTechnologyToSave = this.modelMapperService.forRequest().map(subTechnologyCreateRequest,SubTechnology.class);
        this.subTechnologyRepository.save(subTechnologyToSave);
    }
}
