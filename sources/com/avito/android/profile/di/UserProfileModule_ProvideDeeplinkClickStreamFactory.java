package com.avito.android.profile.di;

import com.avito.android.deep_linking.links.DeepLink;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserProfileModule_ProvideDeeplinkClickStreamFactory implements Factory<PublishRelay<DeepLink>> {
    public final UserProfileModule a;

    public UserProfileModule_ProvideDeeplinkClickStreamFactory(UserProfileModule userProfileModule) {
        this.a = userProfileModule;
    }

    public static UserProfileModule_ProvideDeeplinkClickStreamFactory create(UserProfileModule userProfileModule) {
        return new UserProfileModule_ProvideDeeplinkClickStreamFactory(userProfileModule);
    }

    public static PublishRelay<DeepLink> provideDeeplinkClickStream(UserProfileModule userProfileModule) {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(userProfileModule.provideDeeplinkClickStream());
    }

    @Override // javax.inject.Provider
    public PublishRelay<DeepLink> get() {
        return provideDeeplinkClickStream(this.a);
    }
}
