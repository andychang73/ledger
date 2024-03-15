package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.service.AssetService;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.AssetMapper;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetMapper assetMapper;

    public AssetServiceImpl(AssetMapper assetMapper) {
        this.assetMapper = assetMapper;
    }
}
