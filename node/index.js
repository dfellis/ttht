/*
 * The Time Traveling Hash Table
 * =============================
 * 
 * When dealing with a normal hash table, if you query a key before it has been set,
 * you'll get nothing back, and when querying a key after it has been set, you'll get
 * that value back. If you set the value again and then get it again, you'll get the
 * new value and not the old value.
 *
 * The Time Traveling Hash Table works the same way, except you can also set the time
 * you wish to query from. So if you set a value at 10AM, 11AM, and 12:30PM, you can then
 * specify that you want to query at 9:45AM and get nothing, 10AM and get the first value
 * that was set, 11:15AM and get the second value set, 12:29PM and still get the second value
 * set, and 1PM and get the third value set.
 *
 * Below is a TimeTravelingHashTable prototype and a test suite using it. Please fill in the
 * implementation for the three methods, `set`, `get`, and `getAt` to pass the test.
 *
 * The `key` is a string, the `val` can be anything, and the `time` is a floating point number.
 *
 * You can use ES6 features if you want, but not required.
 *
 * NOTE: PERFORMANCE DOES NOT MATTER
 */

const { describe, it } = require('node:test');

class TimeTravelingHashTable {

  set(key, val, time) {}

  get(key) {}

  getAt(key, time) {}
}

let ttht = new TimeTravelingHashTable();

describe('Standard Hash Table Functionality', function() {
    it('should set values without failing', function() {
        ttht.set('foo', 'A', 0.0);
        ttht.set('foo', 'B', 1.0);
        ttht.set('foo', 'C', 2.0);
        
        ttht.set('bar', 'Z', 3.0);
        ttht.set('bar', 'Y', 1.5);
        ttht.set('bar', 'X', -1.5);
    });
    it('should get the latest values', function() {
        assert.equal(ttht.get('foo'), 'C');
        assert.equal(ttht.get('bar'), 'Z');
        assert.equal(ttht.get('baz'), undefined);
    });
});

describe('Time Traveling Hash Table Functionality', function() {
    it('should get the correct values for the specified times', function() {
        assert.equal(ttht.getAt('foo', 0.0), 'A');
        assert.equal(ttht.getAt('bar', 0.0), 'X');
        
        assert.equal(ttht.getAt('foo', 1.0), 'B');
        assert.equal(ttht.getAt('bar', 1.0), 'X');
        
        assert.equal(ttht.getAt('foo', 2.0), 'C');
        assert.equal(ttht.getAt('bar', 2.0), 'Y');
        
        assert.equal(ttht.getAt('foo', 3.0), 'C');
        assert.equal(ttht.getAt('bar', 3.0), 'Z');
        
        assert.equal(ttht.getAt('foo', -1.0), undefined);
        assert.equal(ttht.getAt('bar', -1.0), 'X');
    });
});