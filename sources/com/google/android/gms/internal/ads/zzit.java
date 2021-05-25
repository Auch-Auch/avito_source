package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
@TargetApi(19)
public final class zzit extends zziq {
    private final AudioTimestamp zzalv = new AudioTimestamp();
    private long zzalw;
    private long zzalx;
    private long zzaly;

    public zzit() {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzalw = 0;
        this.zzalx = 0;
        this.zzaly = 0;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final boolean zzfy() {
        boolean timestamp = this.zzaju.getTimestamp(this.zzalv);
        if (timestamp) {
            long j = this.zzalv.framePosition;
            if (this.zzalx > j) {
                this.zzalw++;
            }
            this.zzalx = j;
            this.zzaly = j + (this.zzalw << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final long zzfz() {
        return this.zzalv.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final long zzga() {
        return this.zzaly;
    }
}
