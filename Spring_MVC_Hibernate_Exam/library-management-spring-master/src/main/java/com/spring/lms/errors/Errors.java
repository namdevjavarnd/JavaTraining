package com.spring.lms.errors;

public class Errors {

    
    public static String getISBNNotFoundErrorPage(String isbn) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sorry, the requested book");
        sb.append(" with ISBN ");
        sb.append(isbn);
        sb.append(" does not exist.");
        return sb.toString();
    }

    
    public static String bookDetailsNotFound(String isbn){
        StringBuilder sb = new StringBuilder();
        sb.append("Sorry, the requested book");
        sb.append(" with ISBN ");
        sb.append(isbn);
        sb.append(" was not found by the GData API.");
        return sb.toString();
    }

   
    public static String getDeleteNotAllowedErrorPage(final String entityMain, final String entityOther, int mainEntityID) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sorry, the deletion of ");
        sb.append(entityMain);
        sb.append(" with ID ");
        sb.append(mainEntityID);
        sb.append(" is not allowed, since there are still ");
        sb.append(entityOther);
        sb.append("s assigned to it.");
        return generatePage(sb.toString());
    }

    
    public static String getDuplicateKeyNotAllowedErrorPage(String isbn) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sorry, ISBN number ");
        sb.append(isbn);
        sb.append(" already exists. Duplicate not allowed.");
        return generatePage(sb.toString());
    }

   
    private static String generatePage(String errorString) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<title>Group 2: Error Page</title>");
        sb.append("<body>");
        sb.append(errorString);
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
}