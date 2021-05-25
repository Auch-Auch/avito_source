package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;
@Beta
@GwtCompatible
public abstract class ArrayBasedCharEscaper extends CharEscaper {
    public final char[][] b;
    public final int c;
    public final char d;
    public final char e;

    public ArrayBasedCharEscaper(Map<Character, String> map, char c2, char c3) {
        this(ArrayBasedEscaperMap.create(map), c2, c3);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.c && this.b[charAt] != null) || charAt > this.e || charAt < this.d) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    public abstract char[] escapeUnsafe(char c2);

    public ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c2, char c3) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] cArr = arrayBasedEscaperMap.a;
        this.b = cArr;
        this.c = cArr.length;
        if (c3 < c2) {
            c3 = 0;
            c2 = CharCompanionObject.MAX_VALUE;
        }
        this.d = c2;
        this.e = c3;
    }

    @Override // com.google.common.escape.CharEscaper
    public final char[] escape(char c2) {
        char[] cArr;
        if (c2 < this.c && (cArr = this.b[c2]) != null) {
            return cArr;
        }
        if (c2 < this.d || c2 > this.e) {
            return escapeUnsafe(c2);
        }
        return null;
    }
}
