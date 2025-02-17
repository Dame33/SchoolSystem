package model;

public class OnlineSchool {
    int c0 = 0;
    int c1 = 0;

    Participant[] task4Array = new Participant[5];


    public Participant[] getParticipants(String classes)
    {
        int finalC = 0;
        int i = 0;
        int z = 0;
        for (;i < c0;)
        {
            int j = 0;
            while (j < task4Array[i].getRegistrations().length)
            {
                while (task4Array[i].getRegistrations()[j].getTitle().equals(classes))
                {
                    c1 ++;
                    break;
                }

                j++;
            }
            i++;
        }

        Participant[] finaltask4Array = new Participant[c1];
        while (z < c0)
        {
            int j = 0;
            while (j < task4Array[z].getRegistrations().length)
            {
                while (task4Array[z].getRegistrations()[j].getTitle().equals(classes))
                {
                    c1 = 0;
                    finaltask4Array[finalC] = task4Array[z];
                    finalC ++;

                    break;
                }
                j++;
            }
            z++;
        }
        return finaltask4Array;
    }


    public void addParticipant(Participant p) {

        while (c0 <= 4) {
            task4Array[c0] = p;
            c0 ++;
            break;
        }
    }

}