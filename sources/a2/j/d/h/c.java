package a2.j.d.h;

import java.io.IOException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class c implements Appendable {
    public int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Appendable c;
    public final /* synthetic */ String d;

    public c(int i, Appendable appendable, String str) {
        this.b = i;
        this.c = appendable;
        this.d = str;
        this.a = i;
    }

    @Override // java.lang.Appendable
    public Appendable append(char c2) throws IOException {
        if (this.a == 0) {
            this.c.append(this.d);
            this.a = this.b;
        }
        this.c.append(c2);
        this.a--;
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(@NullableDecl CharSequence charSequence, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Appendable
    public Appendable append(@NullableDecl CharSequence charSequence) throws IOException {
        throw new UnsupportedOperationException();
    }
}
