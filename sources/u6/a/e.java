package u6.a;

import a2.b.a.a.a;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class e extends JobNode<Job> {
    public final Future<?> d;

    public e(@NotNull Job job, @NotNull Future<?> future) {
        super(job);
        this.d = future;
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
        StringBuilder L = a.L("CancelFutureOnCompletion[");
        L.append(this.d);
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(@Nullable Throwable th) {
        this.d.cancel(false);
    }
}
