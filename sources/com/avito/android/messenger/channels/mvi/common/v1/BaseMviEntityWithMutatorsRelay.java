package com.avito.android.messenger.channels.mvi.common.v1;

import a2.b.a.a.a;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0019\u001a\u00028\u0000\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJV\u0010\u000e\u001aI\u0012E\u0012C\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000b\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\r0\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u0011\u001a\u00020\u0010*C\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000b\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\rH\b¢\u0006\u0004\b\u0011\u0010\u0012Rc\u0010\u0018\u001aI\u0012E\u0012C\u0012/\u0012-\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000b\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\r0\u00138\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v1/BaseMviEntityWithMutatorsRelay;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/v1/BaseMviEntity;", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "oldState", "Lio/reactivex/Single;", "Lcom/avito/android/messenger/channels/mvi/common/v1/MutatorSingle;", "", "Lcom/avito/android/messenger/channels/mvi/common/v1/NamedMutatorSingle;", "mutatorsObservable", "()Lio/reactivex/Observable;", "", "sendToMutatorsRelay", "(Lkotlin/Pair;)V", "Lcom/jakewharton/rxrelay2/Relay;", "i", "Lcom/jakewharton/rxrelay2/Relay;", "getMutatorsRelay", "()Lcom/jakewharton/rxrelay2/Relay;", "mutatorsRelay", "defaultState", "Lio/reactivex/Scheduler;", "schedulerForMutators", "<init>", "(Ljava/lang/Object;Lio/reactivex/Scheduler;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntityWithMutatorsRelay<StateT> extends BaseMviEntity<StateT> {
    @NotNull
    public final Relay<Pair<Function1<StateT, Single<StateT>>, String>> i = a.J1("PublishRelay.create<T>().toSerialized()");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMviEntityWithMutatorsRelay(@NotNull StateT statet, @NotNull Scheduler scheduler) {
        super(statet, scheduler);
        Intrinsics.checkNotNullParameter(statet, "defaultState");
        Intrinsics.checkNotNullParameter(scheduler, "schedulerForMutators");
        initialize();
    }

    @NotNull
    public final Relay<Pair<Function1<StateT, Single<StateT>>, String>> getMutatorsRelay() {
        return this.i;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v1.BaseMviEntity
    @NotNull
    public Observable<Pair<Function1<StateT, Single<StateT>>, String>> mutatorsObservable() {
        return this.i;
    }

    public final void sendToMutatorsRelay(@NotNull Pair<? extends Function1<? super StateT, ? extends Single<StateT>>, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$sendToMutatorsRelay");
        this.i.accept(pair);
    }
}
