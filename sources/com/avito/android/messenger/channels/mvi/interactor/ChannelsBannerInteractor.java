package com.avito.android.messenger.channels.mvi.interactor;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.action_banner.ChannelsBanner;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;", "", "refreshNotificationBannerState", "()V", "hideNotificationBanner", "dismissNotificationBanner", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsBannerInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;", "", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner$NotificationsSettings;", "component1", "()Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner$NotificationsSettings;", "notificationBanner", "copy", "(Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner$NotificationsSettings;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner$NotificationsSettings;", "<init>", "(Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner$NotificationsSettings;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @JvmField
        @Nullable
        public final ChannelsBanner.NotificationsSettings notificationBanner;

        public State(@Nullable ChannelsBanner.NotificationsSettings notificationsSettings) {
            this.notificationBanner = notificationsSettings;
        }

        public static /* synthetic */ State copy$default(State state, ChannelsBanner.NotificationsSettings notificationsSettings, int i, Object obj) {
            if ((i & 1) != 0) {
                notificationsSettings = state.notificationBanner;
            }
            return state.copy(notificationsSettings);
        }

        @Nullable
        public final ChannelsBanner.NotificationsSettings component1() {
            return this.notificationBanner;
        }

        @NotNull
        public final State copy(@Nullable ChannelsBanner.NotificationsSettings notificationsSettings) {
            return new State(notificationsSettings);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof State) && Intrinsics.areEqual(this.notificationBanner, ((State) obj).notificationBanner);
            }
            return true;
        }

        public int hashCode() {
            ChannelsBanner.NotificationsSettings notificationsSettings = this.notificationBanner;
            if (notificationsSettings != null) {
                return notificationsSettings.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(notificationBanner=");
            L.append(this.notificationBanner);
            L.append(")");
            return L.toString();
        }
    }

    void dismissNotificationBanner();

    void hideNotificationBanner();

    void refreshNotificationBannerState();
}
