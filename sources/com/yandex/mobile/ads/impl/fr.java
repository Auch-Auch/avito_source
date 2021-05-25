package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.p;
import org.json.JSONObject;
public final class fr {

    public interface a {
        void a();

        void a(@Nullable String str);
    }

    public static class b implements p.Ucc {
        @NonNull
        private final a a;
        @NonNull
        private final fv b = new fv();

        public b(@NonNull a aVar) {
            this.a = aVar;
        }

        @Override // com.yandex.metrica.p.Ucc
        public final void onError(@Nullable String str) {
            this.a.a();
        }

        @Override // com.yandex.metrica.p.Ucc
        public final void onResult(@Nullable JSONObject jSONObject) {
            this.a.a(jSONObject != null ? cb.a(jSONObject.toString()) : null);
        }
    }
}
