package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
@Beta
@GwtCompatible
public final class CharEscaperBuilder {
    public final Map<Character, String> a = new HashMap();
    public int b = -1;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Map<java.lang.Character, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscape(char c, String str) {
        this.a.put(Character.valueOf(c), Preconditions.checkNotNull(str));
        if (c > this.b) {
            this.b = c;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char c : cArr) {
            addEscape(c, str);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[(this.b + 1)][];
        for (Map.Entry<Character, String> entry : this.a.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new a(toArray());
    }

    public static class a extends CharEscaper {
        public final char[][] b;
        public final int c;

        public a(char[][] cArr) {
            this.b = cArr;
            this.c = cArr.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                char[][] cArr = this.b;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i);
                }
            }
            return str;
        }

        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char c2) {
            if (c2 < this.c) {
                return this.b[c2];
            }
            return null;
        }
    }
}
