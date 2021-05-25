package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
public class kf {
    @NonNull
    private final c a;

    @TargetApi(26)
    public static class a implements c {
        @NonNull
        private final kc a;

        public a(@NonNull Context context) {
            this.a = new kc(context);
        }

        @Override // com.yandex.metrica.impl.ob.kf.c
        @NonNull
        public kd a() {
            return this.a;
        }
    }

    public static class b implements c {
        @NonNull
        private final ke a;

        public b(@NonNull Context context) {
            this.a = new ke(context);
        }

        @Override // com.yandex.metrica.impl.ob.kf.c
        @NonNull
        public kd a() {
            return this.a;
        }
    }

    public interface c {
        @NonNull
        kd a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public kf(@NonNull Context context) {
        this(Build.VERSION.SDK_INT >= 26 ? new a(context) : new b(context));
    }

    public kd a() {
        return this.a.a();
    }

    public kf(@NonNull c cVar) {
        this.a = cVar;
    }
}
