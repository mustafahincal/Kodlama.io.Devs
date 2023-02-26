package com.mustafahincal.business.abstracts;

import com.mustafahincal.business.requests.ProgrammingLanguageCreateRequest;
import com.mustafahincal.business.responses.ProgrammingLanguageGetAllResponse;
import com.mustafahincal.business.responses.ProgrammingLanguageGetByIdResponse;
import com.mustafahincal.entities.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<ProgrammingLanguageGetAllResponse> getAll();
    ProgrammingLanguageGetByIdResponse getById(int id);
    void add(ProgrammingLanguageCreateRequest programmingLanguageCreateRequest);
    void delete(int id);
}
