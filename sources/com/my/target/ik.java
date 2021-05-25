package com.my.target;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
public class ik {
    @NonNull
    public static final Handler d = new Handler(Looper.getMainLooper());
    @NonNull
    public static final ik pQ = new ik(1000);
    public final int a;
    @NonNull
    public final WeakHashMap<Runnable, Boolean> b = new WeakHashMap<>();
    @NonNull
    public final Runnable c = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ik ikVar = ik.this;
            ik ikVar2 = ik.pQ;
            synchronized (ikVar) {
                Iterator it = new HashSet(ikVar.b.keySet()).iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                if (ikVar.b.keySet().size() > 0) {
                    ik.d.postDelayed(ikVar.c, (long) ikVar.a);
                }
            }
        }
    }

    public ik(int i) {
        this.a = i;
    }

    @NonNull
    public static final ik J(int i) {
        return new ik(i);
    }

    @AnyThread
    public void d(@NonNull Runnable runnable) {
        synchronized (this) {
            int size = this.b.size();
            if (this.b.put(runnable, Boolean.TRUE) == null && size == 0) {
                d.postDelayed(this.c, (long) this.a);
            }
        }
    }

    @AnyThread
    public void e(@NonNull Runnable runnable) {
        synchronized (this) {
            this.b.remove(runnable);
            if (this.b.size() == 0) {
                d.removeCallbacks(this.c);
            }
        }
    }
}
