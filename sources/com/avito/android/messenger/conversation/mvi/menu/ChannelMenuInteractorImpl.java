package com.avito.android.messenger.conversation.mvi.menu;

import androidx.annotation.VisibleForTesting;
import arrow.core.Either;
import arrow.core.EitherKt;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.messenger.analytics.OpenUserProfileEvent;
import com.avito.android.messenger.analytics.ShowChatMenuEvent;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.channels.mvi.common.v2.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\bWXYZ[\\]^Bv\b\u0007\u0012\u0011\u00107\u001a\r\u0012\t\u0012\u000703¢\u0006\u0002\b402\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0012\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030R0\u001a\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)¢\u0006\u0004\bT\u0010UBb\b\u0017\u0012\u0011\u00107\u001a\r\u0012\t\u0012\u000703¢\u0006\u0002\b402\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)¢\u0006\u0004\bT\u0010VJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0015\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R.\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u001b0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R.\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u001b0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R!\u00107\u001a\r\u0012\t\u0012\u000703¢\u0006\u0002\b4028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R4\u0010E\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010\u001e\u001a\u0004\bD\u0010 R\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR.\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020J0\u001b0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010\u001e\u001a\u0004\bL\u0010 ¨\u0006_"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "", "callUser", "()V", "", ChannelContext.Item.USER_ID, "channelId", "itemId", "blockUser", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "deleteChannel", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "abuseReportLink", "reportAbuse", "(Lcom/avito/android/deep_linking/links/AbuseReportLink;)V", "trackProfileOpened", "trackMenuOpened", "onCleared", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "w", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelSyncAgent", "Lcom/jakewharton/rxrelay2/Relay;", "Larrow/core/Either;", "", "n", "Lcom/jakewharton/rxrelay2/Relay;", "getUserBlockedStream", "()Lcom/jakewharton/rxrelay2/Relay;", "userBlockedStream", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "u", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "draftRepoWriter", "o", "getChannelDeletedStream", "channelDeletedStream", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/PublishReviewFromChatChannelGroup;", "x", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "publishReviewFromChatChannelGroup", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "s", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "blockUserInteractor", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "r", "Lru/avito/messenger/MessengerClient;", "client", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoWriter;", VKApiConst.VERSION, "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoWriter;", "channelRepoWriter", "Lkotlin/Pair;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", VKApiConst.Q, "getAbuseReportDeepLinksStream", "abuseReportDeepLinksStream", "Lcom/avito/android/analytics/Analytics;", "t", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$CallUserData;", "p", "getCallUserDataStream", "callUserDataStream", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "mutatorsRelay", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoWriter;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoWriter;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "CallUserAction", "ChannelDeletedReaction", "DeleteChannelAction", "NewChannelContextStateMutator", "ReportAbuseAction", "TrackMenuOpenedAction", "TrackProfileOpenedAction", "UserBlockedReaction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelMenuInteractorImpl extends BaseMviEntityWithMutatorsRelay<ChannelMenuInteractor.State> implements ChannelMenuInteractor {
    public final CompositeDisposable m;
    @NotNull
    public final Relay<Either<Throwable, Unit>> n;
    @NotNull
    public final Relay<Either<Throwable, Unit>> o;
    @NotNull
    public final Relay<Either<Throwable, ChannelMenuInteractor.CallUserData>> p;
    @NotNull
    public final Relay<Pair<AbuseReportLink, List<DeepLink>>> q;
    public final MessengerClient<AvitoMessengerApi> r;
    public final BlockUserInteractor s;
    public final Analytics t;
    public final DraftRepoWriter u;
    public final ChannelRepoWriter v;
    public final ChannelSyncAgent w;
    public final SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$CallUserAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class CallUserAction extends ActionSingle<ChannelMenuInteractor.State> {

        public static final class a<T> implements Consumer<String> {
            public final /* synthetic */ CallUserAction a;

            public a(CallUserAction callUserAction) {
                this.a = callUserAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(String str) {
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "phone");
                ChannelMenuInteractorImpl.this.getCallUserDataStream().accept(EitherKt.right(new ChannelMenuInteractor.CallUserData(str2)));
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public final /* synthetic */ CallUserAction a;

            public b(CallUserAction callUserAction) {
                this.a = callUserAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                Relay<Either<Throwable, ChannelMenuInteractor.CallUserData>> callUserDataStream = ChannelMenuInteractorImpl.this.getCallUserDataStream();
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                callUserDataStream.accept(EitherKt.left(ThrowablesKt.toAvitoException(th2)));
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public CallUserAction() {
            super("CallUserAction");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt$sam$i$io_reactivex_functions_Function$0] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.Single<?> invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State r3) {
            /*
                r2 = this;
                java.lang.String r0 = "curState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State$Empty r0 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State.Empty.INSTANCE
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
                if (r0 == 0) goto L_0x0014
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                io.reactivex.Single r3 = com.avito.android.util.Singles.toSingle(r3)
                goto L_0x0076
            L_0x0014:
                boolean r0 = r3 instanceof com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State.Loaded
                if (r0 == 0) goto L_0x0077
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl r0 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.this
                com.avito.android.remote.model.messenger.Channel r3 = r3.getChannel()
                if (r3 == 0) goto L_0x0025
                java.lang.String r3 = r3.getChannelId()
                goto L_0x0026
            L_0x0025:
                r3 = 0
            L_0x0026:
                if (r3 == 0) goto L_0x004f
                ru.avito.messenger.MessengerClient r0 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.access$getClient$p(r0)
                io.reactivex.Single r0 = r0.withMessengerApi()
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$getPhoneNumberByChannelId$1 r1 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$getPhoneNumberByChannelId$1
                r1.<init>(r3)
                io.reactivex.Single r3 = r0.flatMap(r1)
                kotlin.reflect.KProperty1 r0 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$getPhoneNumberByChannelId$2.INSTANCE
                if (r0 == 0) goto L_0x0043
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt$sam$i$io_reactivex_functions_Function$0 r1 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt$sam$i$io_reactivex_functions_Function$0
                r1.<init>(r0)
                r0 = r1
            L_0x0043:
                io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
                io.reactivex.Single r3 = r3.map(r0)
                java.lang.String r0 = "client.withMessengerApi(…oneNumberResponse::phone)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                goto L_0x005f
            L_0x004f:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "Call is not available"
                r3.<init>(r0)
                io.reactivex.Single r3 = io.reactivex.Single.error(r3)
                java.lang.String r0 = "Single.error(IllegalStat…\"Call is not available\"))"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            L_0x005f:
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$CallUserAction$a r0 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$CallUserAction$a
                r0.<init>(r2)
                io.reactivex.Single r3 = r3.doOnSuccess(r0)
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$CallUserAction$b r0 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$CallUserAction$b
                r0.<init>(r2)
                io.reactivex.Single r3 = r3.doOnError(r0)
                java.lang.String r0 = "curState.getPhoneNumberB…                        }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            L_0x0076:
                return r3
            L_0x0077:
                kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
                r3.<init>()
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.CallUserAction.invoke(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State):io.reactivex.Single");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$ChannelDeletedReaction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)Lio/reactivex/Single;", "", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "d", "deletedChannelId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ChannelDeletedReaction extends ActionSingle<ChannelMenuInteractor.State> {
        public final String c;
        public final String d;
        public final /* synthetic */ ChannelMenuInteractorImpl e;

        public static final class a<T, R> implements Function<Object, Unit> {
            public final /* synthetic */ ChannelDeletedReaction a;

            public a(ChannelDeletedReaction channelDeletedReaction) {
                this.a = channelDeletedReaction;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // io.reactivex.functions.Function
            public Unit apply(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                Relay<Either<Throwable, Unit>> channelDeletedStream = this.a.e.getChannelDeletedStream();
                Unit unit = Unit.INSTANCE;
                channelDeletedStream.accept(EitherKt.right(unit));
                return unit;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChannelDeletedReaction(@NotNull ChannelMenuInteractorImpl channelMenuInteractorImpl, @NotNull String str, String str2) {
            super(a2.b.a.a.a.d("ChannelDeletedReaction(", str, ", ", str2));
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "deletedChannelId");
            this.e = channelMenuInteractorImpl;
            this.c = str;
            this.d = str2;
        }

        @NotNull
        public Single<?> invoke(@NotNull ChannelMenuInteractor.State state) {
            Completable completable;
            Intrinsics.checkNotNullParameter(state, "curState");
            if (Intrinsics.areEqual(state.getCurrentUserId(), this.c)) {
                Channel channel = state.getChannel();
                String str = null;
                if (Intrinsics.areEqual(channel != null ? channel.getChannelId() : null, this.d)) {
                    ChannelMenuInteractorImpl channelMenuInteractorImpl = this.e;
                    Channel channel2 = state.getChannel();
                    if (channel2 != null) {
                        str = channel2.getChannelId();
                    }
                    boolean z = true;
                    if (!m.isBlank(state.getCurrentUserId())) {
                        if (str != null && !m.isBlank(str)) {
                            z = false;
                        }
                        if (!z) {
                            completable = channelMenuInteractorImpl.u.deleteDraft(state.getCurrentUserId(), str).andThen(channelMenuInteractorImpl.v.deleteChannel(state.getCurrentUserId(), str)).onErrorComplete();
                            Single singleDefault = completable.toSingleDefault(Unit.INSTANCE);
                            Intrinsics.checkNotNullExpressionValue(singleDefault, "if (\n            current…   .toSingleDefault(Unit)");
                            Single<?> map = singleDefault.map(new a(this));
                            Intrinsics.checkNotNullExpressionValue(map, "curState.deleteDraftAndC…t()\n                    }");
                            return map;
                        }
                    }
                    completable = Completable.complete();
                    Single singleDefault = completable.toSingleDefault(Unit.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(singleDefault, "if (\n            current…   .toSingleDefault(Unit)");
                    Single<?> map = singleDefault.map(new a(this));
                    Intrinsics.checkNotNullExpressionValue(map, "curState.deleteDraftAndC…t()\n                    }");
                    return map;
                }
            }
            return Singles.toSingle(Unit.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$DeleteChannelAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)Lio/reactivex/Single;", "", "c", "Ljava/lang/String;", "channelId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class DeleteChannelAction extends ActionSingle<ChannelMenuInteractor.State> {
        public final String c;
        public final /* synthetic */ ChannelMenuInteractorImpl d;

        public static final class a<T> implements Consumer<Unit> {
            public final /* synthetic */ DeleteChannelAction a;

            public a(DeleteChannelAction deleteChannelAction) {
                this.a = deleteChannelAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Unit unit) {
                this.a.d.getChannelDeletedStream().accept(EitherKt.right(Unit.INSTANCE));
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public final /* synthetic */ DeleteChannelAction a;

            public b(DeleteChannelAction deleteChannelAction) {
                this.a = deleteChannelAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                Relay<Either<Throwable, Unit>> channelDeletedStream = this.a.d.getChannelDeletedStream();
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                channelDeletedStream.accept(EitherKt.left(ThrowablesKt.toAvitoException(th2)));
            }
        }

        public static final class c<V> implements Callable<Unit> {
            public final /* synthetic */ DeleteChannelAction a;

            public c(DeleteChannelAction deleteChannelAction) {
                this.a = deleteChannelAction;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public Unit call() {
                this.a.d.getChannelDeletedStream().accept(EitherKt.left(new IllegalArgumentException("Channel IDs do not match")));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteChannelAction(@NotNull ChannelMenuInteractorImpl channelMenuInteractorImpl, String str) {
            super("DeleteChannelAction");
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.d = channelMenuInteractorImpl;
            this.c = str;
        }

        @NotNull
        public Single<?> invoke(@NotNull ChannelMenuInteractor.State state) {
            Single<?> single;
            Intrinsics.checkNotNullParameter(state, "curState");
            if (Intrinsics.areEqual(state, ChannelMenuInteractor.State.Empty.INSTANCE)) {
                return Singles.toSingle(Unit.INSTANCE);
            }
            if (state instanceof ChannelMenuInteractor.State.Loaded) {
                if (Intrinsics.areEqual(this.c, ((ChannelMenuInteractor.State.Loaded) state).getChannel().getChannelId())) {
                    single = this.d.w.deleteChatAndDraftFromEverywhere(state.getCurrentUserId(), this.c).toSingleDefault(Unit.INSTANCE).observeOn(this.d.getSchedulerForMutators()).doOnSuccess(new a(this)).doOnError(new b(this));
                } else {
                    single = Single.fromCallable(new c(this));
                }
                Intrinsics.checkNotNullExpressionValue(single, "if (channelId == curStat…  }\n                    }");
                return single;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$NewChannelContextStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "", "c", "Ljava/lang/String;", "currentUserId", "Lcom/avito/android/remote/model/messenger/Channel;", "d", "Lcom/avito/android/remote/model/messenger/Channel;", "channel", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/Channel;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class NewChannelContextStateMutator extends Mutator<ChannelMenuInteractor.State> {
        public final String c;
        public final Channel d;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public NewChannelContextStateMutator(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl r3, @org.jetbrains.annotations.Nullable java.lang.String r4, com.avito.android.remote.model.messenger.Channel r5) {
            /*
                r2 = this;
                java.lang.String r3 = "currentUserId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "NewChannelContextStateMutator("
                r3.append(r0)
                r3.append(r4)
                java.lang.String r0 = ", "
                r3.append(r0)
                if (r5 == 0) goto L_0x001e
                java.lang.String r0 = r5.getChannelId()
                goto L_0x001f
            L_0x001e:
                r0 = 0
            L_0x001f:
                r1 = 41
                java.lang.String r3 = a2.b.a.a.a.s(r3, r0, r1)
                r2.<init>(r3)
                r2.c = r4
                r2.d = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.NewChannelContextStateMutator.<init>(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl, java.lang.String, com.avito.android.remote.model.messenger.Channel):void");
        }

        @NotNull
        public ChannelMenuInteractor.State invoke(@NotNull ChannelMenuInteractor.State state) {
            Channel channel;
            Channel channel2;
            Intrinsics.checkNotNullParameter(state, "oldState");
            ChannelMenuInteractor.State.Empty empty = ChannelMenuInteractor.State.Empty.INSTANCE;
            if (Intrinsics.areEqual(state, empty)) {
                if (!(!m.isBlank(this.c)) || (channel2 = this.d) == null) {
                    return state;
                }
                return new ChannelMenuInteractor.State.Loaded(this.c, channel2);
            } else if (!(state instanceof ChannelMenuInteractor.State.Loaded)) {
                throw new NoWhenBranchMatchedException();
            } else if (!(!m.isBlank(this.c)) || (channel = this.d) == null) {
                return empty;
            } else {
                ChannelMenuInteractor.State.Loaded loaded = (ChannelMenuInteractor.State.Loaded) state;
                return ((Intrinsics.areEqual(loaded.getCurrentUserId(), this.c) ^ true) || (Intrinsics.areEqual(loaded.getChannel().getChannelId(), channel.getChannelId()) ^ true) || loaded.getChannel().getUpdated() < channel.getUpdated() || (Intrinsics.areEqual(loaded.getChannel().getContext(), channel.getContext()) ^ true)) ? loaded.copy(loaded.getCurrentUserId(), channel) : loaded;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$ReportAbuseAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)V", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "c", "Lcom/avito/android/deep_linking/links/AbuseReportLink;", "abuseReportLink", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;Lcom/avito/android/deep_linking/links/AbuseReportLink;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ReportAbuseAction extends Action<ChannelMenuInteractor.State> {
        public final AbuseReportLink c;
        public final /* synthetic */ ChannelMenuInteractorImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReportAbuseAction(@NotNull ChannelMenuInteractorImpl channelMenuInteractorImpl, AbuseReportLink abuseReportLink) {
            super("ReportAbuseAction");
            Intrinsics.checkNotNullParameter(abuseReportLink, "abuseReportLink");
            this.d = channelMenuInteractorImpl;
            this.c = abuseReportLink;
        }

        public void invoke(@NotNull ChannelMenuInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            ArrayList arrayList = new ArrayList();
            Channel channel = state.getChannel();
            if (channel != null) {
                arrayList.add(new NoMatchLink());
                arrayList.add(ChannelMenuInteractorKt.access$getDeleteLink$p(channel));
            }
            this.d.getAbuseReportDeepLinksStream().accept(TuplesKt.to(this.c, CollectionsKt___CollectionsKt.filterNotNull(arrayList)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$TrackMenuOpenedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)V", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class TrackMenuOpenedAction extends Action<ChannelMenuInteractor.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public TrackMenuOpenedAction() {
            super("TrackMenuOpenedAction");
        }

        public void invoke(@NotNull ChannelMenuInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            String str = null;
            if (state instanceof ChannelMenuInteractor.State.Loaded) {
                ChannelMenuInteractor.State.Loaded loaded = (ChannelMenuInteractor.State.Loaded) state;
                ChannelContext context = loaded.getChannel().getContext();
                if (!(context instanceof ChannelContext.Item)) {
                    context = null;
                }
                ChannelContext.Item item = (ChannelContext.Item) context;
                String channelId = loaded.getChannel().getChannelId();
                String id = item != null ? item.getId() : null;
                if (item != null) {
                    str = item.getUserId();
                }
                ChannelMenuInteractorImpl.this.t.track(new ShowChatMenuEvent(channelId, id, str));
                ChannelMenuInteractorImpl.this.x.exposeIfNeeded();
            } else if (Intrinsics.areEqual(state, ChannelMenuInteractor.State.Empty.INSTANCE)) {
                Logs.warning$default(ChannelMenuInteractorImpl.this.getTAG(), "ShowChatMenuEvent wasn't tracked – channel wasn't loaded", null, 4, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$TrackProfileOpenedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)V", "", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class TrackProfileOpenedAction extends Action<ChannelMenuInteractor.State> {
        public final String c;
        public final /* synthetic */ ChannelMenuInteractorImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TrackProfileOpenedAction(@NotNull ChannelMenuInteractorImpl channelMenuInteractorImpl, String str) {
            super(a2.b.a.a.a.d3("TrackProfileOpenedAction(", str, ')'));
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            this.d = channelMenuInteractorImpl;
            this.c = str;
        }

        public void invoke(@NotNull ChannelMenuInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            String str = null;
            if (state instanceof ChannelMenuInteractor.State.Loaded) {
                ChannelMenuInteractor.State.Loaded loaded = (ChannelMenuInteractor.State.Loaded) state;
                ChannelContext context = loaded.getChannel().getContext();
                if (!(context instanceof ChannelContext.Item)) {
                    context = null;
                }
                ChannelContext.Item item = (ChannelContext.Item) context;
                String channelId = loaded.getChannel().getChannelId();
                String str2 = this.c;
                String id = item != null ? item.getId() : null;
                if (item != null) {
                    str = item.getUserId();
                }
                this.d.t.track(new OpenUserProfileEvent(channelId, str2, id, str, OpenUserProfileEvent.SOURCE_MESSENGER_MENU));
            } else if (Intrinsics.areEqual(state, ChannelMenuInteractor.State.Empty.INSTANCE)) {
                Logs.warning$default(this.d.getTAG(), "OpenUserProfileEvent wasn't tracked – channel was't loaded", null, 4, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl$UserBlockedReaction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor$State;)Lio/reactivex/Single;", "", "d", "Ljava/lang/String;", "channelId", "c", "blockedUserId", "e", "itemId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractorImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UserBlockedReaction extends ActionSingle<ChannelMenuInteractor.State> {
        public final String c;
        public final String d;
        public final String e;
        public final /* synthetic */ ChannelMenuInteractorImpl f;

        public static final class a<T, R> implements Function<Object, Unit> {
            public final /* synthetic */ UserBlockedReaction a;

            public a(UserBlockedReaction userBlockedReaction) {
                this.a = userBlockedReaction;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // io.reactivex.functions.Function
            public Unit apply(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                Relay<Either<Throwable, Unit>> userBlockedStream = this.a.f.getUserBlockedStream();
                Unit unit = Unit.INSTANCE;
                userBlockedStream.accept(EitherKt.right(unit));
                return unit;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserBlockedReaction(@NotNull ChannelMenuInteractorImpl channelMenuInteractorImpl, @NotNull String str, @Nullable String str2, String str3) {
            super(a2.b.a.a.a.e("UserBlockedReaction(", str, ", ", str2, ')'));
            Intrinsics.checkNotNullParameter(str, "blockedUserId");
            Intrinsics.checkNotNullParameter(str2, "channelId");
            this.f = channelMenuInteractorImpl;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt.access$getContextItemIdString$p(r0), r7.e) != false) goto L_0x004a;
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.Single<?> invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State r8) {
            /*
                r7 = this;
                java.lang.String r0 = "curState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                com.avito.android.remote.model.messenger.Channel r0 = r8.getChannel()
                if (r0 == 0) goto L_0x00c7
                java.lang.String r1 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt.access$getInterlocutorUserId$p(r8)
                java.lang.String r2 = r7.c
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                if (r1 == 0) goto L_0x00c0
                java.lang.String r1 = r7.d
                boolean r1 = t6.y.m.isBlank(r1)
                r2 = 1
                r1 = r1 ^ r2
                r3 = 0
                if (r1 == 0) goto L_0x002e
                java.lang.String r1 = r0.getChannelId()
                java.lang.String r4 = r7.d
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
                if (r1 != 0) goto L_0x004a
            L_0x002e:
                java.lang.String r1 = r7.e
                if (r1 == 0) goto L_0x003b
                boolean r1 = t6.y.m.isBlank(r1)
                if (r1 == 0) goto L_0x0039
                goto L_0x003b
            L_0x0039:
                r1 = 0
                goto L_0x003c
            L_0x003b:
                r1 = 1
            L_0x003c:
                if (r1 != 0) goto L_0x00c0
                java.lang.String r0 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt.access$getContextItemIdString$p(r0)
                java.lang.String r1 = r7.e
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x00c0
            L_0x004a:
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl r0 = r7.f
                java.lang.String r1 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt.access$getInterlocutorUserId$p(r8)
                com.avito.android.remote.model.messenger.Channel r4 = r8.getChannel()
                if (r4 == 0) goto L_0x005b
                java.lang.String r4 = r4.getChannelId()
                goto L_0x005c
            L_0x005b:
                r4 = 0
            L_0x005c:
                java.lang.String r5 = r8.getCurrentUserId()
                boolean r5 = t6.y.m.isBlank(r5)
                r5 = r5 ^ r2
                if (r5 == 0) goto L_0x00a2
                if (r1 == 0) goto L_0x0072
                boolean r5 = t6.y.m.isBlank(r1)
                if (r5 == 0) goto L_0x0070
                goto L_0x0072
            L_0x0070:
                r5 = 0
                goto L_0x0073
            L_0x0072:
                r5 = 1
            L_0x0073:
                if (r5 != 0) goto L_0x00a2
                com.avito.android.messenger.channels.mvi.data.DraftRepoWriter r5 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.access$getDraftRepoWriter$p(r0)
                java.lang.String r6 = r8.getCurrentUserId()
                io.reactivex.Completable r1 = r5.deleteAllDraftsWithInterlocutor(r6, r1)
                if (r4 == 0) goto L_0x008b
                boolean r5 = t6.y.m.isBlank(r4)
                if (r5 == 0) goto L_0x008a
                goto L_0x008b
            L_0x008a:
                r2 = 0
            L_0x008b:
                if (r2 != 0) goto L_0x009d
                com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter r0 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.access$getChannelRepoWriter$p(r0)
                java.lang.String r8 = r8.getCurrentUserId()
                io.reactivex.Completable r8 = r0.deleteChannel(r8, r4)
                io.reactivex.Completable r1 = r1.andThen(r8)
            L_0x009d:
                io.reactivex.Completable r8 = r1.onErrorComplete()
                goto L_0x00a6
            L_0x00a2:
                io.reactivex.Completable r8 = io.reactivex.Completable.complete()
            L_0x00a6:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                io.reactivex.Single r8 = r8.toSingleDefault(r0)
                java.lang.String r0 = "if (\n            current…   .toSingleDefault(Unit)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
                com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$UserBlockedReaction$a r0 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$UserBlockedReaction$a
                r0.<init>(r7)
                io.reactivex.Single r8 = r8.map(r0)
                java.lang.String r0 = "curState.deleteAllDrafts…t()\n                    }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
                goto L_0x00c6
            L_0x00c0:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                io.reactivex.Single r8 = com.avito.android.util.Singles.toSingle(r8)
            L_0x00c6:
                return r8
            L_0x00c7:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                io.reactivex.Single r8 = com.avito.android.util.Singles.toSingle(r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.UserBlockedReaction.invoke(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State):io.reactivex.Single");
        }
    }

    public static final class a<T, R> implements Function<ChannelContextInteractor.State, Pair<? extends String, ? extends Channel>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends String, ? extends Channel> apply(ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "channelContextState");
            String currentUserId = state2.getCurrentUserId();
            Loading<Channel> channelState = state2.getChannelState();
            Channel channel = null;
            if (!(channelState instanceof Loading.Success)) {
                channelState = null;
            }
            Loading.Success success = (Loading.Success) channelState;
            if (success != null) {
                channel = (Channel) success.getValue();
            }
            return TuplesKt.to(currentUserId, channel);
        }
    }

    public static final class b<T> implements Consumer<Pair<? extends String, ? extends Channel>> {
        public final /* synthetic */ ChannelMenuInteractorImpl a;
        public final /* synthetic */ Relay b;

        public b(ChannelMenuInteractorImpl channelMenuInteractorImpl, Relay relay) {
            this.a = channelMenuInteractorImpl;
            this.b = relay;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends String, ? extends Channel> pair) {
            Pair<? extends String, ? extends Channel> pair2 = pair;
            Relay relay = this.b;
            NewChannelContextStateMutator newChannelContextStateMutator = new NewChannelContextStateMutator(this.a, (String) pair2.component1(), (Channel) pair2.component2());
            relay.accept(new MutatorSingle(newChannelContextStateMutator.getName(), new ChannelMenuInteractorImpl$2$$special$$inlined$plusAssign$1(newChannelContextStateMutator)));
        }
    }

    public static final class c<T, R> implements Function<Boolean, ObservableSource<? extends BlockUserInteractor.Result>> {
        public final /* synthetic */ ChannelMenuInteractorImpl a;

        public c(ChannelMenuInteractorImpl channelMenuInteractorImpl) {
            this.a = channelMenuInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends BlockUserInteractor.Result> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "isLoaded");
            if (!bool2.booleanValue()) {
                return Observable.never();
            }
            Observable<U> ofType = this.a.s.getResultStream().ofType(BlockUserInteractor.Result.class);
            Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
            return ofType;
        }
    }

    public static final class d<T> implements Consumer<BlockUserInteractor.Result> {
        public final /* synthetic */ ChannelMenuInteractorImpl a;
        public final /* synthetic */ Relay b;

        public d(ChannelMenuInteractorImpl channelMenuInteractorImpl, Relay relay) {
            this.a = channelMenuInteractorImpl;
            this.b = relay;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(BlockUserInteractor.Result result) {
            BlockUserInteractor.Result result2 = result;
            if (result2 instanceof BlockUserInteractor.Result.Success) {
                if (((BlockUserInteractor.Result.Success) result2).isBlocked()) {
                    Relay relay = this.b;
                    UserBlockedReaction userBlockedReaction = new UserBlockedReaction(this.a, result2.getAction().getUserId(), result2.getAction().getChannelId(), result2.getAction().getItemId());
                    relay.accept(new MutatorSingle(userBlockedReaction.getName(), new ChannelMenuInteractorImpl$4$$special$$inlined$plusAssign$1(userBlockedReaction)));
                }
            } else if ((result2 instanceof BlockUserInteractor.Result.Error) && (result2.getAction() instanceof BlockUserInteractor.Action.BlockUser)) {
                this.a.getUserBlockedStream().accept(EitherKt.left(((BlockUserInteractor.Result.Error) result2).getError()));
            }
        }
    }

    public static final class e<T, R> implements Function<Boolean, ObservableSource<? extends ChatClearEvent>> {
        public final /* synthetic */ ChannelMenuInteractorImpl a;

        public e(ChannelMenuInteractorImpl channelMenuInteractorImpl) {
            this.a = channelMenuInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ChatClearEvent> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "isLoaded");
            if (bool2.booleanValue()) {
                return this.a.r.observeChatEvents(ChatClearEvent.class);
            }
            return Observable.never();
        }
    }

    public static final class f<T> implements Consumer<ChatClearEvent> {
        public final /* synthetic */ ChannelMenuInteractorImpl a;
        public final /* synthetic */ Relay b;

        public f(ChannelMenuInteractorImpl channelMenuInteractorImpl, Relay relay) {
            this.a = channelMenuInteractorImpl;
            this.b = relay;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChatClearEvent chatClearEvent) {
            ChatClearEvent chatClearEvent2 = chatClearEvent;
            Relay relay = this.b;
            ChannelDeletedReaction channelDeletedReaction = new ChannelDeletedReaction(this.a, chatClearEvent2.uid, chatClearEvent2.getChannelId());
            relay.accept(new MutatorSingle(channelDeletedReaction.getName(), new ChannelMenuInteractorImpl$6$$special$$inlined$plusAssign$1(channelDeletedReaction)));
        }
    }

    public static final class g<T, R> implements Function<ChannelMenuInteractor.State, Boolean> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(ChannelMenuInteractor.State state) {
            ChannelMenuInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            return Boolean.valueOf(state2 instanceof ChannelMenuInteractor.State.Loaded);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public ChannelMenuInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull BlockUserInteractor blockUserInteractor, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull DraftRepoWriter draftRepoWriter, @NotNull ChannelRepoWriter channelRepoWriter, @NotNull ChannelSyncAgent channelSyncAgent, @NotNull Relay<MutatorSingle<ChannelMenuInteractor.State>> relay, @NotNull SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> singleManuallyExposedAbTestGroup) {
        super("ChannelMenuInteractor", ChannelMenuInteractor.State.Empty.INSTANCE, schedulersFactory, relay);
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(blockUserInteractor, "blockUserInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(draftRepoWriter, "draftRepoWriter");
        Intrinsics.checkNotNullParameter(channelRepoWriter, "channelRepoWriter");
        Intrinsics.checkNotNullParameter(channelSyncAgent, "channelSyncAgent");
        Intrinsics.checkNotNullParameter(relay, "mutatorsRelay");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "publishReviewFromChatChannelGroup");
        this.r = messengerClient;
        this.s = blockUserInteractor;
        this.t = analytics;
        this.u = draftRepoWriter;
        this.v = channelRepoWriter;
        this.w = channelSyncAgent;
        this.x = singleManuallyExposedAbTestGroup;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.m = compositeDisposable;
        this.n = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.o = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.p = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.q = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        Disposable subscribe = channelContextInteractor.getStateObservable().observeOn(schedulersFactory.computation()).map(a.a).subscribe(new b(this, relay));
        Intrinsics.checkNotNullExpressionValue(subscribe, "channelContextInteractor…d, channel)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        ConnectableObservable publish = getStateObservable().observeOn(schedulersFactory.computation()).map(g.a).distinctUntilChanged().publish();
        Disposable subscribe2 = publish.switchMap(new c(this)).subscribe(new d(this, relay));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "sharedLoadedState\n      …          }\n            }");
        DisposableKt.addTo(subscribe2, compositeDisposable);
        Disposable subscribe3 = publish.switchMap(new e(this)).subscribe(new f(this, relay));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "sharedLoadedState\n      ….channelId)\n            }");
        DisposableKt.addTo(subscribe3, compositeDisposable);
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "sharedLoadedState.connect()");
        DisposableKt.addTo(connect, compositeDisposable);
    }

    public static final Single access$deleteAllDraftsWithInterlocutorAndChatFromDb(ChannelMenuInteractorImpl channelMenuInteractorImpl, ChannelMenuInteractor.State state) {
        Completable completable;
        Objects.requireNonNull(channelMenuInteractorImpl);
        String access$getInterlocutorUserId$p = ChannelMenuInteractorKt.access$getInterlocutorUserId$p(state);
        Channel channel = state.getChannel();
        String channelId = channel != null ? channel.getChannelId() : null;
        boolean z = true;
        if (!m.isBlank(state.getCurrentUserId())) {
            if (!(access$getInterlocutorUserId$p == null || m.isBlank(access$getInterlocutorUserId$p))) {
                Completable deleteAllDraftsWithInterlocutor = channelMenuInteractorImpl.u.deleteAllDraftsWithInterlocutor(state.getCurrentUserId(), access$getInterlocutorUserId$p);
                if (channelId != null && !m.isBlank(channelId)) {
                    z = false;
                }
                if (!z) {
                    deleteAllDraftsWithInterlocutor = deleteAllDraftsWithInterlocutor.andThen(channelMenuInteractorImpl.v.deleteChannel(state.getCurrentUserId(), channelId));
                }
                completable = deleteAllDraftsWithInterlocutor.onErrorComplete();
                Single singleDefault = completable.toSingleDefault(Unit.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(singleDefault, "if (\n            current…   .toSingleDefault(Unit)");
                return singleDefault;
            }
        }
        completable = Completable.complete();
        Single singleDefault = completable.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "if (\n            current…   .toSingleDefault(Unit)");
        return singleDefault;
    }

    public static final Single access$deleteDraftAndChatFromDb(ChannelMenuInteractorImpl channelMenuInteractorImpl, ChannelMenuInteractor.State state) {
        Completable completable;
        Objects.requireNonNull(channelMenuInteractorImpl);
        Channel channel = state.getChannel();
        String channelId = channel != null ? channel.getChannelId() : null;
        boolean z = true;
        if (!m.isBlank(state.getCurrentUserId())) {
            if (channelId != null && !m.isBlank(channelId)) {
                z = false;
            }
            if (!z) {
                completable = channelMenuInteractorImpl.u.deleteDraft(state.getCurrentUserId(), channelId).andThen(channelMenuInteractorImpl.v.deleteChannel(state.getCurrentUserId(), channelId)).onErrorComplete();
                Single singleDefault = completable.toSingleDefault(Unit.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(singleDefault, "if (\n            current…   .toSingleDefault(Unit)");
                return singleDefault;
            }
        }
        completable = Completable.complete();
        Single singleDefault = completable.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "if (\n            current…   .toSingleDefault(Unit)");
        return singleDefault;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt$sam$i$io_reactivex_functions_Function$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.Single access$getPhoneNumberByChannelId(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl r1, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State r2) {
        /*
            java.util.Objects.requireNonNull(r1)
            com.avito.android.remote.model.messenger.Channel r2 = r2.getChannel()
            if (r2 == 0) goto L_0x000e
            java.lang.String r2 = r2.getChannelId()
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            if (r2 == 0) goto L_0x0038
            ru.avito.messenger.MessengerClient r1 = access$getClient$p(r1)
            io.reactivex.Single r1 = r1.withMessengerApi()
            com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$getPhoneNumberByChannelId$1 r0 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$getPhoneNumberByChannelId$1
            r0.<init>(r2)
            io.reactivex.Single r1 = r1.flatMap(r0)
            kotlin.reflect.KProperty1 r2 = com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$getPhoneNumberByChannelId$2.INSTANCE
            if (r2 == 0) goto L_0x002c
            com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt$sam$i$io_reactivex_functions_Function$0 r0 = new com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorKt$sam$i$io_reactivex_functions_Function$0
            r0.<init>(r2)
            r2 = r0
        L_0x002c:
            io.reactivex.functions.Function r2 = (io.reactivex.functions.Function) r2
            io.reactivex.Single r1 = r1.map(r2)
            java.lang.String r2 = "client.withMessengerApi(…oneNumberResponse::phone)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            goto L_0x0048
        L_0x0038:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Call is not available"
            r1.<init>(r2)
            io.reactivex.Single r1 = io.reactivex.Single.error(r1)
            java.lang.String r2 = "Single.error(IllegalStat…\"Call is not available\"))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.access$getPhoneNumberByChannelId(com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State):io.reactivex.Single");
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    public void blockUser(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        BlockUserInteractor.DefaultImpls.blockUser$default(this.s, str, str2, str3, null, 8, null);
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    public void callUser() {
        Relay mutatorsRelay = getMutatorsRelay();
        CallUserAction callUserAction = new CallUserAction();
        mutatorsRelay.accept(new MutatorSingle(callUserAction.getName(), new Function1<ChannelMenuInteractor.State, Single<ChannelMenuInteractor.State>>(callUserAction) { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$callUser$$inlined$plusAssign$1
            public final /* synthetic */ ActionSingle a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Single<ChannelMenuInteractor.State> invoke(@NotNull final ChannelMenuInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                Single<ChannelMenuInteractor.State> onErrorReturn = ((Single) this.a.getBlock().invoke(state)).map(new Function<Object, ChannelMenuInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$callUser$$inlined$plusAssign$1.1
                    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // io.reactivex.functions.Function
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$callUser$$inlined$plusAssign$1.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
                    }
                }).onErrorReturn(new Function<Throwable, ChannelMenuInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$callUser$$inlined$plusAssign$1.2
                    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$callUser$$inlined$plusAssign$1.AnonymousClass2.apply(java.lang.Throwable):java.lang.Object");
                    }
                });
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
                return onErrorReturn;
            }
        }));
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    public void deleteChannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Relay mutatorsRelay = getMutatorsRelay();
        DeleteChannelAction deleteChannelAction = new DeleteChannelAction(this, str);
        mutatorsRelay.accept(new MutatorSingle(deleteChannelAction.getName(), new Function1<ChannelMenuInteractor.State, Single<ChannelMenuInteractor.State>>(deleteChannelAction) { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$deleteChannel$$inlined$plusAssign$1
            public final /* synthetic */ ActionSingle a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Single<ChannelMenuInteractor.State> invoke(@NotNull final ChannelMenuInteractor.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                Single<ChannelMenuInteractor.State> onErrorReturn = ((Single) this.a.getBlock().invoke(state)).map(new Function<Object, ChannelMenuInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$deleteChannel$$inlined$plusAssign$1.1
                    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // io.reactivex.functions.Function
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$deleteChannel$$inlined$plusAssign$1.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
                    }
                }).onErrorReturn(new Function<Throwable, ChannelMenuInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$deleteChannel$$inlined$plusAssign$1.2
                    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$deleteChannel$$inlined$plusAssign$1.AnonymousClass2.apply(java.lang.Throwable):java.lang.Object");
                    }
                });
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
                return onErrorReturn;
            }
        }));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.s.reset();
        this.m.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    public void reportAbuse(@NotNull AbuseReportLink abuseReportLink) {
        Intrinsics.checkNotNullParameter(abuseReportLink, "abuseReportLink");
        Relay mutatorsRelay = getMutatorsRelay();
        ReportAbuseAction reportAbuseAction = new ReportAbuseAction(this, abuseReportLink);
        mutatorsRelay.accept(new MutatorSingle(reportAbuseAction.getName(), new ChannelMenuInteractorImpl$reportAbuse$$inlined$plusAssign$1(reportAbuseAction)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    public void trackMenuOpened() {
        Relay mutatorsRelay = getMutatorsRelay();
        TrackMenuOpenedAction trackMenuOpenedAction = new TrackMenuOpenedAction();
        mutatorsRelay.accept(new MutatorSingle(trackMenuOpenedAction.getName(), new ChannelMenuInteractorImpl$trackMenuOpened$$inlined$plusAssign$1(trackMenuOpenedAction)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    public void trackProfileOpened(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Relay mutatorsRelay = getMutatorsRelay();
        TrackProfileOpenedAction trackProfileOpenedAction = new TrackProfileOpenedAction(this, str);
        mutatorsRelay.accept(new MutatorSingle(trackProfileOpenedAction.getName(), new ChannelMenuInteractorImpl$trackProfileOpened$$inlined$plusAssign$1(trackProfileOpenedAction)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    @NotNull
    public Relay<Pair<AbuseReportLink, List<DeepLink>>> getAbuseReportDeepLinksStream() {
        return this.q;
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    @NotNull
    public Relay<Either<Throwable, ChannelMenuInteractor.CallUserData>> getCallUserDataStream() {
        return this.p;
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    @NotNull
    public Relay<Either<Throwable, Unit>> getChannelDeletedStream() {
        return this.o;
    }

    @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor
    @NotNull
    public Relay<Either<Throwable, Unit>> getUserBlockedStream() {
        return this.n;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChannelMenuInteractorImpl(@org.jetbrains.annotations.NotNull ru.avito.messenger.MessengerClient<ru.avito.messenger.api.AvitoMessengerApi> r13, @org.jetbrains.annotations.NotNull com.avito.android.messenger.blacklist_reasons.BlockUserInteractor r14, @org.jetbrains.annotations.NotNull com.avito.android.analytics.Analytics r15, @org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r16, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor r17, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.data.DraftRepoWriter r18, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter r19, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent r20, @org.jetbrains.annotations.NotNull com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup<com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup> r21) {
        /*
            r12 = this;
            java.lang.String r0 = "client"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "blockUserInteractor"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "analytics"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "schedulers"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "channelContextInteractor"
            r6 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "draftRepoWriter"
            r7 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "channelRepoWriter"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "channelSyncAgent"
            r9 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "publishReviewFromChatChannelGroup"
            r11 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.jakewharton.rxrelay2.PublishRelay r0 = com.jakewharton.rxrelay2.PublishRelay.create()
            com.jakewharton.rxrelay2.Relay r10 = r0.toSerialized()
            java.lang.String r0 = "PublishRelay.create<T>().toSerialized()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl.<init>(ru.avito.messenger.MessengerClient, com.avito.android.messenger.blacklist_reasons.BlockUserInteractor, com.avito.android.analytics.Analytics, com.avito.android.util.SchedulersFactory, com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor, com.avito.android.messenger.channels.mvi.data.DraftRepoWriter, com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter, com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent, com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup):void");
    }
}
