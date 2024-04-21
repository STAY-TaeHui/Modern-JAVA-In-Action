package ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class DishTest {

    static List<Dish> menu;

    @BeforeEach
    void ofMenu() {
        menu = Dish.menu;
    }

    @DisplayName("고칼로리 음식 리스트 foreach")
    @Test
    void highCaloriesDishesByForeach() {
        //given
        int highCalories = 300;
        List<String> dishNames = new ArrayList<>();

        //when
        for (Dish dish : menu) {
            if (dish.getCalories() > highCalories) {
                dishNames.add(dish.getName());
            }
        }

        //then
        assertThat(dishNames.size()).isEqualTo(8);

    }

    @DisplayName("고칼로리 음식 리스트 stream")
    @Test
    void highCaloriesDishesByStream() {
        //given
        int highCalories = 300;

        //when
        List<String> dishNames = menu.stream()
                .filter((m) -> m.getCalories() > highCalories)
                .map(Dish::getName)
                .collect(Collectors.toList());

        //then
        assertThat(dishNames.size()).isEqualTo(8);

    }
    @Test
    void isVegetarian() {
    }

    @Test
    void getCalories() {
    }

    @Test
    void getType() {
    }
}