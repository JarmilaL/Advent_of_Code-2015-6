package com.lenyiova.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InstructionMapper<T extends Map<String, String>, S extends Instruction> implements Mapper<T, S> {

    @Override
    public S map(T map) {
        List<String> keys = new ArrayList<>(map.keySet());
        String inst = map.get(keys.get(0));                     // "instruction"
        int ax = Integer.parseInt(map.get(keys.get(1)));        // "pointAx"
        int ay = Integer.parseInt(map.get(keys.get(2)));        // "pointAy"
        int bx = Integer.parseInt(map.get(keys.get(3)));        // "pointBx"
        int by = Integer.parseInt(map.get(keys.get(4)));        // "pointBy"

        return (S) new Instruction(inst, ax, ay, bx, by);
    }

    @Override
    public List<S> mapAll(List<T> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("List is empty, no instruction data.");
        List<S> instructions = new ArrayList<>();

        for (T item : list) {
            instructions.add(map(item));
        }

        return instructions;
    }
}
