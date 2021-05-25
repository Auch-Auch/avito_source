package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.f;
import java.util.HashMap;
import java.util.Map;
public class vj {
    private final Map<String, vi> a;
    @NonNull
    private final vl b;
    @NonNull
    private final act c;

    public static class a {
        private static final vj a = new vj(dr.a(), new vl());
    }

    @NonNull
    private vi b(@NonNull final Context context, @NonNull String str) {
        if (this.b.g() == null) {
            this.c.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vj.1
                @Override // java.lang.Runnable
                public void run() {
                    vj.this.b.a(context);
                }
            });
        }
        vi viVar = new vi(this.c, context, str);
        this.a.put(str, viVar);
        return viVar;
    }

    private vj(@NonNull act act, @NonNull vl vlVar) {
        this.a = new HashMap();
        this.c = act;
        this.b = vlVar;
    }

    @NonNull
    public static vj a() {
        return a.a;
    }

    @NonNull
    public vi a(@NonNull Context context, @NonNull String str) {
        vi viVar = this.a.get(str);
        if (viVar == null) {
            synchronized (this.a) {
                viVar = this.a.get(str);
                if (viVar == null) {
                    vi b2 = b(context, str);
                    b2.a(str);
                    viVar = b2;
                }
            }
        }
        return viVar;
    }

    @NonNull
    public vi a(@NonNull Context context, @NonNull f fVar) {
        vi viVar = this.a.get(fVar.apiKey);
        if (viVar == null) {
            synchronized (this.a) {
                viVar = this.a.get(fVar.apiKey);
                if (viVar == null) {
                    vi b2 = b(context, fVar.apiKey);
                    b2.a(fVar);
                    viVar = b2;
                }
            }
        }
        return viVar;
    }
}
