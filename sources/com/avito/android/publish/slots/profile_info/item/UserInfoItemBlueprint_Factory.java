package com.avito.android.publish.slots.profile_info.item;

import com.avito.android.component.profile_snippet.AvatarRenderer;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserInfoItemBlueprint_Factory implements Factory<UserInfoItemBlueprint> {
    public final Provider<UserInfoItemPresenter> a;
    public final Provider<AvatarRenderer> b;

    public UserInfoItemBlueprint_Factory(Provider<UserInfoItemPresenter> provider, Provider<AvatarRenderer> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserInfoItemBlueprint_Factory create(Provider<UserInfoItemPresenter> provider, Provider<AvatarRenderer> provider2) {
        return new UserInfoItemBlueprint_Factory(provider, provider2);
    }

    public static UserInfoItemBlueprint newInstance(UserInfoItemPresenter userInfoItemPresenter, AvatarRenderer avatarRenderer) {
        return new UserInfoItemBlueprint(userInfoItemPresenter, avatarRenderer);
    }

    @Override // javax.inject.Provider
    public UserInfoItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
