package org.example.roomservice.controller;

import org.example.roomservice.entity.Room;
import org.example.roomservice.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Room> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Room create(@RequestBody Room room) {
        return repository.save(room);
    }
}
