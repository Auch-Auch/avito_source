package com.avito.android.validation;

import com.avito.android.conveyor_shared_item.notification.NotificationItemBlueprint;
import com.avito.android.conveyor_shared_item.notification.NotificationItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideNotificationItemBlueprintFactory implements Factory<NotificationItemBlueprint> {
    public final ParametersListModule a;
    public final Provider<NotificationItemPresenter> b;

    public ParametersListModule_ProvideNotificationItemBlueprintFactory(ParametersListModule parametersListModule, Provider<NotificationItemPresenter> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideNotificationItemBlueprintFactory create(ParametersListModule parametersListModule, Provider<NotificationItemPresenter> provider) {
        return new ParametersListModule_ProvideNotificationItemBlueprintFactory(parametersListModule, provider);
    }

    public static NotificationItemBlueprint provideNotificationItemBlueprint(ParametersListModule parametersListModule, NotificationItemPresenter notificationItemPresenter) {
        return (NotificationItemBlueprint) Preconditions.checkNotNullFromProvides(parametersListModule.provideNotificationItemBlueprint(notificationItemPresenter));
    }

    @Override // javax.inject.Provider
    public NotificationItemBlueprint get() {
        return provideNotificationItemBlueprint(this.a, this.b.get());
    }
}
