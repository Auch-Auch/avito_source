package com.avito.android.advert.item.safedeal.di;

import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonBlueprint;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonPresenter;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonPresenterImpl;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonBlueprint;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonPresenter;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonPresenterImpl;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoBlueprint;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoPresenter;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoPresenterImpl;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelBlueprint;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelPresenter;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelPresenterImpl;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesBlueprint;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenter;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenterImpl;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsBlueprint;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsPresenter;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001c\u001a\u00020 H'¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001c\u001a\u00020#H'¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001c\u001a\u00020&H'¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001c\u001a\u00020)H'¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001c\u001a\u00020,H'¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/avito/android/advert/item/safedeal/di/AdvertDetailsSafeDealModule;", "", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonPresenter;", "bindAdvertDetailsSafeDealLegacyButtonPresenter", "(Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonPresenterImpl;)Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonPresenter;", "Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonPresenter;", "bindAdvertDetailsSafeDealButtonPresenter", "(Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonPresenterImpl;)Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonPresenter;", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoPresenter;", "bindAdvertDetailsSafeDealInfoPresenter", "(Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoPresenterImpl;)Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoPresenter;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelPresenter;", "bindAdvertDetailsSafeDealLabelPresenter", "(Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelPresenterImpl;)Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelPresenter;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsPresenter;", "bindAdvertDetailsSafeDealTrustFactorsPresenter", "(Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsPresenterImpl;)Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsPresenter;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;", "bindAdvertDetailsSafeDealServicesPresenter", "(Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenterImpl;)Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindAdvertDetailsSafeDealLegacyButtonBlueprint", "(Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonBlueprint;", "bindAdvertDetailsSafeDealButtonBlueprint", "(Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoBlueprint;", "bindAdvertDetailsSafeDealInfoBlueprint", "(Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelBlueprint;", "bindAdvertDetailsSafeDealLabelBlueprint", "(Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsBlueprint;", "bindAdvertDetailsSafeDealTrustFactorsBlueprint", "(Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesBlueprint;", "bindAdvertDetailsSafeDealServicesBlueprint", "(Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertDetailsSafeDealModule {
    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindAdvertDetailsSafeDealButtonBlueprint(@NotNull AdvertDetailsSafeDealButtonBlueprint advertDetailsSafeDealButtonBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsSafeDealButtonPresenter bindAdvertDetailsSafeDealButtonPresenter(@NotNull AdvertDetailsSafeDealButtonPresenterImpl advertDetailsSafeDealButtonPresenterImpl);

    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindAdvertDetailsSafeDealInfoBlueprint(@NotNull AdvertDetailsSafeDealInfoBlueprint advertDetailsSafeDealInfoBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsSafeDealInfoPresenter bindAdvertDetailsSafeDealInfoPresenter(@NotNull AdvertDetailsSafeDealInfoPresenterImpl advertDetailsSafeDealInfoPresenterImpl);

    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindAdvertDetailsSafeDealLabelBlueprint(@NotNull AdvertDetailsSafeDealLabelBlueprint advertDetailsSafeDealLabelBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsSafeDealLabelPresenter bindAdvertDetailsSafeDealLabelPresenter(@NotNull AdvertDetailsSafeDealLabelPresenterImpl advertDetailsSafeDealLabelPresenterImpl);

    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindAdvertDetailsSafeDealLegacyButtonBlueprint(@NotNull AdvertDetailsSafeDealLegacyButtonBlueprint advertDetailsSafeDealLegacyButtonBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsSafeDealLegacyButtonPresenter bindAdvertDetailsSafeDealLegacyButtonPresenter(@NotNull AdvertDetailsSafeDealLegacyButtonPresenterImpl advertDetailsSafeDealLegacyButtonPresenterImpl);

    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindAdvertDetailsSafeDealServicesBlueprint(@NotNull AdvertDetailsSafeDealServicesBlueprint advertDetailsSafeDealServicesBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsSafeDealServicesPresenter bindAdvertDetailsSafeDealServicesPresenter(@NotNull AdvertDetailsSafeDealServicesPresenterImpl advertDetailsSafeDealServicesPresenterImpl);

    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> bindAdvertDetailsSafeDealTrustFactorsBlueprint(@NotNull AdvertDetailsSafeDealTrustFactorsBlueprint advertDetailsSafeDealTrustFactorsBlueprint);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsSafeDealTrustFactorsPresenter bindAdvertDetailsSafeDealTrustFactorsPresenter(@NotNull AdvertDetailsSafeDealTrustFactorsPresenterImpl advertDetailsSafeDealTrustFactorsPresenterImpl);
}
