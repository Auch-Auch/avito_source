package com.avito.android.messenger.channels.mvi.interactor;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.preferences.Preferences;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "", "tryToUpdateBanner", "()V", "hideBanner", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", VKApiConst.POSITION, "sendBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "CommercialBannerFactory", "ShouldUpdateBannerChecker", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChatListAdBannerInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$CommercialBannerFactory;", "", "", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "bannerItems", "", "samplingEnabled", "Lcom/avito/android/remote/model/CommercialBanner;", "createCommercialBanner", "(Ljava/util/List;Z)Lcom/avito/android/remote/model/CommercialBanner;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface CommercialBannerFactory {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            @NotNull
            public static CommercialBanner createCommercialBanner(@NotNull CommercialBannerFactory commercialBannerFactory, @NotNull List<? extends AdNetworkBannerItem<?>> list, boolean z) {
                Intrinsics.checkNotNullParameter(list, "bannerItems");
                return ChatListAdBannerInteractorImpl.Companion.createCommercialBanner(list, z);
            }
        }

        @NotNull
        CommercialBanner createCommercialBanner(@NotNull List<? extends AdNetworkBannerItem<?>> list, boolean z);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$ShouldUpdateBannerChecker;", "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "shouldUpdateBanner", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/server_time/TimeSource;)Z", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface ShouldUpdateBannerChecker {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static boolean shouldUpdateBanner(@NotNull ShouldUpdateBannerChecker shouldUpdateBannerChecker, @NotNull State state, @NotNull Preferences preferences, @NotNull TimeSource timeSource) {
                Intrinsics.checkNotNullParameter(state, "$this$shouldUpdateBanner");
                Intrinsics.checkNotNullParameter(preferences, "preferences");
                Intrinsics.checkNotNullParameter(timeSource, "timeSource");
                if (state.getBanner() != null) {
                    long j = preferences.getLong("banner_shown_timestamp", -1);
                    if (j > 0 && state.getSecondsBeforeChange() > 0) {
                        if (timeSource.now() < TimeUnit.SECONDS.toMillis((long) state.getSecondsBeforeChange()) + j) {
                            return false;
                        }
                    }
                } else {
                    long j2 = preferences.getLong("banner_hidden_timestamp", -1);
                    if (j2 > 0 && state.getSecondsBeforeShowAgain() > 0) {
                        if (timeSource.now() < TimeUnit.SECONDS.toMillis((long) state.getSecondsBeforeShowAgain()) + j2) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }

        boolean shouldUpdateBanner(@NotNull State state, @NotNull Preferences preferences, @NotNull TimeSource timeSource);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B3\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJF\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\nR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010\n¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "", "Lcom/avito/android/remote/model/CommercialBanner;", "component1", "()Lcom/avito/android/remote/model/CommercialBanner;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "component4", "component5", "banner", "locationId", "chatListOffset", "secondsBeforeChange", "secondsBeforeShowAgain", "copy", "(Lcom/avito/android/remote/model/CommercialBanner;Ljava/lang/String;III)Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/CommercialBanner;", "getBanner", "c", "I", "getChatListOffset", "d", "getSecondsBeforeChange", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getLocationId", "e", "getSecondsBeforeShowAgain", "<init>", "(Lcom/avito/android/remote/model/CommercialBanner;Ljava/lang/String;III)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State f = new State(null, null, 0, 0, 0);
        @Nullable
        public final CommercialBanner a;
        @Nullable
        public final String b;
        public final int c;
        public final int d;
        public final int e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State$Companion;", "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "getDEFAULT", "()Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.f;
            }

            public Companion(j jVar) {
            }
        }

        public State(@Nullable CommercialBanner commercialBanner, @Nullable String str, int i, int i2, int i3) {
            this.a = commercialBanner;
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = i3;
        }

        public static /* synthetic */ State copy$default(State state, CommercialBanner commercialBanner, String str, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                commercialBanner = state.a;
            }
            if ((i4 & 2) != 0) {
                str = state.b;
            }
            if ((i4 & 4) != 0) {
                i = state.c;
            }
            if ((i4 & 8) != 0) {
                i2 = state.d;
            }
            if ((i4 & 16) != 0) {
                i3 = state.e;
            }
            return state.copy(commercialBanner, str, i, i2, i3);
        }

        @Nullable
        public final CommercialBanner component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        public final int component4() {
            return this.d;
        }

        public final int component5() {
            return this.e;
        }

        @NotNull
        public final State copy(@Nullable CommercialBanner commercialBanner, @Nullable String str, int i, int i2, int i3) {
            return new State(commercialBanner, str, i, i2, i3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && this.c == state.c && this.d == state.d && this.e == state.e;
        }

        @Nullable
        public final CommercialBanner getBanner() {
            return this.a;
        }

        public final int getChatListOffset() {
            return this.c;
        }

        @Nullable
        public final String getLocationId() {
            return this.b;
        }

        public final int getSecondsBeforeChange() {
            return this.d;
        }

        public final int getSecondsBeforeShowAgain() {
            return this.e;
        }

        public int hashCode() {
            CommercialBanner commercialBanner = this.a;
            int i = 0;
            int hashCode = (commercialBanner != null ? commercialBanner.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return ((((((hashCode + i) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(banner=");
            L.append(this.a);
            L.append(", locationId=");
            L.append(this.b);
            L.append(", chatListOffset=");
            L.append(this.c);
            L.append(", secondsBeforeChange=");
            L.append(this.d);
            L.append(", secondsBeforeShowAgain=");
            return a.j(L, this.e, ")");
        }
    }

    void hideBanner();

    void sendBannerOpened(@NotNull BannerInfo bannerInfo, int i);

    void tryToUpdateBanner();
}
