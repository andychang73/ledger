package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.service.MovementService;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.MovementMapper;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementMapper movementMapper;

    public MovementServiceImpl(MovementMapper movementMapper) {
        this.movementMapper = movementMapper;
    }
}
