package it.marcoberri.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "raw")
public class Raw {

	@Id
	private String id;
}
