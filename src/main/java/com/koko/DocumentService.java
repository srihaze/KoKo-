package com.koko;
import java.io.File;
import java.util.ArrayList;

import com.koko.extractor.DocReturnExtract;
import com.koko.extractor.TextExtractor;
public class DocumentService
{   private ArrayList<Document> documents = new ArrayList<>();
    public Document importDocument(String filepath)
    {
        File file;
        file = new File(filepath);
        TextExtractor extractor;
        if(!file.exists())
        {   
            System.out.println("File does not exist !");
            return  null;
        }
        if(!file.isFile())
        {
            System.out.println("Path is given is not a file !");
            return null;
        }
        String fileName = file.getName();
        String fileExtension = "";
        int dot = fileName.lastIndexOf('.');
        if(dot > 0 && dot < fileName.length() - 1)
        {
            fileExtension = fileName.substring(dot + 1);
        }
        
        if(!"pdf".equals(fileExtension) && !"docx".equals(fileExtension) && !"txt".equals(fileExtension))
        {
            System.out.println("Unsupported Document Type");
            return null;
        }
            Document document = new Document(fileName, fileExtension, file.length(), file.getAbsolutePath());
            documents.add(document);
            extractor = DocReturnExtract.getExtractor(fileExtension);
            extractor.extract(file);
            return document;
    }
    public void  listdocuments()
    {
        if(documents.isEmpty())
        {
            System.out.println("No documents imported.");
            return;
        }
        int i = 1;
        System.out.println("Imported Documents");
        for(Document document:documents )
        {
            System.out.println(i + ". " + document.getFileName());
            i++;
        }

    }
    public void viewDocument(int documentNumber)
    {
    
        if(documentNumber - 1 < 0 || documentNumber - 1 > documents.size() - 1)
        {
            System.out.println("Invalid document number");
            return;
        }
        Document document = documents.get(documentNumber-1);
        System.out.println(document);
    }
    public void deleteDocument(int documentNumber)
    {
    
        if(documentNumber - 1 < 0 || documentNumber - 1 > documents.size() - 1)
        {
            System.out.println("Invalid document number");
            return;
        }
        Document document = documents.remove(documentNumber - 1);
        System.out.println(document.getFileName() + " deleted successfully.");
    }
}
