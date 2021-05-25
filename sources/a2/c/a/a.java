package a2.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
public class a {
    public static a e;
    public final Object a = new Object();
    public final Handler b = new Handler(Looper.getMainLooper(), new C0012a());
    public c c;
    public c d;

    /* renamed from: a2.c.a.a$a  reason: collision with other inner class name */
    public class C0012a implements Handler.Callback {
        public C0012a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a aVar = a.this;
            c cVar = (c) message.obj;
            synchronized (aVar.a) {
                if (aVar.c == cVar || aVar.d == cVar) {
                    aVar.a(cVar, 2);
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
        public final WeakReference<b> a;
        public int b;

        public c(int i, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.b = i;
        }
    }

    public static a c() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    public final boolean a(c cVar, int i) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        bVar.a(i);
        return true;
    }

    public void b(b bVar) {
        synchronized (this.a) {
            if (d(bVar)) {
                this.b.removeCallbacksAndMessages(this.c);
            }
        }
    }

    public final boolean d(b bVar) {
        c cVar = this.c;
        if (cVar == null) {
            return false;
        }
        if (bVar != null && cVar.a.get() == bVar) {
            return true;
        }
        return false;
    }

    public final boolean e(b bVar) {
        c cVar = this.d;
        if (cVar == null) {
            return false;
        }
        if (bVar != null && cVar.a.get() == bVar) {
            return true;
        }
        return false;
    }

    public void f(b bVar) {
        synchronized (this.a) {
            if (d(bVar)) {
                h(this.c);
            }
        }
    }

    public void g(b bVar) {
        synchronized (this.a) {
            if (d(bVar)) {
                h(this.c);
            }
        }
    }

    public final void h(c cVar) {
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

    public final void i() {
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
