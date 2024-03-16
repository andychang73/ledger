package com.abstractionizer.ledger.read.model.dto;

import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;
import lombok.Data;

@Data
public class MovementBroadCastDto {
    private MovementEntity movementEntity;
    private Object detail;
}
