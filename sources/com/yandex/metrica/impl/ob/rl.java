package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.qm;
public class rl extends z<Location> {
    @NonNull
    private lz a;
    @NonNull
    private pr b;
    @NonNull
    private abs c;
    @NonNull
    private final p d;
    @NonNull
    private final k e;

    public rl(@NonNull Context context, @Nullable y<Location> yVar) {
        this(yVar, lv.a(context).g(), new pr(context), new abs(), as.a().n(), as.a().o());
    }

    /* renamed from: a */
    public void b(@Nullable Location location) {
        if (location != null) {
            rb rbVar = new rb(qm.a.a(this.e.c()), this.c.a(), this.c.c(), location, this.d.d());
            String a3 = this.b.a(rbVar);
            if (!TextUtils.isEmpty(a3)) {
                this.a.b(rbVar.b(), a3);
            }
        }
    }

    public rl(@Nullable y<Location> yVar, @NonNull lz lzVar, @NonNull pr prVar, @NonNull abs abs, @NonNull p pVar, @NonNull k kVar) {
        super(yVar);
        this.a = lzVar;
        this.b = prVar;
        this.c = abs;
        this.d = pVar;
        this.e = kVar;
    }
}
