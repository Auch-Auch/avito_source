package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
public class CollectionsKt__IteratorsJVMKt extends e {
    @NotNull
    public static final <T> Iterator<T> iterator(@NotNull Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "$this$iterator");
        return new Object(enumeration) { // from class: kotlin.collections.CollectionsKt__IteratorsJVMKt$iterator$1
            public final /* synthetic */ Enumeration a;

            {
                this.a = r1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasMoreElements();
            }

            @Override // java.util.Iterator
            public T next() {
                return (T) this.a.nextElement();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}
