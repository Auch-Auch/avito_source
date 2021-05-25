package com.avito.android.messenger.channels.mvi.interactor;

import a2.b.a.a.a;
import a2.g.r.g;
import arrow.core.Either;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.n.y;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "subscribe", "()V", "unsubscribe", "", "isRetry", "initialDataRequest", "(Z)V", "refresh", "requestNextPage", "", "channelId", "deleteChannel", "(Ljava/lang/String;)V", "Lio/reactivex/Observable;", "Larrow/core/Either;", "", "getChannelDeleteResultStream", "()Lio/reactivex/Observable;", "channelDeleteResultStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsListInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b&\b\b\u0018\u0000 P2\u00020\u0001:\u0002PQB§\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u001e\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000b\u0012\u000e\u0010$\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u0012\u0006\u0010%\u001a\u00020\u0016\u0012\u001e\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000b\u0012\u000e\u0010'\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b\u0012\u0006\u0010)\u001a\u00020\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ(\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0011J\u0018\u0010\u001a\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0015J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018JÆ\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062 \b\u0002\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000b2\u0010\b\u0002\u0010$\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\b\b\u0002\u0010%\u001a\u00020\u00162 \b\u0002\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000b2\u0010\b\u0002\u0010'\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R!\u0010'\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0015R1\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0011R\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u001dR\u0019\u0010)\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0018R1\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b>\u00106\u001a\u0004\b?\u0010\u0011R\u0019\u0010 \u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\bR\u0019\u0010\"\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010A\u001a\u0004\bD\u0010\bR!\u0010$\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\bE\u00103\u001a\u0004\bF\u0010\u0015R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u0004R\u0019\u0010%\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010\u0018R\u0019\u0010!\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010A\u001a\u0004\bM\u0010\b¨\u0006R"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "", "toString", "()Ljava/lang/String;", "component1", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;", "component2", "()Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;", "component3", "component4", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/android/persistence/messenger/DraftEntity;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelAndDraft;", "component5", "()Ljava/util/List;", "", "Lcom/avito/android/messenger/channels/mvi/sync/Timestamp;", "component6", "()Ljava/lang/Long;", "", "component7", "()Z", "component8", "component9", "", "component10", "()Ljava/util/Set;", "component11", ChannelContext.Item.USER_ID, "initialLoadingState", "refreshState", "nextPageLoadingState", "mainChannelsAndDrafts", "mainListBottomTimestamp", "mainHasMoreItems", "pinnedChannelsAndDrafts", "pinnedListBottomTimestamp", "typingChannelIds", "needInitialRequest", "copy", "(Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;Ljava/util/List;Ljava/lang/Long;ZLjava/util/List;Ljava/lang/Long;Ljava/util/Set;Z)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "i", "Ljava/lang/Long;", "getPinnedListBottomTimestamp", "h", "Ljava/util/List;", "getPinnedChannelsAndDrafts", "j", "Ljava/util/Set;", "getTypingChannelIds", "k", "Z", "getNeedInitialRequest", "e", "getMainChannelsAndDrafts", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;", "getInitialLoadingState", "d", "getNextPageLoadingState", "f", "getMainListBottomTimestamp", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserId", g.a, "getMainHasMoreItems", "c", "getRefreshState", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;Ljava/util/List;Ljava/lang/Long;ZLjava/util/List;Ljava/lang/Long;Ljava/util/Set;Z)V", "Companion", "Loading", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State l;
        @Nullable
        public final String a;
        @NotNull
        public final Loading b;
        @NotNull
        public final Loading c;
        @NotNull
        public final Loading d;
        @NotNull
        public final List<Pair<Channel, DraftEntity>> e;
        @Nullable
        public final Long f;
        public final boolean g;
        @NotNull
        public final List<Pair<Channel, DraftEntity>> h;
        @Nullable
        public final Long i;
        @NotNull
        public final Set<String> j;
        public final boolean k;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Companion;", "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "getDEFAULT", "()Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.l;
            }

            public Companion(j jVar) {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;", "", "<init>", "()V", "Error", "Finished", "InProgress", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading$Error;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading$InProgress;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading$Finished;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Loading {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading$Error;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends Loading {
                @NotNull
                public final Throwable a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Error(@NotNull Throwable th) {
                    super(null);
                    Intrinsics.checkNotNullParameter(th, "throwable");
                    this.a = th;
                }

                @NotNull
                public final Throwable getThrowable() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Loading.Error(");
                    L.append(this.a);
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading$Finished;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Finished extends Loading {
                @NotNull
                public static final Finished INSTANCE = new Finished();

                public Finished() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "Loading.Finished";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading$InProgress;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State$Loading;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class InProgress extends Loading {
                public final long a;

                public InProgress(long j) {
                    super(null);
                    this.a = j;
                }

                public final long getId() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Loading.InProgress#");
                    L.append(this.a);
                    return L.toString();
                }
            }

            public Loading() {
            }

            public Loading(j jVar) {
            }
        }

        static {
            Loading.InProgress inProgress = new Loading.InProgress(-1);
            Loading.Finished finished = Loading.Finished.INSTANCE;
            l = new State(null, inProgress, finished, finished, CollectionsKt__CollectionsKt.emptyList(), null, false, CollectionsKt__CollectionsKt.emptyList(), null, y.emptySet(), true);
        }

        public State(@Nullable String str, @NotNull Loading loading, @NotNull Loading loading2, @NotNull Loading loading3, @NotNull List<Pair<Channel, DraftEntity>> list, @Nullable Long l2, boolean z, @NotNull List<Pair<Channel, DraftEntity>> list2, @Nullable Long l3, @NotNull Set<String> set, boolean z2) {
            Intrinsics.checkNotNullParameter(loading, "initialLoadingState");
            Intrinsics.checkNotNullParameter(loading2, "refreshState");
            Intrinsics.checkNotNullParameter(loading3, "nextPageLoadingState");
            Intrinsics.checkNotNullParameter(list, "mainChannelsAndDrafts");
            Intrinsics.checkNotNullParameter(list2, "pinnedChannelsAndDrafts");
            Intrinsics.checkNotNullParameter(set, "typingChannelIds");
            this.a = str;
            this.b = loading;
            this.c = loading2;
            this.d = loading3;
            this.e = list;
            this.f = l2;
            this.g = z;
            this.h = list2;
            this.i = l3;
            this.j = set;
            this.k = z2;
        }

        public static /* synthetic */ State copy$default(State state, String str, Loading loading, Loading loading2, Loading loading3, List list, Long l2, boolean z, List list2, Long l3, Set set, boolean z2, int i2, Object obj) {
            return state.copy((i2 & 1) != 0 ? state.a : str, (i2 & 2) != 0 ? state.b : loading, (i2 & 4) != 0 ? state.c : loading2, (i2 & 8) != 0 ? state.d : loading3, (i2 & 16) != 0 ? state.e : list, (i2 & 32) != 0 ? state.f : l2, (i2 & 64) != 0 ? state.g : z, (i2 & 128) != 0 ? state.h : list2, (i2 & 256) != 0 ? state.i : l3, (i2 & 512) != 0 ? state.j : set, (i2 & 1024) != 0 ? state.k : z2);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Set<String> component10() {
            return this.j;
        }

        public final boolean component11() {
            return this.k;
        }

        @NotNull
        public final Loading component2() {
            return this.b;
        }

        @NotNull
        public final Loading component3() {
            return this.c;
        }

        @NotNull
        public final Loading component4() {
            return this.d;
        }

        @NotNull
        public final List<Pair<Channel, DraftEntity>> component5() {
            return this.e;
        }

        @Nullable
        public final Long component6() {
            return this.f;
        }

        public final boolean component7() {
            return this.g;
        }

        @NotNull
        public final List<Pair<Channel, DraftEntity>> component8() {
            return this.h;
        }

        @Nullable
        public final Long component9() {
            return this.i;
        }

        @NotNull
        public final State copy(@Nullable String str, @NotNull Loading loading, @NotNull Loading loading2, @NotNull Loading loading3, @NotNull List<Pair<Channel, DraftEntity>> list, @Nullable Long l2, boolean z, @NotNull List<Pair<Channel, DraftEntity>> list2, @Nullable Long l3, @NotNull Set<String> set, boolean z2) {
            Intrinsics.checkNotNullParameter(loading, "initialLoadingState");
            Intrinsics.checkNotNullParameter(loading2, "refreshState");
            Intrinsics.checkNotNullParameter(loading3, "nextPageLoadingState");
            Intrinsics.checkNotNullParameter(list, "mainChannelsAndDrafts");
            Intrinsics.checkNotNullParameter(list2, "pinnedChannelsAndDrafts");
            Intrinsics.checkNotNullParameter(set, "typingChannelIds");
            return new State(str, loading, loading2, loading3, list, l2, z, list2, l3, set, z2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c) && Intrinsics.areEqual(this.d, state.d) && Intrinsics.areEqual(this.e, state.e) && Intrinsics.areEqual(this.f, state.f) && this.g == state.g && Intrinsics.areEqual(this.h, state.h) && Intrinsics.areEqual(this.i, state.i) && Intrinsics.areEqual(this.j, state.j) && this.k == state.k;
        }

        @NotNull
        public final Loading getInitialLoadingState() {
            return this.b;
        }

        @NotNull
        public final List<Pair<Channel, DraftEntity>> getMainChannelsAndDrafts() {
            return this.e;
        }

        public final boolean getMainHasMoreItems() {
            return this.g;
        }

        @Nullable
        public final Long getMainListBottomTimestamp() {
            return this.f;
        }

        public final boolean getNeedInitialRequest() {
            return this.k;
        }

        @NotNull
        public final Loading getNextPageLoadingState() {
            return this.d;
        }

        @NotNull
        public final List<Pair<Channel, DraftEntity>> getPinnedChannelsAndDrafts() {
            return this.h;
        }

        @Nullable
        public final Long getPinnedListBottomTimestamp() {
            return this.i;
        }

        @NotNull
        public final Loading getRefreshState() {
            return this.c;
        }

        @NotNull
        public final Set<String> getTypingChannelIds() {
            return this.j;
        }

        @Nullable
        public final String getUserId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Loading loading = this.b;
            int hashCode2 = (hashCode + (loading != null ? loading.hashCode() : 0)) * 31;
            Loading loading2 = this.c;
            int hashCode3 = (hashCode2 + (loading2 != null ? loading2.hashCode() : 0)) * 31;
            Loading loading3 = this.d;
            int hashCode4 = (hashCode3 + (loading3 != null ? loading3.hashCode() : 0)) * 31;
            List<Pair<Channel, DraftEntity>> list = this.e;
            int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            Long l2 = this.f;
            int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
            boolean z = this.g;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode6 + i4) * 31;
            List<Pair<Channel, DraftEntity>> list2 = this.h;
            int hashCode7 = (i7 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Long l3 = this.i;
            int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
            Set<String> set = this.j;
            if (set != null) {
                i2 = set.hashCode();
            }
            int i8 = (hashCode8 + i2) * 31;
            boolean z2 = this.k;
            if (!z2) {
                i3 = z2 ? 1 : 0;
            }
            return i8 + i3;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(\n                |   userId=");
            L.append(this.a);
            L.append(",\n                |   \n                |   initialLoadingState=");
            L.append(this.b);
            L.append(",\n                |   refreshState=");
            L.append(this.c);
            L.append(", \n                |   nextPageLoadingState=");
            L.append(this.d);
            L.append(",\n                |   \n                |   mainChannelsAndDrafts=(");
            L.append(this.e.size());
            L.append(")[add logging to see contents], \n                |   mainListBottomTimestamp=");
            L.append(this.f);
            L.append(", \n                |   mainHasMoreItems=");
            L.append(this.g);
            L.append(", \n                |   \n                |   pinnedChannelsAndDrafts=(");
            L.append(this.h.size());
            L.append(")[add logging to see contents],\n                |   pinnedListBottomTimestamp=");
            L.append(this.i);
            L.append(",\n                |   \n                |   typingChannelIds=");
            L.append(this.j);
            L.append(",\n                |   \n                |   needInitialRequest=");
            return f.trimMargin$default(a.B(L, this.k, "\n                |)"), null, 1, null);
        }
    }

    void deleteChannel(@NotNull String str);

    @NotNull
    Observable<Either<Throwable, Unit>> getChannelDeleteResultStream();

    void initialDataRequest(boolean z);

    void refresh();

    void requestNextPage();

    void subscribe();

    void unsubscribe();
}
