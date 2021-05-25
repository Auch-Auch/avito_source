package u6.a.j0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class p0<T> extends AbstractSharedFlow<q0> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public Object[] e;
    public long f;
    public long g;
    public int h;
    public int i;
    public final int j;
    public final int k;
    public final BufferOverflow l;

    public static final class a implements DisposableHandle {
        @JvmField
        @NotNull
        public final p0<?> a;
        @JvmField
        public long b;
        @JvmField
        @Nullable
        public final Object c;
        @JvmField
        @NotNull
        public final Continuation<Unit> d;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.coroutines.Continuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull p0<?> p0Var, long j, @Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
            this.a = p0Var;
            this.b = j;
            this.c = obj;
            this.d = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            p0<?> p0Var = this.a;
            synchronized (p0Var) {
                if (this.b >= p0Var.g()) {
                    Object[] objArr = p0Var.e;
                    Intrinsics.checkNotNull(objArr);
                    if (SharedFlowKt.access$getBufferAt(objArr, this.b) == this) {
                        SharedFlowKt.access$setBufferAt(objArr, this.b, SharedFlowKt.NO_VALUE);
                        p0Var.b();
                    }
                }
            }
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {314, 321, 324}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newValue", "this", "collector", "slot", "collectorJob", "newValue"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ p0 c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p0 p0Var, Continuation continuation) {
            super(continuation);
            this.c = p0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.collect(null, this);
        }
    }

    public p0(int i2, int i3, @NotNull BufferOverflow bufferOverflow) {
        this.j = i2;
        this.k = i3;
        this.l = bufferOverflow;
    }

    @Nullable
    public final /* synthetic */ Object a(@NotNull q0 q0Var, @NotNull Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            if (k(q0Var) < 0) {
                q0Var.b = cancellableContinuationImpl;
                q0Var.b = cancellableContinuationImpl;
            } else {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m242constructorimpl(unit));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void b() {
        if (this.k != 0 || this.i > 1) {
            Object[] objArr = this.e;
            Intrinsics.checkNotNull(objArr);
            while (this.i > 0 && SharedFlowKt.access$getBufferAt(objArr, (g() + ((long) h())) - 1) == SharedFlowKt.NO_VALUE) {
                this.i--;
                SharedFlowKt.access$setBufferAt(objArr, g() + ((long) h()), null);
            }
        }
    }

    public final void c() {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        Object[] objArr = this.e;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.access$setBufferAt(objArr, g(), null);
        this.h--;
        long g2 = g() + 1;
        if (this.f < g2) {
            this.f = g2;
        }
        if (this.g < g2) {
            if (!(this.b == 0 || (abstractSharedFlowSlotArr = this.a) == null)) {
                for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                    if (abstractSharedFlowSlot != null) {
                        q0 q0Var = (q0) abstractSharedFlowSlot;
                        long j2 = q0Var.a;
                        if (j2 >= 0 && j2 < g2) {
                            q0Var.a = g2;
                        }
                    }
                }
            }
            this.g = g2;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a8 A[EDGE_INSN: B:45:0x00a8->B:32:0x00a8 ?: BREAK  , SYNTHETIC] */
    @Override // kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.j0.p0.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* Return type fixed from 'kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot' to match base method */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public q0 createSlot() {
        return new q0();
    }

    /* Return type fixed from 'kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[]' to match base method */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public q0[] createSlotArray(int i2) {
        return new q0[i2];
    }

    public final void d(Object obj) {
        int h2 = h();
        Object[] objArr = this.e;
        if (objArr == null) {
            objArr = i(null, 0, 2);
        } else if (h2 >= objArr.length) {
            objArr = i(objArr, h2, objArr.length * 2);
        }
        SharedFlowKt.access$setBufferAt(objArr, g() + ((long) h2), obj);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0045 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0048 */
    /* JADX DEBUG: Multi-variable search result rejected for r12v4, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final Continuation<Unit>[] e(Continuation<Unit>[] continuationArr) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        q0 q0Var;
        Continuation<? super Unit> continuation;
        int length = continuationArr.length;
        if (!(this.b == 0 || (abstractSharedFlowSlotArr = this.a) == null)) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i2 = 0;
            continuationArr = continuationArr;
            while (i2 < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i2];
                if (!(abstractSharedFlowSlot == null || (continuation = (q0Var = (q0) abstractSharedFlowSlot).b) == null || k(q0Var) < 0)) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        Object[] copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        continuationArr = (Continuation[]) copyOf;
                    }
                    continuationArr[length] = continuation;
                    q0Var.b = null;
                    length++;
                }
                i2++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        a aVar;
        if (tryEmit(t)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (j(t)) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m242constructorimpl(unit));
                continuationArr = e(continuationArr2);
                aVar = null;
            } else {
                a aVar2 = new a(this, ((long) h()) + g(), t, cancellableContinuationImpl);
                d(aVar2);
                this.i++;
                if (this.k == 0) {
                    continuationArr2 = e(continuationArr2);
                }
                continuationArr = continuationArr2;
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, aVar);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Unit unit2 = Unit.INSTANCE;
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m242constructorimpl(unit2));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    public final long f() {
        return g() + ((long) this.h);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i2, bufferOverflow);
    }

    public final long g() {
        return Math.min(this.g, this.f);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        synchronized (this) {
            int g2 = (int) ((g() + ((long) this.h)) - this.f);
            if (g2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(g2);
            Object[] objArr = this.e;
            Intrinsics.checkNotNull(objArr);
            for (int i2 = 0; i2 < g2; i2++) {
                arrayList.add(SharedFlowKt.access$getBufferAt(objArr, this.f + ((long) i2)));
            }
            return arrayList;
        }
    }

    public final int h() {
        return this.h + this.i;
    }

    public final Object[] i(Object[] objArr, int i2, int i3) {
        if (i3 > 0) {
            Object[] objArr2 = new Object[i3];
            this.e = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long g2 = g();
            for (int i4 = 0; i4 < i2; i4++) {
                long j2 = ((long) i4) + g2;
                SharedFlowKt.access$setBufferAt(objArr2, j2, SharedFlowKt.access$getBufferAt(objArr, j2));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean j(T t) {
        if (getNCollectors() == 0) {
            if (this.j != 0) {
                d(t);
                int i2 = this.h + 1;
                this.h = i2;
                if (i2 > this.j) {
                    c();
                }
                this.g = g() + ((long) this.h);
            }
            return true;
        }
        if (this.h >= this.k && this.g <= this.f) {
            int ordinal = this.l.ordinal();
            if (ordinal == 0) {
                return false;
            }
            if (ordinal == 2) {
                return true;
            }
        }
        d(t);
        int i3 = this.h + 1;
        this.h = i3;
        if (i3 > this.k) {
            c();
        }
        long g2 = g() + ((long) this.h);
        long j2 = this.f;
        if (((int) (g2 - j2)) > this.j) {
            m(j2 + 1, this.g, f(), g() + ((long) this.h) + ((long) this.i));
        }
        return true;
    }

    public final long k(q0 q0Var) {
        long j2 = q0Var.a;
        if (j2 < f()) {
            return j2;
        }
        if (this.k <= 0 && j2 <= g() && this.i != 0) {
            return j2;
        }
        return -1;
    }

    public final Object l(q0 q0Var) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long k2 = k(q0Var);
            if (k2 < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j2 = q0Var.a;
                Object[] objArr = this.e;
                Intrinsics.checkNotNull(objArr);
                Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, k2);
                if (access$getBufferAt instanceof a) {
                    access$getBufferAt = ((a) access$getBufferAt).c;
                }
                q0Var.a = k2 + 1;
                continuationArr = n(j2);
                obj = access$getBufferAt;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m242constructorimpl(unit));
            }
        }
        return obj;
    }

    public final void m(long j2, long j3, long j4, long j5) {
        long min = Math.min(j3, j2);
        for (long g2 = g(); g2 < min; g2++) {
            Object[] objArr = this.e;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.access$setBufferAt(objArr, g2, null);
        }
        this.f = j2;
        this.g = j3;
        this.h = (int) (j4 - min);
        this.i = (int) (j5 - j4);
    }

    @NotNull
    public final Continuation<Unit>[] n(long j2) {
        int i2;
        long j3;
        long j4;
        long j5;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (j2 > this.g) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long g2 = g();
        long j6 = ((long) this.h) + g2;
        if (this.k == 0 && this.i > 0) {
            j6++;
        }
        if (!(this.b == 0 || (abstractSharedFlowSlotArr = this.a) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j7 = ((q0) abstractSharedFlowSlot).a;
                    if (j7 >= 0 && j7 < j6) {
                        j6 = j7;
                    }
                }
            }
        }
        if (j6 <= this.g) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long f2 = f();
        if (getNCollectors() > 0) {
            i2 = Math.min(this.i, this.k - ((int) (f2 - j6)));
        } else {
            i2 = this.i;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j8 = ((long) this.i) + f2;
        if (i2 > 0) {
            continuationArr = new Continuation[i2];
            Object[] objArr = this.e;
            Intrinsics.checkNotNull(objArr);
            long j9 = f2;
            int i3 = 0;
            while (true) {
                if (f2 >= j8) {
                    j4 = j6;
                    j3 = j8;
                    break;
                }
                Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, f2);
                j4 = j6;
                Symbol symbol = SharedFlowKt.NO_VALUE;
                if (access$getBufferAt != symbol) {
                    Objects.requireNonNull(access$getBufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) access$getBufferAt;
                    int i4 = i3 + 1;
                    j3 = j8;
                    continuationArr[i3] = aVar.d;
                    SharedFlowKt.access$setBufferAt(objArr, f2, symbol);
                    SharedFlowKt.access$setBufferAt(objArr, j9, aVar.c);
                    j5 = 1;
                    j9++;
                    if (i4 >= i2) {
                        break;
                    }
                    i3 = i4;
                } else {
                    j3 = j8;
                    j5 = 1;
                }
                f2 += j5;
                j6 = j4;
                j8 = j3;
            }
            f2 = j9;
        } else {
            j4 = j6;
            j3 = j8;
        }
        int i5 = (int) (f2 - g2);
        long j10 = getNCollectors() == 0 ? f2 : j4;
        long max = Math.max(this.f, f2 - ((long) Math.min(this.j, i5)));
        if (this.k == 0 && max < j3) {
            Object[] objArr2 = this.e;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(objArr2, max), SharedFlowKt.NO_VALUE)) {
                f2++;
                max++;
            }
        }
        m(max, j10, f2, j3);
        b();
        return (continuationArr.length == 0) ^ true ? e(continuationArr) : continuationArr;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            m(f(), this.g, f(), g() + ((long) this.h) + ((long) this.i));
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        int i2;
        boolean z;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (j(t)) {
                continuationArr = e(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m242constructorimpl(unit));
            }
        }
        return z;
    }
}
