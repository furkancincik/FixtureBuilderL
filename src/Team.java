public class Team {
    private String teamName;
    private int teamID;

    public Team(String teamName,int teamID){
        this.teamName=teamName;
        this.teamID=teamID;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    

}
