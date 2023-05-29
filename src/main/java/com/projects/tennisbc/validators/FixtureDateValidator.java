package com.projects.tennisbc.validators;

import com.projects.tennisbc.enums.ValidatorFixtureEnum;
import com.projects.tennisbc.exceptions.FixtureInCompleteException;
import com.projects.tennisbc.services.dto.FixtureDto;

import java.util.Objects;

class FixtureDateValidator implements Validator {
    @Override
    public ValidatorMessage valid(FixtureDto dto, ValidatorMessage validatorMessage) {
        if (Objects.isNull(dto.getChallengeDate())) {
            validatorMessage.setMessage(ValidatorFixtureEnum.NO_CHALLENGE_DATE.getMessage());
            validatorMessage.setCode("e262db71-6eff-4fd4-8c77-954f14798195");
        }
        return validatorMessage;
    }

}
