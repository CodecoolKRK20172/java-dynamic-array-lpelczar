package com.codecool.dynamicArrayDojo;

import java.util.Arrays;
import java.util.stream.IntStream;

class DynamicIntArray {

    private int[] array;
    private int actualSize = 0;

    DynamicIntArray() {
        int initialSize = 5;
        this.array = new int[initialSize];
    }

    DynamicIntArray(int initialSize) {
        this.array = new int[initialSize];
    }

    void add(int number) {
        if (actualSize < array.length) {
            array[actualSize] = number;
            actualSize++;
        } else {
            this.array = Arrays.copyOf(array, array.length + 1);
            array[actualSize] = number;
            actualSize++;
        }
    }

    void remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] firstHalf = Arrays.copyOfRange(array, 0, index);
        int[] secondHalf = Arrays.copyOfRange(array, index + 1, array.length);
        this.array = IntStream.concat(Arrays.stream(firstHalf), Arrays.stream(secondHalf)).toArray();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int number : array) {
            result.append(" ");
            result.append(number);
        }
        return result.toString();
    }
}
