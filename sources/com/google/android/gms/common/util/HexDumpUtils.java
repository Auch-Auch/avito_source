package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.avito.android.lib.design.input.FormatterType;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public final class HexDumpUtils {
    @RecentlyNullable
    @KeepForSdk
    public static String dump(@RecentlyNonNull byte[] bArr, @RecentlyNonNull int i, @RecentlyNonNull int i2, @RecentlyNonNull boolean z) {
        if (bArr == null || bArr.length == 0 || i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            return null;
        }
        int i3 = 57;
        if (z) {
            i3 = 75;
        }
        StringBuilder sb = new StringBuilder((((i2 + 16) - 1) / 16) * i3);
        int i4 = i2;
        int i5 = 0;
        int i6 = 0;
        while (i4 > 0) {
            if (i5 == 0) {
                if (i2 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i)));
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i)));
                }
                i6 = i;
            } else if (i5 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i] & 255)));
            i4--;
            i5++;
            if (z && (i5 == 16 || i4 == 0)) {
                int i7 = 16 - i5;
                if (i7 > 0) {
                    for (int i8 = 0; i8 < i7; i8++) {
                        sb.append("   ");
                    }
                }
                if (i7 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i9 = 0; i9 < i5; i9++) {
                    char c = (char) bArr[i6 + i9];
                    if (c < ' ' || c > '~') {
                        c = FormatterType.defaultDecimalSeparator;
                    }
                    sb.append(c);
                }
            }
            if (i5 == 16 || i4 == 0) {
                sb.append('\n');
                i5 = 0;
            }
            i++;
        }
        return sb.toString();
    }
}
