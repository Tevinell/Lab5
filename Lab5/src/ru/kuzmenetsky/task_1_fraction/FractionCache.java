package ru.kuzmenetsky.task_1_fraction;
import java.util.HashMap;
import java.util.Map;

public class FractionCache {
    private static final Map<Fraction, Double> cache = new HashMap<>();

    //получение закэшированного значения или вычисление нового
    public static double getCachedValue(Fraction fraction) {
        return cache.computeIfAbsent(fraction, f -> (double) f.getNumerator() / f.getDenominator());
    }

    //обновление кэша при изменении дроби
    public static void updateCache(Fraction fraction) {
        cache.put(fraction, (double) fraction.getNumerator() / fraction.getDenominator());
    }
}
