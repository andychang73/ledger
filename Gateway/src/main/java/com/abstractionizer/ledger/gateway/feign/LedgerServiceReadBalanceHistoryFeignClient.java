package com.abstractionizer.ledger.gateway.feign;

import com.abstractionizer.ledger.gateway.model.vo.BalanceHistoryVo;
import com.abstractionizer.module.enumeration.AssetType;
import com.abstractionizer.module.response.SuccessResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(contextId = "ledger-service-read-balance-history", name = "ledger-service-read-balance-history", url = "${feign.client.ledger-service-read.url}")
public interface LedgerServiceReadBalanceHistoryFeignClient {

    @GetMapping("/v1/history/balance/asset/{assetType}/entity/{entityId}/account/{accountId}/wallet/{walletId}")
    SuccessResp<List<BalanceHistoryVo>> getBalanceHistory(@PathVariable AssetType assetType, @PathVariable Long entityId, @PathVariable Long accountId, @PathVariable Long walletId,
                                                          @RequestParam LocalDateTime from, @RequestParam LocalDateTime to);
}
