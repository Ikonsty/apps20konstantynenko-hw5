package ua.edu.ucu.stream;

import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntConsumer;
import ua.edu.ucu.function.IntBinaryOperator;
import ua.edu.ucu.function.IntUnaryOperator;
import ua.edu.ucu.function.IntToIntStreamFunction;

public interface IntStream {

    Double average() throws IllegalAccessException;

    Integer max() throws IllegalAccessException;

    Integer min() throws IllegalAccessException;
    
    IntStream flatMap(IntToIntStreamFunction func);

    long count();

    IntStream filter(IntPredicate predicate);

    void forEach(IntConsumer action);

    IntStream map(IntUnaryOperator mapper);

    int reduce(int identity, IntBinaryOperator op);

    Integer sum() throws IllegalAccessException;

    int[] toArray();
}
