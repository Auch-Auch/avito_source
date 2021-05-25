package x6.e.a;

import a2.b.a.a.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;
public class d extends h {
    public static final byte[] e = new byte[0];
    public final int c;
    public int d;

    public d(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this.c = i;
            this.d = i;
            if (i == 0) {
                b(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    @Override // x6.e.a.h
    public int a() {
        return this.d;
    }

    public byte[] c() throws IOException {
        int i = this.d;
        if (i == 0) {
            return e;
        }
        byte[] bArr = new byte[i];
        int readFully = i - Streams.readFully(this.a, bArr);
        this.d = readFully;
        if (readFully == 0) {
            b(true);
            return bArr;
        }
        StringBuilder L = a.L("DEF length ");
        L.append(this.c);
        L.append(" object truncated by ");
        L.append(this.d);
        throw new EOFException(L.toString());
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.d == 0) {
            return -1;
        }
        int read = this.a.read();
        if (read >= 0) {
            int i = this.d - 1;
            this.d = i;
            if (i == 0) {
                b(true);
            }
            return read;
        }
        StringBuilder L = a.L("DEF length ");
        L.append(this.c);
        L.append(" object truncated by ");
        L.append(this.d);
        throw new EOFException(L.toString());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int read = this.a.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this.d - read;
            this.d = i4;
            if (i4 == 0) {
                b(true);
            }
            return read;
        }
        StringBuilder L = a.L("DEF length ");
        L.append(this.c);
        L.append(" object truncated by ");
        L.append(this.d);
        throw new EOFException(L.toString());
    }
}
