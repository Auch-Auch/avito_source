package u6.a;

import a2.b.a.a.a;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
public final class e0<U, T extends U> extends ScopeCoroutine<T> implements Runnable {
    @JvmField
    public final long c;

    public e0(long j, @NotNull Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.c = j;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.nameString$kotlinx_coroutines_core());
        sb.append("(timeMillis=");
        return a.k(sb, this.c, ')');
    }

    @Override // java.lang.Runnable
    public void run() {
        cancelCoroutine(TimeoutKt.TimeoutCancellationException(this.c, this));
    }
}
