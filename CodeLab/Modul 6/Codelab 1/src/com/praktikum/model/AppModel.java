package com.praktikum.model;

import java.util.Random;

public class AppModel {
    private int targetNumber;
    private int attemptCount;
    private final Random random = new Random();

    public AppModel() {
        generateNewNumber();}

    public void generateNewNumber() {
        targetNumber = random.nextInt(100) + 1;
        attemptCount = 0;}

    public int getTargetNumber() {
        return targetNumber;}

    public int getAttemptCount() {
        return attemptCount;}

    public void incrementAttempt() {
        attemptCount++;}
}
