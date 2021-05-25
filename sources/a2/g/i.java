package a2.g;

import android.os.Handler;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
public class i {
    public final GraphRequest a;
    public final Handler b;
    public final long c = FacebookSdk.getOnProgressThreshold();
    public long d;
    public long e;
    public long f;

    public class a implements Runnable {
        public final /* synthetic */ GraphRequest.OnProgressCallback a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public a(i iVar, GraphRequest.OnProgressCallback onProgressCallback, long j, long j2) {
            this.a = onProgressCallback;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onProgress(this.b, this.c);
        }
    }

    public i(Handler handler, GraphRequest graphRequest) {
        this.a = graphRequest;
        this.b = handler;
    }

    public void a() {
        if (this.d > this.e) {
            GraphRequest.Callback callback = this.a.getCallback();
            long j = this.f;
            if (j > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                long j2 = this.d;
                GraphRequest.OnProgressCallback onProgressCallback = (GraphRequest.OnProgressCallback) callback;
                Handler handler = this.b;
                if (handler == null) {
                    onProgressCallback.onProgress(j2, j);
                } else {
                    handler.post(new a(this, onProgressCallback, j2, j));
                }
                this.e = this.d;
            }
        }
    }
}
