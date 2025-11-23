package com.edifica.bioedifica.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Deserializador flexível que aceita tanto String quanto Array para campos do tipo List<String>
 */
public class FlexibleListDeserializer extends JsonDeserializer<List<String>> {
    
    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        List<String> result = new ArrayList<>();
        
        if (node.isArray()) {
            // Se for array, processa normalmente
            for (JsonNode element : node) {
                result.add(element.asText());
            }
        } else if (node.isTextual()) {
            // Se for string simples, adiciona como único elemento
            result.add(node.asText());
        } else if (node.isNull()) {
            // Se for null, retorna lista vazia
            return result;
        }
        
        return result;
    }
}
