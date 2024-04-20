package ch02;

import ch02.common.Color;
import ch02.common.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ch02 {

  public static void main(String... args) {
    List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED)
    );
  }

  public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if ((flag && apple.getColor().equals(color)) || !flag && apple.getWeight() > weight) {
        result.add(apple);
      }
    }
    return result;
  }
}
