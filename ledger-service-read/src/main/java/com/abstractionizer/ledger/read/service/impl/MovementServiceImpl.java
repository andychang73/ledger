package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.MovementService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.MovementMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<MovementEntity> getMovements(@NonNull final Long entityId) {
        return movementMapper.selectByEntityId(entityId);
    }
}
