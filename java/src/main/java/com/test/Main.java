package com.test;
// The Time Traveling Hash Table
// =============================
// 
// When dealing with a normal hash table, if you query a key before it has been set,
// you'll get nothing back, and when querying a key after it has been set, you'll get
// that value back. If you set the value again and then get it again, you'll get the
// new value and not the old value.
//
// The Time Traveling Hash Table works the same way, except you can also set the time
// you wish to query from. So if you set a value at 10AM, 11AM, and 12:30PM, you can then
// specify that you want to query at 9:45AM and get nothing, 10AM and get the first value
// that was set, 11:15AM and get the second value set, 12:29PM and still get the second value
// set, and 1PM and get the third value set.
//
// Below is a TimeTravelingHashTable prototype and a test suite using it. Please fill in the
// implementation for the three methods, `set(K, V, double)`, `get(K)`, and `get(K, double)` to pass the test.
//
// The `key` is a string, the `val` can be anything, and the `time` is a floating point number.
//
// NOTE: PERFORMANCE DOES NOT MATTER
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

import static org.junit.Assert.*;

class TimeTravelingHashTable<K, V> {
    public void set(K key, V val, double time) {
        
    }
    
    public V get(K key) {
        return null;
    }
    
    public V get(K key, double time) {
        return null;
    }
}

public class Main {
    public static TimeTravelingHashTable<String, String> ttht;
    public static void main(String[] args) {
        ttht = new TimeTravelingHashTable<String, String>();
        test1SetValues();
        test2GetLatestValues();
        test3GetSpecificTimeValues();
    }
    public static void test1SetValues() {
        ttht.set("foo", "A", 0.0);
        ttht.set("foo", "B", 1.0);
        ttht.set("foo", "C", 2.0);
        
        ttht.set("bar", "Z", 3.0);
        ttht.set("bar", "Y", 1.5);
        ttht.set("bar", "X", -1.5);
    }
        
    public static void test2GetLatestValues() {
        assertEquals(ttht.get("foo"), "C");
        assertEquals(ttht.get("bar"), "Z");
        assertNull(ttht.get("baz"));
    }

    public static void test3GetSpecificTimeValues() {
        assertEquals(ttht.get("foo", 0.0), "A");
        assertEquals(ttht.get("bar", 0.0), "X");
        
        assertEquals(ttht.get("foo", 1.0), "B");
        assertEquals(ttht.get("bar", 1.0), "X");
        
        assertEquals(ttht.get("foo", 2.0), "C");
        assertEquals(ttht.get("bar", 2.0), "Y");
        
        assertEquals(ttht.get("foo", 3.0), "C");
        assertEquals(ttht.get("bar", 3.0), "Z");
        
        assertNull(ttht.get("foo", -1.0));
        assertEquals(ttht.get("bar", -1.0), "X");
    }
}