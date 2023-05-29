package com.projects.tennisbc.builders;

import com.projects.tennisbc.enums.FixtureStatusEnum;
import com.projects.tennisbc.repositories.entities.FixtureEntity;

import java.time.Instant;
import java.util.UUID;

public class FixtureEntityBuilder {

    private UUID id;
    private int firstRegistrationId;
    private int secondRegistrationId;
    private Instant challengeDate;
    private int matchId;
    private FixtureStatusEnum status;

    public FixtureEntityBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public FixtureEntityBuilder withFirstRegistrationId(int id) {
        this.firstRegistrationId = id;
        return this;
    }

    public FixtureEntityBuilder withSecondRegistrationId(int id) {
        this.secondRegistrationId = id;
        return this;
    }

    public FixtureEntityBuilder withChallengeDate(Instant challengeDate) {
        this.challengeDate = challengeDate;
        return this;
    }

    public FixtureEntityBuilder withMatchId(int matchId) {
        this.matchId = matchId;
        return this;
    }

    public FixtureEntityBuilder withStatus(FixtureStatusEnum status) {
        this.status = status;
        return this;
    }

    public FixtureEntity build() {
        FixtureEntity entity = new FixtureEntity();
        entity.setId(this.id);
        entity.setFirstRegistrationId(this.firstRegistrationId);
        entity.setSecondRegistrationId(this.secondRegistrationId);
        entity.setChallengeDate(this.challengeDate);
        entity.setMatchId(this.matchId);
        entity.setStatus(this.status);
        return entity;
    }


}
