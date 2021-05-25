package ru.avito.messenger.internal.connection;

import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
import ru.avito.messenger.internal.state_machine.StateMachine;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0006*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00050\u0005 \u0006* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0006*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lru/avito/messenger/MessengerApi;", "T", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "state", "Lio/reactivex/MaybeSource;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "kotlin.jvm.PlatformType", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/MaybeSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessengerConnectionHolderImpl$sendManualPingsWhenConnected$1<T, R> implements Function<MessengerConnectionHolder.State, MaybeSource<? extends StateMachine.Mutator<MessengerConnectionHolder.State>>> {
    public final /* synthetic */ MessengerConnectionHolderImpl a;
    public final /* synthetic */ long b;

    public MessengerConnectionHolderImpl$sendManualPingsWhenConnected$1(MessengerConnectionHolderImpl messengerConnectionHolderImpl, long j) {
        this.a = messengerConnectionHolderImpl;
        this.b = j;
    }

    public final MaybeSource<? extends StateMachine.Mutator<MessengerConnectionHolder.State>> apply(@NotNull MessengerConnectionHolder.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(state instanceof MessengerConnectionHolder.State.Connected)) {
            return Maybe.empty();
        }
        long j = this.b;
        return Observable.interval(j, j, TimeUnit.MILLISECONDS, this.a.i.computation()).switchMapCompletable(new Function<Long, CompletableSource>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$sendManualPingsWhenConnected$1.1
            public final /* synthetic */ MessengerConnectionHolderImpl$sendManualPingsWhenConnected$1 a;

            {
                this.a = r1;
            }

            public final CompletableSource apply(@NotNull Long l) {
                Intrinsics.checkNotNullParameter(l, "it");
                return this.a.a.e.sendPing().subscribeOn(this.a.a.i.io()).ignoreElement();
            }
        }).toMaybe().onErrorReturn(new Function<Throwable, StateMachine.Mutator<MessengerConnectionHolder.State>>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$sendManualPingsWhenConnected$1.2
            public final /* synthetic */ MessengerConnectionHolderImpl$sendManualPingsWhenConnected$1 a;

            {
                this.a = r1;
            }

            public final StateMachine.Mutator<MessengerConnectionHolder.State> apply(@NotNull Throwable th) {
                Intrinsics.checkNotNullParameter(th, "error");
                this.a.a.h.e("ConnectionHolder", "Ping failed. Reconnect scheduled.", th);
                return new MessengerConnectionHolderImpl.DisconnectMutator(true);
            }
        });
    }
}
