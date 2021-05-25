package com.avito.android.social_management.adapter.notification;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationItemBlueprint_Factory implements Factory<NotificationItemBlueprint> {
    public final Provider<NotificationItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public NotificationItemBlueprint_Factory(Provider<NotificationItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationItemBlueprint_Factory create(Provider<NotificationItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new NotificationItemBlueprint_Factory(provider, provider2);
    }

    public static NotificationItemBlueprint newInstance(NotificationItemPresenter notificationItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new NotificationItemBlueprint(notificationItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public NotificationItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
