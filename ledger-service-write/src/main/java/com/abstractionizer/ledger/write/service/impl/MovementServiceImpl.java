package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.service.MovementService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.MovementMapper;
import com.abstractionizer.module.enumeration.MovementState;
import com.abstractionizer.module.exception.BusinessException;
import lombok.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.abstractionizer.module.error.Error.DATA_NOT_FOUND;
import static com.abstractionizer.module.error.Error.UPDATE_DATA_FAILED;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementMapper movementMapper;

    public MovementServiceImpl(MovementMapper movementMapper) {
        this.movementMapper = movementMapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public MovementEntity insert(@NonNull final MovementEntity entity) {
        movementMapper.insertEntity(entity);
        return entity;
    }

    @Override
    public MovementEntity getMovementEntity(@NonNull final MovementMoveDto dto, @NonNull final MovementState movementState) {
        return getMovementEntity(dto.getEntityId(), dto.getSourceAccountId(), dto.getTargetAccountId(), dto.getSourceWalletId(),
                dto.getTargetWalletId(), dto.getAmount(), movementState, LocalDateTime.now(), LocalDateTime.now(), null);
    }

    @Override
    public MovementEntity getMovementEntity(@NonNull final MovementEntity entity, @NonNull final BigDecimal amount,
                                            @NonNull final MovementState movementState, @Nullable final String remark) {
        return getMovementEntity(entity.getEntityId(), entity.getSourceAccountId(), entity.getTargetAccountId(), entity.getSourceWalletId(),
                entity.getTargetWalletId(), amount, movementState, LocalDateTime.now(), LocalDateTime.now(), remark);
    }

    @Override
    public MovementEntity getReversedMovement(@NonNull final MovementEntity entity, @NonNull final BigDecimal amount,
                                              @NonNull final MovementState movementState, @Nullable final String remark) {
        return getMovementEntity(entity.getEntityId(), entity.getTargetAccountId(), entity.getSourceAccountId(), entity.getTargetWalletId(),
                entity.getSourceWalletId(), amount.negate(), movementState, LocalDateTime.now(), LocalDateTime.now(), remark);
    }

    @Override
    public MovementEntity getMovementEntity(@NonNull final Long entityId, @NonNull final Long sourceAccountId, @NonNull final Long targetAccountId,
                                            @NonNull final Long sourceWalletId, @NonNull final Long targetWalletId, @NonNull final BigDecimal amount,
                                            @NonNull final MovementState state, @NonNull final LocalDateTime created, @NonNull final LocalDateTime modifiedAt,
                                            @Nullable final String remark){
        return MovementEntity.builder()
                .entityId(entityId)
                .sourceAccountId(sourceAccountId)
                .targetAccountId(targetAccountId)
                .sourceWalletId(sourceWalletId)
                .targetWalletId(targetWalletId)
                .amount(amount)
                .state(state)
                .createdAt(created)
                .modifiedAt(modifiedAt)
                .remark(remark)
                .build();
    }


    @Override
    public MovementEntity selectByIdOrThrow(@NonNull final Long id) {
        return Optional.ofNullable(movementMapper.selectById(id))
                .orElseThrow(() -> new BusinessException(DATA_NOT_FOUND));
    }

    @Override
    public void updateEntity(@NonNull final MovementEntity movement) {
        if(movementMapper.updateById(movement) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)

    public void updateEntityRequiresNew(@NonNull final MovementEntity movement) {
        movementMapper.updateById(movement);
    }
}
