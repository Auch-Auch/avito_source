package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
public final class zzcdi {
    public zzaex zzfyk;
    public zzaew zzfyl;
    public zzafl zzfym;
    public zzafk zzfyn;
    public zzaiz zzfyo;
    public final SimpleArrayMap<String, zzafd> zzfyp = new SimpleArrayMap<>();
    public final SimpleArrayMap<String, zzafc> zzfyq = new SimpleArrayMap<>();

    public final zzcdi zza(zzafk zzafk) {
        this.zzfyn = zzafk;
        return this;
    }

    public final zzcdg zzamk() {
        return new zzcdg(this);
    }

    public final zzcdi zzb(zzaex zzaex) {
        this.zzfyk = zzaex;
        return this;
    }

    public final zzcdi zzb(zzaew zzaew) {
        this.zzfyl = zzaew;
        return this;
    }

    public final zzcdi zzb(zzafl zzafl) {
        this.zzfym = zzafl;
        return this;
    }

    public final zzcdi zzb(zzaiz zzaiz) {
        this.zzfyo = zzaiz;
        return this;
    }

    public final zzcdi zzb(String str, zzafd zzafd, zzafc zzafc) {
        this.zzfyp.put(str, zzafd);
        this.zzfyq.put(str, zzafc);
        return this;
    }
}
