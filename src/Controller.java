

import java.util.ArrayList;
import java.util.Scanner;

public class Controller{

    public Controller() {
        users = new ArrayList<>();
    }

    User register(User user) {
        String name, password, email, country, mobileNumber, gender;
        do { //name loop
            System.out.println("Enter username:");
            name = in.nextLine();
        } while (!checkUserName(name));

        do { //password loop
            System.out.println("Enter password:");
            password = in.next();
        } while (!checkPassword(password));

        do { //email loop
            System.out.println("Enter email:");
            email = in.next();
        } while (!checkEmail(email));
        System.out.println("Enter country:");
        country = in.next();
        System.out.println("Enter gender:");
        gender = in.next();
        System.out.println("Enter MobileNumber");
        mobileNumber = in.next();
        user = new User(name, email, password, country, gender, mobileNumber);
        users.add(user);
        return user;
    }

    boolean checkUserName(String name) {
        for (User user : users) {
            if (user.userName.equals(name)) {
                return false;
            }
        }
        return true;
    }

    boolean checkEmail(String email) {
        for (User user : users) {
            if (user.userName.equals(email)) {
                return false;
            }
        }
        return true;
    }

    boolean checkPassword(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    MCQGame getMCQGame(String gameName) {
        for (int i = 0; i < TeacherController.teachers.size(); i++) { //check MCQ games
            for (int j = 0; j < TeacherController.teachers.get(i).MCQGames.size(); j++) {
                if (gameName.equals(TeacherController.teachers.get(i).MCQGames.get(j).gameName)) {
                    return TeacherController.teachers.get(i).MCQGames.get(j);
                }
            }
        }
        return null;
    }

    TrueAndFalse getTrueAndFalseGame(String gameName) {
        for (int i = 0; i < TeacherController.teachers.size(); i++) { //check MCQ games
            for (int j = 0; j < TeacherController.teachers.get(i).trueFalseGames.size(); j++) {
                if (gameName.equals(TeacherController.teachers.get(i).trueFalseGames.get(j).gameName)) {
                    return TeacherController.teachers.get(i).trueFalseGames.get(j);
                }
            }
        }
        return null;
    }

    void playGame(String gameName, String userName) {
        if (getMCQGame(gameName) != null) {
            playMCQGame(getMCQGame(gameName), gameName, userName);
        } else if (getTrueAndFalseGame(gameName) != null) {
            playTrueFalseGame(getTrueAndFalseGame(gameName), gameName, userName);
        } else {
            System.out.println("this game does not exist!!");
        }
    }

    void playMCQGame(MCQGame game, String gameName, String userName) {
        int startLevel = 0;
        double score = 0;
        int answer = 0;
        if (checkPreviousPlaying(gameName, userName) != -1) {
            startLevel = game.playings.get(checkPreviousPlaying(gameName, userName)).playedlevels;
            score = game.playings.get(checkPreviousPlaying(gameName, userName)).score;
        }
        System.out.println("Score = "+score);
        System.out.println("your Level = "+startLevel);
        
        for (int i = startLevel; i < Game.levelsQuestions.size(); i++) {
         //   System.out.println("s = "+Game.levelsQuestions.size());
            for (int j = 0; j < Game.levelsQuestions.get(i).size(); j++) {
               // System.out.println("M = "+Game.levelsQuestions.get(i).size());
                System.out.println(Game.levelsQuestions.get(i).get(j).Question);
                for (int k = 0; k < Game.levelsQuestions.get(i).get(j).Answers.size(); k++) {
                    System.out.println("   " + (k + 1) + "- " + Game.levelsQuestions.get(i).get(j).Answers.get(k));
                }

                System.out.println("Enter your Answer:");
                answer = in.nextInt();
                if (Game.levelsQuestions.get(i).get(j).Answers.get(answer - 1).equals(Game.levelsQuestions.get(i).get(j).Answer)) {
                    System.out.println("Correct ;) ");
                    score++;
                } else {
                    System.out.println("false!! -_- ");
                }
            }
            game.playings.get(checkPreviousPlaying(gameName, userName)).playedlevels++;
            game.playings.get(checkPreviousPlaying(gameName, userName)).score = score;
        }

    }

    void playTrueFalseGame(TrueAndFalse game, String gameName, String userName) {
        int startLevel = 0;
        double score = 0;
        int answer = 0;
        if (checkPreviousPlaying(gameName, userName) != -1) {
            startLevel = game.playings.get(checkPreviousPlaying(gameName, userName)).playedlevels;
            score = game.playings.get(checkPreviousPlaying(gameName, userName)).score;
        }
        for (int i = startLevel; i < Game.levelsQuestions.size(); i++) {
            for (int j = 0; j < Game.levelsQuestions.get(i).size(); j++) {
                System.out.println(Game.levelsQuestions.get(i).get(j).Question);
                for (int k = 0; k < Game.levelsQuestions.get(i).get(j).Answers.size(); k++) {
                    System.out.println("   " + (k + 1 )+ "- " + Game.levelsQuestions.get(i).get(j).Answers.get(k));
                }

                System.out.println("Enter your Answer:");
                answer = in.nextByte();

                if (Game.levelsQuestions.get(i).get(j).Answers.get(answer - 1).equals(Game.levelsQuestions.get(i).get(j).Answer)) {
                    System.out.println("Correct ;) ");
                    score++;
                } else {
                    System.out.println("false!! -_- ");
                }
            }

        }
    }

    int checkPreviousPlaying(String gameName, String userName) {
        for (int i = 0; i < game.playings.size(); i++) {
            if (game.playings.get(i).gameName.equals(gameName) && game.playings.get(i).userName.equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    //Variables
    ArrayList<User> users;
    Scanner in = new Scanner(System.in);
    Game game = new Game();
}
