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

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import static java.util.Arrays.stream;

enum Operator {

    ADDITION("+", Math::addExact), //
    SUBTRACTION("-", Math::subtractExact), //
    MULTIPLICATION("*", Math::multiplyExact), //
    DIVISION("/", Math::floorDiv);

    static final String OPERATORS_REGEX = "^[+-\\\\*/]$";
    private static final Map<String, BinaryOperator<Integer>> OPERATORS;

    static {
        OPERATORS = new HashMap<>(values().length);
        stream(values()).forEach(op -> OPERATORS.put(op.symbol, op.operator));
    }

    private final String symbol;
    private final BinaryOperator<Integer> operator;

    Operator(String symbol, BinaryOperator<Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    static BinaryOperator<Integer> of(String symbol) {
        return OPERATORS.get(symbol);
    }

    static boolean isOperator(String symbol) {
        return symbol.matches(OPERATORS_REGEX);
    }
}
