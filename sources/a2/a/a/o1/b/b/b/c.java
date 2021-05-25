package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.DraftEntity;
public final class c<T, R> implements Function<List<? extends Pair<? extends Channel, ? extends DraftEntity>>, Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult>> {
    public final /* synthetic */ ChannelSyncAgent.SyncChatsResult a;

    public c(ChannelSyncAgent.SyncChatsResult syncChatsResult) {
        this.a = syncChatsResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends ChannelSyncAgent.SyncChatsResult> apply(List<? extends Pair<? extends Channel, ? extends DraftEntity>> list) {
        List<? extends Pair<? extends Channel, ? extends DraftEntity>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "channelsAndDrafts");
        return TuplesKt.to(list2, this.a);
    }
}
