package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004)\"*+B\u0007¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00032\n\u0010\u0018\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0004¢\u0006\u0004\b \u0010\u0005J\u001b\u0010\"\u001a\u00020!2\n\u0010\u0018\u001a\u00060\fj\u0002`\rH\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00068T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0013R\u0016\u0010&\u001a\u00020!8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "", "shutdown", "()V", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "resetAll", "", AuthSource.BOOKING_ORDER, "(Ljava/lang/Runnable;)Z", "getNextTime", "nextTime", "isEmpty", "()Z", "<init>", AuthSource.SEND_ABUSE, "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    public static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private volatile Object _delayed = null;
    public volatile int _isCompleted = 0;
    private volatile Object _queue = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010&\u001a\u00020\n¢\u0006\u0004\b/\u00100J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R0\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\f\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010(8V@VX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00061"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "other", "", "compareTo", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "", "now", "", "timeToExecute", "(J)Z", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;Lkotlinx/coroutines/EventLoopImplBase;)I", "", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "_heap", AuthSource.BOOKING_ORDER, "I", "getIndex", "()I", "setIndex", "(I)V", FirebaseAnalytics.Param.INDEX, "nanoTime", "J", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        public Object a;
        public int b = -1;
        @JvmField
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            Object obj = this.a;
            if (obj != EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                if (!(obj instanceof DelayedTaskQueue)) {
                    obj = null;
                }
                DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) obj;
                if (delayedTaskQueue != null) {
                    delayedTaskQueue.remove(this);
                }
                this.a = EventLoop_commonKt.access$getDISPOSED_TASK$p();
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        @Nullable
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this.a;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.b;
        }

        public final synchronized int scheduleTask(long j, @NotNull DelayedTaskQueue delayedTaskQueue, @NotNull EventLoopImplBase eventLoopImplBase) {
            if (this.a == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                return 2;
            }
            synchronized (delayedTaskQueue) {
                DelayedTask delayedTask = (DelayedTask) delayedTaskQueue.firstImpl();
                if (EventLoopImplBase.access$isCompleted$p(eventLoopImplBase)) {
                    return 1;
                }
                if (delayedTask == null) {
                    delayedTaskQueue.timeNow = j;
                } else {
                    long j2 = delayedTask.nanoTime;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - delayedTaskQueue.timeNow > 0) {
                        delayedTaskQueue.timeNow = j;
                    }
                }
                long j3 = this.nanoTime;
                long j4 = delayedTaskQueue.timeNow;
                if (j3 - j4 < 0) {
                    this.nanoTime = j4;
                }
                delayedTaskQueue.addImpl(this);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
            if (this.a != EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                this.a = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.b = i;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a2.b.a.a.a.k(a2.b.a.a.a.L("Delayed[nanos="), this.nanoTime, ']');
        }

        public int compareTo(@NotNull DelayedTask delayedTask) {
            int i = ((this.nanoTime - delayedTask.nanoTime) > 0 ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "timeNow", "J", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        @JvmField
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    public final class a extends DelayedTask {
        public final CancellableContinuation<Unit> c;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.c = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask, java.lang.Object
        @NotNull
        public String toString() {
            return super.toString() + this.c.toString();
        }
    }

    public static final class b extends DelayedTask {
        public final Runnable c;

        public b(long j, @NotNull Runnable runnable) {
            super(j);
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask, java.lang.Object
        @NotNull
        public String toString() {
            return super.toString() + this.c.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean access$isCompleted$p(kotlinx.coroutines.EventLoopImplBase r0) {
        /*
            int r0 = r0._isCompleted
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.access$isCompleted$p(kotlinx.coroutines.EventLoopImplBase):boolean");
    }

    public static final void access$setCompleted$p(EventLoopImplBase eventLoopImplBase, boolean z) {
        eventLoopImplBase._isCompleted = z ? 1 : 0;
    }

    public final boolean b(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (d.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore.addLast(runnable);
                if (addLast == 0) {
                    return true;
                }
                if (addLast == 1) {
                    d.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
                } else if (addLast == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.addLast((Runnable) obj);
                lockFreeTaskQueueCore2.addLast(runnable);
                if (d.compareAndSet(this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Delay
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        enqueue(runnable);
    }

    public final void enqueue(@NotNull Runnable runnable) {
        if (b(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public long getNextTime() {
        DelayedTask delayedTask;
        if (super.getNextTime() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                    return 0;
                }
            } else if (obj == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.peek()) == null) {
            return Long.MAX_VALUE;
        }
        long j = delayedTask.nanoTime;
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        return e.coerceAtLeast(j - (timeSource != null ? timeSource.nanoTime() : System.nanoTime()), 0L);
    }

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.EventLoop
    public boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
            if (obj != EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0083 A[EDGE_INSN: B:51:0x0083->B:43:0x0083 ?: BREAK  , SYNTHETIC] */
    @Override // kotlinx.coroutines.EventLoop
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long processNextEvent() {
        /*
            r9 = this;
            boolean r0 = r9.processUnconfinedEvent()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            r3 = 0
            if (r0 == 0) goto L_0x004f
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x004f
            kotlinx.coroutines.TimeSource r4 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r4 == 0) goto L_0x0021
            long r4 = r4.nanoTime()
            goto L_0x0025
        L_0x0021:
            long r4 = java.lang.System.nanoTime()
        L_0x0025:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r6 = r0.firstImpl()     // Catch:{ all -> 0x004c }
            if (r6 == 0) goto L_0x0045
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6     // Catch:{ all -> 0x004c }
            boolean r7 = r6.timeToExecute(r4)     // Catch:{ all -> 0x004c }
            r8 = 0
            if (r7 == 0) goto L_0x003a
            boolean r6 = r9.b(r6)     // Catch:{ all -> 0x004c }
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            if (r6 == 0) goto L_0x0042
            kotlinx.coroutines.internal.ThreadSafeHeapNode r6 = r0.removeAtImpl(r8)     // Catch:{ all -> 0x004c }
            goto L_0x0043
        L_0x0042:
            r6 = r3
        L_0x0043:
            monitor-exit(r0)
            goto L_0x0047
        L_0x0045:
            monitor-exit(r0)
            r6 = r3
        L_0x0047:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 == 0) goto L_0x004f
            goto L_0x0025
        L_0x004c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x004f:
            java.lang.Object r0 = r9._queue
            if (r0 != 0) goto L_0x0054
            goto L_0x0083
        L_0x0054:
            boolean r4 = r0 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r4 == 0) goto L_0x0071
            r4 = r0
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r4 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r4
            java.lang.Object r5 = r4.removeFirstOrNull()
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            if (r5 == r6) goto L_0x0067
            r3 = r5
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            goto L_0x0083
        L_0x0067:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.EventLoopImplBase.d
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r4 = r4.next()
            r5.compareAndSet(r9, r0, r4)
            goto L_0x004f
        L_0x0071:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.EventLoop_commonKt.access$getCLOSED_EMPTY$p()
            if (r0 != r4) goto L_0x0078
            goto L_0x0083
        L_0x0078:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.EventLoopImplBase.d
            boolean r4 = r4.compareAndSet(r9, r0, r3)
            if (r4 == 0) goto L_0x004f
            r3 = r0
            java.lang.Runnable r3 = (java.lang.Runnable) r3
        L_0x0083:
            if (r3 == 0) goto L_0x0089
            r3.run()
            return r1
        L_0x0089:
            long r0 = r9.getNextTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    public final void schedule(long j, @NotNull DelayedTask delayedTask) {
        int i;
        DelayedTask delayedTask2 = null;
        boolean z = true;
        if (this._isCompleted != 0) {
            i = 1;
        } else {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue == null) {
                e.compareAndSet(this, null, new DelayedTaskQueue(j));
                Object obj = this._delayed;
                Intrinsics.checkNotNull(obj);
                delayedTaskQueue = (DelayedTaskQueue) obj;
            }
            i = delayedTask.scheduleTask(j, delayedTaskQueue, this);
        }
        if (i == 0) {
            DelayedTaskQueue delayedTaskQueue2 = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue2 != null) {
                delayedTask2 = (DelayedTask) delayedTaskQueue2.peek();
            }
            if (delayedTask2 != delayedTask) {
                z = false;
            }
            if (z) {
                unpark();
            }
        } else if (i == 1) {
            reschedule(j, delayedTask);
        } else if (i != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @NotNull
    public final DisposableHandle scheduleInvokeOnTimeout(long j, @NotNull Runnable runnable) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j);
        if (delayToNanos >= 4611686018427387903L) {
            return NonDisposableHandle.INSTANCE;
        }
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
        b bVar = new b(delayToNanos + nanoTime, runnable);
        schedule(nanoTime, bVar);
        return bVar;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j);
        if (delayToNanos < 4611686018427387903L) {
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
            a aVar = new a(delayToNanos + nanoTime, cancellableContinuation);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, aVar);
            schedule(nanoTime, aVar);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        DelayedTask delayedTask;
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this._isCompleted = 1;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (d.compareAndSet(this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p())) {
                    break;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).close();
                break;
            } else if (obj == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                break;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                if (d.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    break;
                }
            }
        }
        do {
        } while (processNextEvent() <= 0);
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue != null && (delayedTask = (DelayedTask) delayedTaskQueue.removeFirstOrNull()) != null) {
                reschedule(nanoTime, delayedTask);
            } else {
                return;
            }
        }
    }
}
