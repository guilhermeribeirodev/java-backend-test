package com.yoti.ihoover;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class RoomSteps {

    Room room;

    @Given("^a room with the following dimensions X = (\\d+) and Y = (\\d+)$")
    public void a_room_with_the_following_dimensions_X_and_Y(int x, int y) throws Throwable {
        room = Room.createRoom(x,y);

    }

    @Then("^result numberOfPositions of room must be (\\d+)$")
    public void result_must_be(int positions) throws Throwable {
        assertThat(room.numberOfPositions(), is(positions));
    }
}
