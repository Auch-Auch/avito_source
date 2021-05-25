package u6.a;

import a2.b.a.a.a;
import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class l extends CancelHandler {
    public final DisposableHandle a;

    public l(@NotNull DisposableHandle disposableHandle) {
        this.a = disposableHandle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.a.dispose();
        return Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DisposeOnCancel[");
        L.append(this.a);
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(@Nullable Throwable th) {
        this.a.dispose();
    }
}
