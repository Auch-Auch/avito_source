package com.avito.android.publish.category_suggest.di;

import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsInteractor;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CategoriesSuggestionsModule_ProviderViewModuleFactoryFactory implements Factory<CategoriesSuggestionsViewModelFactory> {
    public final CategoriesSuggestionsModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<CategoriesSuggestionsInteractor> c;
    public final Provider<PublishEventTracker> d;

    public CategoriesSuggestionsModule_ProviderViewModuleFactoryFactory(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<SchedulersFactory> provider, Provider<CategoriesSuggestionsInteractor> provider2, Provider<PublishEventTracker> provider3) {
        this.a = categoriesSuggestionsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static CategoriesSuggestionsModule_ProviderViewModuleFactoryFactory create(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<SchedulersFactory> provider, Provider<CategoriesSuggestionsInteractor> provider2, Provider<PublishEventTracker> provider3) {
        return new CategoriesSuggestionsModule_ProviderViewModuleFactoryFactory(categoriesSuggestionsModule, provider, provider2, provider3);
    }

    public static CategoriesSuggestionsViewModelFactory providerViewModuleFactory(CategoriesSuggestionsModule categoriesSuggestionsModule, SchedulersFactory schedulersFactory, CategoriesSuggestionsInteractor categoriesSuggestionsInteractor, PublishEventTracker publishEventTracker) {
        return (CategoriesSuggestionsViewModelFactory) Preconditions.checkNotNullFromProvides(categoriesSuggestionsModule.providerViewModuleFactory(schedulersFactory, categoriesSuggestionsInteractor, publishEventTracker));
    }

    @Override // javax.inject.Provider
    public CategoriesSuggestionsViewModelFactory get() {
        return providerViewModuleFactory(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
