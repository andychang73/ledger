package com.abstractionizer.ledger.gateway.feign;

import com.abstractionizer.ledger.gateway.entity.MovementEntity;
import com.abstractionizer.module.response.SuccessResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(contextId = "ledger-service-read-movement", name = "ledger-service-read-movement", url = "${feign.client.ledger-service-read.url}")
public interface LedgerServiceReadMovementFeignClient {

    @GetMapping("/v1/movement/entity/{entityId}")
    SuccessResp<List<MovementEntity>> getMovements(@PathVariable Long entityId);
}
