package com.avito.android.connection_quality;

import android.os.Build;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.network.connectionclass.DeviceBandwidthSampler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/connection_quality/BandwidthSamplerImpl;", "Lcom/avito/android/connection_quality/BandwidthSampler;", "", "startSampling", "()V", "stopSampling", "Lcom/facebook/network/connectionclass/DeviceBandwidthSampler;", AuthSource.SEND_ABUSE, "Lcom/facebook/network/connectionclass/DeviceBandwidthSampler;", "sampler", "<init>", "(Lcom/facebook/network/connectionclass/DeviceBandwidthSampler;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public final class BandwidthSamplerImpl implements BandwidthSampler {
    public final DeviceBandwidthSampler a;

    public BandwidthSamplerImpl(@NotNull DeviceBandwidthSampler deviceBandwidthSampler) {
        Intrinsics.checkNotNullParameter(deviceBandwidthSampler, "sampler");
        this.a = deviceBandwidthSampler;
    }

    @Override // com.avito.android.connection_quality.BandwidthSampler
    public void startSampling() {
        if (Build.VERSION.SDK_INT < 28) {
            this.a.startSampling();
        }
    }

    @Override // com.avito.android.connection_quality.BandwidthSampler
    public void stopSampling() {
        if (Build.VERSION.SDK_INT < 28) {
            this.a.stopSampling();
        }
    }
}
