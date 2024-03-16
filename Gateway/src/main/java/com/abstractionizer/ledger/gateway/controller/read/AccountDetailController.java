package com.abstractionizer.ledger.gateway.controller.read;

import com.abstractionizer.ledger.gateway.feign.LedgerServiceReadAccountDetailFeignClient;
import com.abstractionizer.ledger.gateway.model.vo.AccountDetailVo;
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

    private final LedgerServiceReadAccountDetailFeignClient ledgerServiceReadAccountDetailFeignClient;

    public AccountDetailController(LedgerServiceReadAccountDetailFeignClient ledgerServiceReadAccountDetailFeignClient) {
        this.ledgerServiceReadAccountDetailFeignClient = ledgerServiceReadAccountDetailFeignClient;
    }

    @GetMapping("/{entityId}")
    public SuccessResp<List<AccountDetailVo>> getAccountDetails (@PathVariable Long entityId){
        return ledgerServiceReadAccountDetailFeignClient.getAccountDetail(entityId);
    }
}
