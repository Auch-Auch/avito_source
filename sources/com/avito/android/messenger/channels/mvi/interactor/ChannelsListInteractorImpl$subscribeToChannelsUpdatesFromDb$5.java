package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\f\u001az\u00126\b\u0001\u00122\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0000 \t*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0000\u0018\u00010\u00060\u0006 \t*<\u00126\b\u0001\u00122\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0000 \t*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0000\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\u001c\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0000H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/Pair;", "", "", "Lcom/avito/android/messenger/channels/mvi/sync/Timestamp;", "<name for destructuring parameter 0>", "Lio/reactivex/ObservableSource;", "", "Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/android/persistence/messenger/DraftEntity;", "kotlin.jvm.PlatformType", "apply", "(Lkotlin/Pair;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$5<T, R> implements Function<Pair<? extends String, ? extends Long>, ObservableSource<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>>> {
    public final /* synthetic */ ChannelsListInteractorImpl a;

    public ChannelsListInteractorImpl$subscribeToChannelsUpdatesFromDb$5(ChannelsListInteractorImpl channelsListInteractorImpl) {
        this.a = channelsListInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ ObservableSource<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>> apply(Pair<? extends String, ? extends Long> pair) {
        return apply((Pair<String, Long>) pair);
    }

    public final ObservableSource<? extends List<Pair<Channel, DraftEntity>>> apply(@NotNull Pair<String, Long> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        String component1 = pair.component1();
        Long component2 = pair.component2();
        if ((component1 == null || m.isBlank(component1)) || component2 == null) {
            return Observable.empty();
        }
        return this.a.y.getChannelsAndDraftsStartingFromTimestamp(component1, component2.longValue(), (SortedSet) this.a.I.getFirst(), (SortedSet) this.a.I.getSecond());
    }
}
