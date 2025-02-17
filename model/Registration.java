package model;
//import model.Instructor;
public class Registration {

    String personsTitle = "";
    int mark = 0;
    String[] newArray = {"F", "Failing"};
    String letterGrade = "F";
    String statement = "";
    String newName = "";
    int gpa = 0;

    private Instructor name;

    public Registration(String word) {
        personsTitle = word;
    }

    public Registration(String title, Instructor val) {
        personsTitle = title;
        name = val;
    }

    public String getTitle() {
        //String result = personsTitle;
        return personsTitle;
    }

    public int getMarks() {
        return mark;
    }

    public int get()
    {
        return gpa;
    }

    public String get1()
    {
        return letterGrade;
    }

    public Instructor getInstructor() {
        return name;
    }

    public String[] getGradeReport() {

        if (mark >= 0 && mark <= 49)
        {
            letterGrade = "F";
            statement = "Failing";
            gpa = 0;
        }

        else if (mark >= 50 && mark <= 59)
        {
            letterGrade = "D";
            statement = "Passing";
            gpa = 5;
        }
        else if (mark >= 60 && mark <= 69)
        {
            letterGrade = "C";
            statement = "Competent";
            gpa = 6;
        }

        else if (mark >= 70 && mark <= 79)
        {
            letterGrade = "B";
            statement = "Good";
            gpa = 7;
        }

        else if (mark >= 80 && mark <= 89)
        {
            letterGrade = "A";
            statement = "Excellent";
            gpa = 8;
        }

        else if (mark >= 90 && mark <= 100)
        {
            letterGrade = "A+";
            statement = "Exceptional";
            gpa = 9;
        }
        String[] newArray = {letterGrade, statement};

        return newArray;
    }

    public String getInformation() {


        if (name != null)
        {
            String sent = ""+personsTitle+", taught by "+name.get()+", is completed with raw marks "+mark+" ("+letterGrade+" ; "+statement+")";
            return sent;
        }
        else
        {
            String sent = ""+personsTitle+" has not yet been assigned an instructor";
            return sent;
        }

    }

    public void setInstructor(Instructor jackie) {
        name = jackie;
    }

    public void setMarks(int i) {
        mark = i;

    }

}

