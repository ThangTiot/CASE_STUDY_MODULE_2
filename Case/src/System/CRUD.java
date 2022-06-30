package System;

import java.util.ArrayList;

public interface CRUD<E> {

    E creat();

    void add(E e);

    void displayAll();

    void update(E e);

    void delete(E e);
}
