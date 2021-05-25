package com.yandex.metrica.impl.ob;

import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
public class br implements bs {
    private final acb<String, Integer> a = new acb<>();
    private final Map<b, a> b = new LinkedHashMap();
    private final Map<b, a> c = new LinkedHashMap();

    public interface a {
        boolean a(@NonNull Intent intent, @NonNull br brVar);
    }

    public interface b {
        void a();
    }

    private void d(@NonNull Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            this.a.a(action, Integer.valueOf(h(intent)));
        }
        a(intent, this.b);
    }

    private void e(@NonNull Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            this.a.b(action, Integer.valueOf(h(intent)));
        }
        a(intent, this.c);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean f(@NonNull Intent intent) {
        return g(intent) && d();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean g(@NonNull Intent intent) {
        if (b(intent.getAction())) {
            return !a(h(intent));
        }
        return false;
    }

    private int h(@NonNull Intent intent) {
        Uri data = intent.getData();
        if (data != null && data.getPath().equals("/client")) {
            try {
                return Integer.parseInt(data.getQueryParameter("pid"));
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a() {
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(Intent intent, int i) {
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(Intent intent, int i, int i2) {
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void b() {
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void c(Intent intent) {
        if (intent != null) {
            e(intent);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean f() {
        return e() == 0;
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void b(Intent intent) {
        if (intent != null) {
            d(intent);
        }
    }

    public void c(@NonNull b bVar) {
        this.b.put(bVar, new a() { // from class: com.yandex.metrica.impl.ob.br.1
            @Override // com.yandex.metrica.impl.ob.br.a
            public boolean a(@NonNull Intent intent, @NonNull br brVar) {
                return br.this.f(intent);
            }
        });
    }

    @NonNull
    private a c() {
        return new a() { // from class: com.yandex.metrica.impl.ob.br.4
            @Override // com.yandex.metrica.impl.ob.br.a
            public boolean a(@NonNull Intent intent, @NonNull br brVar) {
                return br.this.a(intent.getAction());
            }
        };
    }

    public void b(@NonNull b bVar) {
        this.c.put(bVar, c());
    }

    private boolean b(@Nullable String str) {
        return "com.yandex.metrica.IMetricaService".equals(str);
    }

    private Collection<Integer> g() {
        return this.a.a((acb<String, Integer>) "com.yandex.metrica.IMetricaService");
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(Intent intent) {
        if (intent != null) {
            d(intent);
        }
    }

    private void a(@NonNull Intent intent, @NonNull Map<b, a> map) {
        for (Map.Entry<b, a> entry : map.entrySet()) {
            if (entry.getValue().a(intent, this)) {
                entry.getKey().a();
            }
        }
    }

    public void d(@NonNull b bVar) {
        this.b.put(bVar, new a() { // from class: com.yandex.metrica.impl.ob.br.2
            @Override // com.yandex.metrica.impl.ob.br.a
            public boolean a(@NonNull Intent intent, @NonNull br brVar) {
                return br.this.g(intent);
            }
        });
    }

    public void e(@NonNull b bVar) {
        this.c.put(bVar, new a() { // from class: com.yandex.metrica.impl.ob.br.3
            @Override // com.yandex.metrica.impl.ob.br.a
            public boolean a(@NonNull Intent intent, @NonNull br brVar) {
                return br.this.g(intent) && br.this.f();
            }
        });
    }

    private boolean d() {
        return e() == 1;
    }

    private int e() {
        Collection<Integer> g = g();
        int i = 0;
        if (!dl.a((Collection) g)) {
            for (Integer num : g) {
                if (!a(num.intValue())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void a(@NonNull b bVar) {
        this.b.put(bVar, c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean a(@Nullable String str) {
        return "com.yandex.metrica.ACTION_C_BG_L".equals(str);
    }

    private boolean a(int i) {
        return i == Process.myPid();
    }
}
