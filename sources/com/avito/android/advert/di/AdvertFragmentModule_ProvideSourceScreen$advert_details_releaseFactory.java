package com.avito.android.advert.di;

import com.avito.android.advert_core.contactbar.SourceScreen;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AdvertFragmentModule_ProvideSourceScreen$advert_details_releaseFactory implements Factory<SourceScreen> {

    public static final class a {
        public static final AdvertFragmentModule_ProvideSourceScreen$advert_details_releaseFactory a = new AdvertFragmentModule_ProvideSourceScreen$advert_details_releaseFactory();
    }

    public static AdvertFragmentModule_ProvideSourceScreen$advert_details_releaseFactory create() {
        return a.a;
    }

    public static SourceScreen provideSourceScreen$advert_details_release() {
        return (SourceScreen) Preconditions.checkNotNullFromProvides(AdvertFragmentModule.INSTANCE.provideSourceScreen$advert_details_release());
    }

    @Override // javax.inject.Provider
    public SourceScreen get() {
        return provideSourceScreen$advert_details_release();
    }
}
