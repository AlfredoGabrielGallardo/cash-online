package com.cashonline.apirest.models.repository;

import com.cashonline.apirest.models.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ILoanRepository extends PagingAndSortingRepository<Loan, Integer> {
    Page<Loan> findLoanByUserId(Integer Id, Pageable pageable);

}
