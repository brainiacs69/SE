
public class TrueAndFalse extends Game{
    public TrueAndFalse(){}

    public String getGameName() {
        return gameName;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getLevels() {
        return levels;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public double getRate() {
        return rate;
    }

    public TrueAndFalse(String gameName, String description, String difficulty, int levels, int numOfQuestions, double rate) {
        super(gameName, description, difficulty, levels, numOfQuestions, rate);
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
}
