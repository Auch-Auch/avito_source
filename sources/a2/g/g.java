package a2.g;

import android.os.Handler;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
public class g extends FilterOutputStream implements h {
    public final Map<GraphRequest, i> a;
    public final GraphRequestBatch b;
    public final long c = FacebookSdk.getOnProgressThreshold();
    public long d;
    public long e;
    public long f;
    public i g;

    public class a implements Runnable {
        public final /* synthetic */ GraphRequestBatch.OnProgressCallback a;

        public a(GraphRequestBatch.OnProgressCallback onProgressCallback) {
            this.a = onProgressCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            GraphRequestBatch.OnProgressCallback onProgressCallback = this.a;
            g gVar = g.this;
            onProgressCallback.onBatchProgress(gVar.b, gVar.d, gVar.f);
        }
    }

    public g(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, i> map, long j) {
        super(outputStream);
        this.b = graphRequestBatch;
        this.a = map;
        this.f = j;
    }

    @Override // a2.g.h
    public void a(GraphRequest graphRequest) {
        this.g = graphRequest != null ? this.a.get(graphRequest) : null;
    }

    public final void b(long j) {
        i iVar = this.g;
        if (iVar != null) {
            long j2 = iVar.d + j;
            iVar.d = j2;
            if (j2 >= iVar.e + iVar.c || j2 >= iVar.f) {
                iVar.a();
            }
        }
        long j3 = this.d + j;
        this.d = j3;
        if (j3 >= this.e + this.c || j3 >= this.f) {
            c();
        }
    }

    public final void c() {
        if (this.d > this.e) {
            for (GraphRequestBatch.Callback callback : this.b.e) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    GraphRequestBatch graphRequestBatch = this.b;
                    Handler handler = graphRequestBatch.a;
                    GraphRequestBatch.OnProgressCallback onProgressCallback = (GraphRequestBatch.OnProgressCallback) callback;
                    if (handler == null) {
                        onProgressCallback.onBatchProgress(graphRequestBatch, this.d, this.f);
                    } else {
                        handler.post(new a(onProgressCallback));
                    }
                }
            }
            this.e = this.d;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        for (i iVar : this.a.values()) {
            iVar.a();
        }
        c();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        ((FilterOutputStream) this).out.write(bArr);
        b((long) bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        b((long) i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        b(1);
    }
}
