package kotlinx.coroutines.internal;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\n\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b.\u0010\bJ\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\nJ&\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u00002\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\fH\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u0017\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001aH\u0010¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$R \u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010&R\u0013\u0010'\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010(R$\u0010-\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a8F@BX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010!¨\u0006/"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "clear", "()V", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "Lkotlin/Function1;", "", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "node", "addLast", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", ProductAction.ACTION_REMOVE, "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "", FirebaseAnalytics.Param.INDEX, "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "i", AuthSource.SEND_ABUSE, "(I)V", "j", AuthSource.BOOKING_ORDER, "(II)V", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    public volatile int _size = 0;
    public T[] a;

    public final void a(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) > 0) {
                b(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    @PublishedApi
    public final void addImpl(@NotNull T t) {
        t.setHeap(this);
        T[] tArr = this.a;
        if (tArr == null) {
            tArr = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr;
        } else if (getSize() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.a = tArr;
        }
        int size = getSize();
        this._size = size + 1;
        tArr[size] = t;
        t.setIndex(size);
        a(size);
    }

    public final void addLast(@NotNull T t) {
        synchronized (this) {
            addImpl(t);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(@NotNull T t, @NotNull Function1<? super T, Boolean> function1) {
        boolean z;
        synchronized (this) {
            try {
                if (function1.invoke(firstImpl()).booleanValue()) {
                    addImpl(t);
                    z = true;
                } else {
                    z = false;
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return z;
    }

    public final void b(int i, int i2) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[i2];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }

    public final void clear() {
        synchronized (this) {
            T[] tArr = this.a;
            if (tArr != null) {
                ArraysKt___ArraysJvmKt.fill$default(tArr, (Object) null, 0, 0, 6, (Object) null);
            }
            this._size = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    @PublishedApi
    @Nullable
    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    @Nullable
    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(@NotNull T t) {
        boolean z;
        synchronized (this) {
            if (t.getHeap() == null) {
                z = false;
            } else {
                removeAtImpl(t.getIndex());
                z = true;
            }
        }
        return z;
    }

    @PublishedApi
    @NotNull
    public final T removeAtImpl(int i) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        this._size = getSize() - 1;
        if (i < getSize()) {
            b(i, getSize());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    b(i, i2);
                    a(i2);
                }
            }
            while (true) {
                int i3 = (i * 2) + 1;
                if (i3 >= getSize()) {
                    break;
                }
                T[] tArr2 = this.a;
                Intrinsics.checkNotNull(tArr2);
                int i4 = i3 + 1;
                if (i4 < getSize()) {
                    T t3 = tArr2[i4];
                    Intrinsics.checkNotNull(t3);
                    T t4 = tArr2[i3];
                    Intrinsics.checkNotNull(t4);
                    if (((Comparable) t3).compareTo(t4) < 0) {
                        i3 = i4;
                    }
                }
                T t5 = tArr2[i];
                Intrinsics.checkNotNull(t5);
                T t7 = tArr2[i3];
                Intrinsics.checkNotNull(t7);
                if (((Comparable) t5).compareTo(t7) <= 0) {
                    break;
                }
                b(i, i3);
                i = i3;
            }
        }
        T t8 = tArr[getSize()];
        Intrinsics.checkNotNull(t8);
        t8.setHeap(null);
        t8.setIndex(-1);
        tArr[getSize()] = null;
        return t8;
    }

    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> function1) {
        synchronized (this) {
            try {
                T firstImpl = firstImpl();
                T t = null;
                if (firstImpl != null) {
                    if (function1.invoke(firstImpl).booleanValue()) {
                        t = removeAtImpl(0);
                    }
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    return t;
                }
                InlineMarker.finallyStart(2);
                InlineMarker.finallyEnd(2);
                return null;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    @Nullable
    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = getSize() > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }
}
