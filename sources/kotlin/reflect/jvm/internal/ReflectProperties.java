package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class ReflectProperties {

    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        public final Function0<T> b;
        public volatile SoftReference<Object> c;

        public LazySoftVal(@Nullable T t, @NotNull Function0<T> function0) {
            if (function0 != null) {
                this.c = null;
                this.b = function0;
                if (t != null) {
                    this.c = new SoftReference<>(escape(t));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return unescape(obj);
            }
            T invoke = this.b.invoke();
            this.c = new SoftReference<>(escape(invoke));
            return invoke;
        }
    }

    public static class LazyVal<T> extends Val<T> {
        public final Function0<T> b;
        public volatile Object c;

        public LazyVal(@NotNull Function0<T> function0) {
            if (function0 != null) {
                this.c = null;
                this.b = function0;
                return;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj = this.c;
            if (obj != null) {
                return unescape(obj);
            }
            T invoke = this.b.invoke();
            this.c = escape(invoke);
            return invoke;
        }
    }

    public static abstract class Val<T> {
        public static final Object a = new a();

        public static class a {
        }

        public Object escape(T t) {
            return t == null ? a : t;
        }

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public abstract T invoke();

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public T unescape(Object obj) {
            if (obj == a) {
                return null;
            }
            return obj;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @NotNull
    public static <T> LazyVal<T> lazy(@NotNull Function0<T> function0) {
        if (function0 != null) {
            return new LazyVal<>(function0);
        }
        a(0);
        throw null;
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@Nullable T t, @NotNull Function0<T> function0) {
        if (function0 != null) {
            return new LazySoftVal<>(t, function0);
        }
        a(1);
        throw null;
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@NotNull Function0<T> function0) {
        if (function0 != null) {
            return lazySoft(null, function0);
        }
        a(2);
        throw null;
    }
}
