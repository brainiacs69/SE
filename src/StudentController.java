import java.util.ArrayList;

public class StudentController extends Controller {

    public StudentController() {
        students = new ArrayList<>();
    }
    
    Student studentRegister() {
        User user = new User();
        user = this.register(user);
        Student student = new Student(user.userName, user.email, user.password, user.country, user.gender, user.mobileNumber);
        students.add(student);
        System.out.println("the add of student :"+students.get(students.size()-1).userName);
        return student;
    }
    
    //Variables
    static ArrayList <Student> students;
}
