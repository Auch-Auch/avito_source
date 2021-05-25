package a2.j.d.b;

import a2.j.d.b.a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;
public class b implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int b;
    public final /* synthetic */ a.m c;
    public final /* synthetic */ ListenableFuture d;
    public final /* synthetic */ a.r e;

    public b(a.r rVar, Object obj, int i, a.m mVar, ListenableFuture listenableFuture) {
        this.e = rVar;
        this.a = obj;
        this.b = i;
        this.c = mVar;
        this.d = listenableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.e.j(this.a, this.b, this.c, this.d);
        } catch (Throwable th) {
            a.w.log(Level.WARNING, "Exception thrown during refresh", th);
            this.c.b.setException(th);
        }
    }
}
