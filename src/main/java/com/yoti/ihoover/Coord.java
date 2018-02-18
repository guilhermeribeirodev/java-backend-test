package com.yoti.ihoover;

public class Coord {

    private int x;
    private int y;

    private Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Coord createCoord(int x, int y){
        return new Coord(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void _N(){
        y++;
    }

    public void _S(){
        y--;
    }

    public void _E(){
        x++;
    }

    public void _W(){
        x--;
    }
}
