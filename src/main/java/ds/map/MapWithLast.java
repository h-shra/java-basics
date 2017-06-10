package ds.map;

public class MapWithLast implements AbstractMapWithLast {

    NodeInArray[] array;
    NodeInDoubleList head;
    NodeInDoubleList tail;

    public MapWithLast() {
        array = new NodeInArray[5];
        head = null;
        tail = null;
    }

    public MapWithLast(int bucketSize) {
        array = new NodeInArray[bucketSize];
        head = null;
        tail = null;
    }

    @Override
    public void put(Integer key, Integer v) {
        int index = hash(key);

    }

    @Override
    public Integer get(Integer key) {
        NodeInArray node = searchKey(key);
        if (node!= null && node.key == key) {
            return node.pointer.value;
        }
        return null;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public Integer last(Integer key) {
        return null;
    }

    private Integer hash(Integer key) {
        return key % array.length;
    }

    private NodeInArray searchKey(Integer key) {
        for (int i = 0; i<array.length; i++) {
            if (array[i].key == key) {
                return array[i];
            }
        }
        return null;
    }

    private class NodeInArray {
        Integer key;
        NodeInDoubleList pointer;

        private NodeInArray() {
            key = Integer.MAX_VALUE;
            pointer = null;
        }
    }

    private class NodeInDoubleList {
        Integer key;
        Integer value;
        NodeInDoubleList next;
        NodeInDoubleList prev;
    }
}
