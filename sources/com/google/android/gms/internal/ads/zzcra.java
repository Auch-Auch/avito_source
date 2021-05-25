package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zztw;
import java.util.ArrayList;
public final class zzcra {
    private zzbbg zzdpq;
    private zzcqk zzgkl;
    private zzto zzgkx;
    private Context zzvr;

    public zzcra(Context context, zzbbg zzbbg, zzto zzto, zzcqk zzcqk) {
        this.zzvr = context;
        this.zzdpq = zzbbg;
        this.zzgkx = zzto;
        this.zzgkl = zzcqk;
    }

    public final void zzapt() {
        try {
            this.zzgkl.zza(new zzdoq(this) { // from class: com.google.android.gms.internal.ads.zzcqz
                private final zzcra zzgkw;

                {
                    this.zzgkw = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdoq
                public final Object apply(Object obj) {
                    return this.zzgkw.zzb((SQLiteDatabase) obj);
                }
            });
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbbd.zzfc(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    public final /* synthetic */ Void zzb(SQLiteDatabase sQLiteDatabase) throws Exception {
        ArrayList<zztw.zzo.zza> zza = zzcqx.zza(sQLiteDatabase);
        int i = 0;
        zztw.zzo zzo = (zztw.zzo) ((zzegp) zztw.zzo.zzok().zzce(this.zzvr.getPackageName()).zzcf(Build.MODEL).zzco(zzcqx.zza(sQLiteDatabase, 0)).zzf(zza).zzcp(zzcqx.zza(sQLiteDatabase, 1)).zzev(zzp.zzkw().currentTimeMillis()).zzew(zzcqx.zzb(sQLiteDatabase, 2)).zzbfx());
        int size = zza.size();
        long j = 0;
        int i2 = 0;
        while (i2 < size) {
            zztw.zzo.zza zza2 = zza.get(i2);
            i2++;
            zztw.zzo.zza zza3 = zza2;
            if (zza3.zzoh() == zzug.ENUM_TRUE && zza3.getTimestamp() > j) {
                j = zza3.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
        this.zzgkx.zza(new zztn(zzo) { // from class: com.google.android.gms.internal.ads.zzcrc
            private final zztw.zzo zzgkz;

            {
                this.zzgkz = r1;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza4) {
                zza4.zza(this.zzgkz);
            }
        });
        zztw.zzu.zza zzcr = zztw.zzu.zzor().zzcq(this.zzdpq.zzedq).zzcr(this.zzdpq.zzedr);
        if (!this.zzdpq.zzeds) {
            i = 2;
        }
        this.zzgkx.zza(new zztn((zztw.zzu) ((zzegp) zzcr.zzcs(i).zzbfx())) { // from class: com.google.android.gms.internal.ads.zzcrb
            private final zztw.zzu zzgky;

            {
                this.zzgky = r1;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza4) {
                zza4.zza(((zztw.zzg.zza) zza4.zznw().zzbfk()).zza(this.zzgky));
            }
        });
        this.zzgkx.zza(zztq.zza.zzb.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
