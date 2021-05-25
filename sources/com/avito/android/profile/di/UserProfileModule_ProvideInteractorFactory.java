package com.avito.android.profile.di;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.profile.UserProfileInteractor;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileModule_ProvideInteractorFactory implements Factory<UserProfileInteractor> {
    public final UserProfileModule a;
    public final Provider<ProfileApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<CodeConfirmationInteractor> d;

    public UserProfileModule_ProvideInteractorFactory(UserProfileModule userProfileModule, Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<CodeConfirmationInteractor> provider3) {
        this.a = userProfileModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static UserProfileModule_ProvideInteractorFactory create(UserProfileModule userProfileModule, Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<CodeConfirmationInteractor> provider3) {
        return new UserProfileModule_ProvideInteractorFactory(userProfileModule, provider, provider2, provider3);
    }

    public static UserProfileInteractor provideInteractor(UserProfileModule userProfileModule, ProfileApi profileApi, SchedulersFactory schedulersFactory, CodeConfirmationInteractor codeConfirmationInteractor) {
        return (UserProfileInteractor) Preconditions.checkNotNullFromProvides(userProfileModule.provideInteractor(profileApi, schedulersFactory, codeConfirmationInteractor));
    }

    @Override // javax.inject.Provider
    public UserProfileInteractor get() {
        return provideInteractor(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
