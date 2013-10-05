public class KeyType implements Comparable {

    private String value;

    public KeyType() { }
    public KeyType(String s) {
        this.value = s;  
    }
    public String getValue() { return this.value; }
    public void setValue(String s) { this.value = s; }
    public int compareTo(Object o) {
        KeyType k = (KeyType)o;
        int len = (this.value.length() < k.value.length()) 
            ? this.value.length() 
            : k.value.length();
        for (int i = 0; i < len; i++) {
            if (this.value.charAt(i) < k.value.charAt(i))
                return -1;
            else if (this.value.charAt(0) > k.value.charAt(0))
                return 1;
        }
        if (this.value.length() < k.value.length())
            return -1;
        else if (this.value.length() > k.value.length())
            return 1;
        else
            return 0;
    }
}

