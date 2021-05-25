package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.kk;
import com.yandex.metrica.impl.ob.op;
public class km {
    @NonNull
    private final Context a;
    @NonNull
    private final kk b;
    @NonNull
    private final kl c;
    @NonNull
    private final a d;
    @NonNull
    private final kh e;

    public static class a {
        public yb a(@NonNull Context context) {
            return (yb) op.a.a(yb.class).a(context).a();
        }
    }

    public km(@NonNull Context context, @NonNull act act, @NonNull kg kgVar) {
        this(context, act, kgVar, new kl(context));
    }

    private void b() {
        this.b.a();
    }

    private km(@NonNull Context context, @NonNull act act, @NonNull kg kgVar, @NonNull kl klVar) {
        this(context, new kk(act, kgVar), klVar, new a(), new kh(context));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(@Nullable kn knVar) {
        if (knVar != null) {
            knVar.a();
        }
    }

    @VisibleForTesting
    public km(@NonNull Context context, @NonNull kk kkVar, @NonNull kl klVar, @NonNull a aVar, @NonNull kh khVar) {
        this.a = context;
        this.b = kkVar;
        this.c = klVar;
        this.d = aVar;
        this.e = khVar;
    }

    public void a() {
        a(this.d.a(this.a));
    }

    private void a(@NonNull yb ybVar) {
        rr rrVar = ybVar.q;
        if (rrVar != null) {
            boolean z = rrVar.b;
            Long a3 = this.e.a(rrVar.c);
            if (!ybVar.o.j || a3 == null || a3.longValue() <= 0) {
                b();
            } else {
                this.b.a(a3.longValue(), z);
            }
        }
    }

    public void a(@Nullable final kn knVar) {
        yb a3 = this.d.a(this.a);
        rr rrVar = a3.q;
        if (rrVar != null) {
            long j = rrVar.a;
            if (j > 0) {
                this.c.a(this.a.getPackageName());
                this.b.a(j, new kk.a() { // from class: com.yandex.metrica.impl.ob.km.1
                    @Override // com.yandex.metrica.impl.ob.kk.a
                    public void a() {
                        km.this.c.a();
                        km.this.b(knVar);
                    }
                });
            } else {
                b(knVar);
            }
        } else {
            b(knVar);
        }
        a(a3);
    }
}
