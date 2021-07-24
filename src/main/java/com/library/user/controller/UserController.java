package com.library.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.user.Borrower;
import com.library.user.service.UserService;

@RestController
public class UserController {
	
private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/borrowers")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Borrower>> getAllBorrower()
	{
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Responded", "MyController");
		return ResponseEntity.accepted().headers(headers).body(userService.findAll());
	}
	
	@GetMapping("/borrowers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Borrower> getBorrower(@PathVariable("id") int id)
	{
		return ResponseEntity
				.ok()
				.header("ResponseHeader", "My Controller")
				.body(userService.findById(id));
	}
	
	@PostMapping("/borrowers")
	@ResponseStatus(HttpStatus.CREATED)
	public  Borrower saveBorrower(@RequestBody Borrower borrower)
	{
		return userService.save(borrower);
	}
	
	@PutMapping("/borrowers")
	@ResponseStatus(HttpStatus.OK)
	public Borrower updateBorrower(@RequestBody Borrower borrower)
	{
		return userService.update(borrower);
	}
	
	@DeleteMapping("/borrowers")
	@ResponseStatus(HttpStatus.OK)
	public String deleteBorrower(@RequestBody Borrower borrower)
	{
		userService.delete(borrower);
		return "Borrower deleted";
	}
	

}
