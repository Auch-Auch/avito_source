package com.avito.android.social_management.adapter.notification;

import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class NotificationItemPresenterImpl_Factory implements Factory<NotificationItemPresenterImpl> {
    public final Provider<Consumer<SocialNotificationAction>> a;

    public NotificationItemPresenterImpl_Factory(Provider<Consumer<SocialNotificationAction>> provider) {
        this.a = provider;
    }

    public static NotificationItemPresenterImpl_Factory create(Provider<Consumer<SocialNotificationAction>> provider) {
        return new NotificationItemPresenterImpl_Factory(provider);
    }

    public static NotificationItemPresenterImpl newInstance(Consumer<SocialNotificationAction> consumer) {
        return new NotificationItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public NotificationItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
