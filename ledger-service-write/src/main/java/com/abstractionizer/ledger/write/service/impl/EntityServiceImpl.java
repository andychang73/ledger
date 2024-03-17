package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.model.vo.AccountVo;
import com.abstractionizer.ledger.write.service.EntityService;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.EntityMapper;
import com.abstractionizer.module.exception.DeclineException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.abstractionizer.module.error.Error.ACCOUNT_NOT_FOUND;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityMapper entityMapper;

    public EntityServiceImpl(EntityMapper entityMapper) {
        this.entityMapper = entityMapper;
    }

    @Override
    public AccountVo getAccountOrThrow(@NotNull final Long entityId, @NotNull final Long accountId) {
        return Optional.ofNullable(entityMapper.selectByEntityIdAndAccountId(entityId, accountId))
                .orElseThrow(() -> new DeclineException(ACCOUNT_NOT_FOUND));
    }
}
