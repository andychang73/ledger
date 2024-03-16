package com.abstractionizer.ledger.gateway.model.dto;

import java.time.LocalDateTime;

public interface DateRangeQry {

    void setFrom(LocalDateTime from);

    LocalDateTime getFrom();

    void setTo(LocalDateTime to);

    LocalDateTime getTo();
}
