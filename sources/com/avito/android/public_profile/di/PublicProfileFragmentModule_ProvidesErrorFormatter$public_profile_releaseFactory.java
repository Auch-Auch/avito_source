package com.avito.android.public_profile.di;

import android.content.res.Resources;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublicProfileFragmentModule_ProvidesErrorFormatter$public_profile_releaseFactory implements Factory<Formatter<Throwable>> {
    public final Provider<Resources> a;

    public PublicProfileFragmentModule_ProvidesErrorFormatter$public_profile_releaseFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static PublicProfileFragmentModule_ProvidesErrorFormatter$public_profile_releaseFactory create(Provider<Resources> provider) {
        return new PublicProfileFragmentModule_ProvidesErrorFormatter$public_profile_releaseFactory(provider);
    }

    public static Formatter<Throwable> providesErrorFormatter$public_profile_release(Resources resources) {
        return (Formatter) Preconditions.checkNotNullFromProvides(PublicProfileFragmentModule.providesErrorFormatter$public_profile_release(resources));
    }

    @Override // javax.inject.Provider
    public Formatter<Throwable> get() {
        return providesErrorFormatter$public_profile_release(this.a.get());
    }
}
