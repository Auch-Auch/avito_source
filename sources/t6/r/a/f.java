package t6.r.a;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class f extends IntIterator {
    public int a;
    public final int[] b;

    public f(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        this.b = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        try {
            int[] iArr = this.b;
            int i = this.a;
            this.a = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
