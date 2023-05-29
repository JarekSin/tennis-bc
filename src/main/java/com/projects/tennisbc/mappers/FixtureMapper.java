package com.projects.tennisbc.mappers;

import com.projects.tennisbc.builders.FixtureDtoBuilder;
import com.projects.tennisbc.builders.FixtureEntityBuilder;
import com.projects.tennisbc.repositories.entities.FixtureEntity;
import com.projects.tennisbc.services.dto.FixtureDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FixtureMapper {

    public FixtureEntity fromDtoToEntity(FixtureDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        FixtureEntityBuilder entityBuilder = new FixtureEntityBuilder();

        if (Objects.nonNull(dto.getId())) {
            entityBuilder.withId(dto.getId());
        }
        if (Objects.nonNull(dto.getFirstRegistrationId())) {
            entityBuilder.withFirstRegistrationId(dto.getFirstRegistrationId());
        }
        if (Objects.nonNull(dto.getSecondRegistrationId())) {
            entityBuilder.withSecondRegistrationId(dto.getSecondRegistrationId());
        }
        if (Objects.nonNull(dto.getChallengeDate())) {
            entityBuilder.withChallengeDate(dto.getChallengeDate());
        }
        if (Objects.nonNull(dto.getMatchId())) {
            entityBuilder.withMatchId(dto.getMatchId());
        }
        if (Objects.nonNull(dto.getStatus())) {
            entityBuilder.withStatus(dto.getStatus());
        }

        return entityBuilder.build();

    }

    public FixtureDto fromEntityToDto(FixtureEntity entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        FixtureDtoBuilder dto = new FixtureDtoBuilder();

        if (Objects.nonNull(entity.getId())) {
            dto.withId(entity.getId());
        }
        if (Objects.nonNull(entity.getFirstRegistrationId())) {
            dto.withFirstRegistrationId(entity.getFirstRegistrationId());
        }
        if (Objects.nonNull(entity.getSecondRegistrationId())) {
            dto.withSecondRegistrationId(entity.getSecondRegistrationId());
        }
        if (Objects.nonNull(entity.getChallengeDate())) {
            dto.withChallengeDate(entity.getChallengeDate());
        }
        if (Objects.nonNull(entity.getMatchId())) {
            dto.withMatchId(entity.getMatchId());
        }
        if (Objects.nonNull(entity.getStatus())) {
            dto.withStatus(entity.getStatus());
        }

        return dto.build();
    }

}
