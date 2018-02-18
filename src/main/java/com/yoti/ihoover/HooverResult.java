package com.yoti.ihoover;

public class HooverResult {

    private int coordsX;
    private int coordsY;
    private int patches;

    public HooverResult(Hoover hoover) {
        coordsX = hoover.getCoord().getX();
        coordsY = hoover.getCoord().getY();
        this.patches = hoover.getNumberOfPatchesRemoved();
    }

    @Override
    public String toString() {
        return String.format("{" +
                "coords : [%d, %d]," +
                "patches : %d" +
                "}", coordsX,coordsY,patches);
    }
}
