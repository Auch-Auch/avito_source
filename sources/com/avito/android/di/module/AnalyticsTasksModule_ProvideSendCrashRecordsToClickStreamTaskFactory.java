package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.crashlytics.CrashRecorder;
import com.avito.android.app.task.SendCrashRecordsToClickStreamTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideSendCrashRecordsToClickStreamTaskFactory implements Factory<SendCrashRecordsToClickStreamTask> {
    public final Provider<CrashRecorder> a;
    public final Provider<Analytics> b;

    public AnalyticsTasksModule_ProvideSendCrashRecordsToClickStreamTaskFactory(Provider<CrashRecorder> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AnalyticsTasksModule_ProvideSendCrashRecordsToClickStreamTaskFactory create(Provider<CrashRecorder> provider, Provider<Analytics> provider2) {
        return new AnalyticsTasksModule_ProvideSendCrashRecordsToClickStreamTaskFactory(provider, provider2);
    }

    public static SendCrashRecordsToClickStreamTask provideSendCrashRecordsToClickStreamTask(CrashRecorder crashRecorder, Analytics analytics) {
        return (SendCrashRecordsToClickStreamTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideSendCrashRecordsToClickStreamTask(crashRecorder, analytics));
    }

    @Override // javax.inject.Provider
    public SendCrashRecordsToClickStreamTask get() {
        return provideSendCrashRecordsToClickStreamTask(this.a.get(), this.b.get());
    }
}
