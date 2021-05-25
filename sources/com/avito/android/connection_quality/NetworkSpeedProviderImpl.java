package com.avito.android.connection_quality;

import com.facebook.network.connectionclass.ConnectionClassManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/connection_quality/NetworkSpeedProviderImpl;", "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "", "networkSpeed", "()Ljava/lang/Double;", "<init>", "()V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public final class NetworkSpeedProviderImpl implements NetworkSpeedProvider {
    @Override // com.avito.android.connection_quality.NetworkSpeedProvider
    @Nullable
    public Double networkSpeed() {
        ConnectionClassManager instance = ConnectionClassManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "ConnectionClassManager.getInstance()");
        Double valueOf = Double.valueOf(instance.getDownloadKBitsPerSecond());
        boolean z = false;
        if (valueOf.doubleValue() > ((double) 0)) {
            z = true;
        }
        if (z) {
            return valueOf;
        }
        return null;
    }
}
