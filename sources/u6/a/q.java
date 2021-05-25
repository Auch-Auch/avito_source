package u6.a;

import a2.b.a.a.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class q extends JobCancellingNode<Job> {
    public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(q.class, "_invoked");
    private volatile int _invoked = 0;
    public final Function1<Throwable, Unit> d;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public q(@NotNull Job job, @NotNull Function1<? super Throwable, Unit> function1) {
        super(job);
        this.d = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        StringBuilder L = a.L("InvokeOnCancelling[");
        L.append(DebugStringsKt.getClassSimpleName(this));
        L.append('@');
        L.append(DebugStringsKt.getHexAddress(this));
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(@Nullable Throwable th) {
        if (e.compareAndSet(this, 0, 1)) {
            this.d.invoke(th);
        }
    }
}
