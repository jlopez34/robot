package com.evoluum.rest.scan.service.impl;

import com.evoluum.rest.scan.model.Cardinal;
import com.evoluum.rest.scan.model.Position;
import com.evoluum.rest.scan.service.ScanningService;
import com.evoluum.rest.scan.util.Constants;
import com.evoluum.rest.scan.util.ScanningUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanningServiceImpl implements ScanningService {

    private static final Logger logger = LoggerFactory.getLogger(ScanningServiceImpl.class);

    @Override
    public Position executeInstruction(String instruction) {
        Position finalPosition = new Position();
        try {
            List<String> moves = ScanningUtils.convertStringToList(instruction);
            long diff = moves.stream().filter(move -> !move.equals("L") && !move.equals("M") && !move.equals("R")).count();
            if (diff == 0) {
                //Making moving
                finalPosition = move(moves);
                //Validate final position into the scan area
                if (verifyPosition(finalPosition)) {
                    finalPosition.setMessage("200 OK");
                } else {
                    finalPosition.setMessage("400 Bad Request - Outside the zone");
                }
            } else {
                finalPosition.setMessage("400 Bad Request - Invalid Command");
            }
        } catch (Exception ex) {
            logger.error("Method : executeInstruction :::" + ex.getMessage());
        }
        return finalPosition;
    }

    private Position move(List<String> moves) {
        Position position = new Position();
        int xAxis = 0, yAxis = 0;
        String focus = "N";
        try {
            for (String move : moves) {
                if (move.equals("M")) {
                    switch (focus) {
                        case "N":
                            yAxis++;
                            break;
                        case "S":
                            yAxis--;
                            break;
                        case "W":
                            xAxis--;
                            break;
                        case "E":
                            xAxis++;
                            break;
                    }
                } else {
                    Cardinal cardinal = ScanningUtils.findCardinal(focus);
                    if (cardinal != null) {
                        if (move.equals("R")) {
                            focus = cardinal.getRightRotate();
                        } else {
                            focus = cardinal.getLeftRotate();
                        }
                    } else {
                        throw new Exception("Wrong finder cardinals");
                    }
                }
            }
            position.setFocus(focus);
            position.setxLocation(String.valueOf(xAxis));
            position.setyLocation(String.valueOf(yAxis));
        } catch (Exception ex) {
            logger.error("Method : move :::" + ex.getMessage());
        }
        return position;
    }

    private boolean verifyPosition(Position position) {
        boolean rightLocation = true;
        try {
            int xAxis = Integer.parseInt(position.getxLocation());
            int yAxis = Integer.parseInt(position.getyLocation());
            if ((xAxis > Constants.LIMIT_NORTH || xAxis < Constants.LIMIT_SOUTH) || (yAxis > Constants.LIMIT_EAST || yAxis < -Constants.LIMIT_WEST))
                rightLocation = false;
        } catch (Exception ex) {
            logger.error("Method : verifyPosition :::" + ex.getMessage());
        }

        return rightLocation;
    }


}