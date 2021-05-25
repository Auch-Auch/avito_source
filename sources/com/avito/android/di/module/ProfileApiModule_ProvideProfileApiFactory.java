package com.avito.android.di.module;

import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ProfileApiModule_ProvideProfileApiFactory implements Factory<ProfileApi> {
    public final Provider<RetrofitFactory> a;

    public ProfileApiModule_ProvideProfileApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ProfileApiModule_ProvideProfileApiFactory create(Provider<RetrofitFactory> provider) {
        return new ProfileApiModule_ProvideProfileApiFactory(provider);
    }

    public static ProfileApi provideProfileApi(RetrofitFactory retrofitFactory) {
        return (ProfileApi) Preconditions.checkNotNullFromProvides(ProfileApiModule.INSTANCE.provideProfileApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ProfileApi get() {
        return provideProfileApi(this.a.get());
    }
}
