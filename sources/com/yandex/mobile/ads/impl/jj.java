package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;
public class jj extends iy {
    public final fa a;

    public jj(@NonNull ev evVar, @NonNull er erVar) {
        super(evVar);
        fa faVar = new fa(evVar);
        this.a = faVar;
        faVar.a(new a(erVar));
    }

    @Override // com.yandex.mobile.ads.impl.iy, com.yandex.mobile.ads.impl.ja
    public final void a(@NonNull String str) {
        this.a.a(str);
    }

    @Override // com.yandex.mobile.ads.impl.iy, com.yandex.mobile.ads.impl.ja
    public final void b() {
        super.b();
        this.a.c();
    }

    public static class a implements fd {
        @NonNull
        private final WeakReference<er> a;

        public a(@NonNull er erVar) {
            this.a = new WeakReference<>(erVar);
        }

        @Override // com.yandex.mobile.ads.impl.fd
        public final void a() {
            er erVar = this.a.get();
            if (erVar != null) {
                erVar.onAdLoaded();
            }
        }

        @Override // com.yandex.mobile.ads.impl.fd
        public final void a(@NonNull String str) {
            er erVar = this.a.get();
            if (erVar != null) {
                erVar.a(str);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.iy, com.yandex.mobile.ads.impl.ja
    public final void a(@NonNull er erVar) {
        super.a(new ji(this.a, erVar));
    }
}
