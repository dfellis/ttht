# The Time Traveling Hash Table
# =============================
# 
# When dealing with a normal hash table, if you query a key before it has been set,
# you'll get nothing back, and when querying a key after it has been set, you'll get
# that value back. If you set the value again and then get it again, you'll get the
# new value and not the old value.
#
# The Time Traveling Hash Table works the same way, except you can also set the time
# you wish to query from. So if you set a value at 10AM, 11AM, and 12:30PM, you can then
# specify that you want to query at 9:45AM and get nothing, 10AM and get the first value
# that was set, 11:15AM and get the second value set, 12:29PM and still get the second value
# set, and 1PM and get the third value set.
#
# Below is a TimeTravelingHashTable prototype and a test suite using it. Please fill in the
# implementation for the three methods, `set`, `get`, and `get_at` to pass the test.
#
# The `key` is a string, the `val` can be anything, and the `time` is a floating point number.
#
# NOTE: PERFORMANCE DOES NOT MATTER

import unittest

class TimeTravelingHashTable:
    def set(self, key, val, time):
        pass
    
    def get(self, key):
        pass
    
    def get_at(self, key, time):
        pass

ttht = TimeTravelingHashTable()

class TestTimeTravelingHashTable(unittest.TestCase):
    def test_1_set_values(self):
        ttht.set('foo', 'A', 0.0)
        ttht.set('foo', 'B', 1.0)
        ttht.set('foo', 'C', 2.0)
        
        ttht.set('bar', 'Z', 3.0)
        ttht.set('bar', 'Y', 1.5)
        ttht.set('bar', 'X', -1.5)
        
    def test_2_get_latest_values(self):
        assert ttht.get('foo') == 'C'
        assert ttht.get('bar') == 'Z'
        assert ttht.get('baz') is None

    def test_3_get_specific_time_values(self):
        assert ttht.get_at('foo', 0.0) == 'A'
        assert ttht.get_at('bar', 0.0) == 'X'
        
        assert ttht.get_at('foo', 1.0) == 'B'
        assert ttht.get_at('bar', 1.0) == 'X'
        
        assert ttht.get_at('foo', 2.0) == 'C'
        assert ttht.get_at('bar', 2.0) == 'Y'
        
        assert ttht.get_at('foo', 3.0) == 'C'
        assert ttht.get_at('bar', 3.0) =='Z'
        
        assert ttht.get_at('foo', -1.0) is None
        assert ttht.get_at('bar', -1.0) == 'X'

unittest.main()