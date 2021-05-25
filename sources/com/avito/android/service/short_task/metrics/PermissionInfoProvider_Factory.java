package com.avito.android.service.short_task.metrics;

import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.PermissionChecker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PermissionInfoProvider_Factory implements Factory<PermissionInfoProvider> {
    public final Provider<PermissionChecker> a;
    public final Provider<NotificationManagerProvider> b;

    public PermissionInfoProvider_Factory(Provider<PermissionChecker> provider, Provider<NotificationManagerProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PermissionInfoProvider_Factory create(Provider<PermissionChecker> provider, Provider<NotificationManagerProvider> provider2) {
        return new PermissionInfoProvider_Factory(provider, provider2);
    }

    public static PermissionInfoProvider newInstance(PermissionChecker permissionChecker, NotificationManagerProvider notificationManagerProvider) {
        return new PermissionInfoProvider(permissionChecker, notificationManagerProvider);
    }

    @Override // javax.inject.Provider
    public PermissionInfoProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
