package com.abstractionizer.ledger.gateway.controller.read;

import com.abstractionizer.ledger.gateway.feign.LedgerServiceReadBalanceHistoryFeignClient;
import com.abstractionizer.ledger.gateway.model.dto.BalanceHistoryDto;
import com.abstractionizer.ledger.gateway.model.vo.BalanceHistoryVo;
import com.abstractionizer.module.enumeration.AssetType;
import com.abstractionizer.module.response.SuccessResp;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/history/balance")
public class BalanceHistoryController {

    private final LedgerServiceReadBalanceHistoryFeignClient balanceHistoryFeignClient;

    public BalanceHistoryController(LedgerServiceReadBalanceHistoryFeignClient balanceHistoryFeignClient) {
        this.balanceHistoryFeignClient = balanceHistoryFeignClient;
    }

    @Operation(summary = "Get a balance history of different wallets within 6 month range")
    @GetMapping("/asset/{assetType}/entity/{entityId}/account/{accountId}/wallet/{walletId}")
    public SuccessResp<List<BalanceHistoryVo>> getBalanceHistory(@PathVariable AssetType assetType, @PathVariable Long entityId, @PathVariable Long accountId, @PathVariable Long walletId,
                                                                 @Valid BalanceHistoryDto dto) {
        return balanceHistoryFeignClient.getBalanceHistory(assetType, entityId, accountId, walletId, dto.getFrom(), dto.getTo());
    }
}
