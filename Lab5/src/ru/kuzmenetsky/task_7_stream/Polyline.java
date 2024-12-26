package ru.kuzmenetsky.task_7_stream;

import java.util.List;
import java.util.stream.Collectors;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "линия [" + points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
