package a2.j.b.e.a.b;

import java.io.IOException;
import java.io.InputStream;
public final class b0 extends InputStream {
    public final InputStream a;
    public long b;

    public b0(InputStream inputStream, long j) {
        this.a = inputStream;
        this.b = j;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        long j = this.b;
        if (j <= 0) {
            return -1;
        }
        this.b = j - 1;
        return this.a.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.b;
        if (j <= 0) {
            return -1;
        }
        int read = this.a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.b -= (long) read;
        }
        return read;
    }
}
