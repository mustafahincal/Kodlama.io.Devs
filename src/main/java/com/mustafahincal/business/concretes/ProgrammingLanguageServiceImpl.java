package com.mustafahincal.business.concretes;

import com.mustafahincal.business.abstracts.ProgrammingLanguageService;
import com.mustafahincal.business.requests.ProgrammingLanguageCreateRequest;
import com.mustafahincal.business.responses.ProgrammingLanguageGetAllResponse;
import com.mustafahincal.business.responses.ProgrammingLanguageGetByIdResponse;
import com.mustafahincal.business.rules.ProgrammingLanguageBusinessRules;
import com.mustafahincal.core.utilities.mappers.ModelMapperService;
import com.mustafahincal.entities.ProgrammingLanguage;
import com.mustafahincal.repositories.ProgrammingLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgrammingLanguageServiceImpl implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;
    private ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;
    private ModelMapperService modelMapperService;
    public ProgrammingLanguageServiceImpl(ProgrammingLanguageRepository programmingLanguageRepository, ModelMapperService modelMapperService, ProgrammingLanguageBusinessRules programmingLanguageBusinessRules){
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.modelMapperService = modelMapperService;
        this.programmingLanguageBusinessRules=programmingLanguageBusinessRules;
    }
    @Override
    public List<ProgrammingLanguageGetAllResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();

        List<ProgrammingLanguageGetAllResponse> programmingLanguageGetAllResponses =  programmingLanguages.stream().map(programmingLanguage -> this.modelMapperService.forResponse().map(programmingLanguage, ProgrammingLanguageGetAllResponse.class)).collect(Collectors.toList());

        return programmingLanguageGetAllResponses;
    }

    @Override
    public ProgrammingLanguageGetByIdResponse getById(int id) {
        ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(id).orElseThrow();
        ProgrammingLanguageGetByIdResponse programmingLanguageGetByIdResponse = this.modelMapperService.forResponse().map(programmingLanguage,ProgrammingLanguageGetByIdResponse.class);

        return programmingLanguageGetByIdResponse;
    }

    @Override
    public void add(ProgrammingLanguageCreateRequest programmingLanguageCreateRequest) {
        this.programmingLanguageBusinessRules.checkIfProgrammingLanguageNameExists(programmingLanguageCreateRequest.getName());

        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(programmingLanguageCreateRequest,ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        this.programmingLanguageRepository.deleteById(id);
    }
}
