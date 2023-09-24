package com.onnovacion.onnovacion.domain.accounts.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.onnovacion.onnovacion.domain.accounts.Account;
import com.onnovacion.onnovacion.domain.accounts.dtos.AccountDTO;

@Mapper
public interface AccountMapper {
    
    AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    AccountDTO entityToDTO (Account account);

    Account DTOtoEntity (AccountDTO accountDTO);
}
