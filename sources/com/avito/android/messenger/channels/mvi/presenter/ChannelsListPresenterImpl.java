package com.avito.android.messenger.channels.mvi.presenter;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.ChatListLoadingException;
import com.avito.android.messenger.ChatListPaginationException;
import com.avito.android.messenger.ErrorType;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.channels.action_banner.ChannelsBanner;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor;
import com.avito.android.messenger.channels.mvi.view.AbstractListItem;
import com.avito.android.messenger.channels.mvi.view.ChannelListItem;
import com.avito.android.messenger.channels.mvi.view.ChannelsListBannerItem;
import com.avito.android.messenger.channels.mvi.view.PinnedSupportChatItem;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.util.Formatter;
import com.avito.android.util.LogsT;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.rxkotlin.DisposableKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0004wxyzB\u0001\u0012\u0006\u0010i\u001a\u00020\u0004\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010l\u001a\u00020\u0002\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010d\u001a\u00020a\u0012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020U0T\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010n\u001a\u00020m\u0012\f\u0010q\u001a\b\u0012\u0004\u0012\u00020p0o\u0012\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00040r¢\u0006\u0004\bt\u0010uBu\b\u0017\u0012\u0006\u0010i\u001a\u00020\u0004\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010l\u001a\u00020\u0002\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010d\u001a\u00020a\u0012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020U0T\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010n\u001a\u00020m\u0012\f\u0010q\u001a\b\u0012\u0004\u0012\u00020p0o¢\u0006\u0004\bt\u0010vJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001c\u0010\u000bJb\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'*\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100 2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020#0\"2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020%0\"H\u0001¢\u0006\u0004\b)\u0010*JD\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010%0+0'2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100 H\u0001¢\u0006\u0004\b)\u0010,Jb\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'*\b\u0012\u0004\u0012\u00020-0'2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100 2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020#0\"2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020%0\"H\u0001¢\u0006\u0004\b)\u0010.J6\u00100\u001a\b\u0012\u0004\u0012\u00020/0'*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010%0+0'2\u0006\u0010\u001f\u001a\u00020\u0010H\u0001¢\u0006\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0007098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001d\u0010B\u001a\u00020=8B@\u0002X\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00100G8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070G8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010I\u001a\u0004\bN\u0010KR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020U0T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006{"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenter;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverter;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "", "isRetry", "", "initialDataRequest", "(Z)V", "attach", "()V", "detach", "refresh", "refreshNotificationBannerState", "loadNextPage", "", "channelId", "deleteChannel", "(Ljava/lang/String;)V", "tryToUpdateAdBanner", "hideAdBanner", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", VKApiConst.POSITION, "onAdBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "onCleared", "", "Lcom/avito/android/remote/model/messenger/Channel;", "currentUserId", "", "typingChannelIds", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "lastMessagesFromDb", "Lru/avito/android/persistence/messenger/DraftEntity;", "drafts", "", "Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem;", "convertToListItems", "(Ljava/util/Collection;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "Lkotlin/Pair;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Set;)Ljava/util/List;", "Lru/avito/messenger/api/entity/Channel;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem;", "convertToPinnedSupportChatItems", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;", VKApiConst.VERSION, "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;", "channelsListInteractor", "u", "Z", "messengerFolderTabsEnabled", "Lkotlin/Function0;", "r", "Lkotlin/jvm/functions/Function0;", "notificationBannerCloseClickListener", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "s", "Lkotlin/Lazy;", "getErrorTracker", "()Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "errorTracker", "Lio/reactivex/disposables/CompositeDisposable;", "t", "Lio/reactivex/disposables/CompositeDisposable;", "lowerLayerSubscriptions", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", VKApiConst.Q, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getErrorMessageStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "errorMessageStream", "p", "getChannelDeletedStream", "channelDeletedStream", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactory;", "B", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactory;", "channelListAdBannerItemFactory", "Lcom/avito/android/util/Formatter;", "", "x", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/analytics/Analytics;", "y", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;", "adBannerInteractor", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;", "w", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;", "channelsBannerInteractor", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "z", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "perfTracker", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "channelsListDataConverter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverter;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactory;Lcom/avito/android/Features;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverter;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor;Lcom/avito/android/messenger/channels/mvi/presenter/ChannelListAdBannerItemFactory;Lcom/avito/android/Features;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", AuthSource.SEND_ABUSE, "NewAdBannerInteractorStateMutator", "NewChannelsBannerInteractorStateMutator", "NewChannelsInteractorStateMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListPresenterImpl extends BaseMviEntityWithReducerQueue<ChannelsListState> implements ChannelsListPresenter, ChannelsListDataConverter {
    public final ChatListAdBannerInteractor A;
    public final ChannelListAdBannerItemFactory B;
    public final /* synthetic */ ChannelsListDataConverter C;
    @NotNull
    public final SingleLiveEvent<Unit> p;
    @NotNull
    public final SingleLiveEvent<String> q;
    public final Function0<Unit> r;
    public final Lazy s;
    public final CompositeDisposable t;
    public final boolean u;
    public final ChannelsListInteractor v;
    public final ChannelsBannerInteractor w;
    public final Formatter<Throwable> x;
    public final Analytics y;
    public final ChannelsTracker z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl$NewAdBannerInteractorStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "d", "Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;", "interactorState", "<init>", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl;Lcom/avito/android/messenger/channels/mvi/interactor/ChatListAdBannerInteractor$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewAdBannerInteractorStateMutator extends Mutator<ChannelsListState> {
        public final ChatListAdBannerInteractor.State d;
        public final /* synthetic */ ChannelsListPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewAdBannerInteractorStateMutator(@NotNull ChannelsListPresenterImpl channelsListPresenterImpl, ChatListAdBannerInteractor.State state) {
            super(null, "interactorState = " + state, 1, null);
            Intrinsics.checkNotNullParameter(state, "interactorState");
            this.e = channelsListPresenterImpl;
            this.d = state;
        }

        @NotNull
        public ChannelsListState invoke(@NotNull ChannelsListState channelsListState) {
            Intrinsics.checkNotNullParameter(channelsListState, "oldState");
            ChatListAdBannerInteractor.State state = this.d;
            ChannelListAdBannerItem channelListAdBannerItem = channelsListState.adBannerItem;
            ChannelListAdBannerItem create = this.e.B.create(state.getBanner());
            Iterator<AbstractListItem<?>> it = channelsListState.listItems.iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next() instanceof ChannelListAdBannerItem) {
                    break;
                } else {
                    i++;
                }
            }
            if (!(!Intrinsics.areEqual(channelListAdBannerItem, create)) && this.d.getChatListOffset() == channelsListState.adBannerItemOffset && (i >= 0 || !(!channelsListState.listItems.isEmpty()))) {
                return channelsListState;
            }
            if (!(!channelsListState.listItems.isEmpty())) {
                return ChannelsListState.copy$default(channelsListState, null, false, false, null, false, false, false, false, null, create, this.d.getChatListOffset(), 511, null);
            }
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) channelsListState.listItems);
            if (i >= 0) {
                z = true;
            }
            if (z) {
                mutableList.remove(i);
            }
            if (create != null) {
                int chatListOffset = this.d.getChatListOffset();
                if (mutableList.size() < chatListOffset) {
                    chatListOffset = mutableList.size();
                }
                mutableList.add(chatListOffset, create);
            }
            return ChannelsListState.copy$default(channelsListState, null, false, false, null, false, false, false, false, mutableList, create, this.d.getChatListOffset(), 255, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl$NewChannelsBannerInteractorStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;", "d", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;", "interactorState", "<init>", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsBannerInteractor$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewChannelsBannerInteractorStateMutator extends Mutator<ChannelsListState> {
        public final ChannelsBannerInteractor.State d;
        public final /* synthetic */ ChannelsListPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewChannelsBannerInteractorStateMutator(@NotNull ChannelsListPresenterImpl channelsListPresenterImpl, ChannelsBannerInteractor.State state) {
            super(null, "interactorState = " + state, 1, null);
            Intrinsics.checkNotNullParameter(state, "interactorState");
            this.e = channelsListPresenterImpl;
            this.d = state;
        }

        @NotNull
        public ChannelsListState invoke(@NotNull ChannelsListState channelsListState) {
            T t;
            Intrinsics.checkNotNullParameter(channelsListState, "oldState");
            ChannelsBannerInteractor.State state = this.d;
            Iterator<T> it = channelsListState.listItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t instanceof ChannelsListBannerItem) {
                    break;
                }
            }
            T t2 = t;
            ChannelsBanner.NotificationsSettings notificationsSettings = state.notificationBanner;
            if (notificationsSettings != null && t2 == null) {
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ChannelsListBannerItem("ChannelsListBannerItem", notificationsSettings.getMessageId(), state.notificationBanner.getActionId(), state.notificationBanner.getImageId(), this.e.r));
                mutableListOf.addAll(channelsListState.listItems);
                return ChannelsListState.copy$default(channelsListState, null, false, false, null, false, false, false, false, mutableListOf, null, 0, 1791, null);
            } else if (notificationsSettings != null || t2 == null) {
                return channelsListState;
            } else {
                List<AbstractListItem<?>> list = channelsListState.listItems;
                ArrayList arrayList = new ArrayList();
                for (T t3 : list) {
                    if (!(t3 instanceof ChannelsListBannerItem)) {
                        arrayList.add(t3);
                    }
                }
                return ChannelsListState.copy$default(channelsListState, null, false, false, null, false, false, false, false, arrayList, null, 0, 1791, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl$NewChannelsInteractorStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "oldState", "invoke", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsInteractorState;", "d", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;", "interactorState", "<init>", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListPresenterImpl;Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractor$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewChannelsInteractorStateMutator extends Mutator<ChannelsListState> {
        public final ChannelsListInteractor.State d;
        public final /* synthetic */ ChannelsListPresenterImpl e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewChannelsInteractorStateMutator(@NotNull ChannelsListPresenterImpl channelsListPresenterImpl, ChannelsListInteractor.State state) {
            super(null, "interactorState = " + state, 1, null);
            Intrinsics.checkNotNullParameter(state, "interactorState");
            this.e = channelsListPresenterImpl;
            this.d = state;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:110:0x01eb, code lost:
            if ((r2.getNextPageLoadingState() instanceof com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.Loading.Error) != false) goto L_0x01ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
            if ((r2.getNextPageLoadingState() instanceof com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor.State.Loading.InProgress) == false) goto L_0x0043;
         */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x01e0  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x01e5  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x01fc  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x007b A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x010d  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01aa  */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState r18) {
            /*
            // Method dump skipped, instructions count: 592
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenterImpl.NewChannelsInteractorStateMutator.invoke(com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState):com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState");
        }
    }

    public static final class a implements ShouldCancelChecker<ChannelsListState> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<ChannelsListState> reducible, @NotNull Reducible<ChannelsListState> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof NewChannelsInteractorStateMutator) {
                if (reducible2 instanceof NewChannelsInteractorStateMutator) {
                    return true;
                }
            } else if (reducible instanceof NewChannelsBannerInteractorStateMutator) {
                if (reducible2 instanceof NewChannelsBannerInteractorStateMutator) {
                    return true;
                }
            } else if ((reducible instanceof NewAdBannerInteractorStateMutator) && (reducible2 instanceof NewAdBannerInteractorStateMutator)) {
                return true;
            }
            return false;
        }
    }

    public static final class b extends Lambda implements Function0<MessengerErrorTracker> {
        public final /* synthetic */ ChannelsListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ChannelsListPresenterImpl channelsListPresenterImpl) {
            super(0);
            this.a = channelsListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public MessengerErrorTracker invoke() {
            return new MessengerErrorTracker(this.a.y);
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChannelsListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ChannelsListPresenterImpl channelsListPresenterImpl) {
            super(0);
            this.a = channelsListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.w.dismissNotificationBanner();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsListPresenterImpl(@NotNull ChannelsListState channelsListState, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelsListDataConverter channelsListDataConverter, @NotNull ChannelsListInteractor channelsListInteractor, @NotNull ChannelsBannerInteractor channelsBannerInteractor, @NotNull Formatter<Throwable> formatter, @NotNull Analytics analytics, @NotNull ChannelsTracker channelsTracker, @NotNull ChatListAdBannerInteractor chatListAdBannerInteractor, @NotNull ChannelListAdBannerItemFactory channelListAdBannerItemFactory, @NotNull Features features, @NotNull ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup, @NotNull ReducerQueue<ChannelsListState> reducerQueue) {
        super("ChannelsPresenter", channelsListState, schedulersFactory, a.a, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(channelsListState, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelsListDataConverter, "channelsListDataConverter");
        Intrinsics.checkNotNullParameter(channelsListInteractor, "channelsListInteractor");
        Intrinsics.checkNotNullParameter(channelsBannerInteractor, "channelsBannerInteractor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(channelsTracker, "perfTracker");
        Intrinsics.checkNotNullParameter(chatListAdBannerInteractor, "adBannerInteractor");
        Intrinsics.checkNotNullParameter(channelListAdBannerItemFactory, "channelListAdBannerItemFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "messengerFolderTabsTestGroup");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.C = channelsListDataConverter;
        this.v = channelsListInteractor;
        this.w = channelsBannerInteractor;
        this.x = formatter;
        this.y = analytics;
        this.z = channelsTracker;
        this.A = chatListAdBannerInteractor;
        this.B = channelListAdBannerItemFactory;
        this.p = new SingleLiveEvent<>();
        this.q = new SingleLiveEvent<>();
        this.r = new c(this);
        this.s = t6.c.lazy(new b(this));
        this.t = new CompositeDisposable();
        boolean isTest = manuallyExposedAbTestGroup.getTestGroup().isTest();
        this.u = isTest;
        LogsT.verbose$default(getTAG(), "child init block", null, 4, null);
        if (!isTest) {
            LogsT.verbose$default(getTAG(), "setupLowerLayerSubscriptions()", null, 4, null);
            Scheduler io2 = getSchedulers().io();
            CompositeDisposable compositeDisposable = this.t;
            SharedScheduler sharedScheduler = new SharedScheduler(io2);
            compositeDisposable.add(Disposables.fromAction(new ChannelsListPresenterImpl$inlined$sam$i$io_reactivex_functions_Action$0(new Function0<Unit>(sharedScheduler) { // from class: com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenterImpl$setupLowerLayerSubscriptions$$inlined$toShared$3
                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ((SharedScheduler) this.receiver).shutdown();
                }
            })));
            Disposable subscribe = this.v.getStateObservable().observeOn(sharedScheduler).scan(new ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$1(this)).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$2(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "channelsInteractor.stateObservable")));
            Intrinsics.checkNotNullExpressionValue(subscribe, "channelsListInteractor.s…bservable\")\n            )");
            DisposableKt.addTo(subscribe, this.t);
            Disposable subscribe2 = this.w.getStateObservable().observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToBannerInteractorStateUpdates$1(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "channelsBannerInteractor.stateObservable")));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "channelsBannerInteractor…bservable\")\n            )");
            DisposableKt.addTo(subscribe2, this.t);
            Disposable subscribe3 = this.A.getStateObservable().observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToAdBannerInteractorStateUpdates$1(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "adBannerInteractor.stateObservable")));
            Intrinsics.checkNotNullExpressionValue(subscribe3, "adBannerInteractor.state…bservable\")\n            )");
            DisposableKt.addTo(subscribe3, this.t);
            Disposable subscribe4 = this.v.getChannelDeleteResultStream().observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToChannelDeleteResults$1(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "channelsInteractor.channelDeleteResultStream")));
            Intrinsics.checkNotNullExpressionValue(subscribe4, "channelsListInteractor.c…ultStream\")\n            )");
            DisposableKt.addTo(subscribe4, this.t);
        }
    }

    public static final ChannelsListState.SnackbarState access$generateSnackbarState(ChannelsListPresenterImpl channelsListPresenterImpl, ChannelsListInteractor.State.Loading... loadingArr) {
        Object obj;
        ChannelsListState.SnackbarState snackbarState;
        Objects.requireNonNull(channelsListPresenterImpl);
        ChannelsListState.SnackbarState snackbarState2 = ChannelsListState.SnackbarState.Hidden.INSTANCE;
        for (ChannelsListInteractor.State.Loading loading : loadingArr) {
            if (loading instanceof ChannelsListInteractor.State.Loading.Error) {
                Throwable throwable = ((ChannelsListInteractor.State.Loading.Error) loading).getThrowable();
                ErrorType.Companion companion = ErrorType.Companion;
                if (throwable instanceof UnauthorizedException) {
                    obj = ErrorType.Unauthorized.INSTANCE;
                } else if (throwable instanceof IOException) {
                    obj = ErrorType.Network.INSTANCE;
                } else {
                    obj = ErrorType.Other.INSTANCE;
                }
                Pair pair = TuplesKt.to(obj, channelsListPresenterImpl.x.format(throwable));
                ErrorType errorType = (ErrorType) pair.getFirst();
                if (Intrinsics.areEqual(errorType, ErrorType.Network.INSTANCE)) {
                    snackbarState = ChannelsListState.SnackbarState.Error.Network.INSTANCE;
                } else if (Intrinsics.areEqual(errorType, ErrorType.Other.INSTANCE)) {
                    snackbarState = new ChannelsListState.SnackbarState.Error.Unknown((String) pair.getSecond());
                } else if (Intrinsics.areEqual(errorType, ErrorType.Unauthorized.INSTANCE)) {
                    snackbarState = ChannelsListState.SnackbarState.Hidden.INSTANCE;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (Intrinsics.compare(snackbarState.getPriority(), snackbarState2.getPriority()) > 0) {
                    snackbarState2 = snackbarState;
                }
            }
        }
        return snackbarState2;
    }

    public static final MessengerErrorTracker access$getErrorTracker$p(ChannelsListPresenterImpl channelsListPresenterImpl) {
        return (MessengerErrorTracker) channelsListPresenterImpl.s.getValue();
    }

    public static final void access$insertAdBannerIntoListItems(ChannelsListPresenterImpl channelsListPresenterImpl, List list, AbstractListItem abstractListItem, int i) {
        Objects.requireNonNull(channelsListPresenterImpl);
        if (list.size() < i) {
            i = list.size();
        }
        list.add(i, abstractListItem);
    }

    public static final Function1 access$logError(ChannelsListPresenterImpl channelsListPresenterImpl, String str) {
        Objects.requireNonNull(channelsListPresenterImpl);
        return new ChannelsListPresenterImpl$logError$1(channelsListPresenterImpl, str);
    }

    public static final void access$subscribeToAdBannerInteractorStateUpdates(ChannelsListPresenterImpl channelsListPresenterImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListPresenterImpl);
        Disposable subscribe = channelsListPresenterImpl.A.getStateObservable().observeOn(scheduler).subscribeOn(scheduler).subscribe(new ChannelsListPresenterImpl$subscribeToAdBannerInteractorStateUpdates$1(channelsListPresenterImpl), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(channelsListPresenterImpl, "adBannerInteractor.stateObservable")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "adBannerInteractor.state…bservable\")\n            )");
        DisposableKt.addTo(subscribe, channelsListPresenterImpl.t);
    }

    public static final void access$subscribeToBannerInteractorStateUpdates(ChannelsListPresenterImpl channelsListPresenterImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListPresenterImpl);
        Disposable subscribe = channelsListPresenterImpl.w.getStateObservable().observeOn(scheduler).subscribeOn(scheduler).subscribe(new ChannelsListPresenterImpl$subscribeToBannerInteractorStateUpdates$1(channelsListPresenterImpl), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(channelsListPresenterImpl, "channelsBannerInteractor.stateObservable")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "channelsBannerInteractor…bservable\")\n            )");
        DisposableKt.addTo(subscribe, channelsListPresenterImpl.t);
    }

    public static final void access$subscribeToChannelDeleteResults(ChannelsListPresenterImpl channelsListPresenterImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListPresenterImpl);
        Disposable subscribe = channelsListPresenterImpl.v.getChannelDeleteResultStream().observeOn(scheduler).subscribeOn(scheduler).subscribe(new ChannelsListPresenterImpl$subscribeToChannelDeleteResults$1(channelsListPresenterImpl), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(channelsListPresenterImpl, "channelsInteractor.channelDeleteResultStream")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "channelsListInteractor.c…ultStream\")\n            )");
        DisposableKt.addTo(subscribe, channelsListPresenterImpl.t);
    }

    public static final void access$subscribeToChannelsInteractorUpdates(ChannelsListPresenterImpl channelsListPresenterImpl, Scheduler scheduler) {
        Objects.requireNonNull(channelsListPresenterImpl);
        Disposable subscribe = channelsListPresenterImpl.v.getStateObservable().observeOn(scheduler).scan(new ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$1(channelsListPresenterImpl)).subscribeOn(scheduler).subscribe(new ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$2(channelsListPresenterImpl), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(channelsListPresenterImpl, "channelsInteractor.stateObservable")));
        Intrinsics.checkNotNullExpressionValue(subscribe, "channelsListInteractor.s…bservable\")\n            )");
        DisposableKt.addTo(subscribe, channelsListPresenterImpl.t);
    }

    public static final Pair access$toErrorMetaInfo(ChannelsListPresenterImpl channelsListPresenterImpl, Throwable th) {
        Object obj;
        Objects.requireNonNull(channelsListPresenterImpl);
        ErrorType.Companion companion = ErrorType.Companion;
        if (th instanceof UnauthorizedException) {
            obj = ErrorType.Unauthorized.INSTANCE;
        } else if (th instanceof IOException) {
            obj = ErrorType.Network.INSTANCE;
        } else {
            obj = ErrorType.Other.INSTANCE;
        }
        return TuplesKt.to(obj, channelsListPresenterImpl.x.format(th));
    }

    public static final ChannelsListState.SnackbarState access$toSnackbarState(ChannelsListPresenterImpl channelsListPresenterImpl, Throwable th) {
        Object obj;
        Objects.requireNonNull(channelsListPresenterImpl);
        ErrorType.Companion companion = ErrorType.Companion;
        if (th instanceof UnauthorizedException) {
            obj = ErrorType.Unauthorized.INSTANCE;
        } else if (th instanceof IOException) {
            obj = ErrorType.Network.INSTANCE;
        } else {
            obj = ErrorType.Other.INSTANCE;
        }
        Pair pair = TuplesKt.to(obj, channelsListPresenterImpl.x.format(th));
        ErrorType errorType = (ErrorType) pair.getFirst();
        if (Intrinsics.areEqual(errorType, ErrorType.Network.INSTANCE)) {
            return ChannelsListState.SnackbarState.Error.Network.INSTANCE;
        }
        if (Intrinsics.areEqual(errorType, ErrorType.Other.INSTANCE)) {
            return new ChannelsListState.SnackbarState.Error.Unknown((String) pair.getSecond());
        }
        if (Intrinsics.areEqual(errorType, ErrorType.Unauthorized.INSTANCE)) {
            return ChannelsListState.SnackbarState.Hidden.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void access$trackErrors(ChannelsListPresenterImpl channelsListPresenterImpl, ChannelsListInteractor.State state, ChannelsListInteractor.State state2) {
        Objects.requireNonNull(channelsListPresenterImpl);
        if (!(state.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.Error) && (state2.getInitialLoadingState() instanceof ChannelsListInteractor.State.Loading.Error)) {
            ErrorTracker.DefaultImpls.track$default(access$getErrorTracker$p(channelsListPresenterImpl), new ChatListLoadingException("Failed to load channels list", ((ChannelsListInteractor.State.Loading.Error) state2.getInitialLoadingState()).getThrowable()), null, q.mapOf(TuplesKt.to("isRefresh", Boolean.FALSE)), 2, null);
        }
        if (!(state.getNextPageLoadingState() instanceof ChannelsListInteractor.State.Loading.Error) && (state2.getNextPageLoadingState() instanceof ChannelsListInteractor.State.Loading.Error)) {
            ErrorTracker.DefaultImpls.track$default(access$getErrorTracker$p(channelsListPresenterImpl), new ChatListPaginationException("Failed to load next page of channels list", ((ChannelsListInteractor.State.Loading.Error) state2.getNextPageLoadingState()).getThrowable()), null, null, 6, null);
        }
        if (!(state.getRefreshState() instanceof ChannelsListInteractor.State.Loading.Error) && (state2.getRefreshState() instanceof ChannelsListInteractor.State.Loading.Error)) {
            ErrorTracker.DefaultImpls.track$default(access$getErrorTracker$p(channelsListPresenterImpl), new ChatListLoadingException("Failed to refresh channels list", ((ChannelsListInteractor.State.Loading.Error) state2.getRefreshState()).getThrowable()), null, q.mapOf(TuplesKt.to("isRefresh", Boolean.TRUE)), 2, null);
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void attach() {
        if (this.u) {
            LogsT.verbose$default(getTAG(), "setupLowerLayerSubscriptions()", null, 4, null);
            Scheduler io2 = getSchedulers().io();
            CompositeDisposable compositeDisposable = this.t;
            SharedScheduler sharedScheduler = new SharedScheduler(io2);
            compositeDisposable.add(Disposables.fromAction(new ChannelsListPresenterImpl$inlined$sam$i$io_reactivex_functions_Action$0(new Function0<Unit>(sharedScheduler) { // from class: com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenterImpl$setupLowerLayerSubscriptions$$inlined$toShared$1
                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ((SharedScheduler) this.receiver).shutdown();
                }
            })));
            Disposable subscribe = this.v.getStateObservable().observeOn(sharedScheduler).scan(new ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$1(this)).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToChannelsInteractorUpdates$2(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "channelsInteractor.stateObservable")));
            Intrinsics.checkNotNullExpressionValue(subscribe, "channelsListInteractor.s…bservable\")\n            )");
            DisposableKt.addTo(subscribe, this.t);
            Disposable subscribe2 = this.w.getStateObservable().observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToBannerInteractorStateUpdates$1(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "channelsBannerInteractor.stateObservable")));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "channelsBannerInteractor…bservable\")\n            )");
            DisposableKt.addTo(subscribe2, this.t);
            Disposable subscribe3 = this.A.getStateObservable().observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToAdBannerInteractorStateUpdates$1(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "adBannerInteractor.stateObservable")));
            Intrinsics.checkNotNullExpressionValue(subscribe3, "adBannerInteractor.state…bservable\")\n            )");
            DisposableKt.addTo(subscribe3, this.t);
            Disposable subscribe4 = this.v.getChannelDeleteResultStream().observeOn(sharedScheduler).subscribeOn(sharedScheduler).subscribe(new ChannelsListPresenterImpl$subscribeToChannelDeleteResults$1(this), new ChannelsListPresenterKt$sam$i$io_reactivex_functions_Consumer$0(new ChannelsListPresenterImpl$logError$1(this, "channelsInteractor.channelDeleteResultStream")));
            Intrinsics.checkNotNullExpressionValue(subscribe4, "channelsListInteractor.c…ultStream\")\n            )");
            DisposableKt.addTo(subscribe4, this.t);
            this.v.subscribe();
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @NotNull
    public List<ChannelListItem> convertToListItems(@NotNull Collection<Channel> collection, @NotNull String str, @NotNull Set<String> set, @NotNull Map<String, LocalMessage> map, @NotNull Map<String, DraftEntity> map2) {
        Intrinsics.checkNotNullParameter(collection, "$this$convertToListItems");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(set, "typingChannelIds");
        Intrinsics.checkNotNullParameter(map, "lastMessagesFromDb");
        Intrinsics.checkNotNullParameter(map2, "drafts");
        return this.C.convertToListItems(collection, str, set, map, map2);
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @NotNull
    public List<ChannelListItem> convertToListItems(@NotNull List<Pair<Channel, DraftEntity>> list, @NotNull String str, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(list, "$this$convertToListItems");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(set, "typingChannelIds");
        return this.C.convertToListItems(list, str, set);
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @NotNull
    public List<ChannelListItem> convertToListItems(@NotNull List<ru.avito.messenger.api.entity.Channel> list, @NotNull String str, @NotNull Set<String> set, @NotNull Map<String, LocalMessage> map, @NotNull Map<String, DraftEntity> map2) {
        Intrinsics.checkNotNullParameter(list, "$this$convertToListItems");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(set, "typingChannelIds");
        Intrinsics.checkNotNullParameter(map, "lastMessagesFromDb");
        Intrinsics.checkNotNullParameter(map2, "drafts");
        return this.C.convertToListItems(list, str, set, map, map2);
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @NotNull
    public List<PinnedSupportChatItem> convertToPinnedSupportChatItems(@NotNull List<Pair<Channel, DraftEntity>> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "$this$convertToPinnedSupportChatItems");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        return this.C.convertToPinnedSupportChatItems(list, str);
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void deleteChannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        this.v.deleteChannel(str);
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void detach() {
        if (this.u) {
            this.v.unsubscribe();
            this.t.clear();
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void hideAdBanner() {
        this.A.hideBanner();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void initialDataRequest(boolean z2) {
        this.v.initialDataRequest(z2);
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void loadNextPage() {
        this.v.requestNextPage();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void onAdBannerOpened(@NotNull BannerInfo bannerInfo, int i) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.A.sendBannerOpened(bannerInfo, i);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.t.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void refresh() {
        this.v.refresh();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void refreshNotificationBannerState() {
        this.w.refreshNotificationBannerState();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    public void tryToUpdateAdBanner() {
        this.A.tryToUpdateBanner();
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    @NotNull
    public SingleLiveEvent<Unit> getChannelDeletedStream() {
        return this.p;
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter
    @NotNull
    public SingleLiveEvent<String> getErrorMessageStream() {
        return this.q;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelsListPresenterImpl(@NotNull ChannelsListState channelsListState, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelsListDataConverter channelsListDataConverter, @NotNull ChannelsListInteractor channelsListInteractor, @NotNull ChannelsBannerInteractor channelsBannerInteractor, @NotNull Formatter<Throwable> formatter, @NotNull Analytics analytics, @NotNull ChannelsTracker channelsTracker, @NotNull ChatListAdBannerInteractor chatListAdBannerInteractor, @NotNull ChannelListAdBannerItemFactory channelListAdBannerItemFactory, @NotNull Features features, @NotNull ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup) {
        this(channelsListState, schedulersFactory, channelsListDataConverter, channelsListInteractor, channelsBannerInteractor, formatter, analytics, channelsTracker, chatListAdBannerInteractor, channelListAdBannerItemFactory, features, manuallyExposedAbTestGroup, new SimpleReducerQueue(schedulersFactory.io(), "ChannelsPresenter"));
        Intrinsics.checkNotNullParameter(channelsListState, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelsListDataConverter, "channelsListDataConverter");
        Intrinsics.checkNotNullParameter(channelsListInteractor, "channelsListInteractor");
        Intrinsics.checkNotNullParameter(channelsBannerInteractor, "channelsBannerInteractor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(channelsTracker, "perfTracker");
        Intrinsics.checkNotNullParameter(chatListAdBannerInteractor, "adBannerInteractor");
        Intrinsics.checkNotNullParameter(channelListAdBannerItemFactory, "channelListAdBannerItemFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "messengerFolderTabsTestGroup");
    }
}
