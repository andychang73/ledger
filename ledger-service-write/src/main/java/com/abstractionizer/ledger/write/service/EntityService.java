package com.abstractionizer.ledger.write.service;

import com.abstractionizer.ledger.write.model.vo.AccountVo;

public interface EntityService {

    AccountVo getAccountOrThrow(Long entityId, Long sourceAccountId);
}
