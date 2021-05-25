package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.Writer;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
public class LogWriter extends Writer {
    public final String a;
    public StringBuilder b = new StringBuilder(128);

    public LogWriter(String str) {
        this.a = str;
    }

    public final void a() {
        if (this.b.length() > 0) {
            this.b.toString();
            StringBuilder sb = this.b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.b.append(c);
            }
        }
    }
}
