package Table;

/**
 * Created by Tomas on 30-Sep-16.
 */
public class TableElement {
    private String keyA;
    private String keyB;
    private Object value;

    public TableElement(String keyA, String keyB, Object value) {
        this.keyA = keyA;
        this.keyB = keyB;
        this.value = value;
    }

    public String getKeyA() {
        return keyA;
    }

    public String getKeyB() {
        return keyB;
    }

    public Object getValue() {
        return value;
    }

    public boolean sameKey(TableElement tableElement){
        return keyA.equals(tableElement.getKeyA()) && keyB.equals(tableElement.getKeyB());
    }
}
