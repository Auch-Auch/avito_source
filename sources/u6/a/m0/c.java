package u6.a.m0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
public final class c implements Semaphore {
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "head");
    public static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(c.class, "deqIdx");
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "tail");
    public static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(c.class, "enqIdx");
    public static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(c.class, "_availablePermits");
    public volatile int _availablePermits;
    public final Function1<Throwable, Unit> a;
    public final int b;
    private volatile long deqIdx = 0;
    private volatile long enqIdx = 0;
    private volatile Object head;
    private volatile Object tail;

    public static final class a extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ c a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(1);
            this.a = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            this.a.release();
            return Unit.INSTANCE;
        }
    }

    public c(int i, int i2) {
        this.b = i;
        boolean z = false;
        if (i > 0) {
            if (i2 >= 0 && i >= i2) {
                z = true;
            }
            if (z) {
                d dVar = new d(0, null, 2);
                this.head = dVar;
                this.tail = dVar;
                this._availablePermits = i - i2;
                this.a = new a(this);
                return;
            }
            throw new IllegalArgumentException(a2.b.a.a.a.M2("The number of acquired permits should be in 0..", i).toString());
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Semaphore should have at least 1 permit, but had ", i).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e2 A[EDGE_INSN: B:60:0x00e2->B:44:0x00e2 ?: BREAK  , SYNTHETIC] */
    @Override // kotlinx.coroutines.sync.Semaphore
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object acquire(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
        // Method dump skipped, instructions count: 288
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.m0.c.acquire(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        Object obj;
        CancellableContinuation cancellableContinuation;
        Object tryResume;
        boolean z;
        while (true) {
            int i = this._availablePermits;
            int i2 = 0;
            if (!(i < this.b)) {
                StringBuilder L = a2.b.a.a.a.L("The number of released permits cannot be greater than ");
                L.append(this.b);
                throw new IllegalStateException(L.toString().toString());
            } else if (g.compareAndSet(this, i, i + 1)) {
                if (i < 0) {
                    Segment segment = (d) this.head;
                    long andIncrement = d.getAndIncrement(this);
                    long j = andIncrement / ((long) SemaphoreKt.f);
                    do {
                        Segment segment2 = segment;
                        while (true) {
                            if (segment2.getId() >= j && !segment2.getRemoved()) {
                                obj = SegmentOrClosed.m530constructorimpl(segment2);
                                break;
                            }
                            Object access$getNextOrClosed$p = ConcurrentLinkedListNode.access$getNextOrClosed$p(segment2);
                            if (access$getNextOrClosed$p == ConcurrentLinkedListKt.a) {
                                obj = SegmentOrClosed.m530constructorimpl(ConcurrentLinkedListKt.a);
                                break;
                            }
                            Segment segment3 = (Segment) ((ConcurrentLinkedListNode) access$getNextOrClosed$p);
                            if (segment3 == null) {
                                segment3 = SemaphoreKt.access$createSegment(segment2.getId() + 1, (d) segment2);
                                if (segment2.trySetNext(segment3)) {
                                    if (segment2.getRemoved()) {
                                        segment2.remove();
                                    }
                                }
                            }
                            segment2 = segment3;
                        }
                        if (SegmentOrClosed.m535isClosedimpl(obj)) {
                            break;
                        }
                        Segment r7 = SegmentOrClosed.m533getSegmentimpl(obj);
                        while (true) {
                            Segment segment4 = (Segment) this.head;
                            if (segment4.getId() >= r7.getId()) {
                                break;
                            } else if (!r7.tryIncPointers$kotlinx_coroutines_core()) {
                                z = false;
                                continue;
                                break;
                            } else if (c.compareAndSet(this, segment4, r7)) {
                                if (segment4.decPointers$kotlinx_coroutines_core()) {
                                    segment4.remove();
                                }
                            } else if (r7.decPointers$kotlinx_coroutines_core()) {
                                r7.remove();
                            }
                        }
                        z = true;
                        continue;
                    } while (!z);
                    d dVar = (d) SegmentOrClosed.m533getSegmentimpl(obj);
                    dVar.cleanPrev();
                    if (dVar.getId() <= j) {
                        int i3 = (int) (andIncrement % ((long) SemaphoreKt.f));
                        Object andSet = dVar.e.getAndSet(i3, SemaphoreKt.b);
                        if (andSet == null) {
                            int i4 = SemaphoreKt.a;
                            while (true) {
                                if (i2 >= i4) {
                                    i2 = !dVar.e.compareAndSet(i3, SemaphoreKt.b, SemaphoreKt.d);
                                    break;
                                } else if (dVar.e.get(i3) == SemaphoreKt.c) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        } else if (andSet != SemaphoreKt.e && (tryResume = (cancellableContinuation = (CancellableContinuation) andSet).tryResume(Unit.INSTANCE, null, this.a)) != null) {
                            cancellableContinuation.completeResume(tryResume);
                        }
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!g.compareAndSet(this, i, i - 1));
        return true;
    }
}
