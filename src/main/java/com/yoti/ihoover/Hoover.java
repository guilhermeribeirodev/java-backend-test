package com.yoti.ihoover;

import java.util.List;

public class Hoover {

    int x;
    int y;

    public Hoover(List<Integer> coords) {
        this.x = coords.get(0);
        this.y = coords.get(1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
