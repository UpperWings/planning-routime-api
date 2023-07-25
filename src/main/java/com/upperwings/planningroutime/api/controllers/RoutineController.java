package com.upperwings.planningroutime.api.controllers;

import com.upperwings.planningroutime.api.dtos.RoutineRecordDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid RoutineRecordDto routineRecordDto){
        System.out.println("chegou");
        return ResponseEntity.ok("Deu boa");
    }
}
