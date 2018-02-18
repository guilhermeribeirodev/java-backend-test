package com.yoti.ihoover;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HooverSteps {

    private Hoover hoover;

    @Given("^a hoover starting on a room of (\\d+) x (\\d+) dimensions with X = (\\d+) and Y = (\\d+) as coords$")
    public void a_room_with_the_following_dimensions_X_and_Y(int roomX, int roomY, int coordX, int coordY)  {

        hoover = new Hoover(coordX, coordY);
        assertThat(hoover.getCurrentPosition(), is(String.format("'coords' : [%d, %d]", coordX, coordY)));
    }

    @When("^requested to move with instructions '([NWSE]+)'$")
    public void requestedToMoveWithInstructionsNNNEEE(String instructions) throws Throwable {
        hoover.move(instructions);
    }

    @Then("^hoover current position should be X = (\\d+) and Y = (\\d+)$")
    public void hooverCurrentPositionShouldBeXAndY(int x, int y) throws Throwable {
        assertThat(hoover.getCurrentPosition(), is(String.format("'coords' : [%d, %d]", x, y)));
    }
}
