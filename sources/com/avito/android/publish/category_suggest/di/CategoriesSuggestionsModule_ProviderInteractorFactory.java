package com.avito.android.publish.category_suggest.di;

import com.avito.android.Features;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsInteractor;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CategoriesSuggestionsModule_ProviderInteractorFactory implements Factory<CategoriesSuggestionsInteractor> {
    public final CategoriesSuggestionsModule a;
    public final Provider<PublishApi> b;
    public final Provider<PublishAnalyticsDataProvider> c;
    public final Provider<CategoryParametersConverter> d;
    public final Provider<Features> e;

    public CategoriesSuggestionsModule_ProviderInteractorFactory(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<PublishApi> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<CategoryParametersConverter> provider3, Provider<Features> provider4) {
        this.a = categoriesSuggestionsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static CategoriesSuggestionsModule_ProviderInteractorFactory create(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<PublishApi> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<CategoryParametersConverter> provider3, Provider<Features> provider4) {
        return new CategoriesSuggestionsModule_ProviderInteractorFactory(categoriesSuggestionsModule, provider, provider2, provider3, provider4);
    }

    public static CategoriesSuggestionsInteractor providerInteractor(CategoriesSuggestionsModule categoriesSuggestionsModule, PublishApi publishApi, PublishAnalyticsDataProvider publishAnalyticsDataProvider, CategoryParametersConverter categoryParametersConverter, Features features) {
        return (CategoriesSuggestionsInteractor) Preconditions.checkNotNullFromProvides(categoriesSuggestionsModule.providerInteractor(publishApi, publishAnalyticsDataProvider, categoryParametersConverter, features));
    }

    @Override // javax.inject.Provider
    public CategoriesSuggestionsInteractor get() {
        return providerInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
