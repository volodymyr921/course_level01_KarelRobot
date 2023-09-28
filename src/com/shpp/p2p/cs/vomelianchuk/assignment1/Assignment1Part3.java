package com.shpp.p2p.cs.vomelianchuk.assignment1;

/**
 * File: Assignment1Part3.java
 * Karel is looking for the center of the southern lane
 */
public class Assignment1Part3 extends KarelProfessional {
    /**
     * Pre-condition: Karel is in the southwest corner and faces east
     * Result: Karel put beeper in the center of the southern lane,
     * his final placement is on the east line, facing east
     */
    @Override
    public void run() throws Exception {
        fillFirstDiagonal();
        moveToTheSecondDiagonal();

        while (frontIsClear()) {
            /*
            In the case of an odd width, the diagonals intersect
            needs to stop at the intersection
            */
            if (beepersPresent()) {
                putBeeperInCenterOfSouthernStrip();
                returnToTheSecondDiagonal();
                clearTheDiagonals();
            } else {
                putBeeper();

                /*
                In the case of an even width, the diagonals  don`t intersect
                needs to take a step to check if there is a beeper there
                */
                move();

                /*
                If there is a beeper,
                then going down it will hit the center of the south line
                (one of the two central cells)
                */
                if (beepersPresent()) {
                    putBeeperInCenterOfSouthernStrip();
                    returnToTheSecondDiagonal();
                    move();
                    clearTheDiagonals();
                }
            }
            stepToTheRight();
        }
    }

    /**
     * Pre-condition: Karel is in the southwest corner and is looking east
     * Result: Karel placed beepers along the first (main) diagonal
     * and is looking east
     */
    private void fillFirstDiagonal() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            stepDiagonally();
        }
        putBeeper();
    }

    /**
     * Pre-condition: Karel is at the top of the first diagonal and looks east
     * Result: Karel is at the top of the second diagonal and looks east
     */
    private void moveToTheSecondDiagonal() throws Exception {
        turnAround();
        moveToTheWall();
        turnAround();
    }

    /**
     * Pre-condition: Karel in the middle of the rectangle,
     * where the middle beeper is, looks to the east
     * Result: Karel went down to the south lane and put the beeper,
     * which will be the center of the south lane.
     * He is looking south
     */
    private void putBeeperInCenterOfSouthernStrip() throws Exception {
        turnRight();
        moveToTheWall();
        putBeeper();
    }

    /**
     * Pre-condition: Karel is in the center of the southern lane, looking south
     * Result: Karel returned to the beeper, from where he descended to the south line
     */
    private void returnToTheSecondDiagonal() throws Exception {
        turnAround();
        move();

        if (noBeepersPresent()) {
            moveToTheBeeper();
        }
        turnLeft();
    }

    /**
     * Pre-condition: Karel is in the center of the second diagonal
     * (in the even world in the neighboring cell east of its),
     * he is looking west
     * Result: Karel picked up all the beepers diagonally,
     * leaving only the beeper in the center of the south lane,
     * it is in the northeast corner and faces east
     */
    private void clearTheDiagonals() throws Exception {
        pickBeepersOfSecondDiagonal();
        turnLeft();
        moveToTheWall();
        turnLeft();
        pickBeepersOfFirstDiagonal();
    }

    /**
     * Pre-condition: Karel is in the center of the second diagonal,
     * he is looking west
     * Result: Karel picked up all the beepers on the second diagonal,
     * is in the northwest corner, looking west
     */
    private void pickBeepersOfSecondDiagonal() throws Exception {
        while (frontIsClear()) {
            pickBeeper();
            stepToTheRight();
            move();
        }

        pickBeeper();
    }

    /**
     * Pre-condition: Karel is in the southwest corner and is looking east
     * Result: Karel picked up all beepers along the first diagonal
     * and looks to the east
     */
    private void pickBeepersOfFirstDiagonal() throws Exception {
        while (frontIsClear()) {
            if (beepersPresent()) {
                pickBeeper();
            }
            stepDiagonally();
        }

        if (beepersPresent()) {
            pickBeeper();
        }
    }

    /**
     * Pre-condition: Karel is in the cell on the first diagonal, facing east
     * Result: Karel moved to the next cell up the first diagonal, facing east
     */
    private void stepDiagonally() throws Exception {
        move();
        turnLeft();
        move();
        turnRight();
    }
}
