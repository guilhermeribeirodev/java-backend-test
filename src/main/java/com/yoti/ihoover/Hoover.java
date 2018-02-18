package com.yoti.ihoover;

import java.util.List;

public class Hoover {

    int x;
    int y;

    public Hoover(List<Integer> coords) {
        this.x = coords.get(0);
        this.y = coords.get(1);
    }

    public Hoover(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(String instructions) {
        for(char c : instructions.toCharArray())
            switch(c){
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;

            }
    }

    public String getCurrentPosition() {
        return String.format("'coords' : [%d, %d]", x, y);
    }
}
