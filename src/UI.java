
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class UI {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("enter 'S' to login as Student, or 'T' to login as Teacher: ");
        System.out.println("if not signed in, enter 'Sreg' to sign up as Student, or enter 'Treg' to sign up as Teacher: ");
        System.out.print("login type: ");
        kind = in.next();
        if (kind.equals("S")) {
            System.out.println("Enter username: ");
            student.userName = in.next();
            System.out.println("Enter Password: ");
            student.password = in.next();
            if (log_in(kind, student.userName, student.password) != -1) {
                System.out.println("welcome " + StudentController.students.get(log_in(kind, student.userName, student.password)).userName);
                System.out.println("Enter the name of the game you want to play :) : ");
                String str = in.next();
                controller.playGame(str, student.userName);
            }
        } else if (kind.equals("T")) {
            System.out.println("Enter username: ");
            teacher.userName = in.next();
            System.out.println("Enter Password: ");
            teacher.password = in.next();
            if (log_in(kind, teacher.userName, teacher.password) != -1) {
                System.out.println("welcome " + TeacherController.teachers.get(log_in(kind, teacher.userName, teacher.password)).userName);
                System.out.println("Enter 'add' to add a new game else enter the game name you want to try: ");
                String str = in.next();
                if (str.equals("add")) {
                    teacherController.AddGame(teacher);
                } else {
                    controller.playGame(str, teacher.userName);
                }
            }
        } else if (kind.equals("Treg")) {
            teacher = teacherController.teacherRegister();
            System.out.println("welcome " + teacher.userName);
            System.out.println("Enter 'add' to add a new game else enter the game name you want to try: ");
            String str = in.next();
            if (str.equals("add")) {
                teacherController.AddGame(teacher);
            } else {
                controller.playGame(str, teacher.userName);
            }
        } else if (kind.equals("Sreg")) {
            student = studentController.studentRegister();
            System.out.println("welcome " + student.userName);
            System.out.println("Enter the name of the game you want to play :) : ");
            String str = in.next();
            controller.playGame(str, student.userName);
        }
    }

    static int log_in(String kind, String user, String pass) {
        if (kind.equals("S")) {
            for (int i = 0; i < StudentController.students.size(); i++) {
                if (user.equals(StudentController.students.get(i).userName) && pass.equals(StudentController.students.get(i).password)) {
                    return i;
                }
            }
            return -1;
        } else if (kind.equals("T")) {
            for (int i = 0; i < TeacherController.teachers.size(); i++) {
                if (user.equals(TeacherController.teachers.get(i).userName) && pass.equals(TeacherController.teachers.get(i).password)) {
                    return i;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }
    //Variables
    static Scanner in = new Scanner(System.in);
    static Teacher teacher = new Teacher();
    static Student student = new Student();
    static Controller controller = new Controller();
    static StudentController studentController = new StudentController();
    static TeacherController teacherController = new TeacherController();
    static FileOutputStream outFile;
    static FileInputStream inFile;
    static ObjectOutputStream outObj;
    static ObjectInputStream inObj;
    static String kind;
}
