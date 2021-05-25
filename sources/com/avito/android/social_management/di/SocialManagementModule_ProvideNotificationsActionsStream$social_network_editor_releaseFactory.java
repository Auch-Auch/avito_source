package com.avito.android.social_management.di;

import com.avito.android.social_management.adapter.notification.SocialNotificationAction;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SocialManagementModule_ProvideNotificationsActionsStream$social_network_editor_releaseFactory implements Factory<PublishRelay<SocialNotificationAction>> {

    public static final class a {
        public static final SocialManagementModule_ProvideNotificationsActionsStream$social_network_editor_releaseFactory a = new SocialManagementModule_ProvideNotificationsActionsStream$social_network_editor_releaseFactory();
    }

    public static SocialManagementModule_ProvideNotificationsActionsStream$social_network_editor_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<SocialNotificationAction> provideNotificationsActionsStream$social_network_editor_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(SocialManagementModule.provideNotificationsActionsStream$social_network_editor_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<SocialNotificationAction> get() {
        return provideNotificationsActionsStream$social_network_editor_release();
    }
}
