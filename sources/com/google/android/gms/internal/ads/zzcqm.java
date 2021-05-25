package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
public final class zzcqm implements zzdvi<SQLiteDatabase> {
    private final /* synthetic */ zzdoq zzgjw;

    public zzcqm(zzcqk zzcqk, zzdoq zzdoq) {
        this.zzgjw = zzdoq;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(SQLiteDatabase sQLiteDatabase) {
        try {
            this.zzgjw.apply(sQLiteDatabase);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbbd.zzfc(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzbbd.zzfc(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }
}
