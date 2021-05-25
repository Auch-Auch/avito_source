package com.avito.android.messenger.channels.mvi.viewstate;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.view.AbstractListItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \b\b\u0018\u00002\u00020\u0001:\u000289Bk\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\f\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010$\u001a\u00020\b\u0012\u0010\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010'\u001a\u00020\u001a¢\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0010\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u001a\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\u0012\b\u0002\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010'\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b*\u0010\u001cJ\u001a\u0010,\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0016\u0010!\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b!\u0010.R\u0016\u0010'\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b'\u0010/R \u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00138\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b%\u00100R\u0016\u0010\u001e\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010.R\u0016\u0010#\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b#\u0010.R\u0016\u0010\u001d\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001d\u00101R\u0014\u00103\u001a\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b2\u0010\nR\u0016\u0010$\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b$\u0010.R\u0018\u0010&\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b&\u00104R\u0016\u0010\u001f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010.R\u0016\u0010 \u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b \u00105R\u0016\u0010\"\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\"\u0010.¨\u0006:"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;", "component1", "()Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;", "", "component2", "()Z", "component3", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;", "component4", "()Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;", "component5", "component6", "component7", "component8", "", "Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "component9", "()Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "component10", "()Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "component11", "()I", "progressOverlayState", "swipeToRefreshIsShown", "paginationIsEnabled", "snackbarState", "scrollToTopButtonIsShown", "showEmptyView", "scrolledToTop", "importantUpdates", "listItems", "adBannerItem", "adBannerItemOffset", "copy", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;ZZLcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;ZZZZLjava/util/List;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;I)Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;", "getShowScrollToTopProposal", "showScrollToTopProposal", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;ZZLcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;ZZZZLjava/util/List;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;I)V", "ProgressOverlayState", "SnackbarState", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListState {
    @JvmField
    @Nullable
    public final ChannelListAdBannerItem adBannerItem;
    @JvmField
    public final int adBannerItemOffset;
    @JvmField
    public final boolean importantUpdates;
    @JvmField
    @NotNull
    public final List<AbstractListItem<?>> listItems;
    @JvmField
    public final boolean paginationIsEnabled;
    @JvmField
    @NotNull
    public final ProgressOverlayState progressOverlayState;
    @JvmField
    public final boolean scrollToTopButtonIsShown;
    @JvmField
    public final boolean scrolledToTop;
    @JvmField
    public final boolean showEmptyView;
    @JvmField
    @NotNull
    public final SnackbarState snackbarState;
    @JvmField
    public final boolean swipeToRefreshIsShown;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;", "", "<init>", "()V", "Error", "Hidden", "Loading", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState$Loading;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState$Error;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState$Hidden;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ProgressOverlayState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState$Error;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ProgressOverlayState {
            @NotNull
            public static final Error INSTANCE = new Error();

            public Error() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "ProgressOverlayState.Error";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState$Hidden;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends ProgressOverlayState {
            @NotNull
            public static final Hidden INSTANCE = new Hidden();

            public Hidden() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "ProgressOverlayState.Hidden";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState$Loading;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$ProgressOverlayState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ProgressOverlayState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "ProgressOverlayState.Loading";
            }
        }

        public ProgressOverlayState() {
        }

        public ProgressOverlayState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;", "", "", "getPriority", "()I", Constants.FirelogAnalytics.PARAM_PRIORITY, "<init>", "()V", "Error", "Hidden", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Hidden;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class SnackbarState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;", "<init>", "()V", "Network", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error$Unknown;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error$Network;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Error extends SnackbarState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error$Network;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "I", "getPriority", "()I", Constants.FirelogAnalytics.PARAM_PRIORITY, "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Network extends Error {
                @NotNull
                public static final Network INSTANCE = new Network();
                public static final int a = 2;

                public Network() {
                    super(null);
                }

                @Override // com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState.SnackbarState
                public int getPriority() {
                    return a;
                }

                @NotNull
                public String toString() {
                    return "SnackbarState.Error.Network";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error$Unknown;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Error;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "I", "getPriority", "()I", Constants.FirelogAnalytics.PARAM_PRIORITY, "message", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Unknown extends Error {
                public final int a = 1;
                @JvmField
                @NotNull
                public final String message;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Unknown(@NotNull String str) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "message");
                    this.message = str;
                }

                @Override // com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState.SnackbarState
                public int getPriority() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    return "SnackbarState.Error.Unknown";
                }
            }

            public Error() {
                super(null);
            }

            public Error(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState$Hidden;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState$SnackbarState;", "", "toString", "()Ljava/lang/String;", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "I", "getPriority", "()I", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends SnackbarState {
            @NotNull
            public static final Hidden INSTANCE = new Hidden();

            public Hidden() {
                super(null);
            }

            @Override // com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState.SnackbarState
            public int getPriority() {
                return 0;
            }

            @NotNull
            public String toString() {
                return "SnackbarState.Hidden";
            }
        }

        public SnackbarState() {
        }

        public abstract int getPriority();

        public SnackbarState(j jVar) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.avito.android.messenger.channels.mvi.view.AbstractListItem<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsListState(@NotNull ProgressOverlayState progressOverlayState2, boolean z, boolean z2, @NotNull SnackbarState snackbarState2, boolean z3, boolean z4, boolean z5, boolean z7, @NotNull List<? extends AbstractListItem<?>> list, @Nullable ChannelListAdBannerItem channelListAdBannerItem, int i) {
        Intrinsics.checkNotNullParameter(progressOverlayState2, "progressOverlayState");
        Intrinsics.checkNotNullParameter(snackbarState2, "snackbarState");
        Intrinsics.checkNotNullParameter(list, "listItems");
        this.progressOverlayState = progressOverlayState2;
        this.swipeToRefreshIsShown = z;
        this.paginationIsEnabled = z2;
        this.snackbarState = snackbarState2;
        this.scrollToTopButtonIsShown = z3;
        this.showEmptyView = z4;
        this.scrolledToTop = z5;
        this.importantUpdates = z7;
        this.listItems = list;
        this.adBannerItem = channelListAdBannerItem;
        this.adBannerItemOffset = i;
    }

    public static /* synthetic */ ChannelsListState copy$default(ChannelsListState channelsListState, ProgressOverlayState progressOverlayState2, boolean z, boolean z2, SnackbarState snackbarState2, boolean z3, boolean z4, boolean z5, boolean z7, List list, ChannelListAdBannerItem channelListAdBannerItem, int i, int i2, Object obj) {
        return channelsListState.copy((i2 & 1) != 0 ? channelsListState.progressOverlayState : progressOverlayState2, (i2 & 2) != 0 ? channelsListState.swipeToRefreshIsShown : z, (i2 & 4) != 0 ? channelsListState.paginationIsEnabled : z2, (i2 & 8) != 0 ? channelsListState.snackbarState : snackbarState2, (i2 & 16) != 0 ? channelsListState.scrollToTopButtonIsShown : z3, (i2 & 32) != 0 ? channelsListState.showEmptyView : z4, (i2 & 64) != 0 ? channelsListState.scrolledToTop : z5, (i2 & 128) != 0 ? channelsListState.importantUpdates : z7, (i2 & 256) != 0 ? channelsListState.listItems : list, (i2 & 512) != 0 ? channelsListState.adBannerItem : channelListAdBannerItem, (i2 & 1024) != 0 ? channelsListState.adBannerItemOffset : i);
    }

    @NotNull
    public final ProgressOverlayState component1() {
        return this.progressOverlayState;
    }

    @Nullable
    public final ChannelListAdBannerItem component10() {
        return this.adBannerItem;
    }

    public final int component11() {
        return this.adBannerItemOffset;
    }

    public final boolean component2() {
        return this.swipeToRefreshIsShown;
    }

    public final boolean component3() {
        return this.paginationIsEnabled;
    }

    @NotNull
    public final SnackbarState component4() {
        return this.snackbarState;
    }

    public final boolean component5() {
        return this.scrollToTopButtonIsShown;
    }

    public final boolean component6() {
        return this.showEmptyView;
    }

    public final boolean component7() {
        return this.scrolledToTop;
    }

    public final boolean component8() {
        return this.importantUpdates;
    }

    @NotNull
    public final List<AbstractListItem<?>> component9() {
        return this.listItems;
    }

    @NotNull
    public final ChannelsListState copy(@NotNull ProgressOverlayState progressOverlayState2, boolean z, boolean z2, @NotNull SnackbarState snackbarState2, boolean z3, boolean z4, boolean z5, boolean z7, @NotNull List<? extends AbstractListItem<?>> list, @Nullable ChannelListAdBannerItem channelListAdBannerItem, int i) {
        Intrinsics.checkNotNullParameter(progressOverlayState2, "progressOverlayState");
        Intrinsics.checkNotNullParameter(snackbarState2, "snackbarState");
        Intrinsics.checkNotNullParameter(list, "listItems");
        return new ChannelsListState(progressOverlayState2, z, z2, snackbarState2, z3, z4, z5, z7, list, channelListAdBannerItem, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelsListState)) {
            return false;
        }
        ChannelsListState channelsListState = (ChannelsListState) obj;
        return Intrinsics.areEqual(this.progressOverlayState, channelsListState.progressOverlayState) && this.swipeToRefreshIsShown == channelsListState.swipeToRefreshIsShown && this.paginationIsEnabled == channelsListState.paginationIsEnabled && Intrinsics.areEqual(this.snackbarState, channelsListState.snackbarState) && this.scrollToTopButtonIsShown == channelsListState.scrollToTopButtonIsShown && this.showEmptyView == channelsListState.showEmptyView && this.scrolledToTop == channelsListState.scrolledToTop && this.importantUpdates == channelsListState.importantUpdates && Intrinsics.areEqual(this.listItems, channelsListState.listItems) && Intrinsics.areEqual(this.adBannerItem, channelsListState.adBannerItem) && this.adBannerItemOffset == channelsListState.adBannerItemOffset;
    }

    public final boolean getShowScrollToTopProposal() {
        return !this.scrolledToTop && this.importantUpdates;
    }

    public int hashCode() {
        ProgressOverlayState progressOverlayState2 = this.progressOverlayState;
        int i = 0;
        int hashCode = (progressOverlayState2 != null ? progressOverlayState2.hashCode() : 0) * 31;
        boolean z = this.swipeToRefreshIsShown;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        boolean z2 = this.paginationIsEnabled;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        SnackbarState snackbarState2 = this.snackbarState;
        int hashCode2 = (i10 + (snackbarState2 != null ? snackbarState2.hashCode() : 0)) * 31;
        boolean z3 = this.scrollToTopButtonIsShown;
        if (z3) {
            z3 = true;
        }
        int i11 = z3 ? 1 : 0;
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = (hashCode2 + i11) * 31;
        boolean z4 = this.showEmptyView;
        if (z4) {
            z4 = true;
        }
        int i15 = z4 ? 1 : 0;
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = (i14 + i15) * 31;
        boolean z5 = this.scrolledToTop;
        if (z5) {
            z5 = true;
        }
        int i19 = z5 ? 1 : 0;
        int i20 = z5 ? 1 : 0;
        int i21 = z5 ? 1 : 0;
        int i22 = (i18 + i19) * 31;
        boolean z7 = this.importantUpdates;
        if (!z7) {
            i2 = z7 ? 1 : 0;
        }
        int i23 = (i22 + i2) * 31;
        List<AbstractListItem<?>> list = this.listItems;
        int hashCode3 = (i23 + (list != null ? list.hashCode() : 0)) * 31;
        ChannelListAdBannerItem channelListAdBannerItem = this.adBannerItem;
        if (channelListAdBannerItem != null) {
            i = channelListAdBannerItem.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.adBannerItemOffset;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelsFragmentState(\n            |   progressOverlayState=");
        L.append(this.progressOverlayState);
        L.append(", \n            |   swipeToRefreshIsShown=");
        L.append(this.swipeToRefreshIsShown);
        L.append(", \n            |   paginationIsEnabled=");
        L.append(this.paginationIsEnabled);
        L.append(", \n            |   snackbarState=");
        L.append(this.snackbarState);
        L.append(", \n            |   scrollToTopButtonIsShown=");
        L.append(this.scrollToTopButtonIsShown);
        L.append(", \n            |   showEmptyView=");
        L.append(this.showEmptyView);
        L.append(", \n            |   scrolledToTop=");
        L.append(this.scrolledToTop);
        L.append(", \n            |   importantUpdates=");
        L.append(this.importantUpdates);
        L.append(", \n            |   listItems=(");
        L.append(this.listItems.size());
        L.append(")[add logging to see contents],\n            |   adBannerItem=");
        L.append(this.adBannerItem);
        L.append(",\n            |)");
        return f.trimMargin$default(L.toString(), null, 1, null);
    }
}
