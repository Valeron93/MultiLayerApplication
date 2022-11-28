package com.valeron.lab4.dao;

import com.valeron.lab4.model.SolveResult;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileRepository implements SimpleRepository<SolveResult>, Closeable {

    @Value("${data.path}")
    private String filePath;

    private BufferedWriter writer;
    private List<SolveResult> savedResults;


    @PostConstruct
    void init() throws IOException {
        savedResults = new ArrayList<>();

        File file = new File(filePath);


        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file");
            }
        }

        if (!file.canRead() || !file.canWrite()) {
            throw new IOException("Failed to open " + filePath + " for reading and writing");
        }

        try (var reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                savedResults.add(SolveResult.deserialize(line));
            }
        }

        writer = new BufferedWriter(new FileWriter(file, true));
    }

    @Override
    public int put(SolveResult element) {

        final int index = savedResults.size();

        savedResults.add(element);
        try {
            writer.write(element.serialize());
            writer.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return index;
    }

    @Override
    public Optional<SolveResult> get(int id) {
        if (id < savedResults.size()) {
            return Optional.of(savedResults.get(id));
        }

        return Optional.empty();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
