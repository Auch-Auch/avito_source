package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
public class zzbxj {
    @Nullable
    private final zzdiw zzfpu;
    private final Set<zzbys<zzut>> zzftu;
    private final Set<zzbys<zzbsu>> zzftv;
    private final Set<zzbys<zzbtm>> zzftw;
    private final Set<zzbys<zzbuo>> zzftx;
    private final Set<zzbys<zzbuj>> zzfty;
    private final Set<zzbys<zzbsz>> zzftz;
    private final Set<zzbys<zzbti>> zzfua;
    private final Set<zzbys<AdMetadataListener>> zzfub;
    private final Set<zzbys<AppEventListener>> zzfuc;
    private final Set<zzbys<zzbuy>> zzfud;
    private zzbsx zzfue;
    private zzcud zzfuf;

    public static class zza {
        private zzdiw zzfpu;
        private Set<zzbys<zzut>> zzftu = new HashSet();
        private Set<zzbys<zzbsu>> zzftv = new HashSet();
        private Set<zzbys<zzbtm>> zzftw = new HashSet();
        private Set<zzbys<zzbuo>> zzftx = new HashSet();
        private Set<zzbys<zzbuj>> zzfty = new HashSet();
        private Set<zzbys<zzbsz>> zzftz = new HashSet();
        private Set<zzbys<zzbti>> zzfua = new HashSet();
        private Set<zzbys<AdMetadataListener>> zzfub = new HashSet();
        private Set<zzbys<AppEventListener>> zzfuc = new HashSet();
        private Set<zzbys<zzbuy>> zzfui = new HashSet();

        public final zza zza(zzbsu zzbsu, Executor executor) {
            this.zzftv.add(new zzbys<>(zzbsu, executor));
            return this;
        }

        public final zzbxj zzake() {
            return new zzbxj(this);
        }

        public final zza zza(zzbuj zzbuj, Executor executor) {
            this.zzfty.add(new zzbys<>(zzbuj, executor));
            return this;
        }

        public final zza zza(zzbsz zzbsz, Executor executor) {
            this.zzftz.add(new zzbys<>(zzbsz, executor));
            return this;
        }

        public final zza zza(zzbti zzbti, Executor executor) {
            this.zzfua.add(new zzbys<>(zzbti, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfub.add(new zzbys<>(adMetadataListener, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfuc.add(new zzbys<>(appEventListener, executor));
            return this;
        }

        public final zza zza(@Nullable zzxc zzxc, Executor executor) {
            if (this.zzfuc != null) {
                zzcxl zzcxl = new zzcxl();
                zzcxl.zzb(zzxc);
                this.zzfuc.add(new zzbys<>(zzcxl, executor));
            }
            return this;
        }

        public final zza zza(zzut zzut, Executor executor) {
            this.zzftu.add(new zzbys<>(zzut, executor));
            return this;
        }

        public final zza zza(zzbtm zzbtm, Executor executor) {
            this.zzftw.add(new zzbys<>(zzbtm, executor));
            return this;
        }

        public final zza zza(zzbuo zzbuo, Executor executor) {
            this.zzftx.add(new zzbys<>(zzbuo, executor));
            return this;
        }

        public final zza zza(zzbuy zzbuy, Executor executor) {
            this.zzfui.add(new zzbys<>(zzbuy, executor));
            return this;
        }

        public final zza zza(zzdiw zzdiw) {
            this.zzfpu = zzdiw;
            return this;
        }
    }

    private zzbxj(zza zza2) {
        this.zzftu = zza2.zzftu;
        this.zzftw = zza2.zzftw;
        this.zzftx = zza2.zzftx;
        this.zzftv = zza2.zzftv;
        this.zzfty = zza2.zzfty;
        this.zzftz = zza2.zzftz;
        this.zzfua = zza2.zzfua;
        this.zzfub = zza2.zzfub;
        this.zzfuc = zza2.zzfuc;
        this.zzfud = zza2.zzfui;
        this.zzfpu = zza2.zzfpu;
    }

    public final zzcud zza(Clock clock, zzcuf zzcuf) {
        if (this.zzfuf == null) {
            this.zzfuf = new zzcud(clock, zzcuf);
        }
        return this.zzfuf;
    }

    public final Set<zzbys<zzbsu>> zzajt() {
        return this.zzftv;
    }

    public final Set<zzbys<zzbuj>> zzaju() {
        return this.zzfty;
    }

    public final Set<zzbys<zzbsz>> zzajv() {
        return this.zzftz;
    }

    public final Set<zzbys<zzbti>> zzajw() {
        return this.zzfua;
    }

    public final Set<zzbys<AdMetadataListener>> zzajx() {
        return this.zzfub;
    }

    public final Set<zzbys<AppEventListener>> zzajy() {
        return this.zzfuc;
    }

    public final Set<zzbys<zzut>> zzajz() {
        return this.zzftu;
    }

    public final Set<zzbys<zzbtm>> zzaka() {
        return this.zzftw;
    }

    public final Set<zzbys<zzbuo>> zzakb() {
        return this.zzftx;
    }

    public final Set<zzbys<zzbuy>> zzakc() {
        return this.zzfud;
    }

    @Nullable
    public final zzdiw zzakd() {
        return this.zzfpu;
    }

    public final zzbsx zzc(Set<zzbys<zzbsz>> set) {
        if (this.zzfue == null) {
            this.zzfue = new zzbsx(set);
        }
        return this.zzfue;
    }
}
