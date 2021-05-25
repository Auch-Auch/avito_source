package com.avito.android.social_management.di;

import com.avito.android.social_management.adapter.SocialItem;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SocialManagementModule_ProvideClicksStream$social_network_editor_releaseFactory implements Factory<PublishRelay<SocialItem>> {

    public static final class a {
        public static final SocialManagementModule_ProvideClicksStream$social_network_editor_releaseFactory a = new SocialManagementModule_ProvideClicksStream$social_network_editor_releaseFactory();
    }

    public static SocialManagementModule_ProvideClicksStream$social_network_editor_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<SocialItem> provideClicksStream$social_network_editor_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(SocialManagementModule.provideClicksStream$social_network_editor_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<SocialItem> get() {
        return provideClicksStream$social_network_editor_release();
    }
}
