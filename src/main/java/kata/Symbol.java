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
import java.util.function.IntBinaryOperator;

import static java.lang.Integer.parseInt;

class Symbol {

    private static final Map<String, IntBinaryOperator> OPERATORS;

    static {
        OPERATORS = new HashMap<String, IntBinaryOperator>(4) {
            {
                put("+", Math::addExact);
                put("-", Math::subtractExact);
                put("*", Math::multiplyExact);
                put("/", Math::floorDiv);
            }
        };
    }

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    void compute(Lifo operands) {
        if (isOperand()) {
            operands.push(toOperand());
        } else {
            Integer rightOperand = operands.pull();
            Integer leftOperand = operands.pull();
            IntBinaryOperator operator = toOperator();
            operands.push(operator.applyAsInt(leftOperand, rightOperand));
        }
    }

    private int toOperand() {
        return parseInt(symbol);
    }

    private IntBinaryOperator toOperator() {
        return OPERATORS.get(symbol);
    }

    private boolean isOperand() {
        return symbol.matches("^[0-9]+$");
    }
}
