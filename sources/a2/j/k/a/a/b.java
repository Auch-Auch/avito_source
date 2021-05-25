package a2.j.k.a.a;

import com.google.zxing.common.BitArray;
import kotlin.text.Typography;
public final class b extends d {
    public final short c;
    public final short d;

    public b(d dVar, int i, int i2) {
        super(dVar);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // a2.j.k.a.a.d
    public void a(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.c, this.d);
    }

    public String toString() {
        short s = this.c;
        short s2 = this.d;
        int i = (s & ((1 << s2) - 1)) | (1 << s2);
        return "<" + Integer.toBinaryString(i | (1 << this.d)).substring(1) + Typography.greater;
    }
}
