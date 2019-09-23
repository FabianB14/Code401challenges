package Code401challenges;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HashTableTest {
    HashTable testHash;

    @Before
    public void testInit() {
        testHash = new HashTable(15);
    }
    @Test public void testConstruct() {
        for(int i = 0; i < 14; i++) {
            assertNull(testHash.map[i]);
        }
    }

    @Test
    public void testLeftJoin() {
        HashTable hashTable2 = new HashTable(5);
        hashTable2.adding("0", "0-table1");
        hashTable2.adding("1", "1-table2");
        hashTable2.adding("2", "2-table2");
        hashTable2.adding("3", "3-table2");

        testHash.adding("0", "0-table1");
        testHash.adding("1", "1-table1");
        testHash.adding("3", "2-table1");
        ArrayList<String[]> testStringArrayList = testHash.leftJoin(hashTable2);
        String result = "";
        String expected = "[3, 2-table1, null]\n" + "[1, 1-table1, 1-table2]\n" + "[0, 0-table1, 0-table2]\n";
        for (String[] stringRow : testStringArrayList) {
            result += Arrays.toString(stringRow) + "\n";
        }
        assertEquals("these should return the same result", result, expected);
    }

    @Test
    public void testAddAndContains() {
        testHash.adding("0", "test");
        assertFalse(testHash.has("The key should be there"));
        assertTrue(testHash.has("0"));
    }

    @Test
    public void testGet() {
        testHash.adding("0", "test");
        assertEquals("test", testHash.get("0"), "test");
        testHash.adding("1", "test1");
        testHash.adding("2", "test2");
        testHash.adding("3", "test3");
        testHash.adding("4", "test4");
        assertEquals("test(n)", testHash.get("1"), "test1");
        assertEquals("test(n)", testHash.get("2"), "test2");
        assertEquals("test(n)", testHash.get("3"), "test3");
    }
}