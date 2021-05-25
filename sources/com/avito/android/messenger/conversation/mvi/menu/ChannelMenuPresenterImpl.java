package com.avito.android.messenger.conversation.mvi.menu;

import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import arrow.core.Either;
import arrow.core.Option;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.deep_linking.links.BlockUserLink;
import com.avito.android.deep_linking.links.ChannelCallLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkKt;
import com.avito.android.deep_linking.links.DeleteChannelLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.UpdateFolderTagsLink;
import com.avito.android.jsonrpc.client.JsonRpcCallException;
import com.avito.android.messenger.R;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView;
import com.avito.android.messenger.folders.Folder;
import com.avito.android.messenger.folders.Folders;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.ChannelDisplayInfo;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context.ChannelMenuAction;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx.arrow.EitherKt;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0006TUVWXYB\u0001\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u00100\u001a\u00020-\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0=\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020A0=\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0H\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0K\u0012\u0012\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030O0N¢\u0006\u0004\bQ\u0010RBs\b\u0017\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u00100\u001a\u00020-\u0012\u000e\b\u0001\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0=\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020A0=\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0H\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0K¢\u0006\u0004\bQ\u0010SJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0006R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R4\u0010,\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0&0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000eR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b2\u0010\u000eR\u001d\u00109\u001a\u0002048B@\u0002X\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u0010<\u001a\u0002048B@\u0002X\u0002¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020A0=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010?¨\u0006Z"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "", "showChannelMenu", "()V", "openProfile", "onCleared", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", VKApiConst.Q, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getCallUserConfirmedStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "callUserConfirmedStream", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", VKApiConst.VERSION, "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "blacklistReasonsProvider", "r", "getErrorMessageStream", "errorMessageStream", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "w", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "deeplinkProcessor", "n", "getUserBlockedStream", "userBlockedStream", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "u", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lkotlin/Pair;", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "", "Lcom/avito/android/remote/model/Action;", "p", "getAbuseReportStream", "abuseReportStream", "Landroid/content/res/Resources;", "x", "Landroid/content/res/Resources;", "resources", "o", "getChannelDeletedStream", "channelDeletedStream", "", "s", "Lkotlin/Lazy;", "getMessengerFolderTabsEnabled", "()Z", "messengerFolderTabsEnabled", "t", "getPublishReviewEnabled", "publishReviewEnabled", "Lcom/avito/android/util/Formatter;", "y", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "", "z", "errorFormatter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/PublishReviewFromChatChannelGroup;", "publishReviewFromChatChannelGroup", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "mutatorsRelay", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Landroid/content/res/Resources;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/Formatter;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/jakewharton/rxrelay2/Relay;)V", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Landroid/content/res/Resources;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/Formatter;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "CloseDialogMutator", "NewInteractorStateMutator", "OnMenuClosedMutator", "OpenProfileAction", "ShowCallSellerDialogMutator", "ShowChannelMenuMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelMenuPresenterImpl extends BaseMviEntityWithMutatorsRelay<ChannelMenuView.State> implements ChannelMenuPresenter {
    public final CompositeDisposable m;
    @NotNull
    public final SingleLiveEvent<Unit> n;
    @NotNull
    public final SingleLiveEvent<Unit> o;
    @NotNull
    public final SingleLiveEvent<Pair<AbuseReportLink, List<Action>>> p;
    @NotNull
    public final SingleLiveEvent<String> q;
    @NotNull
    public final SingleLiveEvent<String> r;
    public final Lazy s;
    public final Lazy t;
    public final ChannelMenuInteractor u;
    public final BlacklistReasonsProvider v;
    public final DeeplinkProcessor w;
    public final Resources x;
    public final Formatter<String> y;
    public final Formatter<Throwable> z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl$CloseDialogMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class CloseDialogMutator extends Mutator<ChannelMenuView.State> {
        public CloseDialogMutator(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
            super(null, 1, null);
        }

        @NotNull
        public ChannelMenuView.State invoke(@NotNull ChannelMenuView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof ChannelMenuView.State.Hidden) {
                ChannelMenuView.DialogState dialogState = state.getDialogState();
                ChannelMenuView.DialogState.Empty empty = ChannelMenuView.DialogState.Empty.INSTANCE;
                if (!Intrinsics.areEqual(dialogState, empty)) {
                    return ChannelMenuView.State.Hidden.copy$default((ChannelMenuView.State.Hidden) state, null, empty, false, 5, null);
                }
                return (ChannelMenuView.State.Hidden) state;
            } else if ((state instanceof ChannelMenuView.State.Shown) || Intrinsics.areEqual(state, ChannelMenuView.State.Empty.INSTANCE)) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl$NewInteractorStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "c", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "menuInteractorState", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewInteractorStateMutator extends Mutator<ChannelMenuView.State> {
        public final ChannelMenuInteractor.State c;
        public final /* synthetic */ ChannelMenuPresenterImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewInteractorStateMutator(@NotNull ChannelMenuPresenterImpl channelMenuPresenterImpl, ChannelMenuInteractor.State state) {
            super("NewInteractorStateMutator(" + state + ')');
            Intrinsics.checkNotNullParameter(state, "menuInteractorState");
            this.d = channelMenuPresenterImpl;
            this.c = state;
        }

        /* JADX WARNING: Removed duplicated region for block: B:143:0x04ae  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x04b6  */
        /* JADX WARNING: Removed duplicated region for block: B:294:0x0994  */
        /* JADX WARNING: Removed duplicated region for block: B:295:0x099c  */
        /* JADX WARNING: Removed duplicated region for block: B:445:0x0e65  */
        /* JADX WARNING: Removed duplicated region for block: B:446:0x0e6d  */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State r46) {
            /*
            // Method dump skipped, instructions count: 3890
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl.NewInteractorStateMutator.invoke(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView$State):com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView$State");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl$OnMenuClosedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnMenuClosedMutator extends Mutator<ChannelMenuView.State> {
        public OnMenuClosedMutator(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
            super(null, 1, null);
        }

        @NotNull
        public ChannelMenuView.State invoke(@NotNull ChannelMenuView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof ChannelMenuView.State.Shown) {
                return new ChannelMenuView.State.Hidden(state.getMenu(), state.getDialogState(), ((ChannelMenuView.State.Shown) state).getCanBlockWithReasons());
            } else if ((state instanceof ChannelMenuView.State.Hidden) || Intrinsics.areEqual(state, ChannelMenuView.State.Empty.INSTANCE)) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl$OpenProfileAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)V", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OpenProfileAction extends com.avito.android.messenger.channels.mvi.common.v2.Action<ChannelMenuView.State> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenProfileAction() {
            super(null, 1, null);
            ChannelMenuPresenterImpl.this = r2;
        }

        public void invoke(@NotNull ChannelMenuView.State state) {
            Action action;
            Intrinsics.checkNotNullParameter(state, "curState");
            ChannelMenuView.Profile orNull = state.getMenu().getProfile().orNull();
            DeepLink deepLink = (orNull == null || (action = orNull.getAction()) == null) ? null : action.getDeepLink();
            if (deepLink == null || (deepLink instanceof NoMatchLink)) {
                ChannelMenuPresenterImpl.this.getErrorMessageStream().postValue(ChannelMenuPresenterImpl.this.x.getString(R.string.messenger_profile_is_not_available));
                return;
            }
            String userId = orNull.getUserId();
            if (userId != null) {
                ChannelMenuPresenterImpl.this.u.trackProfileOpened(userId);
            }
            ChannelMenuPresenterImpl.this.w.process(deepLink);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl$ShowCallSellerDialogMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "", "c", "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ShowCallSellerDialogMutator extends Mutator<ChannelMenuView.State> {
        @NotNull
        public final String c;
        public final /* synthetic */ ChannelMenuPresenterImpl d;

        /* compiled from: kotlin-style lambda group */
        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(int i, Object obj) {
                super(0);
                this.a = i;
                this.b = obj;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                int i = this.a;
                if (i == 0) {
                    Relay mutatorsRelay = ((ShowCallSellerDialogMutator) this.b).d.getMutatorsRelay();
                    CloseDialogMutator closeDialogMutator = new CloseDialogMutator(((ShowCallSellerDialogMutator) this.b).d);
                    mutatorsRelay.accept(new MutatorSingle(closeDialogMutator.getName(), new ChannelMenuPresenterImpl$ShowCallSellerDialogMutator$createDialogState$1$$special$$inlined$plusAssign$1(closeDialogMutator)));
                    ((ShowCallSellerDialogMutator) this.b).d.getCallUserConfirmedStream().postValue(((ShowCallSellerDialogMutator) this.b).getPhone());
                    return Unit.INSTANCE;
                } else if (i == 1) {
                    Relay mutatorsRelay2 = ((ShowCallSellerDialogMutator) this.b).d.getMutatorsRelay();
                    CloseDialogMutator closeDialogMutator2 = new CloseDialogMutator(((ShowCallSellerDialogMutator) this.b).d);
                    mutatorsRelay2.accept(new MutatorSingle(closeDialogMutator2.getName(), new ChannelMenuPresenterImpl$ShowCallSellerDialogMutator$createDialogState$2$$special$$inlined$plusAssign$1(closeDialogMutator2)));
                    return Unit.INSTANCE;
                } else {
                    throw null;
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowCallSellerDialogMutator(@NotNull ChannelMenuPresenterImpl channelMenuPresenterImpl, String str) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(str, "phone");
            this.d = channelMenuPresenterImpl;
            this.c = str;
        }

        public final ChannelMenuView.DialogState a() {
            Resources resources = this.d.x;
            int i = R.string.messenger_call_action;
            String string = resources.getString(i);
            StringBuilder L = a2.b.a.a.a.L("+7 ");
            L.append(this.d.y.format(this.c));
            String sb = L.toString();
            String string2 = this.d.x.getString(i);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…ng.messenger_call_action)");
            a aVar = new a(0, this);
            String string3 = this.d.x.getString(com.avito.android.ui_components.R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(ui_R.string.cancel)");
            return new ChannelMenuView.DialogState.Show(string, sb, string2, aVar, string3, new a(1, this));
        }

        @NotNull
        public final String getPhone() {
            return this.c;
        }

        @NotNull
        public ChannelMenuView.State invoke(@NotNull ChannelMenuView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (Intrinsics.areEqual(state, ChannelMenuView.State.Empty.INSTANCE)) {
                return state;
            }
            if (state instanceof ChannelMenuView.State.Hidden) {
                if (state.getDialogState() instanceof ChannelMenuView.DialogState.Show) {
                    return (ChannelMenuView.State.Hidden) state;
                }
                return ChannelMenuView.State.Hidden.copy$default((ChannelMenuView.State.Hidden) state, null, a(), false, 5, null);
            } else if (state instanceof ChannelMenuView.State.Shown) {
                return new ChannelMenuView.State.Hidden(state.getMenu(), a(), ((ChannelMenuView.State.Shown) state).getCanBlockWithReasons());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl$ShowChannelMenuMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ShowChannelMenuMutator extends Mutator<ChannelMenuView.State> {

        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ShowChannelMenuMutator a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ShowChannelMenuMutator showChannelMenuMutator) {
                super(0);
                this.a = showChannelMenuMutator;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                Relay mutatorsRelay = ChannelMenuPresenterImpl.this.getMutatorsRelay();
                OnMenuClosedMutator onMenuClosedMutator = new OnMenuClosedMutator(ChannelMenuPresenterImpl.this);
                mutatorsRelay.accept(new MutatorSingle(onMenuClosedMutator.getName(), new ChannelMenuPresenterImpl$ShowChannelMenuMutator$invoke$1$$special$$inlined$plusAssign$1(onMenuClosedMutator)));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowChannelMenuMutator() {
            super(null, 1, null);
            ChannelMenuPresenterImpl.this = r2;
        }

        @NotNull
        public ChannelMenuView.State invoke(@NotNull ChannelMenuView.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof ChannelMenuView.State.Hidden) {
                List<ChannelMenuView.MenuAction> actions = state.getMenu().getActions();
                Option<ChannelMenuView.Profile> profile = state.getMenu().getProfile();
                if ((!actions.isEmpty()) || profile.isDefined()) {
                    ChannelMenuPresenterImpl.this.u.trackMenuOpened();
                    ChannelMenuView.State.Hidden hidden = (ChannelMenuView.State.Hidden) state;
                    if (hidden.getCanBlockWithReasons()) {
                        ChannelMenuPresenterImpl.this.v.loadBlacklistReasons(true);
                    }
                    return new ChannelMenuView.State.Shown(state.getMenu(), hidden.getCanBlockWithReasons(), new a(this));
                }
                ChannelMenuPresenterImpl.this.getErrorMessageStream().postValue(ChannelMenuPresenterImpl.this.x.getString(R.string.messenger_profile_is_not_available));
                return state;
            } else if (Intrinsics.areEqual(state, ChannelMenuView.State.Empty.INSTANCE) || (state instanceof ChannelMenuView.State.Shown)) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((ChannelMenuPresenterImpl) this.b).getUserBlockedStream().postValue(Unit.INSTANCE);
            } else if (i == 1) {
                ((ChannelMenuPresenterImpl) this.b).getChannelDeletedStream().postValue(Unit.INSTANCE);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            int i = this.a;
            if (i == 0) {
                return Boolean.valueOf(((MessengerFolderTabsTestGroup) ((ManuallyExposedAbTestGroup) this.b).getTestGroup()).isTest());
            }
            if (i == 1) {
                return Boolean.valueOf(((PublishReviewFromChatChannelGroup) ((SingleManuallyExposedAbTestGroup) this.b).getTestGroup()).isTest());
            }
            throw null;
        }
    }

    public static final class c<T1, T2> implements BiPredicate<ChannelMenuInteractor.State, ChannelMenuInteractor.State> {
        public final /* synthetic */ ChannelMenuPresenterImpl a;

        public c(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
            this.a = channelMenuPresenterImpl;
        }

        @Override // io.reactivex.functions.BiPredicate
        public boolean test(ChannelMenuInteractor.State state, ChannelMenuInteractor.State state2) {
            ChannelMenuInteractor.State state3 = state;
            ChannelMenuInteractor.State state4 = state2;
            Intrinsics.checkNotNullParameter(state3, "prev");
            Intrinsics.checkNotNullParameter(state4, "cur");
            if (Intrinsics.areEqual(state3.getClass(), state4.getClass()) && Intrinsics.areEqual(state3.getCurrentUserId(), state4.getCurrentUserId())) {
                Channel channel = state3.getChannel();
                SortedSet<String> sortedSet = null;
                ChannelDisplayInfo displayInfo = channel != null ? channel.getDisplayInfo() : null;
                Channel channel2 = state4.getChannel();
                if (Intrinsics.areEqual(displayInfo, channel2 != null ? channel2.getDisplayInfo() : null)) {
                    Channel channel3 = state3.getChannel();
                    ChannelContext context = channel3 != null ? channel3.getContext() : null;
                    Channel channel4 = state4.getChannel();
                    if (Intrinsics.areEqual(context, channel4 != null ? channel4.getContext() : null)) {
                        Channel channel5 = state3.getChannel();
                        SortedSet<String> tags = channel5 != null ? channel5.getTags() : null;
                        Channel channel6 = state4.getChannel();
                        if (channel6 != null) {
                            sortedSet = channel6.getTags();
                        }
                        if (Intrinsics.areEqual(tags, sortedSet)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static final class d<T> implements Consumer<ChannelMenuInteractor.State> {
        public final /* synthetic */ ChannelMenuPresenterImpl a;
        public final /* synthetic */ Relay b;

        public d(ChannelMenuPresenterImpl channelMenuPresenterImpl, Relay relay) {
            this.a = channelMenuPresenterImpl;
            this.b = relay;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChannelMenuInteractor.State state) {
            ChannelMenuInteractor.State state2 = state;
            Relay relay = this.b;
            ChannelMenuPresenterImpl channelMenuPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(state2, "menuInteractorState");
            NewInteractorStateMutator newInteractorStateMutator = new NewInteractorStateMutator(channelMenuPresenterImpl, state2);
            relay.accept(new MutatorSingle(newInteractorStateMutator.getName(), new ChannelMenuPresenterImpl$2$$special$$inlined$plusAssign$1(newInteractorStateMutator)));
        }
    }

    public static final class e<T, R> implements Function<Throwable, String> {
        public final /* synthetic */ ChannelMenuPresenterImpl a;

        public e(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
            this.a = channelMenuPresenterImpl;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public String apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return this.a.z.format(th2);
        }
    }

    public static final class f<T> implements Consumer<String> {
        public final /* synthetic */ ChannelMenuPresenterImpl a;

        public f(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
            this.a = channelMenuPresenterImpl;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            this.a.getErrorMessageStream().postValue(str);
        }
    }

    public static final class g<T> implements Consumer<Pair<? extends AbuseReportLink, ? extends List<? extends DeepLink>>> {
        public final /* synthetic */ ChannelMenuPresenterImpl a;

        public g(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
            this.a = channelMenuPresenterImpl;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends AbuseReportLink, ? extends List<? extends DeepLink>> pair) {
            Action action;
            Pair<? extends AbuseReportLink, ? extends List<? extends DeepLink>> pair2 = pair;
            AbuseReportLink abuseReportLink = (AbuseReportLink) pair2.component1();
            ArrayList arrayList = new ArrayList();
            for (T t : (List) pair2.component2()) {
                if (t instanceof NoMatchLink) {
                    String string = this.a.x.getString(R.string.return_to_chat);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.return_to_chat)");
                    action = new Action(string, t, null, null, null, null, 60, null);
                } else if (t instanceof DeleteChannelLink) {
                    String string2 = this.a.x.getString(R.string.delete_chat);
                    Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.delete_chat)");
                    action = new Action(string2, t, null, null, null, null, 60, null);
                } else {
                    action = null;
                }
                if (action != null) {
                    arrayList.add(action);
                }
            }
            this.a.getAbuseReportStream().postValue(TuplesKt.to(abuseReportLink, arrayList));
        }
    }

    public static final class h<T> implements Consumer<Either<? extends Throwable, ? extends ChannelMenuInteractor.CallUserData>> {
        public final /* synthetic */ ChannelMenuPresenterImpl a;

        public h(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
            this.a = channelMenuPresenterImpl;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Either<? extends Throwable, ? extends ChannelMenuInteractor.CallUserData> either) {
            String str;
            Either<? extends Throwable, ? extends ChannelMenuInteractor.CallUserData> either2 = either;
            if (either2 instanceof Either.Right) {
                ChannelMenuPresenterImpl.access$showCallUserConfirmationDialog(this.a, (ChannelMenuInteractor.CallUserData) ((Either.Right) either2).getB());
            } else if (either2 instanceof Either.Left) {
                Throwable th = (Throwable) ((Either.Left) either2).getA();
                SingleLiveEvent<String> errorMessageStream = this.a.getErrorMessageStream();
                ChannelMenuPresenterImpl channelMenuPresenterImpl = this.a;
                if (th instanceof JsonRpcCallException) {
                    if (((JsonRpcCallException) th).getCode() != -32043) {
                        str = channelMenuPresenterImpl.x.getString(com.avito.android.remote.R.string.unknown_server_error);
                    } else {
                        str = channelMenuPresenterImpl.x.getString(R.string.messenger_phone_number_request_is_forbidden);
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "when (error.code) {\n    …_error)\n                }");
                } else if (th instanceof TimeoutException) {
                    str = channelMenuPresenterImpl.x.getString(R.string.error_timeout);
                    Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.error_timeout)");
                } else {
                    str = channelMenuPresenterImpl.z.format(th);
                }
                errorMessageStream.postValue(str);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public ChannelMenuPresenterImpl(@NotNull ChannelMenuInteractor channelMenuInteractor, @NotNull BlacklistReasonsProvider blacklistReasonsProvider, @NotNull DeeplinkProcessor deeplinkProcessor, @NotNull Resources resources, @NotNull Formatter<String> formatter, @NotNull Formatter<Throwable> formatter2, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory, @NotNull ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup, @NotNull SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> singleManuallyExposedAbTestGroup, @NotNull Relay<MutatorSingle<ChannelMenuView.State>> relay) {
        super("ChannelMenuPresenter", ChannelMenuView.State.Empty.INSTANCE, schedulersFactory, relay);
        Intrinsics.checkNotNullParameter(channelMenuInteractor, "interactor");
        Intrinsics.checkNotNullParameter(blacklistReasonsProvider, "blacklistReasonsProvider");
        Intrinsics.checkNotNullParameter(deeplinkProcessor, "deeplinkProcessor");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(formatter2, "errorFormatter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "messengerFolderTabsTestGroup");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "publishReviewFromChatChannelGroup");
        Intrinsics.checkNotNullParameter(relay, "mutatorsRelay");
        this.u = channelMenuInteractor;
        this.v = blacklistReasonsProvider;
        this.w = deeplinkProcessor;
        this.x = resources;
        this.y = formatter;
        this.z = formatter2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.m = compositeDisposable;
        this.n = new SingleLiveEvent<>();
        this.o = new SingleLiveEvent<>();
        this.p = new SingleLiveEvent<>();
        this.q = new SingleLiveEvent<>();
        this.r = new SingleLiveEvent<>();
        this.s = t6.c.lazy(new b(0, manuallyExposedAbTestGroup));
        this.t = t6.c.lazy(new b(1, singleManuallyExposedAbTestGroup));
        Disposable subscribe = channelMenuInteractor.getStateObservable().observeOn(schedulersFactory.computation()).distinctUntilChanged(new c(this)).subscribe(new d(this, relay));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.stateObservab…actorState)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        Observable<Either<Throwable, Unit>> observeOn = channelMenuInteractor.getUserBlockedStream().observeOn(schedulersFactory.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "interactor.userBlockedSt…schedulers.computation())");
        Observable filterRight = EitherKt.filterRight(observeOn);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Disposable subscribe2 = filterRight.throttleFirst(12000, timeUnit, schedulersFactory.computation()).subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.userBlockedSt…dStream.postValue(Unit) }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
        Observable<Either<Throwable, Unit>> observeOn2 = channelMenuInteractor.getChannelDeletedStream().observeOn(schedulersFactory.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn2, "interactor.channelDelete…schedulers.computation())");
        Disposable subscribe3 = EitherKt.filterRight(observeOn2).throttleFirst(12000, timeUnit, schedulersFactory.computation()).subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "interactor.channelDelete…dStream.postValue(Unit) }");
        DisposableKt.addTo(subscribe3, compositeDisposable);
        Disposable subscribe4 = EitherKt.filterLeft(channelMenuInteractor.getChannelDeletedStream()).mergeWith(EitherKt.filterLeft(channelMenuInteractor.getUserBlockedStream())).observeOn(schedulersFactory.computation()).map(new e(this)).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "interactor.channelDelete…rorMessage)\n            }");
        DisposableKt.addTo(subscribe4, compositeDisposable);
        Disposable subscribe5 = channelMenuInteractor.getAbuseReportDeepLinksStream().observeOn(schedulersFactory.computation()).subscribe(new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "interactor.abuseReportDe…to actions)\n            }");
        DisposableKt.addTo(subscribe5, compositeDisposable);
        Disposable subscribe6 = channelMenuInteractor.getCallUserDataStream().observeOn(schedulersFactory.computation()).subscribe(new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "interactor.callUserDataS…          )\n            }");
        DisposableKt.addTo(subscribe6, compositeDisposable);
    }

    public static final ChannelMenuAction access$createMoveToFolderAction(ChannelMenuPresenterImpl channelMenuPresenterImpl, Channel channel) {
        Pair pair;
        Objects.requireNonNull(channelMenuPresenterImpl);
        SortedSet<String> tags = channel.getTags();
        Folders folders = Folders.INSTANCE;
        if (CollectionsKt___CollectionsKt.intersect(tags, folders.getBARG_AND_EXCHANGE().getMainTags().getFirst()).isEmpty()) {
            pair = TuplesKt.to(folders.getBARG_AND_EXCHANGE(), channelMenuPresenterImpl.x.getString(R.string.messenger_move_to_folder_confirmation_title_b_e));
        } else {
            pair = TuplesKt.to(folders.getUNSORTED(), channelMenuPresenterImpl.x.getString(R.string.messenger_move_to_folder_confirmation_title_i));
        }
        Folder folder = (Folder) pair.component1();
        String str = (String) pair.component2();
        List<String> list = CollectionsKt___CollectionsKt.toList(z.minus((Set) folder.getMainTags().getFirst(), (Iterable) tags));
        List<String> list2 = CollectionsKt___CollectionsKt.toList(z.minus((Set) tags, (Iterable) folder.getMainTags().getFirst()));
        if (!((!list.isEmpty()) || (!list2.isEmpty()))) {
            return null;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(DeepLinkKt.DEEPLINK_URI_SCHEME).authority("1").path(UpdateFolderTagsLink.PATH).appendQueryParameter("channelId", channel.getChannelId()).appendQueryParameter(UpdateFolderTagsLink.FOLDER_ID, folder.getId());
        for (String str2 : list) {
            appendQueryParameter.appendQueryParameter("addTags", str2);
        }
        for (String str3 : list2) {
            appendQueryParameter.appendQueryParameter("removeTags", str3);
        }
        String builder = appendQueryParameter.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "Uri.Builder()\n          …              .toString()");
        String string = channelMenuPresenterImpl.x.getString(R.string.messenger_chat_action_move_to_folder);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…at_action_move_to_folder)");
        UpdateFolderTagsLink updateFolderTagsLink = new UpdateFolderTagsLink(channel.getChannelId(), folder.getId(), list, list2);
        String string2 = channelMenuPresenterImpl.x.getString(R.string.messenger_move_to_folder_confirmation_message);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…der_confirmation_message)");
        String string3 = channelMenuPresenterImpl.x.getString(R.string.messenger_move_to_folder_confirmation_confirm);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…der_confirmation_confirm)");
        String string4 = channelMenuPresenterImpl.x.getString(R.string.messenger_move_to_folder_confirmation_cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…lder_confirmation_cancel)");
        return new ChannelMenuAction(string, updateFolderTagsLink, "move_to_folder", new ActionConfirmation(str, string2, string3, string4), builder);
    }

    public static final String access$formatPhoneNumberRequestError(ChannelMenuPresenterImpl channelMenuPresenterImpl, Throwable th) {
        String str;
        Objects.requireNonNull(channelMenuPresenterImpl);
        if (th instanceof JsonRpcCallException) {
            if (((JsonRpcCallException) th).getCode() != -32043) {
                str = channelMenuPresenterImpl.x.getString(com.avito.android.remote.R.string.unknown_server_error);
            } else {
                str = channelMenuPresenterImpl.x.getString(R.string.messenger_phone_number_request_is_forbidden);
            }
            Intrinsics.checkNotNullExpressionValue(str, "when (error.code) {\n    …_error)\n                }");
            return str;
        } else if (!(th instanceof TimeoutException)) {
            return channelMenuPresenterImpl.z.format(th);
        } else {
            String string = channelMenuPresenterImpl.x.getString(R.string.error_timeout);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.error_timeout)");
            return string;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0398  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair access$getMenuAndAbilityToBlockWithReasons(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl r23, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State r24) {
        /*
        // Method dump skipped, instructions count: 1006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl.access$getMenuAndAbilityToBlockWithReasons(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State):kotlin.Pair");
    }

    public static final boolean access$getMessengerFolderTabsEnabled$p(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
        return ((Boolean) channelMenuPresenterImpl.s.getValue()).booleanValue();
    }

    public static final boolean access$getPublishReviewEnabled$p(ChannelMenuPresenterImpl channelMenuPresenterImpl) {
        return ((Boolean) channelMenuPresenterImpl.t.getValue()).booleanValue();
    }

    public static final boolean access$isTheSameWith(ChannelMenuPresenterImpl channelMenuPresenterImpl, ChannelMenuInteractor.State state, ChannelMenuInteractor.State state2) {
        Objects.requireNonNull(channelMenuPresenterImpl);
        if (Intrinsics.areEqual(state2.getClass(), state.getClass()) && Intrinsics.areEqual(state2.getCurrentUserId(), state.getCurrentUserId())) {
            Channel channel = state2.getChannel();
            SortedSet<String> sortedSet = null;
            ChannelDisplayInfo displayInfo = channel != null ? channel.getDisplayInfo() : null;
            Channel channel2 = state.getChannel();
            if (Intrinsics.areEqual(displayInfo, channel2 != null ? channel2.getDisplayInfo() : null)) {
                Channel channel3 = state2.getChannel();
                ChannelContext context = channel3 != null ? channel3.getContext() : null;
                Channel channel4 = state.getChannel();
                if (Intrinsics.areEqual(context, channel4 != null ? channel4.getContext() : null)) {
                    Channel channel5 = state2.getChannel();
                    SortedSet<String> tags = channel5 != null ? channel5.getTags() : null;
                    Channel channel6 = state.getChannel();
                    if (channel6 != null) {
                        sortedSet = channel6.getTags();
                    }
                    if (Intrinsics.areEqual(tags, sortedSet)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final void access$process(ChannelMenuPresenterImpl channelMenuPresenterImpl, DeepLink deepLink) {
        Objects.requireNonNull(channelMenuPresenterImpl);
        if (deepLink instanceof ChannelCallLink) {
            channelMenuPresenterImpl.u.callUser();
        } else if (deepLink instanceof BlockUserLink) {
            BlockUserLink blockUserLink = (BlockUserLink) deepLink;
            channelMenuPresenterImpl.u.blockUser(blockUserLink.getUserId(), blockUserLink.getChannelId(), blockUserLink.getItemId());
        } else if (deepLink instanceof DeleteChannelLink) {
            channelMenuPresenterImpl.u.deleteChannel(((DeleteChannelLink) deepLink).getChannelId());
        } else if (deepLink instanceof AbuseReportLink) {
            channelMenuPresenterImpl.u.reportAbuse((AbuseReportLink) deepLink);
        } else {
            channelMenuPresenterImpl.w.process(deepLink);
        }
    }

    public static final void access$showCallUserConfirmationDialog(ChannelMenuPresenterImpl channelMenuPresenterImpl, ChannelMenuInteractor.CallUserData callUserData) {
        Relay mutatorsRelay = channelMenuPresenterImpl.getMutatorsRelay();
        ShowCallSellerDialogMutator showCallSellerDialogMutator = new ShowCallSellerDialogMutator(channelMenuPresenterImpl, callUserData.getPhone());
        mutatorsRelay.accept(new MutatorSingle(showCallSellerDialogMutator.getName(), new ChannelMenuPresenterImpl$showCallUserConfirmationDialog$$inlined$plusAssign$1(showCallSellerDialogMutator)));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.MenuAction access$toMenuAction(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl r9, com.avito.android.remote.model.messenger.context.ChannelMenuAction r10, java.lang.String r11) {
        /*
            java.util.Objects.requireNonNull(r9)
            java.lang.String r9 = r10.getIcon()
            r0 = 0
            if (r9 != 0) goto L_0x000c
            goto L_0x007f
        L_0x000c:
            int r1 = r9.hashCode()
            switch(r1) {
                case -1335458389: goto L_0x006f;
                case -1030552698: goto L_0x0060;
                case -934348968: goto L_0x0051;
                case -246517770: goto L_0x0042;
                case 3045982: goto L_0x0033;
                case 386809796: goto L_0x0024;
                case 1286582333: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x007f
        L_0x0015:
            java.lang.String r1 = "block_user"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x007f
            int r9 = com.avito.android.ui_components.R.drawable.ic_rds_block_user
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x007d
        L_0x0024:
            java.lang.String r1 = "move_to_folder"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x007f
            int r9 = com.avito.android.messenger.R.drawable.ic_messenger_move_to_folder
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x007d
        L_0x0033:
            java.lang.String r1 = "call"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x007f
            int r9 = com.avito.android.ui_components.R.drawable.ic_rds_call_24
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x007d
        L_0x0042:
            java.lang.String r1 = "report_user"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x007f
            int r9 = com.avito.android.ui_components.R.drawable.ic_rds_status_error_24
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x007d
        L_0x0051:
            java.lang.String r1 = "review"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x007f
            int r9 = com.avito.android.ui_components.R.drawable.ic_request_review_24
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x007d
        L_0x0060:
            java.lang.String r1 = "question_mark"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x007f
            int r9 = com.avito.android.messenger.R.drawable.ic_help_24
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x007d
        L_0x006f:
            java.lang.String r1 = "delete"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x007f
            int r9 = com.avito.android.ui_components.R.drawable.ic_rds_trash_24
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        L_0x007d:
            r3 = r9
            goto L_0x0080
        L_0x007f:
            r3 = r0
        L_0x0080:
            com.avito.android.deep_linking.links.DeepLink r9 = r10.getDeepLink()
            boolean r9 = r9 instanceof com.avito.android.deep_linking.links.BlockUserWithReasonLink
            if (r9 == 0) goto L_0x008d
            com.avito.android.messenger.analytics.ReportBuyerClickEvent r0 = new com.avito.android.messenger.analytics.ReportBuyerClickEvent
            r0.<init>(r11)
        L_0x008d:
            r5 = r0
            com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView$MenuAction r9 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView$MenuAction
            java.lang.String r2 = r10.getTitle()
            com.avito.android.remote.model.messenger.ActionConfirmation r4 = r10.getConfirmation()
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
            switch-data {-1335458389->0x006f, -1030552698->0x0060, -934348968->0x0051, -246517770->0x0042, 3045982->0x0033, 386809796->0x0024, 1286582333->0x0015, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl.access$toMenuAction(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl, com.avito.android.remote.model.messenger.context.ChannelMenuAction, java.lang.String):com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView$MenuAction");
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.m.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter
    public void openProfile() {
        Relay mutatorsRelay = getMutatorsRelay();
        OpenProfileAction openProfileAction = new OpenProfileAction();
        mutatorsRelay.accept(new MutatorSingle(openProfileAction.getName(), new ChannelMenuPresenterImpl$openProfile$$inlined$plusAssign$1(openProfileAction)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter
    public void showChannelMenu() {
        Relay mutatorsRelay = getMutatorsRelay();
        ShowChannelMenuMutator showChannelMenuMutator = new ShowChannelMenuMutator();
        mutatorsRelay.accept(new MutatorSingle(showChannelMenuMutator.getName(), new ChannelMenuPresenterImpl$showChannelMenu$$inlined$plusAssign$1(showChannelMenuMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter
    @NotNull
    public SingleLiveEvent<Pair<AbuseReportLink, List<Action>>> getAbuseReportStream() {
        return this.p;
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter
    @NotNull
    public SingleLiveEvent<String> getCallUserConfirmedStream() {
        return this.q;
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter
    @NotNull
    public SingleLiveEvent<Unit> getChannelDeletedStream() {
        return this.o;
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter
    @NotNull
    public SingleLiveEvent<String> getErrorMessageStream() {
        return this.r;
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter
    @NotNull
    public SingleLiveEvent<Unit> getUserBlockedStream() {
        return this.n;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChannelMenuPresenterImpl(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor r14, @org.jetbrains.annotations.NotNull com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider r15, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor r16, @org.jetbrains.annotations.NotNull android.content.res.Resources r17, @com.avito.android.util.PhoneNumberFormatterModule.NationalPhoneNumberFormatter @org.jetbrains.annotations.NotNull com.avito.android.util.Formatter<java.lang.String> r18, @org.jetbrains.annotations.NotNull com.avito.android.util.Formatter<java.lang.Throwable> r19, @org.jetbrains.annotations.NotNull com.avito.android.Features r20, @org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r21, @org.jetbrains.annotations.NotNull com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup<com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup> r22, @org.jetbrains.annotations.NotNull com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup<com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup> r23) {
        /*
            r13 = this;
            java.lang.String r0 = "interactor"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "blacklistReasonsProvider"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "deeplinkProcessor"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "resources"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "phoneNumberFormatter"
            r6 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "errorFormatter"
            r7 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "features"
            r8 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "schedulers"
            r9 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "messengerFolderTabsTestGroup"
            r10 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "publishReviewFromChatChannelGroup"
            r11 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.jakewharton.rxrelay2.PublishRelay r0 = com.jakewharton.rxrelay2.PublishRelay.create()
            com.jakewharton.rxrelay2.Relay r12 = r0.toSerialized()
            java.lang.String r0 = "PublishRelay.create<T>().toSerialized()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenterImpl.<init>(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor, com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider, com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor, android.content.res.Resources, com.avito.android.util.Formatter, com.avito.android.util.Formatter, com.avito.android.Features, com.avito.android.util.SchedulersFactory, com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup, com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup):void");
    }
}
