package t6.n;

import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class w<T> extends AbstractList<T> {
    public final List<T> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "delegate");
        this.a = list;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        return this.a.get(i.access$reverseElementIndex(this, i));
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.size();
    }
}
