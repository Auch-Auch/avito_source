package a2.j.d.l.a;

import a2.j.d.l.a.g;
import com.google.common.util.concurrent.ListenableFuture;
public class f implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ListenableFuture b;
    public final /* synthetic */ g.a c;

    public f(g.a aVar, int i, ListenableFuture listenableFuture) {
        this.c = aVar;
        this.a = i;
        this.b = listenableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.k(this.a, this.b);
        } finally {
            this.c.h();
        }
    }
}
