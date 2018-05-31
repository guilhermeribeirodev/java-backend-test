package com.example.ihoover.domain;

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

    private void _N(){
        y++;
    }

    private void _S(){
        y--;
    }

    private void _E(){
        x++;
    }

    private void _W(){
        x--;
    }

    public void command(char c, Room room){
        switch(c){
            case 'N': if(getY() < room.getCoord().getY()) _N(); break;
            case 'S': if(getY() > 0) _S(); break;
            case 'E': if(getX() < room.getCoord().getX()) _E(); break;
            case 'W': if(getX() > 0) _W(); break;
        }
    }

}
