package com.lenyiova.model;

public class Instruction {
    private String instruction;
    private int ax;
    private int ay;
    private int bx;
    private int by;

    public Instruction(String instruction, int ax, int ay, int bx, int by) {
        this.instruction = instruction;
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
    }

    @Override
    public String toString() {
        return instruction + ": A(" + ax + ", " + ay + ") B(" + bx + ", " + by + ");";
    }

    public String getInstruction() {
        return instruction;
    }

    public int getAx() {
        return ax;
    }

    public int getAy() {
        return ay;
    }

    public int getBx() {
        return bx;
    }

    public int getBy() {
        return by;
    }
}
