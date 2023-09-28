package com.shpp.p2p.cs.vomelianchuk.assignment1;

/**
 * File: Assignment1Part1.java
 * Karel goes and picks the newspaper
 * and moves to it original place
 */
public class Assignment1Part1 extends KarelProfessional {
    /**
     * Pre-condition: Karel is in the northwest corner of his house
     * Result: Karel picked up a newspaper on the doorstep
     * and returned to the starting point
     */
    @Override
    public void run() throws Exception {
        walkToTheNewspaper();
        pickBeeper();
        returnBack();
    }

    /**
     * Pre-condition: Karel is in the northwest corner of his house
     * Result: Karel is on the threshold of the house
     * (where the newspaper lies)
     */
    private void walkToTheNewspaper() throws Exception {
        stepToTheRight();
        moveToTheBeeper();
    }

    /**
     * Pre-condition: Karel picked the newspaper,
     * he is on the threshold of the house
     * Result: Karel returned to the starting point
     */
    private void returnBack() throws Exception {
        turnAround();
        moveToTheWall();
        turnRight();
        move();
    }
}
