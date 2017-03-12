import java.util.ArrayList;

public class Teacher extends User{

    public Teacher(String userName, String email, String password, String country, String gender, String mobileNumber) {
		super(userName, email, password, country, gender, mobileNumber);
		// TODO Auto-generated constructor stub
	}



	public Teacher(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}



	public Teacher() {}
    
    //Variables
    static ArrayList <MCQGame> MCQGames = new ArrayList<>();
    static ArrayList <TrueAndFalse> trueFalseGames = new ArrayList<>();
    int ID;
    String school;


    public Teacher(int ID, String school, String userName, String email, String password, String country, String gender, String mobileNumber) {
        super(userName, email, password, country, gender, mobileNumber);
        this.ID = ID;
        this.school = school;
    }

   

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public int getID() {
        return ID;
    }

    public String getSchool() {
        return school;
    }
    
}