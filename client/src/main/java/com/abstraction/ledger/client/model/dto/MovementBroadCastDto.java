package com.abstraction.ledger.client.model.dto;

import com.abstraction.ledger.client.entity.MovementEntity;
import lombok.Data;

@Data
public class MovementBroadCastDto {
    private MovementEntity movementEntity;
    private Object detail;
}
