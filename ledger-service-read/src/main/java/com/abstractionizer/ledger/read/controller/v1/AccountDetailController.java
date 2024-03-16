package com.abstractionizer.ledger.read.controller.v1;

import com.abstractionizer.ledger.read.business.AccountDetailBusiness;
import com.abstractionizer.ledger.read.model.vo.AccountDetailVo;
import com.abstractionizer.module.response.SuccessResp;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/account/detail")
public class AccountDetailController {

    private final AccountDetailBusiness accountDetailBusiness;

    public AccountDetailController(AccountDetailBusiness accountDetailBusiness) {
        this.accountDetailBusiness = accountDetailBusiness;
    }

    @GetMapping("/{entityId}")
    public SuccessResp<List<AccountDetailVo>> getAccountDetails(@PathVariable Long entityId){
        return new SuccessResp<>(accountDetailBusiness.getAccountDetails(entityId));
    }
}
