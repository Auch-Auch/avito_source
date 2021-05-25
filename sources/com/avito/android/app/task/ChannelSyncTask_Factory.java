package com.avito.android.app.task;

import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelSyncTask_Factory implements Factory<ChannelSyncTask> {
    public final Provider<ChannelSyncAgent> a;

    public ChannelSyncTask_Factory(Provider<ChannelSyncAgent> provider) {
        this.a = provider;
    }

    public static ChannelSyncTask_Factory create(Provider<ChannelSyncAgent> provider) {
        return new ChannelSyncTask_Factory(provider);
    }

    public static ChannelSyncTask newInstance(Lazy<ChannelSyncAgent> lazy) {
        return new ChannelSyncTask(lazy);
    }

    @Override // javax.inject.Provider
    public ChannelSyncTask get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
