package com.example.ligan.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ligan.model.Season;
import com.example.ligan.model.Team;
import com.example.ligan.model.Match;
import com.example.ligan.repository.SeasonRepository;

@Service
public class FotbollServiceImpl implements FotbollService {

    private SeasonRepository seasonRepository;

    @Autowired
    public FotbollServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public Season getSeasonByYear(int seasonYear) {
        Season season = seasonRepository.findBySeasonYear(seasonYear);
        return season;
    }

    @Override
    public void saveSeason(Season season) {
        if(seasonRepository.findBySeasonYear(season.getSeasonYear()) != null) {
            return;
        } else {
            seasonRepository.save(season);
        }
    }

    @Override
    public void updateSeason(Season season) {
        seasonRepository.save(season);
    }

    @Override
    public void deleteSeason(int seasonYear) {
        if(seasonRepository.findBySeasonYear(seasonYear) != null) {
            var storedSeason = seasonRepository.findBySeasonYear(seasonYear);
            seasonRepository.delete(storedSeason);
        } else {
            return;
        }
    }
    
    @Override
    public void addTeam(Season season, Team team) {
        season.addTeam(team);
        seasonRepository.save(season);
    }

    @Override
    public void addTeam(int seasonYear, Team team) {
        if (seasonRepository.findBySeasonYear(seasonYear) != null) {
            var season = seasonRepository.findBySeasonYear(seasonYear);
            season.addTeam(team);
            seasonRepository.save(season);
        } else {
            try {
                throw new Exception("Season not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeTeam(Season season, Team team) {
        if (seasonRepository.findBySeasonYear(season.getSeasonYear()) != null) {
            var storedSeason = seasonRepository.findBySeasonYear(season.getSeasonYear());
            seasonRepository.findAllSeasonWhereTeamsContainsTeamId(team.getId());
            storedSeason.getTeams().remove(team);
            seasonRepository.save(storedSeason);
        } else {
            try {
                throw new Exception("Season not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        // Implement the logic to remove a team from a season
        // ...
    }

    @Override
    public void removeTeam(int seasonYear, Team team) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTeam'");
    }



    @Override
    public void addMatch(Season season, Match match) {
        // Implement the logic to add a match to a season
        // ...
    }   

    @Override
    public void addMatch(int seasonYear, Match match) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMatch'");
    }


    @Override
    public void removeMatch(Season season, Match match) {
        // Implement the logic to remove a match from a season
        // ...
    }

    
    @Override
    public void removeMatch(int seasonYear, Match match) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMatch'");
    }   
}