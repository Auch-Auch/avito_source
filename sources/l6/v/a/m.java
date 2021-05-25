package l6.v.a;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;
import androidx.recyclerview.widget.TileList;
import l6.v.a.o;
public class m implements ThreadUtil$MainThreadCallback<T> {
    public final o.a a = new o.a();
    public final Handler b = new Handler(Looper.getMainLooper());
    public Runnable c = new a();
    public final /* synthetic */ ThreadUtil$MainThreadCallback d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.b a3 = m.this.a.a();
            while (a3 != null) {
                int i = a3.b;
                if (i == 1) {
                    m.this.d.updateItemCount(a3.c, a3.d);
                } else if (i == 2) {
                    m.this.d.addTile(a3.c, (TileList.Tile) a3.h);
                } else if (i == 3) {
                    m.this.d.removeTile(a3.c, a3.d);
                }
                a3 = m.this.a.a();
            }
        }
    }

    public m(o oVar, ThreadUtil$MainThreadCallback threadUtil$MainThreadCallback) {
        this.d = threadUtil$MainThreadCallback;
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void addTile(int i, TileList.Tile<T> tile) {
        this.a.c(o.b.c(2, i, tile));
        this.b.post(this.c);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void removeTile(int i, int i2) {
        this.a.c(o.b.a(3, i, i2));
        this.b.post(this.c);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void updateItemCount(int i, int i2) {
        this.a.c(o.b.a(1, i, i2));
        this.b.post(this.c);
    }
}
