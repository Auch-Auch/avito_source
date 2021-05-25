package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.ob.qm;
public class rb {
    @NonNull
    public final qm.a a;
    @Nullable
    private Long b;
    private long c;
    private long d;
    @NonNull
    private Location e;
    @NonNull
    private p.a.EnumC0340a f;

    public rb(@NonNull qm.a aVar, long j, long j2, @NonNull Location location, @NonNull p.a.EnumC0340a aVar2) {
        this(aVar, j, j2, location, aVar2, null);
    }

    @Nullable
    public Long a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    @NonNull
    public Location c() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    @NonNull
    public p.a.EnumC0340a e() {
        return this.f;
    }

    public String toString() {
        StringBuilder L = a.L("LocationWrapper{collectionMode=");
        L.append(this.a);
        L.append(", mIncrementalId=");
        L.append(this.b);
        L.append(", mReceiveTimestamp=");
        L.append(this.c);
        L.append(", mReceiveElapsedRealtime=");
        L.append(this.d);
        L.append(", mLocation=");
        L.append(this.e);
        L.append(", mChargeType=");
        L.append(this.f);
        L.append('}');
        return L.toString();
    }

    public rb(@NonNull qm.a aVar, long j, long j2, @NonNull Location location, @NonNull p.a.EnumC0340a aVar2, @Nullable Long l) {
        this.a = aVar;
        this.b = l;
        this.c = j;
        this.d = j2;
        this.e = location;
        this.f = aVar2;
    }
}
