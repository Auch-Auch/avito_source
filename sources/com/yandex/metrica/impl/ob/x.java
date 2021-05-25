package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.cg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
public class x {
    private static final Object j = new Object();
    @SuppressLint({"StaticFieldLeak"})
    private static volatile x k;
    @NonNull
    public final String a = "android";
    public final String b = Build.MANUFACTURER;
    public final String c = Build.MODEL;
    public final String d = Build.VERSION.RELEASE;
    public final int e = Build.VERSION.SDK_INT;
    @NonNull
    public final b f;
    @NonNull
    public final String g;
    @NonNull
    public final String h;
    @NonNull
    public final List<String> i;
    @NonNull
    private final a l;

    public static class a {
        @Nullable
        private String a;
        @NonNull
        private Context b;
        private yb c;

        public a(@NonNull Context context) {
            this.b = context;
            eh.a().b(new en(this.a));
            eh.a().a(this, er.class, el.a(new ek<er>() { // from class: com.yandex.metrica.impl.ob.x.a.1
                public void a(er erVar) {
                    synchronized (a.this) {
                        a.this.c = erVar.b;
                    }
                }
            }).a());
            this.a = b(this.c) ? a(context) : null;
        }

        private synchronized boolean b(@NonNull yb ybVar) {
            if (ybVar == null) {
                ybVar = this.c;
            }
            return c(ybVar);
        }

        private boolean c(@NonNull yb ybVar) {
            return ybVar != null && ybVar.o.o;
        }

        @SuppressLint({"HardwareIds"})
        @Nullable
        private String a(@NonNull Context context) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable unused) {
                return null;
            }
        }

        @Nullable
        public String a(@NonNull yb ybVar) {
            if (TextUtils.isEmpty(this.a) && b(ybVar)) {
                this.a = a(this.b);
            }
            return this.a;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final float d;

        public b(@NonNull Point point, int i, float f) {
            this.a = Math.max(point.x, point.y);
            this.b = Math.min(point.x, point.y);
            this.c = i;
            this.d = f;
        }
    }

    private x(@NonNull Context context) {
        this.l = new a(context);
        this.f = new b(cg.b(context), context.getResources().getDisplayMetrics().densityDpi, context.getResources().getDisplayMetrics().density);
        this.g = cg.a(context).name().toLowerCase(Locale.US);
        this.h = String.valueOf(cg.b.c());
        this.i = Collections.unmodifiableList(new ArrayList<String>() { // from class: com.yandex.metrica.impl.ob.x.1
            {
                if (cg.b.a()) {
                    add("Superuser.apk");
                }
                if (cg.b.b()) {
                    add("su.so");
                }
            }
        });
    }

    public static x a(@NonNull Context context) {
        if (k == null) {
            synchronized (j) {
                if (k == null) {
                    k = new x(context.getApplicationContext());
                }
            }
        }
        return k;
    }

    @Nullable
    public String a() {
        return this.l.a((yb) null);
    }

    @Nullable
    public String a(@NonNull yb ybVar) {
        return this.l.a(ybVar);
    }
}
