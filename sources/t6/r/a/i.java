package t6.r.a;

import java.util.NoSuchElementException;
import kotlin.collections.ShortIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class i extends ShortIterator {
    public int a;
    public final short[] b;

    public i(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        this.b = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // kotlin.collections.ShortIterator
    public short nextShort() {
        try {
            short[] sArr = this.b;
            int i = this.a;
            this.a = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
