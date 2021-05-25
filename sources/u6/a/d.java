package u6.a;

import a2.b.a.a.a;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class d extends CancelHandler {
    public final Future<?> a;

    public d(@NotNull Future<?> future) {
        this.a = future;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.a.cancel(false);
        return Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CancelFutureOnCancel[");
        L.append(this.a);
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(@Nullable Throwable th) {
        this.a.cancel(false);
    }
}
