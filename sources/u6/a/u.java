package u6.a;

import a2.b.a.a.a;
import kotlin.Unit;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class u extends BeforeResumeCancelHandler {
    public final LockFreeLinkedListNode a;

    public u(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.a = lockFreeLinkedListNode;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.a.remove();
        return Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RemoveOnCancel[");
        L.append(this.a);
        L.append(']');
        return L.toString();
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(@Nullable Throwable th) {
        this.a.remove();
    }
}
