package com.abstractionizer.ledger.read.business;

import com.abstractionizer.ledger.read.model.vo.AccountDetailVo;

import java.util.List;

public interface AccountDetailBusiness {

    List<AccountDetailVo> getAccountDetails(Long entityId);
}
