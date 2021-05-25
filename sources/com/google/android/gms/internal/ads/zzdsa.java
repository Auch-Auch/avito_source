package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;
public final class zzdsa {
    private static final HashMap<String, Class<?>> zzhld = new HashMap<>();
    private final zzdrz zzhkr;
    private final zzdpx zzhle;
    @Nullable
    private zzdro zzhlf;
    private final Object zzhlg = new Object();
    private final Context zzvr;
    private final zzdpy zzvw;

    public zzdsa(@NonNull Context context, @NonNull zzdrz zzdrz, @NonNull zzdpy zzdpy, @NonNull zzdpx zzdpx) {
        this.zzvr = context;
        this.zzhkr = zzdrz;
        this.zzvw = zzdpy;
        this.zzhle = zzdpx;
    }

    private final synchronized Class<?> zza(@NonNull zzdrn zzdrn) throws zzdrx {
        if (zzdrn.zzavw() != null) {
            String zzdg = zzdrn.zzavw().zzdg();
            HashMap<String, Class<?>> hashMap = zzhld;
            Class<?> cls = hashMap.get(zzdg);
            if (cls != null) {
                return cls;
            }
            try {
                if (this.zzhle.zzb(zzdrn.zzavx())) {
                    try {
                        File zzavy = zzdrn.zzavy();
                        if (!zzavy.exists()) {
                            zzavy.mkdirs();
                        }
                        Class loadClass = new DexClassLoader(zzdrn.zzavx().getAbsolutePath(), zzavy.getAbsolutePath(), null, this.zzvr.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                        hashMap.put(zzdg, loadClass);
                        return loadClass;
                    } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                        throw new zzdrx(2008, e);
                    }
                } else {
                    throw new zzdrx(2026, "VM did not pass signature verification");
                }
            } catch (GeneralSecurityException e2) {
                throw new zzdrx(2026, e2);
            }
        } else {
            throw new zzdrx(4010, "mc");
        }
    }

    @Nullable
    public final zzdqe zzawh() {
        zzdro zzdro;
        synchronized (this.zzhlg) {
            zzdro = this.zzhlf;
        }
        return zzdro;
    }

    @Nullable
    public final zzdrn zzawi() {
        synchronized (this.zzhlg) {
            zzdro zzdro = this.zzhlf;
            if (zzdro == null) {
                return null;
            }
            return zzdro.zzawa();
        }
    }

    public final void zzb(@NonNull zzdrn zzdrn) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzdro zzdro = new zzdro(zza(zza(zzdrn), zzdrn), zzdrn, this.zzhkr, this.zzvw);
            if (zzdro.zzawb()) {
                int zzawc = zzdro.zzawc();
                if (zzawc == 0) {
                    synchronized (this.zzhlg) {
                        zzdro zzdro2 = this.zzhlf;
                        if (zzdro2 != null) {
                            try {
                                zzdro2.close();
                            } catch (zzdrx e) {
                                this.zzvw.zza(e.zzawg(), -1, e);
                            }
                        }
                        this.zzhlf = zzdro;
                    }
                    this.zzvw.zzg(3000, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzawc);
                throw new zzdrx(4001, sb.toString());
            }
            throw new zzdrx(4000, "init failed");
        } catch (zzdrx e2) {
            this.zzvw.zza(e2.zzawg(), System.currentTimeMillis() - currentTimeMillis, e2);
        } catch (Exception e3) {
            this.zzvw.zza(4010, System.currentTimeMillis() - currentTimeMillis, e3);
        }
    }

    private final Object zza(@NonNull Class<?> cls, @NonNull zzdrn zzdrn) throws zzdrx {
        try {
            return cls.getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzvr, "msa-r", zzdrn.zzavz(), null, new Bundle(), 2);
        } catch (Exception e) {
            throw new zzdrx(2004, e);
        }
    }
}
