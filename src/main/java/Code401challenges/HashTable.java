package Code401challenges;


import java.util.ArrayList;

public class HashTable {

    public HashNode[] map;

    public HashTable(int size) {
        map = new HashNode[size];
    }

    // hash()
    private int hash(String key) {
        int hashValue = 0;
        char[] letters = key.toCharArray();
        for( int i = 0; i<letters.length; i++) {
            hashValue += letters[i];
        }

        hashValue = (hashValue * 599) % map.length;
        return hashValue;
    }

    public boolean has(String key){
        int hashKey = hash(key);
        if(this.map[hashKey] != null){
            HashNode hashNode = this.map[hashKey];
            while(hashNode != null && !hashNode.key.equals(key)) {
                hashNode = hashNode.next;
            }
            return (hashNode == null ? false : true);
        }
        return false;
    }
    // set()
    public void adding(String key, String value){

        // set a var (int) of the hash(key)
        int hashKey = hash(key);
        if(this.has(key)) {
            System.out.println("No duplicate keys!");
            throw new IllegalArgumentException();
        }
        if( this.map[hashKey] == null ) {
            map[hashKey] = new HashNode(key, value);
        }
        else {
            HashNode temp = map[hashKey];
            map[hashKey] = new HashNode(key, value);
            map[hashKey].setNext(temp);
        }

    }

    // get()
    public String get(String key) {
        // hash the key (should give me the same thing)
        // if the hash table has that key, send back the value from the node.
        int  hashKey = hash(key);
        if(this.map[hashKey] != null ) {
            HashNode hashNode = this.map[hashKey];
            while(!hashNode.key.equals(key) && hashNode != null){
                hashNode = hashNode.next;
            }
            return (hashNode == null ? null : hashNode.value);
        }
        return null;
    }

    public ArrayList<String[]> leftJoin(HashTable hashTable){
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        for(int i = 0; i < this.map.length; i++) {
            String[] stringHash = new String[3];
            if (this.map[i] != null) {
                stringHash[0] = this.map[i].key;
                stringHash[1] = this.map[i].value;
                stringHash[2] = null;
                if(hashTable.has(this.map[i].key)) {
                    stringHash[2] = hashTable.get(this.map[i].key);
                }
                arrayList.add(stringHash);
            }
        }
        return arrayList;
    }
}
