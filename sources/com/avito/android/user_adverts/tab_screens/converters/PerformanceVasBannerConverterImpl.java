package com.avito.android.user_adverts.tab_screens.converters;

import a2.b.a.a.a;
import com.avito.android.remote.model.user_adverts.PerformanceVasBanner;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverter;", "Lcom/avito/android/remote/model/user_adverts/PerformanceVasBanner;", "banner", "Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItem;", "convert", "(Lcom/avito/android/remote/model/user_adverts/PerformanceVasBanner;)Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItem;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasBannerConverterImpl implements PerformanceVasBannerConverter {
    @Override // com.avito.android.user_adverts.tab_screens.converters.PerformanceVasBannerConverter
    @NotNull
    public PerformanceVasBannerItem convert(@NotNull PerformanceVasBanner performanceVasBanner) {
        Intrinsics.checkNotNullParameter(performanceVasBanner, "banner");
        return new PerformanceVasBannerItem(a.I2("UUID.randomUUID().toString()"), performanceVasBanner.getTitle(), performanceVasBanner.getIcon(), performanceVasBanner.getUri(), 0, 16, null);
    }
}
