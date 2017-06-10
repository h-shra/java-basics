package ds.map;

public interface AbstractMapWithLast{

    void put(Integer key, Integer v);
    Integer get(Integer key);
    void delete(Integer key);
    Integer last(Integer key);
}
