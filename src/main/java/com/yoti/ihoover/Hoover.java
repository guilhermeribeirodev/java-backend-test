package com.yoti.ihoover;

import java.util.List;

public class Hoover {

    int x;
    int y;
    private int numberOfPatchesRemoved;

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

    public void move(String instructions, Room room) {
        for(char c : instructions.toCharArray()){
            switch(c){
                case 'N': if(y < room.getY()) y++; break;
                case 'S': if(y > 0) y--; break;
                case 'E': if(x < room.getX()) x++; break;
                case 'W': if(x > 0) x--; break;
            }
            if(room.removePatch(x,y)) numberOfPatchesRemoved++;
        }

    }

    public String getCurrentPosition() {
        return String.format("'coords' : [%d, %d]", x, y);
    }

    public Integer getNumberOfPatchesRemoved() {
        return numberOfPatchesRemoved;
    }
}
