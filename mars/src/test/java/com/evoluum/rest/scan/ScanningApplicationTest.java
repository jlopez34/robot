package com.evoluum.rest.scan;

import com.evoluum.rest.scan.model.Position;
import com.evoluum.rest.scan.service.ScanningService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ScanningApplicationTest {

    @Autowired
    ScanningService scanningService;

    @DisplayName("Test method execute instruction MMRMMRMM")
    @Test
    void testRightMovement() {
        Position expectedPosition = new Position("2","0","S");
        assertEquals(expectedPosition.toString(), scanningService.executeInstruction("MMRMMRMM").toString());
    }

    @DisplayName("Test method execute instruction MML")
    @Test
    void testLeftMovement() {
        Position expectedPosition = new Position("0","2","W");
        assertEquals(expectedPosition.toString(), scanningService.executeInstruction("MML").toString());
    }

    @DisplayName("Test method execute instruction AAA")
    @Test
    void testInvalidMovement() {
        Position expectedPosition = new Position("0","2","W");
        assertEquals(null, scanningService.executeInstruction("AAA"));
    }

    @DisplayName("Test method execute instruction MMMMMMMMMMMMMMMMMMMM")
    @Test
    void testInvalidPosition() {
        Position expectedPosition = new Position("0","2","W");
        assertEquals(null, scanningService.executeInstruction("MMMMMMMMMMMMMMMMMMMM"));
    }
}