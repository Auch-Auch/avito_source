package com.avito.android.service.short_task.metrics;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SendMetricTask_MembersInjector implements MembersInjector<SendMetricTask> {
    public final Provider<SendMetricsTaskDelegate> a;

    public SendMetricTask_MembersInjector(Provider<SendMetricsTaskDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<SendMetricTask> create(Provider<SendMetricsTaskDelegate> provider) {
        return new SendMetricTask_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.metrics.SendMetricTask.delegate")
    public static void injectDelegate(SendMetricTask sendMetricTask, SendMetricsTaskDelegate sendMetricsTaskDelegate) {
        sendMetricTask.delegate = sendMetricsTaskDelegate;
    }

    public void injectMembers(SendMetricTask sendMetricTask) {
        injectDelegate(sendMetricTask, this.a.get());
    }
}
