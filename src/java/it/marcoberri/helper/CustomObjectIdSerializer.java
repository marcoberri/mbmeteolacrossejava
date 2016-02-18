package it.marcoberri.helper;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomObjectIdSerializer extends JsonSerializer<ObjectId> {

	@Override
	public void serialize(ObjectId value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
		jgen.writeString(value.toHexString());
	}

}