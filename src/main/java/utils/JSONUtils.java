package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.common.mapper.TypeRef;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JSONUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String,Object> getJsonDataAsMap(String jsonFileName) throws IOException {

        String completeJsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        Map<String,Object> data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>(){});

        return data;


    }

}
