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
import java.util.regex.Pattern;

public class RpnCalculator {

    private static final String SYMBOL_SEPARATOR = " ";

    public Integer compute(String expression) {
        Deque<Integer> operands = new ArrayDeque<>();

        Pattern
                .compile(SYMBOL_SEPARATOR)
                .splitAsStream(expression)
                .map(Symbol::new)
                .forEach(symbol -> symbol.compute(operands));

        return operands.removeLast();
    }
}
