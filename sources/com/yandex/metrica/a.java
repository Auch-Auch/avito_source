package com.yandex.metrica;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.act;
import com.yandex.metrica.impl.ob.acu;
import com.yandex.metrica.impl.ob.dr;
import java.util.HashSet;
import java.util.Set;
public class a {
    @NonNull
    public final act a;
    public final Set<b> b = new HashSet();

    /* renamed from: com.yandex.metrica.a$a  reason: collision with other inner class name */
    public interface AbstractC0331a {
        void a();

        void b();
    }

    public class b {
        @NonNull
        public final act a;
        @NonNull
        public final AbstractC0331a b;
        public final long c;
        public boolean d = true;
        public final Runnable e = new RunnableC0332a();

        /* renamed from: com.yandex.metrica.a$b$a  reason: collision with other inner class name */
        public class RunnableC0332a implements Runnable {
            public RunnableC0332a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b.b();
            }
        }

        public b(a aVar, @NonNull AbstractC0331a aVar2, @NonNull act act, long j) {
            this.b = aVar2;
            this.a = act;
            this.c = j;
        }
    }

    public a(long j) {
        acu b2 = dr.k().b();
        this.a = b2;
    }

    public synchronized void a() {
        for (b bVar : this.b) {
            if (bVar.d) {
                bVar.d = false;
                bVar.a.b(bVar.e);
                bVar.b.a();
            }
        }
    }

    public synchronized void b() {
        for (b bVar : this.b) {
            if (!bVar.d) {
                bVar.d = true;
                bVar.a.a(bVar.e, bVar.c);
            }
        }
    }

    public synchronized void a(@NonNull AbstractC0331a aVar, long j) {
        this.b.add(new b(this, aVar, this.a, j));
    }
}
