package com.lenyiova.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.*;

public class TestInputHandler {

    @Test
    public void testEmptyInput() {
        final List<Map<String, String>> input = Collections.EMPTY_LIST;
        final InputHandler handler = new InputHandler();

        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                handler.handleInput(input);
            }
        });
    }

    @Test
    public void testOneItemInput() {
       // Map<String, String> map = Map.of("instruction", "on", "pointAx", "1", "pointAy", "1", "pointBx", "2", "pointBy", "2");  => Nefunguje, nechapu proc.
        Map<String, String> map = new HashMap<>();
        map.put("instruction", "on");
        map.put("pointAx", "1");
        map.put("pointAy", "1");
        map.put("pointBx", "2");
        map.put("pointBy", "2");

        List<Map<String, String>> input = new ArrayList<>();
        input.add(map);

        InputHandler handler = new InputHandler();
        List<Instruction> instructions = handler.handleInput(input);

        Assertions.assertEquals(1, instructions.size());
    }
}
