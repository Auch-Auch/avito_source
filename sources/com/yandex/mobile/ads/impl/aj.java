package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
public final class aj {
    @NonNull
    private final Context a;
    @NonNull
    private final fo b;
    @NonNull
    private final dc c;
    @NonNull
    private final ak d = ak.a();
    @NonNull
    private final ai e = ai.a();

    public interface a {
        void a();

        void a(@NonNull sl slVar);
    }

    public aj(@NonNull Context context, @NonNull fo foVar) {
        this.a = context.getApplicationContext();
        this.b = foVar;
        this.c = new dc(context);
    }

    public final void a(@NonNull a aVar) {
        String str;
        if (this.c.a()) {
            al alVar = new al(this.a, this.d, aVar);
            Context context = this.a;
            String f = this.b.f();
            if (!TextUtils.isEmpty(f)) {
                String d2 = ae.a(fq.a(context)).b(this.b.d()).a(this.b.i()).b(this.b.j()).a().b(context).a(context, this.b.g()).f(context).b().c().d();
                StringBuilder sb = new StringBuilder(f);
                String str2 = "/";
                if (f.endsWith(str2)) {
                    str2 = "";
                }
                str = a2.b.a.a.a.v(sb, str2, "v1/startup", "?", d2);
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                bz bzVar = new bz(str, this.c, alVar);
                bzVar.a(this);
                this.e.a(this.a, (ry) bzVar);
                return;
            }
            alVar.a((sl) new r());
            return;
        }
        aVar.a();
    }

    public final void a() {
        this.e.a(this.a, this);
    }
}
