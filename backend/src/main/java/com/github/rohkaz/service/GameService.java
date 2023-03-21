package com.github.rohkaz.service;

import com.github.rohkaz.repository.GameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GameService {

    private final GameRepo gameRepo;
    private final IdGenerator idGenerator;

}
