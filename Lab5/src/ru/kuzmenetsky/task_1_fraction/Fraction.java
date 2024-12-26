package ru.kuzmenetsky.task_1_fraction;
import java.util.Objects;

public class Fraction implements FractionInterf {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    //сеттеры
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        FractionCache.updateCache(this);
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            this.numerator = -this.numerator;
            denominator = -denominator;
        }
        this.denominator = denominator;
        FractionCache.updateCache(this);
    }

    //получение вещественного значения
    @Override
    public double getDecimalValue() {
        return FractionCache.getCachedValue(this);
    }

    //строковое представление
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    //сравнение
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

}
