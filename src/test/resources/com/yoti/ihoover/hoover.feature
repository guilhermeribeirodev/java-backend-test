Feature: hoover specification
  Scenario: hoover should move on the assigned position and show it when requested

    Given a hoover starting on a room of 6 x 6 dimensions with X = 2 and Y = 3 as coords
    When requested to move with instructions 'NNNEEE'
    Then hoover current position should be X = 5 and Y = 6
