package ch05;

import ch04.Dish;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DishTest {

    static List<Dish> menu;

    @BeforeEach
    void ofMenu() {
        menu = Dish.menu;
    }

    @DisplayName("채식 메뉴이면 리스트에 담는다.")
    @Test
    void isVegetarianMenuStream() {
        //given

        //when
        List<Dish> collect = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        //then
        assertThat(collect.size()).isEqualTo(4);
    }

    @DisplayName("채식 메뉴이면 리스트에 담는다. 동일 메뉴는 제외")
    @Test
    void isVegetarianMenuStreamDistinct() {
        //given

        //when
        List<Dish> collect = menu.stream()
                .filter(Dish::isVegetarian)
                .distinct()
                .collect(Collectors.toList());

        //then
        assertThat(collect.size()).isEqualTo(4);
    }

    @DisplayName("정렬된 메뉴 리스트에서 takeWhile을 사용하여 칼로리가 320이하 칼로리인 음식 만 리스트에 담는다")
    @Test
    void lowCaloriesMenuForTakeWhile() {
        //given
        int calories = 320;

        //when
        List<Dish> collect = menu.stream().sorted(Comparator.comparing(Dish::getCalories))
                .takeWhile((dish) -> dish.getCalories() < calories)
                .collect(Collectors.toList());

        //then
        assertThat(collect.size()).isEqualTo(1);
    }
    @DisplayName("정렬된 메뉴 리스트에서 dropWhile을 사용하여 칼로리가 320 초과 칼로리인 음식 만 리스트에 담는다")
    @Test
    void lowCaloriesMenuForDropWhile() {
        //given
        int calories = 320;

        //when
        List<Dish> collect = menu.stream().sorted(Comparator.comparing(Dish::getCalories))
                .dropWhile((dish) -> dish.getCalories() < calories)
                .collect(Collectors.toList());

        //then
        assertThat(collect.size()).isEqualTo(8);
    }

    @DisplayName("정렬된 메뉴에서 가장 낮은 칼로리 3개 메뉴를 담는다.")
    @Test
    void lowCaloriesMenuTop3() {
        //given

        //when
        List<Dish> collect = menu.stream().sorted(Comparator.comparing(Dish::getCalories))
                .limit(3)
                .collect(Collectors.toList());

        //then
        assertThat(collect.get(0).getName()).isEqualTo("season fruit");
    }
}
