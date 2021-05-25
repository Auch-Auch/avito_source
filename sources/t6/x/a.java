package t6.x;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a<T, K> extends AbstractIterator<T> {
    public final HashSet<K> c = new HashSet<>();
    public final Iterator<T> d;
    public final Function1<T, K> e;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Iterator<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends K> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Iterator<? extends T> it, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(it, "source");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        this.d = it;
        this.e = function1;
    }

    @Override // kotlin.collections.AbstractIterator
    public void computeNext() {
        while (this.d.hasNext()) {
            T next = this.d.next();
            if (this.c.add(this.e.invoke(next))) {
                setNext(next);
                return;
            }
        }
        done();
    }
}
