package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
public final class zzbgk extends zzyj {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private boolean zzads;
    @GuardedBy("lock")
    private boolean zzadt;
    @GuardedBy("lock")
    private int zzaev;
    @GuardedBy("lock")
    private zzyl zzdkl;
    private final zzbde zzefm;
    private final boolean zzeoz;
    private final boolean zzepa;
    @GuardedBy("lock")
    private boolean zzepb;
    @GuardedBy("lock")
    private boolean zzepc = true;
    @GuardedBy("lock")
    private float zzepd;
    @GuardedBy("lock")
    private float zzepe;
    @GuardedBy("lock")
    private float zzepf;
    @GuardedBy("lock")
    private zzafi zzepg;

    public zzbgk(zzbde zzbde, float f, boolean z, boolean z2) {
        this.zzefm = zzbde;
        this.zzepd = f;
        this.zzeoz = z;
        this.zzepa = z2;
    }

    private final void zzf(String str, @Nullable Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbbi.zzedy.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.zzbgn
            private final Map zzedp;
            private final zzbgk zzeph;

            {
                this.zzeph = r1;
                this.zzedp = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeph.zzk(this.zzedp);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzepf;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float getCurrentTime() {
        float f;
        synchronized (this.lock) {
            f = this.zzepe;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float getDuration() {
        float f;
        synchronized (this.lock) {
            f = this.zzepd;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzaev;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.zzadt && this.zzepa) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeoz && this.zzads;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzepc;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void mute(boolean z) {
        zzf(z ? Tracker.Events.CREATIVE_MUTE : Tracker.Events.CREATIVE_UNMUTE, null);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void pause() {
        zzf(Tracker.Events.CREATIVE_PAUSE, null);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void play() {
        zzf("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void stop() {
        zzf("stop", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzyl zzyl) {
        synchronized (this.lock) {
            this.zzdkl = zzyl;
        }
    }

    public final void zzacs() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzepc;
            i = this.zzaev;
            this.zzaev = 3;
        }
        zza(i, 3, z, z);
    }

    public final void zzb(zzaac zzaac) {
        boolean z = zzaac.zzadr;
        boolean z2 = zzaac.zzads;
        boolean z3 = zzaac.zzadt;
        synchronized (this.lock) {
            this.zzads = z2;
            this.zzadt = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzepe = f;
        }
    }

    public final /* synthetic */ void zzk(Map map) {
        this.zzefm.zza("pubVideoCmd", map);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final zzyl zzqj() throws RemoteException {
        zzyl zzyl;
        synchronized (this.lock) {
            zzyl = this.zzdkl;
        }
        return zzyl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            float r1 = r3.zzepd     // Catch:{ all -> 0x004d }
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0012
            float r1 = r3.zzepf     // Catch:{ all -> 0x004d }
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            r3.zzepd = r5     // Catch:{ all -> 0x004d }
            r3.zzepe = r4     // Catch:{ all -> 0x004d }
            boolean r4 = r3.zzepc     // Catch:{ all -> 0x004d }
            r3.zzepc = r7     // Catch:{ all -> 0x004d }
            int r5 = r3.zzaev     // Catch:{ all -> 0x004d }
            r3.zzaev = r6     // Catch:{ all -> 0x004d }
            float r2 = r3.zzepf     // Catch:{ all -> 0x004d }
            r3.zzepf = r8     // Catch:{ all -> 0x004d }
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x004d }
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbde r8 = r3.zzefm     // Catch:{ all -> 0x004d }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x004d }
            r8.invalidate()     // Catch:{ all -> 0x004d }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzafi r8 = r3.zzepg     // Catch:{ RemoteException -> 0x0043 }
            if (r8 == 0) goto L_0x0049
            r8.zzsq()     // Catch:{ RemoteException -> 0x0043 }
            goto L_0x0049
        L_0x0043:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbbd.zze(r0, r8)
        L_0x0049:
            r3.zza(r5, r6, r4, r7)
            return
        L_0x004d:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgk.zza(float, float, int, boolean, float):void");
    }

    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        zzyl zzyl;
        zzyl zzyl2;
        zzyl zzyl3;
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = this.zzepb;
            boolean z7 = !z5 && i2 == 1;
            boolean z8 = z4 && i2 == 1;
            boolean z9 = z4 && i2 == 2;
            boolean z10 = z4 && i2 == 3;
            boolean z11 = z != z2;
            if (z5 || z7) {
                z3 = true;
            }
            this.zzepb = z3;
            if (z7) {
                try {
                    zzyl zzyl4 = this.zzdkl;
                    if (zzyl4 != null) {
                        zzyl4.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
            if (z8 && (zzyl3 = this.zzdkl) != null) {
                zzyl3.onVideoPlay();
            }
            if (z9 && (zzyl2 = this.zzdkl) != null) {
                zzyl2.onVideoPause();
            }
            if (z10) {
                zzyl zzyl5 = this.zzdkl;
                if (zzyl5 != null) {
                    zzyl5.onVideoEnd();
                }
                this.zzefm.zzzw();
            }
            if (z11 && (zzyl = this.zzdkl) != null) {
                zzyl.onVideoMute(z2);
            }
        }
    }

    public final void zza(zzafi zzafi) {
        synchronized (this.lock) {
            this.zzepg = zzafi;
        }
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzbbi.zzedy.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.zzbgm
            private final int zzeax;
            private final int zzeay;
            private final boolean zzemt;
            private final boolean zzemu;
            private final zzbgk zzeph;

            {
                this.zzeph = r1;
                this.zzeax = r2;
                this.zzeay = r3;
                this.zzemt = r4;
                this.zzemu = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeph.zzb(this.zzeax, this.zzeay, this.zzemt, this.zzemu);
            }
        });
    }
}
