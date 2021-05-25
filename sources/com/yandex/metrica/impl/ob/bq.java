package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.impl.ob.br;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.xh;
import java.io.File;
public class bq implements bo {
    @Nullable
    private yb a;
    @NonNull
    private final Context b;
    @NonNull
    private final MetricaService.c c;
    @NonNull
    private final xh.a d;
    @Nullable
    private xh e;
    @NonNull
    private bb f;
    @NonNull
    private gf g;
    @NonNull
    private final gl h;
    @NonNull
    private final br i;
    @Nullable
    private rp j;
    @NonNull
    private final mq k;
    @NonNull
    private cl l;
    private lm m;

    public bq(@NonNull Context context, @NonNull MetricaService.c cVar) {
        this(context, cVar, new gl(context));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i() {
        rp rpVar = this.j;
        if (rpVar != null) {
            rpVar.a(this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        rp rpVar = this.j;
        if (rpVar != null) {
            rpVar.b(this);
        }
    }

    private bq(@NonNull Context context, @NonNull MetricaService.c cVar, @NonNull gl glVar) {
        this(context, cVar, glVar, new gf(context, glVar), new br(), new xh.a(), new mq(lv.a(context).c()), new an());
    }

    private void c() {
        this.i.a(new br.b() { // from class: com.yandex.metrica.impl.ob.bq.4
            @Override // com.yandex.metrica.impl.ob.br.b
            public void a() {
                bq.this.j();
            }
        });
        this.i.b(new br.b() { // from class: com.yandex.metrica.impl.ob.bq.5
            @Override // com.yandex.metrica.impl.ob.br.b
            public void a() {
                bq.this.i();
            }
        });
        this.i.c(new br.b() { // from class: com.yandex.metrica.impl.ob.bq.6
            @Override // com.yandex.metrica.impl.ob.br.b
            public void a() {
                bq bqVar = bq.this;
                bqVar.c(bqVar.a);
                bq.this.h();
                bq bqVar2 = bq.this;
                bqVar2.e = bqVar2.d.a(bq.this.b);
            }
        });
        this.i.d(new br.b() { // from class: com.yandex.metrica.impl.ob.bq.7
            @Override // com.yandex.metrica.impl.ob.br.b
            public void a() {
                bq.this.d();
            }
        });
        this.i.e(new br.b() { // from class: com.yandex.metrica.impl.ob.bq.8
            @Override // com.yandex.metrica.impl.ob.br.b
            public void a() {
                bq.this.e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        xh xhVar = this.e;
        if (xhVar != null) {
            xhVar.b();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        xh xhVar = this.e;
        if (xhVar != null) {
            xhVar.a();
        }
    }

    private void f() {
        yb ybVar = this.a;
        if (ybVar != null) {
            a(ybVar);
        }
        c(this.a);
    }

    private void g() {
        final kb kbVar = new kb(this.b);
        as.a().k().i().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.bq.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kbVar.a();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        if (this.a != null) {
            as.a().g().a(this.a);
        }
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void b(Intent intent) {
        this.i.b(intent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(@NonNull yb ybVar) {
        this.a = ybVar;
        g();
        c(ybVar);
        as.a().a(ybVar);
        this.f.a(this.a.D);
    }

    private Integer d(@NonNull Bundle bundle) {
        bundle.setClassLoader(eu.class.getClassLoader());
        eu a3 = eu.a(bundle);
        if (a3 == null) {
            return null;
        }
        return a3.f();
    }

    private void e(Intent intent) {
        if (!d(intent)) {
            Bundle extras = intent.getExtras();
            et etVar = new et(extras);
            if (!et.a(etVar, this.b)) {
                aa b2 = aa.b(extras);
                if (!b2.m() && !b2.n()) {
                    try {
                        this.l.a(ge.a(etVar), b2, new ew(etVar));
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a() {
        new db(this.b).a(this.b);
        as.a().b();
        abp.a().a(this.b);
        this.j = new rp(qp.a(this.b), as.a().l(), dn.a(this.b), this.k);
        c();
        eh.a().a(this, er.class, el.a(new ek<er>() { // from class: com.yandex.metrica.impl.ob.bq.3
            public void a(er erVar) {
                bq.this.b(erVar.b);
            }
        }).a(new ei<er>() { // from class: com.yandex.metrica.impl.ob.bq.2
            public boolean a(er erVar) {
                return !bq.this.b.getPackageName().equals(erVar.a);
            }
        }).a());
        yb ybVar = (yb) op.a.a(yb.class).a(this.b).a();
        this.a = ybVar;
        this.f = new bb(this.k, ybVar.D);
        pe.a().a(this.b, this.a);
        f();
        this.l = new cl(this.b, this.g);
        this.m.a();
        xa.b(this.b);
    }

    @VisibleForTesting
    public bq(@NonNull Context context, @NonNull MetricaService.c cVar, @NonNull gl glVar, @NonNull gf gfVar, @NonNull br brVar, @NonNull xh.a aVar, @NonNull mq mqVar, @NonNull an anVar) {
        this.b = context;
        this.c = cVar;
        this.g = gfVar;
        this.h = glVar;
        this.i = brVar;
        this.d = aVar;
        this.k = mqVar;
        this.m = new lm(anVar.b(context), new aby<File>() { // from class: com.yandex.metrica.impl.ob.bq.1
            public void a(File file) {
                bq.this.a(file);
            }
        });
    }

    private boolean d(Intent intent) {
        return intent == null || intent.getData() == null;
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void c(Intent intent) {
        String str;
        this.i.c(intent);
        if (intent != null) {
            String action = intent.getAction();
            Uri data = intent.getData();
            if (data == null) {
                str = null;
            } else {
                str = data.getEncodedAuthority();
            }
            if ("com.yandex.metrica.IMetricaService".equals(action)) {
                a(data, str);
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void b() {
        this.m.b();
        this.h.b();
        dn.a();
        eh.a().a(this);
        as.a().p();
    }

    @Override // com.yandex.metrica.impl.ob.bo
    public void c(@NonNull Bundle bundle) {
        Integer d2 = d(bundle);
        if (d2 != null) {
            as.a().o().b(d2.intValue());
        }
    }

    @Override // com.yandex.metrica.impl.ob.bo
    public void b(@NonNull Bundle bundle) {
        Integer d2 = d(bundle);
        if (d2 != null) {
            as.a().o().a(d2.intValue());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(@NonNull yb ybVar) {
        rp rpVar = this.j;
        if (rpVar != null) {
            rpVar.a(ybVar);
        }
    }

    private void b(Intent intent, int i2) {
        if (intent != null) {
            intent.getExtras().setClassLoader(CounterConfiguration.class.getClassLoader());
            e(intent);
        }
        this.c.a(i2);
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(Intent intent, int i2) {
        b(intent, i2);
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(Intent intent, int i2, int i3) {
        b(intent, i3);
    }

    @Override // com.yandex.metrica.impl.ob.bs
    public void a(Intent intent) {
        this.i.a(intent);
    }

    @VisibleForTesting
    public void a(@Nullable Uri uri, @Nullable String str) {
        if (uri != null && uri.getPath().equals("/client")) {
            int parseInt = Integer.parseInt(uri.getQueryParameter("pid"));
            this.g.a(str, parseInt, uri.getQueryParameter("psid"));
            as.a().o().c(parseInt);
        }
        if (this.g.a() <= 0) {
            e();
        }
    }

    @Override // com.yandex.metrica.impl.ob.bo
    @Deprecated
    public void a(String str, int i2, String str2, Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        this.l.a(new aa(str2, str, i2), bundle);
    }

    @Override // com.yandex.metrica.impl.ob.bo
    public void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        this.f.a();
        this.l.a(aa.b(bundle), bundle);
    }

    public void a(@NonNull File file) {
        this.l.a(file);
    }

    public void a(@NonNull yb ybVar) {
        xs xsVar = ybVar.r;
        if (xsVar == null) {
            eh.a().a(eq.class);
        } else {
            eh.a().b(new eq(xsVar));
        }
    }
}
