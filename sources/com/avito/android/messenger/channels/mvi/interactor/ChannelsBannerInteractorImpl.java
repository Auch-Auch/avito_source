package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage;
import com.avito.android.messenger.channels.mvi.common.v1.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BA\b\u0007\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractorImpl;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v1/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;", "", "refreshNotificationBannerState", "()V", "hideNotificationBanner", "dismissNotificationBanner", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBannerShowTimeStorage;", "l", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBannerShowTimeStorage;", "storage", "Lcom/avito/android/analytics/Analytics;", "n", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "o", "J", "dismissPeriodMs", "", "j", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/server_time/TimeSource;", "k", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/channels/action_banner/ChannelsBannerShowTimeStorage;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/analytics/Analytics;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsBannerInteractorImpl extends BaseMviEntityWithMutatorsRelay<ChannelsBannerInteractor.State> implements ChannelsBannerInteractor {
    @NotNull
    public final String j = "ChannelsBannerInteractor";
    public final TimeSource k;
    public final ChannelsBannerShowTimeStorage l;
    public final NotificationManagerProvider m;
    public final Analytics n;
    public final long o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelsBannerInteractorImpl(@NotNull ChannelsBannerInteractor.State state, @NotNull SchedulersFactory schedulersFactory, @NotNull TimeSource timeSource, @NotNull ChannelsBannerShowTimeStorage channelsBannerShowTimeStorage, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull Analytics analytics, long j2) {
        super(state, new SharedScheduler(schedulersFactory.io()));
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(channelsBannerShowTimeStorage, "storage");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.k = timeSource;
        this.l = channelsBannerShowTimeStorage;
        this.m = notificationManagerProvider;
        this.n = analytics;
        this.o = j2;
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor
    public void dismissNotificationBanner() {
        Relay mutatorsRelay = getMutatorsRelay();
        ChannelsBannerInteractorImpl$dismissNotificationBanner$$inlined$namedMutatorSingleFromMutator$1 channelsBannerInteractorImpl$dismissNotificationBanner$$inlined$namedMutatorSingleFromMutator$1 = new ChannelsBannerInteractorImpl$dismissNotificationBanner$$inlined$namedMutatorSingleFromMutator$1(this);
        mutatorsRelay.accept(TuplesKt.to(channelsBannerInteractorImpl$dismissNotificationBanner$$inlined$namedMutatorSingleFromMutator$1, "Mutator.DismissNotificationBanner#" + generateMutatorId("DismissNotificationBanner")));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v1.BaseMviEntity
    @NotNull
    public String getTAG() {
        return this.j;
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor
    public void hideNotificationBanner() {
        Relay mutatorsRelay = getMutatorsRelay();
        ChannelsBannerInteractorImpl$hideNotificationBanner$$inlined$namedMutatorSingleFromMutator$1 channelsBannerInteractorImpl$hideNotificationBanner$$inlined$namedMutatorSingleFromMutator$1 = new ChannelsBannerInteractorImpl$hideNotificationBanner$$inlined$namedMutatorSingleFromMutator$1(this);
        mutatorsRelay.accept(TuplesKt.to(channelsBannerInteractorImpl$hideNotificationBanner$$inlined$namedMutatorSingleFromMutator$1, "Mutator.HideNotificationBanner#" + generateMutatorId("HideNotificationBanner")));
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor
    public void refreshNotificationBannerState() {
        Relay mutatorsRelay = getMutatorsRelay();
        ChannelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1 channelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1 = new ChannelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1(this);
        mutatorsRelay.accept(TuplesKt.to(channelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1, "Mutator.RefreshNotificationBannerState#" + generateMutatorId("RefreshNotificationBannerState")));
    }
}
