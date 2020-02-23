package com.serndesign.dataStructureLearning.utils;

public class Strings {

    public enum Lean {
        START,
        END
    }

    public static String center(String value, int targetLength, Lean lean) {
        return center(value, targetLength, lean, ' ');
    }

    private static String center(String value, int targetLength, Lean lean, char pad) {

        if (targetLength < 1) {
            throw new IllegalArgumentException("Cannot center something into less than one space.");
        }

        int sourceLength = value.length();

        if (sourceLength == targetLength) {
            return value;
        }

        int paddingToAdd = targetLength - sourceLength;
        int half = paddingToAdd / 2;
        String spad = Character.toString(pad);
        String padding = spad.repeat(half);
        String startExtra = "";
        String endExtra = "";

        if (paddingToAdd % 2 == 1) {
            if (lean == Lean.START) {
                endExtra = spad;
            } else {
                startExtra = spad;
            }
        }

        return padding + startExtra + value + endExtra + padding;
    }
}
