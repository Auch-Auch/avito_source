package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
public final class zzhj implements zzhc {
    private int repeatMode;
    private final zzhx[] zzael;
    private final zzog zzaem;
    private final zzod zzaen;
    private final Handler zzaeo;
    private final zzhl zzaep;
    private final CopyOnWriteArraySet<zzhf> zzaeq;
    private final zzid zzaer;
    private final zzia zzaes;
    private boolean zzaet;
    private boolean zzaeu;
    private int zzaev;
    private int zzaew;
    private int zzaex;
    private boolean zzaey;
    private zzhy zzaez;
    private Object zzafa;
    private zznp zzafb;
    private zzod zzafc;
    private zzhu zzafd;
    private zzhn zzafe;
    private int zzaff;
    private int zzafg;
    private long zzafh;

    @SuppressLint({"HandlerLeak"})
    public zzhj(zzhx[] zzhxArr, zzog zzog, zzhs zzhs) {
        String.valueOf(zzpq.zzbki).length();
        zzoz.checkState(zzhxArr.length > 0);
        this.zzael = (zzhx[]) zzoz.checkNotNull(zzhxArr);
        this.zzaem = (zzog) zzoz.checkNotNull(zzog);
        this.zzaeu = false;
        this.repeatMode = 0;
        this.zzaev = 1;
        this.zzaeq = new CopyOnWriteArraySet<>();
        zzod zzod = new zzod(new zzob[zzhxArr.length]);
        this.zzaen = zzod;
        this.zzaez = zzhy.zzahz;
        this.zzaer = new zzid();
        this.zzaes = new zzia();
        this.zzafb = zznp.zzbgq;
        this.zzafc = zzod;
        this.zzafd = zzhu.zzahv;
        zzhi zzhi = new zzhi(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzaeo = zzhi;
        zzhn zzhn = new zzhn(0, 0);
        this.zzafe = zzhn;
        this.zzaep = new zzhl(zzhxArr, zzog, zzhs, this.zzaeu, 0, zzhi, zzhn, this);
    }

    private final int zzem() {
        if (this.zzaez.isEmpty() || this.zzaew > 0) {
            return this.zzaff;
        }
        this.zzaez.zza(this.zzafe.zzafn, this.zzaes, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final long getBufferedPosition() {
        if (this.zzaez.isEmpty() || this.zzaew > 0) {
            return this.zzafh;
        }
        this.zzaez.zza(this.zzafe.zzafn, this.zzaes, false);
        return zzha.zzdm(this.zzafe.zzags) + this.zzaes.zzff();
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final long getDuration() {
        if (this.zzaez.isEmpty()) {
            return C.TIME_UNSET;
        }
        return zzha.zzdm(this.zzaez.zza(zzem(), this.zzaer, false).zzaid);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final int getPlaybackState() {
        return this.zzaev;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void release() {
        this.zzaep.release();
        this.zzaeo.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void seekTo(long j) {
        long j2;
        int zzem = zzem();
        if (zzem < 0 || (!this.zzaez.isEmpty() && zzem >= this.zzaez.zzfd())) {
            throw new zzht(this.zzaez, zzem, j);
        }
        this.zzaew++;
        this.zzaff = zzem;
        if (!this.zzaez.isEmpty()) {
            this.zzaez.zza(zzem, this.zzaer, false);
            if (j == C.TIME_UNSET) {
                j2 = this.zzaer.zzais;
            } else {
                j2 = zzha.zzdn(j);
            }
            long j3 = this.zzaer.zzait + j2;
            long j4 = this.zzaez.zza(0, this.zzaes, false).zzaid;
            if (j4 != C.TIME_UNSET) {
                int i = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
            }
        }
        this.zzafg = 0;
        if (j == C.TIME_UNSET) {
            this.zzafh = 0;
            this.zzaep.zza(this.zzaez, zzem, C.TIME_UNSET);
            return;
        }
        this.zzafh = j;
        this.zzaep.zza(this.zzaez, zzem, zzha.zzdn(j));
        Iterator<zzhf> it = this.zzaeq.iterator();
        while (it.hasNext()) {
            it.next().zzel();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void stop() {
        this.zzaep.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zza(zzhf zzhf) {
        this.zzaeq.add(zzhf);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zzb(zzhf zzhf) {
        this.zzaeq.remove(zzhf);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final boolean zzei() {
        return this.zzaeu;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final int zzej() {
        return this.zzael.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final long zzek() {
        if (this.zzaez.isEmpty() || this.zzaew > 0) {
            return this.zzafh;
        }
        this.zzaez.zza(this.zzafe.zzafn, this.zzaes, false);
        return zzha.zzdm(this.zzafe.zzagr) + this.zzaes.zzff();
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zzf(boolean z) {
        if (this.zzaeu != z) {
            this.zzaeu = z;
            this.zzaep.zzf(z);
            Iterator<zzhf> it = this.zzaeq.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzaev);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zza(zzmz zzmz) {
        if (!this.zzaez.isEmpty() || this.zzafa != null) {
            this.zzaez = zzhy.zzahz;
            this.zzafa = null;
            Iterator<zzhf> it = this.zzaeq.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzaez, this.zzafa);
            }
        }
        if (this.zzaet) {
            this.zzaet = false;
            this.zzafb = zznp.zzbgq;
            this.zzafc = this.zzaen;
            this.zzaem.zzd(null);
            Iterator<zzhf> it2 = this.zzaeq.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzafb, this.zzafc);
            }
        }
        this.zzaex++;
        this.zzaep.zza(zzmz, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zzb(zzhh... zzhhArr) {
        this.zzaep.zzb(zzhhArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zza(zzhh... zzhhArr) {
        this.zzaep.zza(zzhhArr);
    }

    public final void zza(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzaex--;
                return;
            case 1:
                this.zzaev = message.arg1;
                Iterator<zzhf> it = this.zzaeq.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzaeu, this.zzaev);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzaey = z;
                Iterator<zzhf> it2 = this.zzaeq.iterator();
                while (it2.hasNext()) {
                    it2.next().zzg(this.zzaey);
                }
                return;
            case 3:
                if (this.zzaex == 0) {
                    zzoi zzoi = (zzoi) message.obj;
                    this.zzaet = true;
                    this.zzafb = zzoi.zzbhs;
                    this.zzafc = zzoi.zzbht;
                    this.zzaem.zzd(zzoi.zzbhu);
                    Iterator<zzhf> it3 = this.zzaeq.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzafb, this.zzafc);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzaew - 1;
                this.zzaew = i;
                if (i == 0) {
                    this.zzafe = (zzhn) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhf> it4 = this.zzaeq.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzel();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzaew == 0) {
                    this.zzafe = (zzhn) message.obj;
                    Iterator<zzhf> it5 = this.zzaeq.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzel();
                    }
                    return;
                }
                return;
            case 6:
                zzhp zzhp = (zzhp) message.obj;
                this.zzaew -= zzhp.zzahs;
                if (this.zzaex == 0) {
                    this.zzaez = zzhp.zzaez;
                    this.zzafa = zzhp.zzafa;
                    this.zzafe = zzhp.zzafe;
                    Iterator<zzhf> it6 = this.zzaeq.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzaez, this.zzafa);
                    }
                    return;
                }
                return;
            case 7:
                zzhu zzhu = (zzhu) message.obj;
                if (!this.zzafd.equals(zzhu)) {
                    this.zzafd = zzhu;
                    Iterator<zzhf> it7 = this.zzaeq.iterator();
                    while (it7.hasNext()) {
                        it7.next().zza(zzhu);
                    }
                    return;
                }
                return;
            case 8:
                zzhd zzhd = (zzhd) message.obj;
                Iterator<zzhf> it8 = this.zzaeq.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzhd);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
