package com.yoti.ihoover;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HooverSteps {

    private Hoover hoover;
    private Room room;

    @Given("^a hoover starting on a room of (\\d+) x (\\d+) dimensions with X = (\\d+) and Y = (\\d+) as coords$")
    public void a_room_with_the_following_dimensions_X_and_Y(int roomX, int roomY, int coordX, int coordY)  {

        hoover = Hoover.createHoover(coordX, coordY);
        room = Room.createRoom(roomX, roomY);
        assertThat(hoover.getCurrentPosition(), is(String.format("'coords' : [%d, %d]", coordX, coordY)));
    }

    @When("^requested to move with instructions '([NWSE]+)'$")
    public void requestedToMoveWithInstructions(String instructions) throws Throwable {
        hoover.move(instructions, room);
    }

    @Then("^hoover current position should be X = (\\d+) and Y = (\\d+)$")
    public void hooverCurrentPositionShouldBeXAndY(int x, int y) throws Throwable {
        assertThat(hoover.getCurrentPosition(), is(String.format("'coords' : [%d, %d]", x, y)));
    }

    @And("^having patches of dirty by \\[(\\d+),(\\d+)\\] and \\[(\\d+),(\\d+)\\] coords$")
    public void havingPatchesOfDirtyByAndCoords(int patch_1X, int patch_1Y, int patch_2X, int patch_2Y) throws Throwable {
        room.setPatches(new ArrayList<>(Arrays.asList(new Patch(patch_1X,patch_1Y), new Patch(patch_2X,patch_2Y))));
    }

    @Then("^hoover removed patches would be (\\d+)$")
    public void hooverRemovedPatchesWouldBe(int patches) throws Throwable {
        assertThat(hoover.getNumberOfPatchesRemoved(), is(patches));
    }

    @And("^having patches of dirty by \\[(\\d+),(\\d+)\\] and \\[(\\d+),(\\d+)\\] and \\[(\\d+),(\\d+)\\] coords$")
    public void havingPatchesOfDirtyByAndAndCoords(int patch_1X, int patch_1Y, int patch_2X, int patch_2Y,
                                                   int patch_3X, int patch_3Y) throws Throwable {
        room.setPatches(new ArrayList<>(Arrays.asList(new Patch(patch_1X,patch_1Y), new Patch(patch_2X,patch_2Y),
                new Patch(patch_3X,patch_3Y))));
    }
}
