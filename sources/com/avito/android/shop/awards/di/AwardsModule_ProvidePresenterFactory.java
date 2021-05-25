package com.avito.android.shop.awards.di;

import com.avito.android.shop.awards.AwardsInteractor;
import com.avito.android.shop.awards.AwardsPresenter;
import com.avito.android.shop.awards.AwardsResourceProvider;
import com.avito.android.shop.awards.ShopAwardsItemsConverter;
import com.avito.android.shop.awards.item.action.ActionClickProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AwardsModule_ProvidePresenterFactory implements Factory<AwardsPresenter> {
    public final Provider<AwardsInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<AwardsResourceProvider> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<ShopAwardsItemsConverter> e;
    public final Provider<ActionClickProvider> f;
    public final Provider<Kundle> g;

    public AwardsModule_ProvidePresenterFactory(Provider<AwardsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AwardsResourceProvider> provider3, Provider<AdapterPresenter> provider4, Provider<ShopAwardsItemsConverter> provider5, Provider<ActionClickProvider> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static AwardsModule_ProvidePresenterFactory create(Provider<AwardsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AwardsResourceProvider> provider3, Provider<AdapterPresenter> provider4, Provider<ShopAwardsItemsConverter> provider5, Provider<ActionClickProvider> provider6, Provider<Kundle> provider7) {
        return new AwardsModule_ProvidePresenterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AwardsPresenter providePresenter(AwardsInteractor awardsInteractor, SchedulersFactory3 schedulersFactory3, AwardsResourceProvider awardsResourceProvider, AdapterPresenter adapterPresenter, ShopAwardsItemsConverter shopAwardsItemsConverter, ActionClickProvider actionClickProvider, Kundle kundle) {
        return (AwardsPresenter) Preconditions.checkNotNullFromProvides(AwardsModule.providePresenter(awardsInteractor, schedulersFactory3, awardsResourceProvider, adapterPresenter, shopAwardsItemsConverter, actionClickProvider, kundle));
    }

    @Override // javax.inject.Provider
    public AwardsPresenter get() {
        return providePresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
