package com.example.ligan.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "team")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "teams")
    private List<Season> seasonList;

    public Team() {
    }

    // Constructor
    private Team(TeamBuilder builder) {
        this.name = builder.name;
        this.seasonList = builder.seasonList;
    }

    // Getters
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    // Builder class
    public static class TeamBuilder {
        private String name;
        private List<Season> seasonList;

        public TeamBuilder(String name) {
            this.name = name;
        }

        public TeamBuilder seasonList(List<Season> seasonList) {
            this.seasonList = seasonList;
            return this;
        }

        public Team build() {
            return new Team(this);
        }
    }
}