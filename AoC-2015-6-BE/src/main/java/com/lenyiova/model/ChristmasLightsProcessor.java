package com.lenyiova.model;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChristmasLightsProcessor<T extends Instruction, S extends ChristmasLights> implements Processor<T, S>{

    @Override
    public ChristmasLights process(@NotNull Instruction instruction, ChristmasLights lights) {
        if (lights.getLights().isEmpty()) throw new IllegalArgumentException("List of lights is empty!");
        int startLineIndex = instruction.getAy();
        int endLineIndex = instruction.getBy();
        int startLightIndex = instruction.getAx();
        int endLightIndex = instruction.getBx();
        String inst = instruction.getInstruction();

        for (int i = startLineIndex; i <= endLineIndex; i++) {
            for (int j = startLightIndex; j <= endLightIndex; j++) {
                if (inst.equals("on")) {
                    lights.getLights().get(i).set(j, true);
                } else if (inst.equals("off")) {
                    lights.getLights().get(i).set(j, false);
                } else {
                    Boolean state = lights.getLights().get(i).get(j);
                    if (state) {
                        lights.getLights().get(i).set(j, false);
                    } else {
                        lights.getLights().get(i).set(j, true);
                    }
                }
            }
        }

        return lights;
    }

    @Override
    public S processAll(List<T> instructions, S lights) {
        if (lights.getLights().isEmpty()) throw new IllegalArgumentException("List of lights is empty!");
        if (instructions.isEmpty()) throw new IllegalArgumentException("List of instructions is empty!");
        for (Instruction instruction : instructions) lights = (S) process(instruction, lights);
        return lights;
    }

//    public ChristmasLights processAll(List<Instruction> instructions, ChristmasLights lights) {
//        if (lights.getLights().isEmpty()) throw new IllegalArgumentException("List of lights is empty!");
//        if (instructions.isEmpty()) throw new IllegalArgumentException("List of instructions is empty!");
//        for (Instruction instruction : instructions) lights = process(instruction, lights);
//        return lights;
//    }
}
