package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zztw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
public final class zzto {
    private final zztt zzbvr;
    @GuardedBy("this")
    private final zztw.zzi.zza zzbvs;
    private final boolean zzbvt;

    public zzto(zztt zztt) {
        this.zzbvs = zztw.zzi.zznz();
        this.zzbvr = zztt;
        this.zzbvt = ((Boolean) zzwe.zzpu().zzd(zzaat.zzctk)).booleanValue();
    }

    private final synchronized void zzb(zztq.zza.zzb zzb) {
        this.zzbvs.zznv().zza(zzmz());
        this.zzbvr.zzf(((zztw.zzi) ((zzegp) this.zzbvs.zzbfx())).toByteArray()).zzby(zzb.zzv()).zzdv();
        String valueOf = String.valueOf(Integer.toString(zzb.zzv(), 10));
        zzaxy.zzei(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zztq.zza.zzb zzb) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(zzb).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzaxy.zzei("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzaxy.zzei("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzaxy.zzei("Could not close Clearcut output stream.");
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                        zzaxy.zzei("Could not close Clearcut output stream.");
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
                zzaxy.zzei("Could not find file for Clearcut");
            }
        }
    }

    private final synchronized String zzd(zztq.zza.zzb zzb) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzbvs.zznu(), Long.valueOf(zzp.zzkw().elapsedRealtime()), Integer.valueOf(zzb.zzv()), Base64.encodeToString(((zztw.zzi) ((zzegp) this.zzbvs.zzbfx())).toByteArray(), 3));
    }

    public static zzto zzmy() {
        return new zzto();
    }

    private static List<Long> zzmz() {
        List<String> zzre = zzaat.zzre();
        ArrayList arrayList = new ArrayList();
        for (String str : zzre) {
            for (String str2 : str.split(",")) {
                try {
                    arrayList.add(Long.valueOf(str2));
                } catch (NumberFormatException unused) {
                    zzaxy.zzei("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public final synchronized void zza(zztq.zza.zzb zzb) {
        if (this.zzbvt) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctl)).booleanValue()) {
                zzc(zzb);
            } else {
                zzb(zzb);
            }
        }
    }

    private zzto() {
        this.zzbvs = zztw.zzi.zznz();
        this.zzbvt = false;
        this.zzbvr = new zztt();
    }

    public final synchronized void zza(zztn zztn) {
        if (this.zzbvt) {
            try {
                zztn.zza(this.zzbvs);
            } catch (NullPointerException e) {
                zzp.zzkt().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }
}
