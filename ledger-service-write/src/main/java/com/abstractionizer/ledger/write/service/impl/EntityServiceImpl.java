package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.service.EntityService;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.EntityMapper;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityMapper entityMapper;

    public EntityServiceImpl(EntityMapper entityMapper) {
        this.entityMapper = entityMapper;
    }
}
