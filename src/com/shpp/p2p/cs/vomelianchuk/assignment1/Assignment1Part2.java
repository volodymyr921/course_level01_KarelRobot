package com.shpp.p2p.cs.vomelianchuk.assignment1;

/**
 * File: Assignment1Part2.java
 * Karel builds slender columns of stones
 */
public class Assignment1Part2 extends KarelProfessional {
    /**
     * Pre-condition: Karel is in the southwest corner and faces east
     * Result: Karel built all the columns
     */
    @Override
    public void run() throws Exception {
        // builds all the columns except the last one
        while (frontIsClear()) {
            buildColumn();
            returnToTheFloor();
            moveToNextColumn();
        }

        // builds the last column
        buildColumn();
    }

    /**
     * Pre-condition: Karel is on the floor,
     * where the column should be and faces east
     * Result: Karel built a column and is looking north
     */
    private void buildColumn() throws Exception {
        turnLeft();

        // builds a column by filling in the gaps with beepers
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }

        // puts a beeper on the last cell, if there is no beeper
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    /**
     * Pre-condition: Karel built a column and is looking north
     * Result: Karel stands on the floor of the same column
     * and looks to the east
     */
    private void returnToTheFloor() throws Exception {
        turnAround();
        moveToTheWall();
        turnLeft();
    }

    /**
     * Pre-condition: Karel stands on the floor, where column is present
     * and looks to the east
     * Result: Karel stands on the floor of the next column,
     * where it needs to be built and looks to the east
     */
    private void moveToNextColumn() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }
}
