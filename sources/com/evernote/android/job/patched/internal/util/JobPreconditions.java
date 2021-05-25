package com.evernote.android.job.patched.internal.util;

import a2.b.a.a.a;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
public final class JobPreconditions {
    public static float checkArgumentFinite(float f, String str) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException(a.c3(str, " must not be NaN"));
        } else if (!Float.isInfinite(f)) {
            return f;
        } else {
            throw new IllegalArgumentException(a.c3(str, " must not be infinite"));
        }
    }

    public static float checkArgumentInRange(float f, float f2, float f3, String str) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException(a.c3(str, " must not be NaN"));
        } else if (f < f2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f2), Float.valueOf(f3)));
        } else if (f <= f3) {
            return f;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f2), Float.valueOf(f3)));
        }
    }

    public static int checkArgumentNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkArgumentPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static float[] checkArrayElementsInRange(float[] fArr, float f, float f2, String str) {
        checkNotNull(fArr, str + " must not be null");
        for (int i = 0; i < fArr.length; i++) {
            float f3 = fArr[i];
            if (Float.isNaN(f3)) {
                throw new IllegalArgumentException(str + "[" + i + "] must not be NaN");
            } else if (f3 < f) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too low)", str, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)));
            } else if (f3 > f2) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too high)", str, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)));
            }
        }
        return fArr;
    }

    public static <T> T[] checkArrayElementsNotNull(T[] tArr, String str) {
        if (tArr != null) {
            for (int i = 0; i < tArr.length; i++) {
                if (tArr[i] == null) {
                    throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", str, Integer.valueOf(i)));
                }
            }
            return tArr;
        }
        throw new NullPointerException(a.c3(str, " must not be null"));
    }

    public static <T> Collection<T> checkCollectionElementsNotNull(Collection<T> collection, String str) {
        if (collection != null) {
            long j = 0;
            for (T t : collection) {
                if (t != null) {
                    j++;
                } else {
                    throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", str, Long.valueOf(j)));
                }
            }
            return collection;
        }
        throw new NullPointerException(a.c3(str, " must not be null"));
    }

    public static <T> Collection<T> checkCollectionNotEmpty(Collection<T> collection, String str) {
        if (collection == null) {
            throw new NullPointerException(a.c3(str, " must not be null"));
        } else if (!collection.isEmpty()) {
            return collection;
        } else {
            throw new IllegalArgumentException(a.c3(str, " is empty"));
        }
    }

    public static void checkFlagsArgument(int i, int i2) {
        if ((i & i2) != i) {
            StringBuilder L = a.L("Requested flags 0x");
            L.append(Integer.toHexString(i));
            L.append(", but only 0x");
            L.append(Integer.toHexString(i2));
            L.append(" are allowed");
            throw new IllegalArgumentException(L.toString());
        }
    }

    public static <T extends CharSequence> T checkNotEmpty(T t) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static long checkArgumentNonnegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str);
    }

    public static long checkArgumentPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str);
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkArgumentInRange(int i, int i2, int i3, String str) {
        if (i < i2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        } else if (i <= i3) {
            return i;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static long checkArgumentInRange(long j, long j2, long j3, String str) {
        if (j < j2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j2), Long.valueOf(j3)));
        } else if (j <= j3) {
            return j;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j2), Long.valueOf(j3)));
        }
    }
}
