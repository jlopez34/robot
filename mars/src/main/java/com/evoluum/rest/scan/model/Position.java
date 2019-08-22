package com.evoluum.rest.scan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Current position where could be the scanning robot.")
public class Position {

    @ApiModelProperty(notes = "Position over X axis ")
    private String xLocation;
    @ApiModelProperty(notes = "Position over Y axis")
    private String yLocation;
    @ApiModelProperty(notes = "Look point robot camera")
    private String focus;
    @ApiModelProperty(notes = "Message about final position")
    private String message;

    public Position() {
    }

    public Position(String xLocation, String yLocation, String focus) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.focus = focus;
    }

    public String getXLocation() {
        return xLocation;
    }

    public void setXLocation(String xLocation) {
        this.xLocation = xLocation;
    }

    public String getYLocation() {
        return yLocation;
    }

    public void setYLocation(String yLocation) {
        this.yLocation = yLocation;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "("+xLocation + "," + yLocation + "," + focus +")";
    }
}
