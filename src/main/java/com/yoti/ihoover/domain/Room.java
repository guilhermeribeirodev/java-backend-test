package com.yoti.ihoover.domain;

import java.util.ArrayList;
import java.util.List;

public final class Room {

    private Coord coord;
    private final List<Patch> patches = new ArrayList<>();

    private Room(int x, int y) {
        this.coord = Coord.createCoord(x,y);
    }

    public Room(Coord coord) {
        this.coord = coord;
    }

    public static Room createRoom(int x, int y) {
        return new Room(Coord.createCoord(x,y));
    }

    public int numberOfPositions() {
        return coord.getX()*coord.getY();
    }

    public void setPatches(List<Patch> patches) {
        this.patches.addAll(patches);
    }

    public List<Patch> getPatches() {
        return patches;
    }

    public boolean removePatch(int x, int y) {
        return patches.remove(new Patch(x,y));
    }

    public void fromJsonArray(List<List<Integer>> patches) {
        for(List<Integer> lst : patches){
            this.patches.add(new Patch(lst.get(0), lst.get(1)));
        }

    }

    public Coord getCoord() {
        return coord;
    }
}
