package t6.r.a;

import java.util.NoSuchElementException;
import kotlin.collections.DoubleIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class d extends DoubleIterator {
    public int a;
    public final double[] b;

    public d(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "array");
        this.b = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // kotlin.collections.DoubleIterator
    public double nextDouble() {
        try {
            double[] dArr = this.b;
            int i = this.a;
            this.a = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
