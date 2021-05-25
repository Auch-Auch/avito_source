package com.avito.android.section.item;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.SectionResourceProvider;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/section/item/SectionItemWidthProviderImpl;", "Lcom/avito/android/section/item/SectionItemWidthProvider;", "", "spanCount", "getWidthBySpanCount", "(I)I", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "getWidthByViewType", "(Lcom/avito/android/serp/adapter/SerpViewType;)I", "columnCount", "itemCrop", "padding", AuthSource.SEND_ABUSE, "(III)I", "h", "I", "itemWidth", g.a, "contentPadding", "c", "e", "fallbackItemWidth", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "d", "spaceBetweenItems", "f", "columnsOffset", AuthSource.BOOKING_ORDER, "columnsCount", "Lcom/avito/android/util/DeviceMetrics;", "i", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/section/SectionResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/section/SectionResourceProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionItemWidthProviderImpl implements SectionItemWidthProvider {
    public final BuildInfo a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final DeviceMetrics i;

    public SectionItemWidthProviderImpl(@NotNull DeviceMetrics deviceMetrics, @NotNull SectionResourceProvider sectionResourceProvider) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(sectionResourceProvider, "resourceProvider");
        this.i = deviceMetrics;
        this.a = deviceMetrics.getBuildInfo();
        int columnsCount = sectionResourceProvider.getColumnsCount();
        this.b = columnsCount;
        int paddingPx = sectionResourceProvider.getPaddingPx();
        this.c = paddingPx;
        int cropPx = sectionResourceProvider.getCropPx();
        this.d = cropPx;
        this.e = sectionResourceProvider.getDefaultItemWidthPx();
        this.f = sectionResourceProvider.getColumnsOffsetPx();
        this.g = sectionResourceProvider.getContentPaddingPx();
        this.h = a(columnsCount, cropPx - paddingPx, paddingPx);
    }

    public final int a(int i2, int i3, int i4) {
        int displayWidth = (this.i.getDisplayWidth() - (i4 * 2)) - i3;
        boolean z = true;
        boolean z2 = displayWidth > 0;
        if (i2 <= 0) {
            z = false;
        }
        if (z2 && z) {
            return displayWidth / i2;
        }
        if (!this.a.isDebug()) {
            return this.e;
        }
        throw new IllegalArgumentException("Item width must be a positive value");
    }

    @Override // com.avito.android.section.item.SectionItemWidthProvider
    public int getWidthBySpanCount(int i2) {
        if (i2 == 1) {
            return this.h;
        }
        if (i2 == 2) {
            return this.h * 2;
        }
        if (!this.a.isDebug()) {
            return this.h;
        }
        throw new IllegalArgumentException("provided span count is not supported");
    }

    @Override // com.avito.android.section.item.SectionItemWidthProvider
    public int getWidthByViewType(@NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        int i2 = this.b;
        if (serpViewType == SerpViewType.BIG) {
            i2 /= 2;
        }
        if (i2 <= 0) {
            i2 = 1;
        }
        return a(i2, (i2 - 1) * this.f, this.g);
    }
}
