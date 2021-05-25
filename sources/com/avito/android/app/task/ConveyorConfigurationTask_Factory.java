package com.avito.android.app.task;

import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ConveyorConfigurationTask_Factory implements Factory<ConveyorConfigurationTask> {
    public final Provider<BuildInfo> a;

    public ConveyorConfigurationTask_Factory(Provider<BuildInfo> provider) {
        this.a = provider;
    }

    public static ConveyorConfigurationTask_Factory create(Provider<BuildInfo> provider) {
        return new ConveyorConfigurationTask_Factory(provider);
    }

    public static ConveyorConfigurationTask newInstance(BuildInfo buildInfo) {
        return new ConveyorConfigurationTask(buildInfo);
    }

    @Override // javax.inject.Provider
    public ConveyorConfigurationTask get() {
        return newInstance(this.a.get());
    }
}
