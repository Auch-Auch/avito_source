package com.google.common.escape;

import a2.j.d.d.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
@Beta
@GwtCompatible
public abstract class UnicodeEscaper extends Escaper {
    public static int codePointAt(CharSequence charSequence, int i, int i2) {
        Preconditions.checkNotNull(charSequence);
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected low surrogate character '");
                sb.append(charAt);
                sb.append("' with value ");
                sb.append((int) charAt);
                sb.append(" at index ");
                sb.append(i3 - 1);
                sb.append(" in '");
                sb.append((Object) charSequence);
                sb.append("'");
                throw new IllegalArgumentException(sb.toString());
            } else if (i3 == i2) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i3);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i3 + " in '" + ((Object) charSequence) + "'");
            }
        } else {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    public abstract char[] escape(int i);

    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArr = a.a.get();
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int codePointAt = codePointAt(str, i, length);
            if (codePointAt >= 0) {
                char[] escape = escape(codePointAt);
                int i4 = (Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1) + i;
                if (escape != null) {
                    int i5 = i - i2;
                    int i6 = i3 + i5;
                    int length2 = escape.length + i6;
                    if (cArr.length < length2) {
                        int i7 = (length - i) + length2 + 32;
                        if (i7 >= 0) {
                            char[] cArr2 = new char[i7];
                            if (i3 > 0) {
                                System.arraycopy(cArr, 0, cArr2, 0, i3);
                            }
                            cArr = cArr2;
                        } else {
                            throw new AssertionError("Cannot increase internal buffer any further");
                        }
                    }
                    if (i5 > 0) {
                        str.getChars(i2, i, cArr, i3);
                        i3 = i6;
                    }
                    if (escape.length > 0) {
                        System.arraycopy(escape, 0, cArr, i3, escape.length);
                        i3 += escape.length;
                    }
                    i2 = i4;
                }
                i = nextEscapeIndex(str, i4, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i8 = length - i2;
        if (i8 > 0) {
            int i9 = i8 + i3;
            if (cArr.length < i9) {
                if (i9 >= 0) {
                    char[] cArr3 = new char[i9];
                    if (i3 > 0) {
                        System.arraycopy(cArr, 0, cArr3, 0, i3);
                    }
                    cArr = cArr3;
                } else {
                    throw new AssertionError("Cannot increase internal buffer any further");
                }
            }
            str.getChars(i2, length, cArr, i3);
            i3 = i9;
        }
        return new String(cArr, 0, i3);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int codePointAt = codePointAt(charSequence, i, i2);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1;
        }
        return i;
    }
}
