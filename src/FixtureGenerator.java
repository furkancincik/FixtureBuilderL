import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureGenerator {
    public static List<List<String>> generateFixtures(List<Team> teams) {
        //Takım sayısı tekse bay haftası olarak temsili takım.
        Team teamBay = new Team("Bay", 99);

        Collections.shuffle(teams);

        //Takım sayısını kontrol eedip bay geçilmesi için bay takımı ekledim.
        if (teams.size() % 2 != 0) {
            teams.add(teamBay);
        }

        List<List<String>> fixtures = new ArrayList<>();

        for (int week = 0; week < teams.size()-1; week++) {
            List<String> roundFixtures = new ArrayList<>();

            for (int i = 0; i < teams.size()/2; i++) {

                Team homeTeam = teams.get(i);
                Team awayTeam = teams.get(teams.size() - 1 - i);

                String homeTeamName = (homeTeam.getTeamID() == 99) ? "Bay" :   homeTeam.getTeamName();
                String awayTeamName = (homeTeam.getTeamID() == 99) ? "Bay" :   awayTeam.getTeamName();
                roundFixtures.add(homeTeamName + " vs " + awayTeamName);

            }
            fixtures.add(roundFixtures);

            Collections.rotate(teams.subList(1, teams.size()), 1);

        }

        return fixtures;
    }
}
