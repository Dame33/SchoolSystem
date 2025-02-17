package model;

public class Participant {
    String Name = "";
    int val = 0;
    double average = 0;
    int gpa = 0;
    int x = -1;
    Registration [] simpArray = new Registration [0];
    Registration [] anotherArray = new Registration [5];
    Registration[] clearArray = new Registration [0];
    String sentence = "";

    public Participant(String name) {
        Name = name;
    }

    public Registration[] getRegistrations()
    {
        return simpArray;
    }

    public String getGPAReport() {
        gpa = 0;
        average = 0;

        if (simpArray.length == 0)
        {
            return "No GPA available yet for "+Name+"";
        }
        else {

            int i = 0;
            for (;i < simpArray.length;)
            {
                String[] studentGrade = simpArray[i].getGradeReport();
                int studentMarks = simpArray [i].getMarks();


                if (studentMarks <= 49)
                    gpa = 0;

                else if (studentMarks >= 50 && studentMarks <= 59)
                    gpa = 5;

                else if (studentMarks >= 60 && studentMarks <= 69)
                    gpa = 6;

                else if (studentMarks >= 70 && studentMarks <= 79)
                    gpa = 7;

                else if (studentMarks >= 80 && studentMarks <= 89)
                    gpa = 8;

                else if (studentMarks > 89)
                    gpa = 9;

                average += gpa;

                while (i == 0)
                {
                    sentence = ""+Name+"'s GPA of {"+gpa+" ("+studentGrade[0]+")";
                    break;
                }

                while (i > 0)
                {
                    sentence += ", " +gpa+" ("+studentGrade[0]+")";
                    break;
                }
                i++;
            }
            average = average / simpArray.length;
            String val = String.format("%.1f", average);

            sentence += "}: "+val+"";
            return sentence;
        }
    }

    public int marksOf(String string) {
        x = -1;
        if (simpArray.length == 0)
        {
            return x;
        }
        else if (simpArray != null)
        {
            int i = 0;
            while (i < simpArray.length)
            {
                if (simpArray[i].getTitle().equals(string))
                {
                    x = simpArray[i].getMarks();
                }
                i ++;
            }
        }
        return x;
    }
    public void updateMarks(String word, int j)
    {
        int i = 0;
        while (i < simpArray.length)
        {
            if (simpArray[i].getTitle().equals(word))
                simpArray[i].setMarks(j);
            i++;
        }
    }

    public void clearRegistrations() {
        val = 0;
        simpArray = clearArray;
    }

    public void addRegistration(Registration newClass)
    {
        while (val <= 4)
        {
            anotherArray[val] = newClass;
            val ++;
            simpArray = new Registration [val];
            break;
        }

        int i = 0;
        while (i < simpArray.length)
        {
            simpArray[i] = anotherArray [i];
            i ++;
        }

    }

    public void addRegistration(String anotherString)
    {
        Registration newInfo = new Registration (anotherString);
        while (val <= 4)
        {
            anotherArray[val] = newInfo;
            val ++;
            simpArray = new Registration [val];
            break;
        }

        int i = 0;
        while (i < simpArray.length)
        {
            simpArray[i] = anotherArray[i];
            i++;
        }

    }

}