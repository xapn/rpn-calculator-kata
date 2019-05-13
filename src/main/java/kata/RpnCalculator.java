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

import java.util.ArrayDeque;
import java.util.Deque;

import static java.util.Arrays.stream;

public class RpnCalculator {

    private static final String EXPRESSION_SEPARATOR = " ";

    public Integer compute(final String expression) {
        final Deque<Integer> operands = new ArrayDeque<>();

        stream(expression.split(EXPRESSION_SEPARATOR))
                .map(Symbol::new)
                .forEach(symbol -> {
                    if (symbol.isOperand()) {
                        operands.addLast(symbol.toOperand());
                    } else if (symbol.isOperator()) {
                        Integer right = operands.removeLast();
                        Integer left = operands.removeLast();
                        operands.addLast(symbol
                                .toOperator()
                                .apply(left, right));
                    }
                });
        return operands.removeLast();
    }
}

