package a2.j.d.h;

import java.io.IOException;
import java.io.Reader;
public final class b extends Reader {
    public final /* synthetic */ Reader a;
    public final /* synthetic */ String b;

    public b(Reader reader, String str) {
        this.a = reader;
        this.b = str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        int read;
        do {
            read = this.a.read();
            if (read == -1) {
                break;
            }
        } while (this.b.indexOf((char) read) >= 0);
        return read;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }
}
