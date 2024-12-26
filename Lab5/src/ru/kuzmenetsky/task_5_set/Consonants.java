package ru.kuzmenetsky.task_5_set;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Consonants {
    //чтение текста из файла
    public static String readFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("ошибка при чтении файла: " + e.getMessage());
            return "";
        }
    }

    //извлечение глухих согласных из нечетных слов
    public static Set<Character> extract(String text) {
        //список глухих согласных
        Set<Character> voicelessConsonants = Set.of('п', 'ф', 'к', 'т', 'ш', 'с', 'х', 'ц', 'ч');
        Set<Character> result = new TreeSet<>(); // TreeSet для автоматической сортировки

        //разделяем текст на слова
        String[] words = text.toLowerCase().replaceAll("[^а-яё\\s]", "").split("\\s+");

        //проходим по словам с учетом нечетных индексов
        for (int i = 1; i <= words.length; i++) {
            if (i % 2 != 0) { //нечетные слова
                String word = words[i - 1]; //индекс для массива смещается на -1
                for (char c : word.toCharArray()) {
                    if (voicelessConsonants.contains(c)) {
                        result.add(c);
                    }
                }
            }
        }

        return result;
    }
}
