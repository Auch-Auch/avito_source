package com.avito.android.messenger.channels.mvi.interactor;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.util.Logs;
import com.avito.android.util.Maybies;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "R", "Larrow/core/Option;", "it", "Lio/reactivex/MaybeSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/MaybeSource;", "com/avito/android/util/Singles$flatMapMaybeFold$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$getChatsFromDbForSpecificList$$inlined$flatMapMaybeFold$1<T, R> implements Function<Option<? extends T>, MaybeSource<? extends R>> {
    public final /* synthetic */ ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Pair d;

    public static final class a<T, R> implements Function<List<? extends Pair<? extends Channel, ? extends DraftEntity>>, MaybeSource<? extends Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>>> {
        public final /* synthetic */ long a;

        public a(long j) {
            this.a = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MaybeSource<? extends Pair<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>, ? extends Long>> apply(List<? extends Pair<? extends Channel, ? extends DraftEntity>> list) {
            List<? extends Pair<? extends Channel, ? extends DraftEntity>> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "channelsAndDrafts");
            return Maybies.toMaybe(TuplesKt.to(list2, Long.valueOf(this.a)));
        }
    }

    public ChannelsListInteractorImpl$InitialDataRequestComposite$TryToGetChatsFromDbMutator$getChatsFromDbForSpecificList$$inlined$flatMapMaybeFold$1(ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator, String str, ChannelsListInteractorImpl.InitialDataRequestComposite.TryToGetChatsFromDbMutator tryToGetChatsFromDbMutator2, String str2, Pair pair) {
        this.a = tryToGetChatsFromDbMutator;
        this.b = str;
        this.c = str2;
        this.d = pair;
    }

    public final MaybeSource<? extends R> apply(@NotNull Option<? extends T> option) {
        Intrinsics.checkNotNullParameter(option, "it");
        if (option instanceof None) {
            String tag = ChannelsListInteractorImpl.this.getTAG();
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(' ');
            sb.append(this.a);
            sb.append(": ");
            Logs.verbose$default(tag, a2.b.a.a.a.t(sb, this.b, " chats timestamp from DB is empty => do nothing"), null, 4, null);
            Maybe empty = Maybe.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Maybe.empty()");
            return empty;
        } else if (option instanceof Some) {
            long longValue = ((Number) ((Some) option).getT()).longValue();
            Maybe<R> flatMapMaybe = ChannelsListInteractorImpl.this.y.getChannelsAndDraftsStartingFromTimestamp(this.c, longValue, (SortedSet) this.d.getFirst(), (SortedSet) this.d.getSecond()).observeOn(ChannelsListInteractorImpl.this.getSchedulerForReducibles()).firstOrError().flatMapMaybe(new a(longValue));
            Intrinsics.checkNotNullExpressionValue(flatMapMaybe, "channelRepoReader.getCha…                        }");
            return flatMapMaybe;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Option) ((Option) obj));
    }
}
