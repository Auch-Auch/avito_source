package com.avito.android.short_term_rent.di.module;

import com.avito.android.conveyor_shared_item.notification.NotificationItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrConfirmBookingBlueprintsModule_ProvideNotificationItemPresenterFactory implements Factory<NotificationItemPresenter> {

    public static final class a {
        public static final StrConfirmBookingBlueprintsModule_ProvideNotificationItemPresenterFactory a = new StrConfirmBookingBlueprintsModule_ProvideNotificationItemPresenterFactory();
    }

    public static StrConfirmBookingBlueprintsModule_ProvideNotificationItemPresenterFactory create() {
        return a.a;
    }

    public static NotificationItemPresenter provideNotificationItemPresenter() {
        return (NotificationItemPresenter) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideNotificationItemPresenter());
    }

    @Override // javax.inject.Provider
    public NotificationItemPresenter get() {
        return provideNotificationItemPresenter();
    }
}
