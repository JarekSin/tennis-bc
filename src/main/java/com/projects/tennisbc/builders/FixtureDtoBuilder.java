package com.projects.tennisbc.builders;

import com.projects.tennisbc.enums.FixtureStatusEnum;
import com.projects.tennisbc.services.dto.FixtureDto;

import java.time.Instant;
import java.util.UUID;

public class FixtureDtoBuilder {

    private UUID id;
    private int firstRegistrationId;
    private int secondRegistrationId;
    private Instant challengeDate;
    private int matchId;
    private FixtureStatusEnum status;

    public FixtureDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public FixtureDtoBuilder withFirstRegistrationId(int id) {
        this.firstRegistrationId = id;
        return this;
    }

    public FixtureDtoBuilder withSecondRegistrationId(int id) {
        this.secondRegistrationId = id;
        return this;
    }

    public FixtureDtoBuilder withChallengeDate(Instant challengeDate) {
        this.challengeDate = challengeDate;
        return this;
    }

    public FixtureDtoBuilder withMatchId(int matchId) {
        this.matchId = matchId;
        return this;
    }

    public FixtureDtoBuilder withStatus(FixtureStatusEnum status) {
        this.status = status;
        return this;
    }

    public FixtureDto build() {
        FixtureDto fixtureDto = new FixtureDto();
        fixtureDto.setId(this.id);
        fixtureDto.setFirstRegistrationId(this.firstRegistrationId);
        fixtureDto.setSecondRegistrationId(this.secondRegistrationId);
        fixtureDto.setChallengeDate(this.challengeDate);
        fixtureDto.setMatchId(this.matchId);
        fixtureDto.setStatus(this.status);
        return fixtureDto;
    }


}
