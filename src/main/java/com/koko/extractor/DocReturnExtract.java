package com.koko.extractor;
public class DocReturnExtract
{
    public static TextExtractor getExtractor(String extension)
    {
        switch (extension) {
            case "pdf" -> {return new PdfExtract();}
            case "txt" -> {return new TxtExtract();}
            case "docx" -> {return new DocxExtract();}
            default -> {throw new UnsupportedOperationException();}
                
        }
    }
}