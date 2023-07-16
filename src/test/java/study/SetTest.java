package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1: Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    void size() {
        // give
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2: Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
    void contains(int number) {
        // given
        // when
        boolean sut = numbers.contains(number);

        // then
        assertThat(sut).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int number, boolean expected) {
        // given
        // when
        boolean sut = numbers.contains(number);

        // then
        assertThat(sut).isEqualTo(expected);
    }


}
