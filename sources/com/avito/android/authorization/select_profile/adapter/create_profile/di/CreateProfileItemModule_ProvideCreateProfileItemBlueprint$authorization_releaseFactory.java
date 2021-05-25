package com.avito.android.authorization.select_profile.adapter.create_profile.di;

import com.avito.android.authorization.select_profile.adapter.create_profile.CreateProfileItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CreateProfileItemModule_ProvideCreateProfileItemBlueprint$authorization_releaseFactory implements Factory<ItemBlueprint<?, ?>> {
    public final CreateProfileItemModule a;
    public final Provider<CreateProfileItemPresenter> b;

    public CreateProfileItemModule_ProvideCreateProfileItemBlueprint$authorization_releaseFactory(CreateProfileItemModule createProfileItemModule, Provider<CreateProfileItemPresenter> provider) {
        this.a = createProfileItemModule;
        this.b = provider;
    }

    public static CreateProfileItemModule_ProvideCreateProfileItemBlueprint$authorization_releaseFactory create(CreateProfileItemModule createProfileItemModule, Provider<CreateProfileItemPresenter> provider) {
        return new CreateProfileItemModule_ProvideCreateProfileItemBlueprint$authorization_releaseFactory(createProfileItemModule, provider);
    }

    public static ItemBlueprint<?, ?> provideCreateProfileItemBlueprint$authorization_release(CreateProfileItemModule createProfileItemModule, CreateProfileItemPresenter createProfileItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(createProfileItemModule.provideCreateProfileItemBlueprint$authorization_release(createProfileItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideCreateProfileItemBlueprint$authorization_release(this.a, this.b.get());
    }
}
