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

import java.util.function.BinaryOperator;

class Symbol {

    private static final String DIGITS_REGEX = "^[0-9]+$";

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    boolean isOperand() {
        return symbol.matches(DIGITS_REGEX);
    }

    boolean isOperator() {
        return Operator.isOperator(symbol);
    }

    Integer toOperand() {
        return Integer.parseInt(symbol);
    }

    BinaryOperator<Integer> toOperator() {
        return Operator.of(symbol);
    }
}
