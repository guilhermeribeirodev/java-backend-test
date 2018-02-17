Feature: Room specification
  Scenario: Ensure room is created

    Given a room with the following dimensions X = 2 and Y = 2
    Then numberOfPositions of room must be 4

  Scenario: Creation of a room based on a json payload

    Given the following json payload as ihoover input:
    """
    {
      "roomSize" : [5, 5],
      "coords" : [1, 2],
      "patches" : [
        [1, 0],
        [2, 2],
        [2, 3]
      ],
      "instructions" : "NNESEESWNWW"
    }
    """

    Then room X, Y and coords X, Y should be 5, 5, 1, 2 and instructions 'NNESEESWNWW'



