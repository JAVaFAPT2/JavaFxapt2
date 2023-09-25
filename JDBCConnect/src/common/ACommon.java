package common;

import java.util.ArrayList;

public interface ACommon<T> {
    ArrayList<T> getAll();
    T getOne(int id);
    boolean add(T obj);
    boolean update(T obj, int id);
    boolean delete(int id);
}
