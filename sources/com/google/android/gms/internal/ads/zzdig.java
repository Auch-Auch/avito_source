package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public final class zzdig<R> implements zzdnv {
    public final Executor executor;
    public final String zzbuo;
    public final zzvc zzdpw;
    public final zzvm zzgsx;
    public final zzdjb<R> zzgyn;
    public final zzdja zzgyo;
    @Nullable
    private final zzdnk zzgyp;

    public zzdig(zzdjb<R> zzdjb, zzdja zzdja, zzvc zzvc, String str, Executor executor2, zzvm zzvm, @Nullable zzdnk zzdnk) {
        this.zzgyn = zzdjb;
        this.zzgyo = zzdja;
        this.zzdpw = zzvc;
        this.zzbuo = str;
        this.executor = executor2;
        this.zzgsx = zzvm;
        this.zzgyp = zzdnk;
    }

    @Override // com.google.android.gms.internal.ads.zzdnv
    public final Executor getExecutor() {
        return this.executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdnv
    @Nullable
    public final zzdnk zzasd() {
        return this.zzgyp;
    }

    @Override // com.google.android.gms.internal.ads.zzdnv
    public final zzdnv zzase() {
        return new zzdig(this.zzgyn, this.zzgyo, this.zzdpw, this.zzbuo, this.executor, this.zzgsx, this.zzgyp);
    }
}
