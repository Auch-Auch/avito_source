package t6.r.a;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class h extends LongIterator {
    public int a;
    public final long[] b;

    public h(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        this.b = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        try {
            long[] jArr = this.b;
            int i = this.a;
            this.a = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
