package com.avito.android.messenger.conversation.mvi.messages;

import a2.a.a.o1.d.a0.i.i;
import a2.a.a.o1.d.a0.i.j;
import a2.a.a.o1.d.a0.i.k;
import a2.a.a.o1.d.a0.i.l;
import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.analytics.graphite_counter.ChatLoadingResult;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerConnection;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:BT\b\u0007\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0011\u0010 \u001a\r\u0012\t\u0012\u00070\u001c¢\u0006\u0002\b\u001d0\u001b\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00105\u001a\u00020\u0002\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\rR!\u0010 \u001a\r\u0012\t\u0012\u00070\u001c¢\u0006\u0002\b\u001d0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u0006;"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "", ChannelContext.Item.USER_ID, "", "loadFirstPage", "(Ljava/lang/String;)V", "loadPrevPage", "onCleared", "()V", "n", "Ljava/lang/String;", "messageId", "o", "searchQuery", "Lru/avito/messenger/MessengerConnection;", "u", "Lru/avito/messenger/MessengerConnection;", "connection", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", AuthSource.OPEN_CHANNEL_LIST, "channelId", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatLoadingResult;", "Lkotlin/jvm/JvmSuppressWildcards;", VKApiConst.VERSION, "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "chatLoadingTimer", VKApiConst.Q, "connectionDisposable", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "r", "Lkotlin/Lazy;", "c", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "deps", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "s", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "t", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "syncAgent", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/ChannelFragment$Params;", "params", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;Lru/avito/messenger/MessengerConnection;Lcom/avito/android/analytics/timer/AnalyticsTimer;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/conversation/ChannelFragment$Params;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;Lcom/avito/android/util/SchedulersFactory;)V", "Dependencies", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageListInteractorImpl extends BaseMviEntityWithMutatorsRelay<MessageListInteractor.State> implements MessageListInteractor {
    public final String m;
    public final String n;
    public final String o;
    public final CompositeDisposable p = new CompositeDisposable();
    public final CompositeDisposable q = new CompositeDisposable();
    public final Lazy r;
    public final MessageRepo s;
    public final MessageSyncAgent t;
    public final MessengerConnection u;
    public final AnalyticsTimer<ChatLoadingResult> v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bù\u0003\u0012\u0006\u0010'\u001a\u00020\"\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00126\u0010>\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002\u00126\u0010*\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002\u00126\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002\u00126\u0010-\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002\u00126\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002\u00126\u0010!\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001e0\u0002\u0012<\u00102\u001a8\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u0002\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\b06\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b?\u0010@RI\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019RI\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\fRI\u0010!\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001e0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\fR\u0019\u0010'\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&RI\u0010*\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b)\u0010\fRI\u0010-\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b,\u0010\fRO\u00102\u001a8\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b1\u0010\fRI\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\n\u001a\u0004\b4\u0010\fR\u001f\u0010;\u001a\b\u0012\u0004\u0012\u00020\b068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:RI\u0010>\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\n\u001a\u0004\b=\u0010\f¨\u0006A"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractorImpl$Dependencies;", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", ChannelContext.Item.USER_ID, "channelId", "", "d", "Lkotlin/jvm/functions/Function2;", "getDispatchStartLoadingFirstPageMutator", "()Lkotlin/jvm/functions/Function2;", "dispatchStartLoadingFirstPageMutator", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "l", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "getErrorTracker", "()Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatLoadingResult;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "getChatLoadingTimer", "()Lcom/avito/android/analytics/timer/AnalyticsTimer;", "chatLoadingTimer", "h", "getDispatchSyncLatestMessagesAction", "dispatchSyncLatestMessagesAction", "Lio/reactivex/Completable;", "i", "getSyncLatestMessages", "syncLatestMessages", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "getMessageRepo", "()Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "e", "getDispatchLoadFirstPageMutator", "dispatchLoadFirstPageMutator", g.a, "getDispatchLoadPrevPageMutator", "dispatchLoadPrevPageMutator", "Lio/reactivex/Single;", "", "j", "getSyncPreviousPageOfMessages", "syncPreviousPageOfMessages", "f", "getDispatchStartLoadingPrevPageMutator", "dispatchStartLoadingPrevPageMutator", "Lkotlin/Function0;", "k", "Lkotlin/jvm/functions/Function0;", "getTrackMessageFoundInDb", "()Lkotlin/jvm/functions/Function0;", "trackMessageFoundInDb", "c", "getSubscribeToReconnects", "subscribeToReconnects", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/analytics/timer/AnalyticsTimer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dependencies {
        @NotNull
        public final MessageRepo a;
        @NotNull
        public final AnalyticsTimer<ChatLoadingResult> b;
        @NotNull
        public final Function2<String, String, Unit> c;
        @NotNull
        public final Function2<String, String, Unit> d;
        @NotNull
        public final Function2<String, String, Unit> e;
        @NotNull
        public final Function2<String, String, Unit> f;
        @NotNull
        public final Function2<String, String, Unit> g;
        @NotNull
        public final Function2<String, String, Unit> h;
        @NotNull
        public final Function2<String, String, Completable> i;
        @NotNull
        public final Function2<String, String, Single<Boolean>> j;
        @NotNull
        public final Function0<Unit> k;
        @NotNull
        public final ErrorTracker l;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.analytics.timer.AnalyticsTimer<? super com.avito.android.messenger.analytics.graphite_counter.ChatLoadingResult> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
        /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, ? extends io.reactivex.Completable> */
        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, ? extends io.reactivex.Single<java.lang.Boolean>> */
        /* JADX WARN: Multi-variable type inference failed */
        public Dependencies(@NotNull MessageRepo messageRepo, @NotNull AnalyticsTimer<? super ChatLoadingResult> analyticsTimer, @NotNull Function2<? super String, ? super String, Unit> function2, @NotNull Function2<? super String, ? super String, Unit> function22, @NotNull Function2<? super String, ? super String, Unit> function23, @NotNull Function2<? super String, ? super String, Unit> function24, @NotNull Function2<? super String, ? super String, Unit> function25, @NotNull Function2<? super String, ? super String, Unit> function26, @NotNull Function2<? super String, ? super String, ? extends Completable> function27, @NotNull Function2<? super String, ? super String, ? extends Single<Boolean>> function28, @NotNull Function0<Unit> function0, @NotNull ErrorTracker errorTracker) {
            Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
            Intrinsics.checkNotNullParameter(analyticsTimer, "chatLoadingTimer");
            Intrinsics.checkNotNullParameter(function2, "subscribeToReconnects");
            Intrinsics.checkNotNullParameter(function22, "dispatchStartLoadingFirstPageMutator");
            Intrinsics.checkNotNullParameter(function23, "dispatchLoadFirstPageMutator");
            Intrinsics.checkNotNullParameter(function24, "dispatchStartLoadingPrevPageMutator");
            Intrinsics.checkNotNullParameter(function25, "dispatchLoadPrevPageMutator");
            Intrinsics.checkNotNullParameter(function26, "dispatchSyncLatestMessagesAction");
            Intrinsics.checkNotNullParameter(function27, "syncLatestMessages");
            Intrinsics.checkNotNullParameter(function28, "syncPreviousPageOfMessages");
            Intrinsics.checkNotNullParameter(function0, "trackMessageFoundInDb");
            Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
            this.a = messageRepo;
            this.b = analyticsTimer;
            this.c = function2;
            this.d = function22;
            this.e = function23;
            this.f = function24;
            this.g = function25;
            this.h = function26;
            this.i = function27;
            this.j = function28;
            this.k = function0;
            this.l = errorTracker;
        }

        @NotNull
        public final AnalyticsTimer<ChatLoadingResult> getChatLoadingTimer() {
            return this.b;
        }

        @NotNull
        public final Function2<String, String, Unit> getDispatchLoadFirstPageMutator() {
            return this.e;
        }

        @NotNull
        public final Function2<String, String, Unit> getDispatchLoadPrevPageMutator() {
            return this.g;
        }

        @NotNull
        public final Function2<String, String, Unit> getDispatchStartLoadingFirstPageMutator() {
            return this.d;
        }

        @NotNull
        public final Function2<String, String, Unit> getDispatchStartLoadingPrevPageMutator() {
            return this.f;
        }

        @NotNull
        public final Function2<String, String, Unit> getDispatchSyncLatestMessagesAction() {
            return this.h;
        }

        @NotNull
        public final ErrorTracker getErrorTracker() {
            return this.l;
        }

        @NotNull
        public final MessageRepo getMessageRepo() {
            return this.a;
        }

        @NotNull
        public final Function2<String, String, Unit> getSubscribeToReconnects() {
            return this.c;
        }

        @NotNull
        public final Function2<String, String, Completable> getSyncLatestMessages() {
            return this.i;
        }

        @NotNull
        public final Function2<String, String, Single<Boolean>> getSyncPreviousPageOfMessages() {
            return this.j;
        }

        @NotNull
        public final Function0<Unit> getTrackMessageFoundInDb() {
            return this.k;
        }
    }

    public static final class a extends Lambda implements Function0<Dependencies> {
        public final /* synthetic */ MessageListInteractorImpl a;
        public final /* synthetic */ Analytics b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MessageListInteractorImpl messageListInteractorImpl, Analytics analytics) {
            super(0);
            this.a = messageListInteractorImpl;
            this.b = analytics;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Dependencies invoke() {
            return new Dependencies(this.a.s, this.a.v, new i(this.a), new x4(0, this), new x4(1, this), new x4(2, this), new x4(3, this), new x4(4, this), new j(this), new k(this), new l(this), new MessengerErrorTracker(this.b));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public MessageListInteractorImpl(@NotNull MessageRepo messageRepo, @NotNull MessageSyncAgent messageSyncAgent, @NotNull MessengerConnection messengerConnection, @NotNull AnalyticsTimer<ChatLoadingResult> analyticsTimer, @NotNull Analytics analytics, @NotNull ChannelFragment.Params params, @NotNull MessageListInteractor.State state, @NotNull SchedulersFactory schedulersFactory) {
        super("MessageListInteractor", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(messageSyncAgent, "syncAgent");
        Intrinsics.checkNotNullParameter(messengerConnection, "connection");
        Intrinsics.checkNotNullParameter(analyticsTimer, "chatLoadingTimer");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.s = messageRepo;
        this.t = messageSyncAgent;
        this.u = messengerConnection;
        this.v = analyticsTimer;
        this.m = params.getChannelId();
        this.n = params.getMessageId();
        this.o = params.getSearchQuery();
        this.r = c.lazy(new a(this, analytics));
    }

    public static final void access$subscribeToReconnects(MessageListInteractorImpl messageListInteractorImpl, String str, String str2) {
        Objects.requireNonNull(messageListInteractorImpl);
        if (messageListInteractorImpl.q.size() == 0) {
            CompositeDisposable compositeDisposable = messageListInteractorImpl.q;
            Disposable subscribe = messageListInteractorImpl.u.allReconnects().observeOn(messageListInteractorImpl.getSchedulers().io()).subscribe(new MessageListInteractorImpl$subscribeToReconnects$1(messageListInteractorImpl, str, str2));
            Intrinsics.checkNotNullExpressionValue(subscribe, "connection.allReconnects…, deps)\n                }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final Dependencies c() {
        return (Dependencies) this.r.getValue();
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor
    public void loadFirstPage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Relay mutatorsRelay = getMutatorsRelay();
        StartLoadingFirstPageMutator startLoadingFirstPageMutator = new StartLoadingFirstPageMutator(str, this.m, c());
        mutatorsRelay.accept(new MutatorSingle(startLoadingFirstPageMutator.getName(), new MessageListInteractorImpl$loadFirstPage$$inlined$plusAssign$1(startLoadingFirstPageMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor
    public void loadPrevPage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Relay mutatorsRelay = getMutatorsRelay();
        StartLoadingPrevPageMutator startLoadingPrevPageMutator = new StartLoadingPrevPageMutator(str, this.m, c());
        mutatorsRelay.accept(new MutatorSingle(startLoadingPrevPageMutator.getName(), new MessageListInteractorImpl$loadPrevPage$$inlined$plusAssign$1(startLoadingPrevPageMutator)));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.q.clear();
        this.p.clear();
        super.onCleared();
    }
}
