public class KeyType implements Comparable {

    private String value;

    public KeyType() { }
    public KeyType(String s) { this.value = s; }
    public String getValue() { return this.value; }
    public void setValue(String s) { this.value = s; }
    public int compareTo(Object o) {
        return this.value.compareTo(((KeyType)o).value);
    }
}

