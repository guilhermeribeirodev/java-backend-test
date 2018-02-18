package com.yoti.ihoover;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class RoomSteps {

    Room room;
    CleanSchedule cleanSchedule;
    Hoover hoover;

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
        ObjectMapper mapper = new ObjectMapper();
        cleanSchedule = mapper.readValue(json, CleanSchedule.class);
    }

    @Then("^room X, Y and hoover coords X, Y should be (\\d+), (\\d+), (\\d+), (\\d+) and instructions '([NWSE]+)'$")
    public void roomXYAndCoordsXYShouldBe(int x, int y, int coordX, int coordY, String instructions) throws Throwable {
        assertThat(cleanSchedule.getRoom().getX(), is(x));
        assertThat(cleanSchedule.getRoom().getY(), is(y));
        assertThat(cleanSchedule.getHoover().getCoord().getX(), is(coordX));
        assertThat(cleanSchedule.getHoover().getCoord(), is(coordY));
        assertThat(cleanSchedule.getInstructions(), is(instructions));
    }

}
