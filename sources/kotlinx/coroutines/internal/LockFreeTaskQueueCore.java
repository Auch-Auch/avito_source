package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0014\b\u0000\u0018\u0000 #*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002#$B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0001\u0010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0005R\u0013\u0010\u0015\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0013\u0010\u0018\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", ExifInterface.LONGITUDE_EAST, "", "close", "()Z", "element", "", "addLast", "(Ljava/lang/Object;)I", "removeFirstOrNull", "()Ljava/lang/Object;", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "isClosed", "isEmpty", "getSize", "()I", "size", "c", "I", "capacity", AuthSource.SEND_ABUSE, "mask", "d", "Z", "singleConsumer", "<init>", "(IZ)V", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final Companion Companion = new Companion(null);
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    @JvmField
    @NotNull
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    public static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    private volatile Object _next = null;
    private volatile long _state = 0;
    public final int a;
    public AtomicReferenceArray b;
    public final int c;
    public final boolean d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,J\u001c\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\tJR\u0010\u0013\u001a\u00028\u0001\"\u0004\b\u0001\u0010\f*\u00020\u000226\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00010\rH\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0016\u0010#\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010$\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010%\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u0018R\u0016\u0010'\u001a\u00020&8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0016\u0010*\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u0018¨\u0006-"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "", "other", "wo", "(JJ)J", "", "newHead", "updateHead", "(JI)J", "newTail", "updateTail", "T", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "block", "withState", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "addFailReason", "(J)I", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final int addFailReason(long j) {
            return (j & LockFreeTaskQueueCore.CLOSED_MASK) != 0 ? 2 : 1;
        }

        public final long updateHead(long j, int i) {
            return wo(j, LockFreeTaskQueueCore.HEAD_MASK) | (((long) i) << 0);
        }

        public final long updateTail(long j, int i) {
            return wo(j, LockFreeTaskQueueCore.TAIL_MASK) | (((long) i) << 30);
        }

        public final <T> T withState(long j, @NotNull Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return (T) function2.invoke(Integer.valueOf((int) ((LockFreeTaskQueueCore.HEAD_MASK & j) >> 0)), Integer.valueOf((int) ((j & LockFreeTaskQueueCore.TAIL_MASK) >> 30)));
        }

        public final long wo(long j, long j2) {
            return j & (~j2);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "", FirebaseAnalytics.Param.INDEX, "I", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class Placeholder {
        @JvmField
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.c = i;
        this.d = z;
        int i2 = i - 1;
        this.a = i2;
        this.b = new AtomicReferenceArray(i);
        boolean z2 = false;
        if (i2 <= 1073741823) {
            if (!((i & i2) == 0 ? true : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int addLast(@NotNull E e2) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return Companion.addFailReason(j);
            }
            Companion companion = Companion;
            int i = (int) ((HEAD_MASK & j) >> 0);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.a;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (this.d || this.b.get(i2 & i3) == null) {
                if (f.compareAndSet(this, j, companion.updateTail(j, (i2 + 1) & MAX_CAPACITY_MASK))) {
                    this.b.set(i2 & i3, e2);
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    while ((lockFreeTaskQueueCore._state & FROZEN_MASK) != 0) {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.next();
                        Object obj = lockFreeTaskQueueCore.b.get(lockFreeTaskQueueCore.a & i2);
                        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != i2) {
                            lockFreeTaskQueueCore = null;
                            continue;
                        } else {
                            lockFreeTaskQueueCore.b.set(lockFreeTaskQueueCore.a & i2, e2);
                            continue;
                        }
                        if (lockFreeTaskQueueCore == null) {
                            break;
                        }
                    }
                    return 0;
                }
            } else {
                int i4 = this.c;
                if (i4 < 1024 || ((i2 - i) & MAX_CAPACITY_MASK) > (i4 >> 1)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final boolean close() {
        long j;
        do {
            j = this._state;
            if ((j & CLOSED_MASK) != 0) {
                return true;
            }
            if ((FROZEN_MASK & j) != 0) {
                return false;
            }
        } while (!f.compareAndSet(this, j, j | CLOSED_MASK));
        return true;
    }

    public final int getSize() {
        long j = this._state;
        return 1073741823 & (((int) ((j & TAIL_MASK) >> 30)) - ((int) ((HEAD_MASK & j) >> 0)));
    }

    public final boolean isClosed() {
        return (this._state & CLOSED_MASK) != 0;
    }

    public final boolean isEmpty() {
        long j = this._state;
        return ((int) ((HEAD_MASK & j) >> 0)) == ((int) ((j & TAIL_MASK) >> 30));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> function1) {
        ArrayList arrayList = new ArrayList(this.c);
        long j = this._state;
        int i = (int) ((HEAD_MASK & j) >> 0);
        int i2 = (int) ((j & TAIL_MASK) >> 30);
        while (true) {
            int i3 = this.a;
            if ((i & i3) == (i2 & i3)) {
                return arrayList;
            }
            Object obj = (Object) this.b.get(i3 & i);
            if (obj != 0 && !(obj instanceof Placeholder)) {
                arrayList.add(function1.invoke(obj));
            }
            i++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v2, resolved type: java.util.concurrent.atomic.AtomicReferenceArray */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final LockFreeTaskQueueCore<E> next() {
        long j;
        while (true) {
            j = this._state;
            if ((j & FROZEN_MASK) == 0) {
                long j2 = j | FROZEN_MASK;
                if (f.compareAndSet(this, j, j2)) {
                    j = j2;
                    break;
                }
            } else {
                break;
            }
        }
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(this.c * 2, this.d);
            int i = (int) ((HEAD_MASK & j) >> 0);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            while (true) {
                int i3 = this.a;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object obj = this.b.get(i4);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                lockFreeTaskQueueCore2.b.set(lockFreeTaskQueueCore2.a & i, obj);
                i++;
            }
            lockFreeTaskQueueCore2._state = Companion.wo(j, FROZEN_MASK);
            atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueueCore2);
        }
    }

    @Nullable
    public final Object removeFirstOrNull() {
        int i;
        while (true) {
            long j = this._state;
            if ((j & FROZEN_MASK) != 0) {
                return REMOVE_FROZEN;
            }
            Companion companion = Companion;
            int i2 = (int) ((j & HEAD_MASK) >> 0);
            int i3 = (int) ((TAIL_MASK & j) >> 30);
            int i4 = this.a;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.b.get(i4 & i2);
            if (obj == null) {
                if (this.d) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i5 = 1073741823 & (i2 + 1);
                int i6 = i5;
                if (f.compareAndSet(this, j, companion.updateHead(j, i5))) {
                    this.b.set(this.a & i2, null);
                    return obj;
                } else if (this.d) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    while (true) {
                        long j2 = lockFreeTaskQueueCore._state;
                        Companion companion2 = Companion;
                        int i7 = (int) ((j2 & HEAD_MASK) >> 0);
                        if ((j2 & FROZEN_MASK) != 0) {
                            lockFreeTaskQueueCore = lockFreeTaskQueueCore.next();
                            i = i6;
                        } else {
                            i = i6;
                            if (f.compareAndSet(lockFreeTaskQueueCore, j2, companion2.updateHead(j2, i))) {
                                lockFreeTaskQueueCore.b.set(lockFreeTaskQueueCore.a & i7, null);
                                lockFreeTaskQueueCore = null;
                            } else {
                                continue;
                                i6 = i;
                            }
                        }
                        if (lockFreeTaskQueueCore == null) {
                            return obj;
                        }
                        i6 = i;
                    }
                }
            }
        }
    }
}
