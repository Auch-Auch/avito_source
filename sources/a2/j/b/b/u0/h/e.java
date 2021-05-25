package a2.j.b.b.u0.h;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
public final class e {
    public static final long[] d = {128, 64, 32, 16, 8, 4, 2, 1};
    public final byte[] a = new byte[8];
    public int b;
    public int c;

    public static long a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~d[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public static int b(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = d;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public long c(ExtractorInput extractorInput, boolean z, boolean z2, int i) throws IOException {
        if (this.b == 0) {
            if (!extractorInput.readFully(this.a, 0, 1, z)) {
                return -1;
            }
            int b2 = b(this.a[0] & 255);
            this.c = b2;
            if (b2 != -1) {
                this.b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.c;
        if (i2 > i) {
            this.b = 0;
            return -2;
        }
        if (i2 != 1) {
            extractorInput.readFully(this.a, 1, i2 - 1);
        }
        this.b = 0;
        return a(this.a, this.c, z2);
    }
}
