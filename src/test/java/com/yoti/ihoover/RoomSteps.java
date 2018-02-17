package com.yoti.ihoover;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class RoomSteps {

    Room room;

    @Given("^a room with the following dimensions X = (\\d+) and Y = (\\d+)$")
    public void a_room_with_the_following_dimensions_X_and_Y(int x, int y)  {
        room = Room.createRoom(x,y);

    }

    @Then("^numberOfPositions of room must be (\\d+)$")
    public void result_must_be(int positions)  {
        assertThat(room.numberOfPositions(), is(positions));
    }

    @Given("^the following json payload as ihoover input:$")
    public void theFollowingJsonPayloadAsIhooverInput(String json) throws Throwable {
        System.out.println(json);
    }
}
