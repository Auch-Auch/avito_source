package com.avito.android.analytics.provider.statsd;

import com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegate;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SendStatsdEventsTask_MembersInjector implements MembersInjector<SendStatsdEventsTask> {
    public final Provider<SendStatsdEventsTaskDelegate> a;

    public SendStatsdEventsTask_MembersInjector(Provider<SendStatsdEventsTaskDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<SendStatsdEventsTask> create(Provider<SendStatsdEventsTaskDelegate> provider) {
        return new SendStatsdEventsTask_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.analytics.provider.statsd.SendStatsdEventsTask.delegate")
    public static void injectDelegate(SendStatsdEventsTask sendStatsdEventsTask, SendStatsdEventsTaskDelegate sendStatsdEventsTaskDelegate) {
        sendStatsdEventsTask.delegate = sendStatsdEventsTaskDelegate;
    }

    public void injectMembers(SendStatsdEventsTask sendStatsdEventsTask) {
        injectDelegate(sendStatsdEventsTask, this.a.get());
    }
}
