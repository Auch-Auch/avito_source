package l6.m.a;

import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
public class a {
    public static final ThreadLocal<a> g = new ThreadLocal<>();
    public final SimpleArrayMap<b, Long> a = new SimpleArrayMap<>();
    public final ArrayList<b> b = new ArrayList<>();
    public final C0531a c = new C0531a();
    public c d;
    public long e = 0;
    public boolean f = false;

    /* renamed from: l6.m.a.a$a  reason: collision with other inner class name */
    public class C0531a {
        public C0531a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0045 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r11 = this;
                l6.m.a.a r0 = l6.m.a.a.this
                long r1 = android.os.SystemClock.uptimeMillis()
                r0.e = r1
                l6.m.a.a r0 = l6.m.a.a.this
                long r1 = r0.e
                long r3 = android.os.SystemClock.uptimeMillis()
                r5 = 0
                r6 = 0
            L_0x0012:
                java.util.ArrayList<l6.m.a.a$b> r7 = r0.b
                int r7 = r7.size()
                if (r6 >= r7) goto L_0x0048
                java.util.ArrayList<l6.m.a.a$b> r7 = r0.b
                java.lang.Object r7 = r7.get(r6)
                l6.m.a.a$b r7 = (l6.m.a.a.b) r7
                if (r7 != 0) goto L_0x0025
                goto L_0x0045
            L_0x0025:
                androidx.collection.SimpleArrayMap<l6.m.a.a$b, java.lang.Long> r8 = r0.a
                java.lang.Object r8 = r8.get(r7)
                java.lang.Long r8 = (java.lang.Long) r8
                if (r8 != 0) goto L_0x0030
                goto L_0x003d
            L_0x0030:
                long r8 = r8.longValue()
                int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r10 >= 0) goto L_0x003f
                androidx.collection.SimpleArrayMap<l6.m.a.a$b, java.lang.Long> r8 = r0.a
                r8.remove(r7)
            L_0x003d:
                r8 = 1
                goto L_0x0040
            L_0x003f:
                r8 = 0
            L_0x0040:
                if (r8 == 0) goto L_0x0045
                r7.doAnimationFrame(r1)
            L_0x0045:
                int r6 = r6 + 1
                goto L_0x0012
            L_0x0048:
                boolean r1 = r0.f
                if (r1 == 0) goto L_0x0066
                java.util.ArrayList<l6.m.a.a$b> r1 = r0.b
                int r1 = r1.size()
            L_0x0052:
                int r1 = r1 + -1
                if (r1 < 0) goto L_0x0064
                java.util.ArrayList<l6.m.a.a$b> r2 = r0.b
                java.lang.Object r2 = r2.get(r1)
                if (r2 != 0) goto L_0x0052
                java.util.ArrayList<l6.m.a.a$b> r2 = r0.b
                r2.remove(r1)
                goto L_0x0052
            L_0x0064:
                r0.f = r5
            L_0x0066:
                l6.m.a.a r0 = l6.m.a.a.this
                java.util.ArrayList<l6.m.a.a$b> r0 = r0.b
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x008a
                l6.m.a.a r0 = l6.m.a.a.this
                l6.m.a.a$c r1 = r0.d
                if (r1 != 0) goto L_0x007f
                l6.m.a.a$d r1 = new l6.m.a.a$d
                l6.m.a.a$a r2 = r0.c
                r1.<init>(r2)
                r0.d = r1
            L_0x007f:
                l6.m.a.a$c r0 = r0.d
                l6.m.a.a$d r0 = (l6.m.a.a.d) r0
                android.view.Choreographer r1 = r0.b
                android.view.Choreographer$FrameCallback r0 = r0.c
                r1.postFrameCallback(r0)
            L_0x008a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.m.a.a.C0531a.a():void");
        }
    }

    public interface b {
        boolean doAnimationFrame(long j);
    }

    public static abstract class c {
        public final C0531a a;

        public c(C0531a aVar) {
            this.a = aVar;
        }
    }

    @RequiresApi(16)
    public static class d extends c {
        public final Choreographer b = Choreographer.getInstance();
        public final Choreographer.FrameCallback c = new Choreographer$FrameCallbackC0532a();

        /* renamed from: l6.m.a.a$d$a  reason: collision with other inner class name */
        public class Choreographer$FrameCallbackC0532a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC0532a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                d.this.a.a();
            }
        }

        public d(C0531a aVar) {
            super(aVar);
        }
    }

    public static a a() {
        ThreadLocal<a> threadLocal = g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }
}
