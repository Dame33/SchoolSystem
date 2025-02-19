package model;

public class Course {
    char section;

    String title = "";

    int credit_amount;

    int course_code;

    int max_participants;

    String prereqs;

    String delivery;

    private Lab lab;

    public Course(char section, String title, int credit_amount, int course_code, int max_participants, String prereqs, String delivery) {
        this.section = section;

        this.title = title;

        this.credit_amount = credit_amount;

        this.course_code = course_code;

        this.max_participants = max_participants;

        this.prereqs = prereqs;

        this.delivery = delivery;
    }

    public Course(char section, String title, int credit_amount, int course_code, int max_participants, String prereqs, String delivery, Lab lab) {
        this.section = section;

        this.title = title;

        this.credit_amount = credit_amount;

        this.course_code = course_code;

        this.max_participants = max_participants;

        this.prereqs = prereqs;

        this.delivery = delivery;

        this.lab = lab;
    }


    public char getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public int getCreditAmount() {
        return credit_amount;
    }

    public int getCourseCode() {
        return course_code;
    }

    public int getMaxParticipants() {
        return max_participants;
    }

    public String getPrereqs() {
        return prereqs;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setSection(char section) {
        this.section = section;
    }
    public void setCreditAmount(int credit_amount) {
        this.credit_amount = credit_amount;
    }

    public void setCourseCode(int course_code) {
        this.course_code = course_code;
    }

    public void setMaxParticipants(int max_participants) {
        this.max_participants = max_participants;
    }

    public void setPrereqs(String prereqs) {
        this.prereqs = prereqs;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    /*
     * A console print statement that prints the course info
     * The expected format should be:
     * "Course code: (course code)"
     * "Course name: (title)"
     * "Section: (section)"
     * "Credit amount: (credit_amount)"
     * "Maximum number of participants: (max_participants)"
     * "Prerequisites: (prereqs)"
     * "Form of delivery: (delivery)"
     */
    public void getCourseInfo() {
        System.out.println("Course code: " + course_code);

        System.out.println("Course name: " + title);

        System.out.println("Section: " + section);

        System.out.println("Credit amount: " + credit_amount);

        System.out.println("Maximum number of participants: " + max_participants);

        System.out.println("Prerequisites: " + prereqs);

        System.out.println("Form of delivery: " + delivery);
    }

    public Course createNextSection() {
        return
                new Course(
                        (char) (section + 1),
                        title,
                        credit_amount,
                        course_code,
                        max_participants,
                        prereqs,
                        delivery
                );
    }

    public String hasSameLab(Course other) {
        String return_val = "";
        if (this.lab == null) {
            return_val = "There is no lab for course: " + this.title;
        }

        else if (other.lab == null) {
            return_val = "There is no lab for course: " + other.title;
        }
        else {
            if (this.lab.getLabNum() == other.lab.getLabNum() &&
                    this.lab.getLabTime().equals(other.lab.getLabTime())) {
                return_val = "These courses have conflicting labs. Please change one of them";
            }
        }
        return return_val;
    }
}