package ch02;

import ch02.common.Apple;
import ch02.common.Color;
import ch02.predicate.AppleGreenColorPredicate;
import ch02.predicate.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ch02Test {

    private static final List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED)
    );
    public List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        //두가지 필터링이 존재
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    !flag && apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
    public List<Apple> filterApplesPredicate(List<Apple> inventory, ApplePredicate predicate) {
        //두가지 필터링이 존재
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    @Test
    public void allFilteringTest() {
        //초록 사과만 필터링
        List<Apple> greenApples = filterApples(inventory, Color.GREEN, 0, true);
        for (Apple apple :
                greenApples) {
            Assertions.assertThat(apple.getColor()).isEqualTo(Color.GREEN);
        }
        //무게 150이상만 필터링
        List<Apple> heavyApples = filterApples(inventory, null, 150, false);
        for (Apple apple:
             heavyApples) {
            Assertions.assertThat(apple.getWeight()).isGreaterThan(150);
        }
    }
    @Test
    public void filteringPredicateTest() {
        filterApplesPredicate(inventory, new AppleGreenColorPredicate());
        filterApplesPredicate(inventory, new AppleHeavyWeightPredicate());
    }
}
