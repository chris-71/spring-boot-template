import java.io.Serializable;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "season")
public class Season implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private List<Team> teams;

    // Constructor
    private Season(Builder builder) {
        this.year = builder.year;
        this.teams = builder.teams;
    }

    public static Builder() {
        return new Builder();
    }

    // Getters and Setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    
    public static class Builder {   
        private int year;
        private List<Team> teams;

        public Builder() {  
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder teams(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public Season build() {
            return new Season(this);
        }
    }
}