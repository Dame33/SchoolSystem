package model;

public class Instructor  {

    String name = "";
    int EN = 0;
    String Email = "";

    public Instructor(String N, int P, String E) {
        name = N;
        EN = P;
        Email = E;
    }

    public String getName() {
        //String result = name;
        return name;
    }

    public int getPhoneExtension() {
        int result = EN;
        return result;
    }


    public String getEmail() {
        String result = Email;
        return result;
    }


    public String getInformation() {
        String result = "Instructor "+name+" has campus phone extension "+EN+" and contact email "+Email+"";
        return result;
    }


    public void setName(String newName) {
        name = newName;
    }


    public void setPhoneExtension(int newExtension) {
        EN = newExtension;
    }


    public void setEmail(String newEmail) {
        Email = newEmail;
    }


    public String get() {
        return name;
    }



}