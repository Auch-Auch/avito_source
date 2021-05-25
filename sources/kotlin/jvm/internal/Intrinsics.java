package kotlin.jvm.internal;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;
public class Intrinsics {

    @SinceKotlin(version = "1.4")
    public static class Kotlin {
    }

    public static String a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        StringBuilder W = a.W("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
        W.append(str);
        return W.toString();
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static <T extends Throwable> T b(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(a.c3(str, " must not be null"));
            b(illegalStateException, Intrinsics.class.getName());
            throw illegalStateException;
        }
    }

    public static void checkFieldIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(a.d("Field specified as non-null is null: ", str, ".", str2));
            b(illegalStateException, Intrinsics.class.getName());
            throw illegalStateException;
        }
    }

    public static void checkHasClass(String str) throws ClassNotFoundException {
        String replace = str.replace('/', FormatterType.defaultDecimalSeparator);
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(a.e3("Class ", replace, " is not found. Please update the Kotlin runtime to the latest version"), e);
            b(classNotFoundException, Intrinsics.class.getName());
            throw classNotFoundException;
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(a.c3(str, " must not be null"));
            b(nullPointerException, Intrinsics.class.getName());
            throw nullPointerException;
        }
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(a(str));
            b(nullPointerException, Intrinsics.class.getName());
            throw nullPointerException;
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(a(str));
            b(illegalArgumentException, Intrinsics.class.getName());
            throw illegalArgumentException;
        }
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(a.d("Method specified as non-null returned null: ", str, ".", str2));
            b(illegalStateException, Intrinsics.class.getName());
            throw illegalStateException;
        }
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i, String str) {
        throwUndefinedForReified();
    }

    public static String stringPlus(String str, Object obj) {
        return a.b3(str, obj);
    }

    public static void throwAssert() {
        AssertionError assertionError = new AssertionError();
        b(assertionError, Intrinsics.class.getName());
        throw assertionError;
    }

    public static void throwIllegalArgument() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        b(illegalArgumentException, Intrinsics.class.getName());
        throw illegalArgumentException;
    }

    public static void throwIllegalState() {
        IllegalStateException illegalStateException = new IllegalStateException();
        b(illegalStateException, Intrinsics.class.getName());
        throw illegalStateException;
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe() {
        NullPointerException nullPointerException = new NullPointerException();
        b(nullPointerException, Intrinsics.class.getName());
        throw nullPointerException;
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        b(kotlinNullPointerException, Intrinsics.class.getName());
        throw kotlinNullPointerException;
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedProperty(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        b(uninitializedPropertyAccessException, Intrinsics.class.getName());
        throw uninitializedPropertyAccessException;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double d, Double d2) {
        if (d == null) {
            if (d2 == null) {
                return true;
            }
        } else if (d2 != null && d.doubleValue() == d2.doubleValue()) {
            return true;
        }
        return false;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static void needClassReification(String str) {
        throwUndefinedForReified(str);
    }

    public static void reifiedOperationMarker(int i, String str, String str2) {
        throwUndefinedForReified(str2);
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    public static void checkFieldIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            b(illegalStateException, Intrinsics.class.getName());
            throw illegalStateException;
        }
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            b(illegalStateException, Intrinsics.class.getName());
            throw illegalStateException;
        }
    }

    public static void throwAssert(String str) {
        AssertionError assertionError = new AssertionError(str);
        b(assertionError, Intrinsics.class.getName());
        throw assertionError;
    }

    public static void throwIllegalArgument(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        b(illegalArgumentException, Intrinsics.class.getName());
        throw illegalArgumentException;
    }

    public static void throwIllegalState(String str) {
        IllegalStateException illegalStateException = new IllegalStateException(str);
        b(illegalStateException, Intrinsics.class.getName());
        throw illegalStateException;
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe(String str) {
        NullPointerException nullPointerException = new NullPointerException(str);
        b(nullPointerException, Intrinsics.class.getName());
        throw nullPointerException;
    }

    public static void throwNpe(String str) {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(str);
        b(kotlinNullPointerException, Intrinsics.class.getName());
        throw kotlinNullPointerException;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float f, Float f2) {
        if (f == null) {
            if (f2 == null) {
                return true;
            }
        } else if (f2 != null && f.floatValue() == f2.floatValue()) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static void checkHasClass(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace('/', FormatterType.defaultDecimalSeparator);
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(a.d("Class ", replace, " is not found: this code requires the Kotlin runtime of version at least ", str2), e);
            b(classNotFoundException, Intrinsics.class.getName());
            throw classNotFoundException;
        }
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }
}
