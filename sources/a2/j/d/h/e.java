package a2.j.d.h;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
@GwtIncompatible
public final class e extends Reader {
    public CharSequence a;
    public int b;
    public int c;

    public e(CharSequence charSequence) {
        this.a = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public final void a() throws IOException {
        if (this.a == null) {
            throw new IOException("reader closed");
        }
    }

    public final boolean b() {
        return c() > 0;
    }

    public final int c() {
        return this.a.length() - this.b;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.a = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i) throws IOException {
        Preconditions.checkArgument(i >= 0, "readAheadLimit (%s) may not be negative", i);
        a();
        this.c = this.b;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.checkNotNull(charBuffer);
        a();
        if (!b()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), c());
        for (int i = 0; i < min; i++) {
            CharSequence charSequence = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            charBuffer.put(charSequence.charAt(i2));
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        a();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        a();
        this.b = this.c;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j) throws IOException {
        int min;
        Preconditions.checkArgument(j >= 0, "n (%s) may not be negative", j);
        a();
        min = (int) Math.min((long) c(), j);
        this.b += min;
        return (long) min;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        char c2;
        a();
        if (b()) {
            CharSequence charSequence = this.a;
            int i = this.b;
            this.b = i + 1;
            c2 = charSequence.charAt(i);
        } else {
            c2 = 65535;
        }
        return c2;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i, int i2) throws IOException {
        Preconditions.checkPositionIndexes(i, i + i2, cArr.length);
        a();
        if (!b()) {
            return -1;
        }
        int min = Math.min(i2, c());
        for (int i3 = 0; i3 < min; i3++) {
            CharSequence charSequence = this.a;
            int i4 = this.b;
            this.b = i4 + 1;
            cArr[i + i3] = charSequence.charAt(i4);
        }
        return min;
    }
}
