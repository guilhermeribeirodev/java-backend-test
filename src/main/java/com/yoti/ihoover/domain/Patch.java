package com.yoti.ihoover.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Patch {

    @Transient
    private Coord coord;

    @Id
    @SequenceGenerator(name="patch_seq",
            sequenceName="patch_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="patch_seq")
    private Long id;
    private int x;
    private int y;

    public Patch(int x, int y) {
        this.coord = Coord.createCoord(x,y);
        this.x = x;
        this.y = y;
    }

    public Patch() {
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
        return this.x == patch.getX() && this.y == patch.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord.getX(), coord.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @JsonProperty("_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
