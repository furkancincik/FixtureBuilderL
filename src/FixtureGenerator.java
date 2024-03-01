import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureGenerator {
    public static List<List<String>> generateFixtures(List<Team> teams) {
        //Takım sayısı tekse bay haftası olarak temsili takım.
        Team teamBay = new Team("Bay         ", 99);

        if (teams.size() % 2 != 0) {
            teams.add(teamBay);
        }

        List<List<String>> fixtures = new ArrayList<>(); // fixtures listesini oluştur

        if (teams.size() % 2 == 0) {
            int numberOfTeams = teams.size() - 1;

            for (int week = 0; week < numberOfTeams; week++) {
                List<String> roundFixtures = new ArrayList<>(); // roundFixtures her hafta yeniden oluşturulmalı

                for (int i = 0; i < teams.size() / 2; i++) {
                    Team homeTeam = teams.get(i);
                    Team awayTeam = teams.get(numberOfTeams - i);

                    String homeTeamName = (homeTeam.getTeamID() == 99) ? "Bay" : homeTeam.getTeamName();
                    String awayTeamName = (homeTeam.getTeamID() == 99) ? "Bay" : awayTeam.getTeamName();
                    roundFixtures.add(homeTeamName + " vs " + awayTeamName);
                }

                fixtures.add(roundFixtures);
                Collections.rotate(teams.subList(1, teams.size()), 1);
            }

            //6-10. haftalar yer degistirme islemi.

            for (int week = 5; week < numberOfTeams + 5; week++) {
                List<String> roundFixtures = new ArrayList<>(fixtures.get(numberOfTeams - week + 4));

                for (int i = 0; i < roundFixtures.size(); i++) {
                    String fixture = roundFixtures.get(i);
                    String[] teamsArray = fixture.split(" vs ");
                    roundFixtures.set(i, teamsArray[1] + " vs " + teamsArray[0]);//ev ve deplasman yeri degistirir
                }
                fixtures.add(roundFixtures);

            }
        }

        return fixtures;
    }
}
