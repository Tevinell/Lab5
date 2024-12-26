package ru.kuzmenetsky.task_2_meowing;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;
import static java.lang.System.out;

public class Funs {
    public static void meowsCare(List<Meowable> meowables) {
        //хранение счётчиков каждого объекта
        Map<Meowable, MeowCounter> counters = new HashMap<>();

        Random random = new Random();

        for (Meowable meowable : meowables) {
            MeowCounter counter = new MeowCounter();
            int meowTimes = random.nextInt(5) + 1; //случайное число от 1 до 5

            for (int i = 0; i < meowTimes; i++) {
                meowable.meow();
                counter.increment();
            }

            counters.put(meowable, counter);
        }

        //вывод
        for (Map.Entry<Meowable, MeowCounter> entry : counters.entrySet()) {
            out.println(entry.getKey() + " мяукал " + entry.getValue().getCount() + " раз");
        }
    }
}
