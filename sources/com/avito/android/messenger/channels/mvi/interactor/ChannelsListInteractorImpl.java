package com.avito.android.messenger.channels.mvi.interactor;

import a2.a.a.o1.b.b.b.d;
import a2.a.a.o1.b.b.b.e;
import a2.a.a.o1.b.b.b.f;
import androidx.exifinterface.media.ExifInterface;
import arrow.core.Either;
import arrow.core.EitherKt;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.messenger.ErrorType;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingResult;
import com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshResult;
import com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoReader;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.service.OpenErrorTrackerScheduler;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.util.Logs;
import com.avito.android.util.LogsT;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.rx.arrow.OptionKt;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SinglesKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.event.BlacklistRemoveEvent;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
import t6.n.h;
import t6.n.y;
import t6.n.z;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000etuvwxyz{|}~\u0001B¦\u0002\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010F\u001a\u00020C\u0012\u0011\u0010i\u001a\r\u0012\t\u0012\u00070f¢\u0006\u0002\b\u00190e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010d\u001a\u00020a\u0012\u0011\u0010\u001c\u001a\r\u0012\t\u0012\u00070\u0018¢\u0006\u0002\b\u00190\u0017\u0012\u0011\u0010\u001f\u001a\r\u0012\t\u0012\u00070\u001d¢\u0006\u0002\b\u00190\u0017\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010#\u001a\u00020 \u0012\"\u0010X\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;0:j\u0002`<\u0012(\b\u0001\u0010L\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0018\u00010:j\u0004\u0018\u0001`<\u0012\"\u0010?\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;0:j\u0002`<\u0012\f\u0010n\u001a\b\u0012\u0004\u0012\u00020m0l\u0012\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00030o¢\u0006\u0004\bq\u0010rB\u0002\b\u0017\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010F\u001a\u00020C\u0012\u0011\u0010i\u001a\r\u0012\t\u0012\u00070f¢\u0006\u0002\b\u00190e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010d\u001a\u00020a\u0012\u0011\u0010\u001c\u001a\r\u0012\t\u0012\u00070\u0018¢\u0006\u0002\b\u00190\u0017\u0012\u0011\u0010\u001f\u001a\r\u0012\t\u0012\u00070\u001d¢\u0006\u0002\b\u00190\u0017\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010#\u001a\u00020 \u0012\"\u0010X\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;0:j\u0002`<\u0012(\b\u0001\u0010L\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0018\u00010:j\u0004\u0018\u0001`<\u0012\"\u0010?\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;0:j\u0002`<\u0012\f\u0010n\u001a\b\u0012\u0004\u0012\u00020m0l¢\u0006\u0004\bq\u0010sJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\nR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R!\u0010\u001c\u001a\r\u0012\t\u0012\u00070\u0018¢\u0006\u0002\b\u00190\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR!\u0010\u001f\u001a\r\u0012\t\u0012\u00070\u001d¢\u0006\u0002\b\u00190\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R2\u0010?\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;0:j\u0002`<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR6\u0010L\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0018\u00010:j\u0004\u0018\u0001`<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010>R.\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\u00060N0M8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u00100R2\u0010X\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0;0:j\u0002`<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010>R\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR!\u0010i\u001a\r\u0012\t\u0012\u00070f¢\u0006\u0002\b\u00190e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "isRetry", "", "initialDataRequest", "(Z)V", "subscribe", "()V", "unsubscribe", "refresh", "requestNextPage", "", "channelId", "deleteChannel", "(Ljava/lang/String;)V", "onCleared", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "x", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelSyncAgent", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatListLoadingResult;", "Lkotlin/jvm/JvmSuppressWildcards;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "loadingTimer", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatListRefreshResult;", "B", "refreshTimer", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "G", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "channelsErrorInteractor", "Lcom/avito/android/Features;", "u", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "p", "Lkotlin/Lazy;", "getErrorTracker", "()Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "errorTracker", "Lio/reactivex/disposables/CompositeDisposable;", "t", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Lcom/avito/android/analytics/Analytics;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "F", "Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "openErrorTrackerScheduler", "Lkotlin/Pair;", "Ljava/util/SortedSet;", "Lcom/avito/android/messenger/folders/ChatListTags;", "J", "Lkotlin/Pair;", "mergedTags", "r", "Ljava/lang/String;", "userLastActivitySyncAgentRequestId", "Lcom/avito/android/account/AccountStateProvider;", VKApiConst.VERSION, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "C", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "appendCounter", "I", "pinnedTags", "Lcom/jakewharton/rxrelay2/Relay;", "Larrow/core/Either;", "", VKApiConst.Q, "Lcom/jakewharton/rxrelay2/Relay;", "getChannelDeleteResultStream", "()Lcom/jakewharton/rxrelay2/Relay;", "channelDeleteResultStream", "s", "afterInitSubscriptions", "H", "mainTags", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "D", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "perfTracker", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "y", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "channelRepoReader", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "z", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "userLastActivitySyncAgent", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "w", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;Lcom/avito/android/analytics/timer/AnalyticsTimer;Lcom/avito/android/analytics/timer/AnalyticsTimer;Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;Lcom/avito/android/analytics/timer/AnalyticsTimer;Lcom/avito/android/analytics/timer/AnalyticsTimer;Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;Lkotlin/Pair;Lkotlin/Pair;Lkotlin/Pair;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", AuthSource.SEND_ABUSE, "ChatTypingStartMutator", "ChatTypingStopMutator", "DeleteChatAction", "InitialDataRequestComposite", "LoggedOutMutator", "NewMainChannelsAndDraftsFromDbMutator", "NewPinnedChannelsAndDraftsFromDbMutator", "NextPageRequestComposite", "OnBlacklistRemoveEventAction", "OnReconnectAction", "RefreshComposite", "UserIdUpdatedAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl extends BaseMviEntityWithReducerQueue<ChannelsListInteractor.State> implements ChannelsListInteractor {
    public final AnalyticsTimer<ChatListLoadingResult> A;
    public final AnalyticsTimer<ChatListRefreshResult> B;
    public final MessengerGraphiteCounter C;
    public final ChannelsTracker D;
    public final Analytics E;
    public final OpenErrorTrackerScheduler F;
    public final ChannelsErrorInteractor G;
    public final Pair<SortedSet<String>, SortedSet<String>> H;
    public final Pair<SortedSet<String>, SortedSet<String>> I;
    public final Pair<SortedSet<String>, SortedSet<String>> J;
    public final Lazy p;
    @NotNull
    public final Relay<Either<Throwable, Unit>> q;
    public final String r;
    public CompositeDisposable s;
    public final CompositeDisposable t;
    public final Features u;
    public final AccountStateProvider v;
    public final MessengerClient<AvitoMessengerApi> w;
    public final ChannelSyncAgent x;
    public final ChannelRepoReader y;
    public final UserLastActivitySyncAgent z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$ChatTypingStartMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "d", "Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "getEvent", "()Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "event", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Lru/avito/messenger/api/entity/event/ChatTypingEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ChatTypingStartMutator extends Mutator<ChannelsListInteractor.State> {
        @NotNull
        public final ChatTypingEvent d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatTypingStartMutator(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl, ChatTypingEvent chatTypingEvent) {
            super(null, "event = " + chatTypingEvent, 1, null);
            Intrinsics.checkNotNullParameter(chatTypingEvent, "event");
            this.d = chatTypingEvent;
        }

        @NotNull
        public final ChatTypingEvent getEvent() {
            return this.d;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
            if (r3 != false) goto L_0x0083;
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.String r1 = "oldState"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
                ru.avito.messenger.api.entity.event.ChatTypingEvent r1 = r0.d
                java.lang.String r1 = r1.getFromId()
                java.lang.String r3 = r17.getUserId()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
                r3 = 1
                r1 = r1 ^ r3
                if (r1 == 0) goto L_0x00a5
                java.util.List r1 = r17.getMainChannelsAndDrafts()
                ru.avito.messenger.api.entity.event.ChatTypingEvent r4 = r0.d
                java.lang.String r4 = r4.getChannelId()
                java.util.Iterator r1 = r1.iterator()
            L_0x0029:
                boolean r5 = r1.hasNext()
                r6 = 0
                if (r5 == 0) goto L_0x0048
                java.lang.Object r5 = r1.next()
                r7 = r5
                kotlin.Pair r7 = (kotlin.Pair) r7
                java.lang.Object r7 = r7.component1()
                com.avito.android.remote.model.messenger.Channel r7 = (com.avito.android.remote.model.messenger.Channel) r7
                java.lang.String r7 = r7.getChannelId()
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
                if (r7 == 0) goto L_0x0029
                goto L_0x0049
            L_0x0048:
                r5 = r6
            L_0x0049:
                r1 = 0
                if (r5 == 0) goto L_0x004e
                r4 = 1
                goto L_0x004f
            L_0x004e:
                r4 = 0
            L_0x004f:
                if (r4 != 0) goto L_0x0083
                java.util.List r4 = r17.getPinnedChannelsAndDrafts()
                ru.avito.messenger.api.entity.event.ChatTypingEvent r5 = r0.d
                java.lang.String r5 = r5.getChannelId()
                java.util.Iterator r4 = r4.iterator()
            L_0x005f:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L_0x007d
                java.lang.Object r7 = r4.next()
                r8 = r7
                kotlin.Pair r8 = (kotlin.Pair) r8
                java.lang.Object r8 = r8.component1()
                com.avito.android.remote.model.messenger.Channel r8 = (com.avito.android.remote.model.messenger.Channel) r8
                java.lang.String r8 = r8.getChannelId()
                boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r5)
                if (r8 == 0) goto L_0x005f
                r6 = r7
            L_0x007d:
                if (r6 == 0) goto L_0x0080
                goto L_0x0081
            L_0x0080:
                r3 = 0
            L_0x0081:
                if (r3 == 0) goto L_0x00a5
            L_0x0083:
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                java.util.Set r1 = r17.getTypingChannelIds()
                ru.avito.messenger.api.entity.event.ChatTypingEvent r12 = r0.d
                java.lang.String r12 = r12.getChannelId()
                java.util.Set r12 = t6.n.z.plus(r1, r12)
                r13 = 0
                r14 = 1535(0x5ff, float:2.151E-42)
                r15 = 0
                r2 = r17
                com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State r1 = com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                goto L_0x00a6
            L_0x00a5:
                r1 = r2
            L_0x00a6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl.ChatTypingStartMutator.invoke(com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State):com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$ChatTypingStopMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "d", "Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "getEvent", "()Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "event", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Lru/avito/messenger/api/entity/event/ChatTypingEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ChatTypingStopMutator extends Mutator<ChannelsListInteractor.State> {
        @NotNull
        public final ChatTypingEvent d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatTypingStopMutator(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl, ChatTypingEvent chatTypingEvent) {
            super(null, "event = " + chatTypingEvent, 1, null);
            Intrinsics.checkNotNullParameter(chatTypingEvent, "event");
            this.d = chatTypingEvent;
        }

        @NotNull
        public final ChatTypingEvent getEvent() {
            return this.d;
        }

        @NotNull
        public ChannelsListInteractor.State invoke(@NotNull ChannelsListInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return (!(Intrinsics.areEqual(this.d.getFromId(), state.getUserId()) ^ true) || !state.getTypingChannelIds().contains(this.d.getChannelId())) ? state : ChannelsListInteractor.State.copy$default(state, null, null, null, null, null, null, false, null, null, z.minus(state.getTypingChannelIds(), this.d.getChannelId()), false, 1535, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$DeleteChatAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lio/reactivex/Single;", "", "d", "Ljava/lang/String;", "channelId", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class DeleteChatAction extends ActionSingle<ChannelsListInteractor.State> {
        public final String d;
        public final /* synthetic */ ChannelsListInteractorImpl e;

        public static final class a<T> implements Consumer<Unit> {
            public final /* synthetic */ DeleteChatAction a;

            public a(DeleteChatAction deleteChatAction) {
                this.a = deleteChatAction;
            }

            @Override // io.reactivex.functions.Consumer
            public void accept(Unit unit) {
                this.a.e.getChannelDeleteResultStream().accept(EitherKt.right(Unit.INSTANCE));
            }
        }

        public static final class b<T, R> implements Function<Throwable, Unit> {
            public final /* synthetic */ DeleteChatAction a;

            public b(DeleteChatAction deleteChatAction) {
                this.a = deleteChatAction;
            }

            @Override // io.reactivex.functions.Function
            public Unit apply(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                this.a.e.getChannelDeleteResultStream().accept(EitherKt.left(th2));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteChatAction(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl, String str) {
            super(null, a2.b.a.a.a.c3("channelId = ", str), 1, null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.e = channelsListInteractorImpl;
            this.d = str;
        }

        @NotNull
        public Single<?> invoke(@NotNull ChannelsListInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (state.getUserId() != null) {
                Single<?> onErrorReturn = this.e.x.deleteChatAndDraftFromEverywhere(state.getUserId(), this.d).toSingleDefault(Unit.INSTANCE).doAfterSuccess(new a(this)).onErrorReturn(new b(this));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "channelSyncAgent.deleteC…t()\n                    }");
                return onErrorReturn;
            }
            String tag = this.e.getTAG();
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(' ');
            sb.append(this);
            sb.append(": curState.userId == 0 => do nothing");
            Logs.verbose$default(tag, sb.toString(), null, 4, null);
            return Singles.toSingle(Unit.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R.\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$InitialDataRequestComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "f", "J", "id", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "", "e", "Z", "isRetry", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;ZJ)V", "SetInProgressMutator", "TryToGetChatsFromDbMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class InitialDataRequestComposite extends CompositeReducible<ChannelsListInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<ChannelsListInteractor.State>>> d = new a(this);
        public final boolean e;
        public final long f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$InitialDataRequestComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$InitialDataRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<ChannelsListInteractor.State> {

            public static final class a extends Lambda implements Function1<ChannelsListInteractor.State, ChannelsListInteractor.State> {
                public final /* synthetic */ InitialDataRequestComposite a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(InitialDataRequestComposite initialDataRequestComposite) {
                    super(1);
                    this.a = initialDataRequestComposite;
                }

                @Override // kotlin.jvm.functions.Function1
                public ChannelsListInteractor.State invoke(ChannelsListInteractor.State state) {
                    ChannelsListInteractor.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    if (!state2.getNeedInitialRequest()) {
                        return state2;
                    }
                    ChannelsListInteractorImpl.this.A.trackStart();
                    ChannelsListInteractorImpl.this.D.startReloadSession(0);
                    ChannelsListInteractorImpl.this.D.startChannelsLoading();
                    return ChannelsListInteractor.State.copy$default(ChannelsListInteractor.State.Companion.getDEFAULT(), state2.getUserId(), new ChannelsListInteractor.State.Loading.InProgress(this.a.f), null, null, null, null, false, null, null, null, false, 2044, null);
                }
            }

            public SetInProgressMutator(InitialDataRequestComposite initialDataRequestComposite) {
                super(initialDataRequestComposite.getName() + ".SetInProgressMutator", initialDataRequestComposite.getParams(), new a(initialDataRequestComposite));
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$InitialDataRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class TryToGetChatsFromDbMutator extends MutatorSingle<ChannelsListInteractor.State> {

            public static final class a<T, R> implements Function<Throwable, ChannelsListInteractor.State> {
                public final /* synthetic */ TryToGetChatsFromDbMutator a;
                public final /* synthetic */ ChannelsListInteractor.State b;

                public a(TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator, ChannelsListInteractor.State state) {
                    this.a = tryToGetChatsFromDbMutator;
                    this.b = state;
                }

                @Override // io.reactivex.functions.Function
                public ChannelsListInteractor.State apply(Throwable th) {
                    Throwable th2 = th;
                    Intrinsics.checkNotNullParameter(th2, "it");
                    return TryToGetChatsFromDbMutator.access$handleError(this.a, th2, this.b);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TryToGetChatsFromDbMutator() {
                super(r3.getName() + ".TryToGetChatsFromDbMutator", r3.getParams());
                InitialDataRequestComposite.this = r3;
            }

            public static final Single access$getChatsFromDb(TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator, String str) {
                Single single;
                if (!ChannelsListInteractorImpl.this.u.getMessengerPinSupportChat().invoke().booleanValue()) {
                    return SinglesKt.zipWith(access$getChatsFromDbForSpecificList(tryToGetChatsFromDbMutator, str, ChannelsListInteractorImpl.this.J, "merged"), Singles.toSingle(Notification.createOnComplete()));
                }
                Single access$getChatsFromDbForSpecificList = access$getChatsFromDbForSpecificList(tryToGetChatsFromDbMutator, str, ChannelsListInteractorImpl.this.H, "main");
                if (ChannelsListInteractorImpl.this.I != null) {
                    single = access$getChatsFromDbForSpecificList(tryToGetChatsFromDbMutator, str, ChannelsListInteractorImpl.this.I, "pinned");
                } else {
                    single = Singles.toSingle(Notification.createOnComplete());
                }
                return SinglesKt.zipWith(access$getChatsFromDbForSpecificList, single);
            }

            public static final Single access$getChatsFromDbForSpecificList(TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator, String str, Pair pair, String str2) {
                Single<Option<Long>> firstOrError = ChannelsListInteractorImpl.this.y.getTimestampOfNonEmptyChannelAtPosition(str, 30, (SortedSet) pair.getFirst(), (SortedSet) pair.getSecond()).observeOn(ChannelsListInteractorImpl.this.getSchedulerForReducibles()).firstOrError();
                Intrinsics.checkNotNullExpressionValue(firstOrError, "channelRepoReader.getTim…          .firstOrError()");
                Maybe<R> flatMapMaybe = firstOrError.flatMapMaybe(new ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$getChatsFromDbForSpecificList$$inlined$flatMapMaybeFold$1(tryToGetChatsFromDbMutator, str2, tryToGetChatsFromDbMutator, str, pair));
                Intrinsics.checkNotNullExpressionValue(flatMapMaybe, "flatMapMaybe { it.fold(ifEmpty, some) }");
                io.reactivex.rxjava3.core.Single materialize = InteropKt.toV3(flatMapMaybe).materialize();
                Intrinsics.checkNotNullExpressionValue(materialize, "channelRepoReader.getTim…           .materialize()");
                return InteropKt.toV2(materialize);
            }

            public static final ChannelsListInteractor.State access$handleError(TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator, Throwable th, ChannelsListInteractor.State state) {
                ChannelsListInteractorImpl.this.D.trackChannelsLoadError();
                Throwable avitoException = ThrowablesKt.toAvitoException(th);
                if (!InitialDataRequestComposite.this.e) {
                    ChannelsListInteractorImpl.this.F.scheduleTrackChatListOpenError();
                }
                ChannelsListInteractorImpl.this.A.trackEnd(ChatListLoadingResult.ERROR);
                return ChannelsListInteractor.State.copy$default(state, null, new ChannelsListInteractor.State.Loading.Error(avitoException), null, null, null, null, false, null, null, null, false, 2045, null);
            }

            @NotNull
            public Single<ChannelsListInteractor.State> invoke(@NotNull ChannelsListInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                if (!state.getNeedInitialRequest()) {
                    Single<ChannelsListInteractor.State> just = Single.just(state);
                    Intrinsics.checkNotNullExpressionValue(just, "Single.just(oldState)");
                    return just;
                }
                ChannelsListInteractorImpl channelsListInteractorImpl = ChannelsListInteractorImpl.this;
                Observable map = InteropKt.toV2(channelsListInteractorImpl.v.userId()).observeOn(channelsListInteractorImpl.getSchedulerForReducibles()).map(ChannelsListInteractorImpl$userIdOptionObservable$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
                Single flatMap = map.firstOrError().flatMap(new ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$invoke$$inlined$withUserId$1(this, state));
                Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
                Single<ChannelsListInteractor.State> onErrorReturn = flatMap.onErrorReturn(new a(this, state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "withUserId(schedulerForR…te)\n                    }");
                return onErrorReturn;
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<ChannelsListInteractor.State>>> {
            public final /* synthetic */ InitialDataRequestComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InitialDataRequestComposite initialDataRequestComposite) {
                super(0);
                this.a = initialDataRequestComposite;
            }

            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<ChannelsListInteractor.State>> invoke() {
                String tag = ChannelsListInteractorImpl.this.getTAG();
                StringBuilder L = a2.b.a.a.a.L("InitialDataRequestComposite(isRetry = ");
                L.append(this.a.e);
                L.append(", id = ");
                L.append(this.a.f);
                L.append(").block()");
                LogsT.verbose$default(tag, L.toString(), null, 4, null);
                InitialDataRequestComposite initialDataRequestComposite = this.a;
                ChannelsListInteractorImpl channelsListInteractorImpl = ChannelsListInteractorImpl.this;
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(this.a), new TryToGetChatsFromDbMutator(), new RefreshComposite(channelsListInteractorImpl.generateReducibleId("RefreshComposite"), initialDataRequestComposite.getName(), this.a.getParams())});
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InitialDataRequestComposite(boolean z, long j) {
            super("InitialDataRequestComposite", "isRetry = " + z + ", id = " + j, null, 4, null);
            ChannelsListInteractorImpl.this = r8;
            this.e = z;
            this.f = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<ChannelsListInteractor.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$LoggedOutMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class LoggedOutMutator extends Mutator<ChannelsListInteractor.State> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoggedOutMutator() {
            super(null, null, 3, null);
            ChannelsListInteractorImpl.this = r2;
        }

        @NotNull
        public ChannelsListInteractor.State invoke(@NotNull ChannelsListInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            ChannelsListInteractorImpl.this.G.loggedOut();
            return ChannelsListInteractor.State.Companion.getDEFAULT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$NewMainChannelsAndDraftsFromDbMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/android/persistence/messenger/DraftEntity;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelAndDraft;", "newMainChannelsAndDrafts", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewMainChannelsAndDraftsFromDbMutator extends Mutator<ChannelsListInteractor.State> {

        public static final class a extends Lambda implements Function1<ChannelsListInteractor.State, ChannelsListInteractor.State> {
            public final /* synthetic */ List a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(List list) {
                super(1);
                this.a = list;
            }

            @Override // kotlin.jvm.functions.Function1
            public ChannelsListInteractor.State invoke(ChannelsListInteractor.State state) {
                ChannelsListInteractor.State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "oldState");
                return ChannelsListInteractor.State.copy$default(state2, null, null, null, null, this.a, null, false, null, null, null, false, 2031, null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewMainChannelsAndDraftsFromDbMutator(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl, List<Pair<Channel, DraftEntity>> list) {
            super(null, "newMainChannelsAndDrafts = (" + list.size() + ")[add logging to see contents]", new a(list), 1, null);
            Intrinsics.checkNotNullParameter(list, "newMainChannelsAndDrafts");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0002`\u00070\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$NewPinnedChannelsAndDraftsFromDbMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/android/persistence/messenger/DraftEntity;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelAndDraft;", "newPinnedChannelsAndDrafts", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewPinnedChannelsAndDraftsFromDbMutator extends Mutator<ChannelsListInteractor.State> {

        public static final class a extends Lambda implements Function1<ChannelsListInteractor.State, ChannelsListInteractor.State> {
            public final /* synthetic */ List a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(List list) {
                super(1);
                this.a = list;
            }

            @Override // kotlin.jvm.functions.Function1
            public ChannelsListInteractor.State invoke(ChannelsListInteractor.State state) {
                ChannelsListInteractor.State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "oldState");
                return ChannelsListInteractor.State.copy$default(state2, null, null, null, null, null, null, false, this.a, null, null, false, 1919, null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewPinnedChannelsAndDraftsFromDbMutator(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl, List<Pair<Channel, DraftEntity>> list) {
            super(null, "newPinnedChannelsAndDrafts = (" + list.size() + ")[add logging to see contents]", new a(list), 1, null);
            Intrinsics.checkNotNullParameter(list, "newPinnedChannelsAndDrafts");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R.\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$NextPageRequestComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "e", "J", "id", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;J)V", "SetInProgressMutator", "SyncNextPageMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NextPageRequestComposite extends CompositeReducible<ChannelsListInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<ChannelsListInteractor.State>>> d = new a(this);
        public final long e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$NextPageRequestComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$NextPageRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<ChannelsListInteractor.State> {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SetInProgressMutator() {
                super(r3.getName() + ".SetInProgressMutator", r3.getParams());
                NextPageRequestComposite.this = r3;
            }

            @NotNull
            public ChannelsListInteractor.State invoke(@NotNull ChannelsListInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                if (!(state.getMainHasMoreItems() && (state.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.Finished) && !(state.getRefreshState() instanceof ChannelsListInteractor.State.Loading.InProgress) && !(state.getNextPageLoadingState() instanceof ChannelsListInteractor.State.Loading.InProgress))) {
                    return state;
                }
                ChannelsListInteractorImpl.this.D.startLoadMoreSession(state.getPinnedChannelsAndDrafts().size() + state.getMainChannelsAndDrafts().size());
                ChannelsListInteractorImpl.this.D.startChannelsLoading();
                return ChannelsListInteractor.State.copy$default(state, null, null, null, new ChannelsListInteractor.State.Loading.InProgress(NextPageRequestComposite.this.e), null, null, false, null, null, null, false, 2039, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$NextPageRequestComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SyncNextPageMutator extends MutatorSingle<ChannelsListInteractor.State> {

            public static final class a<T> implements Consumer<ChannelsListInteractor.State> {
                public final /* synthetic */ SyncNextPageMutator a;

                public a(SyncNextPageMutator syncNextPageMutator) {
                    this.a = syncNextPageMutator;
                }

                @Override // io.reactivex.functions.Consumer
                public void accept(ChannelsListInteractor.State state) {
                    ChannelsListInteractorImpl.this.C.trackSuccess();
                    ChannelsListInteractorImpl.this.D.trackChannelsLoad();
                }
            }

            public static final class b<T, R> implements Function<Throwable, ChannelsListInteractor.State> {
                public final /* synthetic */ SyncNextPageMutator a;
                public final /* synthetic */ ChannelsListInteractor.State b;

                public b(SyncNextPageMutator syncNextPageMutator, ChannelsListInteractor.State state) {
                    this.a = syncNextPageMutator;
                    this.b = state;
                }

                @Override // io.reactivex.functions.Function
                public ChannelsListInteractor.State apply(Throwable th) {
                    Throwable th2 = th;
                    Intrinsics.checkNotNullParameter(th2, "it");
                    ChannelsListInteractorImpl.this.C.trackError();
                    ChannelsListInteractorImpl.this.D.trackChannelsLoadError();
                    return ChannelsListInteractor.State.copy$default(this.b, null, null, null, new ChannelsListInteractor.State.Loading.Error(ThrowablesKt.toAvitoException(th2)), null, null, false, null, null, null, false, 2039, null);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SyncNextPageMutator() {
                super(r3.getName() + ".SyncNextPageMutator", r3.getParams());
                NextPageRequestComposite.this = r3;
            }

            @NotNull
            public Single<ChannelsListInteractor.State> invoke(@NotNull ChannelsListInteractor.State state) {
                Pair pair;
                Intrinsics.checkNotNullParameter(state, "oldState");
                if (!(state.getNextPageLoadingState() instanceof ChannelsListInteractor.State.Loading.InProgress) || ((ChannelsListInteractor.State.Loading.InProgress) state.getNextPageLoadingState()).getId() != NextPageRequestComposite.this.e) {
                    String tag = ChannelsListInteractorImpl.this.getTAG();
                    StringBuilder sb = new StringBuilder();
                    StringBuilder I = a2.b.a.a.a.I('[');
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                    I.append(currentThread.getName());
                    I.append(']');
                    sb.append(I.toString());
                    sb.append(' ');
                    sb.append(this);
                    sb.append(": oldState.nextPageLoadingState = ");
                    sb.append(state.getNextPageLoadingState());
                    sb.append(" => do nothing");
                    Logs.verbose$default(tag, sb.toString(), null, 4, null);
                    return Singles.toSingle(state);
                }
                String userId = state.getUserId();
                if (userId == null || m.isBlank(userId)) {
                    return Singles.toSingle(ChannelsListInteractor.State.copy$default(state, null, null, null, new ChannelsListInteractor.State.Loading.Error(new UnauthorizedException()), null, null, false, null, null, null, false, 2039, null));
                }
                if (ChannelsListInteractorImpl.this.u.getMessengerPinSupportChat().invoke().booleanValue()) {
                    pair = ChannelsListInteractorImpl.this.H;
                } else {
                    pair = ChannelsListInteractorImpl.this.J;
                }
                ChannelsListInteractorImpl channelsListInteractorImpl = ChannelsListInteractorImpl.this;
                Observable map = InteropKt.toV2(channelsListInteractorImpl.v.userId()).observeOn(channelsListInteractorImpl.getSchedulerForReducibles()).map(ChannelsListInteractorImpl$userIdOptionObservable$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
                Single flatMap = map.firstOrError().flatMap(new ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1(this, state, pair));
                Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
                Single<ChannelsListInteractor.State> onErrorReturn = flatMap.doAfterSuccess(new a(this)).onErrorReturn(new b(this, state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "withUserId(schedulerForR…                        }");
                return onErrorReturn;
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<ChannelsListInteractor.State>>> {
            public final /* synthetic */ NextPageRequestComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(NextPageRequestComposite nextPageRequestComposite) {
                super(0);
                this.a = nextPageRequestComposite;
            }

            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<ChannelsListInteractor.State>> invoke() {
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(), new SyncNextPageMutator()});
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NextPageRequestComposite(long j) {
            super("NextPageRequestComposite", a2.b.a.a.a.T2("id = ", j), null, 4, null);
            ChannelsListInteractorImpl.this = r7;
            this.e = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<ChannelsListInteractor.State>>> getBlock() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$OnBlacklistRemoveEventAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)V", "Lru/avito/messenger/api/entity/event/BlacklistRemoveEvent;", "d", "Lru/avito/messenger/api/entity/event/BlacklistRemoveEvent;", "event", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Lru/avito/messenger/api/entity/event/BlacklistRemoveEvent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnBlacklistRemoveEventAction extends Action<ChannelsListInteractor.State> {
        public final BlacklistRemoveEvent d;
        public final /* synthetic */ ChannelsListInteractorImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnBlacklistRemoveEventAction(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl, BlacklistRemoveEvent blacklistRemoveEvent) {
            super(null, "event = " + blacklistRemoveEvent, 1, null);
            Intrinsics.checkNotNullParameter(blacklistRemoveEvent, "event");
            this.e = channelsListInteractorImpl;
            this.d = blacklistRemoveEvent;
        }

        public void invoke(@NotNull ChannelsListInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (!(state.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.Finished) || !Intrinsics.areEqual(this.d.ownerId, state.getUserId())) {
                String tag = this.e.getTAG();
                StringBuilder sb = new StringBuilder();
                StringBuilder I = a2.b.a.a.a.I('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                I.append(currentThread.getName());
                I.append(']');
                sb.append(I.toString());
                sb.append(' ');
                sb.append(this);
                sb.append(": initialLoadingState = ");
                sb.append(state.getInitialLoadingState());
                sb.append(", userId = ");
                sb.append(state.getUserId());
                sb.append(", event.ownerId = ");
                Logs.verbose$default(tag, a2.b.a.a.a.t(sb, this.d.ownerId, " => do nothing"), null, 4, null);
                return;
            }
            this.e.refresh();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$OnReconnectAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)V", "", "d", "Z", "notificationQueueWasRestored", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnReconnectAction extends Action<ChannelsListInteractor.State> {
        public final boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnReconnectAction(boolean z) {
            super("OnReconnectAction", "notificationQueueWasRestored = " + z);
            ChannelsListInteractorImpl.this = r2;
            this.d = z;
        }

        public void invoke(@NotNull ChannelsListInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (!(state.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.Finished)) {
                ChannelsListInteractorImpl.this.initialDataRequest(true);
            } else if (!(state.getRefreshState() instanceof ChannelsListInteractor.State.Loading.Finished) || !this.d) {
                ChannelsListInteractorImpl.this.refresh();
            } else if (state.getNextPageLoadingState() instanceof ChannelsListInteractor.State.Loading.Error) {
                ChannelsListInteractorImpl.this.requestNextPage();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$UserIdUpdatedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)V", "", "d", "Ljava/lang/String;", "newUserId", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UserIdUpdatedAction extends Action<ChannelsListInteractor.State> {
        public final String d;
        public final /* synthetic */ ChannelsListInteractorImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserIdUpdatedAction(@NotNull ChannelsListInteractorImpl channelsListInteractorImpl, String str) {
            super(null, a2.b.a.a.a.c3("newUserId = ", str), 1, null);
            Intrinsics.checkNotNullParameter(str, "newUserId");
            this.e = channelsListInteractorImpl;
            this.d = str;
        }

        public void invoke(@NotNull ChannelsListInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            if (!Intrinsics.areEqual(this.d, state.getUserId())) {
                this.e.initialDataRequest(true);
                return;
            }
            String tag = this.e.getTAG();
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(' ');
            sb.append(this);
            sb.append(": newUserId == oldState.userId => do nothing");
            Logs.verbose$default(tag, sb.toString(), null, 4, null);
        }
    }

    public static final class a implements ShouldCancelChecker<ChannelsListInteractor.State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<ChannelsListInteractor.State> reducible, @NotNull Reducible<ChannelsListInteractor.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof LoggedOutMutator) {
                if (!(reducible2 instanceof DeleteChatAction)) {
                    return true;
                }
            } else if (reducible instanceof InitialDataRequestComposite.SetInProgressMutator) {
                if (!(reducible2 instanceof DeleteChatAction)) {
                    return true;
                }
            } else if (reducible instanceof RefreshComposite.SetInProgressMutator) {
                if ((reducible2 instanceof RefreshComposite.SetInProgressMutator) || (reducible2 instanceof RefreshComposite.RefreshChannelsMutator) || (reducible2 instanceof NextPageRequestComposite.SetInProgressMutator) || (reducible2 instanceof NextPageRequestComposite.SyncNextPageMutator) || (reducible2 instanceof NewMainChannelsAndDraftsFromDbMutator) || (reducible2 instanceof NewPinnedChannelsAndDraftsFromDbMutator) || (reducible2 instanceof OnBlacklistRemoveEventAction)) {
                    return true;
                }
            } else if (reducible instanceof NextPageRequestComposite.SetInProgressMutator) {
                if (reducible2 instanceof NextPageRequestComposite.SetInProgressMutator) {
                    return true;
                }
            } else if (reducible instanceof NewMainChannelsAndDraftsFromDbMutator) {
                if (reducible2 instanceof NewMainChannelsAndDraftsFromDbMutator) {
                    return true;
                }
            } else if (reducible instanceof NewPinnedChannelsAndDraftsFromDbMutator) {
                if (reducible2 instanceof NewPinnedChannelsAndDraftsFromDbMutator) {
                    return true;
                }
            } else if (reducible instanceof UserIdUpdatedAction) {
                if (reducible2 instanceof UserIdUpdatedAction) {
                    return true;
                }
            } else if (reducible instanceof ChatTypingStartMutator) {
                if (reducible2 instanceof ChatTypingStartMutator) {
                    return Intrinsics.areEqual(((ChatTypingStartMutator) reducible).getEvent().getChannelId(), ((ChatTypingStartMutator) reducible2).getEvent().getChannelId());
                }
                if (reducible2 instanceof ChatTypingStopMutator) {
                    return Intrinsics.areEqual(((ChatTypingStartMutator) reducible).getEvent().getChannelId(), ((ChatTypingStopMutator) reducible2).getEvent().getChannelId());
                }
            } else if (reducible instanceof ChatTypingStopMutator) {
                if (reducible2 instanceof ChatTypingStartMutator) {
                    return Intrinsics.areEqual(((ChatTypingStopMutator) reducible).getEvent().getChannelId(), ((ChatTypingStartMutator) reducible2).getEvent().getChannelId());
                }
                if (reducible2 instanceof ChatTypingStopMutator) {
                    return Intrinsics.areEqual(((ChatTypingStopMutator) reducible).getEvent().getChannelId(), ((ChatTypingStopMutator) reducible2).getEvent().getChannelId());
                }
            }
            return false;
        }
    }

    public static final class b extends Lambda implements Function0<MessengerErrorTracker> {
        public final /* synthetic */ ChannelsListInteractorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ChannelsListInteractorImpl channelsListInteractorImpl) {
            super(0);
            this.a = channelsListInteractorImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public MessengerErrorTracker invoke() {
            return new MessengerErrorTracker(this.a.E);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [kotlin.Pair<java.util.SortedSet<java.lang.String>, java.util.SortedSet<java.lang.String>>, java.lang.Object, kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>>] */
    /* JADX WARN: Type inference failed for: r39v0, types: [kotlin.Pair<java.util.SortedSet<java.lang.String>, java.util.SortedSet<java.lang.String>>, kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>>] */
    /* JADX WARN: Type inference failed for: r40v0, types: [kotlin.Pair<java.util.SortedSet<java.lang.String>, java.util.SortedSet<java.lang.String>>, java.lang.Object, kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>>] */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Predicate$0] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChannelsListInteractorImpl(@org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r24, @org.jetbrains.annotations.NotNull com.avito.android.Features r25, @org.jetbrains.annotations.NotNull com.avito.android.account.AccountStateProvider r26, @org.jetbrains.annotations.NotNull ru.avito.messenger.MessengerClient<ru.avito.messenger.api.AvitoMessengerApi> r27, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent r28, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.data.ChannelRepoReader r29, @org.jetbrains.annotations.NotNull com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent r30, @org.jetbrains.annotations.NotNull com.avito.android.analytics.timer.AnalyticsTimer<com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingResult> r31, @org.jetbrains.annotations.NotNull com.avito.android.analytics.timer.AnalyticsTimer<com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshResult> r32, @org.jetbrains.annotations.NotNull com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter r33, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.analytics.ChannelsTracker r34, @org.jetbrains.annotations.NotNull com.avito.android.analytics.Analytics r35, @org.jetbrains.annotations.NotNull com.avito.android.messenger.service.OpenErrorTrackerScheduler r36, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor r37, @org.jetbrains.annotations.NotNull kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>> r38, @javax.annotation.Nullable @org.jetbrains.annotations.Nullable kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>> r39, @org.jetbrains.annotations.NotNull kotlin.Pair<? extends java.util.SortedSet<java.lang.String>, ? extends java.util.SortedSet<java.lang.String>> r40, @org.jetbrains.annotations.NotNull com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup<com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup> r41, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue<com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State> r42) {
        /*
        // Method dump skipped, instructions count: 776
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl.<init>(com.avito.android.util.SchedulersFactory, com.avito.android.Features, com.avito.android.account.AccountStateProvider, ru.avito.messenger.MessengerClient, com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent, com.avito.android.messenger.channels.mvi.data.ChannelRepoReader, com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent, com.avito.android.analytics.timer.AnalyticsTimer, com.avito.android.analytics.timer.AnalyticsTimer, com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter, com.avito.android.messenger.channels.analytics.ChannelsTracker, com.avito.android.analytics.Analytics, com.avito.android.messenger.service.OpenErrorTrackerScheduler, com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor, kotlin.Pair, kotlin.Pair, kotlin.Pair, com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup, com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue):void");
    }

    public static final RefreshComposite access$createRefreshComposite(ChannelsListInteractorImpl channelsListInteractorImpl, String str, String str2) {
        Objects.requireNonNull(channelsListInteractorImpl);
        return new RefreshComposite(channelsListInteractorImpl.generateReducibleId("RefreshComposite"), str, str2);
    }

    public static final MessengerErrorTracker access$getErrorTracker$p(ChannelsListInteractorImpl channelsListInteractorImpl) {
        return (MessengerErrorTracker) channelsListInteractorImpl.p.getValue();
    }

    public static final Completable access$handleChatTypingEvent(ChannelsListInteractorImpl channelsListInteractorImpl, ChatTypingEvent chatTypingEvent) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Completable andThen = Completable.fromAction(new e(channelsListInteractorImpl, chatTypingEvent)).andThen(Single.fromCallable(new f(channelsListInteractorImpl, chatTypingEvent)).delaySubscription(3000, TimeUnit.MILLISECONDS, channelsListInteractorImpl.getSchedulers().computation()).ignoreElement());
        Intrinsics.checkNotNullExpressionValue(andThen, "Completable.fromAction {…ignoreElement()\n        )");
        return andThen;
    }

    public static final Set access$interlocutorIds(ChannelsListInteractorImpl channelsListInteractorImpl, List list, String str) {
        Objects.requireNonNull(channelsListInteractorImpl);
        if (!list.isEmpty()) {
            if (!(str == null || m.isBlank(str))) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    List<User> users = ((Channel) ((Pair) it.next()).component1()).getUsers();
                    ArrayList arrayList2 = new ArrayList();
                    for (T t2 : users) {
                        if (!Intrinsics.areEqual(t2.getId(), str)) {
                            arrayList2.add(t2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((User) it2.next()).getId());
                    }
                    h.addAll(arrayList, arrayList3);
                }
                return CollectionsKt___CollectionsKt.toHashSet(arrayList);
            }
        }
        return y.emptySet();
    }

    public static final Function1 access$logError(ChannelsListInteractorImpl channelsListInteractorImpl, String str) {
        Objects.requireNonNull(channelsListInteractorImpl);
        return new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, str);
    }

    public static final boolean access$needToLogIn(ChannelsListInteractorImpl channelsListInteractorImpl, ChannelsListInteractor.State.Loading.Error error) {
        Object obj;
        Objects.requireNonNull(channelsListInteractorImpl);
        ErrorType.Companion companion = ErrorType.Companion;
        Throwable throwable = error.getThrowable();
        if (throwable instanceof UnauthorizedException) {
            obj = ErrorType.Unauthorized.INSTANCE;
        } else if (throwable instanceof IOException) {
            obj = ErrorType.Network.INSTANCE;
        } else {
            obj = ErrorType.Other.INSTANCE;
        }
        return obj == ErrorType.Unauthorized.INSTANCE;
    }

    public static final void access$setupAfterInitSubscriptions(ChannelsListInteractorImpl channelsListInteractorImpl) {
        Objects.requireNonNull(channelsListInteractorImpl);
        if (channelsListInteractorImpl.s.size() == 0) {
            Scheduler io2 = channelsListInteractorImpl.getSchedulers().io();
            CompositeDisposable compositeDisposable = channelsListInteractorImpl.s;
            SharedScheduler sharedScheduler = new SharedScheduler(io2);
            compositeDisposable.add(Disposables.fromAction(new ChannelsListInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0(new Function0<Unit>(sharedScheduler) { // from class: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$setupAfterInitSubscriptions$$inlined$toShared$1
                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ((SharedScheduler) this.receiver).shutdown();
                }
            })));
            Disposable subscribe = channelsListInteractorImpl.w.observeChatEvents(ChatTypingEvent.class).flatMapCompletable(new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Function$0(new ChannelsListInteractorImpl$subscribeToChatTypingEvents$1(channelsListInteractorImpl))).observeOn(sharedScheduler).subscribe(ChannelsListInteractorImpl$subscribeToChatTypingEvents$2.INSTANCE, new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "client.observeChatEvents<ChatTypingEvent>()")));
            Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…gEvent>()\")\n            )");
            DisposableKt.addTo(subscribe, channelsListInteractorImpl.s);
            Disposable subscribe2 = channelsListInteractorImpl.w.observeMessages().observeOn(sharedScheduler).subscribe(new ChannelsListInteractorImpl$subscribeToStopTypingEvents$1(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "New messages")));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "client.observeMessages()… messages\")\n            )");
            DisposableKt.addTo(subscribe2, channelsListInteractorImpl.s);
            Disposable subscribe3 = channelsListInteractorImpl.getStateObservable().observeOn(sharedScheduler).map(new ChannelsListInteractorImpl$setupUsersLastActivityPolling$1(channelsListInteractorImpl)).distinctUntilChanged().subscribe(new ChannelsListInteractorImpl$setupUsersLastActivityPolling$2(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "stateObservable (for requesting users' last activity)")));
            Intrinsics.checkNotNullExpressionValue(subscribe3, "stateObservable\n        …activity)\")\n            )");
            DisposableKt.addTo(subscribe3, channelsListInteractorImpl.s);
            DisposableKt.addTo(channelsListInteractorImpl.s, channelsListInteractorImpl.t);
        }
    }

    public static final void access$setupUsersLastActivityPolling(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Disposable subscribe = channelsListInteractorImpl.getStateObservable().observeOn(scheduler).map(new ChannelsListInteractorImpl$setupUsersLastActivityPolling$1(channelsListInteractorImpl)).distinctUntilChanged().subscribe(new ChannelsListInteractorImpl$setupUsersLastActivityPolling$2(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "stateObservable (for requesting users' last activity)")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "stateObservable\n        …activity)\")\n            )");
        DisposableKt.addTo(subscribe, channelsListInteractorImpl.s);
    }

    public static final void access$subscribeToBlacklistRemoveEvents(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Disposable subscribe = channelsListInteractorImpl.w.observeChatEvents(BlacklistRemoveEvent.class).observeOn(scheduler).throttleLatest(500L, TimeUnit.MILLISECONDS, true).subscribeOn(scheduler).subscribe(new ChannelsListInteractorImpl$subscribeToBlacklistRemoveEvents$1(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "BlacklistRemoveEvent")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…moveEvent\")\n            )");
        DisposableKt.addTo(subscribe, channelsListInteractorImpl.t);
    }

    public static final void access$subscribeToChannelsUpdatesFromDb(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Disposable subscribe = channelsListInteractorImpl.getStateObservable().observeOn(scheduler).map(ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$1.INSTANCE).distinctUntilChanged().switchMap(new ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$2(channelsListInteractorImpl)).subscribe(new ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$3(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "stateObservable (for getting DB updates)")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "stateObservable\n        … updates)\")\n            )");
        DisposableKt.addTo(subscribe, channelsListInteractorImpl.t);
        if (channelsListInteractorImpl.u.getMessengerPinSupportChat().invoke().booleanValue() && channelsListInteractorImpl.I != null) {
            Disposable subscribe2 = channelsListInteractorImpl.getStateObservable().observeOn(scheduler).map(ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$4.INSTANCE).distinctUntilChanged().switchMap(new ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$5(channelsListInteractorImpl)).subscribe(new ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$6(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "stateObservable (for getting DB updates)")));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "stateObservable\n        …ates)\")\n                )");
            DisposableKt.addTo(subscribe2, channelsListInteractorImpl.t);
        }
    }

    public static final void access$subscribeToChatTypingEvents(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Disposable subscribe = channelsListInteractorImpl.w.observeChatEvents(ChatTypingEvent.class).flatMapCompletable(new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Function$0(new ChannelsListInteractorImpl$subscribeToChatTypingEvents$1(channelsListInteractorImpl))).observeOn(scheduler).subscribe(ChannelsListInteractorImpl$subscribeToChatTypingEvents$2.INSTANCE, new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "client.observeChatEvents<ChatTypingEvent>()")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…gEvent>()\")\n            )");
        DisposableKt.addTo(subscribe, channelsListInteractorImpl.s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Predicate$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$subscribeToLogouts(com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl r4, io.reactivex.Scheduler r5) {
        /*
            io.reactivex.Observable r0 = r4.getStateObservable()
            io.reactivex.Observable r0 = r0.observeOn(r5)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$1 r1 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$1
            r1.<init>(r4)
            io.reactivex.Observable r0 = r0.scan(r1)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$2 r1 = com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$2.INSTANCE
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$logError$1 r2 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$logError$1
            java.lang.String r3 = "stateObservable (for logout detection)"
            r2.<init>(r4, r3)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0 r3 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0
            r3.<init>(r2)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1, r3)
            java.lang.String r1 = "stateObservable.observeO…etection)\")\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            io.reactivex.disposables.CompositeDisposable r1 = access$getAllSubscriptions$p(r4)
            io.reactivex.rxkotlin.DisposableKt.addTo(r0, r1)
            com.avito.android.account.AccountStateProvider r0 = access$getAccountStateProvider$p(r4)
            io.reactivex.rxjava3.core.Observable r0 = r0.userId()
            io.reactivex.Observable r0 = com.avito.android.util.rx3.InteropKt.toV2(r0)
            io.reactivex.Observable r0 = r0.observeOn(r5)
            r1 = 1
            io.reactivex.Observable r0 = r0.skip(r1)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$3 r1 = com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$3.INSTANCE
            if (r1 == 0) goto L_0x004f
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Predicate$0 r2 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Predicate$0
            r2.<init>(r1)
            r1 = r2
        L_0x004f:
            io.reactivex.functions.Predicate r1 = (io.reactivex.functions.Predicate) r1
            io.reactivex.Observable r0 = r0.filter(r1)
            io.reactivex.Observable r5 = r0.subscribeOn(r5)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$4 r0 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$subscribeToLogouts$4
            r0.<init>(r4)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$logError$1 r1 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$logError$1
            java.lang.String r2 = "Blank user id"
            r1.<init>(r4, r2)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0 r2 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0
            r2.<init>(r1)
            io.reactivex.disposables.Disposable r5 = r5.subscribe(r0, r2)
            java.lang.String r0 = "accountStateProvider.use…k user id\")\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            io.reactivex.disposables.CompositeDisposable r4 = access$getAllSubscriptions$p(r4)
            io.reactivex.rxkotlin.DisposableKt.addTo(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl.access$subscribeToLogouts(com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl, io.reactivex.Scheduler):void");
    }

    public static final void access$subscribeToNonEmptyUserIdUpdates(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Observable map = InteropKt.toV2(channelsListInteractorImpl.v.userId()).observeOn(scheduler).map(ChannelsListInteractorImpl$userIdOptionObservable$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
        Disposable subscribe = OptionKt.filterDefined(map).subscribe(new ChannelsListInteractorImpl$subscribeToNonEmptyUserIdUpdates$1(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "User Id")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "userIdOptionObservable(s…(\"User Id\")\n            )");
        DisposableKt.addTo(subscribe, channelsListInteractorImpl.t);
    }

    public static final void access$subscribeToReconnects(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Disposable subscribe = channelsListInteractorImpl.w.allReconnects().subscribeOn(scheduler).observeOn(scheduler).subscribe(new ChannelsListInteractorImpl$subscribeToReconnects$1(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "client.allReconnects()")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.allReconnects()\n …onnects()\")\n            )");
        DisposableKt.addTo(subscribe, channelsListInteractorImpl.t);
    }

    public static final void access$subscribeToStopTypingEvents(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Disposable subscribe = channelsListInteractorImpl.w.observeMessages().observeOn(scheduler).subscribe(new ChannelsListInteractorImpl$subscribeToStopTypingEvents$1(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "New messages")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeMessages()… messages\")\n            )");
        DisposableKt.addTo(subscribe, channelsListInteractorImpl.s);
    }

    public static final Observable access$userIdOptionObservable(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Observable map = InteropKt.toV2(channelsListInteractorImpl.v.userId()).observeOn(scheduler).map(ChannelsListInteractorImpl$userIdOptionObservable$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
        return map;
    }

    public static final Single access$withUserId(ChannelsListInteractorImpl channelsListInteractorImpl, Scheduler scheduler, Function1 function1) {
        Objects.requireNonNull(channelsListInteractorImpl);
        Observable map = InteropKt.toV2(channelsListInteractorImpl.v.userId()).observeOn(scheduler).map(ChannelsListInteractorImpl$userIdOptionObservable$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
        Single flatMap = map.firstOrError().flatMap(new Function<Option<? extends String>, SingleSource<? extends R>>() { // from class: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$withUserId$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Option<? extends String> option) {
                return apply((Option<String>) option);
            }

            public final SingleSource<? extends R> apply(@NotNull Option<String> option) {
                Intrinsics.checkNotNullParameter(option, "userIdOption");
                if (option instanceof None) {
                    throw new UnauthorizedException();
                } else if (option instanceof Some) {
                    return (SingleSource) Function1.this.invoke(((Some) option).getT());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
        return flatMap;
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor
    public void deleteChannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        getReducerQueue().plusAssign(new DeleteChatAction(this, str));
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor
    public void initialDataRequest(boolean z2) {
        getReducerQueue().plusAssign(new InitialDataRequestComposite(z2, generateReducibleId("InitialDataRequestComposite")));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.t.clear();
        this.z.requestUsers(this.r, y.emptySet());
        this.A.dispose();
        this.B.dispose();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor
    public void refresh() {
        getReducerQueue().plusAssign(new RefreshComposite(generateReducibleId("RefreshComposite"), null, null));
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor
    public void requestNextPage() {
        getReducerQueue().plusAssign(new NextPageRequestComposite(generateReducibleId("NextPageRequestComposite")));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorKt$sam$i$io_reactivex_functions_Predicate$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribe() {
        /*
        // Method dump skipped, instructions count: 496
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl.subscribe():void");
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor
    public void unsubscribe() {
        this.t.clear();
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor
    @NotNull
    public Relay<Either<Throwable, Unit>> getChannelDeleteResultStream() {
        return this.q;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B'\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R.\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$RefreshComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "", "e", "J", "id", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "", "f", "Ljava/lang/String;", "parentName", "parentParams", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl;JLjava/lang/String;Ljava/lang/String;)V", "RefreshChannelsMutator", "SetInProgressMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RefreshComposite extends CompositeReducible<ChannelsListInteractor.State> {
        @NotNull
        public final Function0<List<Reducible<ChannelsListInteractor.State>>> d;
        public final long e;
        public final String f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$RefreshComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class RefreshChannelsMutator extends MutatorSingle<ChannelsListInteractor.State> {

            public static final class a<T> implements Consumer<ChannelsListInteractor.State> {
                public final /* synthetic */ RefreshChannelsMutator a;

                public a(RefreshChannelsMutator refreshChannelsMutator) {
                    this.a = refreshChannelsMutator;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: com.avito.android.analytics.timer.AnalyticsTimer */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.reactivex.functions.Consumer
                public void accept(ChannelsListInteractor.State state) {
                    ChannelsListInteractorImpl.this.D.trackChannelsLoad();
                    ChannelsListInteractorImpl.this.B.trackEnd(ChatListRefreshResult.SUCCESS);
                    ChannelsListInteractorImpl channelsListInteractorImpl = ChannelsListInteractorImpl.this;
                    if (channelsListInteractorImpl.s.size() == 0) {
                        Scheduler io2 = channelsListInteractorImpl.getSchedulers().io();
                        CompositeDisposable compositeDisposable = channelsListInteractorImpl.s;
                        SharedScheduler sharedScheduler = new SharedScheduler(io2);
                        compositeDisposable.add(Disposables.fromAction(new ChannelsListInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0(new ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$2$setupAfterInitSubscriptions$$inlined$toShared$1(sharedScheduler))));
                        Disposable subscribe = channelsListInteractorImpl.w.observeChatEvents(ChatTypingEvent.class).flatMapCompletable(new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Function$0(new ChannelsListInteractorImpl$subscribeToChatTypingEvents$1(channelsListInteractorImpl))).observeOn(sharedScheduler).subscribe(ChannelsListInteractorImpl$subscribeToChatTypingEvents$2.INSTANCE, new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "client.observeChatEvents<ChatTypingEvent>()")));
                        Intrinsics.checkNotNullExpressionValue(subscribe, "client.observeChatEvents…gEvent>()\")\n            )");
                        DisposableKt.addTo(subscribe, channelsListInteractorImpl.s);
                        Disposable subscribe2 = channelsListInteractorImpl.w.observeMessages().observeOn(sharedScheduler).subscribe(new ChannelsListInteractorImpl$subscribeToStopTypingEvents$1(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "New messages")));
                        Intrinsics.checkNotNullExpressionValue(subscribe2, "client.observeMessages()… messages\")\n            )");
                        DisposableKt.addTo(subscribe2, channelsListInteractorImpl.s);
                        Disposable subscribe3 = channelsListInteractorImpl.getStateObservable().observeOn(sharedScheduler).map(new ChannelsListInteractorImpl$setupUsersLastActivityPolling$1(channelsListInteractorImpl)).distinctUntilChanged().subscribe(new ChannelsListInteractorImpl$setupUsersLastActivityPolling$2(channelsListInteractorImpl), new ChannelsListInteractorKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListInteractorImpl$logError$1(channelsListInteractorImpl, "stateObservable (for requesting users' last activity)")));
                        Intrinsics.checkNotNullExpressionValue(subscribe3, "stateObservable\n        …activity)\")\n            )");
                        DisposableKt.addTo(subscribe3, channelsListInteractorImpl.s);
                        DisposableKt.addTo(channelsListInteractorImpl.s, channelsListInteractorImpl.t);
                    }
                }
            }

            public static final class b<T, R> implements Function<Throwable, ChannelsListInteractor.State> {
                public final /* synthetic */ RefreshChannelsMutator a;
                public final /* synthetic */ ChannelsListInteractor.State b;

                public b(RefreshChannelsMutator refreshChannelsMutator, ChannelsListInteractor.State state) {
                    this.a = refreshChannelsMutator;
                    this.b = state;
                }

                @Override // io.reactivex.functions.Function
                public ChannelsListInteractor.State apply(Throwable th) {
                    Throwable th2 = th;
                    Intrinsics.checkNotNullParameter(th2, "error");
                    return RefreshChannelsMutator.access$handleError(this.a, th2, this.b);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public RefreshChannelsMutator() {
                super(r3.getName() + ".RefreshChannelsMutator", r3.getParams());
                RefreshComposite.this = r3;
            }

            public static final ChannelsListInteractor.State access$handleError(RefreshChannelsMutator refreshChannelsMutator, Throwable th, ChannelsListInteractor.State state) {
                ChannelsListInteractorImpl.this.D.trackChannelsLoadError();
                ChannelsListInteractorImpl.this.B.trackEnd(ChatListRefreshResult.ERROR);
                if (state.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.InProgress) {
                    return ChannelsListInteractor.State.copy$default(state, null, new ChannelsListInteractor.State.Loading.Error(ThrowablesKt.toAvitoException(th)), null, null, null, null, false, null, null, null, false, 2045, null);
                }
                return ChannelsListInteractor.State.copy$default(state, null, null, new ChannelsListInteractor.State.Loading.Error(ThrowablesKt.toAvitoException(th)), null, null, null, false, null, null, null, false, 2043, null);
            }

            public static final Single access$refreshChats(RefreshChannelsMutator refreshChannelsMutator, String str) {
                Single single;
                if (!ChannelsListInteractorImpl.this.u.getMessengerPinSupportChat().invoke().booleanValue()) {
                    return SinglesKt.zipWith(access$refreshChatsInSpecificList(refreshChannelsMutator, str, ChannelsListInteractorImpl.this.J), Singles.toSingle(Notification.createOnComplete()));
                }
                Single access$refreshChatsInSpecificList = access$refreshChatsInSpecificList(refreshChannelsMutator, str, ChannelsListInteractorImpl.this.H);
                if (ChannelsListInteractorImpl.this.I != null) {
                    single = access$refreshChatsInSpecificList(refreshChannelsMutator, str, ChannelsListInteractorImpl.this.I);
                } else {
                    single = Singles.toSingle(Notification.createOnComplete());
                }
                return SinglesKt.zipWith(access$refreshChatsInSpecificList, single);
            }

            public static final Single access$refreshChatsInSpecificList(RefreshChannelsMutator refreshChannelsMutator, String str, Pair pair) {
                Single<R> flatMap = ChannelsListInteractorImpl.this.x.syncLatestChats(str, (SortedSet) pair.getFirst(), (SortedSet) pair.getSecond()).observeOn(ChannelsListInteractorImpl.this.getSchedulerForReducibles()).flatMap(new d(refreshChannelsMutator, str, pair));
                Intrinsics.checkNotNullExpressionValue(flatMap, "channelSyncAgent.syncLat…  }\n                    }");
                io.reactivex.rxjava3.core.Single materialize = InteropKt.toV3(flatMap).materialize();
                Intrinsics.checkNotNullExpressionValue(materialize, "channelSyncAgent.syncLat…           .materialize()");
                return InteropKt.toV2(materialize);
            }

            @NotNull
            public Single<ChannelsListInteractor.State> invoke(@NotNull ChannelsListInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                ChannelsListInteractorImpl channelsListInteractorImpl = ChannelsListInteractorImpl.this;
                Observable map = InteropKt.toV2(channelsListInteractorImpl.v.userId()).observeOn(channelsListInteractorImpl.getSchedulerForReducibles()).map(ChannelsListInteractorImpl$userIdOptionObservable$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.use….toOption()\n            }");
                Single flatMap = map.firstOrError().flatMap(new ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1(this, state));
                Intrinsics.checkNotNullExpressionValue(flatMap, "userIdOptionObservable(s…          )\n            }");
                Single<ChannelsListInteractor.State> onErrorReturn = flatMap.doAfterSuccess(new a(this)).onErrorReturn(new b(this, state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "withUserId(schedulerForR…te)\n                    }");
                return onErrorReturn;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$RefreshComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$RefreshComposite;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<ChannelsListInteractor.State> {

            public static final class a extends Lambda implements Function1<ChannelsListInteractor.State, ChannelsListInteractor.State> {
                public final /* synthetic */ RefreshComposite a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(RefreshComposite refreshComposite) {
                    super(1);
                    this.a = refreshComposite;
                }

                @Override // kotlin.jvm.functions.Function1
                public ChannelsListInteractor.State invoke(ChannelsListInteractor.State state) {
                    ChannelsListInteractor.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    if (!(!Intrinsics.areEqual(this.a.f, "InitialDataRequestComposite"))) {
                        return state2;
                    }
                    ChannelsListInteractorImpl.this.B.trackStart();
                    ChannelsListInteractorImpl.this.D.startReloadSession(state2.getPinnedChannelsAndDrafts().size() + state2.getMainChannelsAndDrafts().size());
                    ChannelsListInteractorImpl.this.D.startChannelsLoading();
                    return ChannelsListInteractor.State.copy$default(state2, null, null, new ChannelsListInteractor.State.Loading.InProgress(this.a.e), ChannelsListInteractor.State.Loading.Finished.INSTANCE, null, null, false, null, null, null, false, 2035, null);
                }
            }

            public SetInProgressMutator(RefreshComposite refreshComposite) {
                super(refreshComposite.getName() + ".SetInProgressMutator", refreshComposite.getParams(), new a(refreshComposite));
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<ChannelsListInteractor.State>>> {
            public final /* synthetic */ RefreshComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(RefreshComposite refreshComposite) {
                super(0);
                this.a = refreshComposite;
            }

            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<ChannelsListInteractor.State>> invoke() {
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(this.a), new RefreshChannelsMutator()});
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public RefreshComposite(long r11, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.Nullable java.lang.String r14) {
            /*
                r9 = this;
                com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl.this = r10
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r0 = ""
                if (r13 == 0) goto L_0x0014
                java.lang.String r1 = "."
                java.lang.String r1 = a2.b.a.a.a.c3(r13, r1)
                if (r1 == 0) goto L_0x0014
                goto L_0x0015
            L_0x0014:
                r1 = r0
            L_0x0015:
                java.lang.String r2 = "RefreshComposite"
                java.lang.String r4 = a2.b.a.a.a.t(r10, r1, r2)
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r1 = "id = "
                r10.append(r1)
                r10.append(r11)
                if (r14 == 0) goto L_0x003b
                java.lang.String r1 = ", parentParams = ("
                java.lang.String r14 = t6.y.f.prependIndent(r14, r1)
                if (r14 == 0) goto L_0x003b
                java.lang.String r1 = ")"
                java.lang.String r14 = a2.b.a.a.a.c3(r14, r1)
                if (r14 == 0) goto L_0x003b
                r0 = r14
            L_0x003b:
                r10.append(r0)
                java.lang.String r5 = r10.toString()
                r6 = 0
                r7 = 4
                r8 = 0
                r3 = r9
                r3.<init>(r4, r5, r6, r7, r8)
                r9.e = r11
                r9.f = r13
                com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$RefreshComposite$a r10 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$RefreshComposite$a
                r10.<init>(r9)
                r9.d = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl.RefreshComposite.<init>(com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl, long, java.lang.String, java.lang.String):void");
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<ChannelsListInteractor.State>>> getBlock() {
            return this.d;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RefreshComposite(ChannelsListInteractorImpl channelsListInteractorImpl, long j, String str, String str2, int i, j jVar) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }
    }

    public static final boolean access$needToLogIn(ChannelsListInteractorImpl channelsListInteractorImpl, ChannelsListInteractor.State.Loading loading, ChannelsListInteractor.State.Loading... loadingArr) {
        Object obj;
        Object obj2;
        Objects.requireNonNull(channelsListInteractorImpl);
        if (loading instanceof ChannelsListInteractor.State.Loading.Error) {
            ErrorType.Companion companion = ErrorType.Companion;
            Throwable throwable = ((ChannelsListInteractor.State.Loading.Error) loading).getThrowable();
            if (throwable instanceof UnauthorizedException) {
                obj2 = ErrorType.Unauthorized.INSTANCE;
            } else if (throwable instanceof IOException) {
                obj2 = ErrorType.Network.INSTANCE;
            } else {
                obj2 = ErrorType.Other.INSTANCE;
            }
            if (obj2 == ErrorType.Unauthorized.INSTANCE) {
                return true;
            }
        }
        for (ChannelsListInteractor.State.Loading loading2 : loadingArr) {
            if (loading2 instanceof ChannelsListInteractor.State.Loading.Error) {
                ErrorType.Companion companion2 = ErrorType.Companion;
                Throwable throwable2 = ((ChannelsListInteractor.State.Loading.Error) loading2).getThrowable();
                if (throwable2 instanceof UnauthorizedException) {
                    obj = ErrorType.Unauthorized.INSTANCE;
                } else if (throwable2 instanceof IOException) {
                    obj = ErrorType.Network.INSTANCE;
                } else {
                    obj = ErrorType.Other.INSTANCE;
                }
                if (obj == ErrorType.Unauthorized.INSTANCE) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if ((r5 == com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE) != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean access$needToLogIn(com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl r5, com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State r6) {
        /*
            java.util.Objects.requireNonNull(r5)
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State$Loading r5 = r6.getInitialLoadingState()
            r0 = 2
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State$Loading[] r1 = new com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.Loading[r0]
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State$Loading r2 = r6.getRefreshState()
            r3 = 0
            r1[r3] = r2
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State$Loading r6 = r6.getNextPageLoadingState()
            r2 = 1
            r1[r2] = r6
            boolean r6 = r5 instanceof com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.Loading.Error
            if (r6 == 0) goto L_0x003e
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State$Loading$Error r5 = (com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.Loading.Error) r5
            com.avito.android.messenger.ErrorType$Companion r6 = com.avito.android.messenger.ErrorType.Companion
            java.lang.Throwable r5 = r5.getThrowable()
            boolean r6 = r5 instanceof com.avito.android.util.UnauthorizedException
            if (r6 == 0) goto L_0x002b
            com.avito.android.messenger.ErrorType$Unauthorized r5 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            goto L_0x0034
        L_0x002b:
            boolean r5 = r5 instanceof java.io.IOException
            if (r5 == 0) goto L_0x0032
            com.avito.android.messenger.ErrorType$Network r5 = com.avito.android.messenger.ErrorType.Network.INSTANCE
            goto L_0x0034
        L_0x0032:
            com.avito.android.messenger.ErrorType$Other r5 = com.avito.android.messenger.ErrorType.Other.INSTANCE
        L_0x0034:
            com.avito.android.messenger.ErrorType$Unauthorized r6 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            if (r5 != r6) goto L_0x003a
            r5 = 1
            goto L_0x003b
        L_0x003a:
            r5 = 0
        L_0x003b:
            if (r5 == 0) goto L_0x003e
            goto L_0x0068
        L_0x003e:
            r5 = 0
        L_0x003f:
            if (r5 >= r0) goto L_0x006d
            r6 = r1[r5]
            boolean r4 = r6 instanceof com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.Loading.Error
            if (r4 == 0) goto L_0x006a
            com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State$Loading$Error r6 = (com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.Loading.Error) r6
            com.avito.android.messenger.ErrorType$Companion r4 = com.avito.android.messenger.ErrorType.Companion
            java.lang.Throwable r6 = r6.getThrowable()
            boolean r4 = r6 instanceof com.avito.android.util.UnauthorizedException
            if (r4 == 0) goto L_0x0056
            com.avito.android.messenger.ErrorType$Unauthorized r6 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            goto L_0x005f
        L_0x0056:
            boolean r6 = r6 instanceof java.io.IOException
            if (r6 == 0) goto L_0x005d
            com.avito.android.messenger.ErrorType$Network r6 = com.avito.android.messenger.ErrorType.Network.INSTANCE
            goto L_0x005f
        L_0x005d:
            com.avito.android.messenger.ErrorType$Other r6 = com.avito.android.messenger.ErrorType.Other.INSTANCE
        L_0x005f:
            com.avito.android.messenger.ErrorType$Unauthorized r4 = com.avito.android.messenger.ErrorType.Unauthorized.INSTANCE
            if (r6 != r4) goto L_0x0065
            r6 = 1
            goto L_0x0066
        L_0x0065:
            r6 = 0
        L_0x0066:
            if (r6 == 0) goto L_0x006a
        L_0x0068:
            r3 = 1
            goto L_0x006d
        L_0x006a:
            int r5 = r5 + 1
            goto L_0x003f
        L_0x006d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl.access$needToLogIn(com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl, com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor$State):boolean");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelsListInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull ChannelSyncAgent channelSyncAgent, @NotNull ChannelRepoReader channelRepoReader, @NotNull UserLastActivitySyncAgent userLastActivitySyncAgent, @NotNull AnalyticsTimer<ChatListLoadingResult> analyticsTimer, @NotNull AnalyticsTimer<ChatListRefreshResult> analyticsTimer2, @NotNull MessengerGraphiteCounter messengerGraphiteCounter, @NotNull ChannelsTracker channelsTracker, @NotNull Analytics analytics, @NotNull OpenErrorTrackerScheduler openErrorTrackerScheduler, @NotNull ChannelsErrorInteractor channelsErrorInteractor, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, @Nullable @org.jetbrains.annotations.Nullable Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, @NotNull Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3, @NotNull ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup) {
        this(schedulersFactory, features, accountStateProvider, messengerClient, channelSyncAgent, channelRepoReader, userLastActivitySyncAgent, analyticsTimer, analyticsTimer2, messengerGraphiteCounter, channelsTracker, analytics, openErrorTrackerScheduler, channelsErrorInteractor, pair, pair2, pair3, manuallyExposedAbTestGroup, new SimpleReducerQueue(schedulersFactory.io(), "ChannelsInteractor"));
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(channelSyncAgent, "channelSyncAgent");
        Intrinsics.checkNotNullParameter(channelRepoReader, "channelRepoReader");
        Intrinsics.checkNotNullParameter(userLastActivitySyncAgent, "userLastActivitySyncAgent");
        Intrinsics.checkNotNullParameter(analyticsTimer, "loadingTimer");
        Intrinsics.checkNotNullParameter(analyticsTimer2, "refreshTimer");
        Intrinsics.checkNotNullParameter(messengerGraphiteCounter, "appendCounter");
        Intrinsics.checkNotNullParameter(channelsTracker, "perfTracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(openErrorTrackerScheduler, "openErrorTrackerScheduler");
        Intrinsics.checkNotNullParameter(channelsErrorInteractor, "channelsErrorInteractor");
        Intrinsics.checkNotNullParameter(pair, "mainTags");
        Intrinsics.checkNotNullParameter(pair3, "mergedTags");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "messengerFolderTabsTestGroup");
    }
}
