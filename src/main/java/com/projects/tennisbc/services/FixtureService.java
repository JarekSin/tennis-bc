package com.projects.tennisbc.services;

import com.projects.tennisbc.builders.FixtureEntityBuilder;
import com.projects.tennisbc.enums.FixtureStatusEnum;
import com.projects.tennisbc.mappers.FixtureMapper;
import com.projects.tennisbc.repositories.FixtureRepository;
import com.projects.tennisbc.repositories.entities.FixtureEntity;
import com.projects.tennisbc.services.dto.FixtureDto;
import com.projects.tennisbc.validators.FixtureValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FixtureService {

    private FixtureRepository fixtureRepository;
    private FixtureMapper mapper;

    private FixtureValidator validator;
    private static final Logger LOGGER = LoggerFactory.getLogger(FixtureService.class.getName());

    public FixtureService(FixtureRepository fixtureRepository, FixtureMapper mapper, FixtureValidator validator) {
        this.fixtureRepository = fixtureRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public List<FixtureDto> getFixtureById(FixtureDto fixtureDto) {
        LOGGER.debug("Get all fixtures");
        return fixtureRepository.findAll().stream()
                .filter(entity -> entity.getId().equals(fixtureDto.getId()))
                .map(entity -> mapper.fromEntityToDto(entity))
                .collect(Collectors.toList());
    }

    public void setFixture(FixtureDto dto) {
        LOGGER.info("Set Fixture");
        validator.validate(dto);

        LOGGER.debug("FixtureDto: " + dto);
        FixtureEntity entity = mapper.fromDtoToEntity(dto);
        fixtureRepository.save(entity);
        LOGGER.info("Save Fixture");
    }

    public void deleteFixture(FixtureDto dto) {
        FixtureEntity entity = new FixtureEntityBuilder()
                .withId(dto.getId())
                .build();
        fixtureRepository.delete(entity);
    }

    public void updateFixture(FixtureDto dto) {
        Optional<FixtureEntity> entity = fixtureRepository.findById(dto.getId());
        entity.ifPresent(e -> {
            e.setSecondRegistrationId(dto.getSecondRegistrationId());
            fixtureRepository.saveAndFlush(e);
        });
    }

    public List<FixtureDto> getFixturesByStatus(FixtureStatusEnum status) {

        return fixtureRepository.getFixtureEntitiesByStatus(status).stream()
                .map(e -> mapper.fromEntityToDto(e))
                .collect(Collectors.toList());
    }


    // CodingBat
    public String repeatEnd(String str, int n) {
        String txt = str.substring(str.length() - n, str.length());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(txt);
        }
        return builder.toString();
    }

    public String starOut(String str) {
// ma*l***t**a
        char[] chars = str.toCharArray();
        char charStar = '*';
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (charStar == chars[i]) {
                System.out.println(chars[i]);
                builder.append(chars[i]);
            }
        }


        int firstIndex = str.indexOf("*");
        int lastIndex = str.lastIndexOf("*");

        String tempString = str.substring(0, firstIndex - 1);
        System.out.println(str.substring(0, firstIndex - 1));
        String tempSting2 = str.substring(lastIndex + 2, str.length());

        return tempString + tempSting2;
    }



}
