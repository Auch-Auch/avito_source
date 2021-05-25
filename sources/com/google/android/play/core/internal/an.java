package com.google.android.play.core.internal;

import a2.j.b.e.a.d.h;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.e;
import com.google.android.play.core.splitinstall.b;
import com.google.android.play.core.splitinstall.d;
import java.util.List;
import java.util.concurrent.Executor;
public final class an implements d {
    public final Context a;
    public final e b;
    public final ao c;
    public final Executor d;

    public an(Context context, Executor executor, ao aoVar, e eVar, aq aqVar, byte[] bArr) {
        this.a = context;
        this.b = eVar;
        this.c = aoVar;
        this.d = executor;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void a(List<Intent> list, b bVar) {
        b(list, bVar);
    }

    public final void b(List<Intent> list, b bVar) {
        if (SplitCompat.a()) {
            this.d.execute(new h(this, list, bVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
