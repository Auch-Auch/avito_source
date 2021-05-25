package t6.n;

import java.util.List;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class v<T> extends AbstractMutableList<T> {
    public final List<T> a;

    public v(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "delegate");
        this.a = list;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.a.add(i.access$reversePositionIndex(this, i), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.a.get(i.access$reverseElementIndex(this, i));
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.a.size();
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int i) {
        return this.a.remove(i.access$reverseElementIndex(this, i));
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        return this.a.set(i.access$reverseElementIndex(this, i), t);
    }
}
