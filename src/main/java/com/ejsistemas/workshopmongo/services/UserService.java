package com.ejsistemas.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejsistemas.workshopmongo.domain.User;
import com.ejsistemas.workshopmongo.dto.UserDTO;
import com.ejsistemas.workshopmongo.repository.UserRepository;
import com.ejsistemas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id){
		User user = repo.findOne(id);
		if(user == null){
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return user;
		
	}
	
	public User insert(User obj){
		return repo.insert(obj);
	}
	
	public User fromDto(UserDTO objDto){
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
