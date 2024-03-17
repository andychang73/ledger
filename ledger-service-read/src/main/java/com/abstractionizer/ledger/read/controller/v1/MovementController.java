package com.abstractionizer.ledger.read.controller.v1;

import com.abstractionizer.ledger.read.service.MovementService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.module.response.SuccessResp;
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

    private final MovementService movementService;


    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping("/entity/{entityId}")
    public SuccessResp<List<MovementEntity>> getMovements(@PathVariable @NotNull Long entityId){
        return new SuccessResp<>(movementService.getMovements(entityId));
    }
}
