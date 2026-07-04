package com.koko;
import java.util.Scanner;

public class Main{
    public static void main(String[] args)
    {   
        System.out.println("==========================");
        System.out.println("         Koko CLI         ");
        System.out.println("==========================");
        System.out.println("Welcome!");

        try (Scanner sc = new Scanner(System.in)) {
            boolean isUserUsing = true;
            int choice;
            String filePath;
            DocumentService documentService = new DocumentService();
            while (isUserUsing)
            {
                System.out.println("1. Import Documents");
                System.out.println("2. List Documents");
                System.out.println("3. View Documents");
                System.out.println("4. Delete Documents");
                System.out.println("5. Search");
                System.out.println("6. Exit");
                
                System.out.print("Choice: ");
                choice = sc.nextInt();
                switch(choice)
                {
                    case 1 -> {
                        System.out.print("Enter the path: ");
                        sc.nextLine();
                        filePath = sc.nextLine();
                        Document document = documentService.importDocument(filePath);
                        if(document != null)
                        {
                            System.out.println(document);
                        }
                            }
                    case 2 -> {documentService.listdocuments();}
                    case 3 -> {
                        documentService.listdocuments();
                        System.out.print("Enter the document number to view: ");
                        int docNum = sc.nextInt();
                        documentService.viewDocument(docNum);
                        }
                    case 4 -> { 
                        documentService.listdocuments();
                        System.out.print("Enter the document number to delete: ");
                        int docNum = sc.nextInt();
                        documentService.deleteDocument(docNum);}
                    case 5 -> {System.out.println("Search Documents here");}
                    case 6 -> {System.out.println("Exiting...");isUserUsing=false;}
                    default -> {System.out.println("Invalid Choice");}
                }
            }
        }
    }
}