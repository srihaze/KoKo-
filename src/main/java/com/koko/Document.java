package com.koko;
public class Document
{
    private String fileName;
    private String fileExtension;
    private double fileSize;
    private String filePath;
    public Document(String fileName,String fileExtension,double fileSize,String filePath) 
    {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }
    @Override //we are overriding 
    public String toString()
    {
        return """
               Name      : %s
               Extension : %s
               Size      : %.2f KB
               Path      : %s
               """.formatted(
                       fileName,
                       fileExtension,
                       fileSize / 1024.0,
                       filePath
               );
    }
    public String getFileName()
    {
        return fileName;
    }
}