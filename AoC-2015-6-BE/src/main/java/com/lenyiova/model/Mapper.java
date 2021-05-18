package com.lenyiova.model;

import java.util.List;

public interface Mapper<T, S> {
    S map(T t);
    List<S> mapAll(List<T> list);
}
