package com.lenyiova.controller;

import com.lenyiova.model.InputHandler;
import com.lenyiova.model.Instruction;
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

//    @PostMapping(value = "/", consumes = "text/plain")
//    public Instruction handlePostRequest(@RequestBody String instructions) {
//        System.out.println(instructions);
//        Instruction pokus = new Instruction("on", 34, 35, 62, 70);
//        return pokus;
//    }

    @PostMapping(value = "/")
    public Instruction handlePostRequest(@RequestBody List<Map<String, String>> instructions) {

        InputHandler inputHandler = new InputHandler();
        List<Instruction> list = inputHandler.handleInput(instructions);

        for (Instruction i : list) System.out.println(i);



        Instruction pokus = new Instruction("on", 34, 35, 62, 70);
        return pokus;
    }
}
