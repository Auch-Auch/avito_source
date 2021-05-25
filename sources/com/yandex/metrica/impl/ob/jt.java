package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import okhttp3.internal.connection.RealConnection;
public class jt {
    private final mo a;

    public jt(@NonNull mo moVar) {
        this.a = moVar;
    }

    public long a() {
        long j = this.a.j();
        long j2 = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (j >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j2 = 1 + j;
        }
        this.a.e(j2).q();
        return j2;
    }
}
