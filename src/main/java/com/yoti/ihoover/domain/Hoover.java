package com.yoti.ihoover.domain;

import com.yoti.ihoover.HooverResult;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hoover")
public class Hoover {

    @Id
    @SequenceGenerator(name="hoover_seq",
            sequenceName="hoover_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="hoover_seq")
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    private int numberOfPatchesRemoved;
    @Transient
    private  Coord coord;
    @Transient
    private  Coord initialCoord;

    @OneToOne(cascade = CascadeType.ALL)
    private HooverResult hooverResult;

    private Hoover(Coord coord) {
        this.coord = coord;
        initialCoord = Coord.createCoord(coord.getX(), coord.getY());
    }

    public Hoover() {
    }

    public void move(String instructions, Room room) {
        for(char c : instructions.toCharArray()){
            coord.command(c, room);
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

    public Coord getInitialCoord() {
        return initialCoord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumberOfPatchesRemoved(int numberOfPatchesRemoved) {
        this.numberOfPatchesRemoved = numberOfPatchesRemoved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hoover hoover = (Hoover) o;

        return id.equals(hoover.id);
    }

    @Override
    public int hashCode() {
        return 17 + id.hashCode();
    }
}
