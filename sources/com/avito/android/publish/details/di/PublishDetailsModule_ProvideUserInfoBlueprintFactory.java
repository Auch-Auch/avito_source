package com.avito.android.publish.details.di;

import com.avito.android.component.profile_snippet.AvatarRenderer;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemBlueprint;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideUserInfoBlueprintFactory implements Factory<UserInfoItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<UserInfoItemPresenter> b;
    public final Provider<AvatarRenderer> c;

    public PublishDetailsModule_ProvideUserInfoBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<UserInfoItemPresenter> provider, Provider<AvatarRenderer> provider2) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishDetailsModule_ProvideUserInfoBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<UserInfoItemPresenter> provider, Provider<AvatarRenderer> provider2) {
        return new PublishDetailsModule_ProvideUserInfoBlueprintFactory(publishDetailsModule, provider, provider2);
    }

    public static UserInfoItemBlueprint provideUserInfoBlueprint(PublishDetailsModule publishDetailsModule, UserInfoItemPresenter userInfoItemPresenter, AvatarRenderer avatarRenderer) {
        return (UserInfoItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideUserInfoBlueprint(userInfoItemPresenter, avatarRenderer));
    }

    @Override // javax.inject.Provider
    public UserInfoItemBlueprint get() {
        return provideUserInfoBlueprint(this.a, this.b.get(), this.c.get());
    }
}
