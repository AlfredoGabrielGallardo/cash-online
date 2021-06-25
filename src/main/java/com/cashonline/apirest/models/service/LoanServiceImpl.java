package com.cashonline.apirest.models.service;

import com.cashonline.apirest.models.entity.Loan;
import com.cashonline.apirest.models.repository.ILoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanServiceImpl implements ILoanService {

//    Injection:
    @Autowired
    private ILoanRepository loanRepository;


//    CRUD Implementation:

//    Implementation of find all loans
    @Override
    @Transactional(readOnly = true)
    public Page<Loan> findAll(Pageable pageable) {
        return loanRepository.findAll(pageable);
    }

//    Implementation of find loan with an indicate user id:
    @Override
    @Transactional(readOnly = true)
    public Page<Loan> findLoanByUserId(Integer id, Pageable pageable) {
        return loanRepository.findLoanByUserId(id, pageable);
    }

//    Implementation of find a loan with an indicate id:
    @Override
    @Transactional(readOnly = true)
    public Loan findById(int id) {
        return loanRepository.findById(id).orElse(null);
    }

//    Implementation of save a loan created:
    @Override
    @Transactional
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

//    Implementation of delete a loan with an indicate id:
    @Override
    @Transactional
    public void delete(int id) {
        loanRepository.deleteById(id);
    }

}