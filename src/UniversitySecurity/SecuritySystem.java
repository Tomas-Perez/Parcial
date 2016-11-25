package UniversitySecurity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class SecuritySystem {
    private ArrayList<Building> buildingList = new ArrayList<>();
    private HashMap<AccessCard, Person> accessList = new HashMap<>();

    public void addBuilding(Building building){
        if(!buildingList.contains(building))
            buildingList.add(building);
    }

    public void removeBuilding(Building building){
        if(buildingList.contains(building))
            buildingList.remove(building);
    }

    public void activateCard(AccessCard accessCard, Person person){
        accessList.putIfAbsent(accessCard, person);
    }

    public void removeCard(AccessCard accessCard){
        if(accessList.containsKey(accessCard))
            accessList.remove(accessCard);
    }

    public void removePerson(Person person){
        if(accessList.containsValue(person))
            accessList.remove(person.getAccessCard());
    }

    public boolean hasAccess(Building building, AccessCard accessCard){
        if(accessList.containsKey(accessCard)) {
            if (accessList.get(accessCard) instanceof SecurityGuard)
                return true;
            if (accessList.get(accessCard) instanceof Professor)
                return building.hasProfessorRoom();
            if (buildingList.contains(building)) {
                Person cardOwner = accessList.get(accessCard);
                ArrayList<Class> buildingClasses = building.getClassList();
                for (Class classInBuilding : buildingClasses) {
                    if (classInBuilding.attendsClass(cardOwner))
                        return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Building> getBuildingList() {
        return buildingList;
    }

    public HashMap<AccessCard, Person> getAccessList() {
        return accessList;
    }
}
