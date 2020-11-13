package ee.bcs.valiiit.controller;

import ee.bcs.valiiit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

// Controller is running the program at annotation level only
// annotated with @Controller or @RestController
// @GetMapping, @PostMapping, @PutMapping endpoints
// service injected into controller with @Autowired

@RestController

public class BankController {

    @Autowired
    AccountService accountService;

    // createAccount (accountNr)                                        TEST OK!
    @PostMapping("bank/newAccount")
    public String createAccount(@RequestBody String accountNr,
                                @RequestParam("name") String name,
                                @RequestParam("address") String address) {
        return accountService.createAccount(accountNr, name, address);
    }

    // getAccountBalance (accountNr)                                    TEST OK!
    @GetMapping("bank/checkAccount/{id1}")
    public BigDecimal checkBankAccount(@PathVariable("id1") String accountNr) {
        return accountService.checkBankAccount(accountNr);
    }

    // check all accounts                                               TEST FAIL
    @GetMapping("bank/checkAccounts")
    public List getHistory() {
        return accountService.getHistory();
    }

    // depositMoney (accountNr, money)                                  TEST OK!
    @PutMapping("bank/depositToAccount/{id1}")
    public void depositMoney(@PathVariable("id1") String accountNr,
                             @RequestParam("money") BigDecimal money) {
        accountService.depositMoney(accountNr, money);
    }

    // withdrawMoney (accountMoney, money))                             TEST OK!
    @PutMapping("bank/withdrawFromAccount/{id1}")
    public void withdrawMoney(@PathVariable("id1") String accountNr,
                              @RequestParam("money") BigDecimal money) {
        accountService.withdrawMoney(accountNr, money);
    }

    // transferMoney (fromAccount), toAccount, money                    TEST OK!
    @PutMapping("bank/transfer/{id1}/{id2}")
    public void transferMoney(@PathVariable("id1") String fromAccountNr,
                              @PathVariable("id2") String toAccountNr,
                              @RequestParam("money") BigDecimal money) {
        accountService.transferMoney(fromAccountNr, toAccountNr, money);
    }
    // getBalanceHistory(accountNr)                                     DONE, NEEDS TESTING
    @GetMapping("bank/accountHistory/{id1}")
    public List checkHistory(@PathVariable("id1") String fromAccountNr) {
        return accountService.checkHistory(fromAccountNr);
    }

    // createClient(firstName, lastName, .....)
    // muuta createAccount (clientId, accountNr)

}
