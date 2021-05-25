package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzclj implements zzelo<zzcli> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcln> zzesn;

    public zzclj(zzelx<zzcln> zzelx, zzelx<Executor> zzelx2) {
        this.zzesn = zzelx;
        this.zzerr = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcli(this.zzesn.get(), this.zzerr.get());
    }
}
