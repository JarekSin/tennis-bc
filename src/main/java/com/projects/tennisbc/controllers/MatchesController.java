package com.projects.tennisbc.controllers;

import com.projects.tennisbc.model.Fixture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchesController {

    @GetMapping
    public List<Fixture> getAllMatches() {
        return List.of("Match 1", "Match 2");
    }
}
