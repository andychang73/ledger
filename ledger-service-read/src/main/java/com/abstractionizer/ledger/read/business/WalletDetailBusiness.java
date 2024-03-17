package com.abstractionizer.ledger.read.business;

import com.abstractionizer.ledger.read.model.vo.WalletDetailAndHistoryUpdateDto;

public interface WalletDetailBusiness {

    void updateWalletBalanceAndInsertBalanceHistory(WalletDetailAndHistoryUpdateDto dto);
}
