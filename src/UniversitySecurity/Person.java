package UniversitySecurity;

/**
 * Created by Tomas on 30-Sep-16.
 */
public abstract class Person {
    private AccessCard accessCard;

    public Person(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public boolean EnterBuilding(Molinete molinete){
        return molinete.validateCard(accessCard);
    }
}
