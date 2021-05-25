package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.nativeads.r;
import com.yandex.mobile.ads.nativeads.s;
public final class e implements s {
    @NonNull
    private final a a;

    public interface a {
        void a(@NonNull r rVar);
    }

    public e(@NonNull a aVar) {
        this.a = aVar;
    }

    @Override // com.yandex.mobile.ads.nativeads.s
    @NonNull
    public final r a(@NonNull Context context, @NonNull fo foVar) {
        r rVar = new r(context, foVar);
        this.a.a(rVar);
        return rVar;
    }
}
