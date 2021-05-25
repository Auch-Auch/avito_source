package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;
public final class zzdrv {
    private static final Object zzhkx = new Object();
    private final SharedPreferences zzcld;
    private final String zzhkw;
    private final Context zzvr;

    public zzdrv(@NonNull Context context, @NonNull zzgo zzgo) {
        this.zzvr = context;
        this.zzhkw = Integer.toString(zzgo.zzv());
        this.zzcld = context.getSharedPreferences("pcvmspf", 0);
    }

    private final String zzawe() {
        String valueOf = String.valueOf(this.zzhkw);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    private final String zzawf() {
        String valueOf = String.valueOf(this.zzhkw);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    private static String zzb(@NonNull zzgq zzgq) {
        return Hex.bytesToStringLowercase(((zzgr) ((zzegp) zzgr.zzdl().zzaw(zzgq.zzdc().zzdg()).zzax(zzgq.zzdc().zzdh()).zzdk(zzgq.zzdc().zzdj()).zzdl(zzgq.zzdc().zzdk()).zzdj(zzgq.zzdc().zzdi()).zzbfx())).zzbda().toByteArray());
    }

    private final zzgr zzei(int i) {
        String str;
        if (i == zzdry.zzhkz) {
            str = this.zzcld.getString(zzawf(), null);
        } else {
            str = i == zzdry.zzhla ? this.zzcld.getString(zzawe(), null) : null;
        }
        if (str == null) {
            return null;
        }
        try {
            return zzgr.zzb(zzeff.zzu(Hex.stringToBytes(str)), zzegc.zzbey());
        } catch (zzegz unused) {
            return null;
        }
    }

    private final File zzhg(@NonNull String str) {
        return new File(new File(this.zzvr.getDir("pccache", 0), this.zzhkw), str);
    }

    public final boolean zza(@NonNull zzgq zzgq, @Nullable zzdrw zzdrw) {
        synchronized (zzhkx) {
            int i = zzdry.zzhkz;
            zzgr zzei = zzei(i);
            String zzdg = zzgq.zzdc().zzdg();
            if (zzei != null && zzei.zzdg().equals(zzdg)) {
                return false;
            }
            if (!zzhg(zzdg).mkdirs()) {
                return false;
            }
            File zzhg = zzhg(zzdg);
            File file = new File(zzhg, "pcam");
            File file2 = new File(zzhg, "pcbc");
            if (!zzdrp.zza(file, zzgq.zzdd().toByteArray())) {
                return false;
            }
            if (!zzdrp.zza(file2, zzgq.zzde().toByteArray())) {
                return false;
            }
            if (zzdrw == null || zzdrw.zzb(file)) {
                String zzb = zzb(zzgq);
                String string = this.zzcld.getString(zzawf(), null);
                SharedPreferences.Editor edit = this.zzcld.edit();
                edit.putString(zzawf(), zzb);
                if (string != null) {
                    edit.putString(zzawe(), string);
                }
                if (!edit.commit()) {
                    return false;
                }
                HashSet hashSet = new HashSet();
                zzgr zzei2 = zzei(i);
                if (zzei2 != null) {
                    hashSet.add(zzei2.zzdg());
                }
                zzgr zzei3 = zzei(zzdry.zzhla);
                if (zzei3 != null) {
                    hashSet.add(zzei3.zzdg());
                }
                File[] listFiles = new File(this.zzvr.getDir("pccache", 0), this.zzhkw).listFiles();
                for (File file3 : listFiles) {
                    if (!hashSet.contains(file3.getName())) {
                        zzdrp.zze(file3);
                    }
                }
                return true;
            }
            zzdrp.zze(zzhg);
            return false;
        }
    }

    @Nullable
    public final zzdrn zzp(int i) {
        synchronized (zzhkx) {
            zzgr zzei = zzei(i);
            if (zzei == null) {
                return null;
            }
            File zzhg = zzhg(zzei.zzdg());
            return new zzdrn(zzei, new File(zzhg, "pcam"), new File(zzhg, "pcbc"), new File(zzhg, "pcopt"));
        }
    }

    public final boolean zza(@NonNull zzgq zzgq) {
        synchronized (zzhkx) {
            if (!zzdrp.zza(new File(zzhg(zzgq.zzdc().zzdg()), "pcbc"), zzgq.zzde().toByteArray())) {
                return false;
            }
            String zzb = zzb(zzgq);
            SharedPreferences.Editor edit = this.zzcld.edit();
            edit.putString(zzawf(), zzb);
            return edit.commit();
        }
    }
}
