package com.abstractionizer.ledger.write.service;

import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.module.enumeration.MovementState;

public interface MovementService {
    MovementEntity insert(MovementEntity movement);

    MovementEntity getMovementEntity(MovementMoveDto dto, MovementState movementState);

    MovementEntity selectByIdOrThrow(Long id);

    void updateEntity(MovementEntity movement);
    void updateEntityRequiresNew(MovementEntity movement);
}
