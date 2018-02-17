package com.yoti.ihoover;

public final class Room {

    private int x;
    private int y;

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
}
