package com.projects.tennisbc.repositories;

import com.projects.tennisbc.enums.FixtureStatusEnum;
import com.projects.tennisbc.repositories.entities.FixtureEntity;
import com.projects.tennisbc.services.dto.FixtureDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FixtureRepository extends JpaRepository<FixtureEntity, UUID> {
    List<FixtureEntity> getFixtureById(FixtureDto fixtureDto);
    List<FixtureEntity> getFixtureEntitiesByStatus(FixtureStatusEnum status);
}
