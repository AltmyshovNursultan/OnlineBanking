package com.bank.onlinebanking.mapper.base;

import java.util.List;

public interface CrudMethod <E, D>{
    D toDto(E e);
    E toEntity(D d);

    List<D> toDtos (List<E> e);
    List<E> toEntity(List<D> d);
}
