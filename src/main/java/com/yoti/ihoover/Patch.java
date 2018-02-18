package com.yoti.ihoover;

import java.util.Objects;

public class Patch {

    int x;
    int y;

    public Patch(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patch patch = (Patch) o;
        return x == patch.x &&
                y == patch.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
