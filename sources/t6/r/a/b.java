package t6.r.a;

import java.util.NoSuchElementException;
import kotlin.collections.ByteIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends ByteIterator {
    public int a;
    public final byte[] b;

    public b(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        this.b = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() {
        try {
            byte[] bArr = this.b;
            int i = this.a;
            this.a = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
