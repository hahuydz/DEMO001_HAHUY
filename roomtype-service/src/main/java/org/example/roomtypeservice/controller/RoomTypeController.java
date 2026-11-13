package org.example.roomtypeservice.controller;

import org.example.roomtypeservice.entity.RoomType;
import org.example.roomtypeservice.repository.RoomTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomtypes")
public class RoomTypeController {
    private final RoomTypeRepository repository;

    public RoomTypeController(RoomTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<RoomType> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public RoomType create(@RequestBody RoomType roomType) {
        return repository.save(roomType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
