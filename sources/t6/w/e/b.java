package t6.w.e;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
public final class b implements DFS.Neighbors {
    public final /* synthetic */ Function1 a;

    public b(Function1 function1) {
        this.a = function1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
    @NotNull
    public final /* synthetic */ Iterable getNeighbors(Object obj) {
        return (Iterable) this.a.invoke(obj);
    }
}
