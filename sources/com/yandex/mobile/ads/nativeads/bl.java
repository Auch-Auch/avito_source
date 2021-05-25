package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.dm;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.fy;
import com.yandex.mobile.ads.impl.fz;
import com.yandex.mobile.ads.impl.og;
public final class bl {
    @Nullable
    private AdTapHandler a;

    @NonNull
    public final dm a(@NonNull Context context, @NonNull fo foVar, @NonNull ResultReceiver resultReceiver) {
        if (this.a != null) {
            fz a3 = fy.a().a(context);
            if (a3 != null && a3.c()) {
                return new g(this.a);
            }
        }
        return new og(context, foVar, resultReceiver);
    }

    public final void a(@Nullable AdTapHandler adTapHandler) {
        this.a = adTapHandler;
    }
}
