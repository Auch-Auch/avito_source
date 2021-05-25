package com.avito.android.notification_center.landing.recommends.review_list.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NcRecommendsReviewListModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public NcRecommendsReviewListModule_ProvideAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static NcRecommendsReviewListModule_ProvideAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new NcRecommendsReviewListModule_ProvideAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(NcRecommendsReviewListModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a.get());
    }
}
