package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.model.dto.ModifyAccountDetailStateDto;
import com.abstractionizer.ledger.read.model.vo.AccountAndWalletDetailVo;

import java.util.List;

public interface AccountDetailService {
    void modifyState(ModifyAccountDetailStateDto dto);

    List<AccountAndWalletDetailVo> getAccountAndWalletDetails(Long entityId);
}
