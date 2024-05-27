package com.example.ligan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ligan.model.Season;
import com.example.ligan.model.Team;
import com.example.ligan.model.Match;
import com.example.ligan.service.FotbollService;


@RestController
@RequestMapping("/api")
public class FotbollController {

    private FotbollService fotbollService;

    @Autowired
    public FotbollController(FotbollService fotbollService) {
        this.fotbollService = fotbollService;
    }   

    @PostMapping("/season")
    public void createSeason(@RequestParam int year) {
        var season = new Season.SeasonBuilder(year).build();
        fotbollService.saveSeason(season);
    }

    @PostMapping("/team")
    public void createTeam(@RequestParam String teamName, @RequestParam Integer seasonYear) {
        fotbollService.addTeam(seasonYear, 
        new Team.TeamBuilder(teamName).build());
    }

/*    @PostMapping("/match")
    public void createMatch(@RequestParam String homeTeamName, @RequestParam String awayTeamName, @RequestParam Integer seasonYear, @RequestParam int homeGoal, @RequestParam int awayGoal) {
        var homeTeam = fotbollService.getTeamByName(homeTeamName);
        var awayTeam = fotbollService.getTeamByName(awayTeamName);
        var season = fotbollService.getSeasonByYear(seasonYear);

        var match = MatchBuilder
            .homeTeam(homeTeam)
            .awayTeam(awayTeam)
            .season(season)
            .homeGoal(homeGoal)
            .awayGoal(awayGoal)
            .build();
            
        fotbollService.addMatch(season, match);
    }    */
    
}