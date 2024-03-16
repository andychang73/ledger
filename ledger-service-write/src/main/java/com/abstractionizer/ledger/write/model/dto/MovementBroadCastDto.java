package com.abstractionizer.ledger.write.model.dto;

import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovementBroadCastDto {
    private MovementEntity movementEntity;
    private Object detail;
}
