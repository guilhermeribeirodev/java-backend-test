package com.yoti.ihoover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Room {

    private int x;
    private int y;
    private List<Integer> patches = new ArrayList<>();

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

    public void setPatches(Integer ... patches) {
        Collections.addAll(this.patches, patches);
    }
}
