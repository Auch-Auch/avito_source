package com.avito.android.di.module;

import com.avito.android.service.short_task.metrics.SendMetricTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SendMetricsModule_ProvideSendMetricTaskFactory implements Factory<SendMetricTask> {

    public static final class a {
        public static final SendMetricsModule_ProvideSendMetricTaskFactory a = new SendMetricsModule_ProvideSendMetricTaskFactory();
    }

    public static SendMetricsModule_ProvideSendMetricTaskFactory create() {
        return a.a;
    }

    public static SendMetricTask provideSendMetricTask() {
        return (SendMetricTask) Preconditions.checkNotNullFromProvides(SendMetricsModule.INSTANCE.provideSendMetricTask());
    }

    @Override // javax.inject.Provider
    public SendMetricTask get() {
        return provideSendMetricTask();
    }
}
