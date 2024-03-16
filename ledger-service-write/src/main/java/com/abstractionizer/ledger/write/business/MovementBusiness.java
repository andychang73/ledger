package com.abstractionizer.ledger.write.business;

import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;

public interface MovementBusiness {

    void move(MovementMoveDto dto);
}
