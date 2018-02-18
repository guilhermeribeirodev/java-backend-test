package com.yoti.ihoover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Room {

    private int x;
    private int y;
    private final List<Patch> patches = new ArrayList<>();

    private Room(int x, int y) {
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

    public void setPatches(List<Patch> patches) {
        this.patches.addAll(patches);
    }

    public boolean removePatch(int x, int y) {
        return patches.remove(new Patch(x,y));
    }

    public void fromJsonArray(List<List<Integer>> patches) {
        for(List<Integer> lst : patches){
            this.patches.add(new Patch(lst.get(0), lst.get(1)));
        }


    }
}
