package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;
public final class zzds implements zzdrw {
    private final /* synthetic */ zzdpx zzwe;

    public zzds(zzdp zzdp, zzdpx zzdpx) {
        this.zzwe = zzdpx;
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    public final boolean zzb(File file) {
        try {
            return this.zzwe.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
