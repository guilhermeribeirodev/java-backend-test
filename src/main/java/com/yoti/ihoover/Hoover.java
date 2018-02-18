package com.yoti.ihoover;

import java.util.List;

public class Hoover {

    private int numberOfPatchesRemoved;
    private Coord coord;

    private Hoover(Coord coord) {
        this.coord = coord;
    }

    public void move(String instructions, Room room) {
        for(char c : instructions.toCharArray()){
            switch(c){
                case 'N': if(coord.getY() < room.getY()) coord._N(); break;
                case 'S': if(coord.getY() > 0) coord._S(); break;
                case 'E': if(coord.getX() < room.getX()) coord._E(); break;
                case 'W': if(coord.getX() > 0) coord._W(); break;
            }
            if(room.removePatch(coord.getX(),coord.getY())) numberOfPatchesRemoved++;
        }

    }

    public String getCurrentPosition() {
        return String.format("'coords' : [%d, %d]", coord.getX(), coord.getY());
    }

    public Integer getNumberOfPatchesRemoved() {
        return numberOfPatchesRemoved;
    }

    public static Hoover createFromList(List<Integer> coords) {
        return new Hoover(Coord.createCoord(coords.get(0), coords.get(1)));
    }

    public static Hoover createHoover(int coordX, int coordY) {
        return new Hoover(Coord.createCoord(coordX,coordY));
    }

    public Coord getCoord() {
        return coord;
    }
}
