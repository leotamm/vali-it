package ee.bcs.valiiit.controller;

import ee.bcs.valiiit.repo.BankRepo;
import ee.bcs.valiiit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// @GetMapping, @PostMapping, @PutMapping endpoints

@RestController

public class BankController {

    @Autowired  // could be substituted with a constructor
    AccountService accountService;

    @Autowired  // could be substituted with a constructor
    BankRepo bankRepo;

    // for vue testing
    @CrossOrigin
    @GetMapping("register")
    public String register(String email){
        return "OK";
    }

    // for vue testing
    @CrossOrigin
    @PostMapping("register_post")
        public List<User> registerAgain(@RequestBody User user){
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(new User("john", "john@company.com", 33));
        userList.add(new User("jane", "jane@company.com", 34));
        userList.add(new User("jill", "jill@organization.org", 23));
        userList.add(new User("bill", "bill@organization.org", 24));
        return userList;
    }

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

    // check all accounts                                               TEST OK!
    @CrossOrigin
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
    // change createAccount (clientId, accountNr)

}
