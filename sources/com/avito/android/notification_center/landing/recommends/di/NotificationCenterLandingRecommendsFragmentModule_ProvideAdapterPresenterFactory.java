package com.avito.android.notification_center.landing.recommends.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsFragmentModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public NotificationCenterLandingRecommendsFragmentModule_ProvideAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static NotificationCenterLandingRecommendsFragmentModule_ProvideAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new NotificationCenterLandingRecommendsFragmentModule_ProvideAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(NotificationCenterLandingRecommendsFragmentModule.INSTANCE.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a.get());
    }
}
