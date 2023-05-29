package com.projects.tennisbc.validators;

import com.projects.tennisbc.enums.ValidatorFixtureEnum;
import com.projects.tennisbc.services.dto.FixtureDto;

import java.util.Objects;

public class FixtureMatchValidator implements Validator {

    private Validator next = new FixtureDateValidator();
    @Override
    public ValidatorMessage valid(FixtureDto dto, ValidatorMessage validatorMessage) {
        if (dto.getMatchId() == 0) {
            validatorMessage.setMessage(ValidatorFixtureEnum.MATCH_IS_NULL.getMessage());
            validatorMessage.setCode("7d5cde98-76ef-4602-82ab-30639f7670b9");
        }
        return next.valid(dto, validatorMessage);
    }
}
