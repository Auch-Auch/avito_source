package com.yandex.metrica.impl.ob;

import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class qw {
    @NonNull
    public final po a;
    @NonNull
    public final yb b;
    @Nullable
    public final LocationManager c;
    @Nullable
    public final ql d;
    @NonNull
    public final rm e;
    @NonNull
    public final pn f;

    @VisibleForTesting
    public qw(@NonNull po poVar, @NonNull yb ybVar, @Nullable ql qlVar, @Nullable LocationManager locationManager, @NonNull rm rmVar, @NonNull pn pnVar) {
        this.a = poVar;
        this.b = ybVar;
        this.d = qlVar;
        this.c = locationManager;
        this.e = rmVar;
        this.f = pnVar;
    }

    public static qw a(@NonNull rh rhVar, @NonNull rm rmVar, @NonNull pn pnVar, @Nullable LocationManager locationManager) {
        return new qw(rhVar.a, rhVar.b, rhVar.c, locationManager, rmVar, pnVar);
    }
}
