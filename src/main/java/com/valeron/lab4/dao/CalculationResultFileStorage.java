package com.valeron.lab4.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valeron.lab4.model.CalculationResult;

import java.io.*;
import java.util.*;

public class CalculationResultFileStorage implements SimpleRepository<CalculationResult>, Closeable {

    private final BufferedWriter writer;
    private final Map<Integer, CalculationResult> map;
    private final ObjectMapper objectMapper;


    public CalculationResultFileStorage(File file) throws IOException {
        objectMapper = new ObjectMapper();
        map = new HashMap<>();

        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file");
            }
        }

        if (!file.canRead() || !file.canWrite()) {
            throw new IOException("Failed to open " + file.getAbsolutePath() + " for reading and writing");
        }

        try (var reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                var object = objectMapper.readValue(line, CalculationResult.class);

                map.put(object.getId(), object);
            }
        }

        writer = new BufferedWriter(new FileWriter(file, true));
    }

    @Override
    public int save(CalculationResult element) {


        final int index = map.keySet()
                .stream()
                .mapToInt(x -> x)
                .max()
                .orElse(-1) + 1;

        element.id(index);

        try {
            var json = objectMapper.writeValueAsString(element);

            writer.write(json);
            writer.write('\n');
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        map.put(index, element);

        return index;
    }

    @Override
    public Optional<CalculationResult> get(int id) {
        return Optional.ofNullable(map.getOrDefault(id, null));
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
