package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public final class SetBuilder<T> {
    public final List<T> a;

    public SetBuilder(int i) {
        this.a = new ArrayList(i);
    }

    public static <T> SetBuilder<T> newSetBuilder(int i) {
        return new SetBuilder<>(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SetBuilder<T> add(T t) {
        this.a.add(Preconditions.checkNotNull(t, "Set contributions cannot be null"));
        return this;
    }

    public SetBuilder<T> addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            Preconditions.checkNotNull(it.next(), "Set contributions cannot be null");
        }
        this.a.addAll(collection);
        return this;
    }

    public Set<T> build() {
        if (this.a.isEmpty()) {
            return Collections.emptySet();
        }
        if (this.a.size() == 1) {
            return Collections.singleton(this.a.get(0));
        }
        return Collections.unmodifiableSet(new HashSet(this.a));
    }
}
