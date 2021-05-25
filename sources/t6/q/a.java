package t6.q;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends ByteArrayOutputStream {
    public a(int i) {
        super(i);
    }

    @NotNull
    public final byte[] a() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        Intrinsics.checkNotNullExpressionValue(bArr, "buf");
        return bArr;
    }
}
