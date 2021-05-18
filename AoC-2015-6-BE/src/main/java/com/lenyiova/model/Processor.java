package com.lenyiova.model;

import java.util.List;

public interface Processor<T, S> {

    S process(T instruction, S object);
    S processAll(List<T> instructions, S object);
}
