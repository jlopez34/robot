package com.evoluum.rest.scan.util;

import com.evoluum.rest.scan.model.Cardinal;

import java.util.ArrayList;
import java.util.Optional;

public abstract class ScanningUtils {

    public static ArrayList<String> convertStringToList(String str) {
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            stringList.add(String.valueOf(str.charAt(i)));
        }
        return stringList;
    }

    public static Cardinal findCardinal(String nextFocus) {
        Optional<Cardinal> focus = Constants.cardinals.stream()
                .filter(p -> p.getInitial().equals(nextFocus))
                .findFirst();
        return focus.orElse(null);
    }
}
