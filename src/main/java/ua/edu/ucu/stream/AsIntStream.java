package ua.edu.ucu.stream;

import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntConsumer;
import ua.edu.ucu.function.IntBinaryOperator;
import ua.edu.ucu.function.IntUnaryOperator;
import ua.edu.ucu.function.IntToIntStreamFunction;

import java.util.ArrayList;

public class AsIntStream implements IntStream {
    private static int[] stream;

    private AsIntStream() {
        // To Do
    }

    public static IntStream of(int... values) {
        stream = new int[values.length];
        System.arraycopy(values, 0, stream, 0, values.length);
        return new AsIntStream();
    }

    private void checkLen() throws IllegalAccessException {
        if (stream.length == 0) {
            throw new IllegalAccessException("Stream is empty");
        }
    }

    @Override
    public double average() throws IllegalAccessException {
        checkLen();
        return (double) sum() / (double) stream.length;
    }

    @Override
    public int max() throws IllegalAccessException {
        checkLen();
        int max = stream[0];
        for (int val : stream) {
            if (max < val) {
                max = val;
            }
        }
        return max;
    }

    @Override
    public int min() throws IllegalAccessException {
        checkLen();
        int min = stream[0];
        for (int val : stream) {
            if (min > val) {
                min = val;
            }
        }
        return min;
    }

    @Override
    public long count() {
        return stream.length;
    }

    @Override
    public int sum() throws IllegalAccessException {
        checkLen();
        int sum = 0;
        for (int val : stream) {
            sum += val;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        ArrayList<Integer> filteredValues = new ArrayList<>();
        for (int val : stream) {
            if (predicate.test(val)) {
                filteredValues.add(val);
            }
        }
        int[] result = new int[filteredValues.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = filteredValues.get(i);
        }
        return of(result);
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int val : stream) {
            action.accept(val);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        int[] mappedValues = new int[stream.length];
        for (int i = 0; i < stream.length; i++) {
            mappedValues[i] = mapper.apply(stream[i]);
        }
        return of(mappedValues);
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<Integer> mappedValues = new ArrayList<>();
        for (int val : stream) {
            int[] arrayOfMappedValues = func.applyAsIntStream(val).toArray();
            for (int mappedVal : arrayOfMappedValues) {
                mappedValues.add(mappedVal);
            }
        }

        int[] result = new int[mappedValues.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = mappedValues.get(i);
        }
        return of(result);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int answer = identity;
        for (int val : stream) {
            answer = op.apply(answer, val);
        }
        return answer;
    }

    @Override
    public int[] toArray() {
        return stream;
    }

}
