package com.evoluum.rest.scan.model;

public class Cardinal {

    private String initial;
    private String leftRotate;
    private String rightRotate;

    public Cardinal(String initial, String leftRotate, String rightRotate) {
        this.initial = initial;
        this.leftRotate = leftRotate;
        this.rightRotate = rightRotate;
    }

    public String getInitial() {
        return initial;
    }

    public String getLeftRotate() {
        return leftRotate;
    }
    public String getRightRotate() {
        return rightRotate;
    }

   @Override
    public String toString() {
        return "Cardinal{" +
                "initial='" + initial + '\'' +
                ", leftRotate='" + leftRotate + '\'' +
                ", rightRotate='" + rightRotate + '\'' +
                '}';
    }
}
