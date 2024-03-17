package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.MovementService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.MovementMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementMapper movementMapper;

    public MovementServiceImpl(MovementMapper movementMapper) {
        this.movementMapper = movementMapper;
    }

    @Override
    public void upsert(@NonNull final MovementEntity entity) {
        movementMapper.upsert(entity);
    }
}
