package UniversitySecurity;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class Molinete {
    private Building building;
    private SecuritySystem securitySystem;

    public Molinete(Building building, SecuritySystem securitySystem) {
        this.building = building;
        this.securitySystem = securitySystem;
    }

    public boolean validateCard(AccessCard card){
        return securitySystem.hasAccess(building, card);
    }
}
