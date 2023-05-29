package com.projects.tennisbc.controllers;

import com.projects.tennisbc.enums.FixtureStatusEnum;
import com.projects.tennisbc.services.FixtureService;
import com.projects.tennisbc.services.dto.FixtureDto;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/fixtures")
public class FixtureController {

    private FixtureService fixtureService;

    public FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    @GetMapping
    public List<FixtureDto> getFixtureById(@RequestBody FixtureDto dto) {
        return fixtureService.getFixtureById(dto);
    }

    @PostMapping
    public void setFixture(@RequestBody FixtureDto dto) {
        fixtureService.setFixture(dto);
    }

    @DeleteMapping
    public void deleteFixture(@RequestBody FixtureDto dto) {
        fixtureService.deleteFixture(dto);
    }

    @PutMapping
    public void updateFixture(@RequestBody FixtureDto dto) {
        fixtureService.updateFixture(dto);
    }

    @GetMapping("/find")
    public List<FixtureDto> getFixturesByStatus(@PathParam("status") String status) {
        return fixtureService.getFixturesByStatus(FixtureStatusEnum.valueOf(status.toUpperCase()));
    }

}
