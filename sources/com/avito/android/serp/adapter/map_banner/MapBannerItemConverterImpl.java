package com.avito.android.serp.adapter.map_banner;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.map_banner.MapBanner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverterImpl;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverter;", "Lcom/avito/android/remote/model/map_banner/MapBanner;", "entity", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItem;", "convert", "(Lcom/avito/android/remote/model/map_banner/MapBanner;)Lcom/avito/android/serp/adapter/map_banner/MapBannerItem;", "", AuthSource.SEND_ABUSE, "I", "columnCount", "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MapBannerItemConverterImpl implements MapBannerItemConverter {
    public final int a;

    public MapBannerItemConverterImpl(int i) {
        this.a = i;
    }

    @Override // com.avito.android.serp.adapter.map_banner.MapBannerItemConverter
    @NotNull
    public MapBannerItem convert(@NotNull MapBanner mapBanner) {
        Intrinsics.checkNotNullParameter(mapBanner, "entity");
        return new MapBannerItem(this.a, null, mapBanner.getButtonText(), mapBanner.getLightMapScreenUri(), mapBanner.getDarkMapScreenUri(), mapBanner.getDeepLink(), 2, null);
    }
}
