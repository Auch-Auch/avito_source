package com.avito.android.serp.adapter;

import com.avito.android.ab_tests.PriceOnTop;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.SerpItemViewConfig;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "Lru/avito/component/serp/SerpItemViewConfig;", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/PriceOnTopTestGroup;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "priceOnTopTestGroup", "", "isPriceOnTop", "()Z", AuthSource.SEND_ABUSE, "Z", "isTextPrefetchEnabled", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "prefetchTestGroup", "<init>", "(Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpItemAbViewConfig implements SerpItemViewConfig {
    public final boolean a;
    public final ExposedAbTestGroup<PriceOnTopTestGroup> b;

    @Inject
    public SerpItemAbViewConfig(@PriceOnTop @NotNull ExposedAbTestGroup<PriceOnTopTestGroup> exposedAbTestGroup, @NotNull SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup) {
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "priceOnTopTestGroup");
        Intrinsics.checkNotNullParameter(serpItemsPrefetchTestGroup, "prefetchTestGroup");
        this.b = exposedAbTestGroup;
        this.a = serpItemsPrefetchTestGroup.isTest();
    }

    @Override // ru.avito.component.serp.SerpItemViewConfig
    @Nullable
    public GalleryRatio getGalleryRatio() {
        return SerpItemViewConfig.DefaultImpls.getGalleryRatio(this);
    }

    @Override // ru.avito.component.serp.SerpItemViewConfig
    public boolean isPriceOnTop() {
        return this.b.getTestGroup().isTest();
    }

    @Override // ru.avito.component.serp.SerpItemViewConfig
    public boolean isTextPrefetchEnabled() {
        return this.a;
    }
}
