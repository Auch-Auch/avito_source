package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
public class zzbsg {
    private final zzdln zzfqn;
    private Bundle zzfsj;
    @Nullable
    private final String zzfsk;
    @Nullable
    private final zzdli zzfsl;
    private final Context zzvr;

    public static class zza {
        private zzdln zzfqn;
        private Bundle zzfsj;
        @Nullable
        private String zzfsk;
        @Nullable
        private zzdli zzfsl;
        private Context zzvr;

        public final zza zza(zzdln zzdln) {
            this.zzfqn = zzdln;
            return this;
        }

        public final zzbsg zzajj() {
            return new zzbsg(this);
        }

        public final zza zzcd(Context context) {
            this.zzvr = context;
            return this;
        }

        public final zza zzf(Bundle bundle) {
            this.zzfsj = bundle;
            return this;
        }

        public final zza zzfx(String str) {
            this.zzfsk = str;
            return this;
        }

        public final zza zza(zzdli zzdli) {
            this.zzfsl = zzdli;
            return this;
        }
    }

    private zzbsg(zza zza2) {
        this.zzvr = zza2.zzvr;
        this.zzfqn = zza2.zzfqn;
        this.zzfsj = zza2.zzfsj;
        this.zzfsk = zza2.zzfsk;
        this.zzfsl = zza2.zzfsl;
    }

    public final zza zzaje() {
        return new zza().zzcd(this.zzvr).zza(this.zzfqn).zzfx(this.zzfsk).zzf(this.zzfsj);
    }

    public final zzdln zzajf() {
        return this.zzfqn;
    }

    @Nullable
    public final zzdli zzajg() {
        return this.zzfsl;
    }

    @Nullable
    public final Bundle zzajh() {
        return this.zzfsj;
    }

    @Nullable
    public final String zzaji() {
        return this.zzfsk;
    }

    public final Context zzcc(Context context) {
        if (this.zzfsk != null) {
            return context;
        }
        return this.zzvr;
    }
}
