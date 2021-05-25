package com.avito.android.advert.item.dfpcreditinfo.di;

import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoBlueprint;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenterImpl;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditStorage;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditStorageImpl;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProviderImpl;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkBlueprint;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenter;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00162\u0006\u0010\u0015\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/di/AdvertDetailsCreditInfoModule;", "", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;", "bindAdvertDetailsCreditInfoPresenter", "(Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenterImpl;)Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenterImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter;", "bindCreditBrokerLinkPresenter", "(Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenterImpl;)Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorageImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;", "bindAdvertDetailsCreditStorage", "(Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorageImpl;)Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "bindAdvertDetailsCreditInfoResourcesProvider", "(Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProviderImpl;)Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideAdvertCreditInfoBlueprint", "(Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkBlueprint;", "provideCreditBrokerLinkBlueprint", "(Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertDetailsCreditInfoModule {
    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsCreditInfoPresenter bindAdvertDetailsCreditInfoPresenter(@NotNull AdvertDetailsCreditInfoPresenterImpl advertDetailsCreditInfoPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    CreditInfoResourcesProvider bindAdvertDetailsCreditInfoResourcesProvider(@NotNull CreditInfoResourcesProviderImpl creditInfoResourcesProviderImpl);

    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsCreditStorage bindAdvertDetailsCreditStorage(@NotNull AdvertDetailsCreditStorageImpl advertDetailsCreditStorageImpl);

    @PerFragment
    @Binds
    @NotNull
    CreditBrokerLinkPresenter bindCreditBrokerLinkPresenter(@NotNull CreditBrokerLinkPresenterImpl creditBrokerLinkPresenterImpl);

    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> provideAdvertCreditInfoBlueprint(@NotNull AdvertDetailsCreditInfoBlueprint advertDetailsCreditInfoBlueprint);

    @AdvertFragmentModule.AdvertBlueprints
    @Binds
    @IntoSet
    @NotNull
    @PerFragment
    ItemBlueprint<?, ?> provideCreditBrokerLinkBlueprint(@NotNull CreditBrokerLinkBlueprint creditBrokerLinkBlueprint);
}
