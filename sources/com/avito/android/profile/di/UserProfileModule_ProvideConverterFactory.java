package com.avito.android.profile.di;

import com.avito.android.Features;
import com.avito.android.profile.UserProfileItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileModule_ProvideConverterFactory implements Factory<UserProfileItemConverter> {
    public final UserProfileModule a;
    public final Provider<Features> b;

    public UserProfileModule_ProvideConverterFactory(UserProfileModule userProfileModule, Provider<Features> provider) {
        this.a = userProfileModule;
        this.b = provider;
    }

    public static UserProfileModule_ProvideConverterFactory create(UserProfileModule userProfileModule, Provider<Features> provider) {
        return new UserProfileModule_ProvideConverterFactory(userProfileModule, provider);
    }

    public static UserProfileItemConverter provideConverter(UserProfileModule userProfileModule, Features features) {
        return (UserProfileItemConverter) Preconditions.checkNotNullFromProvides(userProfileModule.provideConverter(features));
    }

    @Override // javax.inject.Provider
    public UserProfileItemConverter get() {
        return provideConverter(this.a, this.b.get());
    }
}
