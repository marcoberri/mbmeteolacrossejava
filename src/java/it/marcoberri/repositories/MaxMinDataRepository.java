package it.marcoberri.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.marcoberri.model.MaxMinData;

@Repository
public interface MaxMinDataRepository extends MongoRepository<MaxMinData, String> {

	MaxMinData findByTs(String ts, Sort sort);

}