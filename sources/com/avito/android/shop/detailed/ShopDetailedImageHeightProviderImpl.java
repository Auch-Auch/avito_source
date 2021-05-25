package com.avito.android.shop.detailed;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProviderImpl;", "Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProvider;", "", "provideImageHeightPx", "()I", AuthSource.SEND_ABUSE, "I", "getGap", "gap", "Lcom/avito/android/util/DeviceMetrics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Landroid/content/res/Resources;", "resources", "<init>", "(Lcom/avito/android/util/DeviceMetrics;Landroid/content/res/Resources;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedImageHeightProviderImpl implements ShopDetailedImageHeightProvider {
    public final int a;
    public final DeviceMetrics b;

    @Inject
    public ShopDetailedImageHeightProviderImpl(@NotNull DeviceMetrics deviceMetrics, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = deviceMetrics;
        this.a = resources.getDimensionPixelSize(R.dimen.shop_min_height_gap);
    }

    public final int getGap() {
        return this.a;
    }

    @Override // com.avito.android.shop.detailed.ShopDetailedImageHeightProvider
    public int provideImageHeightPx() {
        int displayWidth = this.b.getDisplayWidth() / 2;
        return this.b.getDisplayHeight() - displayWidth > this.a ? displayWidth : this.b.getDisplayHeight() - this.a;
    }
}
