package com.abstractionizer.ledger.gateway.feign;


import com.abstractionizer.ledger.gateway.model.vo.AccountDetailVo;
import com.abstractionizer.module.response.SuccessResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(contextId = "ledger-service-read-account-detail", name = "ledger-service-read-account-detail", url = "${feign.client.ledger-service-read.url}")
public interface LedgerServiceReadAccountDetailFeignClient {

    @GetMapping("/v1/account/detail/{entityId}")
    SuccessResp<List<AccountDetailVo>> getAccountDetail(@PathVariable Long entityId);
}
