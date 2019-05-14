/*-
 * #%L
 * RPN Calculator Kata
 * %%
 * Copyright (C) 2019 Chrysocode
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package kata;

import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.resultOf;

class RpnCalculatorTest {

    @Test
    void should_return_the_value_given_no_operator() {
        resultOf(() -> new RpnCalculator().compute("0")).isEqualTo(0);
    }

    @Test
    void should_return_another_value_given_no_operator() {
        resultOf(() -> new RpnCalculator().compute("1")).isEqualTo(1);
    }

    @Test
    void should_add_2_operands() {
        resultOf(() -> new RpnCalculator().compute("1 2 +")).isEqualTo(3);
    }

    @Test
    void should_subtract_2_operands() {
        resultOf(() -> new RpnCalculator().compute("5 3 -")).isEqualTo(2);
    }

    @Test
    void should_multiply_2_operands() {
        resultOf(() -> new RpnCalculator().compute("2 4 *")).isEqualTo(8);
    }

    @Test
    void should_divide_2_operands() {
        resultOf(() -> new RpnCalculator().compute("20 5 /")).isEqualTo(4);
    }
}
