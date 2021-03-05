package br.com.deliver.testepratico.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

    public static String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
    
	public static String readJsonFile(final String filePath) throws IOException {
		try {
			final File input = new ClassPathResource(filePath).getFile();
			return new String(Files.readAllBytes(Paths.get(input.getPath())));
		} catch (IOException e) {
			throw e;
		}
	}
}
