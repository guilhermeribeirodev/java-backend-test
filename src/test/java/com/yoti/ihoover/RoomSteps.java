package com.yoti.ihoover;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class RoomSteps {

    Room room;

    @Given("^a room with the following dimensions X = (\\d+) and Y = (\\d+)$")
    public void a_room_with_the_following_dimensions_X_and_Y(int arg1, int arg2) throws Throwable {
        room = Room.createRoom(2,2);
        assertThat(room.numberOfPositions(), is(4));
    }

    @When("^user asks for numberOfPositions of room$")
    public void user_asks_for_room_numberOfPositions() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^result must be (\\d+)$")
    public void result_must_be(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
