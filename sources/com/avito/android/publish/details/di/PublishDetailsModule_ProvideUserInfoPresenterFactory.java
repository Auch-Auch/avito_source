package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.profile_info.item.UserInfoItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDetailsModule_ProvideUserInfoPresenterFactory implements Factory<UserInfoItemPresenter> {
    public final PublishDetailsModule a;

    public PublishDetailsModule_ProvideUserInfoPresenterFactory(PublishDetailsModule publishDetailsModule) {
        this.a = publishDetailsModule;
    }

    public static PublishDetailsModule_ProvideUserInfoPresenterFactory create(PublishDetailsModule publishDetailsModule) {
        return new PublishDetailsModule_ProvideUserInfoPresenterFactory(publishDetailsModule);
    }

    public static UserInfoItemPresenter provideUserInfoPresenter(PublishDetailsModule publishDetailsModule) {
        return (UserInfoItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideUserInfoPresenter());
    }

    @Override // javax.inject.Provider
    public UserInfoItemPresenter get() {
        return provideUserInfoPresenter(this.a);
    }
}
