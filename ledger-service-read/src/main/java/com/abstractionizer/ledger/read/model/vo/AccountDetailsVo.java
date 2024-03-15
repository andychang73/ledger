package com.abstractionizer.ledger.read.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class AccountDetailsVo {
    private List<AccountDetailVo> accountDetails;
}
