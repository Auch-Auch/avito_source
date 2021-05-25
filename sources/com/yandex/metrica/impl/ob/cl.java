package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.wf;
import java.io.File;
public class cl {
    @NonNull
    private final Context a;
    @NonNull
    private final act b;
    @NonNull
    private final gf c;

    public cl(@NonNull Context context, @NonNull gf gfVar) {
        this(context, gfVar, as.a().k().c());
    }

    public void a(aa aaVar, Bundle bundle) {
        if (!aaVar.n()) {
            this.b.a(new cm(this.a, aaVar, bundle, this.c));
        }
    }

    @VisibleForTesting
    public cl(@NonNull Context context, @NonNull gf gfVar, @NonNull act act) {
        this.a = context;
        this.b = act;
        this.c = gfVar;
    }

    public void a(@NonNull File file) {
        this.b.a(new kw(this.a, file, new aby<ln>() { // from class: com.yandex.metrica.impl.ob.cl.1
            public void a(ln lnVar) {
                cl.this.a(new ge(lnVar.h(), lnVar.g(), lnVar.e(), lnVar.f(), lnVar.i()), al.a(lnVar.b(), lnVar.a(), lnVar.c(), lnVar.d(), abd.a(lnVar.h())), new ew(new wf.a(), new ew.a(), null));
            }
        }));
    }

    public void a(@NonNull ge geVar, @NonNull aa aaVar, @NonNull ew ewVar) {
        this.c.a(geVar, ewVar).a(aaVar, ewVar);
        this.c.a(geVar.b(), geVar.c().intValue(), geVar.d());
    }
}
