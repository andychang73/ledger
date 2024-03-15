package com.abstractionizer.ledger.write.business;

import com.abstractionizer.ledger.write.model.dto.ModifyAccountStateDto;
public interface AccountBusiness {
    void modifyAccountState(ModifyAccountStateDto dto);
}
