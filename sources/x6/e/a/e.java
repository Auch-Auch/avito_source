package x6.e.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
public class e extends h {
    public int c;
    public int d;
    public boolean e = false;
    public boolean f = true;

    public e(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        this.c = inputStream.read();
        int read = inputStream.read();
        this.d = read;
        if (read >= 0) {
            c();
            return;
        }
        throw new EOFException();
    }

    public final boolean c() {
        if (!this.e && this.f && this.c == 0 && this.d == 0) {
            this.e = true;
            b(true);
        }
        return this.e;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this.e) {
            return -1;
        }
        int read = this.a.read(bArr, i + 2, i2 - 2);
        if (read >= 0) {
            bArr[i] = (byte) this.c;
            bArr[i + 1] = (byte) this.d;
            this.c = this.a.read();
            int read2 = this.a.read();
            this.d = read2;
            if (read2 >= 0) {
                return read + 2;
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (c()) {
            return -1;
        }
        int read = this.a.read();
        if (read >= 0) {
            int i = this.c;
            this.c = this.d;
            this.d = read;
            return i;
        }
        throw new EOFException();
    }
}
