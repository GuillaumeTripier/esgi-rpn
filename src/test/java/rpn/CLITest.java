package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(new CLI().evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(new CLI().evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(new CLI().evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        assertThat(new CLI().evaluate("2 3 *")).isEqualTo(6);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(new CLI().evaluate("10 5 /")).isEqualTo(2);
    }

    @Test
    public void should_evaluate_simple_substraction() {
        assertThat(new CLI().evaluate("2 3 -")).isEqualTo(-1);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(new CLI().evaluate("2 3 5 + +")).isEqualTo(10);
    }
}