package com.avito.android.profile.di;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.profile.UserProfilePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileModule_ProvideDeepLinkClickListenerFactory implements Factory<OnDeepLinkClickListener> {
    public final UserProfileModule a;
    public final Provider<UserProfilePresenter> b;

    public UserProfileModule_ProvideDeepLinkClickListenerFactory(UserProfileModule userProfileModule, Provider<UserProfilePresenter> provider) {
        this.a = userProfileModule;
        this.b = provider;
    }

    public static UserProfileModule_ProvideDeepLinkClickListenerFactory create(UserProfileModule userProfileModule, Provider<UserProfilePresenter> provider) {
        return new UserProfileModule_ProvideDeepLinkClickListenerFactory(userProfileModule, provider);
    }

    public static OnDeepLinkClickListener provideDeepLinkClickListener(UserProfileModule userProfileModule, UserProfilePresenter userProfilePresenter) {
        return (OnDeepLinkClickListener) Preconditions.checkNotNullFromProvides(userProfileModule.provideDeepLinkClickListener(userProfilePresenter));
    }

    @Override // javax.inject.Provider
    public OnDeepLinkClickListener get() {
        return provideDeepLinkClickListener(this.a, this.b.get());
    }
}
