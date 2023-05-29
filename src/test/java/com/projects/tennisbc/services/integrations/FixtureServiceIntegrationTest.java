package com.projects.tennisbc.services.integrations;

import com.projects.tennisbc.builders.FixtureDtoBuilder;
import com.projects.tennisbc.builders.FixtureEntityBuilder;
import com.projects.tennisbc.enums.FixtureStatusEnum;
import com.projects.tennisbc.repositories.FixtureRepository;
import com.projects.tennisbc.repositories.entities.FixtureEntity;
import com.projects.tennisbc.services.FixtureService;
import com.projects.tennisbc.services.dto.FixtureDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest
@Transactional
public class FixtureServiceIntegrationTest {

    @Autowired
    private FixtureService service;
    @Autowired
    private FixtureRepository repository;


    // TODO
    // Test nie przechodzi, service do poprawki, id
//    @Test
//    void shouldReturnListWithTreeElements() {
//        //given:
//        FixtureDto dto = new FixtureDtoBuilder()
//                .withFirstRegistrationId(1)
//                        .build();
//        initDataBase();
//        //when:
//        List<FixtureDto> allFixturesInDB = service.getFixtureById(dto);
//        //then:
//        org.assertj.core.api.Assertions.assertThat(allFixturesInDB)
//                .hasSize(3);
//    }
//
//    private void initDataBase() {
//        FixtureEntity entity1 = new FixtureEntityBuilder()
//                .withFirstRegistrationId(1)
//                .withSecondRegistrationId(2)
//                .withChallengeDate(Instant.now())
//                .withMatchId(1)
//                .withStatus(FixtureStatusEnum.SCHEDULING_THE_MATCH)
//                .build();
//
//        FixtureEntity entity2 = new FixtureEntityBuilder()
//                .withFirstRegistrationId(1)
//                .withSecondRegistrationId(3)
//                .withChallengeDate(Instant.now())
//                .withMatchId(2)
//                .withStatus(FixtureStatusEnum.MATCH_DATE_IS_SET)
//                .build();
//
//        FixtureEntity entity3 = new FixtureEntityBuilder()
//                .withFirstRegistrationId(1)
//                .withSecondRegistrationId(4)
//                .withChallengeDate(Instant.now())
//                .withMatchId(3)
//                .withStatus(FixtureStatusEnum.SCHEDULING_THE_MATCH)
//                .build();
//
//        repository.saveAll(asList(entity1,entity2, entity3));
//    }

    @Test
    void shouldAddFixtureToDB() {
        //given:

        FixtureDto dto = new FixtureDtoBuilder()
                .withFirstRegistrationId(1)
                .withSecondRegistrationId(2)
                .withChallengeDate(Instant.now())
                .withMatchId(1)
                .withStatus(FixtureStatusEnum.SCHEDULING_THE_MATCH)
                .build();

        //when:
        service.setFixture(dto);
        //then:
        List<FixtureEntity> allFixtures = repository.findAll();
        org.assertj.core.api.Assertions.assertThat(allFixtures)
                .hasSize(1);
    }

    @Test
    void shouldReturnListOnlyWithOneStatus() {
        //given:
        FixtureEntity entity = new FixtureEntityBuilder()
                .withFirstRegistrationId(1)
                .withSecondRegistrationId(2)
                .withChallengeDate(Instant.now())
                .withMatchId(1)
                .withStatus(FixtureStatusEnum.SCHEDULING_THE_MATCH)
                .build();
        repository.save(entity);

        FixtureStatusEnum status = FixtureStatusEnum.SCHEDULING_THE_MATCH;
        //when:
        List<FixtureDto> fixturesByStatus = service.getFixturesByStatus(status);
        //then:
        org.assertj.core.api.Assertions.assertThat(fixturesByStatus)
                .hasSize(1);

    }

}
