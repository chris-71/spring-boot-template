import java.io.Serializable;
import java.util.List;
import java.io.Serializable;
import java.util.List;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
    public class Team implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @OneToMany(mappedBy = "team")
        private List<Season> seasonList;

    // Constructor
    private Team(Builder builder) {
        this.name = builder.name;
        this.seasonList = builder.seasonList;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public List<Season> getSeasonList() {
        return season;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.season = season;
    }

    public void addSeason(Season season) {
        this.seasonList.add(season);
    }

    // Builder class
    public static class Builder {
        private String name;
        private List<Season> seasonList;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder seasonList(List<Season> seasonList) {
            this.season = season;
            return this;
        }

        public Team build() {
            return new Team(name, season);
        }
    }
}