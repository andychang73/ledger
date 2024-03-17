package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;

import java.util.List;

public interface MovementService {

    void upsert(MovementEntity entity);

    List<MovementEntity> getMovements(Long entityId);
}
