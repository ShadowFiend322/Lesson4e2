import java.util.ArrayList;
import java.util.Collections;

class StringStorage {
    private ArrayList<String> strings;

    public StringStorage() {
        strings = new ArrayList<>();
    }

    public void add(String str) {
        strings.add(str);
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                if (strings.get(i).length() > strings.get(j).length()) {
                    String temp = strings.get(i);
                    strings.set(i, strings.get(j));
                    strings.set(j, temp);
                }
            }
        }
    }

    public String getMax() {
        if (strings.size() == 0) {
            return null;
        }
        return strings.get(strings.size() - 1);
    }

    public double getAverageLength() {
        if (strings.size() == 0) {
            return 0;
        }
        int totalLength = 0;
        for (String str : strings) {
            totalLength += str.length();
        }
        return (double) totalLength / strings.size();
    }

    public void displayStrings() {
        System.out.println(strings);
    }
}

// Тест
public class Main {
    public static void main(String[] args) {
        StringStorage storage = new StringStorage();

        storage.add("apple");
        storage.add("banana");
        storage.add("kiwi");
        storage.add("cherry");
        storage.add("blueberry");

        System.out.println("Все строки в хранилище:");
        storage.displayStrings();
        System.out.println("Самая длинная строка: " + storage.getMax());
        System.out.println("Средняя длина строк: " + storage.getAverageLength());
    }
}
