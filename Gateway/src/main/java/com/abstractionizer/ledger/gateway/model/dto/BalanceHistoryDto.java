package com.abstractionizer.ledger.gateway.model.dto;

import com.abstractionizer.ledger.gateway.annotation.DateRange;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@DateRange(maxRange = 6)
public class BalanceHistoryDto implements DateRangeQry{

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime from;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime to;
}
