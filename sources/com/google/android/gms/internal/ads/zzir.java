package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
public final class zzir extends Thread {
    private final /* synthetic */ AudioTrack zzalt;
    private final /* synthetic */ zzio zzalu;

    public zzir(zzio zzio, AudioTrack audioTrack) {
        this.zzalu = zzio;
        this.zzalt = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.zzalt.flush();
            this.zzalt.release();
        } finally {
            zzio.zza(this.zzalu).open();
        }
    }
}
