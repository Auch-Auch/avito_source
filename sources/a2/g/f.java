package a2.g;

import android.os.Handler;
import com.facebook.GraphRequest;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
public class f extends OutputStream implements h {
    public final Map<GraphRequest, i> a = new HashMap();
    public final Handler b;
    public GraphRequest c;
    public i d;
    public int e;

    public f(Handler handler) {
        this.b = handler;
    }

    @Override // a2.g.h
    public void a(GraphRequest graphRequest) {
        this.c = graphRequest;
        this.d = graphRequest != null ? this.a.get(graphRequest) : null;
    }

    public void b(long j) {
        if (this.d == null) {
            i iVar = new i(this.b, this.c);
            this.d = iVar;
            this.a.put(this.c, iVar);
        }
        this.d.f += j;
        this.e = (int) (((long) this.e) + j);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        b((long) bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        b((long) i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        b(1);
    }
}
