package t6.n;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class f extends CollectionsKt__IteratorsJVMKt {
    public static final <T> void forEach(@NotNull Iterator<? extends T> it, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(it, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "operation");
        while (it.hasNext()) {
            function1.invoke((Object) it.next());
        }
    }

    @NotNull
    public static final <T> Iterator<IndexedValue<T>> withIndex(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "$this$withIndex");
        return new IndexingIterator(it);
    }
}
