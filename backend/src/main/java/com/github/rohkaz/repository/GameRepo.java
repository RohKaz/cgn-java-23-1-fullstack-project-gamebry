package com.github.rohkaz.repository;

import com.github.rohkaz.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepo extends MongoRepository<Game, String> {
}
