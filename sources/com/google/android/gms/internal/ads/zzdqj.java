package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
@VisibleForTesting
public final class zzdqj implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final long startTime;
    private final HandlerThread zzeci;
    @VisibleForTesting
    private zzdrf zzhja;
    private final LinkedBlockingQueue<zzdru> zzhjc;
    private final String zzhjd;
    private final String zzhje;
    private final int zzhjf = 1;
    private final zzdpy zzvw;
    private final zzgo zzvy;

    public zzdqj(Context context, int i, zzgo zzgo, String str, String str2, String str3, zzdpy zzdpy) {
        this.zzhjd = str;
        this.zzvy = zzgo;
        this.zzhje = str2;
        this.zzvw = zzdpy;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzeci = handlerThread;
        handlerThread.start();
        this.startTime = System.currentTimeMillis();
        this.zzhja = new zzdrf(context, handlerThread.getLooper(), this, this, 19621000);
        this.zzhjc = new LinkedBlockingQueue<>();
        this.zzhja.checkAvailabilityAndConnect();
    }

    private final void zzapl() {
        zzdrf zzdrf = this.zzhja;
        if (zzdrf == null) {
            return;
        }
        if (zzdrf.isConnected() || this.zzhja.isConnecting()) {
            this.zzhja.disconnect();
        }
    }

    private final zzdrm zzave() {
        try {
            return this.zzhja.zzavt();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static zzdru zzavg() {
        return new zzdru(null, 1);
    }

    private final void zzb(int i, long j, Exception exc) {
        zzdpy zzdpy = this.zzvw;
        if (zzdpy != null) {
            zzdpy.zza(i, System.currentTimeMillis() - j, exc);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdrm zzave = zzave();
        if (zzave != null) {
            try {
                zzdru zza = zzave.zza(new zzdrs(this.zzhjf, this.zzvy, this.zzhjd, this.zzhje));
                zzb(5011, this.startTime, null);
                this.zzhjc.put(zza);
            } catch (Throwable th) {
                zzb(2010, this.startTime, new Exception(th));
            } finally {
                zzapl();
                this.zzeci.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzb(4012, this.startTime, null);
            this.zzhjc.put(zzavg());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            zzb(4011, this.startTime, null);
            this.zzhjc.put(zzavg());
        } catch (InterruptedException unused) {
        }
    }

    public final zzdru zzef(int i) {
        zzdru zzdru;
        try {
            zzdru = this.zzhjc.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzb(2009, this.startTime, e);
            zzdru = null;
        }
        zzb(3004, this.startTime, null);
        if (zzdru != null) {
            if (zzdru.status == 7) {
                zzdpy.zzb(zzbw.zza.zzc.DISABLED);
            } else {
                zzdpy.zzb(zzbw.zza.zzc.ENABLED);
            }
        }
        return zzdru == null ? zzavg() : zzdru;
    }
}
