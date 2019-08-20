package com.evoluum.rest.scan.util;

import com.evoluum.rest.scan.model.Cardinal;

import java.util.ArrayList;
import java.util.List;

public abstract class Constants {
    public static final int LIMIT_NORTH = 5;
    public static final int LIMIT_SOUTH = -5;
    public static final int LIMIT_EAST = 5;
    public static final int LIMIT_WEST = -5;

    static List<Cardinal> cardinals = getCardinal();

    private static List<Cardinal> getCardinal() {
        List<Cardinal> cardinals = new ArrayList<>();
        Cardinal northCardinal = new Cardinal("N", "W", "E");
        Cardinal southCardinal = new Cardinal("S", "E", "W");
        Cardinal eastCardinal = new Cardinal("E", "N", "S");
        Cardinal westCardinal = new Cardinal("W", "S", "N");
        cardinals.add(northCardinal);
        cardinals.add(southCardinal);
        cardinals.add(eastCardinal);
        cardinals.add(westCardinal);
        return cardinals;
    }
}
