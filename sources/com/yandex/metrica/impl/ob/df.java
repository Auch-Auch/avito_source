package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
public class df {
    private final a a;
    @Nullable
    private Boolean b;
    private final HashSet<String> c = new HashSet<>();
    private final HashSet<String> d = new HashSet<>();

    public interface a {
        @Nullable
        Boolean a();

        void a(boolean z);
    }

    public static class b implements a {
        private final mq a;

        public b(@NonNull mq mqVar) {
            this.a = mqVar;
        }

        @Override // com.yandex.metrica.impl.ob.df.a
        public void a(boolean z) {
            this.a.e(z).q();
        }

        @Override // com.yandex.metrica.impl.ob.df.a
        @Nullable
        public Boolean a() {
            return this.a.h();
        }
    }

    public df(@NonNull a aVar) {
        this.a = aVar;
        this.b = aVar.a();
    }

    private boolean e() {
        Boolean bool = this.b;
        if (bool == null) {
            return !this.c.isEmpty() || this.d.isEmpty();
        }
        return bool.booleanValue();
    }

    public synchronized void a(@Nullable Boolean bool) {
        if (dl.a(bool) || this.b == null) {
            Boolean valueOf = Boolean.valueOf(aau.c(bool));
            this.b = valueOf;
            this.a.a(valueOf.booleanValue());
        }
    }

    public synchronized boolean b() {
        Boolean bool;
        bool = this.b;
        return bool == null ? this.d.isEmpty() : bool.booleanValue();
    }

    public synchronized boolean c() {
        return e();
    }

    public synchronized boolean d() {
        return e();
    }

    public synchronized void a(@NonNull String str, @Nullable Boolean bool) {
        if (dl.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
            if (((Boolean) abw.b(bool, Boolean.TRUE)).booleanValue()) {
                this.d.add(str);
                this.c.remove(str);
            } else {
                this.c.add(str);
                this.d.remove(str);
            }
        }
    }

    public synchronized boolean a() {
        boolean z;
        Boolean bool = this.b;
        if (bool == null) {
            z = this.d.isEmpty() && this.c.isEmpty();
        } else {
            z = bool.booleanValue();
        }
        return z;
    }
}
