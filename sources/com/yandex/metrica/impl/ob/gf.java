package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
public class gf {
    private final Object a;
    private final gl b;
    private final HashMap<ge, gg> c;
    private final acb<a, ge> d;
    @NonNull
    private final Context e;
    private volatile int f;
    @NonNull
    private final gi g;

    public gf(@NonNull Context context, @NonNull gl glVar) {
        this(context, glVar, new gi());
    }

    public gg a(@NonNull ge geVar, @NonNull ew ewVar) {
        gg ggVar;
        synchronized (this.a) {
            ggVar = this.c.get(geVar);
            if (ggVar == null) {
                ggVar = this.g.a(geVar).a(this.e, this.b, geVar, ewVar);
                this.c.put(geVar, ggVar);
                this.d.a(new a(geVar), geVar);
                this.f++;
            }
        }
        return ggVar;
    }

    @VisibleForTesting
    public gf(@NonNull Context context, @NonNull gl glVar, @NonNull gi giVar) {
        this.a = new Object();
        this.c = new HashMap<>();
        this.d = new acb<>();
        this.f = 0;
        this.e = context.getApplicationContext();
        this.b = glVar;
        this.g = giVar;
    }

    public static final class a {
        @NonNull
        private final String a;
        @Nullable
        private final Integer b;
        @Nullable
        private final String c;

        public a(@NonNull String str, @Nullable Integer num, @Nullable String str2) {
            this.a = str;
            this.b = num;
            this.c = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.a.equals(aVar.a)) {
                return false;
            }
            Integer num = this.b;
            if (num == null ? aVar.b != null : !num.equals(aVar.b)) {
                return false;
            }
            String str = this.c;
            String str2 = aVar.c;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            Integer num = this.b;
            int i = 0;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        public a(@NonNull ge geVar) {
            this(geVar.b(), geVar.c(), geVar.d());
        }
    }

    public void a(@NonNull String str, int i, String str2) {
        a(str, Integer.valueOf(i), str2);
    }

    private void a(@NonNull String str, @Nullable Integer num, @Nullable String str2) {
        synchronized (this.a) {
            Collection<ge> b2 = this.d.b(new a(str, num, str2));
            if (!dl.a((Collection) b2)) {
                this.f -= b2.size();
                ArrayList arrayList = new ArrayList(b2.size());
                for (ge geVar : b2) {
                    arrayList.add(this.c.remove(geVar));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((gg) it.next()).a();
                }
            }
        }
    }

    public int a() {
        return this.f;
    }
}
