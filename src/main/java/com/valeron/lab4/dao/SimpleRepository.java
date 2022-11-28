package com.valeron.lab4.dao;

import java.util.Optional;

public interface SimpleRepository<E> {

    /**
     * @param element an element to be saved into repository
     * @return an identifier of saved element
     */
    int save(E element);

    /**
     * @param id an identifier of element in repository
     * @return an element, if it exists
     */
    Optional<E> get(int id);

}
