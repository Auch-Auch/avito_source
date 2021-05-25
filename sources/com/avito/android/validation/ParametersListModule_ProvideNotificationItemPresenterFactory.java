package com.avito.android.validation;

import com.avito.android.conveyor_shared_item.notification.NotificationItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ParametersListModule_ProvideNotificationItemPresenterFactory implements Factory<NotificationItemPresenter> {
    public final ParametersListModule a;

    public ParametersListModule_ProvideNotificationItemPresenterFactory(ParametersListModule parametersListModule) {
        this.a = parametersListModule;
    }

    public static ParametersListModule_ProvideNotificationItemPresenterFactory create(ParametersListModule parametersListModule) {
        return new ParametersListModule_ProvideNotificationItemPresenterFactory(parametersListModule);
    }

    public static NotificationItemPresenter provideNotificationItemPresenter(ParametersListModule parametersListModule) {
        return (NotificationItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideNotificationItemPresenter());
    }

    @Override // javax.inject.Provider
    public NotificationItemPresenter get() {
        return provideNotificationItemPresenter(this.a);
    }
}
