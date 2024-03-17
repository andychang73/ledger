package com.abstractionizer.ledger.write.business;

import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.model.dto.WalletDetailUpdateDto;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;

import java.math.BigDecimal;

public interface WalletBusiness {

    WalletDetailUpdateDto validateMovement(MovementMoveDto dto);
    WalletDetailUpdateDto validateMovement(MovementEntity movement);

    WalletDetailUpdateDto validateMovement(Long entityId, Long sourceAccountId, Long targetAccount, Long sourceWalletId, Long targetWalletId, BigDecimal amount);

    // todo need it
    WalletDetailUpdateDto checkFundAndGetDetail(BigDecimal newAmount, MovementEntity movement);

    void transferToTargetWallet(Long sourceWalletId, Long targetWalletId, BigDecimal amount);


}
