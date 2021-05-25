package com.avito.android.in_app_calls.task;

import com.avito.android.in_app_calls.MicAccessPermissionTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MicAccessTrackingTask_Factory implements Factory<MicAccessTrackingTask> {
    public final Provider<MicAccessPermissionTracker> a;

    public MicAccessTrackingTask_Factory(Provider<MicAccessPermissionTracker> provider) {
        this.a = provider;
    }

    public static MicAccessTrackingTask_Factory create(Provider<MicAccessPermissionTracker> provider) {
        return new MicAccessTrackingTask_Factory(provider);
    }

    public static MicAccessTrackingTask newInstance(MicAccessPermissionTracker micAccessPermissionTracker) {
        return new MicAccessTrackingTask(micAccessPermissionTracker);
    }

    @Override // javax.inject.Provider
    public MicAccessTrackingTask get() {
        return newInstance(this.a.get());
    }
}
