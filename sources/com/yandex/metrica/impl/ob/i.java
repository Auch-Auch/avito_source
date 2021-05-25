package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Pair;
public class i {
    private abj a;
    private long b;
    private boolean c;
    @NonNull
    private final adj d;

    public static final class a {
        public final String a;
        public final long b;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            String str = this.a;
            String str2 = aVar.a;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = str != null ? str.hashCode() : 0;
            long j = this.b;
            return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
        }
    }

    public i(String str, long j, @NonNull abl abl) {
        this(str, j, new adj(abl, "[App Environment]"));
    }

    public synchronized void a() {
        this.a = new abj();
    }

    public synchronized a b() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new a(abc.b(this.a), this.b);
    }

    public synchronized String toString() {
        return "Map size " + this.a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    @VisibleForTesting
    public i(String str, long j, @NonNull adj adj) {
        this.b = j;
        try {
            this.a = new abj(str);
        } catch (Throwable unused) {
            this.a = new abj();
        }
        this.d = adj;
    }

    public synchronized void a(@NonNull Pair<String, String> pair) {
        if (this.d.a(this.a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }
}
