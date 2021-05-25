package com.avito.android.search.map.di;

import com.avito.android.Features;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SearchMapModule_ProvideAvitoMapAttachHelperFactory implements Factory<AvitoMapAttachHelper> {
    public final Provider<Features> a;

    public SearchMapModule_ProvideAvitoMapAttachHelperFactory(Provider<Features> provider) {
        this.a = provider;
    }

    public static SearchMapModule_ProvideAvitoMapAttachHelperFactory create(Provider<Features> provider) {
        return new SearchMapModule_ProvideAvitoMapAttachHelperFactory(provider);
    }

    public static AvitoMapAttachHelper provideAvitoMapAttachHelper(Features features) {
        return (AvitoMapAttachHelper) Preconditions.checkNotNullFromProvides(SearchMapModule.provideAvitoMapAttachHelper(features));
    }

    @Override // javax.inject.Provider
    public AvitoMapAttachHelper get() {
        return provideAvitoMapAttachHelper(this.a.get());
    }
}
