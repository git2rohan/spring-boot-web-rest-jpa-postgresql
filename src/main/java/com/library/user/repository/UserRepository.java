package com.library.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.user.Borrower;

@Repository
public interface UserRepository extends JpaRepository<Borrower, Integer>{

}
