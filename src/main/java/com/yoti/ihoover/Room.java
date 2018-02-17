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

    @JsonCreator
    public Room(@JsonProperty("roomSize") final int[] roomSize,
                @JsonProperty("coords") final List<Integer> coords,
                @JsonProperty("patches") final List<List<Integer>> patches,
                @JsonProperty("instructions") final String instructions){
        this.x = roomSize[0];
        this.y = roomSize[1];
        this.coords = coords;
        this.patches = patches;
        this.instructions = instructions;
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
