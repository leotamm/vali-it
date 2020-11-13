package ee.bcs.valiiit.service;

import ee.bcs.valiiit.controller.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {

        Account account = new Account();
        account.setAccountNr(resultSet.getString("to_account"));
        account.setBalance(resultSet.getBigDecimal("money"));

        return account;
    }
}
