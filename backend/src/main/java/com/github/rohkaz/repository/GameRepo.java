package com.github.rohkaz.repository;

import com.github.rohkaz.model.GameCardModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends MongoRepository<GameCardModel, String> {

}
