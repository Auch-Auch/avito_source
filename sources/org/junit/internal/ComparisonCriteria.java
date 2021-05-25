package org.junit.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import okhttp3.HttpUrl;
import org.junit.Assert;
import x6.c.b.a;
public abstract class ComparisonCriteria {
    public static final Object a = new a("end of array");

    public final void a(String str, Object obj, Object obj2, boolean z) throws ArrayComparisonFailure {
        String str2;
        if (obj != obj2 && !Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2})) {
            String str3 = "";
            if (str == null) {
                str2 = str3;
            } else {
                str2 = a2.b.a.a.a.c3(str, ": ");
            }
            if (z) {
                str3 = str2;
            }
            if (obj == null) {
                Assert.fail(str3 + "expected array was null");
            }
            if (obj2 == null) {
                Assert.fail(str3 + "actual array was null");
            }
            int length = Array.getLength(obj2);
            int length2 = Array.getLength(obj);
            if (length != length2) {
                str2 = str2 + "array lengths differed, expected.length=" + length2 + " actual.length=" + length + "; ";
            }
            int min = Math.min(length, length2);
            for (int i = 0; i < min; i++) {
                Object obj3 = Array.get(obj, i);
                Object obj4 = Array.get(obj2, i);
                if (!d(obj3) || !d(obj4)) {
                    try {
                        assertElementsEqual(obj3, obj4);
                    } catch (AssertionError e) {
                        throw new ArrayComparisonFailure(str2, e, i);
                    }
                } else {
                    try {
                        a(str, obj3, obj4, false);
                    } catch (ArrayComparisonFailure e2) {
                        e2.addDimension(i);
                        throw e2;
                    } catch (AssertionError e3) {
                        throw new ArrayComparisonFailure(str2, e3, i);
                    }
                }
            }
            if (length != length2) {
                try {
                    Assert.assertEquals(c(obj, length2, min), c(obj2, length, min));
                } catch (AssertionError e4) {
                    throw new ArrayComparisonFailure(str2, e4, min);
                }
            }
        }
    }

    public void arrayEquals(String str, Object obj, Object obj2) throws ArrayComparisonFailure {
        a(str, obj, obj2, true);
    }

    public abstract void assertElementsEqual(Object obj, Object obj2);

    public final String b(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (!componentType.isArray()) {
            return componentType.getName();
        }
        return b(componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public final Object c(Object obj, int i, int i2) {
        if (i2 >= i) {
            return a;
        }
        Object obj2 = Array.get(obj, i2);
        if (!d(obj2)) {
            return obj2;
        }
        return new a(b(obj2.getClass()) + "[" + Array.getLength(obj2) + "]");
    }

    public final boolean d(Object obj) {
        return obj != null && obj.getClass().isArray();
    }
}
