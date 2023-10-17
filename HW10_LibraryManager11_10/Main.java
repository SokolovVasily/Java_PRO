package org.example.HW_11_10_23LibraryManager;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) { //книги 10 и добавить их лист

        Book bookMastAndMarg = new Book("AA1122", "Master and Margarita", "Michael Bulgakov", "Horror", 2006, true);
        Book bookALittlePrince = new Book("BB1122", "A little prince", "Antoine de Saint-Exupery", "Prose", 2005, true);
        Book bookCatcherInTheRye = new Book("CC1122", "Catcher in the rye", "Jerome D. Salinger", "Prose", 2008, true);
        Book bookAnnaKarenina = new Book("DD1122", "Anna Karenina", " Leo Tolstoy", "Prose", 2009, true);
        Book bookLordTheRings = new Book("EE1122", "The Lord of the Rings", "J. R. R. Tolkien", "Prose", 2001, true);
        Book bookCatch22 = new Book("JJ1122", "Catch-22", "JJoseph Heller", "Prose", 2002, true);
        Book bookTheHobbit = new Book("ZZ1122", "The Hobbit", "J. R. R. Tolkien", "Prose", 2003, true);
        Book bookAliceAdventuresWonderland = new Book("KK1122", "Alice's Adventures in Wonderland ", "Lewis Carroll", "Prose", 2004, true);
        Book bookTreasureIsland = new Book("LL1122", "Treasure Island ", "Robert Louis Stevenson", "Horror", 2005, true);
        Book bookTheGodfather = new Book("MM1122", "The Godfather", "Mario Puzo", "Horror", 2006, true);
        List<Book> bookList = Arrays.asList(
                bookALittlePrince,
                bookCatcherInTheRye,
                bookMastAndMarg,
                bookAnnaKarenina,
                bookLordTheRings,
                bookCatch22,
                bookTheHobbit,
                bookAliceAdventuresWonderland,
                bookTreasureIsland
        );


        LibraryUser libraryUser1 = new LibraryUser("1979", "Alex", "alex.de", 2234707, null, null);
        LibraryUser libraryUser2 = new LibraryUser("1978", "Vano", "vano.de", 2234708, null, null);
        LibraryUser libraryUser3 = new LibraryUser("1977", "Bigus", "bigus.de", 2234709, null, null);
        List<LibraryUser> libraryUserList = Arrays.asList(
                libraryUser1,
                libraryUser2,
                libraryUser3
        );
        LibraryManager libraryManager = new LibraryManager(bookList, libraryUserList);

        System.out.println( libraryManager.listAvailableBooksByGenre("Prose"));
        System.out.println(libraryManager.listUserEmailsWithReservedBooks());
        System.out.println(libraryManager.getLibraryCatalog());
        libraryManager.addBookToLibrary(bookTheGodfather);
        System.out.println(libraryManager.getLibraryCatalog());
        libraryManager.removeBookFromLibrary(bookTheGodfather);
        System.out.println(libraryManager.getLibraryCatalog());
        libraryManager.borrowBook(libraryUser3,bookTreasureIsland);
        System.out.println(libraryManager.getLibraryUsers());
        libraryManager.reserveBook(libraryUser1,bookCatch22);
        System.out.println(libraryManager.getLibraryUsers());
    }
}
