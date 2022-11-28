package com.valeron.lab4.dao;

import java.util.Optional;

public interface SimpleRepository<E> {

    int put(E element);
    Optional<E> get(int id);

}
