package u6.a;

import a2.b.a.a.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class r extends JobNode<Job> {
    public final Function1<Throwable, Unit> d;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public r(@NotNull Job job, @NotNull Function1<? super Throwable, Unit> function1) {
        super(job);
        this.d = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.d.invoke(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        StringBuilder L = a.L("InvokeOnCompletion[");
        L.append(DebugStringsKt.getClassSimpleName(this));
        L.append('@');
        L.append(DebugStringsKt.getHexAddress(this));
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(@Nullable Throwable th) {
        this.d.invoke(th);
    }
}
