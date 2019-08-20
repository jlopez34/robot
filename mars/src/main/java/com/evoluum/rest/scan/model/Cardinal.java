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


    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getLeftRotate() {
        return leftRotate;
    }

    public void setLeftRotate(String leftRotate) {
        this.leftRotate = leftRotate;
    }

    public String getRightRotate() {
        return rightRotate;
    }

    public void setRightRotate(String rightRotate) {
        this.rightRotate = rightRotate;
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
