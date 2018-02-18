Feature: hoover specification
  Scenario: hoover should move on the assigned position and show it when requested

    Given a hoover starting on a room of 6 x 6 dimensions with X = 2 and Y = 3 as coords
    When requested to move with instructions 'NNNEEE'
    Then hoover current position should be X = 5 and Y = 6

  Scenario: hoover should skid when it hits the room boundaries

    Given a hoover starting on a room of 8 x 7 dimensions with X = 7 and Y = 5 as coords
    When requested to move with instructions 'NNNEE'
    Then hoover current position should be X = 8 and Y = 7

    Given a hoover starting on a room of 8 x 7 dimensions with X = 2 and Y = 2 as coords
    When requested to move with instructions 'SSSEEWWWW'
    Then hoover current position should be X = 0 and Y = 0


