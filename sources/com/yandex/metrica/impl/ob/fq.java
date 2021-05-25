package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.fe;
import com.yandex.metrica.impl.ob.vt;
import java.io.File;
public class fq extends fe {
    @NonNull
    private final vt b;
    @NonNull
    private final a c;
    @NonNull
    private final df d;
    @NonNull
    private final bv e;
    @NonNull
    private final lm f;
    @NonNull
    private final bw g;

    public class a implements vt.a {
        public a() {
        }

        @Override // com.yandex.metrica.impl.ob.vt.a
        public boolean a(@NonNull vu vuVar, @NonNull bd bdVar) {
            fq.this.a(new aa().a(vuVar.a()).a(al.a.EVENT_TYPE_SEND_REFERRER.a()));
            return true;
        }
    }

    public fq(@NonNull Context context, @NonNull yb ybVar, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull vt vtVar, @NonNull df dfVar, @NonNull ye yeVar) {
        this(context, fbVar, new fe.a(), new dj(), new an(), new fr(context, fbVar, aVar, yeVar, ybVar, new fp(dfVar), as.a().k().g(), dl.c(context, fbVar.b())), vtVar, dfVar, aVar.q);
    }

    private void D() {
        this.a.a(i().U()).q();
    }

    @Override // com.yandex.metrica.impl.ob.fe, com.yandex.metrica.impl.ob.fg
    public void b() {
        this.f.b();
        super.b();
    }

    @Override // com.yandex.metrica.impl.ob.fe, com.yandex.metrica.impl.ob.fk
    public synchronized void a(@NonNull ew.a aVar) {
        super.a(aVar);
        D();
        this.d.a(aVar.m);
    }

    @VisibleForTesting
    public fq(@NonNull Context context, @NonNull fb fbVar, @NonNull fe.a aVar, @NonNull dj djVar, @NonNull an anVar, @NonNull fr frVar, @NonNull vt vtVar, @NonNull df dfVar, @Nullable Boolean bool) {
        super(context, fbVar, aVar, djVar, frVar);
        this.b = vtVar;
        hg f2 = f();
        f2.a(al.a.EVENT_TYPE_REGULAR, new iv(f2.a()));
        a a3 = frVar.a(this);
        this.c = a3;
        vtVar.a(a3);
        this.d = dfVar;
        bw b2 = frVar.b(this);
        this.g = b2;
        bv a4 = frVar.a(b2, y());
        this.e = a4;
        lm a5 = frVar.a(anVar, new aby<File>() { // from class: com.yandex.metrica.impl.ob.fq.1
            public void a(File file) {
                fq.this.a(file);
            }
        });
        this.f = a5;
        if (Boolean.TRUE.equals(bool)) {
            a5.a();
            a4.a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.fe
    @NonNull
    public CounterConfiguration.a a() {
        return CounterConfiguration.a.MAIN;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(File file) {
        this.e.a(file.getAbsolutePath(), new aby<Boolean>() { // from class: com.yandex.metrica.impl.ob.fq.2
            public void a(Boolean bool) {
            }
        }, true);
    }
}
