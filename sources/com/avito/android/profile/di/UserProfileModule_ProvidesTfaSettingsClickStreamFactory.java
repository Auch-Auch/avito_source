package com.avito.android.profile.di;

import com.avito.android.profile.cards.CardItem;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserProfileModule_ProvidesTfaSettingsClickStreamFactory implements Factory<PublishRelay<CardItem.TfaSettingsCardItem>> {
    public final UserProfileModule a;

    public UserProfileModule_ProvidesTfaSettingsClickStreamFactory(UserProfileModule userProfileModule) {
        this.a = userProfileModule;
    }

    public static UserProfileModule_ProvidesTfaSettingsClickStreamFactory create(UserProfileModule userProfileModule) {
        return new UserProfileModule_ProvidesTfaSettingsClickStreamFactory(userProfileModule);
    }

    public static PublishRelay<CardItem.TfaSettingsCardItem> providesTfaSettingsClickStream(UserProfileModule userProfileModule) {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(userProfileModule.providesTfaSettingsClickStream());
    }

    @Override // javax.inject.Provider
    public PublishRelay<CardItem.TfaSettingsCardItem> get() {
        return providesTfaSettingsClickStream(this.a);
    }
}
