package t6.r.a;

import java.util.NoSuchElementException;
import kotlin.collections.FloatIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class e extends FloatIterator {
    public int a;
    public final float[] b;

    public e(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        this.b = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // kotlin.collections.FloatIterator
    public float nextFloat() {
        try {
            float[] fArr = this.b;
            int i = this.a;
            this.a = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
