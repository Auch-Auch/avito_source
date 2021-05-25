package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
public class zzbih {
    private final Context zzaai;
    private final zzbbg zzbop;
    private final WeakReference<Context> zzerl;

    public static class zza {
        private Context zzaai;
        private zzbbg zzbop;
        private WeakReference<Context> zzerl;

        public final zza zza(zzbbg zzbbg) {
            this.zzbop = zzbbg;
            return this;
        }

        public final zza zzbw(Context context) {
            this.zzerl = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaai = context;
            return this;
        }
    }

    private zzbih(zza zza2) {
        this.zzbop = zza2.zzbop;
        this.zzaai = zza2.zzaai;
        this.zzerl = zza2.zzerl;
    }

    public final Context zzade() {
        return this.zzaai;
    }

    public final WeakReference<Context> zzadf() {
        return this.zzerl;
    }

    public final zzbbg zzadg() {
        return this.zzbop;
    }

    public final String zzadh() {
        return zzp.zzkp().zzs(this.zzaai, this.zzbop.zzbra);
    }

    public final zzeg zzadi() {
        return new zzeg(new zzf(this.zzaai, this.zzbop));
    }
}
