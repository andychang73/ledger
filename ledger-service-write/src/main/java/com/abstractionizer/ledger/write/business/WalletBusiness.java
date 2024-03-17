package com.abstractionizer.ledger.write.business;

import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.model.dto.WalletDetailUpdateDto;

import java.math.BigDecimal;

public interface WalletBusiness {

    WalletDetailUpdateDto validateMovementDto(MovementMoveDto dto);

    void transferToTargetWallet(Long sourceWalletId, Long targetWalletId, BigDecimal amount);
}
