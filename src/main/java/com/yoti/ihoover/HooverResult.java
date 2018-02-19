package com.yoti.ihoover;

import javax.persistence.*;

@Entity
@Table(name = "hoover_result")
public class HooverResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCoordsX() {
        return coordsX;
    }

    public void setCoordsX(int coordsX) {
        this.coordsX = coordsX;
    }

    public int getCoordsY() {
        return coordsY;
    }

    public void setCoordsY(int coordsY) {
        this.coordsY = coordsY;
    }

    public int getPatches() {
        return patches;
    }

    public void setPatches(int patches) {
        this.patches = patches;
    }
}
