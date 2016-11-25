package UniversitySecurity;

import java.util.ArrayList;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class Class {
    private ArrayList<Person> attendanceList = new ArrayList<>();

    public void add(Person person){
        if(!attendanceList.contains(person))
            attendanceList.add(person);
    }

    public void remove(Person person){
        if(attendanceList.contains(person))
            attendanceList.remove(person);
    }

    public boolean attendsClass(Person person){
        return attendanceList.contains(person);
    }
}
