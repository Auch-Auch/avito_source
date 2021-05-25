package com.avito.android.serp.adapter;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/adapter/SerpShortcutBannerWidthProvider;", "Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "", AuthSource.BOOKING_ORDER, "I", "getWidthPx", "()I", "widthPx", AuthSource.SEND_ABUSE, "calculatedWidth", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/util/BuildInfo;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpShortcutBannerWidthProvider implements ShortcutBannerWidthProvider {
    public final int a;
    public final int b;

    @Inject
    public SerpShortcutBannerWidthProvider(@NotNull Resources resources, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        int i = resources.getDisplayMetrics().widthPixels;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.serp_shortcut_banner_default_width);
        int dimensionPixelOffset2 = (((i - (resources.getDimensionPixelOffset(R.dimen.serp_horizontal_padding) * 2)) / resources.getInteger(R.integer.serp_columns)) * 2) - resources.getDimensionPixelOffset(R.dimen.serp_shortcut_banner_padding);
        if (dimensionPixelOffset2 > 0) {
            dimensionPixelOffset = dimensionPixelOffset2;
        } else if (buildInfo.isDebug()) {
            throw new IllegalArgumentException("shortcut banner width cant be a negative value");
        }
        this.a = dimensionPixelOffset;
        this.b = dimensionPixelOffset;
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerWidthProvider
    public int getWidthPx() {
        return this.b;
    }
}
