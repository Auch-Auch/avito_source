package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;
import androidx.annotation.NonNull;
@TargetApi(23)
public final class zzqc implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzpx zzbmn;

    private zzqc(zzpx zzpx, MediaCodec mediaCodec) {
        this.zzbmn = zzpx;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
        zzpx zzpx = this.zzbmn;
        if (this == zzpx.zzbly) {
            zzpx.zzji();
        }
    }
}
