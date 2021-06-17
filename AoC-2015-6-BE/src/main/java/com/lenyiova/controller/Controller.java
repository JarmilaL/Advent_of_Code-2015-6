package com.lenyiova.controller;

import com.lenyiova.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping(value = "/")
    public Instruction handleGetRequest() {
        System.out.println("Tu jsem a zdravim.");
        Instruction pokus = new Instruction("on", 34, 35, 62, 70);
        return pokus;
    }

    @PostMapping(value = "/lights")
    public int handlePostRequest(@RequestBody List<Map<String, String>> instructions) {

        Mapper<Map<String, String>, Instruction> mapper = new InstructionMapper<>();
        List<Instruction> listOfInstructions = mapper.mapAll(instructions);

        // TODO: User can define number of lights and rectangle side length.
        ChristmasLights lights = new ChristmasLights(1_000_000, 1_000);

        Processor<Instruction, ChristmasLights> processor = new ChristmasLightsProcessor<>();
        lights = processor.processAll(listOfInstructions, lights);

        System.out.println(lights.countLitLights());
        return lights.countLitLights();
    }

    @PostMapping(value = "/brightness")
    public int handlePostRequest() {
        return 255;
    }
}
