package com.projects.tennisbc.services.dto;

import com.projects.tennisbc.enums.FixtureStatusEnum;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class FixtureDto {

    private UUID id;
    private int firstRegistrationId;
    private int secondRegistrationId;
    private Instant challengeDate;
    private int matchId;
    private FixtureStatusEnum status;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getFirstRegistrationId() {
        return firstRegistrationId;
    }

    public void setFirstRegistrationId(int firstRegistrationId) {
        this.firstRegistrationId = firstRegistrationId;
    }

    public int getSecondRegistrationId() {
        return secondRegistrationId;
    }

    public void setSecondRegistrationId(int secondRegistrationId) {
        this.secondRegistrationId = secondRegistrationId;
    }

    public Instant getChallengeDate() {
        return challengeDate;
    }

    public void setChallengeDate(Instant challengeDate) {
        this.challengeDate = challengeDate;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public FixtureStatusEnum getStatus() {
        return status;
    }

    public void setStatus(FixtureStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixtureDto that = (FixtureDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FixtureDto{" +
                "id=" + id +
                ", firstRegistrationId=" + firstRegistrationId +
                ", secondRegistrationId=" + secondRegistrationId +
                ", challengeDate" + challengeDate +
                ", matchId" + matchId +
                ", status" + status +
                '}';
    }
}
