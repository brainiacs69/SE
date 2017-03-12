
import java.util.ArrayList;

public class MCQGame extends Game {
    //variables
    int numOfChoises;
    String choices;

    public MCQGame(int numOfChoises, String choices, String gameName, String description, String difficulty, String category, int levels, int numOfQuestions, double rate) {
        super(gameName, description, difficulty, levels, numOfQuestions, rate);
        this.numOfChoises = numOfChoises;
        this.choices = choices;
        
    }
    public MCQGame(){}

    public void setNumOfChoises(int numOfChoises) {
        this.numOfChoises = numOfChoises;
    }

    public MCQGame(String gameName, String description, String difficulty, int levels, int numOfQuestions,
			double rate) {
		super(gameName, description, difficulty, levels, numOfQuestions, rate);
		// TODO Auto-generated constructor stub
	}
	public MCQGame(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void setChoices(String choices) {
        this.choices = choices;
    }

    public int getNumOfChoises() {
        return numOfChoises;
    }

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

    public String getChoices() {
        return choices;
    }
    
}
