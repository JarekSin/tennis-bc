package com.projects.tennisbc.repositories.entities;

import com.projects.tennisbc.enums.FixtureStatusEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "fixtures")
public class FixtureEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(name = "firstregistrationid")
    private int firstRegistrationId;
    @Column(name = "secondregistrationid")
    private int secondRegistrationId;
    //    @ManyToOne(fetch = FetchType.LAZY)
//    private UserEntity userEntity;
    private Instant challengeDate;
    private int matchId;
    @Enumerated(EnumType.STRING)
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

    @Enumerated(EnumType.STRING)
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
        FixtureEntity entity = (FixtureEntity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FixtureEntity{" +
                "id=" + id +
                ", firstRegistrationId=" + firstRegistrationId +
                ", secondRegistrationId=" + secondRegistrationId +
                ", challengeDate" + challengeDate +
                ", matchId" + matchId +
                ", status" + status +
                '}';
    }
}
