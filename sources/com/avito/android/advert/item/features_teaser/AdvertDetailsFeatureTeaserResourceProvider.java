package com.avito.android.advert.item.features_teaser;

import android.content.res.Resources;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/features_teaser/AdvertDetailsFeatureTeaserResourceProvider;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "", "isTablet", "()Z", "isLandscape", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", AuthSource.BOOKING_ORDER, "Z", "<init>", "(Landroid/content/res/Resources;Z)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserResourceProvider implements FeatureTeaserResourceProvider {
    public final Resources a;
    public final boolean b;

    @Inject
    public AdvertDetailsFeatureTeaserResourceProvider(@NotNull Resources resources, @AdvertFragmentModule.IsTablet boolean z) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
        this.b = z;
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider
    public boolean isLandscape() {
        return this.a.getConfiguration().orientation == 2;
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider
    public boolean isTablet() {
        return this.b;
    }
}
