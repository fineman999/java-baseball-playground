package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항 1: split() 메소드를 통해 문자열을 분리하여 배열로 반환한다.")
    void split() {
        // given
        String sut = "1,2";

        // when
        String[] result = sut.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 2: substring을 통해 부분적으로 받아 올수 있는지 검증한다.")
    void substring() {
        // given
        String sut = "(1,2)";

        // when
        String result = sut.substring(1, sut.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3: charAt() 메소드를 통해 특정 위치의 문자를 가져온다.")
    void charAt() {
        // given
        String sut = "abc";

        // when
        char result = sut.charAt(1);

        // then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("요구사항 3: charAt() 메소드를 통해 특정 위치의 문자를 가져올때 위치 값을 벗어나면 예외가 발생한다.")
    void charAtException() {
        // given
        String sut = "abc";

        // when
        // then
        assertThatThrownBy(() -> sut.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
