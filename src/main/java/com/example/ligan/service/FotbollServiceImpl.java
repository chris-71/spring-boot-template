@Service
public class FotbollServiceImpl implements FotbollService {

    private SeasonRepository seasonRepository;

    public FotbollServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public Season getSeasonById(Long id) {
        // Implement the logic to get a season by its ID
        // ...
    }

    @Override
    public Season getSeasonByYear(int year) {
        // Implement the logic to get a season by its year
        // ...
    }

    @Override
    public void saveSeason(Season season) {
        // Implement the logic to save a season
        // ...
    }

    @Override
    public void updateSeason(Season season) {
        // Implement the logic to update a season
        // ...
    }

    @Override
    public void deleteSeason(Long id) {
        // Implement the logic to delete a season by its ID
        // ...
    }
    
    @Override
    public void addTeam(Season season, Team team) {
        // Implement the logic to add a team to a season
        // ...
    }

    @Override
    public void removeTeam(Season season, Team team) {
        // Implement the logic to remove a team from a season
        // ...
    }

    @Override
    public void addMatch(Season season, Match match) {
        // Implement the logic to add a match to a season
        // ...
    }   

    @Override
    public void removeMatch(Season season, Match match) {
        // Implement the logic to remove a match from a season
        // ...
    }   

}