package ee.bcs.valiiit.repo;

import ee.bcs.valiiit.controller.Account;
import ee.bcs.valiiit.service.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// repository handles SQL (database) queries only
// annotated with @Repository - it's a bean
// NamedParameterJdbcTemplate injected with @Autowired

@Repository

public class BankRepo {

    @Autowired
    private NamedParameterJdbcTemplate JdbcTemplate;

    public void createNewAccount(String accountNr) {
        String sql = "INSERT INTO account (account_nr, balance) VALUES (:var1, :var2)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("var1", accountNr);
        paramMap.put("var2", BigDecimal.ZERO);
        JdbcTemplate.update(sql, paramMap);
    }

    public void createNewClient(String name, String address) {
        String sql = "INSERT INTO customer (name, address) VALUES (:var1, :var2)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("var1", name);
        paramMap.put("var2", address);
        JdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal getBalance(String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_nr = :accountNr";      // reads account and balance from sql
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        BigDecimal getAmount = JdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        return getAmount;
    }

    public BigDecimal updateBalance(String accountNr, BigDecimal money, BigDecimal newValue) {
        String sql = "UPDATE account SET balance = :var1 WHERE account_nr = :var2";    // writes account and balance back to sql
        Map<String, Object> paramMap = new HashMap<>();
        paramMap = new HashMap<>();
        paramMap.put("var1", newValue);
        paramMap.put("var2", accountNr);
        JdbcTemplate.update(sql, paramMap);
        return newValue;
    }

    public String logTransaction(String type, BigDecimal money, String fromAccountNr, String toAccountNr) { // code service and controller!
        String sql = "INSERT INTO transaction (type, money, from_account, to_account) " +
                "VALUES (:var1, :var2, :var3, :var4)";    // writes account and balance back to sql
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("var1", type);
        paramMap.put("var2", money);
        paramMap.put("var3", fromAccountNr);
        paramMap.put("var4", toAccountNr);
        JdbcTemplate.update(sql, paramMap);
        String replyYes = "Transaction logged";
        return replyYes;
    }

    public List<Account> checkHistory(String fromAccountNr) {
        String sql = "SELECT * FROM transaction WHERE from_account = :var1";
        Map<String, Object> paraMap = new HashMap();
        paraMap.put("var1", fromAccountNr);
        List<Account> result = JdbcTemplate.query(sql, paraMap, new AccountRowMapper());
        return result;
    }
}