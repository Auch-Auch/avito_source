package u6.a;

import a2.b.a.a.a;
import java.util.concurrent.Future;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
public final class k implements DisposableHandle {
    public final Future<?> a;

    public k(@NotNull Future<?> future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.a.cancel(false);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DisposableFutureHandle[");
        L.append(this.a);
        L.append(']');
        return L.toString();
    }
}
