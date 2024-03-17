package com.abstractionizer.ledger.gateway.controller.read;

import com.abstractionizer.ledger.gateway.entity.MovementEntity;
import com.abstractionizer.ledger.gateway.feign.LedgerServiceReadMovementFeignClient;
import com.abstractionizer.module.response.SuccessResp;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/movement")
public class MovementController {

    private final LedgerServiceReadMovementFeignClient movementFeignClient;

    public MovementController(LedgerServiceReadMovementFeignClient movementFeignClient) {
        this.movementFeignClient = movementFeignClient;
    }

    @Operation(summary = "Get a list of movements in descending order")
    @GetMapping("/entity/{entityId}")
    public SuccessResp<List<MovementEntity>> getMovements(@PathVariable @NotNull Long entityId){
        return movementFeignClient.getMovements(entityId);
    }
}
