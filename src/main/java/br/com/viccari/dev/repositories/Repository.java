package br.com.viccari.dev.repositories;

import java.util.List;

public interface Repository<T> {
    void create(T instance);
    T findById(String id);
    List<T> all();
    int delete(String id);
}
