package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.d;
import com.yandex.metrica.i;
public class vq extends vp implements d {
    public static final adw<i> f = new ads(new adr("User Info"));

    @Override // com.yandex.metrica.d
    public void a(@Nullable String str, @Nullable String str2) {
    }

    @Override // com.yandex.metrica.d
    public void b(@NonNull String str, @Nullable String str2) throws adt {
        vp.a.a(str);
    }

    @Override // com.yandex.metrica.impl.ob.vp, com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
    }
}
