package dev.tiagosilva.controller;

import java.util.List;

public abstract class Controller<T extends Controller<T>> {
    public List<T> get() {
        return List.of();
    }

    public T get(Long id) {
        return null;
    }

    public T create(T obj) {
        return null;
    }

    public T update(Long id, T obj) {
        return null;
    }

    public boolean delete(Long id) {
        return true;
    }
}
