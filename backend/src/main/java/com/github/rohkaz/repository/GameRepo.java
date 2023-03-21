package com.github.rohkaz.repository;

import com.github.rohkaz.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends MongoRepository<Game, String> {
}
