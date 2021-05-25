package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class WrappedValues {
    public static final Object a = new a();
    public static volatile boolean throwWrappedProcessCanceledException = false;

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    public static class a {
        public String toString() {
            return "NULL_VALUE";
        }
    }

    public static final class b {
        public final Throwable a;

        public b(Throwable th, a aVar) {
            if (th != null) {
                this.a = th;
            } else {
                a(0);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 1 ? 3 : 2)];
            if (i != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 1) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i == 1 || i == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        if (i == 1 || i == 2) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static <V> Object escapeNull(@Nullable V v) {
        return v == null ? a : v;
    }

    @NotNull
    public static Object escapeThrowable(@NotNull Throwable th) {
        if (th != null) {
            return new b(th, null);
        }
        a(3);
        throw null;
    }

    @Nullable
    public static <V> V unescapeExceptionOrNull(@NotNull Object obj) {
        if (obj != null) {
            return (V) unescapeNull(unescapeThrowable(obj));
        }
        a(4);
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V unescapeNull(@NotNull Object obj) {
        if (obj == 0) {
            a(0);
            throw null;
        } else if (obj == a) {
            return null;
        } else {
            return obj;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V unescapeThrowable(@Nullable Object obj) {
        if (!(obj instanceof b)) {
            return obj;
        }
        Throwable th = ((b) obj).a;
        if (th == null) {
            b.a(1);
            throw null;
        } else if (!throwWrappedProcessCanceledException || !ExceptionUtilsKt.isProcessCanceledException(th)) {
            throw ExceptionUtilsKt.rethrow(th);
        } else {
            throw new WrappedProcessCanceledException(th);
        }
    }
}
