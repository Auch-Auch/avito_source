package a2.j.b.d.q;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
public class m {
    public static m e;
    @NonNull
    public final Object a = new Object();
    @NonNull
    public final Handler b = new Handler(Looper.getMainLooper(), new a());
    @Nullable
    public c c;
    @Nullable
    public c d;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            m mVar = m.this;
            c cVar = (c) message.obj;
            synchronized (mVar.a) {
                if (mVar.c == cVar || mVar.d == cVar) {
                    mVar.a(cVar, 2);
                }
            }
            return true;
        }
    }

    public interface b {
        void a(int i);

        void show();
    }

    public static class c {
        @NonNull
        public final WeakReference<b> a;
        public int b;
        public boolean c;

        public c(int i, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.b = i;
        }
    }

    public static m b() {
        if (e == null) {
            e = new m();
        }
        return e;
    }

    public final boolean a(@NonNull c cVar, int i) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.b.removeCallbacksAndMessages(cVar);
        bVar.a(i);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.c;
        if (cVar == null) {
            return false;
        }
        if (bVar != null && cVar.a.get() == bVar) {
            return true;
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.d;
        if (cVar == null) {
            return false;
        }
        if (bVar != null && cVar.a.get() == bVar) {
            return true;
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.a) {
            if (c(bVar)) {
                c cVar = this.c;
                if (!cVar.c) {
                    cVar.c = true;
                    this.b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.a) {
            if (c(bVar)) {
                c cVar = this.c;
                if (cVar.c) {
                    cVar.c = false;
                    g(cVar);
                }
            }
        }
    }

    public final void g(@NonNull c cVar) {
        int i = cVar.b;
        if (i != -2) {
            if (i <= 0) {
                i = i == -1 ? 1500 : 2750;
            }
            this.b.removeCallbacksAndMessages(cVar);
            Handler handler = this.b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i);
        }
    }

    public final void h() {
        c cVar = this.d;
        if (cVar != null) {
            this.c = cVar;
            this.d = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.c = null;
            }
        }
    }
}
