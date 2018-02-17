package com.yoti.ihoover;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class Room {

    private int x;
    private int y;
    List<Integer> coords;
    List<List<Integer>> patches;
    private String instructions;

    Room(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Room createRoom(int x, int y) {
        return new Room(x,y);
    }

    public int numberOfPositions() {
        return x*y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getInstructions() {
        return instructions;
    }
}
