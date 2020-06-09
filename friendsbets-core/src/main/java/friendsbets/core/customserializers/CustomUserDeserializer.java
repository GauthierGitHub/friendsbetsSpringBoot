package friendsbets.core.customserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import friendsbets.core.models.User;

/**
 * Made because Jackson can't deserialize directly array of long.
 * https://github.com/FasterXML/jackson-databind/issues/2245
 * 
 * @author barbet
 *
 */
public class CustomUserDeserializer extends StdDeserializer<Set<User>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomUserDeserializer() {
		this(null);
	}

	public CustomUserDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Set<User> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		Logger.getLogger(getClass()).info("		!! CUSTOM DESERIALIZER !!");
		JsonNode node = jp.getCodec().readTree(jp);
		Set<User> result = new HashSet<>();
		for (JsonNode jsonNodeId : node) {
			result.add(new User(jsonNodeId.asLong()));
		}

		return result;
	}

}