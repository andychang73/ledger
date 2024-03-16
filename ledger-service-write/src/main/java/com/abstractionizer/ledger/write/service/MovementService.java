package com.abstractionizer.ledger.write.service;

import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;

public interface MovementService {
    MovementEntity insert(MovementEntity movement);
}
