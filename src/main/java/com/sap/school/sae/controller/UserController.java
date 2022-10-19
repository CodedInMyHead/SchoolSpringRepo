package com.sap.school.sae.controller;

import com.sap.school.sae.common.Beautify;
import com.sap.school.sae.model.UserModel;
import com.sap.school.sae.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final Beautify beautifier;

    public UserController(final UserService service, Beautify beautifier) {
        this.service = service;
        this.beautifier = beautifier;
    }

    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok(beautifier.getAllUsers(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getSingle(@PathVariable("id") final int id) {
        return ResponseEntity.of(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(@PathVariable("id") final Integer id, @RequestBody final UserModel userModel) {
        return ResponseEntity.ok(service.update(id, userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> delete(@PathVariable("id") final Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<UserModel> post(@RequestBody final UserModel userModel) {
        return ResponseEntity.ok(service.create(userModel));
    }

}
