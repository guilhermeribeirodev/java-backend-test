package com.yoti.ihoover;


import com.yoti.ihoover.domain.Hoover;
import com.yoti.ihoover.domain.Patch;
import com.yoti.ihoover.domain.Room;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hoover_result")
public class HooverResult {

    @Id
    @SequenceGenerator(name="hoover_result_seq",
            sequenceName="hoover_result_seq", initialValue = 1,
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="hoover_result_seq")
    @Column(name = "id", updatable = false, unique = true)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Patch> patches;
    @OneToOne(cascade = CascadeType.ALL)
    private  Hoover hoover;

    public HooverResult(Hoover hoover, Room room) {
        this.hoover = hoover;
        this.patches = room.getPatches();
    }

    public HooverResult() {
    }

    @Override
    public String toString() {
        return String.format("{" +
                "coords : [%d, %d]," +
                "patches : %d" +
                "}", patches.get(0).getX(),patches.get(0).getY(),hoover.getNumberOfPatchesRemoved());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Patch> getPatches() {
        return patches;
    }

    public void setPatches(List<Patch> patches) {
        this.patches = patches;
    }

    public Hoover getHoover() {
        return hoover;
    }

    public void setHoover(Hoover hoover) {
        this.hoover = hoover;
    }

}
