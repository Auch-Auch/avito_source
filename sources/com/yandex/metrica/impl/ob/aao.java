package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.uiaccessor.a;
import com.yandex.metrica.uiaccessor.b;
public class aao implements dk {
    @NonNull
    private final aan a;
    @NonNull
    private final act b;
    @NonNull
    private final mn c;
    @NonNull
    private final dm d;
    @NonNull
    private final zo e;
    @NonNull
    private final aar f;
    @NonNull
    private final aaj g;
    @Nullable
    private Runnable h;
    @NonNull
    private final b i;
    @NonNull
    private final av j;
    @Nullable
    private aag k;
    @NonNull
    private final abt l;
    @NonNull
    private final ay m;
    @NonNull
    private final aaa n;
    private long o;

    public static class a {
        @NonNull
        public b a(@NonNull final aby<Activity> aby) {
            com.yandex.metrica.uiaccessor.a aVar;
            try {
                aVar = new com.yandex.metrica.uiaccessor.a(new a.AbstractC0365a() { // from class: com.yandex.metrica.impl.ob.aao.a.1
                });
            } catch (Throwable unused) {
                aVar = null;
            }
            return aVar == null ? new b() { // from class: com.yandex.metrica.impl.ob.aao.a.2
                @Override // com.yandex.metrica.uiaccessor.b
                public void a(@NonNull Activity activity) throws Throwable {
                }
            } : aVar;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public aao(@NonNull act act, @NonNull mn mnVar, @NonNull dm dmVar, @NonNull av avVar, @Nullable aag aag) {
        this(act, mnVar, dmVar, avVar, aag, new aan(aag == null ? null : aag.d), new zo(1, mnVar), new aar(), new aaj(), new a(), new abs(), xa.a(), new aaa());
    }

    public static /* synthetic */ long i(aao aao) {
        long j2 = aao.o + 1;
        aao.o = j2;
        return j2;
    }

    @VisibleForTesting
    public aao(@NonNull act act, @NonNull mn mnVar, @NonNull dm dmVar, @NonNull av avVar, @Nullable aag aag, @NonNull aan aan, @NonNull zo zoVar, @NonNull aar aar, @NonNull aaj aaj, @NonNull a aVar, @NonNull abt abt, @NonNull ay ayVar, @NonNull aaa aaa) {
        this.b = act;
        this.c = mnVar;
        this.k = aag;
        this.a = aan;
        this.d = dmVar;
        this.j = avVar;
        this.e = zoVar;
        this.f = aar;
        this.g = aaj;
        this.i = aVar.a(new aby<Activity>() { // from class: com.yandex.metrica.impl.ob.aao.1
            public void a(Activity activity) {
                aao.this.a(activity);
            }
        });
        this.l = abt;
        this.m = ayVar;
        this.n = aaa;
        this.o = mnVar.g(0);
    }

    private void a(@NonNull Activity activity, long j2, @Nullable aal aal, boolean z) {
        if (aal != null) {
            aag aag = this.k;
            if (aag == null) {
                aal.a(String.format("no %s_config", "ui_access"));
            } else if (!aag.a) {
                aal.a(String.format("feature %s disabled", "ui_parsing"));
            } else if (aag.d == null) {
                aal.a(String.format("no %s_config", "ui_parsing"));
            } else if (!aag.c) {
                aal.a(String.format("feature %s disabled", "ui_collecting_for_bridge"));
            } else if (aag.f == null) {
                aal.a(String.format("no %s_config", "ui_collecting_for_bridge"));
            }
        }
        aag aag2 = this.k;
        if (aag2 != null && aag2.a) {
            try {
                this.i.a(activity);
            } catch (Throwable unused) {
            }
            Runnable a3 = a(activity, this.k, aal, z);
            Runnable runnable = this.h;
            if (runnable != null) {
                this.b.b(runnable);
            }
            this.h = a3;
            this.b.a(a3, j2);
        }
    }

    public void a(@NonNull Activity activity) {
        aap aap;
        aag aag = this.k;
        if (aag != null && (aap = aag.d) != null) {
            a(activity, aap.d, (aal) null, false);
        }
    }

    public void a(@NonNull Activity activity, @Nullable aal aal, boolean z) {
        a(activity, 0, aal, z);
    }

    @Override // com.yandex.metrica.impl.ob.dk
    public void a(@NonNull aag aag) {
        Activity a3;
        this.a.a(aag.d);
        aag aag2 = this.k;
        this.k = aag;
        if (aag2 == null && (a3 = this.j.a()) != null) {
            a(a3, (aal) null, false);
        }
    }

    @NonNull
    public zo a() {
        return this.e;
    }

    @NonNull
    private Runnable a(@NonNull final Activity activity, @NonNull final aag aag, @Nullable final aal aal, final boolean z) {
        return new Runnable() { // from class: com.yandex.metrica.impl.ob.aao.2
            @Override // java.lang.Runnable
            public void run() {
                aag aag2 = aag;
                boolean z2 = false;
                if (aag2.c && aag2.f != null && (aao.this.c.a(false) || z)) {
                    z2 = true;
                }
                zt a3 = aao.this.a(z2);
                try {
                    long a4 = aao.this.l.a();
                    aaf a5 = aao.this.a.a(activity, a3);
                    if (z2) {
                        aao.this.g.a(aao.this.e, activity, a3.a(), aag.f, aao.this.o);
                        aao.this.a(aal);
                    }
                    aag aag3 = aag;
                    if (aag3.b && aag3.e != null) {
                        aao.this.d.a(aao.this.f.a(activity, a5, aag.e, aao.this.o));
                    }
                    aao.this.c.h(aao.i(aao.this));
                    aao.this.m.reportEvent("ui_parsing_time", aao.this.n.a(aao.this.l.a() - a4).toString());
                } catch (Throwable th) {
                    aao.this.m.reportError("ui_parsing", th);
                    aao.this.a(aal, th);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private zt a(boolean z) {
        if (z) {
            return new zz();
        }
        return new zp();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(@Nullable aal aal) {
        if (aal != null) {
            aal.a(this.e.b());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(@Nullable aal aal, @NonNull Throwable th) {
        if (aal != null) {
            StringBuilder L = a2.b.a.a.a.L("exception: ");
            L.append(th.getMessage());
            aal.a(L.toString());
        }
    }
}
