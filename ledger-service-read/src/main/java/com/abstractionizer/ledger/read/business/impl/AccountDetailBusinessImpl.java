package com.abstractionizer.ledger.read.business.impl;

import com.abstractionizer.ledger.read.business.AccountDetailBusiness;
import com.abstractionizer.ledger.read.model.vo.AccountAndWalletDetailVo;
import com.abstractionizer.ledger.read.model.vo.AccountDetailVo;
import com.abstractionizer.ledger.read.model.vo.WalletDetailVo;
import com.abstractionizer.ledger.read.service.AccountDetailService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountDetailBusinessImpl implements AccountDetailBusiness {

    private final AccountDetailService accountDetailService;

    public AccountDetailBusinessImpl(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }

    @Override
    public List<AccountDetailVo> getAccountDetails(@NonNull final Long entityId) {

        List<AccountAndWalletDetailVo> accountAndWalletDetails = accountDetailService.getAccountAndWalletDetails(entityId);

        return accountAndWalletDetails.stream()
                .collect(Collectors.groupingBy(AccountAndWalletDetailVo::getAccountId))
                .values()
                .stream()
                .map(details ->{

                    AccountAndWalletDetailVo accountAndWallet = details.iterator().next();

                    AccountDetailVo accountDetail = AccountDetailVo.builder()
                            .accountId(accountAndWallet.getAccountId())
                            .state(accountAndWallet.getState())
                            .walletDetails(new ArrayList<>())
                            .build();

                    details.stream()
                            .filter(detail -> Objects.nonNull(detail.getWalletId()))
                            .map(detail -> WalletDetailVo.builder()
                                    .walletId(detail.getWalletId())
                                    .assetType(detail.getAssetType())
                                    .assetCode(detail.getAssetCode())
                                    .assetName(detail.getAssetName())
                                    .balance(detail.getBalance())
                                    .build())
                            .forEach(accountDetail.getWalletDetails()::add);

                    return accountDetail;
                }).collect(Collectors.toList());
    }
}
