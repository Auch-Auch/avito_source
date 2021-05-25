package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
public final class g {

    public static final class b implements f {
        @Override // com.yandex.mobile.ads.impl.f
        public final void a() {
        }

        @Override // com.yandex.mobile.ads.impl.f
        public final void a(int i) {
        }

        @Override // com.yandex.mobile.ads.impl.f
        public final void a(@NonNull Context context, @NonNull View view) {
            view.setVisibility(0);
            view.setMinimumHeight(dv.a(context, 50.0f));
        }

        @Override // com.yandex.mobile.ads.impl.f
        public final void b() {
        }
    }

    public static final class a implements f {
        @NonNull
        private final a a;

        public a(@NonNull a aVar) {
            this.a = aVar;
        }

        @Override // com.yandex.mobile.ads.impl.f
        public final void a() {
            if (!dt.a((ad) this.a)) {
                this.a.u();
            }
        }

        @Override // com.yandex.mobile.ads.impl.f
        public final void a(@NonNull Context context, @NonNull View view) {
        }

        @Override // com.yandex.mobile.ads.impl.f
        public final void b() {
            if (!dt.a((ad) this.a)) {
                this.a.v();
            }
        }

        @Override // com.yandex.mobile.ads.impl.f
        public final void a(int i) {
            this.a.b(i);
        }
    }
}
