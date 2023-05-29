package com.projects.tennisbc.validators;

import com.projects.tennisbc.enums.ValidatorFixtureEnum;
import com.projects.tennisbc.exceptions.FixtureInCompleteException;
import com.projects.tennisbc.services.dto.FixtureDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FixtureValidator {
    private Validator validator = new FixtureMatchValidator();

    public void validate(FixtureDto dto) {
        ValidatorMessage validatorMessage = validator.valid(dto, new ValidatorMessage());
        if (validatorMessage.getMessage().isEmpty()) {
            return;
        }
        throw new FixtureInCompleteException(validatorMessage.getMessage(), validatorMessage.getCode());


//        if (dto.getFirstRegistrationId() == 1) {
//            throw new FixtureInCompleteException(ValidatorFixtureEnum.FIXTURE_IS_NULL.getMessage(),
//                    "48857121-06be-4a4d-82b2-e7513022accb");
//        }
//        if (Objects.isNull(dto.getChallengeDate())) {
//            throw new FixtureInCompleteException(ValidatorFixtureEnum.NO_CHALLENGE_DATE.getMessage(),
//                    "e262db71-6eff-4fd4-8c77-954f14798195");
//        }
    }

}
