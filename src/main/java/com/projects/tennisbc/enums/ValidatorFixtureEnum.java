package com.projects.tennisbc.enums;

public enum ValidatorFixtureEnum {

    FIXTURE_IS_NULL("fixture_is_null"),
    NO_CHALLENGE_DATE("no challenge date"),
    MATCH_IS_NULL("match null");

    private String message;

    ValidatorFixtureEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
