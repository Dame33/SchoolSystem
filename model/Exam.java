package model;

import model.Course;

public class Exam {

    //initialize variables
    String courseNum = "";

    String date = "";

    String time = "";

    String location = "";

    String exam_length = "";

    //initialize the course model that associates with an exam
    private Course course_name;

    /**
     * Constructs an Exam object with the specified course number, date, time, exam length,
     * and location.
     *
     * @param courseNum    The course number associated with the exam.
     * @param date         The date of the exam.
     * @param time         The time when the exam is scheduled.
     * @param exam_length  The duration of the exam.
     * @param location     The location where the exam will take place.
     */
    public Exam (String courseNum, String date, String time, String exam_length, String location) {
        courseNum = courseNum;
        date = date;
        time = time;
        location = location;
        exam_length = exam_length;
    }

    /**
     * Constructs an Exam object with the specified course number, date, time, exam length,
     * location, and course name.
     *
     * @param courseNum    The course number associated with the exam.
     * @param date         The date of the exam.
     * @param time         The time when the exam is scheduled.
     * @param exam_length  The duration of the exam.
     * @param location     The location where the exam will take place.
     * @param course_name  The Course object associated with the exam.
     */
    public Exam (String courseNum, String date, String time, String exam_length, String location, Course course_name) {
        courseNum = courseNum;
        date = date;
        time = time;
        location = location;
        course_name = course_name;
        exam_length = exam_length;
    }

    /**
     * getter method to get the course number of the exam
     * return type: String
     */
    public String getCourse(){
        return courseNum;
    }

    /**
     * getter method to get the date of the exam
     * return type: String
     */
    public String getDate(){
        return date;
    }

    /**
     * getter method to get the time of the exam
     * return type: String
     */
    public String getTime(){
        return time;
    }

    /**
     * getter method to get the time duration of the exam
     * return type: String
     */
    public String getExam_length(){
        return exam_length;
    }

    /**
     * getter method to get the location of the exam
     * return type: String
     */
    public String getLocation(){
        return location;
    }

    /**
     * getter method to get the course name of the exam
     * return type: course
     */
    public Course getCourse_name(){
        return course_name;
    }

    /**
     * setter method to set the course of the exam
     * @param course_num is the course_num that is being assigned
     * @return void
     */
    public void setCourse(String course_num){
        courseNum = course_num;
    }

    /**
     * setter method to set the exam date of the exam
     * @param date is the date that is being assigned
     * @return void
     */
    public void setDate(String date){
        date = date;
    }

    /**
     * setter method to set the exam time of the exam
     * @param time is the time that is being assigned
     * @return void
     */
    public void setTime(String time){
        time = time;
    }


    /**
     * setter method to set the exam length of the exam
     * @param exam_length is the exam_length that is being assigned
     * @return void
     */
    public void setExam_length(String exam_length){
        exam_length = exam_length;
    }


    /**
     * setter method to set the location of the exam
     * @param location is the location that is being assigned
     * @return void
     */
    public void setLocation(String location){
        location = location;
    }

    /**
     * A console print statement that prints the exam info
     * The expected format should be:
     * "For course: (course number) (course name)"
     * "Exam Date: (date)"
     * "Exam Time: (time)"
     * "Exam Length: (length)"
     * "Exam Location: (location)"
     */
    public void getExamInfo() {
        System.out.println("For course: " + courseNum + " "+course_name+":");

        System.out.println("Exam Date: " + date);

        System.out.println("Exam Time: " + time);

        System.out.println("Exam length: " + exam_length);

        System.out.println("Exam Location: " + location);
    }

    public boolean checkExamConflict(Exam exam1, Exam exam2) {
        if (exam1.date == exam2.date && exam1.time == exam2.time)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String changeExamTime(Exam exam, String time) {
        if (exam.time.equals(time)){
            String return_val = "Please enter a different time for the exam";
            return return_val;
        }
        else {
            exam.setTime(time);
            String return_success = "Exam time has been successfully updated";
            return return_success;
        }
    }

    public String changeExamDate(Exam exam, String date) {
        if (exam.date.equals(date)){
            String return_val = "Please enter a different date for the exam";
            return return_val;
        }
        else {
            exam.setDate(date);
            String return_success = "Exam date has been successfully updated";
            return return_success;
        }
    }


}