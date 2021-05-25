package kotlinx.coroutines.scheduling;

import a2.b.a.a.a;
import android.support.v4.media.session.PlaybackStateCompat;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.TimeSource;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0003KLMB+\u0012\u0006\u0010>\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u0005\u0012\b\b\u0002\u0010C\u001a\u00020\u0010\u0012\b\b\u0002\u0010<\u001a\u00020*¢\u0006\u0004\bI\u0010JJ+\u0010\u000b\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0003R\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\"\u001a\u00020\b2\n\u0010\u001e\u001a\u00060\u0014j\u0002`\u00152\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J#\u0010'\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010)\u001a\u00020\bH\u0000¢\u0006\u0004\b(\u0010\u001aJ\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020$¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u0000H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\fH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\b\u0018\u00010\u0003R\u00020\u0000H\u0002¢\u0006\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020*8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b>\u0010;R\u0016\u0010@\u001a\u00020?8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0013\u0010B\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\bB\u00105R\u0016\u0010C\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020?8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bE\u0010AR\"\u0010G\u001a\u000e\u0012\n\u0012\b\u0018\u00010\u0003R\u00020\u00000F8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006N"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "worker", "", "oldIndex", "newIndex", "", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "", "state", "availableCpuPermits", "(J)I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "shutdown", "(J)V", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "Lkotlinx/coroutines/scheduling/Task;", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "", "toString", "()Ljava/lang/String;", "task", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "c", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "d", "(J)Z", "e", "()Z", AuthSource.SEND_ABUSE, "()I", AuthSource.BOOKING_ORDER, "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "maxPoolSize", "I", "schedulerName", "Ljava/lang/String;", "corePoolSize", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "isTerminated", "idleWorkerKeepAliveNs", "J", "globalCpuQueue", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "<init>", "(IIJLjava/lang/String;)V", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class CoroutineScheduler implements Executor, Closeable {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    @JvmField
    @NotNull
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    public static final AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    private volatile int _isTerminated;
    public volatile long controlState;
    @JvmField
    public final int corePoolSize;
    @JvmField
    @NotNull
    public final GlobalQueue globalBlockingQueue;
    @JvmField
    @NotNull
    public final GlobalQueue globalCpuQueue;
    @JvmField
    public final long idleWorkerKeepAliveNs;
    @JvmField
    public final int maxPoolSize;
    private volatile long parkedWorkersStack;
    @JvmField
    @NotNull
    public final String schedulerName;
    @JvmField
    @NotNull
    public final AtomicReferenceArray<Worker> workers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00058\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "", "BLOCKING_MASK", "J", "", "BLOCKING_SHIFT", "I", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "Lkotlinx/coroutines/internal/Symbol;", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WorkerState.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[1] = 2;
            iArr[0] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b7\u00108J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010+R\u0014\u00100\u001a\u00020-8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010\u001cR\u0016\u00104\u001a\u0002038\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010+¨\u00069"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "", "run", "()V", "", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "scanLocalQueue", "Lkotlinx/coroutines/scheduling/Task;", "findTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", AuthSource.SEND_ABUSE, "()Lkotlinx/coroutines/scheduling/Task;", "blockingOnly", AuthSource.BOOKING_ORDER, "mayHaveLocalTasks", "Z", FirebaseAnalytics.Param.INDEX, "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "", "J", "minDelayUntilStealableTaskNs", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "c", "rngState", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "terminationDeadline", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        public long a;
        public long b;
        public int c = Random.Default.nextInt();
        public volatile int indexInArray;
        @JvmField
        @NotNull
        public final WorkQueue localQueue = new WorkQueue();
        @JvmField
        public boolean mayHaveLocalTasks;
        @Nullable
        public volatile Object nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
        @JvmField
        @NotNull
        public WorkerState state = WorkerState.DORMANT;
        @NotNull
        public volatile int workerCtl = 0;

        public Worker(int i) {
            setDaemon(true);
            setIndexInArray(i);
        }

        public final Task a() {
            if (nextInt$kotlinx_coroutines_core(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    return task;
                }
                return (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (task2 != null) {
                return task2;
            }
            return (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        public final Task b(boolean z) {
            long j;
            int access$getCreatedWorkers$p = CoroutineScheduler.access$getCreatedWorkers$p(CoroutineScheduler.this);
            if (access$getCreatedWorkers$p < 2) {
                return null;
            }
            int nextInt$kotlinx_coroutines_core = nextInt$kotlinx_coroutines_core(access$getCreatedWorkers$p);
            long j2 = Long.MAX_VALUE;
            for (int i = 0; i < access$getCreatedWorkers$p; i++) {
                nextInt$kotlinx_coroutines_core++;
                if (nextInt$kotlinx_coroutines_core > access$getCreatedWorkers$p) {
                    nextInt$kotlinx_coroutines_core = 1;
                }
                Worker worker = CoroutineScheduler.this.workers.get(nextInt$kotlinx_coroutines_core);
                if (!(worker == null || worker == this)) {
                    if (z) {
                        j = this.localQueue.tryStealBlockingFrom(worker.localQueue);
                    } else {
                        j = this.localQueue.tryStealFrom(worker.localQueue);
                    }
                    if (j == -1) {
                        return this.localQueue.poll();
                    }
                    if (j > 0) {
                        j2 = Math.min(j2, j);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.b = j2;
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlinx.coroutines.scheduling.Task findTask(boolean r11) {
            /*
                r10 = this;
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = r10.state
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x0009
                goto L_0x0032
            L_0x0009:
                kotlinx.coroutines.scheduling.CoroutineScheduler r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
            L_0x000b:
                long r6 = r0.controlState
                r4 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
                long r4 = r4 & r6
                r1 = 42
                long r4 = r4 >> r1
                int r1 = (int) r4
                if (r1 != 0) goto L_0x001b
                r0 = 0
                goto L_0x002c
            L_0x001b:
                r4 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
                long r8 = r6 - r4
                java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.scheduling.CoroutineScheduler.b
                r5 = r0
                boolean r1 = r4.compareAndSet(r5, r6, r8)
                if (r1 == 0) goto L_0x000b
                r0 = 1
            L_0x002c:
                if (r0 == 0) goto L_0x0034
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED
                r10.state = r0
            L_0x0032:
                r0 = 1
                goto L_0x0035
            L_0x0034:
                r0 = 0
            L_0x0035:
                if (r0 == 0) goto L_0x006e
                if (r11 == 0) goto L_0x0062
                kotlinx.coroutines.scheduling.CoroutineScheduler r11 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                int r11 = r11.corePoolSize
                int r11 = r11 * 2
                int r11 = r10.nextInt$kotlinx_coroutines_core(r11)
                if (r11 != 0) goto L_0x0046
                goto L_0x0047
            L_0x0046:
                r2 = 0
            L_0x0047:
                if (r2 == 0) goto L_0x0050
                kotlinx.coroutines.scheduling.Task r11 = r10.a()
                if (r11 == 0) goto L_0x0050
                goto L_0x006d
            L_0x0050:
                kotlinx.coroutines.scheduling.WorkQueue r11 = r10.localQueue
                kotlinx.coroutines.scheduling.Task r11 = r11.poll()
                if (r11 == 0) goto L_0x0059
                goto L_0x006d
            L_0x0059:
                if (r2 != 0) goto L_0x0069
                kotlinx.coroutines.scheduling.Task r11 = r10.a()
                if (r11 == 0) goto L_0x0069
                goto L_0x006d
            L_0x0062:
                kotlinx.coroutines.scheduling.Task r11 = r10.a()
                if (r11 == 0) goto L_0x0069
                goto L_0x006d
            L_0x0069:
                kotlinx.coroutines.scheduling.Task r11 = r10.b(r3)
            L_0x006d:
                return r11
            L_0x006e:
                if (r11 == 0) goto L_0x0084
                kotlinx.coroutines.scheduling.WorkQueue r11 = r10.localQueue
                kotlinx.coroutines.scheduling.Task r11 = r11.poll()
                if (r11 == 0) goto L_0x0079
                goto L_0x008e
            L_0x0079:
                kotlinx.coroutines.scheduling.CoroutineScheduler r11 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                kotlinx.coroutines.scheduling.GlobalQueue r11 = r11.globalBlockingQueue
                java.lang.Object r11 = r11.removeFirstOrNull()
                kotlinx.coroutines.scheduling.Task r11 = (kotlinx.coroutines.scheduling.Task) r11
                goto L_0x008e
            L_0x0084:
                kotlinx.coroutines.scheduling.CoroutineScheduler r11 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                kotlinx.coroutines.scheduling.GlobalQueue r11 = r11.globalBlockingQueue
                java.lang.Object r11 = r11.removeFirstOrNull()
                kotlinx.coroutines.scheduling.Task r11 = (kotlinx.coroutines.scheduling.Task) r11
            L_0x008e:
                if (r11 == 0) goto L_0x0091
                goto L_0x0095
            L_0x0091:
                kotlinx.coroutines.scheduling.Task r11 = r10.b(r2)
            L_0x0095:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.findTask(boolean):kotlinx.coroutines.scheduling.Task");
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @NotNull
        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final int nextInt$kotlinx_coroutines_core(int i) {
            int i2 = this.c;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.c = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WorkerState workerState;
            WorkerState workerState2;
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != (workerState = WorkerState.TERMINATED)) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask == null) {
                        this.mayHaveLocalTasks = false;
                        if (this.b == 0) {
                            if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                this.workerCtl = -1;
                                while (true) {
                                    if (!(this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) || CoroutineScheduler.this.isTerminated() || this.state == (workerState2 = WorkerState.TERMINATED)) {
                                        break;
                                    }
                                    tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                                    Thread.interrupted();
                                    if (this.a == 0) {
                                        this.a = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                    }
                                    LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                    if (System.nanoTime() - this.a >= 0) {
                                        this.a = 0;
                                        synchronized (CoroutineScheduler.this.workers) {
                                            if (!CoroutineScheduler.this.isTerminated()) {
                                                if (CoroutineScheduler.access$getCreatedWorkers$p(CoroutineScheduler.this) > CoroutineScheduler.this.corePoolSize) {
                                                    if (e.compareAndSet(this, -1, 1)) {
                                                        int i = this.indexInArray;
                                                        setIndexInArray(0);
                                                        CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(this, i, 0);
                                                        int andDecrement = (int) (CoroutineScheduler.b.getAndDecrement(CoroutineScheduler.this) & 2097151);
                                                        if (andDecrement != i) {
                                                            Worker worker = CoroutineScheduler.this.workers.get(andDecrement);
                                                            Intrinsics.checkNotNull(worker);
                                                            Worker worker2 = worker;
                                                            CoroutineScheduler.this.workers.set(i, worker2);
                                                            worker2.setIndexInArray(i);
                                                            CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(worker2, andDecrement, i);
                                                        }
                                                        CoroutineScheduler.this.workers.set(andDecrement, null);
                                                        this.state = workerState2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                CoroutineScheduler.this.parkedWorkersStackPush$kotlinx_coroutines_core(this);
                            }
                        } else if (!z) {
                            z = true;
                        } else {
                            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.b);
                            this.b = 0;
                        }
                    } else {
                        this.b = 0;
                        int taskMode = findTask.taskContext.getTaskMode();
                        this.a = 0;
                        if (this.state == WorkerState.PARKING) {
                            this.state = WorkerState.BLOCKING;
                        }
                        if (taskMode != 0 && tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                            CoroutineScheduler.this.signalCpuWork$kotlinx_coroutines_core();
                        }
                        CoroutineScheduler.this.runSafely(findTask);
                        if (taskMode != 0) {
                            CoroutineScheduler.b.addAndGet(CoroutineScheduler.this, -2097152);
                            if (this.state != workerState) {
                                this.state = WorkerState.DORMANT;
                            }
                        }
                    }
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.b.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i, int i2, long j, @NotNull String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i >= 1) {
            if (i2 >= i) {
                if (i2 <= 2097150) {
                    if (j > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.parkedWorkersStack = 0;
                        this.workers = new AtomicReferenceArray<>(i2 + 1);
                        this.controlState = ((long) i) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(a.V2("Idle worker keep alive time ", j, " must be positive").toString());
                }
                throw new IllegalArgumentException(a.Q2("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(a.R2("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        throw new IllegalArgumentException(a.Q2("Core pool size ", i, " should be at least 1").toString());
    }

    public static final int access$createdWorkers(CoroutineScheduler coroutineScheduler, long j) {
        Objects.requireNonNull(coroutineScheduler);
        return (int) (j & 2097151);
    }

    public static final void access$decrementBlockingTasks(CoroutineScheduler coroutineScheduler) {
        Objects.requireNonNull(coroutineScheduler);
        b.addAndGet(coroutineScheduler, -2097152);
    }

    public static final int access$decrementCreatedWorkers(CoroutineScheduler coroutineScheduler) {
        Objects.requireNonNull(coroutineScheduler);
        return (int) (b.getAndDecrement(coroutineScheduler) & 2097151);
    }

    public static final int access$getCreatedWorkers$p(CoroutineScheduler coroutineScheduler) {
        return (int) (coroutineScheduler.controlState & 2097151);
    }

    public static final long access$releaseCpuPermit(CoroutineScheduler coroutineScheduler) {
        Objects.requireNonNull(coroutineScheduler);
        return b.addAndGet(coroutineScheduler, 4398046511104L);
    }

    public static final boolean access$tryAcquireCpuPermit(CoroutineScheduler coroutineScheduler) {
        long j;
        do {
            j = coroutineScheduler.controlState;
            if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                return false;
            }
        } while (!b.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
        return true;
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final int a() {
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            boolean z = false;
            int coerceAtLeast = e.coerceAtLeast(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (coerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (i2 > 0 && this.workers.get(i2) == null) {
                Worker worker = new Worker(i2);
                this.workers.set(i2, worker);
                if (i2 == ((int) (2097151 & b.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    worker.start();
                    return coerceAtLeast + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final int availableCpuPermits(long j) {
        return (int) ((j & 9223367638808264704L) >> 42);
    }

    public final Worker b() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public final int c(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000);
    }

    @NotNull
    public final Task createTask$kotlinx_coroutines_core(@NotNull Runnable runnable, @NotNull TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, nanoTime, taskContext);
        }
        Task task = (Task) runnable;
        task.submissionTime = nanoTime;
        task.taskContext = taskContext;
        return task;
    }

    public final boolean d(long j) {
        if (e.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int a3 = a();
            if (a3 == 1 && this.corePoolSize > 1) {
                a();
            }
            if (a3 > 0) {
                return true;
            }
        }
        return false;
    }

    public final void dispatch(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        Task task;
        boolean z2;
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        Task createTask$kotlinx_coroutines_core = createTask$kotlinx_coroutines_core(runnable, taskContext);
        Worker b2 = b();
        boolean z3 = true;
        if (b2 == null || b2.state == WorkerState.TERMINATED || (createTask$kotlinx_coroutines_core.taskContext.getTaskMode() == 0 && b2.state == WorkerState.BLOCKING)) {
            task = createTask$kotlinx_coroutines_core;
        } else {
            b2.mayHaveLocalTasks = true;
            task = b2.localQueue.add(createTask$kotlinx_coroutines_core, z);
        }
        if (task != null) {
            if (task.taskContext.getTaskMode() == 1) {
                z2 = this.globalBlockingQueue.addLast(task);
            } else {
                z2 = this.globalCpuQueue.addLast(task);
            }
            if (!z2) {
                throw new RejectedExecutionException(a.t(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        if (!z || b2 == null) {
            z3 = false;
        }
        if (createTask$kotlinx_coroutines_core.taskContext.getTaskMode() != 0) {
            long addAndGet = b.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
            if (!z3 && !e() && !d(addAndGet)) {
                e();
            }
        } else if (!z3) {
            signalCpuWork$kotlinx_coroutines_core();
        }
    }

    public final boolean e() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = this.workers.get((int) (2097151 & j));
            if (worker != null) {
                long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
                int c2 = c(worker);
                if (c2 >= 0 && a.compareAndSet(this, j, ((long) c2) | j2)) {
                    worker.setNextParkedWorker(NOT_IN_STACK);
                }
            } else {
                worker = null;
            }
            if (worker == null) {
                return false;
            }
            if (Worker.e.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        dispatch$default(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isTerminated() {
        /*
            r1 = this;
            int r0 = r1._isTerminated
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.isTerminated():boolean");
    }

    public final boolean parkedWorkersStackPush$kotlinx_coroutines_core(@NotNull Worker worker) {
        long j;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.workers.get((int) (2097151 & j)));
        } while (!a.compareAndSet(this, j, ((PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152) | ((long) indexInArray)));
        return true;
    }

    public final void parkedWorkersStackTopUpdate$kotlinx_coroutines_core(@NotNull Worker worker, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            if (i3 == i) {
                i3 = i2 == 0 ? c(worker) : i2;
            }
            if (i3 >= 0 && a.compareAndSet(this, j, j2 | ((long) i3))) {
                return;
            }
        }
    }

    public final void runSafely(@NotNull Task task) {
        TimeSource timeSource;
        try {
            task.run();
            timeSource = TimeSourceKt.getTimeSource();
            if (timeSource == null) {
                return;
            }
        } catch (Throwable th) {
            TimeSource timeSource2 = TimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            throw th;
        }
        timeSource.unTrackTask();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r8 != null) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void shutdown(long r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.c
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = r7.b()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r1 = r7.workers
            monitor-enter(r1)
            long r3 = r7.controlState     // Catch:{ all -> 0x007d }
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r4 = (int) r3
            monitor-exit(r1)
            if (r2 > r4) goto L_0x0043
            r1 = 1
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r3 = r7.workers
            java.lang.Object r3 = r3.get(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r3 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r3
            if (r3 == r0) goto L_0x003e
        L_0x002a:
            boolean r5 = r3.isAlive()
            if (r5 == 0) goto L_0x0037
            java.util.concurrent.locks.LockSupport.unpark(r3)
            r3.join(r8)
            goto L_0x002a
        L_0x0037:
            kotlinx.coroutines.scheduling.WorkQueue r3 = r3.localQueue
            kotlinx.coroutines.scheduling.GlobalQueue r5 = r7.globalBlockingQueue
            r3.offloadAllWorkTo(r5)
        L_0x003e:
            if (r1 == r4) goto L_0x0043
            int r1 = r1 + 1
            goto L_0x001d
        L_0x0043:
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.globalBlockingQueue
            r8.close()
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.globalCpuQueue
            r8.close()
        L_0x004d:
            if (r0 == 0) goto L_0x0056
            kotlinx.coroutines.scheduling.Task r8 = r0.findTask(r2)
            if (r8 == 0) goto L_0x0056
            goto L_0x005e
        L_0x0056:
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.globalCpuQueue
            java.lang.Object r8 = r8.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r8 = (kotlinx.coroutines.scheduling.Task) r8
        L_0x005e:
            if (r8 == 0) goto L_0x0061
            goto L_0x0069
        L_0x0061:
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.globalBlockingQueue
            java.lang.Object r8 = r8.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r8 = (kotlinx.coroutines.scheduling.Task) r8
        L_0x0069:
            if (r8 == 0) goto L_0x006f
            r7.runSafely(r8)
            goto L_0x004d
        L_0x006f:
            if (r0 == 0) goto L_0x0076
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu$kotlinx_coroutines_core(r8)
        L_0x0076:
            r8 = 0
            r7.parkedWorkersStack = r8
            r7.controlState = r8
            return
        L_0x007d:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.shutdown(long):void");
    }

    public final void signalCpuWork$kotlinx_coroutines_core() {
        if (!e() && !d(this.controlState)) {
            e();
        }
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.workers.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            Worker worker = this.workers.get(i6);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int ordinal = worker.state.ordinal();
                if (ordinal == 0) {
                    i++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "c");
                } else if (ordinal == 1) {
                    i2++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + AuthSource.BOOKING_ORDER);
                } else if (ordinal == 2) {
                    i3++;
                } else if (ordinal == 3) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "d");
                    }
                } else if (ordinal == 4) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, j jVar) {
        this(i, i2, (i3 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }
}
