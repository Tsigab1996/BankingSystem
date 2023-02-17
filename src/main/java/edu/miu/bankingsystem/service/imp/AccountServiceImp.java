package edu.miu.bankingsystem.service.imp;

import edu.miu.bankingsystem.domian.Account;
import edu.miu.bankingsystem.domian.Transaction;
import edu.miu.bankingsystem.repository.AccountRepo;
import edu.miu.bankingsystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {
    private final AccountRepo accountRepo;



    public AccountServiceImp(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAnAccountByID(long id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public void saveAnAccount(Account account) {
     accountRepo.save(account);
    }

    @Override
    public void deleteAnAccount(long id) {
     accountRepo.deleteById(id);
    }

    @Override
    public Account updateAnAccount(long id, Account account) {
     Account a= getAnAccountByID(id);
     a.setBalance(account.getBalance());
     Account acct= accountRepo.save(a);
     return acct;
    }

}
