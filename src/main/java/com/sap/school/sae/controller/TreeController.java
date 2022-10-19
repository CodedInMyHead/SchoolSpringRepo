package com.sap.school.sae.controller;

import com.sap.school.sae.service.TreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreeController {

    @PostMapping("tree/{length}")
    public ResponseEntity<String> setTreeLength(@PathVariable final int length) {
        if (length % 2 == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            TreeService.setLength(length);
            return ResponseEntity.ok(TreeService.getTree());
        }

    }

    @GetMapping("tree")
    public ResponseEntity<String> getTreeLength() {
        return ResponseEntity.ok(TreeService.getTree());
    }
}
