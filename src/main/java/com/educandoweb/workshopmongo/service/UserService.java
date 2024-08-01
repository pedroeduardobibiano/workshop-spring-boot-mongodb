package com.educandoweb.workshopmongo.service;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.dto.UserDTO;
import com.educandoweb.workshopmongo.repository.UserRepository;
import com.educandoweb.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User insert(User user) {
        return repo.save(user);
    }

    public void delete(String id) {
        try {
            if (repo.existsById(id)) {
                repo.deleteById(id);
            } else {
                throw new ObjectNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }


    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }


}
