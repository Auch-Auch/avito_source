package com.avito.android;

import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.MessageSendingTrackerFactory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PendingMessageHandlerModule_ProvideMessageSendingTrackerFactoryFactory implements Factory<MessageSendingTrackerFactory> {
    public final Provider<Analytics> a;
    public final Provider<TimeSource> b;
    public final Provider<BuildInfo> c;

    public PendingMessageHandlerModule_ProvideMessageSendingTrackerFactoryFactory(Provider<Analytics> provider, Provider<TimeSource> provider2, Provider<BuildInfo> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PendingMessageHandlerModule_ProvideMessageSendingTrackerFactoryFactory create(Provider<Analytics> provider, Provider<TimeSource> provider2, Provider<BuildInfo> provider3) {
        return new PendingMessageHandlerModule_ProvideMessageSendingTrackerFactoryFactory(provider, provider2, provider3);
    }

    public static MessageSendingTrackerFactory provideMessageSendingTrackerFactory(Analytics analytics, TimeSource timeSource, BuildInfo buildInfo) {
        return (MessageSendingTrackerFactory) Preconditions.checkNotNullFromProvides(PendingMessageHandlerModule.provideMessageSendingTrackerFactory(analytics, timeSource, buildInfo));
    }

    @Override // javax.inject.Provider
    public MessageSendingTrackerFactory get() {
        return provideMessageSendingTrackerFactory(this.a.get(), this.b.get(), this.c.get());
    }
}
