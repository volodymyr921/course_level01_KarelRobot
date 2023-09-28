package com.shpp.p2p.cs.vomelianchuk.assignment1;

/**
 * File: Assignment1Part4.java
 * Karel creates a "checkerboard" using a beeper in a rectangular empty world
 */
public class Assignment1Part4 extends KarelProfessional {
    /**
     * Pre-condition: Karel is in the southwest corner and faces east
     * Result: Karel arranged the beepers in a checkerboard pattern
     */
    @Override
    public void run() throws Exception {
        // puts the initial beeper
        putBeeper();

        // fills the diagonals with beepers, each time starting from the south line
        while (frontIsClear()) {
            createDiagonal();
            turnAround();
            moveToNextDiagonal();
        }

        // proceeds to fill the diagonals, moving along the west line
        returnToTheStartPlace();
        moveToNextDiagonal();
        turnRight();

        // fills the diagonals with beepers, each time starting from the west line
        while (leftIsClear()) {
            createDiagonal();
            turnRight();
            moveToNextDiagonal();
            turnRight();
        }
    }

    /**
     * Pre-condition: Karel is looking east
     * Result: Karel put beepers diagonally
     * and is in the north or east line and faces east
     */
    private void createDiagonal() throws Exception {
        fillDiagonal();
        turnAround();
        returnToTheStartOfDiagonal();
    }

    /**
     * Pre-condition: Karel is in the south or west line and faces east
     * Result: Karel put beepers diagonally
     * and is in the north or east line and faces east
     */
    private void fillDiagonal() throws Exception {
        while (frontIsClear() && leftIsClear()) {
            stepDiagonallyUp();
            putBeeper();
        }
    }

    /**
     * Pre-condition: Karel is in the north or east line and faces east
     * Result: Karel returns to the beginning of the diagonal line
     * and is in the south or west line and faces east
     */
    private void returnToTheStartOfDiagonal() throws Exception {
        while (leftIsClear() && frontIsClear()) {
            stepDiagonallyDown();
        }
    }

    /**
     * Pre-condition: Karel is on the south or west line and faces north or east respectively
     * Result: Karel moves across the cell and puts a beeper there,
     * that's where the new diagonal will start
     */
    private void moveToNextDiagonal() throws Exception {
        if (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }

    /**
     * Pre-condition: Karel is in the southeast corner and faces east
     * Result: Karel is in the southeast corner and faces north
     */
    private void returnToTheStartPlace() throws Exception {
        turnAround();
        moveToTheWall();
        turnRight();
    }

    /**
     * Pre-condition: Karel is in any cell, looking to the east
     * Result: Karel is in the next cell diagonally up, looking east
     */
    private void stepDiagonallyUp() throws Exception {
        move();
        turnLeft();
        move();
        turnRight();
    }

    /**
     * Pre-condition: Karel is in any cell, looking to the west
     * Result: Karel is in the next cell diagonally down, looking west
     */
    private void stepDiagonallyDown() throws Exception {
        turnLeft();
        move();
        turnRight();
        move();
    }
}
