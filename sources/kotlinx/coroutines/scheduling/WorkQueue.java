package kotlinx.coroutines.scheduling;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.model.VKAttachments;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0004R\u001e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006%"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "Lkotlinx/coroutines/scheduling/Task;", VKAttachments.TYPE_POLL, "()Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", ProductAction.ACTION_ADD, "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "victim", "", "tryStealFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealBlockingFrom", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", AuthSource.SEND_ABUSE, "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "blockingOnly", "c", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", AuthSource.BOOKING_ORDER, "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "getSize$kotlinx_coroutines_core", "()I", "size", "getBufferSize$kotlinx_coroutines_core", "bufferSize", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class WorkQueue {
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
    public final AtomicReferenceArray<Task> a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer = 0;
    private volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return workQueue.add(task, z);
    }

    public final Task a(Task task) {
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            e.incrementAndGet(this);
        }
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return task;
        }
        int i = this.producerIndex & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, task);
        c.incrementAndGet(this);
        return null;
    }

    @Nullable
    public final Task add(@NotNull Task task, boolean z) {
        if (z) {
            return a(task);
        }
        Task task2 = (Task) b.getAndSet(this, task);
        if (task2 != null) {
            return a(task2);
        }
        return null;
    }

    public final Task b() {
        Task andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.a.getAndSet(i2, null)) != null) {
                boolean z = true;
                if (andSet.taskContext.getTaskMode() != 1) {
                    z = false;
                }
                if (z) {
                    e.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final long c(WorkQueue workQueue, boolean z) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (task.taskContext.getTaskMode() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            long nanoTime = TasksKt.schedulerTimeSource.nanoTime() - task.submissionTime;
            long j = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (nanoTime < j) {
                return j - nanoTime;
            }
        } while (!b.compareAndSet(workQueue, task, null));
        add$default(this, task, false, 2, null);
        return -1;
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    public final void offloadAllWorkTo(@NotNull GlobalQueue globalQueue) {
        boolean z;
        Task task = (Task) b.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        do {
            Task b2 = b();
            if (b2 != null) {
                globalQueue.addLast(b2);
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
        } while (z);
    }

    @Nullable
    public final Task poll() {
        Task task = (Task) b.getAndSet(this, null);
        return task != null ? task : b();
    }

    public final long tryStealBlockingFrom(@NotNull WorkQueue workQueue) {
        int i = workQueue.consumerIndex;
        int i2 = workQueue.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = workQueue.a;
        while (true) {
            boolean z = true;
            if (i == i2) {
                break;
            }
            int i3 = i & 127;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i3);
            if (task != null) {
                if (task.taskContext.getTaskMode() != 1) {
                    z = false;
                }
                if (z && atomicReferenceArray.compareAndSet(i3, task, null)) {
                    e.decrementAndGet(workQueue);
                    add$default(this, task, false, 2, null);
                    return -1;
                }
            }
            i++;
        }
        return c(workQueue, true);
    }

    public final long tryStealFrom(@NotNull WorkQueue workQueue) {
        Task b2 = workQueue.b();
        if (b2 == null) {
            return c(workQueue, false);
        }
        add$default(this, b2, false, 2, null);
        return -1;
    }
}
