package a2.a.a.o1.b.b.b;

import arrow.core.OptionKt;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.DraftEntity;
public final class a<T, R> implements Function<List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ChannelsListInteractor.State> {
    public final /* synthetic */ ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1.a a;
    public final /* synthetic */ ChannelSyncAgent.SyncChatsResult b;

    public a(ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1.a aVar, ChannelSyncAgent.SyncChatsResult syncChatsResult) {
        this.a = aVar;
        this.b = syncChatsResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ChannelsListInteractor.State apply(List<? extends Pair<? extends Channel, ? extends DraftEntity>> list) {
        List<? extends Pair<? extends Channel, ? extends DraftEntity>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "channelsAndDrafts");
        ChannelsListInteractorImpl$NextPageRequestComposite$SyncNextPageMutator$invoke$$inlined$withUserId$1.a aVar = this.a;
        return ChannelsListInteractor.State.copy$default(aVar.b.b, aVar.a, null, null, ChannelsListInteractor.State.Loading.Finished.INSTANCE, list2, (Long) OptionKt.getOrElse(this.b.getOldestSyncedChatTimestamp(), m4.c), this.b.getHasMorePages(), null, null, null, false, 1926, null);
    }
}
