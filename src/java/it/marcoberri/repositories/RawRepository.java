package it.marcoberri.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.marcoberri.model.Raw;

@Repository
public interface RawRepository extends MongoRepository<Raw, String> {

	List<Raw> findByTsGreaterThan(Date date, Sort sort);

}
