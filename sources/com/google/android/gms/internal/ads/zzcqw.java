package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztw;
import java.util.ArrayList;
public final class zzcqw implements zzdvi<Bundle> {
    private final /* synthetic */ boolean zzgkt;
    public final /* synthetic */ zzcqt zzgku;

    public zzcqw(zzcqt zzcqt, boolean z) {
        this.zzgku = zzcqt;
        this.zzgkt = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcqt zzcqt = this.zzgku;
        ArrayList arrayList = zzcqt.zzm(bundle2);
        zzcqt zzcqt2 = this.zzgku;
        zztw.zzo.zzb zzb = zzcqt.zzl(bundle2);
        this.zzgku.zzgkl.zza(new zzdoq(this, this.zzgkt, arrayList, this.zzgku.zzk(bundle2), zzb) { // from class: com.google.android.gms.internal.ads.zzcqv
            private final boolean zzegf;
            private final zzcqw zzgkp;
            private final ArrayList zzgkq;
            private final zztw.zzm zzgkr;
            private final zztw.zzo.zzb zzgks;

            {
                this.zzgkp = r1;
                this.zzegf = r2;
                this.zzgkq = r3;
                this.zzgkr = r4;
                this.zzgks = r5;
            }

            @Override // com.google.android.gms.internal.ads.zzdoq
            public final Object apply(Object obj) {
                zzcqw zzcqw = this.zzgkp;
                boolean z = this.zzegf;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                byte[] bArr = zzcqw.zzgku.zza(z, this.zzgkq, this.zzgkr, this.zzgks);
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(zzp.zzkw().currentTimeMillis()));
                contentValues.put("serialized_proto_data", bArr);
                sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
                if (!z) {
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "failed_requests"));
                }
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzbbd.zzfc("Failed to get signals bundle");
    }
}
