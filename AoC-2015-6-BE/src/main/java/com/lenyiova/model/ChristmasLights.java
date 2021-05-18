package com.lenyiova.model;

import java.util.ArrayList;
import java.util.List;

public class ChristmasLights {
    private List<List<Boolean>> lights;

    public ChristmasLights(int numberOfLights, int rectangleSideLength) {
        this.lights = new ArrayList<>();
        for (int i = 0; i < rectangleSideLength; i++) {
            List<Boolean> line = new ArrayList<>();
            for (int j = 0; j < numberOfLights / rectangleSideLength; j++) line.add(false);
            lights.add(line);
        }
    }

    public List<List<Boolean>> getLights() {
        return lights;
    }

    public int countLitLights() {
        int count = 0;

        for (int i = 0; i < lights.size(); i++) {
            List<Boolean> line = lights.get(i);
            for (int j = 0; j < line.size(); j++) {
                Boolean light = line.get(j);
                if (light) count += 1;
            }
        }

        return count;
    }
}
