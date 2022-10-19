package com.sap.school.sae.service;

import com.sap.school.sae.model.UserModel;
import com.sap.school.sae.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public List<UserModel> getAll() {
        return repository.findAll();
    }

    public Optional<UserModel> get(final Integer id) {
        return repository.findById(id);
    }

    public UserModel create(final UserModel userModel) {
        if (userModel.getId() == null) {
            return repository.save(userModel);
        }

        throw new IllegalArgumentException("ID already set");
    }

    public UserModel update(final Integer id, final UserModel userModel) {
        if (userModel.getId() != null && userModel.getId().equals(id)) {
            return repository.save(userModel);
        }

        throw new IllegalArgumentException("Wrong id");
    }

    public void delete(final Integer id) {
        repository.deleteById(id);
    }
}
