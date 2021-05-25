package a2.j.d.h;

import java.io.IOException;
import java.io.Writer;
public final class d extends Writer {
    public final /* synthetic */ Appendable a;
    public final /* synthetic */ Writer b;

    public d(Appendable appendable, Writer writer) {
        this.a = appendable;
        this.b = writer;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.a.append((char) i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }
}
