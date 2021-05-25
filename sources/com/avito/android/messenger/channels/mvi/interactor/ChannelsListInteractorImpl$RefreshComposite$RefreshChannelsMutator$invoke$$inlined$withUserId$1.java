package com.avito.android.messenger.channels.mvi.interactor;

import a2.a.a.o1.b.b.b.v;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.Some;
import com.avito.android.BuildConfig;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshResult;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.util.Singles;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxkotlin.SinglesKt;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"R", "Larrow/core/Option;", "", "userIdOption", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/SingleSource;", "com/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$withUserId$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1<T, R> implements Function<Option<? extends String>, SingleSource<? extends R>> {
    public final /* synthetic */ ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator a;
    public final /* synthetic */ ChannelsListInteractor.State b;

    public static final class a<T, R> implements Function<Pair<? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>>, ? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>>>, ChannelsListInteractor.State> {
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1 b;

        public a(String str, ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1 channelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1) {
            this.a = str;
            this.b = channelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v16, resolved type: com.avito.android.analytics.timer.AnalyticsTimer */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00e1: APUT  
          (r5v4 kotlin.Pair[])
          (0 ??[int, short, byte, char])
          (wrap: kotlin.Pair : 0x00dd: INVOKE  (r11v7 kotlin.Pair) = ("includeTags"), (r11v6 java.lang.Object) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
         */
        @Override // io.reactivex.functions.Function
        public ChannelsListInteractor.State apply(Pair<? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>>, ? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>>> pair) {
            Long l;
            ChannelsListInteractor.State.Loading loading;
            List<Pair<Channel, DraftEntity>> list;
            Object obj;
            Object obj2;
            Option<Long> oldestSyncedChatTimestamp;
            Pair<? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>>, ? extends Notification<Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>>> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
            Notification notification = (Notification) pair2.component1();
            Notification notification2 = (Notification) pair2.component2();
            if (!notification.isOnError() || !notification2.isOnError()) {
                Object value = notification.getValue();
                Intrinsics.checkNotNull(value);
                Pair pair3 = (Pair) value;
                List list2 = (List) pair3.component1();
                ChannelSyncAgent.SyncChatsResult syncChatsResult = (ChannelSyncAgent.SyncChatsResult) pair3.component2();
                Pair pair4 = (Pair) notification2.getValue();
                Throwable th = null;
                if (pair4 == null) {
                    pair4 = TuplesKt.to(null, null);
                }
                List<Pair<Channel, DraftEntity>> list3 = (List) pair4.component1();
                ChannelSyncAgent.SyncChatsResult syncChatsResult2 = (ChannelSyncAgent.SyncChatsResult) pair4.component2();
                long longValue = ((Number) OptionKt.getOrElse(syncChatsResult.getOldestSyncedChatTimestamp(), m4.d)).longValue();
                if (syncChatsResult2 == null || (oldestSyncedChatTimestamp = syncChatsResult2.getOldestSyncedChatTimestamp()) == null || (l = (Long) OptionKt.getOrElse(oldestSyncedChatTimestamp, m4.e)) == null) {
                    l = this.b.b.getPinnedListBottomTimestamp();
                }
                Throwable error = notification.getError();
                if (error != null) {
                    th = error;
                } else {
                    Throwable error2 = notification2.getError();
                    if (error2 != null) {
                        MessengerErrorTracker access$getErrorTracker$p = ChannelsListInteractorImpl.access$getErrorTracker$p(ChannelsListInteractorImpl.this);
                        v vVar = new v(error2);
                        Pair[] pairArr = new Pair[2];
                        Pair pair5 = ChannelsListInteractorImpl.this.I;
                        Object obj3 = BuildConfig.ADJUST_DEFAULT_TRACKER;
                        if (pair5 == null || (obj = (SortedSet) pair5.getFirst()) == null) {
                            obj = obj3;
                        }
                        pairArr[0] = TuplesKt.to("includeTags", obj);
                        Pair pair6 = ChannelsListInteractorImpl.this.I;
                        if (!(pair6 == null || (obj2 = (SortedSet) pair6.getSecond()) == null)) {
                            obj3 = obj2;
                        }
                        pairArr[1] = TuplesKt.to("excludeTags", obj3);
                        access$getErrorTracker$p.track(vVar, "Failed to load pinned chats", r.mapOf(pairArr));
                        th = error2;
                    }
                }
                if (th != null) {
                    ChannelsListInteractorImpl.this.D.trackChannelsLoadError();
                    ChannelsListInteractorImpl.this.B.trackEnd(ChatListRefreshResult.ERROR);
                    loading = new ChannelsListInteractor.State.Loading.Error(ThrowablesKt.toAvitoException(th));
                } else {
                    loading = ChannelsListInteractor.State.Loading.Finished.INSTANCE;
                }
                ChannelsListInteractor.State state = this.b.b;
                String str = this.a;
                ChannelsListInteractor.State.Loading.Finished finished = ChannelsListInteractor.State.Loading.Finished.INSTANCE;
                Long valueOf = Long.valueOf(longValue);
                boolean hasMorePages = syncChatsResult.getHasMorePages();
                if (list3 != null) {
                    list = list3;
                } else {
                    list = this.b.b.getPinnedChannelsAndDrafts();
                }
                return ChannelsListInteractor.State.copy$default(state, str, finished, loading, finished, list2, valueOf, hasMorePages, list, l, null, false, 512, null);
            }
            Throwable error3 = notification.getError();
            if (error3 == null) {
                error3 = notification2.getError();
            }
            if (error3 == null) {
                error3 = new UnknownError();
            }
            ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1 channelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1 = this.b;
            return ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator.access$handleError(channelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1.a, error3, channelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1.b);
        }
    }

    public ChannelsListInteractorImpl$RefreshComposite$RefreshChannelsMutator$invoke$$inlined$withUserId$1(ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator refreshChannelsMutator, ChannelsListInteractor.State state) {
        this.a = refreshChannelsMutator;
        this.b = state;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Option<? extends String> option) {
        return apply((Option<String>) option);
    }

    public final SingleSource<? extends R> apply(@NotNull Option<String> option) {
        Single single;
        Single single2;
        Intrinsics.checkNotNullParameter(option, "userIdOption");
        if (option instanceof None) {
            throw new UnauthorizedException();
        } else if (option instanceof Some) {
            String str = (String) ((Some) option).getT();
            ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator refreshChannelsMutator = this.a;
            if (ChannelsListInteractorImpl.this.u.getMessengerPinSupportChat().invoke().booleanValue()) {
                Single access$refreshChatsInSpecificList = ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator.access$refreshChatsInSpecificList(refreshChannelsMutator, str, ChannelsListInteractorImpl.this.H);
                if (ChannelsListInteractorImpl.this.I != null) {
                    single2 = ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator.access$refreshChatsInSpecificList(refreshChannelsMutator, str, ChannelsListInteractorImpl.this.I);
                } else {
                    single2 = Singles.toSingle(Notification.createOnComplete());
                }
                single = SinglesKt.zipWith(access$refreshChatsInSpecificList, single2);
            } else {
                single = SinglesKt.zipWith(ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator.access$refreshChatsInSpecificList(refreshChannelsMutator, str, ChannelsListInteractorImpl.this.J), Singles.toSingle(Notification.createOnComplete()));
            }
            Single<R> map = single.map(new a(str, this));
            Intrinsics.checkNotNullExpressionValue(map, "refreshChats(userId)\n   …                        }");
            return map;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
