package ee.bcs.valiiit.service;

import ee.bcs.valiiit.Account;
import ee.bcs.valiiit.repo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
// service class implements business logic only
// annotated with @Service - it's a bean
// repository class injected with @Autowired

public class AccountService {

    @Autowired
    private NamedParameterJdbcTemplate JdbcTemplate;
    @Autowired
    private BankRepo bankRepo;

    public List getHistory() {
        List allAccounts = bankRepo.getAllAccounts();
        return allAccounts;
    }

    public String createAccount(String accountNr, String name, String address) {
        bankRepo.createNewAccount(accountNr);
        bankRepo.createNewClient(name, address);
        String reply = "Account created, client created";
        return reply;
    }

    public BigDecimal checkBankAccount(String accountNr) {
        BigDecimal getAmount = bankRepo.getBalance(accountNr);
        if (getAmount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("There are no funds on the account");
        } else {
        }
        return getAmount;
    }

    public String depositMoney(String accountNr, BigDecimal money) {
        BigDecimal getAmount = bankRepo.getBalance(accountNr);
        BigDecimal newValue = getAmount.add(money);
        bankRepo.updateBalance(accountNr, money, newValue);
        String type = new String("deposit");
        String fromAccount = new String("Account owner");
        bankRepo.logTransaction(type, money, accountNr, accountNr);
        String replyYes = "Money deposited, new balance: ";
        return replyYes + bankRepo.getBalance(accountNr);
    }

    public String withdrawMoney(String accountNr, BigDecimal money) {
        BigDecimal getAmount = bankRepo.getBalance(accountNr);
        if (money.compareTo(getAmount) > 0) {
            String replyNo = "Denied - insufficient funds";
            return replyNo;
        } else {
            BigDecimal newValue = getAmount.subtract(money);
            bankRepo.updateBalance(accountNr, money, newValue);
            String type = new String("withdrawal");
            String fromAccount = new String("Account owner");
            bankRepo.logTransaction(type, money, accountNr, accountNr);
        }
        String replyYes = "Withdrawal completed, new balance: ";
        return replyYes + bankRepo.getBalance(accountNr);
    }

    public String transferMoney(String fromAccountNr, String toAccountNr, BigDecimal money) {
        BigDecimal getAmount = bankRepo.getBalance(fromAccountNr);
        if (money.compareTo(getAmount) > 0) {
            String replyNo = "Denied - insufficient funds";
            return replyNo;
        } else {
            BigDecimal newValue = getAmount.subtract(money);
            bankRepo.updateBalance(fromAccountNr, money, newValue);
            BigDecimal addAmount = bankRepo.getBalance(toAccountNr);
            BigDecimal newValue2 = addAmount.add(money);
            bankRepo.updateBalance(toAccountNr, money, newValue2);
            String type = new String("transfer");
            String fromAccount = new String("Account owner");
            bankRepo.logTransaction(type, money, fromAccountNr, toAccountNr);
        }
        String replyYes = "Transfer completed";
        return replyYes;
    }

    public List<Account> checkHistory(String fromAccountNr) {
        return bankRepo.checkHistory(fromAccountNr);
    }

}