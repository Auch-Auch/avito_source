package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eB\t\b\u0016¢\u0006\u0004\b\r\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "submissionTime", "J", "", "getMode", "()I", "mode", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "<init>", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class Task implements Runnable {
    @JvmField
    public long submissionTime;
    @JvmField
    @NotNull
    public TaskContext taskContext;

    public Task(long j, @NotNull TaskContext taskContext2) {
        this.submissionTime = j;
        this.taskContext = taskContext2;
    }

    public final int getMode() {
        return this.taskContext.getTaskMode();
    }

    public Task() {
        this(0, NonBlockingContext.INSTANCE);
    }
}
