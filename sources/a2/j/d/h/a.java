package a2.j.d.h;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public class a extends Writer {
    public final Appendable a;
    public boolean b;

    public a(Appendable appendable) {
        this.a = (Appendable) Preconditions.checkNotNull(appendable);
    }

    public final void a() throws IOException {
        if (this.b) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        a();
        this.a.append(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b = true;
        Appendable appendable = this.a;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        a();
        Appendable appendable = this.a;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        a();
        this.a.append(new String(cArr, i, i2));
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo64append(char c) throws IOException {
        a();
        this.a.append(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        a();
        this.a.append((char) i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@NullableDecl CharSequence charSequence) throws IOException {
        a();
        this.a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public void write(@NullableDecl String str) throws IOException {
        a();
        this.a.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo65append(@NullableDecl CharSequence charSequence) throws IOException {
        a();
        this.a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public void write(@NullableDecl String str, int i, int i2) throws IOException {
        a();
        this.a.append(str, i, i2 + i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@NullableDecl CharSequence charSequence, int i, int i2) throws IOException {
        a();
        this.a.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo66append(@NullableDecl CharSequence charSequence, int i, int i2) throws IOException {
        a();
        this.a.append(charSequence, i, i2);
        return this;
    }
}
