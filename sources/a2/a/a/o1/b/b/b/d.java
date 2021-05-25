package a2.a.a.o1.b.b.b;

import arrow.core.OptionKt;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.SortedSet;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.DraftEntity;
public final class d<T, R> implements Function<ChannelSyncAgent.SyncChatsResult, SingleSource<? extends Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>>> {
    public final /* synthetic */ ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Pair c;

    public d(ChannelsListInteractorImpl.RefreshComposite.RefreshChannelsMutator refreshChannelsMutator, String str, Pair pair) {
        this.a = refreshChannelsMutator;
        this.b = str;
        this.c = pair;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>> apply(ChannelSyncAgent.SyncChatsResult syncChatsResult) {
        ChannelSyncAgent.SyncChatsResult syncChatsResult2 = syncChatsResult;
        Intrinsics.checkNotNullParameter(syncChatsResult2, "syncResult");
        return ChannelsListInteractorImpl.this.y.getChannelsAndDraftsStartingFromTimestamp(this.b, ((Number) OptionKt.getOrElse(syncChatsResult2.getOldestSyncedChatTimestamp(), b.a)).longValue(), (SortedSet) this.c.getFirst(), (SortedSet) this.c.getSecond()).observeOn(ChannelsListInteractorImpl.this.getSchedulerForReducibles()).firstOrError().map(new c(syncChatsResult2));
    }
}
