package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.google.android.exoplayer2.offline.DownloadService;
import com.yandex.metrica.impl.ob.aq;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
public class k implements aq.a {
    private final Set<Integer> a;
    private final Set<Integer> b;
    @NonNull
    private volatile a c;
    private boolean d;
    @NonNull
    private final aq e;
    private final Set<b> f;

    public enum a {
        UNKNOWN("unknown"),
        BACKGROUND("background"),
        FOREGROUND(DownloadService.KEY_FOREGROUND),
        VISIBLE("visible");
        
        private final String e;

        private a(String str) {
            this.e = str;
        }
    }

    public interface b {
        void a(@NonNull a aVar);
    }

    public k(@NonNull Context context, @NonNull act act) {
        this(new aq(context, act));
    }

    private void d() {
        a e2 = e();
        if (this.c != e2) {
            this.c = e2;
            f();
        }
    }

    @NonNull
    private a e() {
        a aVar = a.UNKNOWN;
        if (!this.a.isEmpty()) {
            return a.VISIBLE;
        }
        if (this.d) {
            return a.FOREGROUND;
        }
        return !this.b.isEmpty() ? a.BACKGROUND : aVar;
    }

    private void f() {
        for (b bVar : this.f) {
            bVar.a(this.c);
        }
    }

    public void a() {
        this.e.a();
        this.d = this.e.a(this);
        d();
    }

    public void b() {
        this.e.b(this);
        this.e.b();
        this.f.clear();
        if (this.c == a.FOREGROUND || this.c == a.VISIBLE) {
            this.c = a.BACKGROUND;
        }
    }

    @NonNull
    public a c() {
        return this.c;
    }

    @VisibleForTesting
    public k(@NonNull aq aqVar) {
        this.a = new HashSet();
        this.b = new HashSet();
        this.c = a.UNKNOWN;
        this.d = false;
        this.f = new CopyOnWriteArraySet();
        this.e = aqVar;
    }

    public void c(int i) {
        this.a.remove(Integer.valueOf(i));
        d();
    }

    @NonNull
    public a a(@Nullable b bVar) {
        if (bVar != null) {
            this.f.add(bVar);
        }
        return this.c;
    }

    public void a(int i) {
        this.a.add(Integer.valueOf(i));
        this.b.remove(Integer.valueOf(i));
        d();
    }

    public void b(@NonNull b bVar) {
        this.f.remove(bVar);
    }

    public void b(int i) {
        this.b.add(Integer.valueOf(i));
        this.a.remove(Integer.valueOf(i));
        d();
    }

    @Override // com.yandex.metrica.impl.ob.aq.a
    public void a(boolean z) {
        if (z != this.d) {
            this.d = z;
            d();
        }
    }
}
