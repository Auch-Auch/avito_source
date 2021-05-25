package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class LockBasedStorageManager implements StorageManager {
    public static final StorageManager NO_LOCKS = new a("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE);
    public static final String c = StringsKt__StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    public final ExceptionHandlingStrategy a;
    public final String b;
    public final SimpleLock lock;

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new a();

        public static class a implements ExceptionHandlingStrategy {
            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            @NotNull
            public RuntimeException handleException(@NotNull Throwable th) {
                throw ExceptionUtilsKt.rethrow(th);
            }
        }

        @NotNull
        RuntimeException handleException(@NotNull Throwable th);
    }

    public static class a extends LockBasedStorageManager {
        public a(String str, ExceptionHandlingStrategy exceptionHandlingStrategy, SimpleLock simpleLock) {
            super(str, exceptionHandlingStrategy, simpleLock);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
        @NotNull
        public <K, V> n<V> recursionDetectedDefault(@NotNull String str, K k) {
            return new n<>(null, true);
        }
    }

    public class b extends i<T> {
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Object obj) {
            super(lockBasedStorageManager2, function0);
            this.d = obj;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g
        @NotNull
        public n<T> c(boolean z) {
            return new n<>(this.d, false);
        }
    }

    public class c extends j<T> {
        public final /* synthetic */ Function1 e;
        public final /* synthetic */ Function1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Function1 function1, Function1 function12) {
            super(lockBasedStorageManager2, function0);
            this.e = function1;
            this.f = function12;
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i != 2 ? 2 : 3)];
            if (i != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i == 2) {
                objArr[2] = "doPostCompute";
            }
            String format = String.format(str, objArr);
            if (i != 2) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g
        @NotNull
        public n<T> c(boolean z) {
            Function1 function1 = this.e;
            if (function1 != null) {
                return new n<>(function1.invoke(Boolean.valueOf(z)), false);
            }
            n<T> c = super.c(z);
            if (c != null) {
                return c;
            }
            a(0);
            throw null;
        }
    }

    public static class d<K, V> extends e<K, V> implements CacheWithNotNullValues<K, V> {
        public d(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            super(lockBasedStorageManager, concurrentMap, null);
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$d<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        @NotNull
        public V computeIfAbsent(K k, @NotNull Function0<? extends V> function0) {
            V v = (V) invoke(new f(k, function0));
            if (v != null) {
                return v;
            }
            a(3);
            throw null;
        }
    }

    public static class e<K, V> extends k<f<K, V>, V> implements CacheWithNullableValues<K, V> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            super(lockBasedStorageManager, concurrentMap, new t6.w.f.a.m.i.a());
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            } else if (concurrentMap != null) {
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    public static class f<K, V> {
        public final K a;
        public final Function0<? extends V> b;

        public f(K k, Function0<? extends V> function0) {
            this.a = k;
            this.b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && f.class == obj.getClass() && this.a.equals(((f) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static class g<T> implements NullableLazyValue<T> {
        public final LockBasedStorageManager a;
        public final Function0<? extends T> b;
        @Nullable
        public volatile Object c;

        public g(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            } else if (function0 != null) {
                this.c = m.NOT_COMPUTED;
                this.a = lockBasedStorageManager;
                this.b = function0;
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 2 || i == 3) ? 2 : 3)];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (!(i == 2 || i == 3)) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 2 || i == 3) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        public void b(T t) {
        }

        @NotNull
        public n<T> c(boolean z) {
            n<T> recursionDetectedDefault = this.a.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedDefault != null) {
                return recursionDetectedDefault;
            }
            a(2);
            throw null;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T t;
            m mVar = m.RECURSION_WAS_DETECTED;
            m mVar2 = m.COMPUTING;
            Object obj = this.c;
            if (!(obj instanceof m)) {
                return (T) WrappedValues.unescapeThrowable(obj);
            }
            this.a.lock.lock();
            try {
                Object obj2 = this.c;
                if (!(obj2 instanceof m)) {
                    t = (T) WrappedValues.unescapeThrowable(obj2);
                } else {
                    if (obj2 == mVar2) {
                        this.c = mVar;
                        n<T> c2 = c(true);
                        if (!c2.b) {
                            t = c2.a;
                        }
                    }
                    if (obj2 == mVar) {
                        n<T> c3 = c(false);
                        if (!c3.b) {
                            t = c3.a;
                        }
                    }
                    this.c = mVar2;
                    try {
                        t = (T) this.b.invoke();
                        b(t);
                        this.c = t;
                    } catch (Throwable th) {
                        if (!ExceptionUtilsKt.isProcessCanceledException(th)) {
                            if (this.c == mVar2) {
                                this.c = WrappedValues.escapeThrowable(th);
                            }
                            throw this.a.a.handleException(th);
                        }
                        this.c = m.NOT_COMPUTED;
                        throw th;
                    }
                }
                return t;
            } finally {
                this.a.lock.unlock();
            }
        }

        public boolean isComputed() {
            return (this.c == m.NOT_COMPUTED || this.c == m.COMPUTING) ? false : true;
        }
    }

    public static abstract class h<T> extends g<T> {
        @Nullable
        public volatile t6.w.f.a.m.i.b<T> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            } else if (function0 != null) {
                this.d = null;
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g
        public final void b(T t) {
            this.d = new t6.w.f.a.m.i.b<>(t);
            t6.w.f.a.m.i.b<T> bVar = null;
            try {
                c cVar = (c) this;
                if (t != null) {
                    cVar.f.invoke(t);
                } else {
                    c.a(2);
                    throw null;
                }
            } finally {
                this.d = bVar;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g, kotlin.jvm.functions.Function0
        public T invoke() {
            t6.w.f.a.m.i.b<T> bVar = this.d;
            if (bVar != null) {
                boolean z = false;
                if (bVar.b == Thread.currentThread()) {
                    if (bVar.b == Thread.currentThread()) {
                        z = true;
                    }
                    if (z) {
                        return bVar.a;
                    }
                    throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
                }
            }
            return (T) super.invoke();
        }
    }

    public static class i<T> extends g<T> implements NotNullLazyValue<T> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            } else if (function0 != null) {
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 2 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 2) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            a(2);
            throw null;
        }
    }

    public static abstract class j<T> extends h<T> implements NotNullLazyValue<T> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            } else if (function0 != null) {
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 2 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 2) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            a(2);
            throw null;
        }
    }

    public static class k<K, V> implements MemoizedFunctionToNullable<K, V> {
        public final LockBasedStorageManager a;
        public final ConcurrentMap<K, Object> b;
        public final Function1<? super K, ? extends V> c;

        public k(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            } else if (concurrentMap == null) {
                a(1);
                throw null;
            } else if (function1 != null) {
                this.a = lockBasedStorageManager;
                this.b = concurrentMap;
                this.c = function1;
            } else {
                a(2);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 3 || i == 4) ? 2 : 3)];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (!(i == 3 || i == 4)) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 3 || i == 4) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @NotNull
        public final AssertionError b(K k, Object obj) {
            AssertionError assertionError = new AssertionError("Race condition detected on input " + ((Object) k) + ". Old value is " + obj + " under " + this.a);
            LockBasedStorageManager.c(assertionError);
            return assertionError;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public V invoke(K k) {
            T t;
            m mVar = m.RECURSION_WAS_DETECTED;
            m mVar2 = m.COMPUTING;
            Object obj = this.b.get(k);
            if (obj != null && obj != mVar2) {
                return (V) WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.a.lock.lock();
            try {
                Object obj2 = this.b.get(k);
                if (obj2 == mVar2) {
                    n<V> recursionDetectedDefault = this.a.recursionDetectedDefault("", k);
                    if (recursionDetectedDefault == null) {
                        a(3);
                        throw null;
                    } else if (!recursionDetectedDefault.b) {
                        t = recursionDetectedDefault.a;
                        return (V) t;
                    } else {
                        obj2 = mVar;
                    }
                }
                if (obj2 == mVar) {
                    n<V> recursionDetectedDefault2 = this.a.recursionDetectedDefault("", k);
                    if (recursionDetectedDefault2 == null) {
                        a(3);
                        throw null;
                    } else if (!recursionDetectedDefault2.b) {
                        t = recursionDetectedDefault2.a;
                        return (V) t;
                    }
                }
                if (obj2 != null) {
                    t = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                    return (V) t;
                }
                try {
                    this.b.put(k, mVar2);
                    V v = (V) this.c.invoke(k);
                    Object put = this.b.put(k, WrappedValues.escapeNull(v));
                    if (put == mVar2) {
                        this.a.lock.unlock();
                        return v;
                    }
                    throw b(k, put);
                } catch (Throwable th) {
                    if (ExceptionUtilsKt.isProcessCanceledException(th)) {
                        this.b.remove(k);
                        throw th;
                    } else if (th != null) {
                        Object put2 = this.b.put(k, WrappedValues.escapeThrowable(th));
                        if (put2 != mVar2) {
                            throw b(k, put2);
                        }
                        throw this.a.a.handleException(th);
                    } else {
                        throw this.a.a.handleException(th);
                    }
                }
            } finally {
                this.a.lock.unlock();
            }
        }
    }

    public static class l<K, V> extends k<K, V> implements MemoizedFunctionToNotNull<K, V> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (concurrentMap == null) {
                a(1);
                throw null;
            } else if (function1 != null) {
            } else {
                a(2);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.k, kotlin.jvm.functions.Function1
        @NotNull
        public V invoke(K k) {
            V v = (V) super.invoke(k);
            if (v != null) {
                return v;
            }
            a(3);
            throw null;
        }
    }

    public enum m {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    public static class n<T> {
        public final T a;
        public final boolean b;

        public n(T t, boolean z) {
            this.a = t;
            this.b = z;
        }

        public String toString() {
            if (this.b) {
                return "FALL_THROUGH";
            }
            return String.valueOf(this.a);
        }
    }

    public LockBasedStorageManager(@NotNull String str, @NotNull ExceptionHandlingStrategy exceptionHandlingStrategy, @NotNull SimpleLock simpleLock) {
        if (str == null) {
            a(4);
            throw null;
        } else if (exceptionHandlingStrategy == null) {
            a(5);
            throw null;
        } else if (simpleLock != null) {
            this.lock = simpleLock;
            this.a = exceptionHandlingStrategy;
            this.b = str;
        } else {
            a(6);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(int r13) {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.a(int):void");
    }

    @NotNull
    public static <K> ConcurrentMap<K, Object> b() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    @NotNull
    public static <T extends Throwable> T c(@NotNull T t) {
        if (t != null) {
            StackTraceElement[] stackTrace = t.getStackTrace();
            int length = stackTrace.length;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (!stackTrace[i3].getClassName().startsWith(c)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            List subList = Arrays.asList(stackTrace).subList(i2, length);
            t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
            return t;
        }
        a(36);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(@NotNull Function0<? extends T> function0) {
        if (function0 != null) {
            this.lock.lock();
            try {
                T t = (T) function0.invoke();
                this.lock.unlock();
                return t;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        } else {
            a(34);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new d(this, b(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new e(this, b(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 != null) {
            return new i(this, function0);
        }
        a(23);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, @NotNull Function1<? super T, Unit> function12) {
        if (function0 == null) {
            a(28);
            throw null;
        } else if (function12 != null) {
            return new c(this, this, function0, function1, function12);
        } else {
            a(29);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 != null) {
            MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(function1, b());
            if (createMemoizedFunction != null) {
                return createMemoizedFunction;
            }
            a(10);
            throw null;
        }
        a(9);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 != null) {
            MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, b());
            if (createMemoizedFunctionWithNullableValues != null) {
                return createMemoizedFunctionWithNullableValues;
            }
            a(20);
            throw null;
        }
        a(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 != null) {
            return new g(this, function0);
        }
        a(30);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> function0, @NotNull T t) {
        if (function0 == null) {
            a(26);
            throw null;
        } else if (t != null) {
            return new b(this, this, function0, t);
        } else {
            a(27);
            throw null;
        }
    }

    @NotNull
    public <K, V> n<V> recursionDetectedDefault(@NotNull String str, K k2) {
        if (str != null) {
            StringBuilder Q = a2.b.a.a.a.Q("Recursion detected ", str);
            Q.append(k2 == null ? "" : a2.b.a.a.a.b3("on input: ", k2));
            Q.append(" under ");
            Q.append(this);
            AssertionError assertionError = new AssertionError(Q.toString());
            c(assertionError);
            throw assertionError;
        }
        a(35);
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return a2.b.a.a.a.t(sb, this.b, ")");
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(14);
            throw null;
        } else if (concurrentMap != null) {
            return new l(this, concurrentMap, function1);
        } else {
            a(15);
            throw null;
        }
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(21);
            throw null;
        } else if (concurrentMap != null) {
            return new k(this, concurrentMap, function1);
        } else {
            a(22);
            throw null;
        }
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    public LockBasedStorageManager(String str, @Nullable Runnable runnable, @Nullable Function1<InterruptedException, Unit> function1) {
        this(str, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(runnable, function1));
    }
}
