package u6.a;

import a2.b.a.a.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class p extends CancelHandler {
    public final Function1<Throwable, Unit> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Function1<? super Throwable, Unit> function1) {
        this.a = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.a.invoke(th);
        return Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("InvokeOnCancel[");
        L.append(DebugStringsKt.getClassSimpleName(this.a));
        L.append('@');
        L.append(DebugStringsKt.getHexAddress(this));
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(@Nullable Throwable th) {
        this.a.invoke(th);
    }
}
