package ch02.predicate;

import ch02.common.Apple;
import ch02.common.Color;


public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
