package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgent;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushService;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushService_MembersInjector;
import com.avito.android.messenger.di.ChannelSyncOnPushServiceComponent;
import dagger.internal.Preconditions;
public final class DaggerChannelSyncOnPushServiceComponent implements ChannelSyncOnPushServiceComponent {
    public final ChannelSyncOnPushServiceDependencies a;

    public static final class b implements ChannelSyncOnPushServiceComponent.Builder {
        public ChannelSyncOnPushServiceDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.ChannelSyncOnPushServiceComponent.Builder
        public ChannelSyncOnPushServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ChannelSyncOnPushServiceDependencies.class);
            return new DaggerChannelSyncOnPushServiceComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.di.ChannelSyncOnPushServiceComponent.Builder
        public ChannelSyncOnPushServiceComponent.Builder dependencies(ChannelSyncOnPushServiceDependencies channelSyncOnPushServiceDependencies) {
            this.a = (ChannelSyncOnPushServiceDependencies) Preconditions.checkNotNull(channelSyncOnPushServiceDependencies);
            return this;
        }
    }

    public DaggerChannelSyncOnPushServiceComponent(ChannelSyncOnPushServiceDependencies channelSyncOnPushServiceDependencies, a aVar) {
        this.a = channelSyncOnPushServiceDependencies;
    }

    public static ChannelSyncOnPushServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.di.ChannelSyncOnPushServiceComponent
    public void inject(ChannelSyncOnPushService channelSyncOnPushService) {
        ChannelSyncOnPushService_MembersInjector.injectAgent(channelSyncOnPushService, (ChannelSyncOnPushAgent) Preconditions.checkNotNullFromComponent(this.a.channelSyncOnPushAgent()));
    }
}
