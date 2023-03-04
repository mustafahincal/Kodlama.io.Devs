package com.mustafahincal.business.abstracts;

import com.mustafahincal.business.requests.ProgrammingLanguageCreateRequest;
import com.mustafahincal.business.requests.SubTechnologyCreateRequest;
import com.mustafahincal.business.responses.ProgrammingLanguageGetAllResponse;
import com.mustafahincal.business.responses.ProgrammingLanguageGetByIdResponse;
import com.mustafahincal.business.responses.SubTechnologyGetAllResponse;
import com.mustafahincal.entities.SubTechnology;

import java.util.List;

public interface SubTechnologyService {
    List<SubTechnologyGetAllResponse> getAll();
    void add(SubTechnologyCreateRequest subTechnologyCreateRequest);
}
