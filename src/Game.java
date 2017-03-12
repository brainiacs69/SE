import java.util.ArrayList;


public class Game {
    
    
    //Variables
    String gameName; //association class "playing" ID
    String description, difficulty;
    static ArrayList <String> Category =  new ArrayList<>();
    int levels, numOfQuestions;
    double rate;
    static ArrayList<ArrayList <Q_A>> levelsQuestions = new ArrayList<>();
    ArrayList <Q_A> QAndA = new ArrayList<>();
    static ArrayList <Playing> playings = new ArrayList<>();
    public Game(String gameName, String description, String difficulty, int levels, int numOfQuestions, double rate) {
        this.gameName = gameName;
        this.description = description;
        this.levels = levels;
        this.numOfQuestions = numOfQuestions;
        this.rate = rate;
    }
    public Game(String name){
    	this.gameName = name;
    }
    public Game(){
        Category.add("Computer Science");
        Category.add("Math");
    }
    
}
