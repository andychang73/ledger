package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.service.MovementService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.MovementMapper;
import com.abstractionizer.module.enumeration.MovementState;
import com.abstractionizer.module.exception.BusinessException;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        return MovementEntity.builder()
                .entityId(dto.getEntityId())
                .sourceAccountId(dto.getSourceAccountId())
                .targetAccountId(dto.getTargetAccountId())
                .sourceWalletId(dto.getSourceWalletId())
                .targetWalletId(dto.getTargetWalletId())
                .amount(dto.getAmount())
                .state(movementState)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
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
    @Override
    public void updateEntityRequiresNew(@NonNull final MovementEntity movement) {
        movementMapper.updateById(movement);
    }
}
