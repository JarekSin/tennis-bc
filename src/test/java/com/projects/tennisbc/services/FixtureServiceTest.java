package com.projects.tennisbc.services;

import com.projects.tennisbc.builders.FixtureDtoBuilder;
import com.projects.tennisbc.builders.FixtureEntityBuilder;
import com.projects.tennisbc.enums.ValidatorFixtureEnum;
import com.projects.tennisbc.exceptions.FixtureInCompleteException;
import com.projects.tennisbc.mappers.FixtureMapper;
import com.projects.tennisbc.repositories.FixtureRepository;
import com.projects.tennisbc.repositories.entities.FixtureEntity;
import com.projects.tennisbc.services.dto.FixtureDto;
import com.projects.tennisbc.validators.FixtureValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FixtureServiceTest {

    @Mock
    private FixtureRepository fixtureRepository;

    private FixtureMapper mapper = new FixtureMapper();
    private FixtureService fixtureService;
    private FixtureDtoBuilder builder;

    private FixtureValidator validator = new FixtureValidator();
    UUID uuid = UUID.randomUUID();

    @BeforeEach
    public void init() {
        fixtureService = new FixtureService(fixtureRepository, mapper, validator);
        builder = new FixtureDtoBuilder();
//        validator = new FixtureValidator();
    }

    @Test
    void shouldReturnListOfFixtures() {

        //given:
        FixtureDto dto = builder.withFirstRegistrationId(1)
                .withId(uuid)
                .withSecondRegistrationId(10)
                .build();

        FixtureEntity entity = new FixtureEntityBuilder()
                .withId(uuid)
                .withFirstRegistrationId(1)
                .withSecondRegistrationId(10)
                .build();

        List<FixtureEntity> list = Collections.singletonList(entity);
        Mockito.when(fixtureRepository.findAll()).thenReturn(list);

        //when:
        List<FixtureDto> result = fixtureService.getFixtureById(dto);

        //then:
        org.assertj.core.api.Assertions.assertThat(result)
                .hasSize(1);
    }

    @Test
    void shouldVerifyIFTheRepositorySaveWasCalledOneTime() {
        //given
        Instant date = Instant.now();
        FixtureDto dto = new FixtureDtoBuilder()
                .withId(uuid)
                .withFirstRegistrationId(10)
                .withSecondRegistrationId(1)
                .withChallengeDate(date)
                .build();

        FixtureEntity entity = new FixtureEntityBuilder()
                .withId(uuid)
                .withFirstRegistrationId(10)
                .withSecondRegistrationId(1)
                .build();
        //when:
        fixtureService.setFixture(dto);

        //then:
        Mockito.verify(fixtureRepository, Mockito.times(1)).save(entity);
    }

    @Test
    void shouldThrowExceptionWhenMatchIsNull() {

        //given:
        Instant date = Instant.now();
        builder = new FixtureDtoBuilder();
        FixtureDto dto = builder
                .withMatchId(2)
                .build();
        FixtureDto dtoNull = new FixtureDto();

        //when:
        FixtureInCompleteException result = assertThrows(FixtureInCompleteException.class,
                () -> fixtureService.setFixture(dto));

        //then:
        assertEquals(ValidatorFixtureEnum.NO_CHALLENGE_DATE.getMessage(), result.getMessage());

    }

    @Test
    void shouldVerifyTheRepositoryUpdateFixtureForSecondRegistrationId() {
        //given:
        FixtureDto dto = new FixtureDtoBuilder()
                .withFirstRegistrationId(2)
                .withSecondRegistrationId(100)
                .build();
        FixtureEntity entity = new FixtureEntityBuilder()
                .withFirstRegistrationId(2)
                .withSecondRegistrationId(100)
                .build();

        Mockito.when(fixtureRepository.findById(any())).thenReturn(Optional.of(entity));

        //when:
        fixtureService.updateFixture(dto);

        //then:
        Mockito.verify(fixtureRepository, Mockito.times(1)).saveAndFlush(entity);

    }

    @Test
    void shouldThrowExceptionWhenChallengeDateIsNull() {
        //given:
        Instant date = Instant.now();
        FixtureDto dto = builder.withFirstRegistrationId(2)
                .withSecondRegistrationId(3)
//                .withChallengeDate(date)
                .build();
        //when:
        FixtureInCompleteException result = assertThrows(FixtureInCompleteException.class,
                () -> fixtureService.setFixture(dto));
        //then:
        assertEquals(ValidatorFixtureEnum.NO_CHALLENGE_DATE.getMessage(), result.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenChallengeDateAndMatchIsNull() {
        //given:
        String messageSeparator = "; ";
        String expectedMessage = ValidatorFixtureEnum.MATCH_IS_NULL.getMessage()
                + messageSeparator + ValidatorFixtureEnum.NO_CHALLENGE_DATE.getMessage();
        builder = new FixtureDtoBuilder();
        FixtureDto dto = builder
                .build();

        //when:
        FixtureInCompleteException result = assertThrows(FixtureInCompleteException.class,
                () -> fixtureService.setFixture(dto));

        //then:
        assertEquals(expectedMessage, result.getMessage());


    }

    @Test
    void testOneRepeatEnd() {
        //given:
        String txt = "Hello";
        int number = 2;

        //when:
        String resul = fixtureService.repeatEnd(txt, number);

        //then:
        assertEquals("lolo", resul);
    }

    @Test
    void testTwoStarOut() {
        //given:
        String txt = "ab****************cd";
        //when:

        String resul = fixtureService.starOut(txt);

        //then:
        assertEquals("ad", resul);
    }

}