package com.avito.android.di.module;

import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.InitTimberLoggerTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class ApplicationDelegateOptionalModule_ProvideDebugTasks$avito_release_releaseFactory implements Factory<List<ApplicationBlockingStartupTask>> {
    public final ApplicationDelegateOptionalModule a;
    public final Provider<InitTimberLoggerTask> b;

    public ApplicationDelegateOptionalModule_ProvideDebugTasks$avito_release_releaseFactory(ApplicationDelegateOptionalModule applicationDelegateOptionalModule, Provider<InitTimberLoggerTask> provider) {
        this.a = applicationDelegateOptionalModule;
        this.b = provider;
    }

    public static ApplicationDelegateOptionalModule_ProvideDebugTasks$avito_release_releaseFactory create(ApplicationDelegateOptionalModule applicationDelegateOptionalModule, Provider<InitTimberLoggerTask> provider) {
        return new ApplicationDelegateOptionalModule_ProvideDebugTasks$avito_release_releaseFactory(applicationDelegateOptionalModule, provider);
    }

    public static List<ApplicationBlockingStartupTask> provideDebugTasks$avito_release_release(ApplicationDelegateOptionalModule applicationDelegateOptionalModule, InitTimberLoggerTask initTimberLoggerTask) {
        return (List) Preconditions.checkNotNullFromProvides(applicationDelegateOptionalModule.provideDebugTasks$avito_release_release(initTimberLoggerTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationBlockingStartupTask> get() {
        return provideDebugTasks$avito_release_release(this.a, this.b.get());
    }
}
