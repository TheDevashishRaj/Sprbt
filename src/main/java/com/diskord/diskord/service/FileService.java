package com.diskord.diskord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.File;
import com.diskord.diskord.repository.FileRepository;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void uploadFile(File file) {
        fileRepository.save(file);
    }

    public File getFileById(int id) {
        return fileRepository.findById(id);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public void deleteFile(int id) {
        fileRepository.deleteById(id);
    }
}
