package com.abstractionizer.ledger.read.factory;

import com.abstractionizer.ledger.read.handler.BalanceHistoryHandler;
import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.model.vo.WalletDetailAndHistoryUpdateDto;
import com.abstractionizer.module.enumeration.AssetType;
import com.abstractionizer.module.exception.BusinessException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.abstractionizer.module.error.Error.DATA_NOT_FOUND;

@Component
public class BalanceHistoryFactory {

    private final Map<AssetType, BalanceHistoryHandler> factory;

    public BalanceHistoryFactory(List<BalanceHistoryHandler> handlers) {
        this.factory = handlers.stream().collect(Collectors.toMap(BalanceHistoryHandler::getAssetType, v -> v));
    }

    public List<BalanceHistoryVo> getBalanceHistory(@NonNull final AssetType assetType, @NonNull final Long entityId, @NonNull final Long accountId,
                                                    @NonNull final Long walletId, @NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {

        return Optional.ofNullable(factory.get(assetType))
                .map(factory -> factory.getBalanceHistoryByDates(entityId, accountId, walletId, from, to))
                .orElseThrow(() -> new BusinessException(DATA_NOT_FOUND));
    }

    public void insertBalanceHistory(@NonNull final WalletDetailAndHistoryUpdateDto dto) {
        Optional.ofNullable(factory.get(dto.getAssetType()))
                .ifPresentOrElse(factory -> factory.insertBalanceHistory(dto),
                        () -> {
                            throw new BusinessException(DATA_NOT_FOUND);
                        });
    }
}
