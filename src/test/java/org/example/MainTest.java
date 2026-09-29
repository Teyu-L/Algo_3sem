package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @MethodSource("testBubbleSortData")
    void testBubbleSort(int N) {
        //Random random = new Random(7777);
        int[] arr = new int[N];
        //random.nextInt(100);
        // Органообразный массив: сначала вверх, потом вниз
        int mid = N / 2;
        for (int i = 0; i < mid; i++) {
            arr[i] = i;
        }
        for (int i = mid; i < N; i++) {
            arr[i] = N - i;
        }
        long start = System.nanoTime();
        Main.insertionSort(arr);
        System.out.println(System.nanoTime() - start);

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    static Stream<Arguments> testBubbleSortData() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(1000),
                Arguments.of(2000),
                Arguments.of(4000),
                Arguments.of(8000),
                Arguments.of(16000),
                Arguments.of(32000),
                Arguments.of(64000),
                Arguments.of(128000)
        );
    }

}