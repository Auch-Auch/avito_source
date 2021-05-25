package com.avito.android.short_term_rent.di.module;

import com.avito.android.conveyor_shared_item.notification.NotificationItemBlueprint;
import com.avito.android.conveyor_shared_item.notification.NotificationItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingBlueprintsModule_ProvideNotificationItemBlueprintFactory implements Factory<NotificationItemBlueprint> {
    public final Provider<NotificationItemPresenter> a;

    public StrConfirmBookingBlueprintsModule_ProvideNotificationItemBlueprintFactory(Provider<NotificationItemPresenter> provider) {
        this.a = provider;
    }

    public static StrConfirmBookingBlueprintsModule_ProvideNotificationItemBlueprintFactory create(Provider<NotificationItemPresenter> provider) {
        return new StrConfirmBookingBlueprintsModule_ProvideNotificationItemBlueprintFactory(provider);
    }

    public static NotificationItemBlueprint provideNotificationItemBlueprint(NotificationItemPresenter notificationItemPresenter) {
        return (NotificationItemBlueprint) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideNotificationItemBlueprint(notificationItemPresenter));
    }

    @Override // javax.inject.Provider
    public NotificationItemBlueprint get() {
        return provideNotificationItemBlueprint(this.a.get());
    }
}
