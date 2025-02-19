package model;

public class Lab {
    int lab_num;

    String lab_time;

    String lab_duration;

    private Course course;

    public Lab(int lab_num, String title, String lab_time,  String lab_duration) {
        this.lab_num = lab_num;

        this.lab_time = lab_time;

        this.lab_duration = lab_duration;
    }

    public Lab(int lab_num, String title, String lab_time,  String lab_duration, Course course) {
        this.lab_num = lab_num;

        this.lab_time = lab_time;

        this.lab_duration = lab_duration;

        this.course = course;
    }

    /**
     * Gets the lab number.
     *
     * @return The lab number.
     */
    public int getLabNum() {
        return lab_num;
    }

    /**
     * Gets the lab time.
     *
     * @return The scheduled lab time.
     */
    public String getLabTime() {
        return lab_time;
    }

    /**
     * Gets the lab duration.
     *
     * @return The lab duration.
     */
    public String getLabDuration() {
        return lab_duration;
    }

    /**
     * Sets the lab number.
     *
     * @param lab_num The new lab number.
     */
    public void setLabNum(int lab_num) {
        this.lab_num = lab_num;
    }

    /**
     * Sets the scheduled lab time.
     *
     * @param lab_time The new lab time.
     */
    public void setLabTime(String lab_time) {
        this.lab_time = lab_time;
    }
    /**
     * Sets the lab duration.
     *
     * @param lab_duration The new lab duration.
     */
    public void setLabDuration(String lab_duration) {
        this.lab_duration = lab_duration;
    }

    public String changeLabTime(String newTime) {
        if (this.lab_time.equals(newTime)) {
            return "Please enter a different time for the lab.";
        }
        this.lab_time = newTime;
        return "Lab time successfully updated to: " + newTime;
    }

    public String changeLabNum(int newLabNum) {
        if (this.lab_num == newLabNum) {
            return "Please enter a different lab number.";
        }
        this.lab_num = newLabNum;
        return "Lab number successfully updated to: " + newLabNum;
    }
}