import java.util.*;

public class LibraryMap {
    private Map<String, String> books = new HashMap<>(); // ключ = название, значение = автор

    public void addBook(String title, String author) {
        books.put(title, author);
    }

    public void removeBook(String title) {
        books.remove(title);
    }

    public String findAuthor(String title) {
        return books.get(title);
    }

    public void printBooks() {
        System.out.println(books);
    }

    public List<String> findBooksByAuthor(String author) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : books.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(author)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<String> findBooksByKeyword(String keyword) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : books.entrySet()) {
            if (entry.getKey().contains(keyword)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
