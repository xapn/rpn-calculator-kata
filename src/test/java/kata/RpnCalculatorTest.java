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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static testasyouthink.TestAsYouThink.resultOf;

class RpnCalculatorTest {

    private static final String SYMBOL_SEPARATOR = " ";

    @Test
    void should_return_the_value_given_no_operator() {
        resultOf(() -> compute("0")).isEqualTo(0);
    }

    @Test
    void should_return_another_value_given_no_operator() {
        resultOf(() -> compute("1")).isEqualTo(1);
    }

    @Test
    void should_add_2_operands() {
        resultOf(() -> compute("1 2 +")).isEqualTo(3);
    }

    @Test
    void should_subtract_2_operands() {
        resultOf(() -> compute("5 3 -")).isEqualTo(2);
    }

    @Test
    void should_multiply_2_operands() {
        resultOf(() -> compute("2 4 *")).isEqualTo(8);
    }

    @Test
    void should_divide_2_operands() {
        resultOf(() -> compute("20 5 /")).isEqualTo(4);
    }

    Integer compute(String expression) {
        Deque<Integer> operands = new ArrayDeque<>();

        Pattern
                .compile(SYMBOL_SEPARATOR)
                .splitAsStream(expression)
                .map(Symbol::new)
                .forEach(symbol -> symbol.compute(operands));

        return operands.removeLast();
    }

    static class Symbol {

        private final String symbol;

        Symbol(String symbol) {
            this.symbol = symbol;
        }

        void compute(Deque<Integer> operands) {
            if (isOperand()) {
                operands.addLast(toOperand());
            } else {
                Integer rightOperand = operands.removeLast();
                Integer leftOperand = operands.removeLast();
                IntBinaryOperator operator = toOperator();
                operands.addLast(operator.applyAsInt(leftOperand, rightOperand));
            }
        }

        private int toOperand() {
            return parseInt(symbol);
        }

        private IntBinaryOperator toOperator() {
            IntBinaryOperator operator;
            if (isMinus()) {
                operator = Math::subtractExact;
            } else if (isMultiplication()) {
                operator = Math::multiplyExact;
            } else if (isDivision()) {
                operator = Math::floorDiv;
            } else {
                operator = Math::addExact;
            }
            return operator;
        }

        private boolean isDivision() {
            return "/".equals(symbol);
        }

        private boolean isMultiplication() {
            return "*".equals(symbol);
        }

        private boolean isMinus() {
            return "-".equals(symbol);
        }

        private boolean isOperand() {
            return symbol.matches("^[0-9]+$");
        }
    }
}
