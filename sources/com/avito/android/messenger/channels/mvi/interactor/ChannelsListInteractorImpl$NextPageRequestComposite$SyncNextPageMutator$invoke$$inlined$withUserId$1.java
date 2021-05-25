package com.avito.android.messenger.channels.mvi.interactor;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.Some;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"R", "Larrow/core/Option;", "", "userIdOption", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/SingleSource;", "com/avito/android/messenger/channels/mvi/interactor/ChannelsListInteractorImpl$withUserId$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1<T, R> implements Function<Option<? extends String>, SingleSource<? extends R>> {
    public final /* synthetic */ ChannelsListInteractorImpl.NextPageRequestComposite.SyncNextPageMutator a;
    public final /* synthetic */ ChannelsListInteractor.State b;
    public final /* synthetic */ Pair c;

    public static final class a<T, R> implements Function<ChannelSyncAgent.SyncChatsResult, SingleSource<? extends ChannelsListInteractor.State>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1 b;

        public a(String str, ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1 channelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1) {
            this.a = str;
            this.b = channelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChannelsListInteractor.State> apply(ChannelSyncAgent.SyncChatsResult syncChatsResult) {
            ChannelSyncAgent.SyncChatsResult syncChatsResult2 = syncChatsResult;
            Intrinsics.checkNotNullParameter(syncChatsResult2, "syncResult");
            return ChannelsListInteractorImpl.access$getChannelRepoReader$p(ChannelsListInteractorImpl.this).getChannelsAndDraftsStartingFromTimestamp(this.a, ((Number) OptionKt.getOrElse(syncChatsResult2.getOldestSyncedChatTimestamp(), m4.b)).longValue(), (SortedSet) this.b.c.getFirst(), (SortedSet) this.b.c.getSecond()).firstOrError().observeOn(ChannelsListInteractorImpl.access$getSchedulerForReducibles$p(ChannelsListInteractorImpl.this)).map(new a2.a.a.o1.b.b.b.a(this, syncChatsResult2));
        }
    }

    public ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1(ChannelsListInteractorImpl.NextPageRequestComposite.SyncNextPageMutator syncNextPageMutator, ChannelsListInteractor.State state, Pair pair) {
        this.a = syncNextPageMutator;
        this.b = state;
        this.c = pair;
    }

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
            String str = (String) ((Some) option).getT();
            ChannelSyncAgent access$getChannelSyncAgent$p = ChannelsListInteractorImpl.access$getChannelSyncAgent$p(ChannelsListInteractorImpl.this);
            List<Pair<Channel, DraftEntity>> mainChannelsAndDrafts = this.b.getMainChannelsAndDrafts();
            int i = 0;
            if (!(mainChannelsAndDrafts instanceof Collection) || !mainChannelsAndDrafts.isEmpty()) {
                Iterator<T> it = mainChannelsAndDrafts.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    LocalMessage lastMessage = ((Channel) it.next().component1()).getLastMessage();
                    String str2 = lastMessage != null ? lastMessage.remoteId : null;
                    if ((!(str2 == null || m.isBlank(str2))) && (i2 = i2 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
                i = i2;
            }
            Single<R> flatMap = access$getChannelSyncAgent$p.syncNextPage(str, i, (SortedSet) this.c.getFirst(), (SortedSet) this.c.getSecond()).flatMap(new a(str, this));
            Intrinsics.checkNotNullExpressionValue(flatMap, "channelSyncAgent.syncNex…                        }");
            return flatMap;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
