Feature: Room specification
  Scenario: Ensure room is created

    Given a room with the following dimensions X = 2 and Y = 2
    Then result numberOfPositions of room must be 4
