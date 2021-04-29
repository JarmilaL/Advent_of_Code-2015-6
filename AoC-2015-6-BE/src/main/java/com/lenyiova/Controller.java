package com.lenyiova;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Instruction handlePostRequest(@RequestBody List<Map<String, Object>> instructions) {

        List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
        maps.addAll(instructions);

        for (int i = 0; i < maps.size(); i++) {
            System.out.println(maps.get(i).keySet());
            System.out.println(maps.get(i).values());
        }

//        for (int i = 0; i < instructions.length; i++) {
//            System.out.println(instructions[i]);
//        }

        Instruction pokus = new Instruction("on", 34, 35, 62, 70);
        return pokus;
    }
}
