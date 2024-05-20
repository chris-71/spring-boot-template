package com.example.ligan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ligan.service.FotbollService;


@RestController
@RequestMapping("/api")
public class FotbollController {

    private FotbollService fotbollService;

    public FotbollController(FotbollService fotbollService) {
        this.fotbollService = fotbollService;
    }   

    @PostMapping("/season")
    public void createSeason(@RequestParam int year) {
        var season = Season.builder().with
            .year(year)
            .build();

        fotbollService.createSeason(season);
    }

    @PostMapping("/team")
    public void createTeam(@RequestParam String teamName, @RequestParam Integer seasonYear) {
        var team = Team.builder().name(teamName).build();
        var season = fotbollService.getSeasonByYear(seasonYear);
        fotbollService.addTeam(season, team);
    }

    @PostMapping("/match")
    public void createMatch(@RequestParam String homeTeamName, @RequestParam String awayTeamName, @RequestParam Integer seasonYear, @RequestParam int homeGoal, @RequestParam int awayGoal) {
        var homeTeam = fotbollService.getTeamByName(homeTeamName);
        var awayTeam = fotbollService.getTeamByName(awayTeamName);
        var season = fotbollService.getSeasonByYear(seasonYear);

        var match = Match.builder()
            .homeTeam(homeTeam)
            .awayTeam(awayTeam)
            .season(season)
            .homeGoal(homeGoal)
            .awayGoal(awayGoal)
            .build();
            
        fotbollService.addMatch(season, match);
    }    
    
}