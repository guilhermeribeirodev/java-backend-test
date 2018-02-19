package com.yoti.ihoover.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Patch {

    Coord coord;

    public Patch(int x, int y) {
        this.coord = Coord.createCoord(x,y);
    }

    @JsonCreator
    public Patch(@JsonProperty("patches") final int[] patches){
        this.coord = Coord.createCoord(patches[0], patches[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patch patch = (Patch) o;
        return coord.getX() == patch.coord.getX() &&
                coord.getY() == patch.coord.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord.getX(), coord.getY());
    }
}
