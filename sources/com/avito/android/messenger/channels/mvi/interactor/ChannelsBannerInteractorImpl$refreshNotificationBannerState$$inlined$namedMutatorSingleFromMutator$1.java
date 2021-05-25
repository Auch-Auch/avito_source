package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.analytics.event.BannerEvent;
import com.avito.android.messenger.channels.action_banner.ChannelsBanner;
import com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "T", "oldState", "Lio/reactivex/Single;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)Lio/reactivex/Single;", "com/avito/android/messenger/channels/mvi/common/v1/BaseMviEntitiesKt$mutatorSingle$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1 extends Lambda implements Function1<T, Single<T>> {
    public final /* synthetic */ ChannelsBannerInteractorImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1(ChannelsBannerInteractorImpl channelsBannerInteractorImpl) {
        super(1);
        this.a = channelsBannerInteractorImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Single<T> invoke(@NotNull final T t) {
        Intrinsics.checkNotNullParameter(t, "oldState");
        Single<T> fromCallable = Single.fromCallable(new Callable<T>(this) { // from class: com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1.1
            public final /* synthetic */ ChannelsBannerInteractorImpl$refreshNotificationBannerState$$inlined$namedMutatorSingleFromMutator$1 a;

            {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public final T call() {
                T t2 = (T) ((ChannelsBannerInteractor.State) t);
                boolean areNotificationsEnabled = this.a.a.m.getAreNotificationsEnabled();
                if (areNotificationsEnabled && t2.notificationBanner != null) {
                    return (T) t2.copy(null);
                }
                if (areNotificationsEnabled || t2.notificationBanner != null) {
                    return t2;
                }
                ChannelsBannerShowTimeStorage channelsBannerShowTimeStorage = this.a.a.l;
                ChannelsBanner.NotificationsSettings notificationsSettings = ChannelsBanner.NotificationsSettings.INSTANCE;
                if (channelsBannerShowTimeStorage.getBannerShowTime(notificationsSettings.getId()) >= this.a.a.k.now()) {
                    return t2;
                }
                this.a.a.n.track(new BannerEvent.Shown("notifications", "messenger", "top"));
                return (T) t2.copy(notificationsSettings);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …tator(oldState)\n        }");
        return fromCallable;
    }
}
