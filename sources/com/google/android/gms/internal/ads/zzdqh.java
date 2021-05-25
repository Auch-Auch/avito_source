package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
@VisibleForTesting
public final class zzdqh implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzeci;
    @VisibleForTesting
    private zzdrf zzhja;
    private final String zzhjb;
    private final LinkedBlockingQueue<zzcf.zza> zzhjc = new LinkedBlockingQueue<>();

    public zzdqh(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhjb = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zzeci = handlerThread;
        handlerThread.start();
        this.zzhja = new zzdrf(context, handlerThread.getLooper(), this, this, 9200000);
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
    private static zzcf.zza zzavf() {
        return (zzcf.zza) ((zzegp) zzcf.zza.zzaq().zzn(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbfx());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdrm zzave = zzave();
        if (zzave != null) {
            try {
                this.zzhjc.put(zzave.zza(new zzdri(this.packageName, this.zzhjb)).zzavu());
                zzapl();
                this.zzeci.quit();
            } catch (Throwable unused) {
                try {
                    this.zzhjc.put(zzavf());
                } catch (InterruptedException unused2) {
                } catch (Throwable th) {
                    zzapl();
                    this.zzeci.quit();
                    throw th;
                }
                zzapl();
                this.zzeci.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhjc.put(zzavf());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzhjc.put(zzavf());
        } catch (InterruptedException unused) {
        }
    }

    public final zzcf.zza zzee(int i) {
        zzcf.zza zza;
        try {
            zza = this.zzhjc.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? zzavf() : zza;
    }
}
