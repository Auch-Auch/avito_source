package com.avito.security;

import com.avito.android.lib.design.input.FormatterType;
public class t1 extends s1 {
    public static int a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int a(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + FormatterType.defaultDecimalSeparator);
    }

    public static int b(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static o1 c(int i, int i2) {
        return o1.d.a(i, i2, -1);
    }

    public static q1 d(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? q1.f.a() : new q1(i, i2 - 1);
    }
}
