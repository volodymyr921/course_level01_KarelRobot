package com.shpp.p2p.cs.vomelianchuk.assignment1;

import com.shpp.karel.KarelTheRobot;

/**
 * File: KarelProfessional.java
 * Improves KarelTheRobot.
 * Allows him to turn right, turn around,
 * moves straight to the wall,
 * move straight to the beeper, step right
 */
public class KarelProfessional extends KarelTheRobot {
    /**
     * Pre-condition: None
     * Result: Karel turns 90 degrees to the right
     */
    public void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    /**
     * Pre-condition: None
     * Result: Karel makes a 180-degree turn
     */
    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /**
     * Pre-condition: None
     * Result: Karel walks straight until the wall
     */
    public void moveToTheWall() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    /**
     * Pre-condition: There is a beeper straight ahead of Karel
     * Result: Karel goes straight to the cell where the beeper is
     */
    public void moveToTheBeeper() throws Exception {
        while (noBeepersPresent()) {
            move();
        }
    }

    /**
     * Pre-condition: On the right side there is a place without a wall
     * Result: Karel takes a step into the cell that was on the right side relative to him
     */
    public void stepToTheRight() throws Exception {
        turnRight();
        move();
        turnLeft();
    }
}
