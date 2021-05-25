package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.tb;
public final class dn implements dp {
    @NonNull
    private final Context a;
    @NonNull
    private final ai b = ai.a();

    public dn(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.dp
    public final void a(@NonNull String str) {
        this.b.a(this.a, (ry) new by(str, new a(str)));
    }

    public static class a implements tb.a<rx> {
        private final String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.yandex.mobile.ads.impl.sa.b
        public final /* synthetic */ void a(Object obj) {
            int i = ((rx) obj).a;
        }

        @Override // com.yandex.mobile.ads.impl.sa.a
        public final void a(@NonNull sl slVar) {
            slVar.toString();
        }
    }
}
