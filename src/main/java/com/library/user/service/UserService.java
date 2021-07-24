package com.library.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.user.Borrower;
import com.library.user.exception.UserAlreadyExistsException;
import com.library.user.exception.UserNotFoundException;
import com.library.user.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	//GET
	public List<Borrower> findAll()
	{
		if(userRepo.findAll().equals(null))
			throw new UserNotFoundException();
		return userRepo.findAll();
	}
	
	//GET
	public Borrower findById(int id)
	{
		if(!userRepo.existsById(id))
			throw new UserNotFoundException();
		return userRepo.findById(id).get();
	}
	
	//POST
	public Borrower save(Borrower borrower)
	{
		if(!userRepo.existsById(borrower.getUserId()))
			return userRepo.save(borrower);
		throw new UserAlreadyExistsException();
	}
	
	//PUT
	public Borrower update(Borrower borrower)
	{
		if(!userRepo.existsById(borrower.getUserId()))
			throw new UserNotFoundException();
		return userRepo.save(borrower);
	}
	
	//DELETE
	public void delete(Borrower borrower)
	{
		if(!userRepo.existsById(borrower.getUserId()))
			throw new UserNotFoundException();
		userRepo.delete(borrower);
	}

}
