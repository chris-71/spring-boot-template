import com.example.ligan.model.Season;

public interface FotbollService {
    Season getSeasonById(Long id);
    Season getSeasonByYear(int year);
    void saveSeason(Season season);
    void updateSeason(Season season);
    void deleteSeason(Long id);

    void addTeam(Season season, Team team);
    void removeTeam(Season season, Team team);
    void addMatch(Season season, Match match);
    void removeMatch(Season season, Match match);
    
}