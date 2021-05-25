package com.avito.android.messenger.conversation.mvi.menu;

import a2.b.a.a.a;
import arrow.core.Either;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0005R.\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b0\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R(\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001b0\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0019R(\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001b0\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "", "callUser", "()V", "", ChannelContext.Item.USER_ID, "channelId", "itemId", "blockUser", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "deleteChannel", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "abuseReportLink", "reportAbuse", "(Lcom/avito/android/deep_linking/links/AbuseReportLink;)V", "trackProfileOpened", "trackMenuOpened", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAbuseReportDeepLinksStream", "()Lio/reactivex/Observable;", "abuseReportDeepLinksStream", "Larrow/core/Either;", "", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallUserData;", "getCallUserDataStream", "callUserDataStream", "getUserBlockedStream", "userBlockedStream", "getChannelDeletedStream", "channelDeletedStream", "CallFrom", "CallUserData", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelMenuInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallFrom;", "", "<init>", "()V", "ActionMenu", "ChatByRecommendation", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallFrom$ActionMenu;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallFrom$ChatByRecommendation;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class CallFrom {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallFrom$ActionMenu;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallFrom;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ActionMenu extends CallFrom {
            @NotNull
            public static final ActionMenu INSTANCE = new ActionMenu();

            public ActionMenu() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallFrom$ChatByRecommendation;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallFrom;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ChatByRecommendation extends CallFrom {
            @NotNull
            public static final ChatByRecommendation INSTANCE = new ChatByRecommendation();

            public ChatByRecommendation() {
                super(null);
            }
        }

        public CallFrom() {
        }

        public CallFrom(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallUserData;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallUserData {
        @NotNull
        public final String a;

        public CallUserData(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "phone");
            this.a = str;
        }

        @NotNull
        public final String getPhone() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "", "Lcom/avito/android/remote/model/messenger/Channel;", "getChannel", "()Lcom/avito/android/remote/model/messenger/Channel;", "channel", "", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "<init>", "()V", "Empty", "Loaded", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State$Loaded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "Lcom/avito/android/remote/model/messenger/Channel;", "getChannel", "()Lcom/avito/android/remote/model/messenger/Channel;", "channel", "", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State
            @Nullable
            public Channel getChannel() {
                return null;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State
            @NotNull
            public String getCurrentUserId() {
                return "";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/Channel;", "component2", "()Lcom/avito/android/remote/model/messenger/Channel;", "currentUserId", "channel", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/Channel;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State$Loaded;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCurrentUserId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/messenger/Channel;", "getChannel", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/Channel;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final String a;
            @NotNull
            public final Channel b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull String str, @NotNull Channel channel) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.a = str;
                this.b = channel;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.getCurrentUserId();
                }
                if ((i & 2) != 0) {
                    channel = loaded.getChannel();
                }
                return loaded.copy(str, channel);
            }

            @NotNull
            public final String component1() {
                return getCurrentUserId();
            }

            @NotNull
            public final Channel component2() {
                return getChannel();
            }

            @NotNull
            public final Loaded copy(@NotNull String str, @NotNull Channel channel) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new Loaded(str, channel);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                return Intrinsics.areEqual(getCurrentUserId(), loaded.getCurrentUserId()) && Intrinsics.areEqual(getChannel(), loaded.getChannel());
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State
            @NotNull
            public Channel getChannel() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State
            @NotNull
            public String getCurrentUserId() {
                return this.a;
            }

            public int hashCode() {
                String currentUserId = getCurrentUserId();
                int i = 0;
                int hashCode = (currentUserId != null ? currentUserId.hashCode() : 0) * 31;
                Channel channel = getChannel();
                if (channel != null) {
                    i = channel.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loaded(currentUserId=");
                L.append(getCurrentUserId());
                L.append(", channel=");
                L.append(getChannel());
                L.append(")");
                return L.toString();
            }
        }

        public State() {
        }

        @Nullable
        public abstract Channel getChannel();

        @NotNull
        public abstract String getCurrentUserId();

        public State(j jVar) {
        }
    }

    void blockUser(@NotNull String str, @NotNull String str2, @Nullable String str3);

    void callUser();

    void deleteChannel(@NotNull String str);

    @NotNull
    Observable<Pair<AbuseReportLink, List<DeepLink>>> getAbuseReportDeepLinksStream();

    @NotNull
    Observable<Either<Throwable, CallUserData>> getCallUserDataStream();

    @NotNull
    Observable<Either<Throwable, Unit>> getChannelDeletedStream();

    @NotNull
    Observable<Either<Throwable, Unit>> getUserBlockedStream();

    void reportAbuse(@NotNull AbuseReportLink abuseReportLink);

    void trackMenuOpened();

    void trackProfileOpened(@NotNull String str);
}
