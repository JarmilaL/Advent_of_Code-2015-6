package com.lenyiova.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class InputHandler {

    public List<Instruction> handleInput(List<Map<String, String>> input) {
        if (input.isEmpty()) throw new IllegalArgumentException("List is empty, no instruction data.");

        return createInstructions(input);
    }

    private List<Instruction> createInstructions(List<Map<String, String>> input) {
        List<Instruction> instructions = new ArrayList<>();

        for (Map<String, String> map : input) {
            String inst = map.get("instruction");
            int ax = Integer.parseInt(map.get("pointAx"));
            int ay = Integer.parseInt(map.get("pointAy"));
            int bx = Integer.parseInt(map.get("pointBx"));
            int by = Integer.parseInt(map.get("pointBy"));
            instructions.add(new Instruction(inst, ax, ay, bx, by));
        }

        return instructions;
    }
}
