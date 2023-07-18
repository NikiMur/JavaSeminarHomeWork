import java.util.*;

public class Zadanie6 {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "Иванов", "123456789");
        addContact(phoneBook, "Петров", "987654321");
        addContact(phoneBook, "Сидоров", "555555555");
        addContact(phoneBook, "Иванов", "111111111");

        // Вывод телефонной книги, отсортированной по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedContacts = sortContacts(phoneBook);
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    public static List<Map.Entry<String, List<String>>> sortContacts(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());
        return sortedList;
    }
}