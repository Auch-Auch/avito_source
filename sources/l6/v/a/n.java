package l6.v.a;

import android.os.AsyncTask;
import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import l6.v.a.o;
public class n implements ThreadUtil$BackgroundCallback<T> {
    public final o.a a = new o.a();
    public final Executor b = AsyncTask.THREAD_POOL_EXECUTOR;
    public AtomicBoolean c = new AtomicBoolean(false);
    public Runnable d = new a();
    public final /* synthetic */ ThreadUtil$BackgroundCallback e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                o.b a3 = n.this.a.a();
                if (a3 == null) {
                    n.this.c.set(false);
                    return;
                }
                int i = a3.b;
                if (i == 1) {
                    n.this.a.b(1);
                    n.this.e.refresh(a3.c);
                } else if (i == 2) {
                    n.this.a.b(2);
                    n.this.a.b(3);
                    n.this.e.updateRange(a3.c, a3.d, a3.e, a3.f, a3.g);
                } else if (i == 3) {
                    n.this.e.loadTile(a3.c, a3.d);
                } else if (i == 4) {
                    n.this.e.recycleTile((TileList.Tile) a3.h);
                }
            }
        }
    }

    public n(o oVar, ThreadUtil$BackgroundCallback threadUtil$BackgroundCallback) {
        this.e = threadUtil$BackgroundCallback;
    }

    public final void a(o.b bVar) {
        this.a.c(bVar);
        if (this.c.compareAndSet(false, true)) {
            this.b.execute(this.d);
        }
    }

    public final void b(o.b bVar) {
        o.a aVar = this.a;
        synchronized (aVar) {
            bVar.a = aVar.a;
            aVar.a = bVar;
        }
        if (this.c.compareAndSet(false, true)) {
            this.b.execute(this.d);
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void loadTile(int i, int i2) {
        a(o.b.a(3, i, i2));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void recycleTile(TileList.Tile<T> tile) {
        a(o.b.c(4, 0, tile));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void refresh(int i) {
        b(o.b.c(1, i, null));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void updateRange(int i, int i2, int i3, int i4, int i5) {
        b(o.b.b(2, i, i2, i3, i4, i5, null));
    }
}
