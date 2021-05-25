package com.avito.android.app.task;

import com.avito.android.geo.GeoPositionModel;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RegisterGeoPositionCheckingCallbacksTask_Factory implements Factory<RegisterGeoPositionCheckingCallbacksTask> {
    public final Provider<SchedulersFactory> a;
    public final Provider<PermissionChecker> b;
    public final Provider<GeoPositionModel> c;

    public RegisterGeoPositionCheckingCallbacksTask_Factory(Provider<SchedulersFactory> provider, Provider<PermissionChecker> provider2, Provider<GeoPositionModel> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static RegisterGeoPositionCheckingCallbacksTask_Factory create(Provider<SchedulersFactory> provider, Provider<PermissionChecker> provider2, Provider<GeoPositionModel> provider3) {
        return new RegisterGeoPositionCheckingCallbacksTask_Factory(provider, provider2, provider3);
    }

    public static RegisterGeoPositionCheckingCallbacksTask newInstance(SchedulersFactory schedulersFactory, PermissionChecker permissionChecker, GeoPositionModel geoPositionModel) {
        return new RegisterGeoPositionCheckingCallbacksTask(schedulersFactory, permissionChecker, geoPositionModel);
    }

    @Override // javax.inject.Provider
    public RegisterGeoPositionCheckingCallbacksTask get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
