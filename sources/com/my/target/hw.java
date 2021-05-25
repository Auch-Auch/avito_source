package com.my.target;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
public class hw {
    @NonNull
    public static String a(@Nullable String[] strArr) {
        return strArr == null ? "" : TextUtils.join(",", strArr);
    }

    public static boolean a(@NonNull String[] strArr, @NonNull String str) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public static int[] b(@NonNull int... iArr) {
        Arrays.sort(iArr);
        return iArr;
    }

    @NonNull
    public static String f(@NonNull List<String> list) {
        return TextUtils.join(",", list);
    }
}
