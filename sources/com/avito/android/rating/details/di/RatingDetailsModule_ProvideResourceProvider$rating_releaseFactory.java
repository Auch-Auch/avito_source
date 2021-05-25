package com.avito.android.rating.details.di;

import android.content.res.Resources;
import com.avito.android.rating.details.RatingDetailsResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class RatingDetailsModule_ProvideResourceProvider$rating_releaseFactory implements Factory<RatingDetailsResourceProvider> {
    public final Provider<Resources> a;
    public final Provider<String> b;
    public final Provider<String> c;

    public RatingDetailsModule_ProvideResourceProvider$rating_releaseFactory(Provider<Resources> provider, Provider<String> provider2, Provider<String> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static RatingDetailsModule_ProvideResourceProvider$rating_releaseFactory create(Provider<Resources> provider, Provider<String> provider2, Provider<String> provider3) {
        return new RatingDetailsModule_ProvideResourceProvider$rating_releaseFactory(provider, provider2, provider3);
    }

    public static RatingDetailsResourceProvider provideResourceProvider$rating_release(Resources resources, String str, String str2) {
        return (RatingDetailsResourceProvider) Preconditions.checkNotNullFromProvides(RatingDetailsModule.provideResourceProvider$rating_release(resources, str, str2));
    }

    @Override // javax.inject.Provider
    public RatingDetailsResourceProvider get() {
        return provideResourceProvider$rating_release(this.a.get(), this.b.get(), this.c.get());
    }
}
