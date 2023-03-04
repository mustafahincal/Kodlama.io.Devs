package com.mustafahincal.business.rules;

import com.mustafahincal.core.utilities.exceptions.BusinessException;
import com.mustafahincal.repositories.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRules {
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public void checkIfProgrammingLanguageNameExists(String name) {
        if (this.programmingLanguageRepository.existsByName(name)) {
            throw new BusinessException("Programming Language name already exists"); //Java exception types
        }
    }
}
