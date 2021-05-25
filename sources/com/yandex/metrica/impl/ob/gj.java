package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class gj implements gg, xy {
    @NonNull
    private final Context a;
    @NonNull
    private ey b;
    @Nullable
    private final ResultReceiver c;

    public gj(@NonNull Context context, @NonNull ey eyVar, @NonNull ew ewVar) {
        this.a = context;
        this.b = eyVar;
        this.c = ewVar.c;
        eyVar.a(this);
    }

    @Override // com.yandex.metrica.impl.ob.gg
    public void a(@NonNull aa aaVar, @NonNull ew ewVar) {
        this.b.a(ewVar.b);
        this.b.a(aaVar, this);
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public void a(@NonNull xv xvVar, @Nullable yb ybVar) {
    }

    @NonNull
    public ey b() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public void a(@Nullable yb ybVar) {
        ab.a(this.c, ybVar);
    }

    @Override // com.yandex.metrica.impl.ob.gg
    public void a() {
        this.b.b(this);
    }
}
