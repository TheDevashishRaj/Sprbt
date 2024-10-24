package com.diskord.diskord.model;

public class File {
    private int fileId;
    private byte[] fileData; // Use byte[] to hold binary data
    private String fileType;
    private int size;

    public File() {}

    public File(int fileId, byte[] fileData, String fileType, int size) {
        this.fileId = fileId;
        this.fileData = fileData;
        this.fileType = fileType;
        this.size = size;
    }

    public int getFileId() {
        return fileId;
    }
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
    public byte[] getFileData() {
        return fileData;
    }
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
}
