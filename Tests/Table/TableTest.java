package Table;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class TableTest {
    Table table = new Table();

    @Test
    public void add() throws Exception {
        assertTrue(table.getElements().isEmpty());
        table.add("1", "2", "auto");
        assertFalse(table.getElements().isEmpty());
    }

    @Test
    public void remove() throws Exception {
        table.add("1", "2", "auto");
        assertFalse(table.getElements().isEmpty());
        table.remove("1", "2");
        assertTrue(table.getElements().isEmpty());
    }

    @Test
    public void get() throws Exception {
        table.add("1", "2", "auto");
        assertTrue(table.get("1", "2").equals("auto"));
    }

    @Test
    public void size() throws Exception {
        table.add("1", "2", "auto");
        assertEquals(1, table.size());
        table.add("1", "2", "camion");
        assertEquals(1, table.size());
        table.add("1", "3", "camion");
        assertEquals(2, table.size());
    }

    @Test
    public void removeFromDimensionA() throws Exception {
        table.add("1", "2", "auto");
        table.add("1", "3", "camion");
        table.removeFromDimensionA("1");
        assertEquals(0, table.size());
    }

    @Test
    public void removeFromDimensionB() throws Exception {

    }

    @Test
    public void keysA() throws Exception {

    }

    @Test
    public void keysB() throws Exception {

    }

    @Test
    public void values() throws Exception {

    }

}