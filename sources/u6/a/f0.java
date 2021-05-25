package u6.a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class f0<T> extends ScopeCoroutine<T> {
    public f0(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    public void afterResume(@Nullable Object obj) {
        Object recoverResult = CompletionStateKt.recoverResult(obj, this.uCont);
        CoroutineContext context = this.uCont.getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
        try {
            this.uCont.resumeWith(recoverResult);
        } finally {
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
        }
    }
}
