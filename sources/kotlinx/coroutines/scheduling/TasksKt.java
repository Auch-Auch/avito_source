package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0016\u0010\n\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u00038\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\u0005\"\u0016\u0010\r\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\r\u0010\u0002\"\u0016\u0010\u000e\u001a\u00020\u00068\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\b\"\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u000f8À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0016\u0010\u0013\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0002\"\u0016\u0010\u0014\u001a\u00020\u00008\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0002\"\u0016\u0010\u0015\u001a\u00020\u00008\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0002¨\u0006\u0016"}, d2 = {"", "BLOCKING_DEFAULT_PARALLELISM", "I", "", "DEFAULT_DISPATCHER_NAME", "Ljava/lang/String;", "", "WORK_STEALING_TIME_RESOLUTION_NS", "J", "Lkotlinx/coroutines/scheduling/TimeSource;", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "DEFAULT_SCHEDULER_NAME", "TASK_NON_BLOCKING", "IDLE_WORKER_KEEP_ALIVE_NS", "Lkotlinx/coroutines/scheduling/Task;", "", "isBlocking", "(Lkotlinx/coroutines/scheduling/Task;)Z", "TASK_PROBABLY_BLOCKING", "CORE_POOL_SIZE", "MAX_POOL_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class TasksKt {
    @JvmField
    public static final int BLOCKING_DEFAULT_PARALLELISM = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
    @JvmField
    public static final int CORE_POOL_SIZE;
    @NotNull
    public static final String DEFAULT_DISPATCHER_NAME = "Dispatchers.Default";
    @NotNull
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
    @JvmField
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null));
    @JvmField
    public static final int MAX_POOL_SIZE;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;
    @JvmField
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);
    @JvmField
    @NotNull
    public static TimeSource schedulerTimeSource = NanoTimeSource.INSTANCE;

    static {
        int systemProp$default = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", e.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);
        CORE_POOL_SIZE = systemProp$default;
        MAX_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", e.coerceIn(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, systemProp$default, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE), 0, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, (Object) null);
    }

    public static final boolean isBlocking(@NotNull Task task) {
        return task.taskContext.getTaskMode() == 1;
    }
}
