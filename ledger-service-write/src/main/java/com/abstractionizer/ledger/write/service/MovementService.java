package com.abstractionizer.ledger.write.service;

import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.module.enumeration.MovementState;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface MovementService {
    MovementEntity insert(MovementEntity movement);

    MovementEntity getMovementEntity(MovementMoveDto dto, MovementState movementState);

    MovementEntity getMovementEntity(MovementEntity entity, BigDecimal amount, MovementState movementState, String remark);

    MovementEntity getReversedMovement(MovementEntity entity, BigDecimal amount, MovementState movementState, String remark);

    MovementEntity getMovementEntity(Long entityId, Long sourceAccountId, Long targetAccountId, Long sourceWalletId,
                                     Long targetWalletId, BigDecimal amount, MovementState state, LocalDateTime created,
                                     LocalDateTime modifiedAt, String remark);

    MovementEntity selectByIdOrThrow(Long id);

    void updateEntity(MovementEntity movement);
    void updateEntityRequiresNew(MovementEntity movement);
}
