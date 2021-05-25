package com.avito.android.advert.item.features_teaser.di;

import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert_details.R;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerFragment;
import com.avito.android.serp.adapter.promo_card.PromoCardBlueprint;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/features_teaser/di/PromoCardModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "getPresenter$advert_details_release", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "getPresenter", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "getBlueprint", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PromoCardModule {
    @NotNull
    public static final PromoCardModule INSTANCE = new PromoCardModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PromoCardItemPresenter getPresenter$advert_details_release(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new PromoCardItemPresenter(null, analytics);
    }

    @Provides
    @AdvertFragmentModule.AdvertBlueprints
    @IntoSet
    @NotNull
    @PerFragment
    public final ItemBlueprint<?, ?> getBlueprint(@NotNull PromoCardItemPresenter promoCardItemPresenter) {
        Intrinsics.checkNotNullParameter(promoCardItemPresenter, "presenter");
        return new PromoCardBlueprint(promoCardItemPresenter, R.id.advert_details_report_banner_title, null, Integer.valueOf(R.id.advert_details_report_banner_subtitle), Integer.valueOf(R.id.advert_details_report_banner_button), R.layout.advert_details_report_banner, 4, null);
    }
}
