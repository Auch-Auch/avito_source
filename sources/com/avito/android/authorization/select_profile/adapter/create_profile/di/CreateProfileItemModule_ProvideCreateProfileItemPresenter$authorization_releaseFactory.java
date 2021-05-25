package com.avito.android.authorization.select_profile.adapter.create_profile.di;

import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.authorization.select_profile.adapter.create_profile.CreateProfileItemPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CreateProfileItemModule_ProvideCreateProfileItemPresenter$authorization_releaseFactory implements Factory<CreateProfileItemPresenter> {
    public final CreateProfileItemModule a;
    public final Provider<PublishRelay<SelectProfileField>> b;

    public CreateProfileItemModule_ProvideCreateProfileItemPresenter$authorization_releaseFactory(CreateProfileItemModule createProfileItemModule, Provider<PublishRelay<SelectProfileField>> provider) {
        this.a = createProfileItemModule;
        this.b = provider;
    }

    public static CreateProfileItemModule_ProvideCreateProfileItemPresenter$authorization_releaseFactory create(CreateProfileItemModule createProfileItemModule, Provider<PublishRelay<SelectProfileField>> provider) {
        return new CreateProfileItemModule_ProvideCreateProfileItemPresenter$authorization_releaseFactory(createProfileItemModule, provider);
    }

    public static CreateProfileItemPresenter provideCreateProfileItemPresenter$authorization_release(CreateProfileItemModule createProfileItemModule, PublishRelay<SelectProfileField> publishRelay) {
        return (CreateProfileItemPresenter) Preconditions.checkNotNullFromProvides(createProfileItemModule.provideCreateProfileItemPresenter$authorization_release(publishRelay));
    }

    @Override // javax.inject.Provider
    public CreateProfileItemPresenter get() {
        return provideCreateProfileItemPresenter$authorization_release(this.a, this.b.get());
    }
}
