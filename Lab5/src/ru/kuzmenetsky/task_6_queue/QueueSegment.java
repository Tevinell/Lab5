package ru.kuzmenetsky.task_6_queue;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class QueueSegment {
    public static <T> boolean areEqual(Queue<T> queue, int i, int j) {
        if (queue == null || i < 0 || j < 0 || i >= j || i >= queue.size() || j >= queue.size()) {
            throw new IllegalArgumentException("неверные индексы или очередь пустая");
        }
        //преобразуем очередь в список для работы с элементами по индексам
        LinkedList<T> list = new LinkedList<>(queue);

        out.println("исходная очередь: " + queue);

        //сравниваем элементы зеркально
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false; //если хотя бы один элемент не равен
            }
            i++; //сдвигаем начальный индекс i вправо
            j--; //сдвигаем конечный индекс j влево
        }

        return true; //если все элементы равны
    }
}
