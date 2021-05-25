package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
public final class zzayz {
    private float zzdqm = 1.0f;
    private boolean zzdqs = false;

    public static float zzbh(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }

    private final synchronized boolean zzya() {
        return this.zzdqm >= 0.0f;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdqs = z;
    }

    public final synchronized void setAppVolume(float f) {
        this.zzdqm = f;
    }

    public final synchronized float zzqd() {
        if (!zzya()) {
            return 1.0f;
        }
        return this.zzdqm;
    }

    public final synchronized boolean zzqe() {
        return this.zzdqs;
    }
}
