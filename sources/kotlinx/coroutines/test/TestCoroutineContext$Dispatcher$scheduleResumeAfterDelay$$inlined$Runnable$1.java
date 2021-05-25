package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.test.TestCoroutineContext;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "run", "()V", "kotlinx/coroutines/RunnableKt$Runnable$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {
    public final /* synthetic */ TestCoroutineContext.Dispatcher a;
    public final /* synthetic */ CancellableContinuation b;

    public TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(TestCoroutineContext.Dispatcher dispatcher, CancellableContinuation cancellableContinuation) {
        this.a = dispatcher;
        this.b = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.resumeUndispatched(this.a, Unit.INSTANCE);
    }
}
