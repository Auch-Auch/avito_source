package t6.o;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class f<T> implements Comparator<T> {
    @NotNull
    public final Comparator<T> a;

    public f(@NotNull Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.a = comparator;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.a.compare(t2, t);
    }

    @Override // java.util.Comparator
    @NotNull
    public final Comparator<T> reversed() {
        return this.a;
    }
}
