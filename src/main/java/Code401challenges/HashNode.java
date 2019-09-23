package Code401challenges;

public class HashNode {
    public String key;
    public String value;
    public HashNode next;

    public HashNode() {

    }

    public void setNext(HashNode node) { this.next = node; }
    public void setKey(String key) { this.key = key; }
    public void setValue(String value) { this.value = value; }

    public HashNode(String key, String value) {
        setKey(key);
        setValue(value);
    }
}
