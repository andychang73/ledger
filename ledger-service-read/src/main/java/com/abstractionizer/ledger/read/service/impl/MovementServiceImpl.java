package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.MovementService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.MovementMapper;
import com.abstractionizer.module.exception.BusinessException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import static com.abstractionizer.module.error.Error.CREATE_DATA_FAIL;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementMapper movementMapper;

    public MovementServiceImpl(MovementMapper movementMapper) {
        this.movementMapper = movementMapper;
    }

    @Override
    public void insert(@NonNull final MovementEntity entity) {
        if(movementMapper.insert(entity) != 1){
            throw new BusinessException(CREATE_DATA_FAIL);
        }
    }
}
