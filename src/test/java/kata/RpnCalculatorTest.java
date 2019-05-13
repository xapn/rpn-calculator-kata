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

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.resultOf;
import static testasyouthink.TestAsYouThink.when;

class RpnCalculatorTest {

    @Test
    void should_return_X_given_0_as_a_value_of_X() {
        when(() -> compute("0")).then(result -> {
            assertThat(result).isEqualTo(0);
        });
    }

    @Test
    void should_return_X_given_1_as_a_value_of_X() {
        resultOf(() -> compute("1")).isEqualTo(1);
    }

    @Test
    void should_add_2_operands() {
        when(() -> compute("1 2")).then(result -> {
            assertThat(result).isEqualTo(3);
        });
    }

    Integer compute(String expression) {
        return stream(expression.split(" "))
                .map(Integer::parseInt)
                .reduce(0, Math::addExact);
    }
}
