package com.yoti.ihoover;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CleanSchedule {

    Room room;
    Hoover hoover;
    List<List<Integer>> patches;
    String instructions;

    @JsonCreator
    public CleanSchedule(@JsonProperty("roomSize") final int[] roomSize,
                @JsonProperty("coords") final List<Integer> coords,
                @JsonProperty("patches") final List<List<Integer>> patches,
                @JsonProperty("instructions") final String instructions){
        this.room = Room.createRoom(roomSize[0], roomSize[1]);
        this.hoover = new Hoover(coords);
        this.patches = patches;
        this.instructions = instructions;
    }

    public Room getRoom() {
        return room;
    }

    public List<List<Integer>> getPatches() {
        return patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public Hoover getHoover() {
        return hoover;
    }
}
