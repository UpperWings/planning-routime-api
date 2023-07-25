package com.upperwings.planningroutime.api.controllers;

import com.upperwings.planningroutime.api.dtos.UserRecordDto;
import com.upperwings.planningroutime.api.models.UserModel;
import com.upperwings.planningroutime.api.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid UserRecordDto userRecordDto){
        var user = new UserModel(userRecordDto);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
