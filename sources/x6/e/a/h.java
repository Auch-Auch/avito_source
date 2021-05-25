package x6.e.a;

import java.io.InputStream;
public abstract class h extends InputStream {
    public final InputStream a;
    public int b;

    public h(InputStream inputStream, int i) {
        this.a = inputStream;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public void b(boolean z) {
        InputStream inputStream = this.a;
        if (inputStream instanceof e) {
            e eVar = (e) inputStream;
            eVar.f = z;
            eVar.c();
        }
    }
}
