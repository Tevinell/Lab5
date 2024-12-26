package ru.kuzmenetsky.task_3_list;

import java.util.ArrayList;
import java.util.List;

public class ListMod {

    public static <T> List<T> addAfter(List<T> L, T E) {
        if (L == null || L.isEmpty()) {
            throw new IllegalArgumentException("список не может быть пустым");
        }

        int index = L.indexOf(E);
        if (index == -1) {
            throw new IllegalArgumentException("элемента нет в списке");
        }

        List<T> newL = new ArrayList<>(L);  //копия исходного списка
        newL.addAll(index + 1, L);  //вставляем все элементы после первого вхождения E
        return newL;  //возвращаем новый список
    }
}
