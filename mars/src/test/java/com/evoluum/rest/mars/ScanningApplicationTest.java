package com.evoluum.rest.mars;

import com.evoluum.rest.scan.controller.ScanningController;
import com.evoluum.rest.scan.service.ScanningService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class ScanningApplicationTest {

    @Mock
    private ScanningService scanningService;

    @InjectMocks
    private ScanningController scanningController = new ScanningController(scanningService);

    @DisplayName("Test Mock get all posting")
    @Test
    void testGetPostings() {
        assertEquals("Wrong Test", "(2,0,S)", scanningController.executeInstruction("MMRMMRMM"));
    }


}
