
import java.util.ArrayList;

public class TeacherController extends Controller{

    public TeacherController() {
        teachers = new ArrayList<>();
        MCQ = new MCQGame();
        TF = new TrueAndFalse();
    }

    Teacher teacherRegister() {
        User user = new User();
        user = this.register(teacher);
        System.out.println("Enter school name: ");
        String school = in.next();
        System.out.println("Enter teacher ID: ");
        int ID = in.nextInt();
        teacher = new Teacher(ID,school,user.userName, user.email, user.password, user.country, user.gender, user.mobileNumber);
        teachers.add(teacher);
        System.out.println("check the teacher add: "+teachers.get(teachers.size()-1).userName);
        return teacher;
    }
    
    int checkMCQGame (String name) {
        for(int i = 0; i < Teacher.MCQGames.size(); i++) {
            if(Teacher.MCQGames.get(i).gameName.equals(name))
                return 0;
        }
        return 1;
    }
    
    int checkTrueAndFalseGame (String name) {
        for(int i = 0; i < Teacher.trueFalseGames.size(); i++) {
            if(Teacher.trueFalseGames.get(i).gameName.equals(name))
                return 0;
        }
        return 1;
    }

    boolean AddGame(Teacher teacher) {
        System.out.println("1- " + Game.Category.get(0));
        System.out.println("2- " + Game.Category.get(1));
        System.out.println("Enter Category: ");
        int choice = in.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Enter 1 Or 2 !!");
            choice = in.nextInt();
        }
        System.out.println("Enter Game Type: (1- MCQ | 2- TrueAndFalse ");
        int type = in.nextInt();
        while (type != 1 && type != 2) {
            System.out.println("Enter 1 Or 2 !!");
            type = in.nextInt();
        }
        if (type == 1) {
            System.out.println("Enter game name: ");
            String str = in.next();
            while(checkMCQGame(str) != 1) {
                System.out.println("Enter another name this one is taken: ");
                str = in.next();
            }
            MCQ.gameName = str;
            System.out.println("Enter number of choices: ");
            MCQ.setNumOfChoises(in.nextInt());
            System.out.println("Enter game description: ");
            MCQ.description = in.next();
            System.out.println("Enter number of levels: ");
            MCQ.levels = in.nextInt();
            for (int k = 0; k < MCQ.levels; k++) {
                System.out.println("Enter Number of questions of level: " + (k + 1));
                MCQ.numOfQuestions = in.nextInt();
                for (int i = 0; i < MCQ.numOfQuestions; i++) {
                    Q_A QA = new Q_A();
                    System.out.println("Enter Question " + (i + 1) + ": ");
                    QA.Question = in.next();
                    for (int j = 0; j < MCQ.numOfChoises; j++) {
                        System.out.println("Enter Answer " + (j + 1) + ": ");
                        QA.Answers.add(in.next());
                    }
                    System.out.println("Enter The Answer");
                    QA.Answer = in.next();
                    MCQ.QAndA.add(QA);
                }
                MCQ.levelsQuestions.add(MCQ.QAndA);
            }
            teacher.MCQGames.add(MCQ);
            return true;
        } else {
            System.out.println("Enter game name: ");
            String str = in.next();
            while(checkTrueAndFalseGame(str) != 1) {
                System.out.println("Enter another name this one is taken: ");
                str = in.next();
            }
            TF.gameName = str;
            System.out.println("Enter number of levels: ");
            TF.levels = in.nextInt();
            System.out.println("Enter game description: ");
            TF.description = in.next();
            for (int k = 0; k < TF.levels; k++) {
                System.out.println("Enter Number of questions of level: " + (k + 1));
                TF.numOfQuestions = in.nextInt();
                for (int i = 0; i < TF.numOfQuestions; i++) {
                    Q_A QA = new Q_A();
                    System.out.println("Enter Question" + (i + 1));
                    QA.Question = in.next();
                    QA.Answers.add("True");
                    QA.Answers.add("False");
                    TF.QAndA.add(QA);
                }
                TF.levelsQuestions.add(TF.QAndA);
            }
            teacher.trueFalseGames.add(TF);
            return true;
        }
    }
    
    //Variables
    static ArrayList<Teacher> teachers;
    Teacher teacher;
    static MCQGame MCQ = new MCQGame();
    static TrueAndFalse TF = new TrueAndFalse();
}
