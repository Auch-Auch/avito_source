package org.junit;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.function.ThrowingRunnable;
import org.junit.internal.ArrayComparisonFailure;
import org.junit.internal.ExactComparisonCriteria;
import org.junit.internal.InexactComparisonCriteria;
public class Assert {
    public static String a(String str) {
        return (str == null || str.length() == 0) ? "" : a.c3(str, ": ");
    }

    public static void assertArrayEquals(String str, Object[] objArr, Object[] objArr2) throws ArrayComparisonFailure {
        j(str, objArr, objArr2);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (!c(obj, obj2)) {
            if (!(obj instanceof String) || !(obj2 instanceof String)) {
                e(str, obj, obj2);
                return;
            }
            if (str == null) {
                str = "";
            }
            throw new ComparisonFailure(str, (String) obj, (String) obj2);
        }
    }

    public static void assertFalse(String str, boolean z) {
        assertTrue(str, !z);
    }

    public static void assertNotEquals(String str, Object obj, Object obj2) {
        if (c(obj, obj2)) {
            d(str, obj2);
        }
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame(null, obj, obj2);
    }

    public static void assertNull(Object obj) {
        assertNull(null, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame(null, obj, obj2);
    }

    @Deprecated
    public static <T> void assertThat(T t, Matcher<? super T> matcher) {
        assertThat("", t, matcher);
    }

    public static <T extends Throwable> T assertThrows(Class<T> cls, ThrowingRunnable throwingRunnable) {
        return (T) assertThrows(null, cls, throwingRunnable);
    }

    public static void assertTrue(String str, boolean z) {
        if (!z) {
            fail(str);
        }
    }

    public static boolean b(double d, double d2, double d3) {
        if (Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3) {
            return true;
        }
        return false;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void d(String str, Object obj) {
        String c3 = str != null ? a.c3(str, ". ") : "Values should be different. ";
        fail(c3 + "Actual: " + obj);
    }

    public static void e(String str, Object obj, Object obj2) {
        fail(g(str, obj, obj2));
    }

    public static boolean f(float f, float f2, float f3) {
        if (Float.compare(f, f2) != 0 && Math.abs(f - f2) > f3) {
            return true;
        }
        return false;
    }

    public static void fail(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    public static String g(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str2.equals(str)) {
            str2 = a.c3(str, " ");
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        if (c(valueOf, valueOf2)) {
            StringBuilder Q = a.Q(str2, "expected: ");
            Q.append(i(obj, valueOf));
            Q.append(" but was: ");
            Q.append(i(obj2, valueOf2));
            return Q.toString();
        }
        StringBuilder W = a.W(str2, "expected:<", valueOf, "> but was:<", valueOf2);
        W.append(">");
        return W.toString();
    }

    public static String h(Class<?> cls) {
        String canonicalName = cls.getCanonicalName();
        return canonicalName == null ? cls.getName() : canonicalName;
    }

    public static String i(Object obj, String str) {
        return a.d(obj == null ? BuildConfig.ADJUST_DEFAULT_TRACKER : obj.getClass().getName(), "<", str, ">");
    }

    public static void j(String str, Object obj, Object obj2) throws ArrayComparisonFailure {
        new ExactComparisonCriteria().arrayEquals(str, obj, obj2);
    }

    public static void assertArrayEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals((String) null, objArr, objArr2);
    }

    public static void assertFalse(boolean z) {
        assertFalse(null, z);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            String c3 = str != null ? a.c3(str, " ") : "";
            fail(c3 + "expected not same");
        }
    }

    public static void assertNull(String str, Object obj) {
        if (obj != null) {
            String c3 = str != null ? a.c3(str, " ") : "";
            fail(c3 + "expected null, but was:<" + obj + ">");
        }
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj != obj2) {
            String c3 = str != null ? a.c3(str, " ") : "";
            fail(c3 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
        }
    }

    @Deprecated
    public static <T> void assertThat(String str, T t, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(str, t, matcher);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001d: APUT  (r4v7 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v4 java.lang.String) */
    public static <T extends Throwable> T assertThrows(String str, Class<T> cls, ThrowingRunnable throwingRunnable) {
        try {
            throwingRunnable.run();
            StringBuilder sb = new StringBuilder();
            sb.append(a(str));
            Object[] objArr = new Object[1];
            String canonicalName = cls.getCanonicalName();
            if (canonicalName == null) {
                canonicalName = cls.getName();
            }
            objArr[0] = canonicalName;
            sb.append(String.format("expected %s to be thrown, but nothing was thrown", objArr));
            throw new AssertionError(sb.toString());
        } catch (Throwable th) {
            if (cls.isInstance(th)) {
                return th;
            }
            String canonicalName2 = cls.getCanonicalName();
            if (canonicalName2 == null) {
                canonicalName2 = cls.getName();
            }
            Class<?> cls2 = th.getClass();
            String h = h(cls2);
            if (canonicalName2.equals(h)) {
                StringBuilder Q = a.Q(canonicalName2, "@");
                Q.append(Integer.toHexString(System.identityHashCode(cls)));
                canonicalName2 = Q.toString();
                StringBuilder Q2 = a.Q(h, "@");
                Q2.append(Integer.toHexString(System.identityHashCode(cls2)));
                h = Q2.toString();
            }
            AssertionError assertionError = new AssertionError(a(str) + g("unexpected exception type thrown;", canonicalName2, h));
            assertionError.initCause(th);
            throw assertionError;
        }
    }

    public static void assertTrue(boolean z) {
        assertTrue(null, z);
    }

    public static void assertArrayEquals(String str, boolean[] zArr, boolean[] zArr2) throws ArrayComparisonFailure {
        j(str, zArr, zArr2);
    }

    public static void assertNotEquals(Object obj, Object obj2) {
        assertNotEquals((String) null, obj, obj2);
    }

    public static void fail() {
        fail(null);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2) {
        assertArrayEquals((String) null, zArr, zArr2);
    }

    public static void assertNotEquals(String str, long j, long j2) {
        if (j == j2) {
            d(str, Long.valueOf(j2));
        }
    }

    public static void assertArrayEquals(String str, byte[] bArr, byte[] bArr2) throws ArrayComparisonFailure {
        j(str, bArr, bArr2);
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertNotEquals(long j, long j2) {
        assertNotEquals((String) null, j, j2);
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2) {
        assertArrayEquals((String) null, bArr, bArr2);
    }

    public static void assertEquals(String str, double d, double d2, double d3) {
        if (b(d, d2, d3)) {
            e(str, Double.valueOf(d), Double.valueOf(d2));
        }
    }

    public static void assertNotEquals(String str, double d, double d2, double d3) {
        if (!b(d, d2, d3)) {
            d(str, Double.valueOf(d2));
        }
    }

    public static void assertArrayEquals(String str, char[] cArr, char[] cArr2) throws ArrayComparisonFailure {
        j(str, cArr, cArr2);
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2) {
        assertArrayEquals((String) null, cArr, cArr2);
    }

    public static void assertEquals(String str, float f, float f2, float f3) {
        if (f(f, f2, f3)) {
            e(str, Float.valueOf(f), Float.valueOf(f2));
        }
    }

    public static void assertNotEquals(double d, double d2, double d3) {
        assertNotEquals((String) null, d, d2, d3);
    }

    public static void assertArrayEquals(String str, short[] sArr, short[] sArr2) throws ArrayComparisonFailure {
        j(str, sArr, sArr2);
    }

    public static void assertNotEquals(float f, float f2, float f3) {
        assertNotEquals((String) null, f, f2, f3);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2) {
        assertArrayEquals((String) null, sArr, sArr2);
    }

    public static void assertEquals(long j, long j2) {
        assertEquals((String) null, j, j2);
    }

    public static void assertNotEquals(String str, float f, float f2, float f3) {
        if (!f(f, f2, f3)) {
            d(str, Float.valueOf(f2));
        }
    }

    public static void assertArrayEquals(String str, int[] iArr, int[] iArr2) throws ArrayComparisonFailure {
        j(str, iArr, iArr2);
    }

    public static void assertEquals(String str, long j, long j2) {
        if (j != j2) {
            e(str, Long.valueOf(j), Long.valueOf(j2));
        }
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2) {
        assertArrayEquals((String) null, iArr, iArr2);
    }

    @Deprecated
    public static void assertEquals(double d, double d2) {
        assertEquals((String) null, d, d2);
    }

    public static void assertArrayEquals(String str, long[] jArr, long[] jArr2) throws ArrayComparisonFailure {
        j(str, jArr, jArr2);
    }

    @Deprecated
    public static void assertEquals(String str, double d, double d2) {
        fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2) {
        assertArrayEquals((String) null, jArr, jArr2);
    }

    public static void assertEquals(double d, double d2, double d3) {
        assertEquals((String) null, d, d2, d3);
    }

    public static void assertArrayEquals(String str, double[] dArr, double[] dArr2, double d) throws ArrayComparisonFailure {
        new InexactComparisonCriteria(d).arrayEquals(str, dArr, dArr2);
    }

    public static void assertEquals(float f, float f2, float f3) {
        assertEquals((String) null, f, f2, f3);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d) {
        assertArrayEquals((String) null, dArr, dArr2, d);
    }

    @Deprecated
    public static void assertEquals(String str, Object[] objArr, Object[] objArr2) {
        assertArrayEquals(str, objArr, objArr2);
    }

    public static void assertArrayEquals(String str, float[] fArr, float[] fArr2, float f) throws ArrayComparisonFailure {
        new InexactComparisonCriteria(f).arrayEquals(str, fArr, fArr2);
    }

    @Deprecated
    public static void assertEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals(objArr, objArr2);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f) {
        assertArrayEquals((String) null, fArr, fArr2, f);
    }
}
