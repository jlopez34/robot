package com.evoluum.rest.scan.service;

import com.evoluum.rest.scan.model.Position;

public interface ScanningService {

   Position executeInstruction(String instruction);

}
