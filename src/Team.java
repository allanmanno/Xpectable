import org.jetbrains.annotations.NotNull;

// Class for each team
class Team {

    // String variable for the teams name and abbreviation
    private String name;
    private static int point;
    private static int goalScored, goalAgainst, goalDifference;

    /**
     *  this constructor will take the name, points, and goals of each team
     * @param name name of the team
     * @param point how many point each team has (can only increase by 3 or 1)
     * @param goalScored how many goal each team has scored
     * @param goalAgainst how many goals each team has conceded
     */
    public Team(String name, int point,
                int goalScored, int goalAgainst){
        setName(name);
        Team.point = point;
        Team.goalScored = goalScored;
        Team.goalAgainst = goalAgainst;
    }

    // Name getter
    public String getName() {
        return name;
    }

    /**
     * this method set the name of the team, it also replaces the char - with a space.
     * @param name name of the team
     */
    public void setName(@NotNull String name) {
        if(name.contains("-")){
            this.name = name.replace("-"," ");
        }
        else {
            this.name = name;
        }
    }

    // Abbreviation getter
    public int getPoint() {
        return point;
    }

    // Method to display team name
    public void printTeam() {
        System.out.printf("| %-17s |   %d   |%n", getName(), getPoint());
    }


}