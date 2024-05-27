package com.example.ligan.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "season")
public class Season implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int seasonYear;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "team_season",
        joinColumns = @JoinColumn(name = "season_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> teams;

    public Season() {
    }
    
    // Constructor
    private Season(SeasonBuilder builder) {
        this.seasonYear = builder.seasonYear;
        this.teams = builder.teams;
    }

    // Getters
    public int getSeasonYear() {
        return seasonYear;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }
    
    public static class SeasonBuilder {   
        private int seasonYear;
        private List<Team> teams;

        public SeasonBuilder(int seasonYear) {
            this.seasonYear = seasonYear;
        }

        public SeasonBuilder teams(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public Season build() {
            return new Season(this);
        }
    }
}