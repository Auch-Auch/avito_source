package u6.a;

import a2.b.a.a.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class v<T> extends JobNode<JobSupport> {
    public final CancellableContinuationImpl<T> d;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuationImpl<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull JobSupport jobSupport, @NotNull CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        super(jobSupport);
        this.d = cancellableContinuationImpl;
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
        StringBuilder L = a.L("ResumeAwaitOnCompletion[");
        L.append(this.d);
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(@Nullable Throwable th) {
        Object state$kotlinx_coroutines_core = ((JobSupport) this.job).getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.d;
            Throwable th2 = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(th2)));
            return;
        }
        CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.d;
        Object unboxState = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
        Result.Companion companion2 = Result.Companion;
        cancellableContinuationImpl2.resumeWith(Result.m242constructorimpl(unboxState));
    }
}
