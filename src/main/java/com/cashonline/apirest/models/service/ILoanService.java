package com.cashonline.apirest.models.service;

import com.cashonline.apirest.models.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILoanService {

//    CRUD:
    Page<Loan> findAll(Pageable pageable);                         //To find all loans.
    Page<Loan> findLoanByUserId(Integer id, Pageable pageable);    //To find loans by user id.
    Loan findById(int id);                                         //To find a loan by an indicated id.
    Loan save(Loan loan);                                          //To save a created loan.
    void delete(int id);                                           //To delete a loan by an indicated id.

}
