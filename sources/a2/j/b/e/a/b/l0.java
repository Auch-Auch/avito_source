package a2.j.b.e.a.b;

import com.google.android.play.core.assetpacks.dd;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class l0 extends FilterInputStream {
    public byte[] a = new byte[4096];
    public long b;
    public boolean c = false;
    public boolean d = false;

    public l0(InputStream inputStream) {
        super(inputStream);
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    public final f2 b() throws IOException {
        byte[] bArr;
        if (this.b > 0) {
            do {
                bArr = this.a;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.c || this.d) {
            return new i0(null, -1, -1, false, null);
        }
        int a3 = a(this.a, 0, 30);
        if (a3 != 30 && !e(a3, 30 - a3)) {
            this.c = true;
            return c(a3, null, -1, -1, true);
        } else if (dd.g(this.a, 0) != 67324752) {
            this.d = true;
            return c(a3, null, -1, -1, false);
        } else {
            long g = dd.g(this.a, 18);
            if (g != BodyPartID.bodyIdMax) {
                int h = dd.h(this.a, 8);
                int h2 = dd.h(this.a, 26);
                int i = h2 + 30;
                d((long) i);
                int a4 = a(this.a, 30, h2);
                int i2 = a4 + 30;
                if (a4 == h2 || e(i2, h2 - a4)) {
                    String str = new String(this.a, 30, h2);
                    int h3 = dd.h(this.a, 28);
                    int i3 = i + h3;
                    d((long) i3);
                    int a5 = a(this.a, i, h3);
                    int i4 = i + a5;
                    if (a5 == h3 || e(i4, h3 - a5)) {
                        this.b = dd.g(this.a, 18);
                        return c(i3, str, g, h, false);
                    }
                    this.c = true;
                    return c(i4, str, g, h, true);
                }
                this.c = true;
                return c(i2, null, g, h, true);
            }
            throw new q0("Files bigger than 4GiB are not supported.");
        }
    }

    public final f2 c(int i, String str, long j, int i2, boolean z) {
        return new i0(str, j, i2, z, Arrays.copyOf(this.a, i));
    }

    public final void d(long j) {
        int length = this.a.length;
        if (j > ((long) length)) {
            do {
                length += length;
            } while (((long) length) < j);
            this.a = Arrays.copyOf(this.a, length);
        }
    }

    public final boolean e(int i, int i2) throws IOException {
        return a(this.a, i, i2) == i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.b;
        if (j <= 0 || this.c) {
            return -1;
        }
        int max = Math.max(0, super.read(bArr, i, (int) Math.min(j, (long) i2)));
        this.b -= (long) max;
        if (max != 0) {
            return max;
        }
        this.c = true;
        return 0;
    }
}
