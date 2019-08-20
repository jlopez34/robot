package com.evoluum.rest.scan.controller;


import com.evoluum.rest.scan.model.Position;
import com.evoluum.rest.scan.service.ScanningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ScanningController class
 *
 * @author Jaime Lopez
 * @Since 1.0.0
 */

@RestController
@RequestMapping(path = "/rest/mars")
@Api(value = "Scanning micro service This API is used to scan new plants around the space")
public class ScanningController {

    private static final Logger logger = LoggerFactory.getLogger(ScanningController.class);

    @Autowired
    private ScanningService service;

    public ScanningController(ScanningService service) {
        this.service = service;
    }

    @PostMapping("/")
    @ApiOperation(value = "Execute Instructions", notes = "Return final position of the scanning robots")
    public @ResponseBody ResponseEntity<String> executeInstruction(@RequestBody String instruction) {
        logger.info("Consuming executeInstruction");
        HttpStatus status;
        Position position = service.executeInstruction(instruction);
        if (position != null)
            status = HttpStatus.OK;
        else
            status = HttpStatus.CREATED;

        System.out.println("Final Position Robot:  " + (position != null ? position.toString() : "Error"));
        return new ResponseEntity<>("POST Response " + status.toString(), status);
    }

}
