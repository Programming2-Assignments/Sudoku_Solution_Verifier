package org.project;

import java.util.Arrays;

public class DuplicateRecord {
    private int value;
    private int[] position ;
    private String type;

    public DuplicateRecord(int value, int[] position, String type) {
        this.value = value;
        this .position=position;
        this.type = type;
    }

    @Override
    public String toString() {
        return "The " + type + "'s duplicate value is: " + value + ", the position is: " + Arrays.toString(position);
    }
}
