package a2.j.d.h;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public class i extends Reader {
    public final Iterator<? extends CharSource> a;
    @NullableDecl
    public Reader b;

    public i(Iterator<? extends CharSource> it) throws IOException {
        this.a = it;
        a();
    }

    public final void a() throws IOException {
        close();
        if (this.a.hasNext()) {
            this.b = ((CharSource) this.a.next()).openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.b;
        if (reader != null) {
            Reader reader2 = null;
            try {
                reader.close();
            } finally {
                this.b = reader2;
            }
        }
    }

    @Override // java.io.Reader
    public int read(@NullableDecl char[] cArr, int i, int i2) throws IOException {
        Reader reader = this.b;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i, i2);
        if (read != -1) {
            return read;
        }
        a();
        return read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.b;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        Preconditions.checkArgument(i >= 0, "n is negative");
        if (i > 0) {
            while (true) {
                Reader reader = this.b;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j);
                if (skip > 0) {
                    return skip;
                }
                a();
            }
        }
        return 0;
    }
}
