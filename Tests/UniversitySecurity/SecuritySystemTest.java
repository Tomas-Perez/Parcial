package UniversitySecurity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class SecuritySystemTest extends AccessCard {
    SecuritySystem securitySystem = new SecuritySystem();
    Building buildingA = new Building();
    Building buildingB = new Building();
    Building buildingC = new Building();
    AccessCard securityGuardAccessCard = new AccessCard();
    SecurityGuard securityGuard = new SecurityGuard(securityGuardAccessCard);
    Class classA = new Class();
    Class classB = new Class();
    AccessCard studentAccessCard = new AccessCard();
    Student student = new Student(studentAccessCard);

    @Test
    public void addBuilding() throws Exception {
        assertTrue(securitySystem.getBuildingList().isEmpty());
        securitySystem.addBuilding(buildingA);
        assertFalse(securitySystem.getBuildingList().isEmpty());
    }

    @Test
    public void removeBuilding() throws Exception {
        assertTrue(securitySystem.getBuildingList().isEmpty());
        securitySystem.addBuilding(buildingA);
        assertFalse(securitySystem.getBuildingList().isEmpty());
        securitySystem.removeBuilding(buildingA);
        assertTrue(securitySystem.getBuildingList().isEmpty());
    }

    @Test
    public void activateCard() throws Exception {
        assertTrue(securitySystem.getAccessList().isEmpty());
        securitySystem.activateCard(securityGuardAccessCard, securityGuard);
        assertFalse(securitySystem.getAccessList().isEmpty());
    }

    @Test
    public void removeCard() throws Exception {
        assertTrue(securitySystem.getAccessList().isEmpty());
        securitySystem.activateCard(securityGuardAccessCard, securityGuard);
        assertFalse(securitySystem.getAccessList().isEmpty());
        securitySystem.removeCard(securityGuardAccessCard);
        assertTrue(securitySystem.getAccessList().isEmpty());
    }

    @Test
    public void removePerson() throws Exception {
        assertTrue(securitySystem.getAccessList().isEmpty());
        securitySystem.activateCard(securityGuardAccessCard, securityGuard);
        assertFalse(securitySystem.getAccessList().isEmpty());
        securitySystem.removePerson(securityGuard);
        assertTrue(securitySystem.getAccessList().isEmpty());
    }

    @Test
    public void hasAccess() throws Exception {
        securitySystem.addBuilding(buildingA);
        securitySystem.addBuilding(buildingB);
        buildingA.addClass(classA);
        classA.add(student);
        buildingB.addClass(classB);
        assertFalse(securitySystem.hasAccess(buildingA, studentAccessCard));
        securitySystem.activateCard(studentAccessCard, student);
        assertTrue(securitySystem.hasAccess(buildingA, studentAccessCard));
        assertFalse(securitySystem.hasAccess(buildingB, studentAccessCard));
        assertFalse(securitySystem.hasAccess(buildingB, securityGuardAccessCard));
        securitySystem.activateCard(securityGuardAccessCard, securityGuard);
        assertTrue(securitySystem.hasAccess(buildingB, securityGuardAccessCard));
    }

}