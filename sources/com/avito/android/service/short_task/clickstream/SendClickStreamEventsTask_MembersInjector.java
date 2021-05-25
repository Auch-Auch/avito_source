package com.avito.android.service.short_task.clickstream;

import com.avito.android.analytics.clickstream.SendClickStreamEventsTaskDelegate;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SendClickStreamEventsTask_MembersInjector implements MembersInjector<SendClickStreamEventsTask> {
    public final Provider<SendClickStreamEventsTaskDelegate> a;

    public SendClickStreamEventsTask_MembersInjector(Provider<SendClickStreamEventsTaskDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<SendClickStreamEventsTask> create(Provider<SendClickStreamEventsTaskDelegate> provider) {
        return new SendClickStreamEventsTask_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.clickstream.SendClickStreamEventsTask.delegate")
    public static void injectDelegate(SendClickStreamEventsTask sendClickStreamEventsTask, SendClickStreamEventsTaskDelegate sendClickStreamEventsTaskDelegate) {
        sendClickStreamEventsTask.delegate = sendClickStreamEventsTaskDelegate;
    }

    public void injectMembers(SendClickStreamEventsTask sendClickStreamEventsTask) {
        injectDelegate(sendClickStreamEventsTask, this.a.get());
    }
}
