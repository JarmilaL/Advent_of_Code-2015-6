package com.lenyiova;

public class Instruction {
    private String instruction;
    private int Ax;
    private int Ay;
    private int Bx;
    private int By;

    public Instruction(String instruction, int ax, int ay, int bx, int by) {
        this.instruction = instruction;
        Ax = ax;
        Ay = ay;
        Bx = bx;
        By = by;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getAx() {
        return Ax;
    }

    public int getAy() {
        return Ay;
    }

    public int getBx() {
        return Bx;
    }

    public int getBy() {
        return By;
    }
}
