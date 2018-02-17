Feature: Room specification
  Scenario: Ensure room is created

    Given a room with the following dimensions X = 2 and Y = 2
    When user asks for numberOfPositions of room
    Then result must be 4
