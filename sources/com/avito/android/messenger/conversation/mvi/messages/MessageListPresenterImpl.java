package com.avito.android.messenger.conversation.mvi.messages;

import a2.a.a.o1.d.a0.i.b;
import a2.a.a.o1.d.a0.i.n;
import a2.a.a.o1.d.a0.i.o;
import a2.a.a.o1.d.a0.i.p;
import a2.g.r.g;
import android.net.Uri;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.WorkInfo;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.Some;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.messenger.MessageListInconsistentStateException;
import com.avito.android.messenger.analytics.MessengerCopyPlatformMessageTextEvent;
import com.avito.android.messenger.analytics.MessengerLinkClick;
import com.avito.android.messenger.analytics.OpenUserProfileEvent;
import com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v3.BaseEffect;
import com.avito.android.messenger.channels.mvi.common.v3.BaseEntityDeps;
import com.avito.android.messenger.channels.mvi.common.v3.BaseEventDeps;
import com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents;
import com.avito.android.messenger.channels.mvi.common.v3.EventCommand;
import com.avito.android.messenger.channels.mvi.common.v3.EventInstance;
import com.avito.android.messenger.channels.mvi.common.v3.ShouldCancelChecker;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManager;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import com.avito.android.messenger.conversation.mvi.messages.LatestReadMessageBeforeOpen;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import com.avito.android.messenger.conversation.mvi.messages.MessageListView;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.ChatAvatar;
import com.avito.android.remote.model.messenger.PublicProfile;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context.ChatReplyTime;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.DummyActionModeCallback;
import com.avito.android.util.Formatter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Uris;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.common.net.HttpHeaders;
import com.vk.sdk.api.VKApiConst;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.n.d;
import t6.n.i;
import t6.n.q;
import t6.n.x;
import t6.r.a.j;
import t6.y.f;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u00020\u00072\u00020\b:\u000e\u0001\u0001\u0001\u0001\u0001\u0001\u0001B\u001b\u0012\u0007\u0010\u0001\u001a\u00020\u0004\u0012\u0007\u0010\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ)\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\u000bJ'\u0010%\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b'\u0010&J#\u0010,\u001a\u00020+2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020.2\u0006\u0010/\u001a\u00020+H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\tH\u0016¢\u0006\u0004\b2\u0010\u000bJ!\u00105\u001a\u00020\u0004*\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000303H\u0016¢\u0006\u0004\b5\u00106J0\u0010;\u001a\u00020+2\u000e\u00108\u001a\n 7*\u0004\u0018\u00010(0(2\u000e\u0010:\u001a\n 7*\u0004\u0018\u00010909H\u0001¢\u0006\u0004\b;\u0010<J \u0010=\u001a\u00020\t2\u000e\u00108\u001a\n 7*\u0004\u0018\u00010(0(H\u0001¢\u0006\u0004\b=\u0010>J0\u0010?\u001a\u00020+2\u000e\u00108\u001a\n 7*\u0004\u0018\u00010(0(2\u000e\u0010:\u001a\n 7*\u0004\u0018\u00010909H\u0001¢\u0006\u0004\b?\u0010<R4\u0010H\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020B\u0012\u0006\u0012\u0004\u0018\u00010#0Aj\u0002`C0@8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR4\u0010L\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110Aj\u0002`I0@8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010GR\"\u0010R\u001a\b\u0012\u0004\u0012\u00020M038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020T0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\"\u0010]\u001a\b\u0012\u0004\u0012\u00020Z0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010XR\"\u0010`\u001a\b\u0012\u0004\u0012\u00020\t0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b^\u0010V\u001a\u0004\b_\u0010XR\"\u0010c\u001a\b\u0012\u0004\u0012\u00020#0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\ba\u0010V\u001a\u0004\bb\u0010XR\"\u0010f\u001a\b\u0012\u0004\u0012\u00020\t0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bd\u0010V\u001a\u0004\be\u0010XR\"\u0010j\u001a\b\u0012\u0004\u0012\u00020g0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bh\u0010V\u001a\u0004\bi\u0010XR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\"\u0010u\u001a\b\u0012\u0004\u0012\u00020\t0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bs\u0010V\u001a\u0004\bt\u0010XR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\"\u0010}\u001a\b\u0012\u0004\u0012\u00020z0S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b{\u0010V\u001a\u0004\b|\u0010XR\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010S8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010V\u001a\u0005\b\u0001\u0010XR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020#0S8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010V\u001a\u0005\b\u0001\u0010X¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl;", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseMviEntityWithEvents;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Deps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "Landroid/view/ActionMode$Callback;", "", "refresh", "()V", "startPagination", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "metaInfo", "onMessageClick", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "message", "onAvatarClicked", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "onAppCallMessageClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onFileMessageCancelClicked", "Lcom/avito/android/messenger/conversation/ChannelItem$PaginationError;", "item", "onRetryPaginationClicked", "(Lcom/avito/android/messenger/conversation/ChannelItem$PaginationError;)V", "callUser", "", "url", "onMessageLinkClicked", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)V", "onMessageLinkLongClicked", "Landroid/view/ActionMode;", "mode", "Landroid/view/MenuItem;", "", "onActionItemClicked", "(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "isSpam", "onSpamActionClicked", "(Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;Z)V", "userInteractedWithList", "", "partialStates", "applyPartialStates", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;Ljava/util/Set;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;", "kotlin.jvm.PlatformType", "p0", "Landroid/view/Menu;", "p1", "onCreateActionMode", "(Landroid/view/ActionMode;Landroid/view/Menu;)Z", "onDestroyActionMode", "(Landroid/view/ActionMode;)V", "onPrepareActionMode", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "Landroid/net/Uri;", "Lcom/avito/android/messenger/conversation/mvi/messages/UriAndMimeType;", "z", "Landroidx/lifecycle/LiveData;", "getFileMessageClickedStream", "()Landroidx/lifecycle/LiveData;", "fileMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "F", "getRequestPermissionsForFileMessageStream", "requestPermissionsForFileMessageStream", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Effect$StartLoadingOnNewUserId;", "G", "Ljava/util/Set;", "getEffects", "()Ljava/util/Set;", "effects", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/messenger/conversation/mvi/messages/OpenGalleryData;", VKApiConst.VERSION, "Landroidx/lifecycle/MutableLiveData;", "getImageMessageClickedStream", "()Landroidx/lifecycle/MutableLiveData;", "imageMessageClickedStream", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "y", "getLocationMessageClickedStream", "locationMessageClickedStream", "B", "getSystemUserAvatarClickedStream", "systemUserAvatarClickedStream", "x", "getLinkMessageWithUrlClickedStream", "linkMessageWithUrlClickedStream", "w", "getUnknownMessageClickedStream", "unknownMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/PlatformMapData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getPlatformMapMessageClickedStream", "platformMapMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "o", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "metaState", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "t", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "listSpamActionsState", ExifInterface.LONGITUDE_EAST, "getFileDownloadFailsStream", "fileDownloadFailsStream", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "p", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextState", "Lcom/avito/android/messenger/conversation/mvi/messages/ItemMessageInfo;", "u", "getItemMessageClickedStream", "itemMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", VKApiConst.Q, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopState", "Lcom/avito/android/messenger/conversation/mvi/messages/LinkMenuData;", "C", "getShowMenuForTextLinkStream", "showMenuForTextLinkStream", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "r", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleState", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "s", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomState", "D", "getErrorMessageStream", "errorMessageStream", "defaultState", "deps", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Deps;)V", "AggregatedState", "CommandCancelChecker", "Deps", "Effect", "Event", "EventDeps", "PartialState", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageListPresenterImpl extends BaseMviEntityWithEvents<Event, PartialState, AggregatedState, MessageListView.State, Deps> implements MessageListPresenter, ActionMode.Callback {
    @NotNull
    public final MutableLiveData<PlatformMapData> A;
    @NotNull
    public final MutableLiveData<Unit> B;
    @NotNull
    public final MutableLiveData<LinkMenuData> C;
    @NotNull
    public final MutableLiveData<String> D;
    @NotNull
    public final MutableLiveData<Unit> E;
    @NotNull
    public final LiveData<Pair<LocalMessage, MessageMetaInfo>> F;
    @NotNull
    public final Set<Effect.StartLoadingOnNewUserId> G;
    public final /* synthetic */ DummyActionModeCallback H = DummyActionModeCallback.INSTANCE;
    public volatile PartialState.Meta o;
    public volatile PartialState.Context p;
    public volatile PartialState.List.Top q;
    public volatile PartialState.List.Middle r;
    public volatile PartialState.List.Bottom s;
    public volatile PartialState.List.SpamActions t;
    @NotNull
    public final MutableLiveData<ItemMessageInfo> u;
    @NotNull
    public final MutableLiveData<OpenGalleryData> v;
    @NotNull
    public final MutableLiveData<Unit> w;
    @NotNull
    public final MutableLiveData<String> x;
    @NotNull
    public final MutableLiveData<MessageBody.Location> y;
    @NotNull
    public final LiveData<Pair<Uri, String>> z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ?\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0004\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$CommandCancelChecker;", "Lcom/avito/android/messenger/channels/mvi/common/v3/ShouldCancelChecker;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventCommand;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "command", "other", "", "shouldCancel", "(Lcom/avito/android/messenger/channels/mvi/common/v3/EventCommand;Lcom/avito/android/messenger/channels/mvi/common/v3/EventCommand;)Z", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CommandCancelChecker implements ShouldCancelChecker<EventCommand<? extends Event, ?, ?>> {
        @NotNull
        public static final CommandCancelChecker INSTANCE = new CommandCancelChecker();

        public boolean shouldCancel(@NotNull EventCommand<? extends Event, ?, ?> eventCommand, @NotNull EventCommand<? extends Event, ?, ?> eventCommand2) {
            Intrinsics.checkNotNullParameter(eventCommand, "command");
            Intrinsics.checkNotNullParameter(eventCommand2, "other");
            Event event = (Event) eventCommand.getTypeObj();
            Event.ScreenOpened screenOpened = Event.ScreenOpened.INSTANCE;
            if (Intrinsics.areEqual(event, screenOpened)) {
                Event event2 = (Event) eventCommand2.getTypeObj();
                if (!Intrinsics.areEqual(event2, screenOpened)) {
                    if (!Intrinsics.areEqual(event2, Event.EmptyContext.INSTANCE) && !Intrinsics.areEqual(event2, Event.LoadedContext.INSTANCE) && !Intrinsics.areEqual(event2, Event.LoadedOnlyUserId.INSTANCE) && !Intrinsics.areEqual(event2, Event.ContextLoadingError.INSTANCE) && !Intrinsics.areEqual(event2, Event.Refresh.INSTANCE) && !Intrinsics.areEqual(event2, Event.MessagesLoadingStart.INSTANCE) && !Intrinsics.areEqual(event2, Event.MessagesLoadedEmpty.INSTANCE) && !Intrinsics.areEqual(event2, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event2, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event2, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event2, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event2, Event.PaginationError.INSTANCE) && !Intrinsics.areEqual(event2, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event2, Event.UsersFinishedTyping.INSTANCE) && !Intrinsics.areEqual(event2, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event2, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event2, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event2, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event2, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event2, Event.SyncMissingUsersEvent.INSTANCE) && !Intrinsics.areEqual(event2, Event.UserInteractedWithList.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return false;
                }
            } else {
                Event.EmptyContext emptyContext = Event.EmptyContext.INSTANCE;
                if (Intrinsics.areEqual(event, emptyContext)) {
                    Event event3 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event3, screenOpened)) {
                        if (!Intrinsics.areEqual(event3, emptyContext) && !Intrinsics.areEqual(event3, Event.LoadedContext.INSTANCE) && !Intrinsics.areEqual(event3, Event.LoadedOnlyUserId.INSTANCE) && !Intrinsics.areEqual(event3, Event.ContextLoadingError.INSTANCE)) {
                            if (!Intrinsics.areEqual(event3, Event.Refresh.INSTANCE) && !Intrinsics.areEqual(event3, Event.MessagesLoadingStart.INSTANCE) && !Intrinsics.areEqual(event3, Event.MessagesLoadedEmpty.INSTANCE) && !Intrinsics.areEqual(event3, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event3, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event3, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event3, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event3, Event.PaginationError.INSTANCE)) {
                                if (!Intrinsics.areEqual(event3, Event.UsersStartedTyping.INSTANCE)) {
                                    if (!Intrinsics.areEqual(event3, Event.UsersFinishedTyping.INSTANCE)) {
                                        if (!Intrinsics.areEqual(event3, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event3, Event.MessageAvatarClicked.INSTANCE)) {
                                            if (!Intrinsics.areEqual(event3, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event3, Event.SyncMissingUsersEvent.INSTANCE) && !Intrinsics.areEqual(event3, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event3, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event3, Event.UserInteractedWithList.INSTANCE)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.LoadedOnlyUserId loadedOnlyUserId = Event.LoadedOnlyUserId.INSTANCE;
                if (Intrinsics.areEqual(event, loadedOnlyUserId)) {
                    Event event4 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event4, screenOpened)) {
                        if (!Intrinsics.areEqual(event4, emptyContext) && !Intrinsics.areEqual(event4, Event.LoadedContext.INSTANCE) && !Intrinsics.areEqual(event4, loadedOnlyUserId) && !Intrinsics.areEqual(event4, Event.ContextLoadingError.INSTANCE)) {
                            if (!Intrinsics.areEqual(event4, Event.Refresh.INSTANCE) && !Intrinsics.areEqual(event4, Event.MessagesLoadingStart.INSTANCE) && !Intrinsics.areEqual(event4, Event.MessagesLoadedEmpty.INSTANCE) && !Intrinsics.areEqual(event4, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event4, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event4, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event4, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event4, Event.PaginationError.INSTANCE)) {
                                if (!Intrinsics.areEqual(event4, Event.UsersStartedTyping.INSTANCE)) {
                                    if (!Intrinsics.areEqual(event4, Event.UsersFinishedTyping.INSTANCE)) {
                                        if (!Intrinsics.areEqual(event4, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event4, Event.MessageAvatarClicked.INSTANCE)) {
                                            if (!Intrinsics.areEqual(event4, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event4, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event4, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event4, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event4, Event.SyncMissingUsersEvent.INSTANCE)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.LoadedContext loadedContext = Event.LoadedContext.INSTANCE;
                if (Intrinsics.areEqual(event, loadedContext)) {
                    Event event5 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event5, screenOpened)) {
                        if (!Intrinsics.areEqual(event5, emptyContext) && !Intrinsics.areEqual(event5, loadedContext) && !Intrinsics.areEqual(event5, loadedOnlyUserId) && !Intrinsics.areEqual(event5, Event.ContextLoadingError.INSTANCE)) {
                            if (!Intrinsics.areEqual(event5, Event.Refresh.INSTANCE) && !Intrinsics.areEqual(event5, Event.MessagesLoadingStart.INSTANCE) && !Intrinsics.areEqual(event5, Event.MessagesLoadedEmpty.INSTANCE) && !Intrinsics.areEqual(event5, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event5, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event5, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event5, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event5, Event.PaginationError.INSTANCE)) {
                                if (!Intrinsics.areEqual(event5, Event.UsersStartedTyping.INSTANCE)) {
                                    if (!Intrinsics.areEqual(event5, Event.UsersFinishedTyping.INSTANCE)) {
                                        if (!Intrinsics.areEqual(event5, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event5, Event.MessageAvatarClicked.INSTANCE)) {
                                            if (!Intrinsics.areEqual(event5, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event5, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event5, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event5, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event5, Event.SyncMissingUsersEvent.INSTANCE)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.ContextLoadingError contextLoadingError = Event.ContextLoadingError.INSTANCE;
                if (Intrinsics.areEqual(event, contextLoadingError)) {
                    Event event6 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event6, screenOpened)) {
                        if (!Intrinsics.areEqual(event6, emptyContext) && !Intrinsics.areEqual(event6, loadedContext) && !Intrinsics.areEqual(event6, loadedOnlyUserId) && !Intrinsics.areEqual(event6, contextLoadingError)) {
                            if (!Intrinsics.areEqual(event6, Event.Refresh.INSTANCE) && !Intrinsics.areEqual(event6, Event.MessagesLoadingStart.INSTANCE) && !Intrinsics.areEqual(event6, Event.MessagesLoadedEmpty.INSTANCE) && !Intrinsics.areEqual(event6, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event6, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event6, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event6, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event6, Event.PaginationError.INSTANCE)) {
                                if (!Intrinsics.areEqual(event6, Event.UsersStartedTyping.INSTANCE)) {
                                    if (!Intrinsics.areEqual(event6, Event.UsersFinishedTyping.INSTANCE)) {
                                        if (!Intrinsics.areEqual(event6, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event6, Event.MessageAvatarClicked.INSTANCE)) {
                                            if (!Intrinsics.areEqual(event6, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event6, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event6, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event6, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event6, Event.SyncMissingUsersEvent.INSTANCE)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.Refresh refresh = Event.Refresh.INSTANCE;
                if (Intrinsics.areEqual(event, refresh)) {
                    Event event7 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event7, screenOpened) && !Intrinsics.areEqual(event7, emptyContext) && !Intrinsics.areEqual(event7, loadedContext) && !Intrinsics.areEqual(event7, loadedOnlyUserId) && !Intrinsics.areEqual(event7, contextLoadingError)) {
                        if (!Intrinsics.areEqual(event7, refresh) && !Intrinsics.areEqual(event7, Event.MessagesLoadingStart.INSTANCE) && !Intrinsics.areEqual(event7, Event.MessagesLoadedEmpty.INSTANCE) && !Intrinsics.areEqual(event7, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event7, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event7, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event7, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event7, Event.PaginationError.INSTANCE) && !Intrinsics.areEqual(event7, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event7, Event.UsersFinishedTyping.INSTANCE)) {
                            if (!Intrinsics.areEqual(event7, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event7, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event7, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event7, Event.SyncMissingUsersEvent.INSTANCE)) {
                                if (!Intrinsics.areEqual(event7, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event7, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event7, Event.UserInteractedWithList.INSTANCE)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.MessagesLoadingStart messagesLoadingStart = Event.MessagesLoadingStart.INSTANCE;
                if (Intrinsics.areEqual(event, messagesLoadingStart)) {
                    Event event8 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event8, screenOpened) && !Intrinsics.areEqual(event8, emptyContext) && !Intrinsics.areEqual(event8, loadedContext) && !Intrinsics.areEqual(event8, loadedOnlyUserId) && !Intrinsics.areEqual(event8, contextLoadingError) && !Intrinsics.areEqual(event8, refresh)) {
                        if (!Intrinsics.areEqual(event8, messagesLoadingStart) && !Intrinsics.areEqual(event8, Event.MessagesLoadedEmpty.INSTANCE) && !Intrinsics.areEqual(event8, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event8, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event8, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event8, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event8, Event.PaginationError.INSTANCE) && !Intrinsics.areEqual(event8, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event8, Event.UsersFinishedTyping.INSTANCE)) {
                            if (!Intrinsics.areEqual(event8, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event8, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event8, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event8, Event.SyncMissingUsersEvent.INSTANCE)) {
                                if (!Intrinsics.areEqual(event8, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event8, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event8, Event.UserInteractedWithList.INSTANCE)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.MessagesLoadedEmpty messagesLoadedEmpty = Event.MessagesLoadedEmpty.INSTANCE;
                if (Intrinsics.areEqual(event, messagesLoadedEmpty)) {
                    Event event9 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event9, screenOpened) && !Intrinsics.areEqual(event9, emptyContext) && !Intrinsics.areEqual(event9, loadedContext) && !Intrinsics.areEqual(event9, loadedOnlyUserId) && !Intrinsics.areEqual(event9, contextLoadingError) && !Intrinsics.areEqual(event9, refresh)) {
                        if (!Intrinsics.areEqual(event9, messagesLoadingStart) && !Intrinsics.areEqual(event9, messagesLoadedEmpty) && !Intrinsics.areEqual(event9, Event.MessagesLoadedNonEmpty.INSTANCE) && !Intrinsics.areEqual(event9, Event.MessagesLoadingError.INSTANCE) && !Intrinsics.areEqual(event9, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event9, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event9, Event.PaginationError.INSTANCE) && !Intrinsics.areEqual(event9, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event9, Event.UsersFinishedTyping.INSTANCE)) {
                            if (!Intrinsics.areEqual(event9, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event9, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event9, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event9, Event.SyncMissingUsersEvent.INSTANCE)) {
                                if (!Intrinsics.areEqual(event9, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event9, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event9, Event.UserInteractedWithList.INSTANCE)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.MessagesLoadedNonEmpty messagesLoadedNonEmpty = Event.MessagesLoadedNonEmpty.INSTANCE;
                if (Intrinsics.areEqual(event, messagesLoadedNonEmpty)) {
                    Event event10 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event10, screenOpened) && !Intrinsics.areEqual(event10, emptyContext) && !Intrinsics.areEqual(event10, loadedContext) && !Intrinsics.areEqual(event10, loadedOnlyUserId) && !Intrinsics.areEqual(event10, contextLoadingError) && !Intrinsics.areEqual(event10, refresh)) {
                        if (!Intrinsics.areEqual(event10, messagesLoadingStart) && !Intrinsics.areEqual(event10, messagesLoadedEmpty) && !Intrinsics.areEqual(event10, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event10, Event.MessagesLoadingError.INSTANCE)) {
                            if (!Intrinsics.areEqual(event10, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event10, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event10, Event.PaginationError.INSTANCE) && !Intrinsics.areEqual(event10, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event10, Event.UsersFinishedTyping.INSTANCE) && !Intrinsics.areEqual(event10, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event10, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event10, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event10, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event10, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event10, Event.SyncMissingUsersEvent.INSTANCE)) {
                                if (!Intrinsics.areEqual(event10, Event.UserInteractedWithList.INSTANCE)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.MessagesLoadingError messagesLoadingError = Event.MessagesLoadingError.INSTANCE;
                if (Intrinsics.areEqual(event, messagesLoadingError)) {
                    Event event11 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event11, screenOpened) && !Intrinsics.areEqual(event11, emptyContext) && !Intrinsics.areEqual(event11, loadedContext) && !Intrinsics.areEqual(event11, loadedOnlyUserId) && !Intrinsics.areEqual(event11, contextLoadingError) && !Intrinsics.areEqual(event11, refresh)) {
                        if (!Intrinsics.areEqual(event11, messagesLoadingStart) && !Intrinsics.areEqual(event11, messagesLoadedEmpty) && !Intrinsics.areEqual(event11, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event11, messagesLoadingError) && !Intrinsics.areEqual(event11, Event.PaginationStart.INSTANCE) && !Intrinsics.areEqual(event11, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event11, Event.PaginationError.INSTANCE) && !Intrinsics.areEqual(event11, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event11, Event.UsersFinishedTyping.INSTANCE)) {
                            if (!Intrinsics.areEqual(event11, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event11, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event11, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event11, Event.SyncMissingUsersEvent.INSTANCE)) {
                                if (!Intrinsics.areEqual(event11, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event11, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event11, Event.UserInteractedWithList.INSTANCE)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                    }
                    return false;
                }
                Event.PaginationStart paginationStart = Event.PaginationStart.INSTANCE;
                if (Intrinsics.areEqual(event, paginationStart)) {
                    Event event12 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event12, screenOpened) && !Intrinsics.areEqual(event12, emptyContext) && !Intrinsics.areEqual(event12, loadedContext) && !Intrinsics.areEqual(event12, loadedOnlyUserId) && !Intrinsics.areEqual(event12, contextLoadingError) && !Intrinsics.areEqual(event12, refresh) && !Intrinsics.areEqual(event12, messagesLoadingStart) && !Intrinsics.areEqual(event12, messagesLoadedEmpty) && !Intrinsics.areEqual(event12, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event12, messagesLoadingError)) {
                        if (!Intrinsics.areEqual(event12, paginationStart) && !Intrinsics.areEqual(event12, Event.PaginationSuccess.INSTANCE) && !Intrinsics.areEqual(event12, Event.PaginationError.INSTANCE)) {
                            if (!Intrinsics.areEqual(event12, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event12, Event.UsersFinishedTyping.INSTANCE) && !Intrinsics.areEqual(event12, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event12, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event12, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event12, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event12, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event12, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event12, Event.SyncMissingUsersEvent.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    return false;
                }
                Event.PaginationSuccess paginationSuccess = Event.PaginationSuccess.INSTANCE;
                if (Intrinsics.areEqual(event, paginationSuccess)) {
                    Event event13 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event13, screenOpened) && !Intrinsics.areEqual(event13, emptyContext) && !Intrinsics.areEqual(event13, loadedContext) && !Intrinsics.areEqual(event13, loadedOnlyUserId) && !Intrinsics.areEqual(event13, contextLoadingError) && !Intrinsics.areEqual(event13, refresh) && !Intrinsics.areEqual(event13, messagesLoadingStart) && !Intrinsics.areEqual(event13, messagesLoadedEmpty) && !Intrinsics.areEqual(event13, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event13, messagesLoadingError)) {
                        if (!Intrinsics.areEqual(event13, paginationStart) && !Intrinsics.areEqual(event13, paginationSuccess) && !Intrinsics.areEqual(event13, Event.PaginationError.INSTANCE)) {
                            if (!Intrinsics.areEqual(event13, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event13, Event.UsersFinishedTyping.INSTANCE) && !Intrinsics.areEqual(event13, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event13, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event13, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event13, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event13, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event13, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event13, Event.SyncMissingUsersEvent.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    return false;
                }
                Event.PaginationError paginationError = Event.PaginationError.INSTANCE;
                if (Intrinsics.areEqual(event, paginationError)) {
                    Event event14 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event14, screenOpened) && !Intrinsics.areEqual(event14, emptyContext) && !Intrinsics.areEqual(event14, loadedContext) && !Intrinsics.areEqual(event14, loadedOnlyUserId) && !Intrinsics.areEqual(event14, contextLoadingError) && !Intrinsics.areEqual(event14, refresh) && !Intrinsics.areEqual(event14, messagesLoadingStart) && !Intrinsics.areEqual(event14, messagesLoadedEmpty) && !Intrinsics.areEqual(event14, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event14, messagesLoadingError)) {
                        if (!Intrinsics.areEqual(event14, paginationStart) && !Intrinsics.areEqual(event14, paginationSuccess) && !Intrinsics.areEqual(event14, paginationError)) {
                            if (!Intrinsics.areEqual(event14, Event.UsersStartedTyping.INSTANCE) && !Intrinsics.areEqual(event14, Event.UsersFinishedTyping.INSTANCE) && !Intrinsics.areEqual(event14, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event14, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event14, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event14, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event14, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event14, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event14, Event.SyncMissingUsersEvent.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    return false;
                }
                Event.UsersStartedTyping usersStartedTyping = Event.UsersStartedTyping.INSTANCE;
                if (Intrinsics.areEqual(event, usersStartedTyping)) {
                    Event event15 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event15, screenOpened) && !Intrinsics.areEqual(event15, emptyContext) && !Intrinsics.areEqual(event15, loadedContext) && !Intrinsics.areEqual(event15, loadedOnlyUserId) && !Intrinsics.areEqual(event15, contextLoadingError) && !Intrinsics.areEqual(event15, refresh) && !Intrinsics.areEqual(event15, messagesLoadingStart) && !Intrinsics.areEqual(event15, messagesLoadedEmpty) && !Intrinsics.areEqual(event15, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event15, messagesLoadingError) && !Intrinsics.areEqual(event15, paginationStart) && !Intrinsics.areEqual(event15, paginationSuccess) && !Intrinsics.areEqual(event15, paginationError)) {
                        if (!Intrinsics.areEqual(event15, usersStartedTyping) && !Intrinsics.areEqual(event15, Event.UsersFinishedTyping.INSTANCE)) {
                            if (!Intrinsics.areEqual(event15, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event15, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event15, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event15, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event15, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event15, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event15, Event.SyncMissingUsersEvent.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    return false;
                }
                Event.UsersFinishedTyping usersFinishedTyping = Event.UsersFinishedTyping.INSTANCE;
                if (Intrinsics.areEqual(event, usersFinishedTyping)) {
                    Event event16 = (Event) eventCommand2.getTypeObj();
                    if (!Intrinsics.areEqual(event16, screenOpened) && !Intrinsics.areEqual(event16, emptyContext) && !Intrinsics.areEqual(event16, loadedContext) && !Intrinsics.areEqual(event16, loadedOnlyUserId) && !Intrinsics.areEqual(event16, contextLoadingError) && !Intrinsics.areEqual(event16, refresh) && !Intrinsics.areEqual(event16, messagesLoadingStart) && !Intrinsics.areEqual(event16, messagesLoadedEmpty) && !Intrinsics.areEqual(event16, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event16, messagesLoadingError) && !Intrinsics.areEqual(event16, paginationStart) && !Intrinsics.areEqual(event16, paginationSuccess) && !Intrinsics.areEqual(event16, paginationError)) {
                        if (!Intrinsics.areEqual(event16, usersStartedTyping) && !Intrinsics.areEqual(event16, usersFinishedTyping)) {
                            if (!Intrinsics.areEqual(event16, Event.ItemMessageClicked.INSTANCE) && !Intrinsics.areEqual(event16, Event.MessageAvatarClicked.INSTANCE) && !Intrinsics.areEqual(event16, Event.MessageSpamActionClicked.INSTANCE) && !Intrinsics.areEqual(event16, Event.MessageSpamActionsInteractorStateUpdated.INSTANCE) && !Intrinsics.areEqual(event16, Event.ImageMessageClicked.INSTANCE) && !Intrinsics.areEqual(event16, Event.UserInteractedWithList.INSTANCE) && !Intrinsics.areEqual(event16, Event.SyncMissingUsersEvent.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    return false;
                }
                Event.ItemMessageClicked itemMessageClicked = Event.ItemMessageClicked.INSTANCE;
                if (!Intrinsics.areEqual(event, itemMessageClicked)) {
                    Event.MessageAvatarClicked messageAvatarClicked = Event.MessageAvatarClicked.INSTANCE;
                    if (!Intrinsics.areEqual(event, messageAvatarClicked)) {
                        Event.ImageMessageClicked imageMessageClicked = Event.ImageMessageClicked.INSTANCE;
                        if (!Intrinsics.areEqual(event, imageMessageClicked)) {
                            Event.SyncMissingUsersEvent syncMissingUsersEvent = Event.SyncMissingUsersEvent.INSTANCE;
                            if (!Intrinsics.areEqual(event, syncMissingUsersEvent)) {
                                Event.MessageSpamActionClicked messageSpamActionClicked = Event.MessageSpamActionClicked.INSTANCE;
                                if (!Intrinsics.areEqual(event, messageSpamActionClicked)) {
                                    Event.MessageSpamActionsInteractorStateUpdated messageSpamActionsInteractorStateUpdated = Event.MessageSpamActionsInteractorStateUpdated.INSTANCE;
                                    if (!Intrinsics.areEqual(event, messageSpamActionsInteractorStateUpdated)) {
                                        Event.UserInteractedWithList userInteractedWithList = Event.UserInteractedWithList.INSTANCE;
                                        if (Intrinsics.areEqual(event, userInteractedWithList)) {
                                            Event event17 = (Event) eventCommand2.getTypeObj();
                                            if (!Intrinsics.areEqual(event17, screenOpened) && !Intrinsics.areEqual(event17, emptyContext) && !Intrinsics.areEqual(event17, loadedContext) && !Intrinsics.areEqual(event17, loadedOnlyUserId) && !Intrinsics.areEqual(event17, contextLoadingError) && !Intrinsics.areEqual(event17, refresh) && !Intrinsics.areEqual(event17, messagesLoadingStart) && !Intrinsics.areEqual(event17, messagesLoadedEmpty) && !Intrinsics.areEqual(event17, messagesLoadedNonEmpty) && !Intrinsics.areEqual(event17, messagesLoadingError) && !Intrinsics.areEqual(event17, paginationStart) && !Intrinsics.areEqual(event17, paginationSuccess) && !Intrinsics.areEqual(event17, paginationError) && !Intrinsics.areEqual(event17, usersStartedTyping) && !Intrinsics.areEqual(event17, usersFinishedTyping) && !Intrinsics.areEqual(event17, itemMessageClicked) && !Intrinsics.areEqual(event17, messageAvatarClicked) && !Intrinsics.areEqual(event17, messageSpamActionClicked) && !Intrinsics.areEqual(event17, messageSpamActionsInteractorStateUpdated) && !Intrinsics.areEqual(event17, imageMessageClicked) && !Intrinsics.areEqual(event17, syncMissingUsersEvent)) {
                                                if (!Intrinsics.areEqual(event17, userInteractedWithList)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                            }
                                        } else {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Bª\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010k\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010X\u001a\u00020S\u0012\u0006\u0010t\u001a\u00020o\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010z\u001a\u00020u\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u0010A\u001a\u00020<\u0012\u0006\u0010h\u001a\u00020c\u0012\u0006\u00102\u001a\u00020-\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020H0\u0016\u0012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0\u0016\u0012\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016\u0012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020~0\u0016\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u0016\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020M0L\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010;\u001a\u000206\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010G\u001a\u00020B\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010b\u001a\u00020]\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001R\u001c\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001bR\u001c\u0010,\u001a\u00020'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001bR\u001c\u0010;\u001a\u0002068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010A\u001a\u00020<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010G\u001a\u00020B8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010K\u001a\b\u0012\u0004\u0012\u00020H0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010\u0019\u001a\u0004\bJ\u0010\u001bR\"\u0010R\u001a\b\u0012\u0004\u0012\u00020M0L8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001c\u0010X\u001a\u00020S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\"\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bZ\u0010\u0019\u001a\u0004\b[\u0010\u001bR\u0019\u0010b\u001a\u00020]8\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001c\u0010h\u001a\u00020c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u001e\u0010k\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010\u0006\u001a\u0004\bj\u0010\bR\"\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bl\u0010\u0019\u001a\u0004\bm\u0010\u001bR\u001c\u0010t\u001a\u00020o8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001c\u0010z\u001a\u00020u8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\"\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b{\u0010\u0019\u001a\u0004\b|\u0010\u001bR$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020~0\u00168\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b\u0010\u0019\u001a\u0005\b\u0001\u0010\u001bR\"\u0010\u0001\u001a\u00030\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00030\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00030\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Deps;", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps$Impl;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "f", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "channelId", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "y", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "getErrorTracker", "()Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/Features;", "D", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "features", "Landroidx/lifecycle/MutableLiveData;", "", VKApiConst.VERSION, "Landroidx/lifecycle/MutableLiveData;", "getSystemUserAvatarClickedStream", "()Landroidx/lifecycle/MutableLiveData;", "systemUserAvatarClickedStream", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;", "F", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;", "getFileMessageClickInteractor", "()Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;", "fileMessageClickInteractor", "Lcom/avito/android/messenger/conversation/mvi/messages/PlatformMapData;", "u", "getPlatformMapMessageClickedStream", "platformMapMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "l", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "getMessageSpamActionsInteractor", "()Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "messageSpamActionsInteractor", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "o", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "getAppendCounter", "()Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "appendCounter", "w", "getErrorMessageStream", "errorMessageStream", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "z", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "getPerfTracker", "()Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "perfTracker", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "getDeeplinkProcessor", "()Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deeplinkProcessor", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "C", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "getMissingUsersSyncAgent", "()Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "missingUsersSyncAgent", "Lcom/avito/android/messenger/conversation/mvi/messages/ItemMessageInfo;", "p", "getItemMessageClickedStream", "itemMessageClickedStream", "Lcom/avito/android/util/Formatter;", "", "x", "Lcom/avito/android/util/Formatter;", "getErrorFormatter", "()Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "h", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "getMessageListInteractor", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "messageListInteractor", "Lcom/avito/android/messenger/conversation/mvi/messages/OpenGalleryData;", VKApiConst.Q, "getImageMessageClickedStream", "imageMessageClickedStream", "Lcom/avito/android/deep_linking/DeepLinkFactory;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "getDeepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/analytics/Analytics;", "n", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", g.a, "getMessageId", "messageId", "r", "getUnknownMessageClickedStream", "unknownMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "i", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "getMessageListItemConverter", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "messageListItemConverter", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "k", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "getChannelMenuInteractor", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "channelMenuInteractor", "s", "getLinkMessageWithUrlClickedStream", "linkMessageWithUrlClickedStream", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "t", "getLocationMessageClickedStream", "locationMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "B", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "getFileDownloadManager", "()Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "fileDownloadManager", "Lcom/avito/android/server_time/TimeSource;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "j", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "getChannelContextInteractor", "()Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Lcom/avito/android/util/Formatter;Lcom/avito/android/communications_common/analytics/ErrorTracker;Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;Lcom/avito/android/Features;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Deps extends BaseEntityDeps.Impl<PartialState> implements EventDeps {
        @NotNull
        public final TimeSource A;
        @NotNull
        public final FileDownloadManager B;
        @NotNull
        public final MissingUsersSyncAgent C;
        @NotNull
        public final Features D;
        @NotNull
        public final DeepLinkFactory E;
        @NotNull
        public final FileMessageClickInteractor F;
        @NotNull
        public final String f;
        @Nullable
        public final String g;
        @NotNull
        public final MessageListInteractor h;
        @NotNull
        public final MessageListItemConverter i;
        @NotNull
        public final ChannelContextInteractor j;
        @NotNull
        public final ChannelMenuInteractor k;
        @NotNull
        public final MessageSpamActionsInteractor l;
        @NotNull
        public final DeeplinkProcessor m;
        @NotNull
        public final Analytics n;
        @NotNull
        public final MessengerGraphiteCounter o;
        @NotNull
        public final MutableLiveData<ItemMessageInfo> p;
        @NotNull
        public final MutableLiveData<OpenGalleryData> q;
        @NotNull
        public final MutableLiveData<Unit> r;
        @NotNull
        public final MutableLiveData<String> s;
        @NotNull
        public final MutableLiveData<MessageBody.Location> t;
        @NotNull
        public final MutableLiveData<PlatformMapData> u;
        @NotNull
        public final MutableLiveData<Unit> v;
        @NotNull
        public final MutableLiveData<String> w;
        @NotNull
        public final Formatter<Throwable> x;
        @NotNull
        public final ErrorTracker y;
        @NotNull
        public final ChannelTracker z;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Deps(@NotNull String str, @Nullable String str2, @NotNull MessageListInteractor messageListInteractor, @NotNull MessageListItemConverter messageListItemConverter, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull ChannelMenuInteractor channelMenuInteractor, @NotNull MessageSpamActionsInteractor messageSpamActionsInteractor, @NotNull DeeplinkProcessor deeplinkProcessor, @NotNull Analytics analytics, @NotNull MessengerGraphiteCounter messengerGraphiteCounter, @NotNull MutableLiveData<ItemMessageInfo> mutableLiveData, @NotNull MutableLiveData<OpenGalleryData> mutableLiveData2, @NotNull MutableLiveData<Unit> mutableLiveData3, @NotNull MutableLiveData<String> mutableLiveData4, @NotNull MutableLiveData<MessageBody.Location> mutableLiveData5, @NotNull MutableLiveData<PlatformMapData> mutableLiveData6, @NotNull MutableLiveData<Unit> mutableLiveData7, @NotNull MutableLiveData<String> mutableLiveData8, @NotNull Formatter<Throwable> formatter, @NotNull ErrorTracker errorTracker, @NotNull ChannelTracker channelTracker, @NotNull TimeSource timeSource, @NotNull FileDownloadManager fileDownloadManager, @NotNull MissingUsersSyncAgent missingUsersSyncAgent, @NotNull Features features, @NotNull DeepLinkFactory deepLinkFactory, @NotNull FileMessageClickInteractor fileMessageClickInteractor, @NotNull SchedulersFactory schedulersFactory) {
            super("MessageListPresenter", schedulersFactory);
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(messageListInteractor, "messageListInteractor");
            Intrinsics.checkNotNullParameter(messageListItemConverter, "messageListItemConverter");
            Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
            Intrinsics.checkNotNullParameter(channelMenuInteractor, "channelMenuInteractor");
            Intrinsics.checkNotNullParameter(messageSpamActionsInteractor, "messageSpamActionsInteractor");
            Intrinsics.checkNotNullParameter(deeplinkProcessor, "deeplinkProcessor");
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(messengerGraphiteCounter, "appendCounter");
            Intrinsics.checkNotNullParameter(mutableLiveData, "itemMessageClickedStream");
            Intrinsics.checkNotNullParameter(mutableLiveData2, "imageMessageClickedStream");
            Intrinsics.checkNotNullParameter(mutableLiveData3, "unknownMessageClickedStream");
            Intrinsics.checkNotNullParameter(mutableLiveData4, "linkMessageWithUrlClickedStream");
            Intrinsics.checkNotNullParameter(mutableLiveData5, "locationMessageClickedStream");
            Intrinsics.checkNotNullParameter(mutableLiveData6, "platformMapMessageClickedStream");
            Intrinsics.checkNotNullParameter(mutableLiveData7, "systemUserAvatarClickedStream");
            Intrinsics.checkNotNullParameter(mutableLiveData8, "errorMessageStream");
            Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
            Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
            Intrinsics.checkNotNullParameter(channelTracker, "perfTracker");
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            Intrinsics.checkNotNullParameter(fileDownloadManager, "fileDownloadManager");
            Intrinsics.checkNotNullParameter(missingUsersSyncAgent, "missingUsersSyncAgent");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
            Intrinsics.checkNotNullParameter(fileMessageClickInteractor, "fileMessageClickInteractor");
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
            this.f = str;
            this.g = str2;
            this.h = messageListInteractor;
            this.i = messageListItemConverter;
            this.j = channelContextInteractor;
            this.k = channelMenuInteractor;
            this.l = messageSpamActionsInteractor;
            this.m = deeplinkProcessor;
            this.n = analytics;
            this.o = messengerGraphiteCounter;
            this.p = mutableLiveData;
            this.q = mutableLiveData2;
            this.r = mutableLiveData3;
            this.s = mutableLiveData4;
            this.t = mutableLiveData5;
            this.u = mutableLiveData6;
            this.v = mutableLiveData7;
            this.w = mutableLiveData8;
            this.x = formatter;
            this.y = errorTracker;
            this.z = channelTracker;
            this.A = timeSource;
            this.B = fileDownloadManager;
            this.C = missingUsersSyncAgent;
            this.D = features;
            this.E = deepLinkFactory;
            this.F = fileMessageClickInteractor;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public Analytics getAnalytics() {
            return this.n;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MessengerGraphiteCounter getAppendCounter() {
            return this.o;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public ChannelContextInteractor getChannelContextInteractor() {
            return this.j;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public String getChannelId() {
            return this.f;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public ChannelMenuInteractor getChannelMenuInteractor() {
            return this.k;
        }

        @NotNull
        public final DeepLinkFactory getDeepLinkFactory() {
            return this.E;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public DeeplinkProcessor getDeeplinkProcessor() {
            return this.m;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public Formatter<Throwable> getErrorFormatter() {
            return this.x;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<String> getErrorMessageStream() {
            return this.w;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public ErrorTracker getErrorTracker() {
            return this.y;
        }

        @NotNull
        public final Features getFeatures() {
            return this.D;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public FileDownloadManager getFileDownloadManager() {
            return this.B;
        }

        @NotNull
        public final FileMessageClickInteractor getFileMessageClickInteractor() {
            return this.F;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<OpenGalleryData> getImageMessageClickedStream() {
            return this.q;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<ItemMessageInfo> getItemMessageClickedStream() {
            return this.p;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<String> getLinkMessageWithUrlClickedStream() {
            return this.s;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<MessageBody.Location> getLocationMessageClickedStream() {
            return this.t;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @Nullable
        public String getMessageId() {
            return this.g;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MessageListInteractor getMessageListInteractor() {
            return this.h;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MessageListItemConverter getMessageListItemConverter() {
            return this.i;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MessageSpamActionsInteractor getMessageSpamActionsInteractor() {
            return this.l;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MissingUsersSyncAgent getMissingUsersSyncAgent() {
            return this.C;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public ChannelTracker getPerfTracker() {
            return this.z;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<PlatformMapData> getPlatformMapMessageClickedStream() {
            return this.u;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<Unit> getSystemUserAvatarClickedStream() {
            return this.v;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public TimeSource getTimeSource() {
            return this.A;
        }

        @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps
        @NotNull
        public MutableLiveData<Unit> getUnknownMessageClickedStream() {
            return this.r;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Effect;", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEffect;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "<init>", "()V", "StartLoadingOnNewUserId", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Effect$StartLoadingOnNewUserId;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Effect implements BaseEffect<EventInstance<Event, ?, ?>> {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u001a\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Effect$StartLoadingOnNewUserId;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Effect;", "Lio/reactivex/Observable;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "eventStream", "", "reactTo", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlin/Function0;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function0;", "dispatchLoadingStartCommand", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class StartLoadingOnNewUserId extends Effect {
            public final Function0<Unit> a;

            public static final class a<T> implements Predicate<a2.a.a.o1.d.a0.i.b> {
                public static final a a = new a();

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Predicate
                public boolean test(a2.a.a.o1.d.a0.i.b bVar) {
                    a2.a.a.o1.d.a0.i.b bVar2 = bVar;
                    Intrinsics.checkNotNullParameter(bVar2, "event");
                    return !m.isBlank(bVar2.getCurrentUserId());
                }
            }

            public static final class b<T, R> implements Function<a2.a.a.o1.d.a0.i.b, String> {
                public static final b a = new b();

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Function
                public String apply(a2.a.a.o1.d.a0.i.b bVar) {
                    a2.a.a.o1.d.a0.i.b bVar2 = bVar;
                    Intrinsics.checkNotNullParameter(bVar2, "event");
                    return bVar2.getCurrentUserId();
                }
            }

            public static final class c<T, R> implements Function<String, Unit> {
                public static final c a = new c();

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Function
                public Unit apply(String str) {
                    Intrinsics.checkNotNullParameter(str, "it");
                    return Unit.INSTANCE;
                }
            }

            public static final class d<T> implements Consumer<Unit> {
                public final /* synthetic */ StartLoadingOnNewUserId a;

                public d(StartLoadingOnNewUserId startLoadingOnNewUserId) {
                    this.a = startLoadingOnNewUserId;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Consumer
                public void accept(Unit unit) {
                    this.a.a.invoke();
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public StartLoadingOnNewUserId(@NotNull Function0<Unit> function0) {
                super(null);
                Intrinsics.checkNotNullParameter(function0, "dispatchLoadingStartCommand");
                this.a = function0;
            }

            @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseEffect
            @NotNull
            public Observable<Unit> reactTo(@NotNull Observable<EventInstance<Event, ?, ?>> observable) {
                Intrinsics.checkNotNullParameter(observable, "eventStream");
                Observable<U> ofType = observable.ofType(a2.a.a.o1.d.a0.i.b.class);
                Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
                Observable<R> doOnNext = ofType.filter(a.a).map(b.a).distinctUntilChanged().map(c.a).doOnNext(new d(this));
                Intrinsics.checkNotNullExpressionValue(doOnNext, "eventStream.ofType<CanHa…d()\n                    }");
                return doOnNext;
            }
        }

        public Effect() {
        }

        public Effect(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0016\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0016\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./¨\u00060"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "<init>", "()V", "ContextLoadingError", "EmptyContext", "ImageMessageClicked", "ItemMessageClicked", "LoadedContext", "LoadedOnlyUserId", "MessageAvatarClicked", "MessageSpamActionClicked", "MessageSpamActionsInteractorStateUpdated", "MessagesLoadedEmpty", "MessagesLoadedNonEmpty", "MessagesLoadingError", "MessagesLoadingStart", "PaginationError", "PaginationStart", "PaginationSuccess", HttpHeaders.REFRESH, "ScreenOpened", "SyncMissingUsersEvent", "UserInteractedWithList", "UsersFinishedTyping", "UsersStartedTyping", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ScreenOpened;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$EmptyContext;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedOnlyUserId;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedContext;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ContextLoadingError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$SyncMissingUsersEvent;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$Refresh;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingStart;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedEmpty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedNonEmpty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationStart;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationSuccess;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersStartedTyping;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersFinishedTyping;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ItemMessageClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageAvatarClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ImageMessageClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UserInteractedWithList;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ContextLoadingError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "currentUserId", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ContextLoadingError$Instance;", "invoke", "(Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ContextLoadingError extends Event {
            @NotNull
            public static final ContextLoadingError INSTANCE = new ContextLoadingError();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B-\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ContextLoadingError$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "La2/a/a/o1/d/a0/i/b;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "", g.a, "Ljava/lang/String;", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "contextStateProperty", "", "id", "deps", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> implements b {
                public static final /* synthetic */ KProperty[] h = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;
                @NotNull
                public final String g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull String str, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(ContextLoadingError.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(str, "currentUserId");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = str;
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    this.f.getValue((EventInstance.WriteKeyProperty) this, h[0]).set(new PartialState.Context.LoadingError(getCurrentUserId()));
                }

                @Override // a2.a.a.o1.d.a0.i.b
                @NotNull
                public String getCurrentUserId() {
                    return this.g;
                }
            }

            public ContextLoadingError() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull String str, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                return new MessageListPresenterImpl$Event$ContextLoadingError$invoke$1(str, kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$EmptyContext;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$EmptyContext$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class EmptyContext extends Event {
            @NotNull
            public static final EmptyContext INSTANCE = new EmptyContext();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$EmptyContext$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "contextStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] g = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(EmptyContext.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    this.f.getValue((EventInstance.WriteKeyProperty) this, g[0]).set(PartialState.Context.Empty.INSTANCE);
                }
            }

            public EmptyContext() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                return new MessageListPresenterImpl$Event$EmptyContext$invoke$1(kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JB\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ImageMessageClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "", "imageId", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ImageMessageClicked$Instance;", "invoke", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ImageMessageClicked extends Event {
            @NotNull
            public static final ImageMessageClicked INSTANCE = new ImageMessageClicked();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B7\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ImageMessageClicked$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getListMiddleStateProperty", "()Lkotlin/reflect/KProperty0;", "listMiddleStateProperty", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", g.a, "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "", "h", "Ljava/lang/String;", "imageId", "Lkotlin/reflect/KMutableProperty0;", "", "id", "deps", "<init>", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] i = {a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final LocalMessage g;
                public final String h;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull LocalMessage localMessage, @Nullable String str, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(ImageMessageClicked.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(localMessage, "message");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = localMessage;
                    this.h = str;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    int size;
                    Image image;
                    Image image2;
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = i;
                    int i2 = 0;
                    Object obj = readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    if (!(obj instanceof PartialState.List.Middle.LoadingSuccess)) {
                        obj = null;
                    }
                    PartialState.List.Middle.LoadingSuccess loadingSuccess = (PartialState.List.Middle.LoadingSuccess) obj;
                    if (loadingSuccess != null) {
                        ArrayList arrayList = new ArrayList();
                        List<ChannelItem> items = loadingSuccess.getItems();
                        ArrayList arrayList2 = new ArrayList();
                        for (T t : items) {
                            if (t instanceof ChannelItem.Message) {
                                arrayList2.add(t);
                            }
                        }
                        for (ChannelItem.Message message : i.asReversed(arrayList2)) {
                            boolean areEqual = Intrinsics.areEqual(message.getLocalMessage().localId, this.g.localId);
                            ChannelItem.Message.BodyOrBubble bodyOrBubble = message.getBodyOrBubble();
                            if (bodyOrBubble instanceof ChannelItem.Message.BodyOrBubble.Body) {
                                MessageBody body = ((ChannelItem.Message.BodyOrBubble.Body) message.getBodyOrBubble()).getBody();
                                if (body instanceof MessageBody.ImageBody) {
                                    arrayList.add(((MessageBody.ImageBody) body).getImage());
                                    if (areEqual) {
                                        size = arrayList.size();
                                    }
                                } else if (body instanceof MessageBody.LocalImage) {
                                    arrayList.add(ImageKt.toImage(((MessageBody.LocalImage) body).getSource()));
                                    if (areEqual) {
                                        size = arrayList.size();
                                    }
                                } else if (body instanceof MessageBody.Link) {
                                    MessageBody.Link.Preview preview = ((MessageBody.Link) body).getPreview();
                                    if (!(preview instanceof MessageBody.Link.Preview.Image)) {
                                        preview = null;
                                    }
                                    MessageBody.Link.Preview.Image image3 = (MessageBody.Link.Preview.Image) preview;
                                    if (!(image3 == null || (image = image3.getImage()) == null)) {
                                        arrayList.add(image);
                                        if (areEqual) {
                                            size = arrayList.size();
                                        }
                                    }
                                }
                            } else if (bodyOrBubble instanceof ChannelItem.Message.BodyOrBubble.Bubble) {
                                MessageBody.SystemMessageBody.Platform.Bubble bubble = ((ChannelItem.Message.BodyOrBubble.Bubble) message.getBodyOrBubble()).getBubble();
                                if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Image)) {
                                    bubble = null;
                                }
                                MessageBody.SystemMessageBody.Platform.Bubble.Image image4 = (MessageBody.SystemMessageBody.Platform.Bubble.Image) bubble;
                                if (!(image4 == null || (image2 = image4.getImage()) == null)) {
                                    arrayList.add(image2);
                                    if (areEqual && Intrinsics.areEqual(image4.getImageId(), this.h)) {
                                        size = arrayList.size();
                                    }
                                }
                            }
                            i2 = size - 1;
                        }
                        Pair pair = TuplesKt.to(arrayList, Integer.valueOf(i2));
                        eventDeps.getImageMessageClickedStream().postValue(new OpenGalleryData((List) pair.component1(), ((Number) pair.component2()).intValue()));
                        return;
                    }
                    StringBuilder L = a2.b.a.a.a.L("Image message click ignored: Event.ImageMessageClicked arrived when first page wasn't loaded: \n\t listMiddleState = ");
                    L.append((PartialState.List.Middle) this.f.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get());
                    Logs.warning$default("MessageListPresenter", L.toString(), null, 4, null);
                }
            }

            public ImageMessageClicked() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull LocalMessage localMessage, @Nullable String str, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(localMessage, "message");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "listMiddleStateProperty");
                return new MessageListPresenterImpl$Event$ImageMessageClicked$invoke$1(localMessage, str, kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ItemMessageClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", SDKConstants.PARAM_A2U_BODY, "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ItemMessageClicked$Instance;", "invoke", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ItemMessageClicked extends Event {
            @NotNull
            public static final ItemMessageClicked INSTANCE = new ItemMessageClicked();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ItemMessageClicked$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", g.a, "Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", SDKConstants.PARAM_A2U_BODY, "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KProperty0;", "contextStateProperty", "Lkotlin/reflect/KMutableProperty0;", "", "id", "deps", "<init>", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] h = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final MessageBody.Item g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull MessageBody.Item item, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(ItemMessageClicked.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(item, SDKConstants.PARAM_A2U_BODY);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = item;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = h;
                    String access$getCurrentUserId$p = MessageListPresenterKt.access$getCurrentUserId$p(readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]));
                    if (!m.isBlank(access$getCurrentUserId$p)) {
                        eventDeps.getItemMessageClickedStream().postValue(new ItemMessageInfo(this.g.getId(), this.g.getUserId(), access$getCurrentUserId$p));
                        return;
                    }
                    StringBuilder L = a2.b.a.a.a.L("Item Message click ignored: Event.ItemMessageClicked arrived when currentUserId wasn't available: \n\t ctxState = ");
                    L.append((PartialState.Context) this.f.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get());
                    Logs.warning$default("MessageListPresenter", L.toString(), null, 4, null);
                }
            }

            public ItemMessageClicked() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull MessageBody.Item item, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(item, SDKConstants.PARAM_A2U_BODY);
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                return new MessageListPresenterImpl$Event$ItemMessageClicked$invoke$1(item, kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0001\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\n¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedContext;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "currentUserId", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "context", "", "Lcom/avito/android/remote/model/User;", "users", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "metaStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedContext$Instance;", "invoke", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context/ChannelContext;Ljava/util/List;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoadedContext extends Event {
            @NotNull
            public static final LoadedContext INSTANCE = new LoadedContext();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B{\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020,0\u0016\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u0002020\u0016\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u0016\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00108\u001a\u00020\u0004¢\u0006\u0004\b9\u0010:J\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR#\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001c\u0010*\u001a\u00020%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R#\u00101\u001a\b\u0012\u0004\u0012\u00020,0+8B@\u0002X\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R#\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001b¨\u0006;"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedContext$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "La2/a/a/o1/d/a0/i/b;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "l", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "getContext", "()Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "context", "", "Lcom/avito/android/remote/model/User;", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "users", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", g.a, "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "h", "getListTopStateProperty", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "j", "getListBottomStateProperty", "listBottomStateProperty", "", "k", "Ljava/lang/String;", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getMetaStateProperty", "()Lkotlin/reflect/KProperty0;", "metaStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "i", "getListMiddleStateProperty", "listMiddleStateProperty", "", "id", "deps", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context/ChannelContext;Ljava/util/List;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> implements b {
                public static final /* synthetic */ KProperty[] n = {a2.b.a.a.a.v0(Instance.class, "metaStateProperty", "getMetaStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listBottomStateProperty", "getListBottomStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.WriteKeyProperty g;
                public final EventInstance.WriteKeyProperty h;
                public final EventInstance.WriteKeyProperty i;
                public final EventInstance.WriteKeyProperty j;
                @NotNull
                public final String k;
                @NotNull
                public final ChannelContext l;
                @NotNull
                public final List<User> m;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull String str, @NotNull ChannelContext channelContext, @NotNull List<User> list, @NotNull KMutableProperty0<PartialState.Meta> kMutableProperty0, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty04, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty05, long j2, @NotNull EventDeps eventDeps) {
                    super(LoadedContext.INSTANCE, j2, eventDeps);
                    Intrinsics.checkNotNullParameter(str, "currentUserId");
                    Intrinsics.checkNotNullParameter(channelContext, "context");
                    Intrinsics.checkNotNullParameter(list, "users");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "metaStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty04, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty05, "listBottomStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.k = str;
                    this.l = channelContext;
                    this.m = list;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.WriteKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                    this.i = new EventInstance.WriteKeyProperty(kMutableProperty04, getKeys());
                    this.j = new EventInstance.WriteKeyProperty(kMutableProperty05, getKeys());
                }

                /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fb, code lost:
                    if (com.avito.android.remote.model.messenger.MessengerTimestamp.toMillis(r4.created) < r13) goto L_0x0113;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x010c, code lost:
                    if (r10.longValue() < r13) goto L_0x0113;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x0111, code lost:
                    if (r4.isRead != false) goto L_0x0113;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:36:0x0115, code lost:
                    r4 = false;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Removed duplicated region for block: B:94:0x0244  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void doHandle(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps r19) {
                    /*
                    // Method dump skipped, instructions count: 596
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.Event.LoadedContext.Instance.doHandle(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$EventDeps):void");
                }

                @NotNull
                public final ChannelContext getContext() {
                    return this.l;
                }

                @Override // a2.a.a.o1.d.a0.i.b
                @NotNull
                public String getCurrentUserId() {
                    return this.k;
                }

                @NotNull
                public final List<User> getUsers() {
                    return this.m;
                }
            }

            public LoadedContext() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull String str, @NotNull ChannelContext channelContext, @NotNull List<User> list, @NotNull KMutableProperty0<PartialState.Meta> kMutableProperty0, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty04, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty05) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(channelContext, "context");
                Intrinsics.checkNotNullParameter(list, "users");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "metaStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty04, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty05, "listBottomStateProperty");
                return new MessageListPresenterImpl$Event$LoadedContext$invoke$1(str, channelContext, list, kMutableProperty0, kMutableProperty02, kMutableProperty03, kMutableProperty04, kMutableProperty05);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedOnlyUserId;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "currentUserId", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedOnlyUserId$Instance;", "invoke", "(Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoadedOnlyUserId extends Event {
            @NotNull
            public static final LoadedOnlyUserId INSTANCE = new LoadedOnlyUserId();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B-\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$LoadedOnlyUserId$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "La2/a/a/o1/d/a0/i/b;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "", g.a, "Ljava/lang/String;", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "contextStateProperty", "", "id", "deps", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> implements b {
                public static final /* synthetic */ KProperty[] h = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;
                @NotNull
                public final String g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull String str, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(LoadedOnlyUserId.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(str, "currentUserId");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = str;
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    this.f.getValue((EventInstance.WriteKeyProperty) this, h[0]).set(new PartialState.Context.LoadedOnlyUserId(getCurrentUserId()));
                }

                @Override // a2.a.a.o1.d.a0.i.b
                @NotNull
                public String getCurrentUserId() {
                    return this.g;
                }
            }

            public LoadedOnlyUserId() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull String str, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                return new MessageListPresenterImpl$Event$LoadedOnlyUserId$invoke$1(str, kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageAvatarClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "message", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageAvatarClicked$Instance;", "invoke", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessageAvatarClicked extends Event {
            @NotNull
            public static final MessageAvatarClicked INSTANCE = new MessageAvatarClicked();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageAvatarClicked$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", g.a, "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "message", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KProperty0;", "contextStateProperty", "Lkotlin/reflect/KMutableProperty0;", "", "id", "deps", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] h = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final ChannelItem.Message g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull ChannelItem.Message message, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(MessageAvatarClicked.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(message, "message");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = message;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    T t;
                    PublicProfile publicProfile;
                    Action action;
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = h;
                    Object obj = readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    String str = null;
                    if (!(obj instanceof PartialState.Context.Loaded)) {
                        obj = null;
                    }
                    PartialState.Context.Loaded loaded = (PartialState.Context.Loaded) obj;
                    if (loaded != null) {
                        String str2 = this.g.getLocalMessage().fromId;
                        if (str2.hashCode() == 48 && str2.equals("0")) {
                            eventDeps.getSystemUserAvatarClickedStream().postValue(Unit.INSTANCE);
                            return;
                        }
                        Iterator<T> it = loaded.getUsers().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it.next();
                            if (Intrinsics.areEqual(t.getId(), str2)) {
                                break;
                            }
                        }
                        T t2 = t;
                        DeepLink deepLink = (t2 == null || (publicProfile = t2.getPublicProfile()) == null || (action = publicProfile.getAction()) == null) ? null : action.getDeepLink();
                        if (deepLink != null && !(deepLink instanceof NoMatchLink)) {
                            eventDeps.getDeeplinkProcessor().process(deepLink);
                            ChannelContext context = loaded.getContext();
                            if (!(context instanceof ChannelContext.Item)) {
                                context = null;
                            }
                            ChannelContext.Item item = (ChannelContext.Item) context;
                            Analytics analytics = eventDeps.getAnalytics();
                            String channelId = eventDeps.getChannelId();
                            String id = t2.getId();
                            String id2 = item != null ? item.getId() : null;
                            if (item != null) {
                                str = item.getUserId();
                            }
                            analytics.track(new OpenUserProfileEvent(channelId, id, id2, str, OpenUserProfileEvent.SOURCE_MESSENGER_AVATAR));
                            return;
                        }
                        return;
                    }
                    StringBuilder L = a2.b.a.a.a.L("Message avatar click ignored: Event.MessageAvatarClicked arrived when context wasn't loaded: \n\t ctxState = ");
                    L.append((PartialState.Context) this.f.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get());
                    Logs.warning$default("MessageListPresenter", L.toString(), null, 4, null);
                }
            }

            public MessageAvatarClicked() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull ChannelItem.Message message, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                return new MessageListPresenterImpl$Event$MessageAvatarClicked$invoke$1(message, kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J@\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionClicked;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "messageRemoteId", "", "isSpam", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionClicked$Instance;", "invoke", "(Ljava/lang/String;ZLkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessageSpamActionClicked extends Event {
            @NotNull
            public static final MessageSpamActionClicked INSTANCE = new MessageSpamActionClicked();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B5\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionClicked$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "", "h", "Z", "isSpam", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getListMiddleStateProperty", "()Lkotlin/reflect/KProperty0;", "listMiddleStateProperty", "", g.a, "Ljava/lang/String;", "messageRemoteId", "Lkotlin/reflect/KMutableProperty0;", "", "id", "deps", "<init>", "(Ljava/lang/String;ZLkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] i = {a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final String g;
                public final boolean h;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull String str, boolean z, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(MessageSpamActionClicked.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(str, "messageRemoteId");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = str;
                    this.h = z;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Object obj;
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    Iterator it = MessageListPresenterKt.access$getRawItems$p((PartialState.List.Middle) this.f.getValue((EventInstance.ReadKeyProperty) this, i[0]).get()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual(((LocalMessage) ((Pair) obj).component1()).remoteId, this.g)) {
                            break;
                        }
                    }
                    Pair pair = (Pair) obj;
                    LocalMessage localMessage = pair != null ? (LocalMessage) pair.getFirst() : null;
                    if (localMessage == null) {
                        StringBuilder L = a2.b.a.a.a.L("Message not found: remoteId=");
                        L.append(this.g);
                        Logs.debug$default("MessageListPresenter", L.toString(), null, 4, null);
                    } else if (this.h) {
                        eventDeps.getMessageSpamActionsInteractor().markChatAsSpam(localMessage.fromId);
                    } else {
                        eventDeps.getMessageSpamActionsInteractor().markChatAsNonSpam(localMessage.fromId);
                    }
                }
            }

            public MessageSpamActionClicked() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull String str, boolean z, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(str, "messageRemoteId");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "listMiddleStateProperty");
                return new MessageListPresenterImpl$Event$MessageSpamActionClicked$invoke$1(str, z, kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "interactorState", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "listSpamActionsStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$Instance;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessageSpamActionsInteractorStateUpdated extends Event {
            @NotNull
            public static final MessageSpamActionsInteractorStateUpdated INSTANCE = new MessageSpamActionsInteractorStateUpdated();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", g.a, "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "interactorState", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListSpamActionsStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listSpamActionsStateProperty", "", "id", "deps", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] h = {a2.b.a.a.a.v0(Instance.class, "listSpamActionsStateProperty", "getListSpamActionsStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;
                public final MessageSpamActionsInteractor.State g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull MessageSpamActionsInteractor.State state, @NotNull KMutableProperty0<PartialState.List.SpamActions> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(MessageSpamActionsInteractorStateUpdated.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(state, "interactorState");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "listSpamActionsStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = state;
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    ChannelItem.SpamActions spamActions;
                    ChannelItem.SpamActions spamActions2;
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    MessageSpamActionsInteractor.State state = this.g;
                    if (Intrinsics.areEqual(state, MessageSpamActionsInteractor.State.Empty.INSTANCE)) {
                        spamActions = null;
                    } else {
                        if (state instanceof MessageSpamActionsInteractor.State.Static) {
                            spamActions2 = new ChannelItem.SpamActions(eventDeps.getChannelId(), ((MessageSpamActionsInteractor.State.Static) this.g).getData().getSuspectMessageId(), ChannelItem.SpamActions.State.Static.INSTANCE);
                        } else if (state instanceof MessageSpamActionsInteractor.State.InProgress) {
                            spamActions2 = new ChannelItem.SpamActions(eventDeps.getChannelId(), ((MessageSpamActionsInteractor.State.InProgress) this.g).getData().getSuspectMessageId(), new ChannelItem.SpamActions.State.InProgress(((MessageSpamActionsInteractor.State.InProgress) this.g).isSpam()));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        spamActions = spamActions2;
                    }
                    this.f.getValue((EventInstance.WriteKeyProperty) this, h[0]).set(new PartialState.List.SpamActions(spamActions));
                }
            }

            public MessageSpamActionsInteractorStateUpdated() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull MessageSpamActionsInteractor.State state, @NotNull KMutableProperty0<PartialState.List.SpamActions> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(state, "interactorState");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "listSpamActionsStateProperty");
                return new MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1(state, kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JL\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedEmpty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedEmpty$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessagesLoadedEmpty extends Event {
            @NotNull
            public static final MessagesLoadedEmpty INSTANCE = new MessagesLoadedEmpty();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BA\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedEmpty$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "h", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListBottomStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listBottomStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "f", "getListTopStateProperty", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", g.a, "getListMiddleStateProperty", "listMiddleStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] i = {a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listBottomStateProperty", "getListBottomStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;
                public final EventInstance.WriteKeyProperty g;
                public final EventInstance.WriteKeyProperty h;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty03, long j, @NotNull EventDeps eventDeps) {
                    super(MessagesLoadedEmpty.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listBottomStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.WriteKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    eventDeps.getPerfTracker().trackMessagesLoad();
                    eventDeps.getPerfTracker().startMessagesPreparing();
                    EventInstance.WriteKeyProperty writeKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = i;
                    writeKeyProperty.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[0]).set(new PartialState.List.Top.Empty(false));
                    this.g.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[1]).set(PartialState.List.Middle.Empty.INSTANCE);
                    this.h.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[2]).set(PartialState.List.Bottom.Empty.INSTANCE);
                    eventDeps.getPerfTracker().trackMessagesPreparing();
                }
            }

            public MessagesLoadedEmpty() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty03) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "listTopStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listBottomStateProperty");
                return new MessageListPresenterImpl$Event$MessagesLoadedEmpty$invoke$1(kMutableProperty0, kMutableProperty02, kMutableProperty03);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018Jz\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00112\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u00060\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\n¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedNonEmpty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "messagesAndMetaInfo", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "metaStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedNonEmpty$Instance;", "invoke", "(Ljava/util/List;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessagesLoadedNonEmpty extends Event {
            @NotNull
            public static final MessagesLoadedNonEmpty INSTANCE = new MessagesLoadedNonEmpty();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001Bo\u0012\u001e\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bj\u0002`\u001e0\u001a\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\b\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b)\u0010*J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R.\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bj\u0002`\u001e0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R#\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadedNonEmpty$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "i", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", AuthSource.SEND_ABUSE, "()Lkotlin/reflect/KMutableProperty0;", "listMiddleStateProperty", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", g.a, "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KProperty0;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "f", "getMetaStateProperty", "metaStateProperty", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "j", "Ljava/util/List;", "messagesAndMetaInfo", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "h", "getListTopStateProperty", "listTopStateProperty", "", "id", "deps", "<init>", "(Ljava/util/List;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] k = {a2.b.a.a.a.v0(Instance.class, "metaStateProperty", "getMetaStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.ReadKeyProperty g;
                public final EventInstance.WriteKeyProperty h;
                public final EventInstance.WriteKeyProperty i;
                public final List<Pair<LocalMessage, MessageMetaInfo>> j;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull List<Pair<LocalMessage, MessageMetaInfo>> list, @NotNull KMutableProperty0<PartialState.Meta> kMutableProperty0, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty04, long j2, @NotNull EventDeps eventDeps) {
                    super(MessagesLoadedNonEmpty.INSTANCE, j2, eventDeps);
                    Intrinsics.checkNotNullParameter(list, "messagesAndMetaInfo");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "metaStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty04, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.j = list;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.ReadKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                    this.i = new EventInstance.WriteKeyProperty(kMutableProperty04, getKeys());
                }

                public final KMutableProperty0<PartialState.List.Middle> a() {
                    return this.i.getValue((EventInstance.WriteKeyProperty) this, k[3]);
                }

                /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c8, code lost:
                    if (com.avito.android.remote.model.messenger.MessengerTimestamp.toMillis(r12.created) < r14) goto L_0x00df;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d8, code lost:
                    if (r4.longValue() < r14) goto L_0x00df;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:36:0x00dd, code lost:
                    if (r12.isRead != false) goto L_0x00df;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e1, code lost:
                    r4 = false;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void doHandle(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps r17) {
                    /*
                    // Method dump skipped, instructions count: 463
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.Event.MessagesLoadedNonEmpty.Instance.doHandle(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$EventDeps):void");
                }
            }

            public MessagesLoadedNonEmpty() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull List<Pair<LocalMessage, MessageMetaInfo>> list, @NotNull KMutableProperty0<PartialState.Meta> kMutableProperty0, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty04) {
                Intrinsics.checkNotNullParameter(list, "messagesAndMetaInfo");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "metaStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty04, "listMiddleStateProperty");
                return new MessageListPresenterImpl$Event$MessagesLoadedNonEmpty$invoke$1(list, kMutableProperty0, kMutableProperty02, kMutableProperty03, kMutableProperty04);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JL\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingError$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessagesLoadingError extends Event {
            @NotNull
            public static final MessagesLoadingError INSTANCE = new MessagesLoadingError();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BA\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingError$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListTopStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", g.a, "getListMiddleStateProperty", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "h", "getListBottomStateProperty", "listBottomStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] i = {a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listBottomStateProperty", "getListBottomStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;
                public final EventInstance.WriteKeyProperty g;
                public final EventInstance.WriteKeyProperty h;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty03, long j, @NotNull EventDeps eventDeps) {
                    super(MessagesLoadingError.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listBottomStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.WriteKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    eventDeps.getPerfTracker().trackMessagesLoadError();
                    eventDeps.getPerfTracker().startMessagesPreparing();
                    EventInstance.WriteKeyProperty writeKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = i;
                    writeKeyProperty.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[0]).set(new PartialState.List.Top.Empty(false));
                    this.g.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[1]).set(PartialState.List.Middle.LoadingError.INSTANCE);
                    this.h.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[2]).set(PartialState.List.Bottom.Empty.INSTANCE);
                    eventDeps.getPerfTracker().trackMessagesPreparingError();
                }
            }

            public MessagesLoadingError() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty03) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "listTopStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listBottomStateProperty");
                return new MessageListPresenterImpl$Event$MessagesLoadingError$invoke$1(kMutableProperty0, kMutableProperty02, kMutableProperty03);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014Jb\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\n¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingStart;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "shouldTriggerInteractor", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingStart$Instance;", "invoke", "(ZLkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class MessagesLoadingStart extends Event {
            @NotNull
            public static final MessagesLoadingStart INSTANCE = new MessagesLoadingStart();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BW\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\b\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR#\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$MessagesLoadingStart$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", g.a, "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListTopStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listTopStateProperty", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KProperty0;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "i", "getListBottomStateProperty", "listBottomStateProperty", "", "j", "Z", "shouldTriggerInteractor", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "h", "getListMiddleStateProperty", "listMiddleStateProperty", "", "id", "deps", "<init>", "(ZLkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] k = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listBottomStateProperty", "getListBottomStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.WriteKeyProperty g;
                public final EventInstance.WriteKeyProperty h;
                public final EventInstance.WriteKeyProperty i;
                public final boolean j;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(boolean z, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty04, long j2, @NotNull EventDeps eventDeps) {
                    super(MessagesLoadingStart.INSTANCE, j2, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty04, "listBottomStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.j = z;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.WriteKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                    this.i = new EventInstance.WriteKeyProperty(kMutableProperty04, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = k;
                    PartialState.Context context = (PartialState.Context) readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    String access$getCurrentUserId$p = MessageListPresenterKt.access$getCurrentUserId$p(context);
                    if (!m.isBlank(access$getCurrentUserId$p)) {
                        if (this.j) {
                            eventDeps.getMessageListInteractor().loadFirstPage(access$getCurrentUserId$p);
                        }
                        this.g.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[1]).set(new PartialState.List.Top.Empty(false));
                        this.h.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[2]).set(new PartialState.List.Middle.LoadingInProgress(CollectionsKt__CollectionsKt.emptyList()));
                        this.i.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[3]).set(PartialState.List.Bottom.Empty.INSTANCE);
                        return;
                    }
                    MessageListInconsistentStateException messageListInconsistentStateException = new MessageListInconsistentStateException("Event.MessagesLoadingStart arrived when userId wasn't available (contextState=" + context + ')', null, 2, null);
                    ErrorTracker.DefaultImpls.track$default(((EventDeps) getDeps()).getErrorTracker(), messageListInconsistentStateException, null, q.mapOf(TuplesKt.to("contextState", MessageListPresenterKt.access$getShortStr$p(context))), 2, null);
                    Logs.warning("MessageListPresenter", "Inconsistent state", messageListInconsistentStateException);
                }
            }

            public MessagesLoadingStart() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(boolean z, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty04) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listTopStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty04, "listBottomStateProperty");
                return new MessageListPresenterImpl$Event$MessagesLoadingStart$invoke$1(z, kMutableProperty0, kMutableProperty02, kMutableProperty03, kMutableProperty04);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JL\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationError$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class PaginationError extends Event {
            @NotNull
            public static final PaginationError INSTANCE = new PaginationError();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BA\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationError$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "h", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListTopStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listTopStateProperty", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", g.a, "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getListMiddleStateProperty", "()Lkotlin/reflect/KProperty0;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "getContextStateProperty", "contextStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] i = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.ReadKeyProperty g;
                public final EventInstance.WriteKeyProperty h;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03, long j, @NotNull EventDeps eventDeps) {
                    super(PaginationError.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.ReadKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = i;
                    Object obj = readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    if (!(obj instanceof PartialState.Context.Loaded)) {
                        obj = null;
                    }
                    PartialState.Context.Loaded loaded = (PartialState.Context.Loaded) obj;
                    Object obj2 = this.g.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[1]).get();
                    if (!(obj2 instanceof PartialState.List.Middle.LoadingSuccess)) {
                        obj2 = null;
                    }
                    PartialState.List.Middle.LoadingSuccess loadingSuccess = (PartialState.List.Middle.LoadingSuccess) obj2;
                    if (loaded == null || loadingSuccess == null) {
                        StringBuilder L = a2.b.a.a.a.L("Pagination ignored: Event.PaginationError arrived when context or first page weren't loaded: \n\t ctxState = ");
                        L.append((PartialState.Context) this.f.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get());
                        L.append(", \n\t listMiddleState = ");
                        L.append((PartialState.List.Middle) this.g.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[1]).get());
                        Logs.debug$default("MessageListPresenter", L.toString(), null, 4, null);
                        return;
                    }
                    eventDeps.getAppendCounter().trackError();
                    if (eventDeps.getPerfTracker().isTrackingLoadMore()) {
                        eventDeps.getPerfTracker().trackMessagesLoadError();
                        eventDeps.getPerfTracker().startMessagesPreparing();
                    }
                    this.h.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[2]).set(PartialState.List.Top.PaginationError.INSTANCE);
                    if (eventDeps.getPerfTracker().isTrackingLoadMore()) {
                        eventDeps.getPerfTracker().trackMessagesPreparingError();
                    }
                }
            }

            public PaginationError() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                return new MessageListPresenterImpl$Event$PaginationError$invoke$1(kMutableProperty0, kMutableProperty02, kMutableProperty03);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JT\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\n¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationStart;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "shouldTriggerInteractor", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationStart$Instance;", "invoke", "(ZLkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class PaginationStart extends Event {
            @NotNull
            public static final PaginationStart INSTANCE = new PaginationStart();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BI\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0013\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationStart$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KProperty0;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", g.a, "getListMiddleStateProperty", "listMiddleStateProperty", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "h", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListTopStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listTopStateProperty", "", "i", "Z", "shouldTriggerInteractor", "", "id", "deps", "<init>", "(ZLkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] j = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.ReadKeyProperty g;
                public final EventInstance.WriteKeyProperty h;
                public final boolean i;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(boolean z, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03, long j2, @NotNull EventDeps eventDeps) {
                    super(PaginationStart.INSTANCE, j2, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.i = z;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.ReadKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = j;
                    Object obj = readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    if (!(obj instanceof PartialState.Context.Loaded)) {
                        obj = null;
                    }
                    PartialState.Context.Loaded loaded = (PartialState.Context.Loaded) obj;
                    Object obj2 = this.g.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[1]).get();
                    if (!(obj2 instanceof PartialState.List.Middle.LoadingSuccess)) {
                        obj2 = null;
                    }
                    PartialState.List.Middle.LoadingSuccess loadingSuccess = (PartialState.List.Middle.LoadingSuccess) obj2;
                    PartialState.List.Top top = (PartialState.List.Top) this.h.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[2]).get();
                    if (loaded == null || loadingSuccess == null) {
                        StringBuilder L = a2.b.a.a.a.L("Pagination is ignored: Event.PaginationStart arrived when context or first page weren't loaded \n\t ctxState = ");
                        L.append((PartialState.Context) this.f.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get());
                        L.append(", \n\t listMiddleState = ");
                        L.append((PartialState.List.Middle) this.g.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[1]).get());
                        Logs.debug$default("MessageListPresenter", L.toString(), null, 4, null);
                    } else if (!(top instanceof PartialState.List.Top.PaginationInProgress)) {
                        eventDeps.getPerfTracker().startLoadMoreSession(loadingSuccess.getItems().size());
                        eventDeps.getPerfTracker().startMessagesLoading();
                        if (this.i) {
                            eventDeps.getMessageListInteractor().loadPrevPage(loaded.getCurrentUserId());
                        }
                        this.h.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[2]).set(PartialState.List.Top.PaginationInProgress.INSTANCE);
                    }
                }
            }

            public PaginationStart() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(boolean z, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                return new MessageListPresenterImpl$Event$PaginationStart$invoke$1(z, kMutableProperty0, kMutableProperty02, kMutableProperty03);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JT\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\n¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationSuccess;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "paginationIsEnabled", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationSuccess$Instance;", "invoke", "(ZLkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class PaginationSuccess extends Event {
            @NotNull
            public static final PaginationSuccess INSTANCE = new PaginationSuccess();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BI\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$PaginationSuccess$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "h", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListTopStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listTopStateProperty", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", g.a, "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getListMiddleStateProperty", "()Lkotlin/reflect/KProperty0;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "getContextStateProperty", "contextStateProperty", "", "i", "Z", "paginationIsEnabled", "", "id", "deps", "<init>", "(ZLkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] j = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.ReadKeyProperty g;
                public final EventInstance.WriteKeyProperty h;
                public final boolean i;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(boolean z, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03, long j2, @NotNull EventDeps eventDeps) {
                    super(PaginationSuccess.INSTANCE, j2, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.i = z;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.ReadKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = j;
                    Object obj = readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    if (!(obj instanceof PartialState.Context.Loaded)) {
                        obj = null;
                    }
                    PartialState.Context.Loaded loaded = (PartialState.Context.Loaded) obj;
                    Object obj2 = this.g.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[1]).get();
                    if (!(obj2 instanceof PartialState.List.Middle.LoadingSuccess)) {
                        obj2 = null;
                    }
                    PartialState.List.Middle.LoadingSuccess loadingSuccess = (PartialState.List.Middle.LoadingSuccess) obj2;
                    if (loaded == null || loadingSuccess == null) {
                        StringBuilder L = a2.b.a.a.a.L("Pagination ignored: Event.PaginationSuccess arrived when context or first page weren't loaded \n\t ctxState = ");
                        L.append((PartialState.Context) this.f.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get());
                        L.append(", \n\t listMiddleState = ");
                        L.append((PartialState.List.Middle) this.g.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[1]).get());
                        Logs.debug$default("MessageListPresenter", L.toString(), null, 4, null);
                        return;
                    }
                    if (eventDeps.getPerfTracker().isTrackingLoadMore()) {
                        eventDeps.getPerfTracker().trackMessagesLoad();
                    }
                    eventDeps.getAppendCounter().trackSuccess();
                    this.h.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[2]).set(new PartialState.List.Top.Empty(this.i));
                }
            }

            public PaginationSuccess() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(boolean z, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty03) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listTopStateProperty");
                return new MessageListPresenterImpl$Event$PaginationSuccess$invoke$1(z, kMutableProperty0, kMutableProperty02, kMutableProperty03);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JZ\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\n¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$Refresh;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$Refresh$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Refresh extends Event {
            @NotNull
            public static final Refresh INSTANCE = new Refresh();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BO\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$Refresh$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "i", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListBottomStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listBottomStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "h", AuthSource.SEND_ABUSE, "listMiddleStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", g.a, "getListTopStateProperty", "listTopStateProperty", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KProperty0;", "contextStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] j = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listTopStateProperty", "getListTopStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KMutableProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listBottomStateProperty", "getListBottomStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.WriteKeyProperty g;
                public final EventInstance.WriteKeyProperty h;
                public final EventInstance.WriteKeyProperty i;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty04, long j2, @NotNull EventDeps eventDeps) {
                    super(Refresh.INSTANCE, j2, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listTopStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty04, "listBottomStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.WriteKeyProperty(kMutableProperty02, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty03, getKeys());
                    this.i = new EventInstance.WriteKeyProperty(kMutableProperty04, getKeys());
                }

                public final KMutableProperty0<PartialState.List.Middle> a() {
                    return this.h.getValue((EventInstance.WriteKeyProperty) this, j[2]);
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    eventDeps.getPerfTracker().startReloadSession(0);
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = j;
                    PartialState.Context context = (PartialState.Context) readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    String access$getCurrentUserId$p = MessageListPresenterKt.access$getCurrentUserId$p(context);
                    if (context instanceof PartialState.Context.LoadingError) {
                        eventDeps.getChannelContextInteractor().initialDataRequest(true);
                    }
                    if ((a().get() instanceof PartialState.List.Middle.LoadingError) && (!m.isBlank(access$getCurrentUserId$p))) {
                        eventDeps.getPerfTracker().startMessagesLoading();
                        eventDeps.getMessageListInteractor().loadFirstPage(access$getCurrentUserId$p);
                    }
                    this.g.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[1]).set(new PartialState.List.Top.Empty(false));
                    a().set(new PartialState.List.Middle.LoadingInProgress(MessageListPresenterKt.access$getRawItems$p(a())));
                    this.i.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[3]).set(PartialState.List.Bottom.Empty.INSTANCE);
                }
            }

            public Refresh() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Top> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty03, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty04) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listTopStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listMiddleStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty04, "listBottomStateProperty");
                return new MessageListPresenterImpl$Event$Refresh$invoke$1(kMutableProperty0, kMutableProperty02, kMutableProperty03, kMutableProperty04);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ScreenOpened;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "metaStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ScreenOpened$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ScreenOpened extends Event {
            @NotNull
            public static final ScreenOpened INSTANCE = new ScreenOpened();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$ScreenOpened$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getMetaStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "metaStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] g = {a2.b.a.a.a.v0(Instance.class, "metaStateProperty", "getMetaStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.Meta> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(ScreenOpened.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "metaStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    this.f.getValue((EventInstance.WriteKeyProperty) this, g[0]).set(new PartialState.Meta(Long.valueOf(eventDeps.getTimeSource().now())));
                }
            }

            public ScreenOpened() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.Meta> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "metaStateProperty");
                return new MessageListPresenterImpl$Event$ScreenOpened$invoke$1(kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$SyncMissingUsersEvent;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "messages", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$SyncMissingUsersEvent$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class SyncMissingUsersEvent extends Event {
            @NotNull
            public static final SyncMissingUsersEvent INSTANCE = new SyncMissingUsersEvent();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B3\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$SyncMissingUsersEvent$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getContextStateProperty", "()Lkotlin/reflect/KProperty0;", "contextStateProperty", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", g.a, "Ljava/util/List;", "messages", "Lkotlin/reflect/KMutableProperty0;", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;Ljava/util/List;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] h = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final List<LocalMessage> g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull List<LocalMessage> list, long j, @NotNull EventDeps eventDeps) {
                    super(SyncMissingUsersEvent.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(list, "messages");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.g = list;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    eventDeps.getMissingUsersSyncAgent().syncMissingUsers(MessageListPresenterKt.access$getCurrentUserId$p((PartialState.Context) this.f.getValue((EventInstance.ReadKeyProperty) this, h[0]).get()), eventDeps.getChannelId(), this.g);
                }
            }

            public SyncMissingUsersEvent() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull List<LocalMessage> list) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                Intrinsics.checkNotNullParameter(list, "messages");
                return new MessageListPresenterImpl$Event$SyncMissingUsersEvent$invoke$1(kMutableProperty0, list);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UserInteractedWithList;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UserInteractedWithList$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class UserInteractedWithList extends Event {
            @NotNull
            public static final UserInteractedWithList INSTANCE = new UserInteractedWithList();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UserInteractedWithList$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListMiddleStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listMiddleStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] g = {a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(UserInteractedWithList.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.WriteKeyProperty writeKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = g;
                    Object obj = writeKeyProperty.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[0]).get();
                    if (!(obj instanceof PartialState.List.Middle.LoadingSuccess)) {
                        obj = null;
                    }
                    PartialState.List.Middle.LoadingSuccess loadingSuccess = (PartialState.List.Middle.LoadingSuccess) obj;
                    if (loadingSuccess != null && !loadingSuccess.getUserInteractedWithList()) {
                        this.f.getValue((EventInstance.WriteKeyProperty) this, kPropertyArr[0]).set(new PartialState.List.Middle.LoadingSuccess(loadingSuccess.getItems(), loadingSuccess.getRawItems(), loadingSuccess.getLatestReadMessageBeforeOpen(), loadingSuccess.getNewMessagesDividerPosition(), true));
                    }
                }
            }

            public UserInteractedWithList() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "listMiddleStateProperty");
                return new MessageListPresenterImpl$Event$UserInteractedWithList$invoke$1(kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersFinishedTyping;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersFinishedTyping$Instance;", "invoke", "(Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class UsersFinishedTyping extends Event {
            @NotNull
            public static final UsersFinishedTyping INSTANCE = new UsersFinishedTyping();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersFinishedTyping$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "f", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListBottomStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listBottomStateProperty", "", "id", "deps", "<init>", "(Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] g = {a2.b.a.a.a.v0(Instance.class, "listBottomStateProperty", "getListBottomStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.WriteKeyProperty f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty0, long j, @NotNull EventDeps eventDeps) {
                    super(UsersFinishedTyping.INSTANCE, j, eventDeps);
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "listBottomStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.f = new EventInstance.WriteKeyProperty(kMutableProperty0, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    this.f.getValue((EventInstance.WriteKeyProperty) this, g[0]).set(PartialState.List.Bottom.Empty.INSTANCE);
                }
            }

            public UsersFinishedTyping() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty0) {
                Intrinsics.checkNotNullParameter(kMutableProperty0, "listBottomStateProperty");
                return new MessageListPresenterImpl$Event$UsersFinishedTyping$invoke$1(kMutableProperty0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JT\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\n¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersStartedTyping;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "", "typingUserId", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomStateProperty", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleStateProperty", "Lkotlin/Function2;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersStartedTyping$Instance;", "invoke", "(Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Instance", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class UsersStartedTyping extends Event {
            @NotNull
            public static final UsersStartedTyping INSTANCE = new UsersStartedTyping();

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001BI\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UsersStartedTyping$Instance;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "", "doHandle", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "Lkotlin/reflect/KProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", g.a, "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$ReadKeyProperty;", "getListMiddleStateProperty", "()Lkotlin/reflect/KProperty0;", "listMiddleStateProperty", "Lkotlin/reflect/KMutableProperty0;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "h", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance$WriteKeyProperty;", "getListBottomStateProperty", "()Lkotlin/reflect/KMutableProperty0;", "listBottomStateProperty", "", "i", "Ljava/lang/String;", "typingUserId", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "f", "getContextStateProperty", "contextStateProperty", "", "id", "deps", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;Lkotlin/reflect/KMutableProperty0;JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Instance extends EventInstance<Event, PartialState, EventDeps> {
                public static final /* synthetic */ KProperty[] j = {a2.b.a.a.a.v0(Instance.class, "contextStateProperty", "getContextStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listMiddleStateProperty", "getListMiddleStateProperty()Lkotlin/reflect/KProperty0;", 0), a2.b.a.a.a.v0(Instance.class, "listBottomStateProperty", "getListBottomStateProperty()Lkotlin/reflect/KMutableProperty0;", 0)};
                public final EventInstance.ReadKeyProperty f;
                public final EventInstance.ReadKeyProperty g;
                public final EventInstance.WriteKeyProperty h;
                public final String i;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Instance(@NotNull String str, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty03, long j2, @NotNull EventDeps eventDeps) {
                    super(UsersStartedTyping.INSTANCE, j2, eventDeps);
                    Intrinsics.checkNotNullParameter(str, "typingUserId");
                    Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty02, "listBottomStateProperty");
                    Intrinsics.checkNotNullParameter(kMutableProperty03, "listMiddleStateProperty");
                    Intrinsics.checkNotNullParameter(eventDeps, "deps");
                    this.i = str;
                    this.f = new EventInstance.ReadKeyProperty(kMutableProperty0, getKeys());
                    this.g = new EventInstance.ReadKeyProperty(kMutableProperty03, getKeys());
                    this.h = new EventInstance.WriteKeyProperty(kMutableProperty02, getKeys());
                }

                public void doHandle(@NotNull EventDeps eventDeps) {
                    T t;
                    PublicProfile publicProfile;
                    ChatAvatar avatar;
                    LocalMessage localMessage;
                    List<ChannelItem> items;
                    Intrinsics.checkNotNullParameter(eventDeps, "$this$doHandle");
                    EventInstance.ReadKeyProperty readKeyProperty = this.f;
                    KProperty<?>[] kPropertyArr = j;
                    Object obj = readKeyProperty.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get();
                    Image image = null;
                    if (!(obj instanceof PartialState.Context.Loaded)) {
                        obj = null;
                    }
                    PartialState.Context.Loaded loaded = (PartialState.Context.Loaded) obj;
                    Object obj2 = this.g.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[1]).get();
                    if (!(obj2 instanceof PartialState.List.Middle.LoadingSuccess)) {
                        obj2 = null;
                    }
                    PartialState.List.Middle.LoadingSuccess loadingSuccess = (PartialState.List.Middle.LoadingSuccess) obj2;
                    if (loaded != null) {
                        Iterator<T> it = loaded.getUsers().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it.next();
                            if (Intrinsics.areEqual(t.getId(), this.i)) {
                                break;
                            }
                        }
                        T t2 = t;
                        if (t2 != null) {
                            ChannelItem channelItem = (loadingSuccess == null || (items = loadingSuccess.getItems()) == null) ? null : (ChannelItem) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) items);
                            if (!(channelItem instanceof ChannelItem.Message)) {
                                channelItem = null;
                            }
                            ChannelItem.Message message = (ChannelItem.Message) channelItem;
                            String str = this.i;
                            if (!(!(!Intrinsics.areEqual((message == null || (localMessage = message.getLocalMessage()) == null) ? null : localMessage.fromId, t2.getId())) || (publicProfile = t2.getPublicProfile()) == null || (avatar = publicProfile.getAvatar()) == null)) {
                                image = avatar.getImage();
                            }
                            this.h.getValue((EventInstance.WriteKeyProperty) this, j[2]).set(new PartialState.List.Bottom.UsersTyping(new ChannelItem.TypingIndicator(str, image)));
                            return;
                        }
                        StringBuilder Q = a2.b.a.a.a.Q("Event.UsersStartedTyping handler couldn't find typingUser to display: \n", "\t typingUserId = ");
                        Q.append(this.i);
                        Q.append(", \n");
                        Q.append("\t users = ");
                        Q.append(loaded.getUsers());
                        MessageListInconsistentStateException messageListInconsistentStateException = new MessageListInconsistentStateException(Q.toString(), null, 2, null);
                        ErrorTracker.DefaultImpls.track$default(((EventDeps) getDeps()).getErrorTracker(), messageListInconsistentStateException, null, null, 6, null);
                        Logs.warning("MessageListPresenter", "Typing event handler error", messageListInconsistentStateException);
                        return;
                    }
                    MessageListInconsistentStateException messageListInconsistentStateException2 = new MessageListInconsistentStateException("Event.UsersStartedTyping arrived when context wasn't loaded", null, 2, null);
                    ErrorTracker.DefaultImpls.track$default(((EventDeps) getDeps()).getErrorTracker(), messageListInconsistentStateException2, null, q.mapOf(TuplesKt.to("ctxState", MessageListPresenterKt.access$getShortStr$p((PartialState) this.f.getValue((EventInstance.ReadKeyProperty) this, kPropertyArr[0]).get()))), 2, null);
                    Logs.warning("MessageListPresenter", "Inconsistent state", messageListInconsistentStateException2);
                }
            }

            public UsersStartedTyping() {
                super(null);
            }

            @NotNull
            public final Function2<Long, EventDeps, Instance> invoke(@NotNull String str, @NotNull KMutableProperty0<PartialState.Context> kMutableProperty0, @NotNull KMutableProperty0<PartialState.List.Bottom> kMutableProperty02, @NotNull KMutableProperty0<PartialState.List.Middle> kMutableProperty03) {
                Intrinsics.checkNotNullParameter(str, "typingUserId");
                Intrinsics.checkNotNullParameter(kMutableProperty0, "contextStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty02, "listBottomStateProperty");
                Intrinsics.checkNotNullParameter(kMutableProperty03, "listMiddleStateProperty");
                return new MessageListPresenterImpl$Event$UsersStartedTyping$invoke$1(str, kMutableProperty0, kMutableProperty02, kMutableProperty03);
            }
        }

        public Event() {
        }

        public Event(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0016\u0010\u0006\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0012R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0012R\u0018\u0010.\u001a\u0004\u0018\u00010\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00108\u001a\u0002058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020$0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0012R\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0012R\u0016\u0010U\u001a\u00020R8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020V0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0012¨\u0006Y"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "getMessageSpamActionsInteractor", "()Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "messageSpamActionsInteractor", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "getMessageListItemConverter", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "messageListItemConverter", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "getAppendCounter", "()Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "appendCounter", "Landroidx/lifecycle/MutableLiveData;", "", "getLinkMessageWithUrlClickedStream", "()Landroidx/lifecycle/MutableLiveData;", "linkMessageWithUrlClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "getMessageListInteractor", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor;", "messageListInteractor", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getLocationMessageClickedStream", "locationMessageClickedStream", "Lcom/avito/android/util/Formatter;", "", "getErrorFormatter", "()Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "getSystemUserAvatarClickedStream", "systemUserAvatarClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/ItemMessageInfo;", "getItemMessageClickedStream", "itemMessageClickedStream", "getErrorMessageStream", "errorMessageStream", "getMessageId", "()Ljava/lang/String;", "messageId", "getChannelId", "channelId", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "getChannelMenuInteractor", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "channelMenuInteractor", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "getMissingUsersSyncAgent", "()Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "missingUsersSyncAgent", "Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "getPerfTracker", "()Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "perfTracker", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "getDeeplinkProcessor", "()Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deeplinkProcessor", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "getFileDownloadManager", "()Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "fileDownloadManager", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "getChannelContextInteractor", "()Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "getErrorTracker", "()Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "getUnknownMessageClickedStream", "unknownMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/PlatformMapData;", "getPlatformMapMessageClickedStream", "platformMapMessageClickedStream", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/messages/OpenGalleryData;", "getImageMessageClickedStream", "imageMessageClickedStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface EventDeps extends BaseEventDeps<PartialState> {
        @NotNull
        Analytics getAnalytics();

        @NotNull
        MessengerGraphiteCounter getAppendCounter();

        @NotNull
        ChannelContextInteractor getChannelContextInteractor();

        @NotNull
        String getChannelId();

        @NotNull
        ChannelMenuInteractor getChannelMenuInteractor();

        @NotNull
        DeeplinkProcessor getDeeplinkProcessor();

        @NotNull
        Formatter<Throwable> getErrorFormatter();

        @NotNull
        MutableLiveData<String> getErrorMessageStream();

        @NotNull
        ErrorTracker getErrorTracker();

        @NotNull
        FileDownloadManager getFileDownloadManager();

        @NotNull
        MutableLiveData<OpenGalleryData> getImageMessageClickedStream();

        @NotNull
        MutableLiveData<ItemMessageInfo> getItemMessageClickedStream();

        @NotNull
        MutableLiveData<String> getLinkMessageWithUrlClickedStream();

        @NotNull
        MutableLiveData<MessageBody.Location> getLocationMessageClickedStream();

        @Nullable
        String getMessageId();

        @NotNull
        MessageListInteractor getMessageListInteractor();

        @NotNull
        MessageListItemConverter getMessageListItemConverter();

        @NotNull
        MessageSpamActionsInteractor getMessageSpamActionsInteractor();

        @NotNull
        MissingUsersSyncAgent getMissingUsersSyncAgent();

        @NotNull
        ChannelTracker getPerfTracker();

        @NotNull
        MutableLiveData<PlatformMapData> getPlatformMapMessageClickedStream();

        @NotNull
        MutableLiveData<Unit> getSystemUserAvatarClickedStream();

        @NotNull
        TimeSource getTimeSource();

        @NotNull
        MutableLiveData<Unit> getUnknownMessageClickedStream();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "", "<init>", "()V", "Context", "List", "Meta", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class PartialState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "<init>", "()V", "Empty", "Loaded", "LoadedOnlyUserId", "LoadingError", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$LoadedOnlyUserId;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$LoadingError;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Context extends PartialState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Empty extends Context {
                @NotNull
                public static final Empty INSTANCE = new Empty();

                public Empty() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "Context.Empty";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "La2/a/a/o1/d/a0/i/b;", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCurrentUserId", "currentUserId", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "getContext", "()Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "context", "", "Lcom/avito/android/remote/model/User;", "c", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "users", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context/ChannelContext;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Loaded extends Context implements b {
                @NotNull
                public final String a;
                @NotNull
                public final ChannelContext b;
                @NotNull
                public final java.util.List<User> c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Loaded(@NotNull String str, @NotNull ChannelContext channelContext, @NotNull java.util.List<User> list) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "currentUserId");
                    Intrinsics.checkNotNullParameter(channelContext, "context");
                    Intrinsics.checkNotNullParameter(list, "users");
                    this.a = str;
                    this.b = channelContext;
                    this.c = list;
                }

                @NotNull
                public final ChannelContext getContext() {
                    return this.b;
                }

                @Override // a2.a.a.o1.d.a0.i.b
                @NotNull
                public String getCurrentUserId() {
                    return this.a;
                }

                @NotNull
                public final java.util.List<User> getUsers() {
                    return this.c;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a2.b.a.a.a.L("Context.Loaded(currentUserId = ");
                    L.append(getCurrentUserId());
                    L.append(", channel = ");
                    L.append(this.b);
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$LoadedOnlyUserId;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "La2/a/a/o1/d/a0/i/b;", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCurrentUserId", "currentUserId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class LoadedOnlyUserId extends Context implements b {
                @NotNull
                public final String a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public LoadedOnlyUserId(@NotNull String str) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "currentUserId");
                    this.a = str;
                }

                @Override // a2.a.a.o1.d.a0.i.b
                @NotNull
                public String getCurrentUserId() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a2.b.a.a.a.L("Context.LoadedOnlyUserId(currentUserId = ");
                    L.append(getCurrentUserId());
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context$LoadingError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "La2/a/a/o1/d/a0/i/b;", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCurrentUserId", "currentUserId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class LoadingError extends Context implements b {
                @NotNull
                public final String a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public LoadingError(@NotNull String str) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "currentUserId");
                    this.a = str;
                }

                @Override // a2.a.a.o1.d.a0.i.b
                @NotNull
                public String getCurrentUserId() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a2.b.a.a.a.L("Context.LoadingError(currentUserId=");
                    L.append(getCurrentUserId());
                    L.append(')');
                    return L.toString();
                }
            }

            public Context() {
                super(null);
            }

            public Context(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "<init>", "()V", "Bottom", "Middle", "SpamActions", "Top", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class List extends PartialState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List;", "<init>", "()V", "Empty", "UsersTyping", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom$UsersTyping;", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static abstract class Bottom extends List {

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class Empty extends Bottom {
                    @NotNull
                    public static final Empty INSTANCE = new Empty();

                    public Empty() {
                        super(null);
                    }

                    @NotNull
                    public String toString() {
                        return "List.Bottom.Empty";
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom$UsersTyping;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;", "getTypingIndicator", "()Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;", "typingIndicator", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class UsersTyping extends Bottom {
                    @NotNull
                    public final ChannelItem.TypingIndicator a;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public UsersTyping(@NotNull ChannelItem.TypingIndicator typingIndicator) {
                        super(null);
                        Intrinsics.checkNotNullParameter(typingIndicator, "typingIndicator");
                        this.a = typingIndicator;
                    }

                    @NotNull
                    public final ChannelItem.TypingIndicator getTypingIndicator() {
                        return this.a;
                    }

                    @NotNull
                    public String toString() {
                        return "List.Bottom.UsersTyping";
                    }
                }

                public Bottom() {
                    super(null);
                }

                public Bottom(j jVar) {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List;", "<init>", "()V", "Empty", "LoadingError", "LoadingInProgress", "LoadingSuccess", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$LoadingInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$LoadingError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$LoadingSuccess;", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static abstract class Middle extends List {

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class Empty extends Middle {
                    @NotNull
                    public static final Empty INSTANCE = new Empty();

                    public Empty() {
                        super(null);
                    }

                    @NotNull
                    public String toString() {
                        return "List.Middle.Empty";
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$LoadingError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class LoadingError extends Middle {
                    @NotNull
                    public static final LoadingError INSTANCE = new LoadingError();

                    public LoadingError() {
                        super(null);
                    }

                    @NotNull
                    public String toString() {
                        return "List.Middle.LoadingError";
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R4\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$LoadingInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "La2/a/a/o1/d/a0/i/a;", "", "toString", "()Ljava/lang/String;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getRawItems", "()Ljava/util/List;", "rawItems", "<init>", "(Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class LoadingInProgress extends Middle implements a2.a.a.o1.d.a0.i.a {
                    @NotNull
                    public final java.util.List<Pair<LocalMessage, MessageMetaInfo>> a;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public LoadingInProgress(@NotNull java.util.List<Pair<LocalMessage, MessageMetaInfo>> list) {
                        super(null);
                        Intrinsics.checkNotNullParameter(list, "rawItems");
                        this.a = list;
                    }

                    @Override // a2.a.a.o1.d.a0.i.a
                    @NotNull
                    public java.util.List<Pair<LocalMessage, MessageMetaInfo>> getRawItems() {
                        return this.a;
                    }

                    @NotNull
                    public String toString() {
                        StringBuilder L = a2.b.a.a.a.L("List.Middle.LoadingInProgress(rawItems=(");
                        L.append(getRawItems().size());
                        L.append(")[add logging to see contents])");
                        return L.toString();
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R4\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle$LoadingSuccess;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "La2/a/a/o1/d/a0/i/a;", "", "toString", "()Ljava/lang/String;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getRawItems", "()Ljava/util/List;", "rawItems", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;", "c", "Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;", "getLatestReadMessageBeforeOpen", "()Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;", "latestReadMessageBeforeOpen", "Lcom/avito/android/messenger/conversation/ChannelItem;", AuthSource.SEND_ABUSE, "getItems", "items", "", "e", "Z", "getUserInteractedWithList", "()Z", "userInteractedWithList", "", "d", "I", "getNewMessagesDividerPosition", "()I", "newMessagesDividerPosition", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/messenger/conversation/mvi/messages/LatestReadMessageBeforeOpen;IZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class LoadingSuccess extends Middle implements a2.a.a.o1.d.a0.i.a {
                    @NotNull
                    public final java.util.List<ChannelItem> a;
                    @NotNull
                    public final java.util.List<Pair<LocalMessage, MessageMetaInfo>> b;
                    @NotNull
                    public final LatestReadMessageBeforeOpen c;
                    public final int d;
                    public final boolean e;

                    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                    public /* synthetic */ LoadingSuccess(java.util.List list, java.util.List list2, LatestReadMessageBeforeOpen latestReadMessageBeforeOpen, int i, boolean z, int i2, j jVar) {
                        this(list, list2, (i2 & 4) != 0 ? LatestReadMessageBeforeOpen.NotFound.INSTANCE : latestReadMessageBeforeOpen, i, z);
                    }

                    @NotNull
                    public final java.util.List<ChannelItem> getItems() {
                        return this.a;
                    }

                    @NotNull
                    public final LatestReadMessageBeforeOpen getLatestReadMessageBeforeOpen() {
                        return this.c;
                    }

                    public final int getNewMessagesDividerPosition() {
                        return this.d;
                    }

                    @Override // a2.a.a.o1.d.a0.i.a
                    @NotNull
                    public java.util.List<Pair<LocalMessage, MessageMetaInfo>> getRawItems() {
                        return this.b;
                    }

                    public final boolean getUserInteractedWithList() {
                        return this.e;
                    }

                    @NotNull
                    public String toString() {
                        StringBuilder L = a2.b.a.a.a.L("List.Middle.LoadingSuccess(items=<");
                        L.append(this.a.size());
                        L.append(" items>, rawItems = <");
                        L.append(getRawItems().size());
                        L.append(" items>, latestReadMessageBeforeOpen = ");
                        L.append(this.c);
                        L.append(", newMessagesDividerPosition = ");
                        L.append(this.d);
                        L.append(",userInteractedWithList = ");
                        return a2.b.a.a.a.A(L, this.e, ')');
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.messenger.conversation.ChannelItem> */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public LoadingSuccess(@NotNull java.util.List<? extends ChannelItem> list, @NotNull java.util.List<Pair<LocalMessage, MessageMetaInfo>> list2, @NotNull LatestReadMessageBeforeOpen latestReadMessageBeforeOpen, int i, boolean z) {
                        super(null);
                        Intrinsics.checkNotNullParameter(list, "items");
                        Intrinsics.checkNotNullParameter(list2, "rawItems");
                        Intrinsics.checkNotNullParameter(latestReadMessageBeforeOpen, "latestReadMessageBeforeOpen");
                        this.a = list;
                        this.b = list2;
                        this.c = latestReadMessageBeforeOpen;
                        this.d = i;
                        this.e = z;
                    }
                }

                public Middle() {
                    super(null);
                }

                public Middle(j jVar) {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "getSpamActions", "()Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "spamActions", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class SpamActions extends List {
                @Nullable
                public final ChannelItem.SpamActions a;

                public SpamActions(@Nullable ChannelItem.SpamActions spamActions) {
                    super(null);
                    this.a = spamActions;
                }

                @Nullable
                public final ChannelItem.SpamActions getSpamActions() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a2.b.a.a.a.L("List.SpamActions(");
                    L.append(this.a);
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List;", "<init>", "()V", "Empty", "PaginationError", "PaginationInProgress", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top$PaginationInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top$PaginationError;", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static abstract class Top extends List {

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Z", "getPaginationIsEnabled", "()Z", "paginationIsEnabled", "<init>", "(Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class Empty extends Top {
                    public final boolean a;

                    public Empty(boolean z) {
                        super(null);
                        this.a = z;
                    }

                    public final boolean getPaginationIsEnabled() {
                        return this.a;
                    }

                    @NotNull
                    public String toString() {
                        return a2.b.a.a.a.A(a2.b.a.a.a.L("List.Top.Empty(paginationIsEnabled="), this.a, ')');
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top$PaginationError;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class PaginationError extends Top {
                    @NotNull
                    public static final PaginationError INSTANCE = new PaginationError();

                    public PaginationError() {
                        super(null);
                    }

                    @NotNull
                    public String toString() {
                        return "List.Top.PaginationError";
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top$PaginationInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class PaginationInProgress extends Top {
                    @NotNull
                    public static final PaginationInProgress INSTANCE = new PaginationInProgress();

                    public PaginationInProgress() {
                        super(null);
                    }

                    @NotNull
                    public String toString() {
                        return "List.Top.PaginationInProgress";
                    }
                }

                public Top() {
                    super(null);
                }

                public Top(j jVar) {
                    super(null);
                }
            }

            public List() {
                super(null);
            }

            public List(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "", "component1", "()Ljava/lang/Long;", "openTimestamp", "copy", "(Ljava/lang/Long;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Long;", "getOpenTimestamp", "<init>", "(Ljava/lang/Long;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Meta extends PartialState {
            @Nullable
            public final Long a;

            public Meta(@Nullable Long l) {
                super(null);
                this.a = l;
            }

            public static /* synthetic */ Meta copy$default(Meta meta, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = meta.a;
                }
                return meta.copy(l);
            }

            @Nullable
            public final Long component1() {
                return this.a;
            }

            @NotNull
            public final Meta copy(@Nullable Long l) {
                return new Meta(l);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Meta) && Intrinsics.areEqual(this.a, ((Meta) obj).a);
                }
                return true;
            }

            @Nullable
            public final Long getOpenTimestamp() {
                return this.a;
            }

            public int hashCode() {
                Long l = this.a;
                if (l != null) {
                    return l.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Meta(openTimestamp=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        public PartialState() {
        }

        public PartialState(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MessageListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MessageListPresenterImpl messageListPresenterImpl) {
            super(0);
            this.a = messageListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MessageListPresenterImpl messageListPresenterImpl = this.a;
            Event.MessagesLoadingStart messagesLoadingStart = Event.MessagesLoadingStart.INSTANCE;
            messageListPresenterImpl.dispatchCommand(new MessageListPresenterImpl$Event$MessagesLoadingStart$invoke$1(true, new n(this.a), new o(this.a), new p(this.a), new a2.a.a.o1.d.a0.i.q(this.a)));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageListPresenterImpl(@NotNull AggregatedState aggregatedState, @NotNull Deps deps) {
        super("MessageListPresenter", aggregatedState, CommandCancelChecker.INSTANCE, deps);
        Intrinsics.checkNotNullParameter(aggregatedState, "defaultState");
        Intrinsics.checkNotNullParameter(deps, "deps");
        this.o = aggregatedState.getMetaState();
        this.p = aggregatedState.getContextState();
        this.q = aggregatedState.getListTopState();
        this.r = aggregatedState.getListMiddleState();
        this.s = aggregatedState.getListBottomState();
        this.t = aggregatedState.getListSpamActionsState();
        this.u = deps.getItemMessageClickedStream();
        this.v = deps.getImageMessageClickedStream();
        this.w = deps.getUnknownMessageClickedStream();
        this.x = deps.getLinkMessageWithUrlClickedStream();
        this.y = deps.getLocationMessageClickedStream();
        this.z = deps.getFileMessageClickInteractor().getFileMessageClickedStream();
        this.A = deps.getPlatformMapMessageClickedStream();
        this.B = deps.getSystemUserAvatarClickedStream();
        this.C = new SingleLiveEvent();
        this.D = deps.getErrorMessageStream();
        this.E = new SingleLiveEvent();
        this.F = deps.getFileMessageClickInteractor().getRequestPermissionsForFileMessageStream();
        this.G = x.setOf(new Effect.StartLoadingOnNewUserId(new a(this)));
        Event.ScreenOpened screenOpened = Event.ScreenOpened.INSTANCE;
        dispatchCommand(new MessageListPresenterImpl$Event$ScreenOpened$invoke$1(new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.m
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((MessageListPresenterImpl) this.receiver).o;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((MessageListPresenterImpl) this.receiver).o = (MessageListPresenterImpl.PartialState.Meta) obj;
            }
        }));
        Scheduler io2 = access$getDeps$p(this).getSchedulers().io();
        CompositeDisposable disposables = getDisposables();
        SharedScheduler sharedScheduler = new SharedScheduler(io2);
        disposables.add(Disposables.fromAction(new io.reactivex.functions.Action() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        Disposable subscribe = access$getDeps$p(this).getChannelContextInteractor().getStateObservable().observeOn(sharedScheduler).subscribeOn(sharedScheduler).skipWhile(new Predicate<ChannelContextInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$1
            public final boolean test(@NotNull ChannelContextInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "contextState");
                return MessageListPresenterImpl.access$isEmptyOrInProgressWithNoUserId$p(MessageListPresenterImpl.this, state);
            }
        }).distinctUntilChanged(new BiPredicate<ChannelContextInteractor.State, ChannelContextInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$2
            /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean test(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor.State r7, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor.State r8) {
                /*
                    r6 = this;
                    java.lang.String r0 = "prev"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r0 = "cur"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                    boolean r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.access$isEmptyOrInProgressWithNoUserId$p(r0, r7)
                    r1 = 0
                    r2 = 1
                    if (r0 == 0) goto L_0x001c
                    com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                    boolean r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.access$isEmptyOrInProgressWithNoUserId$p(r0, r8)
                    if (r0 != 0) goto L_0x00a6
                L_0x001c:
                    com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                    boolean r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.access$isError$p(r0, r7)
                    if (r0 == 0) goto L_0x002c
                    com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                    boolean r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.access$isError$p(r0, r8)
                    if (r0 != 0) goto L_0x00a6
                L_0x002c:
                    com.avito.android.messenger.channels.mvi.common.Loading r0 = r7.getChannelState()
                    boolean r3 = r0 instanceof com.avito.android.messenger.channels.mvi.common.Loading.Success
                    r4 = 0
                    if (r3 != 0) goto L_0x0036
                    r0 = r4
                L_0x0036:
                    com.avito.android.messenger.channels.mvi.common.Loading$Success r0 = (com.avito.android.messenger.channels.mvi.common.Loading.Success) r0
                    if (r0 == 0) goto L_0x003f
                    java.lang.Object r0 = r0.getValue()
                    goto L_0x0040
                L_0x003f:
                    r0 = r4
                L_0x0040:
                    com.avito.android.remote.model.messenger.Channel r0 = (com.avito.android.remote.model.messenger.Channel) r0
                    com.avito.android.messenger.channels.mvi.common.Loading r3 = r8.getChannelState()
                    boolean r5 = r3 instanceof com.avito.android.messenger.channels.mvi.common.Loading.Success
                    if (r5 != 0) goto L_0x004b
                    r3 = r4
                L_0x004b:
                    com.avito.android.messenger.channels.mvi.common.Loading$Success r3 = (com.avito.android.messenger.channels.mvi.common.Loading.Success) r3
                    if (r3 == 0) goto L_0x0054
                    java.lang.Object r3 = r3.getValue()
                    goto L_0x0055
                L_0x0054:
                    r3 = r4
                L_0x0055:
                    com.avito.android.remote.model.messenger.Channel r3 = (com.avito.android.remote.model.messenger.Channel) r3
                    if (r0 == 0) goto L_0x00a3
                    if (r3 != 0) goto L_0x005c
                    goto L_0x00a3
                L_0x005c:
                    java.lang.String r7 = r7.getCurrentUserId()
                    boolean r5 = t6.y.m.isBlank(r7)
                    r5 = r5 ^ r2
                    if (r5 == 0) goto L_0x0068
                    goto L_0x0069
                L_0x0068:
                    r7 = r4
                L_0x0069:
                    java.lang.String r8 = r8.getCurrentUserId()
                    boolean r5 = t6.y.m.isBlank(r8)
                    r5 = r5 ^ r2
                    if (r5 == 0) goto L_0x0075
                    r4 = r8
                L_0x0075:
                    boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
                    r7 = r7 ^ r2
                    if (r7 == 0) goto L_0x007d
                    goto L_0x00a3
                L_0x007d:
                    com.avito.android.remote.model.messenger.context.ChannelContext r7 = r0.getContext()
                    com.avito.android.remote.model.messenger.context.ChannelContext r8 = r3.getContext()
                    boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                    if (r7 == 0) goto L_0x00a3
                    java.util.List r7 = r0.getUsers()
                    java.util.Set r7 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r7)
                    java.util.List r8 = r3.getUsers()
                    java.util.Set r8 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r8)
                    boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                    if (r7 == 0) goto L_0x00a3
                    r7 = 1
                    goto L_0x00a4
                L_0x00a3:
                    r7 = 0
                L_0x00a4:
                    if (r7 == 0) goto L_0x00a7
                L_0x00a6:
                    r1 = 1
                L_0x00a7:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$2.test(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State, com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State):boolean");
            }
        }).subscribe(new Consumer<ChannelContextInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3
            public final void accept(ChannelContextInteractor.State state) {
                Object obj;
                Object obj2;
                MessageListPresenterImpl messageListPresenterImpl = MessageListPresenterImpl.this;
                Loading<Channel> channelState = state.getChannelState();
                if (channelState instanceof Loading.Success) {
                    Intrinsics.checkNotNullExpressionValue(state, "contextState");
                    String currentUserId = state.getCurrentUserId();
                    Object obj3 = null;
                    if (!(!m.isBlank(currentUserId))) {
                        currentUserId = null;
                    }
                    Loading<Channel> channelState2 = state.getChannelState();
                    if (!(channelState2 instanceof Loading.Success)) {
                        channelState2 = null;
                    }
                    Loading.Success success = (Loading.Success) channelState2;
                    if (success != null) {
                        obj3 = success.getValue();
                    }
                    Channel channel = (Channel) obj3;
                    Option none = (currentUserId == null || channel == null) ? OptionKt.none() : OptionKt.some(TuplesKt.to(currentUserId, channel));
                    if (none instanceof None) {
                        MessageListPresenterImpl.Event.EmptyContext emptyContext = MessageListPresenterImpl.Event.EmptyContext.INSTANCE;
                        obj = new MessageListPresenterImpl$Event$EmptyContext$invoke$1(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: CONSTRUCTOR  (r1v22 'obj' java.lang.Object) = 
                              (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3$1$1 : 0x004c: CONSTRUCTOR  (r12v22 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3$1$1) = 
                              (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x004a: IGET  (r1v21 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                              (r11v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3<T> A[IMMUTABLE_TYPE, THIS])
                             com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                             call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3$1$1.<init>(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl):void type: CONSTRUCTOR)
                             call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$EmptyContext$invoke$1.<init>(kotlin.reflect.KMutableProperty0):void type: CONSTRUCTOR in method: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3.accept(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State):void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: CONSTRUCTOR  (r12v22 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3$1$1) = 
                              (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x004a: IGET  (r1v21 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                              (r11v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3<T> A[IMMUTABLE_TYPE, THIS])
                             com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                             call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3$1$1.<init>(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl):void type: CONSTRUCTOR in method: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3.accept(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State):void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:690)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 27 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3$1$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 33 more
                            */
                        /*
                        // Method dump skipped, instructions count: 257
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$3.accept(com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State):void");
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe, "deps.channelContextInter…chCommand()\n            }");
                DisposableKt.addTo(subscribe, getDisposables());
                Disposable subscribe2 = access$getDeps$p(this).getChannelContextInteractor().getStateObservable().observeOn(sharedScheduler).subscribeOn(sharedScheduler).map(MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$4.INSTANCE).distinctUntilChanged().subscribe(new Consumer<Option<? extends String>>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // io.reactivex.functions.Consumer
                    public /* bridge */ /* synthetic */ void accept(Option<? extends String> option) {
                        accept((Option<String>) option);
                    }

                    public final void accept(Option<String> option) {
                        Object obj;
                        MessageListPresenterImpl messageListPresenterImpl = MessageListPresenterImpl.this;
                        if (option instanceof None) {
                            MessageListPresenterImpl.Event.UsersFinishedTyping usersFinishedTyping = MessageListPresenterImpl.Event.UsersFinishedTyping.INSTANCE;
                            obj = new MessageListPresenterImpl$Event$UsersFinishedTyping$invoke$1(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r1v7 'obj' java.lang.Object) = 
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1 : 0x000c: CONSTRUCTOR  (r6v6 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1) = 
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x000a: IGET  (r1v6 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                                  (r5v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5<T> A[IMMUTABLE_TYPE, THIS])
                                 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1.<init>(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl):void type: CONSTRUCTOR)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$UsersFinishedTyping$invoke$1.<init>(kotlin.reflect.KMutableProperty0):void type: CONSTRUCTOR in method: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5.accept(arrow.core.Option<java.lang.String>):void, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r6v6 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1) = 
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x000a: IGET  (r1v6 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                                  (r5v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5<T> A[IMMUTABLE_TYPE, THIS])
                                 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1.<init>(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl):void type: CONSTRUCTOR in method: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5.accept(arrow.core.Option<java.lang.String>):void, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:690)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                	... 21 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                	... 27 more
                                */
                            /*
                                this = this;
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                                boolean r1 = r6 instanceof arrow.core.None
                                if (r1 == 0) goto L_0x0015
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$UsersFinishedTyping r6 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.Event.UsersFinishedTyping.INSTANCE
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1 r6 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$1$1
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r1 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                                r6.<init>(r1)
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$UsersFinishedTyping$invoke$1 r1 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$UsersFinishedTyping$invoke$1
                                r1.<init>(r6)
                                goto L_0x003e
                            L_0x0015:
                                boolean r1 = r6 instanceof arrow.core.Some
                                if (r1 == 0) goto L_0x0042
                                arrow.core.Some r6 = (arrow.core.Some) r6
                                java.lang.Object r6 = r6.getT()
                                java.lang.String r6 = (java.lang.String) r6
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$UsersStartedTyping r1 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.Event.UsersStartedTyping.INSTANCE
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$2$1 r1 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$2$1
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r2 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                                r1.<init>(r2)
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$2$2 r2 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$2$2
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r3 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                                r2.<init>(r3)
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$2$3 r3 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5$2$3
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r4 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                                r3.<init>(r4)
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$UsersStartedTyping$invoke$1 r4 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$UsersStartedTyping$invoke$1
                                r4.<init>(r6, r1, r2, r3)
                                r1 = r4
                            L_0x003e:
                                r0.dispatchCommand(r1)
                                return
                            L_0x0042:
                                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                                r6.<init>()
                                throw r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToChannelContextInteractorStateUpdates$5.accept(arrow.core.Option):void");
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(subscribe2, "deps.channelContextInter…chCommand()\n            }");
                    DisposableKt.addTo(subscribe2, getDisposables());
                    Scheduler io3 = access$getDeps$p(this).getSchedulers().io();
                    CompositeDisposable disposables2 = getDisposables();
                    SharedScheduler sharedScheduler2 = new SharedScheduler(io3);
                    disposables2.add(Disposables.fromAction(new io.reactivex.functions.Action() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$inlined$sam$i$io_reactivex_functions_Action$0
                        @Override // io.reactivex.functions.Action
                        public final /* synthetic */ void run() {
                            Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                        }
                    }));
                    Disposable subscribe3 = access$getDeps$p(this).getMessageListInteractor().getStateObservable().observeOn(sharedScheduler2).skipWhile(MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$1.INSTANCE).publish(new MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2(this, sharedScheduler2)).subscribeOn(sharedScheduler2).subscribe(new Consumer<Function2<? super Long, ? super EventDeps, ? extends EventInstance<Event, PartialState, EventDeps>>>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$3
                        public final void accept(Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>> function2) {
                            MessageListPresenterImpl messageListPresenterImpl = MessageListPresenterImpl.this;
                            Intrinsics.checkNotNullExpressionValue(function2, "eventDispatchable");
                            messageListPresenterImpl.dispatchCommand(function2);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(subscribe3, "deps.messageListInteract…chCommand()\n            }");
                    DisposableKt.addTo(subscribe3, getDisposables());
                    Disposable subscribe4 = access$getDeps$p(this).getMessageSpamActionsInteractor().getStateObservable().observeOn(access$getDeps$p(this).getSchedulers().computation()).distinctUntilChanged().subscribe(new Consumer<MessageSpamActionsInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1
                        public final void accept(MessageSpamActionsInteractor.State state) {
                            MessageListPresenterImpl.Event.MessageSpamActionsInteractorStateUpdated messageSpamActionsInteractorStateUpdated = MessageListPresenterImpl.Event.MessageSpamActionsInteractorStateUpdated.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(state, "interactorState");
                            MessageListPresenterImpl.this.dispatchCommand(new MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1(state, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x0013: IGET  (r3v1 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                                  (r2v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1<T> A[IMMUTABLE_TYPE, THIS])
                                 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1 : 0x0010: CONSTRUCTOR  (r1v1 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1) = 
                                  (r3v0 'state' com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State)
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1 : 0x000b: CONSTRUCTOR  (r0v2 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1) = 
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x0009: IGET  (r1v0 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                                  (r2v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1<T> A[IMMUTABLE_TYPE, THIS])
                                 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1.<init>(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl):void type: CONSTRUCTOR)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1.<init>(com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State, kotlin.reflect.KMutableProperty0):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents.dispatchCommand(kotlin.jvm.functions.Function2):void in method: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.accept(com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State):void, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r1v1 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1) = 
                                  (r3v0 'state' com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State)
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1 : 0x000b: CONSTRUCTOR  (r0v2 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1) = 
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x0009: IGET  (r1v0 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                                  (r2v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1<T> A[IMMUTABLE_TYPE, THIS])
                                 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1.<init>(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl):void type: CONSTRUCTOR)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1.<init>(com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State, kotlin.reflect.KMutableProperty0):void type: CONSTRUCTOR in method: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.accept(com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State):void, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                                	... 15 more
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r0v2 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1) = 
                                  (wrap: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl : 0x0009: IGET  (r1v0 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl) = 
                                  (r2v0 'this' com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1<T> A[IMMUTABLE_TYPE, THIS])
                                 com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.a com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl)
                                 call: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1.<init>(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl):void type: CONSTRUCTOR in method: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.accept(com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State):void, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:690)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                	... 21 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                                	... 27 more
                                */
                            /*
                                this = this;
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated r0 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.Event.MessageSpamActionsInteractorStateUpdated.INSTANCE
                                java.lang.String r0 = "interactorState"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1 r0 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1$event$1
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r1 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                                r0.<init>(r1)
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1 r1 = new com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Event$MessageSpamActionsInteractorStateUpdated$invoke$1
                                r1.<init>(r3, r0)
                                com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl r3 = com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.this
                                r3.dispatchCommand(r1)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$1.accept(com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor$State):void");
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(subscribe4, "deps.messageSpamActionsI…chCommand()\n            }");
                    DisposableKt.addTo(subscribe4, getDisposables());
                    Disposable subscribe5 = access$getDeps$p(this).getMessageSpamActionsInteractor().getErrorStream().observeOn(access$getDeps$p(this).getSchedulers().computation()).map(new Function<Throwable, String>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageSpamActionsInteractorStateUpdates$2
                        public final String apply(@NotNull Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "error");
                            return MessageListPresenterImpl.access$getDeps$p(MessageListPresenterImpl.this).getErrorFormatter().format(ThrowablesKt.toAvitoException(th));
                        }
                    }).subscribe(new Consumer() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterKt$sam$i$io_reactivex_functions_Consumer$0
                        @Override // io.reactivex.functions.Consumer
                        public final /* synthetic */ void accept(Object obj) {
                            Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(subscribe5, "deps.messageSpamActionsI…MessageStream::postValue)");
                    DisposableKt.addTo(subscribe5, getDisposables());
                    if (access$getDeps$p(this).getFeatures().getMessengerDynamicAttachMenu().invoke().booleanValue()) {
                        Observable distinctUntilChanged = getInternalStateObservable().map(MessageListPresenterImpl$subscribeToFileDownloadFails$1.INSTANCE).distinctUntilChanged();
                        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "internalStateObservable\n…  .distinctUntilChanged()");
                        Observable switchMap = distinctUntilChanged.switchMap(new Function<Option<? extends T>, ObservableSource<? extends R>>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToFileDownloadFails$$inlined$switchMapFold$2
                            public final ObservableSource<? extends R> apply(@NotNull Option<? extends T> option) {
                                Intrinsics.checkNotNullParameter(option, "it");
                                if (option instanceof None) {
                                    Observable never = Observable.never();
                                    Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
                                    return never;
                                } else if (option instanceof Some) {
                                    return InteropKt.toV2(MessageListPresenterImpl.access$getDeps$p(MessageListPresenterImpl.this).getFileDownloadManager().observeNewDownloadFails((String) ((Some) option).getT(), MessageListPresenterImpl.access$getDeps$p(MessageListPresenterImpl.this).getChannelId(), MessageListPresenterImpl.access$getDeps$p(MessageListPresenterImpl.this).getTimeSource().now()));
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }

                            @Override // io.reactivex.functions.Function
                            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                                return apply((Option) ((Option) obj));
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(switchMap, "switchMap { it.fold(ifEmpty, some) }");
                        Disposable subscribe6 = switchMap.subscribe(new Consumer<Map<UUID, ? extends WorkInfo>>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToFileDownloadFails$4
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // io.reactivex.functions.Consumer
                            public /* bridge */ /* synthetic */ void accept(Map<UUID, ? extends WorkInfo> map) {
                                accept((Map<UUID, WorkInfo>) map);
                            }

                            public final void accept(Map<UUID, WorkInfo> map) {
                                MessageListPresenterImpl.this.getFileDownloadFailsStream().postValue(Unit.INSTANCE);
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(subscribe6, "internalStateObservable\n…e(Unit)\n                }");
                        DisposableKt.addTo(subscribe6, getDisposables());
                    }
                }

                public static final boolean access$areBothSuccessAndRelevantFieldsAreEqual(MessageListPresenterImpl messageListPresenterImpl, ChannelContextInteractor.State state, ChannelContextInteractor.State state2) {
                    Objects.requireNonNull(messageListPresenterImpl);
                    Loading<Channel> channelState = state.getChannelState();
                    String str = null;
                    if (!(channelState instanceof Loading.Success)) {
                        channelState = null;
                    }
                    Loading.Success success = (Loading.Success) channelState;
                    Channel channel = (Channel) (success != null ? success.getValue() : null);
                    Loading<Channel> channelState2 = state2.getChannelState();
                    if (!(channelState2 instanceof Loading.Success)) {
                        channelState2 = null;
                    }
                    Loading.Success success2 = (Loading.Success) channelState2;
                    Channel channel2 = (Channel) (success2 != null ? success2.getValue() : null);
                    if (channel == null || channel2 == null) {
                        return false;
                    }
                    String currentUserId = state.getCurrentUserId();
                    if (!(!m.isBlank(currentUserId))) {
                        currentUserId = null;
                    }
                    String currentUserId2 = state2.getCurrentUserId();
                    if (!m.isBlank(currentUserId2)) {
                        str = currentUserId2;
                    }
                    if (!(!Intrinsics.areEqual(currentUserId, str)) && Intrinsics.areEqual(channel.getContext(), channel2.getContext()) && Intrinsics.areEqual(CollectionsKt___CollectionsKt.toSet(channel.getUsers()), CollectionsKt___CollectionsKt.toSet(channel2.getUsers()))) {
                        return true;
                    }
                    return false;
                }

                public static final Option access$getCurUserIdAndChannel(MessageListPresenterImpl messageListPresenterImpl, ChannelContextInteractor.State state) {
                    Objects.requireNonNull(messageListPresenterImpl);
                    String currentUserId = state.getCurrentUserId();
                    Object obj = null;
                    if (!(!m.isBlank(currentUserId))) {
                        currentUserId = null;
                    }
                    Loading<Channel> channelState = state.getChannelState();
                    if (!(channelState instanceof Loading.Success)) {
                        channelState = null;
                    }
                    Loading.Success success = (Loading.Success) channelState;
                    if (success != null) {
                        obj = success.getValue();
                    }
                    Channel channel = (Channel) obj;
                    return (currentUserId == null || channel == null) ? OptionKt.none() : OptionKt.some(TuplesKt.to(currentUserId, channel));
                }

                public static final /* synthetic */ Deps access$getDeps$p(MessageListPresenterImpl messageListPresenterImpl) {
                    return (Deps) messageListPresenterImpl.getDeps();
                }

                public static final boolean access$isEmptyOrInProgressWithNoUserId$p(MessageListPresenterImpl messageListPresenterImpl, ChannelContextInteractor.State state) {
                    Objects.requireNonNull(messageListPresenterImpl);
                    return (state.getChannelState() instanceof Loading.Empty) || ((state.getChannelState() instanceof Loading.InProgress) && m.isBlank(state.getCurrentUserId()));
                }

                public static final boolean access$isError$p(MessageListPresenterImpl messageListPresenterImpl, ChannelContextInteractor.State state) {
                    Objects.requireNonNull(messageListPresenterImpl);
                    return state.getChannelState() instanceof Loading.Error;
                }

                public static final Observable access$subscribeToMessageUpdates(MessageListPresenterImpl messageListPresenterImpl, Observable observable, Scheduler scheduler) {
                    Objects.requireNonNull(messageListPresenterImpl);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    Observable ofType = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
                    Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
                    Observable subscribeOn = ofType.observeOn(scheduler).map(MessageListPresenterImpl$subscribeToMessageUpdates$1.INSTANCE).distinctUntilChanged().switchMap(new MessageListPresenterImpl$subscribeToMessageUpdates$2(scheduler)).subscribeOn(scheduler);
                    Intrinsics.checkNotNullExpressionValue(subscribeOn, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
                    Observable ofType2 = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
                    Intrinsics.checkExpressionValueIsNotNull(ofType2, "ofType(R::class.java)");
                    Observable subscribeOn2 = ofType2.observeOn(scheduler).map(MessageListPresenterImpl$subscribeToMessageUpdates$3.INSTANCE).distinctUntilChanged().switchMap(new MessageListPresenterImpl$subscribeToMessageUpdates$4(scheduler)).startWith((Observable) CollectionsKt__CollectionsKt.emptyList()).subscribeOn(scheduler);
                    Intrinsics.checkNotNullExpressionValue(subscribeOn2, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
                    Observable ofType3 = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
                    Intrinsics.checkExpressionValueIsNotNull(ofType3, "ofType(R::class.java)");
                    Observable subscribeOn3 = ofType3.observeOn(scheduler).map(MessageListPresenterImpl$subscribeToMessageUpdates$5.INSTANCE).distinctUntilChanged().takeUntil(MessageListPresenterImpl$subscribeToMessageUpdates$6.INSTANCE).subscribeOn(scheduler);
                    Intrinsics.checkNotNullExpressionValue(subscribeOn3, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
                    Observable combineLatest = Observable.combineLatest(subscribeOn, subscribeOn2, subscribeOn3, new Function3<T1, T2, T3, R>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$$inlined$combineLatestWith$1
                        @Override // io.reactivex.functions.Function3
                        @NotNull
                        public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                            Intrinsics.checkNotNullParameter(t1, "t1");
                            Intrinsics.checkNotNullParameter(t2, "t2");
                            Intrinsics.checkNotNullParameter(t3, "t3");
                            return (R) new Triple(t1, t2, t3);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
                    Observable subscribeOn4 = combineLatest.doOnNext(new MessageListPresenterImpl$subscribeToMessageUpdates$7(messageListPresenterImpl, atomicInteger)).concatMap(new MessageListPresenterImpl$subscribeToMessageUpdates$8(messageListPresenterImpl, atomicBoolean)).subscribeOn(scheduler);
                    Intrinsics.checkNotNullExpressionValue(subscribeOn4, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
                    return subscribeOn4;
                }

                public static final Observable access$subscribeToPaginationStateUpdates(MessageListPresenterImpl messageListPresenterImpl, Observable observable) {
                    Objects.requireNonNull(messageListPresenterImpl);
                    Observable ofType = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
                    Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
                    Observable map = ofType.distinctUntilChanged(MessageListPresenterImpl$subscribeToPaginationStateUpdates$1.INSTANCE).map(new MessageListPresenterImpl$subscribeToPaginationStateUpdates$2(messageListPresenterImpl));
                    Intrinsics.checkNotNullExpressionValue(map, "ofType<MessageListIntera….exhaustive\n            }");
                    return map;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                public void callUser() {
                    ((Deps) getDeps()).getChannelMenuInteractor().callUser();
                }

                /* Return type fixed from 'java.util.Set<com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$Effect$StartLoadingOnNewUserId>' to match base method */
                @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseMviEntityWithEvents
                @NotNull
                public Set<BaseEffect<EventInstance<Event, ?, ?>>> getEffects() {
                    return this.G;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public LiveData<Pair<Uri, String>> getFileMessageClickedStream() {
                    return this.z;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public LiveData<Pair<LocalMessage, MessageMetaInfo>> getRequestPermissionsForFileMessageStream() {
                    return this.F;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(@Nullable ActionMode actionMode, @Nullable MenuItem menuItem) {
                    if (menuItem == null || menuItem.getItemId() != 16908321) {
                        return false;
                    }
                    ((Deps) getDeps()).getAnalytics().track(new MessengerCopyPlatformMessageTextEvent(((Deps) getDeps()).getChannelId()));
                    return false;
                }

                @Override // com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageClickListener
                public void onAppCallMessageClicked(@NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                    ((Deps) getDeps()).getDeeplinkProcessor().process(deepLink);
                }

                @Override // com.avito.android.messenger.conversation.adapter.MessageAvatarClickListener
                public void onAvatarClicked(@NotNull ChannelItem.Message message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Event.MessageAvatarClicked messageAvatarClicked = Event.MessageAvatarClicked.INSTANCE;
                    dispatchCommand(new MessageListPresenterImpl$Event$MessageAvatarClicked$invoke$1(message, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.r
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).p;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                        }
                    }));
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return this.H.onCreateActionMode(actionMode, menu);
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode actionMode) {
                    this.H.onDestroyActionMode(actionMode);
                }

                @Override // com.avito.android.messenger.conversation.adapter.file.FileMessageClickListener
                public void onFileMessageCancelClicked(@NotNull ChannelItem.Message message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    if (((Deps) getDeps()).getFeatures().getMessengerDynamicAttachMenu().invoke().booleanValue()) {
                        ((Deps) getDeps()).getFileMessageClickInteractor().onCancelClick(message.getLocalMessage());
                    }
                }

                /* JADX WARN: Type inference failed for: r0v3, types: [com.avito.android.remote.model.messenger.message.MessageBody, java.lang.Object] */
                /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
                /* JADX WARNING: Removed duplicated region for block: B:30:0x00d3  */
                /* JADX WARNING: Unknown variable types count: 1 */
                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onMessageClick(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.ChannelItem.Message.BodyOrBubble r6, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.messenger.message.LocalMessage r7, @org.jetbrains.annotations.Nullable ru.avito.android.persistence.messenger.MessageMetaInfo r8) {
                    /*
                    // Method dump skipped, instructions count: 638
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.onMessageClick(com.avito.android.messenger.conversation.ChannelItem$Message$BodyOrBubble, com.avito.android.remote.model.messenger.message.LocalMessage, ru.avito.android.persistence.messenger.MessageMetaInfo):void");
                }

                @Override // com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener
                public void onMessageLinkClicked(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str) {
                    Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
                    Intrinsics.checkNotNullParameter(localMessage, "localMessage");
                    Intrinsics.checkNotNullParameter(str, "url");
                    String str2 = localMessage.remoteId;
                    if (str2 != null) {
                        ((Deps) getDeps()).getAnalytics().track(new MessengerLinkClick(localMessage.channelId, str2, str));
                    }
                    MutableLiveData<String> linkMessageWithUrlClickedStream = getLinkMessageWithUrlClickedStream();
                    String[] url_schemes = Uris.getURL_SCHEMES();
                    int length = url_schemes.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            str = a2.b.a.a.a.t(new StringBuilder(), Uris.getURL_SCHEMES()[0], str);
                            break;
                        }
                        String str3 = url_schemes[i];
                        if (!m.startsWith(str, str3, true)) {
                            i++;
                        } else if (!m.startsWith(str, str3, false)) {
                            StringBuilder L = a2.b.a.a.a.L(str3);
                            String substring = str.substring(str3.length());
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                            L.append(substring);
                            str = L.toString();
                        }
                    }
                    linkMessageWithUrlClickedStream.postValue(str);
                }

                @Override // com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener
                public void onMessageLinkLongClicked(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str) {
                    Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
                    Intrinsics.checkNotNullParameter(localMessage, "localMessage");
                    Intrinsics.checkNotNullParameter(str, "url");
                    getShowMenuForTextLinkStream().postValue(new LinkMenuData(bodyOrBubble, localMessage, str));
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return this.H.onPrepareActionMode(actionMode, menu);
                }

                @Override // com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView.Listener
                public void onRetryPaginationClicked(@NotNull ChannelItem.PaginationError paginationError) {
                    Intrinsics.checkNotNullParameter(paginationError, "item");
                    startPagination();
                }

                @Override // com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter.Listener
                public void onSpamActionClicked(@NotNull ChannelItem.SpamActions spamActions, boolean z2) {
                    Intrinsics.checkNotNullParameter(spamActions, "item");
                    Event.MessageSpamActionClicked messageSpamActionClicked = Event.MessageSpamActionClicked.INSTANCE;
                    dispatchCommand(new MessageListPresenterImpl$Event$MessageSpamActionClicked$invoke$1(spamActions.getMessageRemoteId(), z2, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.w
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).r;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                        }
                    }));
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                public void refresh() {
                    Event.Refresh refresh = Event.Refresh.INSTANCE;
                    dispatchCommand(new MessageListPresenterImpl$Event$Refresh$invoke$1(new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.x
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).p;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                        }
                    }, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.y
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).q;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                        }
                    }, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.z
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).r;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                        }
                    }, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.a0
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).s;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).s = (MessageListPresenterImpl.PartialState.List.Bottom) obj;
                        }
                    }));
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                public void startPagination() {
                    Event.PaginationStart paginationStart = Event.PaginationStart.INSTANCE;
                    dispatchCommand(new MessageListPresenterImpl$Event$PaginationStart$invoke$1(true, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.b0
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).p;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                        }
                    }, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.c0
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).r;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                        }
                    }, new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.d0
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).q;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                        }
                    }));
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                public void userInteractedWithList() {
                    Event.UserInteractedWithList userInteractedWithList = Event.UserInteractedWithList.INSTANCE;
                    dispatchCommand(new MessageListPresenterImpl$Event$UserInteractedWithList$invoke$1(new MutablePropertyReference0Impl(this) { // from class: a2.a.a.o1.d.a0.i.e0
                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return ((MessageListPresenterImpl) this.receiver).r;
                        }

                        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj) {
                            ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                        }
                    }));
                }

                @NotNull
                public AggregatedState applyPartialStates(@NotNull AggregatedState aggregatedState, @NotNull Set<? extends PartialState> set) {
                    T t2;
                    T t3;
                    T t4;
                    T t5;
                    T t7;
                    T t8;
                    T t9;
                    Intrinsics.checkNotNullParameter(aggregatedState, "$this$applyPartialStates");
                    Intrinsics.checkNotNullParameter(set, "partialStates");
                    Iterator<T> it = set.iterator();
                    while (true) {
                        t2 = null;
                        if (!it.hasNext()) {
                            t3 = null;
                            break;
                        }
                        t3 = it.next();
                        if (t3 instanceof PartialState.Meta) {
                            break;
                        }
                    }
                    if (!(t3 instanceof PartialState.Meta)) {
                        t3 = null;
                    }
                    T t10 = t3;
                    Iterator<T> it2 = set.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t4 = null;
                            break;
                        }
                        t4 = it2.next();
                        if (t4 instanceof PartialState.Context) {
                            break;
                        }
                    }
                    if (!(t4 instanceof PartialState.Context)) {
                        t4 = null;
                    }
                    T t11 = t4;
                    Iterator<T> it3 = set.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            t5 = null;
                            break;
                        }
                        t5 = it3.next();
                        if (t5 instanceof PartialState.List.Top) {
                            break;
                        }
                    }
                    if (!(t5 instanceof PartialState.List.Top)) {
                        t5 = null;
                    }
                    T t12 = t5;
                    Iterator<T> it4 = set.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            t7 = null;
                            break;
                        }
                        t7 = it4.next();
                        if (t7 instanceof PartialState.List.Middle) {
                            break;
                        }
                    }
                    if (!(t7 instanceof PartialState.List.Middle)) {
                        t7 = null;
                    }
                    T t13 = t7;
                    Iterator<T> it5 = set.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            t8 = null;
                            break;
                        }
                        t8 = it5.next();
                        if (t8 instanceof PartialState.List.Bottom) {
                            break;
                        }
                    }
                    if (!(t8 instanceof PartialState.List.Bottom)) {
                        t8 = null;
                    }
                    T t14 = t8;
                    Iterator<T> it6 = set.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            t9 = null;
                            break;
                        }
                        t9 = it6.next();
                        if (t9 instanceof PartialState.List.SpamActions) {
                            break;
                        }
                    }
                    if (t9 instanceof PartialState.List.SpamActions) {
                        t2 = t9;
                    }
                    T t15 = t2;
                    if ((t10 == null || t10 == aggregatedState.getMetaState()) && ((t11 == null || t11 == aggregatedState.getContextState()) && ((t12 == null || t12 == aggregatedState.getListTopState()) && ((t13 == null || t13 == aggregatedState.getListMiddleState()) && ((t14 == null || t14 == aggregatedState.getListBottomState()) && ((t15 == null || t15 == aggregatedState.getListSpamActionsState()) && ((Deps) getDeps()).getMessageId() == aggregatedState.getMessageId())))))) {
                        return aggregatedState;
                    }
                    if (t10 == null) {
                        t10 = aggregatedState.getMetaState();
                    }
                    if (t11 == null) {
                        t11 = aggregatedState.getContextState();
                    }
                    if (t12 == null) {
                        t12 = aggregatedState.getListTopState();
                    }
                    if (t13 == null) {
                        t13 = aggregatedState.getListMiddleState();
                    }
                    if (t14 == null) {
                        t14 = aggregatedState.getListBottomState();
                    }
                    if (t15 == null) {
                        t15 = aggregatedState.getListSpamActionsState();
                    }
                    return new AggregatedState(t10, t11, t12, t13, t14, t15, ((Deps) getDeps()).getMessageId());
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<String> getErrorMessageStream() {
                    return this.D;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<Unit> getFileDownloadFailsStream() {
                    return this.E;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<OpenGalleryData> getImageMessageClickedStream() {
                    return this.v;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<ItemMessageInfo> getItemMessageClickedStream() {
                    return this.u;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<String> getLinkMessageWithUrlClickedStream() {
                    return this.x;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<MessageBody.Location> getLocationMessageClickedStream() {
                    return this.y;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<PlatformMapData> getPlatformMapMessageClickedStream() {
                    return this.A;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<LinkMenuData> getShowMenuForTextLinkStream() {
                    return this.C;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<Unit> getSystemUserAvatarClickedStream() {
                    return this.B;
                }

                @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter
                @NotNull
                public MutableLiveData<Unit> getUnknownMessageClickedStream() {
                    return this.w;
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0001;BC\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010,\u001a\u00020'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u00102\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00108\u001a\u0002038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "e", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "getListTopState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", "listTopState", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "h", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "getListSpamActionsState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;", "listSpamActionsState", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "c", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "getMetaState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;", "metaState", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "d", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "getContextState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;", "contextState", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "f", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "getListMiddleState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", "listMiddleState", "i", "Ljava/lang/String;", "getMessageId", "messageId", "", AuthSource.BOOKING_ORDER, "Z", "getPaginationIsEnabled", "()Z", "paginationIsEnabled", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", g.a, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "getListBottomState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", "listBottomState", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "getListState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "listState", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Meta;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$Context;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$SpamActions;Ljava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
                public static final class AggregatedState implements MessageListView.State {
                    @NotNull
                    public static final Companion Companion = new Companion(null);
                    @NotNull
                    public static final AggregatedState j = new AggregatedState(new PartialState.Meta(null), PartialState.Context.Empty.INSTANCE, new PartialState.List.Top.Empty(false), new PartialState.List.Middle.LoadingInProgress(CollectionsKt__CollectionsKt.emptyList()), PartialState.List.Bottom.Empty.INSTANCE, new PartialState.List.SpamActions(null), null, 64, null);
                    @NotNull
                    public final MessageListView.ListState a;
                    public final boolean b;
                    @NotNull
                    public final PartialState.Meta c;
                    @NotNull
                    public final PartialState.Context d;
                    @NotNull
                    public final PartialState.List.Top e;
                    @NotNull
                    public final PartialState.List.Middle f;
                    @NotNull
                    public final PartialState.List.Bottom g;
                    @NotNull
                    public final PartialState.List.SpamActions h;
                    @Nullable
                    public final String i;

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState$Companion;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;", "getDEFAULT", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$AggregatedState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
                    public static final class Companion {
                        public Companion() {
                        }

                        @NotNull
                        public final AggregatedState getDEFAULT() {
                            return AggregatedState.j;
                        }

                        public Companion(j jVar) {
                        }
                    }

                    public AggregatedState(@NotNull PartialState.Meta meta, @NotNull PartialState.Context context, @NotNull PartialState.List.Top top, @NotNull PartialState.List.Middle middle, @NotNull PartialState.List.Bottom bottom, @NotNull PartialState.List.SpamActions spamActions, @Nullable String str) {
                        List list;
                        List list2;
                        boolean z;
                        LocalMessage localMessage;
                        MessageListView.ListState listState;
                        ChatReplyTime replyTime;
                        Intrinsics.checkNotNullParameter(meta, "metaState");
                        Intrinsics.checkNotNullParameter(context, "contextState");
                        Intrinsics.checkNotNullParameter(top, "listTopState");
                        Intrinsics.checkNotNullParameter(middle, "listMiddleState");
                        Intrinsics.checkNotNullParameter(bottom, "listBottomState");
                        Intrinsics.checkNotNullParameter(spamActions, "listSpamActionsState");
                        this.c = meta;
                        this.d = context;
                        this.e = top;
                        this.f = middle;
                        this.g = bottom;
                        this.h = spamActions;
                        this.i = str;
                        boolean z2 = false;
                        if (Intrinsics.areEqual(context, PartialState.Context.Empty.INSTANCE)) {
                            this.a = MessageListView.ListState.LoadingInProgress.INSTANCE;
                            this.b = false;
                        } else if (context instanceof PartialState.Context.LoadingError) {
                            this.a = MessageListView.ListState.Error.INSTANCE;
                            this.b = false;
                        } else if (context instanceof PartialState.Context.LoadedOnlyUserId) {
                            this.a = MessageListView.ListState.LoadingInProgress.INSTANCE;
                            this.b = false;
                        } else if (context instanceof PartialState.Context.Loaded) {
                            Pair pair = null;
                            boolean z3 = true;
                            if (Intrinsics.areEqual(middle, PartialState.List.Middle.Empty.INSTANCE)) {
                                PartialState.Context.Loaded loaded = (PartialState.Context.Loaded) context;
                                ChannelContext context2 = loaded.getContext();
                                ChannelContext.Item item = (ChannelContext.Item) (!(context2 instanceof ChannelContext.Item) ? null : context2);
                                if (!(item == null || (replyTime = item.getReplyTime()) == null)) {
                                    List<User> users = loaded.getUsers();
                                    ArrayList arrayList = new ArrayList();
                                    for (T t : users) {
                                        if (!Intrinsics.areEqual(loaded.getCurrentUserId(), t.getId())) {
                                            arrayList.add(t);
                                        }
                                    }
                                    pair = TuplesKt.to(replyTime, Boolean.valueOf((!(arrayList.size() == 1) || !(Intrinsics.areEqual(item.getUserId(), loaded.getCurrentUserId()) ^ true) || item.getDeleted() || item.getHidePhone()) ? false : z3));
                                }
                                if (pair != null) {
                                    listState = new MessageListView.ListState.Empty.WithReplyTime((ChatReplyTime) pair.component1(), ((Boolean) pair.component2()).booleanValue());
                                } else {
                                    listState = MessageListView.ListState.Empty.NoReplyTime.INSTANCE;
                                }
                                this.a = listState;
                                this.b = false;
                            } else if (middle instanceof PartialState.List.Middle.LoadingInProgress) {
                                this.a = MessageListView.ListState.LoadingInProgress.INSTANCE;
                                this.b = false;
                            } else if (middle instanceof PartialState.List.Middle.LoadingError) {
                                this.a = MessageListView.ListState.Error.INSTANCE;
                                this.b = false;
                            } else if (middle instanceof PartialState.List.Middle.LoadingSuccess) {
                                if (bottom instanceof PartialState.List.Bottom.Empty) {
                                    list = CollectionsKt__CollectionsKt.emptyList();
                                } else if (bottom instanceof PartialState.List.Bottom.UsersTyping) {
                                    list = d.listOf(((PartialState.List.Bottom.UsersTyping) bottom).getTypingIndicator());
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                                List plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) ((PartialState.List.Middle.LoadingSuccess) middle).getItems());
                                if (top instanceof PartialState.List.Top.Empty) {
                                    list2 = CollectionsKt__CollectionsKt.emptyList();
                                } else if (top instanceof PartialState.List.Top.PaginationInProgress) {
                                    list2 = d.listOf(ChannelItem.PaginationInProgress.INSTANCE);
                                } else if (top instanceof PartialState.List.Top.PaginationError) {
                                    list2 = d.listOf(ChannelItem.PaginationError.INSTANCE);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                                List plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) list2);
                                ChannelItem.SpamActions spamActions2 = spamActions.getSpamActions();
                                int i2 = -1;
                                if (spamActions2 != null) {
                                    String messageRemoteId = spamActions2.getMessageRemoteId();
                                    Iterator it = plus2.iterator();
                                    int i3 = 0;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            i3 = -1;
                                            break;
                                        }
                                        ChannelItem channelItem = (ChannelItem) it.next();
                                        if ((channelItem instanceof ChannelItem.Message) && Intrinsics.areEqual(((ChannelItem.Message) channelItem).getLocalMessage().remoteId, messageRemoteId)) {
                                            break;
                                        }
                                        i3++;
                                    }
                                    if (i3 >= 1) {
                                        Object obj = plus2.get(i3 - 1);
                                        ChannelItem.Message message = (ChannelItem.Message) (!(obj instanceof ChannelItem.Message) ? null : obj);
                                        Object obj2 = plus2.get(i3);
                                        ChannelItem.Message message2 = (ChannelItem.Message) (!(obj2 instanceof ChannelItem.Message) ? null : obj2);
                                        if (message != null) {
                                            if (Intrinsics.areEqual(message.getLocalMessage().fromId, (message2 == null || (localMessage = message2.getLocalMessage()) == null) ? null : localMessage.fromId)) {
                                                z = true;
                                                spamActions2.setSplitsUserGroup(z);
                                            }
                                        }
                                        z = false;
                                        spamActions2.setSplitsUserGroup(z);
                                    }
                                    if (i3 >= 0) {
                                        plus2 = CollectionsKt___CollectionsKt.toMutableList((Collection) plus2);
                                        plus2.add(i3, spamActions2);
                                    }
                                }
                                if (this.i != null) {
                                    int size = plus2.size();
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= size) {
                                            break;
                                        }
                                        Object obj3 = plus2.get(i4);
                                        ChannelItem.Message message3 = (ChannelItem.Message) (!(obj3 instanceof ChannelItem.Message) ? null : obj3);
                                        if (message3 != null && Intrinsics.areEqual(message3.getLocalMessage().remoteId, this.i)) {
                                            message3.setHighlight(true);
                                            i2 = i4;
                                            break;
                                        }
                                        i4++;
                                    }
                                }
                                this.a = new MessageListView.ListState.Loaded(plus2, i2 < 0 ? ((PartialState.List.Middle.LoadingSuccess) this.f).getNewMessagesDividerPosition() : i2, ((PartialState.List.Middle.LoadingSuccess) this.f).getUserInteractedWithList());
                                PartialState.List.Top top2 = this.e;
                                if (top2 instanceof PartialState.List.Top.Empty) {
                                    z2 = ((PartialState.List.Top.Empty) top2).getPaginationIsEnabled();
                                } else if (!(top2 instanceof PartialState.List.Top.PaginationInProgress) && !(top2 instanceof PartialState.List.Top.PaginationError)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                this.b = z2;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }

                    @NotNull
                    public final PartialState.Context getContextState() {
                        return this.d;
                    }

                    @NotNull
                    public final PartialState.List.Bottom getListBottomState() {
                        return this.g;
                    }

                    @NotNull
                    public final PartialState.List.Middle getListMiddleState() {
                        return this.f;
                    }

                    @NotNull
                    public final PartialState.List.SpamActions getListSpamActionsState() {
                        return this.h;
                    }

                    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView.State
                    @NotNull
                    public MessageListView.ListState getListState() {
                        return this.a;
                    }

                    @NotNull
                    public final PartialState.List.Top getListTopState() {
                        return this.e;
                    }

                    @Nullable
                    public final String getMessageId() {
                        return this.i;
                    }

                    @NotNull
                    public final PartialState.Meta getMetaState() {
                        return this.c;
                    }

                    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListView.State
                    public boolean getPaginationIsEnabled() {
                        return this.b;
                    }

                    @NotNull
                    public String toString() {
                        StringBuilder L = a2.b.a.a.a.L("MessageListView.State(\n            |   listState = ");
                        L.append(getListState());
                        L.append(",\n            |   paginationIsEnabled = ");
                        L.append(getPaginationIsEnabled());
                        L.append("\n            |) from {\n            |   contextState=");
                        L.append(this.d);
                        L.append(",\n            |   listTopState=");
                        L.append(this.e);
                        L.append(",\n            |   listMiddleState=");
                        L.append(this.f);
                        L.append(",\n            |   listBottomState=");
                        L.append(this.g);
                        L.append(",\n            |   listSpamActionsState=");
                        L.append(this.h);
                        L.append(",\n            |}");
                        return f.trimMargin$default(L.toString(), null, 1, null);
                    }

                    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                    public /* synthetic */ AggregatedState(PartialState.Meta meta, PartialState.Context context, PartialState.List.Top top, PartialState.List.Middle middle, PartialState.List.Bottom bottom, PartialState.List.SpamActions spamActions, String str, int i2, j jVar) {
                        this(meta, context, top, middle, bottom, spamActions, (i2 & 64) != 0 ? null : str);
                    }
                }
            }
