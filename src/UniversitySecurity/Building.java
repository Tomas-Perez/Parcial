package UniversitySecurity;

import java.util.ArrayList;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class Building {
    private ArrayList<Class> classList = new ArrayList<>();
    private ArrayList<Molinete> entrances = new ArrayList<>();
    private ArrayList<ProfessorRoom> professorRooms = new ArrayList<>();

    public ArrayList<Class> getClassList() {
        return classList;
    }

    public void addClass(Class classToAdd){
        if(!classList.contains(classToAdd))
            classList.add(classToAdd);
    }

    public void removeClass(Class classToRemove){
        if(classList.contains(classToRemove))
            classList.remove(classToRemove);
    }

    public void addMolinete(Molinete molinete){
        if(!entrances.contains(molinete))
            entrances.add(molinete);
    }

    public void removeMolinete(Molinete molinete){
        if(entrances.contains(molinete))
            entrances.remove(molinete);
    }

    public void addProfessorRoom(ProfessorRoom professorRoom){
        if(!professorRooms.contains(professorRoom))
            professorRooms.add(professorRoom);
    }

    public void removeProfessorRoom(ProfessorRoom professorRoom){
        if(professorRooms.remove(professorRoom))
            professorRooms.remove(professorRoom);
    }

    public boolean hasProfessorRoom(){
        return professorRooms.size() > 0;
    }
}
