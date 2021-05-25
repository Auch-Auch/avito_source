package u6.a.k0;

import a2.b.a.a.a;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
public final class b {
    @JvmField
    @NotNull
    public final LockFreeLinkedListNode a;

    public b(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.a = lockFreeLinkedListNode;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Removed[");
        L.append(this.a);
        L.append(']');
        return L.toString();
    }
}
