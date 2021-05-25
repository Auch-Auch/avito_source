package com.google.android.gms.common.util;

import a2.b.a.a.a;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@VisibleForTesting
@KeepForSdk
public class NumberUtils {
    private NumberUtils() {
    }

    @RecentlyNonNull
    @KeepForSdk
    public static long parseHexLong(@RecentlyNonNull String str) {
        if (str.length() > 16) {
            throw new NumberFormatException(a.s2(str.length() + 37, "Invalid input: ", str, " exceeds 16 characters"));
        } else if (str.length() != 16) {
            return Long.parseLong(str, 16);
        } else {
            return (Long.parseLong(str.substring(0, 8), 16) << 32) | Long.parseLong(str.substring(8), 16);
        }
    }
}
