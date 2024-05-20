import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class Match implements Serializable {
    private Team homeTeam;
    private Team awayTeam;
    private Season season;
    private int homeGoal;
    private int awayGoal;

    @Entity
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

        private Match(Builder builder) {
            this.homeTeam = builder.homeTeam;
            this.awayTeam = builder.awayTeam;
            this.season = builder.season;
            this.homeGoal = builder.homeGoal;
            this.awayGoal = builder.awayGoal;
        }

        public static Builder builder() {
            return new Builder();
        }

        // Getters and setters
        public Long getId() {
            return id;
        }

        public Team getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(Team homeTeam) {
            this.homeTeam = homeTeam;
        }

        public Team getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(Team awayTeam) {
            this.awayTeam = awayTeam;
        }

        public Season getSeason() {
            return season;
        }

        public void setSeason(Season season) {
            this.season = season;
        }

        public int getHomeGoal() {
            return homeGoal;
        }

        public void setHomeGoal(int homeGoal) {
            this.homeGoal = homeGoal;
        }

        public int getAwayGoal() {
            return awayGoal;
        }

        public void setAwayGoal(int awayGoal) {
            this.awayGoal = awayGoal;
        }

        public static class Builder {
            private Team homeTeam;
            private Team awayTeam;
            private Season season;
            private int homeGoal;
            private int awayGoal;

            private Builder() {
            }

            public Builder homeTeam(Team homeTeam) {
                this.homeTeam = homeTeam;
                return this;
            }

            public Builder awayTeam(Team awayTeam) {
                this.awayTeam = awayTeam;
                return this;
            }

            public Builder season(Season season) {
                this.season = season;
                return this;
            }

            public Builder homeGoal(int homeGoal) {
                this.homeGoal = homeGoal;
                return this;
            }

            public Builder awayGoal(int awayGoal) {
                this.awayGoal = awayGoal;
                return this;
            }

            public Match build() {
                return new Match(this);
            }
        }
    }
    private Match(Builder builder) {
        this.homeTeam = builder.homeTeam;
        this.awayTeam = builder.awayTeam;
        this.season = builder.season;
        this.homeGoal = builder.homeGoal;
        this.awayGoal = builder.awayGoal;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters and setters

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(int homeGoal) {
        this.homeGoal = homeGoal;
    }

    public int getAwayGoal() {
        return awayGoal;
    }

    public void setAwayGoal(int awayGoal) {
        this.awayGoal = awayGoal;
    }

    public static class Builder {
        private Team homeTeam;
        private Team awayTeam;
        private Season season;
        private int homeGoal;
        private int awayGoal;

        private Builder() {
        }

        public Builder homeTeam(Team homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public Builder awayTeam(Team awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }

        public Builder season(Season season) {
            this.season = season;
            return this;
        }

        public Builder homeGoal(int homeGoal) {
            this.homeGoal = homeGoal;
            return this;
        }

        public Builder awayGoal(int awayGoal) {
            this.awayGoal = awayGoal;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}