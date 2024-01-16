import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class XpectableMain {


    public static void main(String[] args) throws FileNotFoundException {
        System.out.printf("-----------------------------%n");
        System.out.printf("   Premier League Standing %n");
        System.out.printf("-----------------------------%n");
        System.out.printf("| %-17s | %-5s |%n", "TEAM","POINT");
        System.out.printf("-----------------------------%n");
        runTeam();
        System.out.printf("-----------------------------%n");

    }

    /**
     * runTeam will run the class team
     */
    static void runTeam() throws FileNotFoundException {

        File inputFile = new File("PremierLeagueTeams.txt");
        // Scanner to get the teams name and abbreviation
        Scanner teamScanner = new Scanner(inputFile);

        while (teamScanner.hasNext()) {
            String teamName = teamScanner.next();
            int teamPoint = teamScanner.nextInt();
            int teamGoalScored = teamScanner.nextInt();
            int teamGoalAgainst = teamScanner.nextInt();
            Team myTeam = new Team(teamName, teamPoint, teamGoalScored, teamGoalAgainst);
            myTeam.printTeam();
        }
    }
}
