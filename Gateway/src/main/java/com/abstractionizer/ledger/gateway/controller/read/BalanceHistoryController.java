package com.abstractionizer.ledger.gateway.controller.read;

import com.abstractionizer.ledger.gateway.feign.LedgerServiceReadBalanceHistoryFeignClient;
import com.abstractionizer.ledger.gateway.model.vo.BalanceHistoryVo;
import com.abstractionizer.module.enumeration.AssetType;
import com.abstractionizer.module.response.SuccessResp;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/history/balance")
public class BalanceHistoryController {

    private final LedgerServiceReadBalanceHistoryFeignClient balanceHistoryFeignClient;

    public BalanceHistoryController(LedgerServiceReadBalanceHistoryFeignClient balanceHistoryFeignClient) {
        this.balanceHistoryFeignClient = balanceHistoryFeignClient;
    }

    @GetMapping("/asset/{assetType}/entity/{entityId}/account/{accountId}/wallet/{walletId}")
    public SuccessResp<List<BalanceHistoryVo>> getBalanceHistory(@PathVariable AssetType assetType, @PathVariable Long entityId, @PathVariable Long accountId, @PathVariable Long walletId,
                                                                 @RequestParam LocalDateTime from, @RequestParam LocalDateTime to) {
        return balanceHistoryFeignClient.getBalanceHistory(assetType, entityId, accountId, walletId, from, to);
    }
}
