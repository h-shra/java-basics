package questions;

import ds.linkedList.DoubleLinkedList;
import ds.linkedList.DoubleLinkedNode;

import java.util.HashMap;

public class LRUCache {
    private final int MAX_SIZE;
    private final HashMap<Integer, DoubleLinkedNode> map = new HashMap<>();
    private final DoubleLinkedList list = new DoubleLinkedList();

    public LRUCache(int size) {
        this.MAX_SIZE = size;
    }

    public static void main(String[] args) {
        //build the cache
        int size = 5;
        LRUCache cache = new LRUCache(size);
        cache.build();
        cache.print();
        cache.put(0, 0);
        cache.print();
        cache.get(200);
        cache.print();
        cache.put(20, 123);
        cache.print();
    }

    private void print() {
        System.out.println("Cache contents : ");
        for (Integer key : map.keySet()) {
            System.out.println("Key : "+key+
                    ", Value : <" + map.get(key).key +
                    ", " +map.get(key).value +
                    "> "
            );
        }
        System.out.println("MRU item (Head): " +list.head.value);
        System.out.println("LRU item (Tail): " +list.tail.value);
    }

    private void build() {
        DoubleLinkedNode node = new DoubleLinkedNode(20000, 20000);
        list.head = list.addAtHead(node);
        map.put(node.value, node);
        node = new DoubleLinkedNode(2000, 2000);
        list.head = list.addAtHead(node);
        map.put(node.value, node);
        node = new DoubleLinkedNode(200, 200);
        list.head = list.addAtHead(node);
        map.put(node.value, node);
        node = new DoubleLinkedNode(20, 20);
        list.head = list.addAtHead(node);
        map.put(node.value, node);
        node = new DoubleLinkedNode(2, 2);
        list.head = list.addAtHead(node);
        map.put(node.value, node);
    }

    /*
    * Inserts (or replaces) the given key,value in cache.
    * Moves it at the head as it's now MRU.
    * If cache has reached its MAX_SIZE, should evict LRU entry.
    * */
    public void put(Integer key, Integer value) {
        //If cache has this key, remove te old value
        if (map.containsKey(key)) {
            DoubleLinkedNode oldNode = map.get(key);
            list.delete(oldNode);
            map.remove(oldNode);
        }
        //Verify if eviction is needed
        if (map.size() == MAX_SIZE) {
            System.out.println("Cache full. Evicting LRU entry to insert :" + value);
            DoubleLinkedNode evicted = list.deleteFromTail();
            map.remove(evicted.key);
        }
        //Insert new key-value in list
        DoubleLinkedNode newNode = list.addAtHead(new DoubleLinkedNode(key, value));
        map.put(key, newNode);

    }

    /*
    * Returns the value for given key.
    * If found, places it at the head as it's now MRU.
    * */
    public Integer get(Integer key) {
        if (!map.containsKey(key)) {
            System.out.println("Cache does not contain requested item");
            return null;
        }
        DoubleLinkedNode requestedNode = map.get(key);
        if (requestedNode != list.head) {
            list.delete(requestedNode);
            list.addAtHead(requestedNode);
        }
        return requestedNode.value;
    }


}
