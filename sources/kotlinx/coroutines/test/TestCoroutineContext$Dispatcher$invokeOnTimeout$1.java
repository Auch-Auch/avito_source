package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.test.TestCoroutineContext;
import u6.a.n0.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlinx/coroutines/test/TestCoroutineContext$Dispatcher$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "", "dispose", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class TestCoroutineContext$Dispatcher$invokeOnTimeout$1 implements DisposableHandle {
    public final /* synthetic */ TestCoroutineContext.Dispatcher a;
    public final /* synthetic */ a b;

    public TestCoroutineContext$Dispatcher$invokeOnTimeout$1(TestCoroutineContext.Dispatcher dispatcher, a aVar) {
        this.a = dispatcher;
        this.b = aVar;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        TestCoroutineContext.access$getQueue$p(TestCoroutineContext.this).remove(this.b);
    }
}
