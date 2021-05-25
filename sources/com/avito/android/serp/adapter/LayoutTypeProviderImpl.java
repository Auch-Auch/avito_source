package com.avito.android.serp.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/adapter/LayoutTypeProviderImpl;", "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "Lcom/avito/android/serp/adapter/LayoutType;", "getLayoutType", "()Lcom/avito/android/serp/adapter/LayoutType;", "Lcom/avito/android/util/DeviceMetrics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Lcom/avito/android/util/DeviceMetrics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LayoutTypeProviderImpl implements LayoutTypeProvider {
    public final DeviceMetrics a;

    public LayoutTypeProviderImpl(@NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.a = deviceMetrics;
    }

    @Override // com.avito.android.serp.adapter.LayoutTypeProvider
    @NotNull
    public LayoutType getLayoutType() {
        int displayWidthDp = this.a.getDisplayWidthDp();
        if (displayWidthDp >= 960) {
            return LayoutType.WIDE;
        }
        if (displayWidthDp >= 640) {
            return LayoutType.MIDDLE;
        }
        return LayoutType.NARROW;
    }
}
