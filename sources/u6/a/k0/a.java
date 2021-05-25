package u6.a.k0;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatchersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a extends MainCoroutineDispatcher implements Delay {
    public final Throwable a = null;
    public final String b = null;

    public a(Throwable th, String str, int i) {
        int i2 = i & 2;
    }

    public final Void a() {
        String str;
        if (this.a != null) {
            StringBuilder L = a2.b.a.a.a.L("Module with the Main dispatcher had failed to initialize");
            String str2 = this.b;
            if (str2 == null || (str = a2.b.a.a.a.c3(". ", str2)) == null) {
                str = "";
            }
            L.append(str);
            throw new IllegalStateException(L.toString(), this.a);
        }
        MainDispatchersKt.throwMissingMainDispatcherException();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    @Nullable
    public Object delay(long j, @NotNull Continuation<?> continuation) {
        a();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        a();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        a();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        a();
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j, CancellableContinuation cancellableContinuation) {
        a();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, java.lang.Object
    @NotNull
    public String toString() {
        String str;
        StringBuilder L = a2.b.a.a.a.L("Dispatchers.Main[missing");
        if (this.a != null) {
            StringBuilder L2 = a2.b.a.a.a.L(", cause=");
            L2.append(this.a);
            str = L2.toString();
        } else {
            str = "";
        }
        return a2.b.a.a.a.s(L, str, ']');
    }
}
