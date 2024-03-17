package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;

public interface MovementService {

    void upsert(MovementEntity entity);
}
