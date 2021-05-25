package t6.r.a;

import java.util.NoSuchElementException;
import kotlin.collections.BooleanIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends BooleanIterator {
    public int a;
    public final boolean[] b;

    public a(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "array");
        this.b = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // kotlin.collections.BooleanIterator
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.b;
            int i = this.a;
            this.a = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
