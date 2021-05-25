package com.google.common.base;

import a2.b.a.a.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
@Beta
@GwtCompatible(emulated = true)
public final class Utf8 {
    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) != charAt2) {
                                i2++;
                            } else {
                                throw new IllegalArgumentException(a.M2("Unpaired surrogate at index ", i2));
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder L = a.L("UTF-8 length does not fit in int: ");
        L.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(L.toString());
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormed(byte[] bArr, int i, int i2) {
        byte b;
        int i3 = i2 + i;
        Preconditions.checkPositionIndexes(i, i3, bArr.length);
        while (i < i3) {
            if (bArr[i] < 0) {
                while (i < i3) {
                    int i4 = i + 1;
                    byte b2 = bArr[i];
                    if (b2 < 0) {
                        if (b2 < -32) {
                            if (i4 != i3 && b2 >= -62) {
                                i = i4 + 1;
                                if (bArr[i4] > -65) {
                                }
                            }
                        } else if (b2 < -16) {
                            int i5 = i4 + 1;
                            if (i5 < i3 && (b = bArr[i4]) <= -65 && ((b2 != -32 || b >= -96) && (b2 != -19 || -96 > b))) {
                                i = i5 + 1;
                                if (bArr[i5] > -65) {
                                }
                            }
                        } else if (i4 + 2 < i3) {
                            int i6 = i4 + 1;
                            byte b3 = bArr[i4];
                            if (b3 <= -65) {
                                if ((((b3 + 112) + (b2 << Ascii.FS)) >> 30) == 0) {
                                    int i7 = i6 + 1;
                                    if (bArr[i6] <= -65) {
                                        i4 = i7 + 1;
                                        if (bArr[i7] > -65) {
                                        }
                                    }
                                }
                            }
                        }
                        return false;
                    }
                    i = i4;
                }
                return true;
            }
            i++;
        }
        return true;
    }
}
