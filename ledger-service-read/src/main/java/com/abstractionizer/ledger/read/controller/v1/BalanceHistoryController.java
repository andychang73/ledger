package com.abstractionizer.ledger.read.controller.v1;

import com.abstractionizer.ledger.read.factory.BalanceHistoryFactory;
import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.module.enumeration.AssetType;
import com.abstractionizer.module.response.SuccessResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/v1/history/balance")
public class BalanceHistoryController {

    private final BalanceHistoryFactory balanceHistoryFactory;

    public BalanceHistoryController(BalanceHistoryFactory balanceHistoryFactory) {
        this.balanceHistoryFactory = balanceHistoryFactory;
    }

    @GetMapping("/asset/{assetType}/entity/{entityId}/account/{accountId}/wallet/{walletId}")
    public SuccessResp<List<BalanceHistoryVo>> getBalanceHistory(@PathVariable AssetType assetType, @PathVariable Long entityId, @PathVariable Long accountId, @PathVariable Long walletId,
                                                                 @RequestParam LocalDateTime from, @RequestParam LocalDateTime to){
        return new SuccessResp<>(balanceHistoryFactory.getBalanceHistory(assetType, entityId, accountId, walletId, from, to));
    }
}
