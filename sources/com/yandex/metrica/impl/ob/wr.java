package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.List;
public class wr {
    @NonNull
    public final List<wu> a;
    @NonNull
    public final String b;
    public final long c;
    public final boolean d;
    public final boolean e;

    public wr(@NonNull List<wu> list, @NonNull String str, long j, boolean z, boolean z2) {
        this.a = Collections.unmodifiableList(list);
        this.b = str;
        this.c = j;
        this.d = z;
        this.e = z2;
    }

    public String toString() {
        StringBuilder L = a.L("SdkFingerprintingState{sdkItemList=");
        L.append(this.a);
        L.append(", etag='");
        a.k1(L, this.b, '\'', ", lastAttemptTime=");
        L.append(this.c);
        L.append(", hasFirstCollectionOccurred=");
        L.append(this.d);
        L.append(", shouldRetry=");
        return a.A(L, this.e, '}');
    }
}
