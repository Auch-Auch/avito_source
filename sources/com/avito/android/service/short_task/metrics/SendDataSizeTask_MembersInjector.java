package com.avito.android.service.short_task.metrics;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SendDataSizeTask_MembersInjector implements MembersInjector<SendDataSizeTask> {
    public final Provider<SendDataSizeTaskDelegate> a;

    public SendDataSizeTask_MembersInjector(Provider<SendDataSizeTaskDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<SendDataSizeTask> create(Provider<SendDataSizeTaskDelegate> provider) {
        return new SendDataSizeTask_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.metrics.SendDataSizeTask.delegate")
    public static void injectDelegate(SendDataSizeTask sendDataSizeTask, SendDataSizeTaskDelegate sendDataSizeTaskDelegate) {
        sendDataSizeTask.delegate = sendDataSizeTaskDelegate;
    }

    public void injectMembers(SendDataSizeTask sendDataSizeTask) {
        injectDelegate(sendDataSizeTask, this.a.get());
    }
}
