package com.mustafahincal.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SubTechnologyGetAllResponse {
    private int id;
    private String name;
    private int programmingLanguageId;
}
