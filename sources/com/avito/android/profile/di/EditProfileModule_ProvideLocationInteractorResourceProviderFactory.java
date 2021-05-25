package com.avito.android.profile.di;

import android.content.Context;
import com.avito.android.profile.edit.LocationInteractorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideLocationInteractorResourceProviderFactory implements Factory<LocationInteractorResourceProvider> {
    public final Provider<Context> a;

    public EditProfileModule_ProvideLocationInteractorResourceProviderFactory(Provider<Context> provider) {
        this.a = provider;
    }

    public static EditProfileModule_ProvideLocationInteractorResourceProviderFactory create(Provider<Context> provider) {
        return new EditProfileModule_ProvideLocationInteractorResourceProviderFactory(provider);
    }

    public static LocationInteractorResourceProvider provideLocationInteractorResourceProvider(Context context) {
        return (LocationInteractorResourceProvider) Preconditions.checkNotNullFromProvides(EditProfileModule.provideLocationInteractorResourceProvider(context));
    }

    @Override // javax.inject.Provider
    public LocationInteractorResourceProvider get() {
        return provideLocationInteractorResourceProvider(this.a.get());
    }
}
