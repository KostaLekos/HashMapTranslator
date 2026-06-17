// Kosta Lekos
// June 12th, 2026
//
// Code modified from GeeksForGeeks:
// https://www.geeksforgeeks.org/java/how-to-implement-a-bidirectional-map-using-two-hashsets-in-java/

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashBiMap<K, V> {
    private final Map<K, V> keyToValueMap = new HashMap<>();
    private final Map<V, K> valueToKeyMap = new HashMap<>();

    // method to put a key-value pair into the bidirectional map
    public void put(K key, V value) {
        keyToValueMap.put(key, value);
        valueToKeyMap.put(value, key);
    }

    // method to get a value based on the key
    public V getValueByKey(K key) {
        return keyToValueMap.get(key);
    }

    // method to get a key based on the value
    public K getKeyByValue(V value) {
        return valueToKeyMap.get(value);
    }

    // method to check if a key exists in the map
    public boolean containsKey(K key) {
        return keyToValueMap.containsKey(key);
    }

    // method to check if a value exists in the map
    public boolean containsValue(V value) {
        return valueToKeyMap.containsKey(value);
    }

    // method to remove a key-value pair based on the key
    public void removeByKey(K key) {
        V value = keyToValueMap.remove(key);
        valueToKeyMap.remove(value);
    }

    // method to remove a key-value pair based on the value
    public void removeByValue(V value) {
        K key = valueToKeyMap.remove(value);
        keyToValueMap.remove(key);
    }

    // method to remove all key-value pairs from the bidirectional map
    public void removeAll() {
        keyToValueMap.clear();
        valueToKeyMap.clear();
    }

    // method to get a set of all keys in the bidirectional map
    public Set<K> getAllKeys() {
        return keyToValueMap.keySet();
    }

    // method to get a set of all values in the bidirectional map
    public Set<V> getAllValues() {
        return valueToKeyMap.keySet();
    }

    public boolean replace(K key, V value) {
        if (!keyToValueMap.containsKey(key)) return false;
        V oldValue = keyToValueMap.replace(key, value);
        valueToKeyMap.remove(oldValue);
        valueToKeyMap.put(value, key);
        return true;
    }

    public boolean isEmpty() {
        return valueToKeyMap.isEmpty();
    }
}
