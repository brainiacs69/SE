
public class Playing{
    
    
    //variables
  String userName, gameName;
  int playedlevels;
  double score;

    public Playing(String userName, String gameName, int playedlevels, double score) {
        this.userName = userName;
        this.gameName = gameName;
        this.playedlevels = playedlevels;
        this.score = score;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setPlayedlevels(int playedlevels) {
        this.playedlevels = playedlevels;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public String getGameName() {
        return gameName;
    }

    public int getPlayedlevels() {
        return playedlevels;
    }

    public double getScore() {
        return score;
    }
  
}
