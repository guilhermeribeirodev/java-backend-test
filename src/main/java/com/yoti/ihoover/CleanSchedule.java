package com.yoti.ihoover;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CleanSchedule {

    Room room;
    Hoover hoover;
    String instructions;

    @JsonCreator
    public CleanSchedule(@JsonProperty("roomSize") final int[] roomSize,
                @JsonProperty("coords") final List<Integer> coords,
                @JsonProperty("patches") final List<List<Integer>> patches,
                @JsonProperty("instructions") final String instructions) {
        this.room = Room.createRoom(roomSize[0], roomSize[1]);
        this.hoover = Hoover.createFromList(coords);
        this.room.fromJsonArray(patches);
        this.instructions = instructions;
        hoover.move(instructions, room);
    }

    public Room getRoom() {
        return room;
    }

    public String getInstructions() {
        return instructions;
    }

    public Hoover getHoover() {
        return hoover;
    }

    @Override
    public String toString() {
        return hoover.getCurrentPosition() + hoover.getNumberOfPatchesRemoved();
    }
}
