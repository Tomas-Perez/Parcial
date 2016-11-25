package Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class Table {
    ArrayList<TableElement> elements = new ArrayList<>();

    public void add(String keyDimensionA, String keyDimensionB, Object value){
        TableElement newTableElement = new TableElement(keyDimensionA, keyDimensionB, value);
        for (TableElement element: elements) {
            if(element.sameKey(newTableElement))
                return;
        }
        elements.add(newTableElement);
    }

    public void remove(String keyDimensionA, String keyDimensionB){
        for (TableElement element: elements) {
            if(element.getKeyA().equals(keyDimensionA) && element.getKeyB().equals(keyDimensionB))
                elements.remove(element);
                return;
        }
    }

    public Object get(String keyDimensionA, String keyDimensionB){
        for (TableElement element: elements) {
            if(element.getKeyA().equals(keyDimensionA) && element.getKeyB().equals(keyDimensionB))
                return element.getValue();
        }

        throw new RuntimeException();
    }

    public int size(){
        return elements.size();
    }

    public void removeFromDimensionA(String key){
        elements.stream().filter(element -> element.getKeyA().equals(key)).forEach(element -> elements.remove(element));
    }

    public void removeFromDimensionB(String key){
        for (TableElement element: elements) {
            if(element.getKeyB().equals(key))
                elements.remove(element);
        }
    }

    public ArrayList<String> keysA() {
        ArrayList<String> result = new ArrayList<>();
        for (TableElement element: elements) {
            result.add(element.getKeyA());
        }
        return result;
    }

    public ArrayList<String> keysB() {
        ArrayList<String> result = new ArrayList<>();
        for (TableElement element: elements) {
            result.add(element.getKeyB());
        }
        return result;
    }

    public ArrayList<Object> values() {
        ArrayList<Object> result = new ArrayList<>();
        for (TableElement element: elements) {
            result.add(element.getValue());
        }
        return result;
    }

    public ArrayList<TableElement> getElements() {
        return elements;
    }
}
