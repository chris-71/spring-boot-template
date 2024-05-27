package com.example.ligan.service;

import com.example.ligan.model.Season;
import com.example.ligan.model.Team;
import com.example.ligan.model.Match;

public interface FotbollService {
    
    Season getSeasonByYear(int seasonYear);
    void saveSeason(Season season);
    void updateSeason(Season season);
    void deleteSeason(int seasonYear);

    void addTeam(Season season, Team team);
    void addTeam(int seasonYear, Team team);

    void removeTeam(Season season, Team team);
    void removeTeam(int seasonYear, Team team);

    void addMatch(Season season, Match match);
    void addMatch(int seasonYear, Match match);

    void removeMatch(Season season, Match match);
    void removeMatch(int seasonYear, Match match);
    
}