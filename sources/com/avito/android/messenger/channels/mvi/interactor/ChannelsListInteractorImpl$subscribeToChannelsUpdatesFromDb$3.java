package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.DraftEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u000626\u0010\u0005\u001a2\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001 \u0004*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/android/persistence/messenger/DraftEntity;", "kotlin.jvm.PlatformType", "newChannelsAndDrafts", "", "accept", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$3<T> implements Consumer<List<? extends Pair<? extends Channel, ? extends DraftEntity>>> {
    public final /* synthetic */ ChannelsListInteractorImpl a;

    public ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$3(ChannelsListInteractorImpl channelsListInteractorImpl) {
        this.a = channelsListInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends Pair<? extends Channel, ? extends DraftEntity>> list) {
        accept((List<Pair<Channel, DraftEntity>>) list);
    }

    public final void accept(List<Pair<Channel, DraftEntity>> list) {
        ReducerQueue reducerQueue = this.a.getReducerQueue();
        ChannelsListInteractorImpl channelsListInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list, "newChannelsAndDrafts");
        reducerQueue.plusAssign(new ChannelsListInteractorImpl.NewMainChannelsAndDraftsFromDbMutator(channelsListInteractorImpl, list));
    }
}
