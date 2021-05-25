package u6.a.m0;

import java.util.Objects;
import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a extends CancelHandler {
    public final d a;
    public final int b;

    public a(@NotNull d dVar, int i) {
        this.a = dVar;
        this.b = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        d dVar = this.a;
        int i = this.b;
        Objects.requireNonNull(dVar);
        dVar.e.set(i, SemaphoreKt.e);
        dVar.onSlotCleaned();
        return Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CancelSemaphoreAcquisitionHandler[");
        L.append(this.a);
        L.append(", ");
        return a2.b.a.a.a.i(L, this.b, ']');
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(@Nullable Throwable th) {
        d dVar = this.a;
        int i = this.b;
        Objects.requireNonNull(dVar);
        dVar.e.set(i, SemaphoreKt.e);
        dVar.onSlotCleaned();
    }
}
