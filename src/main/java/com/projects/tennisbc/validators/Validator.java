package com.projects.tennisbc.validators;

import com.projects.tennisbc.services.dto.FixtureDto;

public interface Validator {

    ValidatorMessage valid(FixtureDto dto, ValidatorMessage validatorMessage);
}
