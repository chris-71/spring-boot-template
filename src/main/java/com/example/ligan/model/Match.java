package com.example.ligan.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "match")
public class Match implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;

    @ManyToOne
    private Season season;

    private int homeGoal;
    private int awayGoal;

    public Match() {
    }

    private Match(MatchBuilder builder) {
        this.homeTeam = builder.homeTeam;
        this.awayTeam = builder.awayTeam;
        this.season = builder.season;
        this.homeGoal = builder.homeGoal;
        this.awayGoal = builder.awayGoal;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Season getSeason() {
        return season;
    }

    public int getHomeGoal() {
        return homeGoal;
    }

    public int getAwayGoal() {
        return awayGoal;
    }

    public static class MatchBuilder {
        private Team homeTeam;
        private Team awayTeam;
        private Season season;
        private int homeGoal;
        private int awayGoal;

            public MatchBuilder(Team homeTeam, Team awayTeam, Season season) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.season = season;
        }
        
        public MatchBuilder homeGoal(int homeGoal) {
            this.homeGoal = homeGoal;
            return this;
        }

        public MatchBuilder awayGoal(int awayGoal) {
            this.awayGoal = awayGoal;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}