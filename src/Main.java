import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Team> teams = new ArrayList<>();

        Team team1 = new Team("Galatasaray ", 1);
        Team team2 = new Team("Bursaspor   ", 2);
        Team team3 = new Team("Fenerbahçe  ", 3);
        Team team4 = new Team("Beşiktaş    ", 4);
        Team team5 = new Team("Başakşehir  ", 5);
        Team team6 = new Team("Trabzonspor ", 6);
        Team team7 = new Team("Boluspor    ", 7);


        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
        teams.add(team5);
        teams.add(team6);
        teams.add(team7);


        //fikstür oluşturuldu.
        List<List<String>> fixtures = FixtureGenerator.generateFixtures(teams);

        //fikstür yazdırılıyor.
        for (int i = 0; i < fixtures.size(); i++) {
            System.out.println("Hafta " + (i + 1) + " Maçları :");
            System.out.println("----------------------------------------------");
            List<String> roundFixtures = fixtures.get(i);
            for (String f : roundFixtures) {
                System.out.println(f);
            }
            System.out.println();
        }




    }
}