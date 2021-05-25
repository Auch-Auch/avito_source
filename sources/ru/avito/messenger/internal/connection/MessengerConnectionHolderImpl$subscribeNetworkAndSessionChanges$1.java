package ru.avito.messenger.internal.connection;

import a7.a.b.a.m.i;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
import ru.avito.messenger.internal.state_machine.StateMachine;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0005 \u0007* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lru/avito/messenger/MessengerApi;", "T", "La7/a/b/a/m/i;", "<name for destructuring parameter 0>", "Lio/reactivex/ObservableSource;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "kotlin.jvm.PlatformType", "apply", "(La7/a/b/a/m/i;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1<T, R> implements Function<i, ObservableSource<? extends StateMachine.Mutator<MessengerConnectionHolder.State>>> {
    public final /* synthetic */ MessengerConnectionHolderImpl a;

    public MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1(MessengerConnectionHolderImpl messengerConnectionHolderImpl) {
        this.a = messengerConnectionHolderImpl;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: io.reactivex.Observable */
    /* JADX WARN: Multi-variable type inference failed */
    public final ObservableSource<? extends StateMachine.Mutator<MessengerConnectionHolder.State>> apply(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<name for destructuring parameter 0>");
        boolean z = iVar.a;
        final String str = iVar.b;
        boolean z2 = iVar.c;
        if (z) {
            if ((str.length() > 0) && z2) {
                return MessengerConnectionHolderImpl.access$reconnectSequence(this.a, str).startWith((Observable) new MessengerConnectionHolderImpl.CanConnectChangedMutator(true, new Function0<Unit>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1.1
                    public final /* synthetic */ MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1 a;

                    {
                        this.a = r1;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final void invoke() {
                        MessengerConnectionHolderImpl messengerConnectionHolderImpl = this.a.a;
                        messengerConnectionHolderImpl.c.enqueue(new MessengerConnectionHolderImpl.PerformConnectMutator(messengerConnectionHolderImpl, str, false));
                    }
                }, new Function0<Unit>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1.2
                    public final /* synthetic */ MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1 a;

                    {
                        this.a = r1;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final void invoke() {
                        this.a.a.c.enqueue(new MessengerConnectionHolderImpl.DisconnectMutator(true));
                    }
                }));
            }
        }
        return Observable.just(new MessengerConnectionHolderImpl.CanConnectChangedMutator(false, new Function0<Unit>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1.3
            public final /* synthetic */ MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1 a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                MessengerConnectionHolderImpl messengerConnectionHolderImpl = this.a.a;
                messengerConnectionHolderImpl.c.enqueue(new MessengerConnectionHolderImpl.PerformConnectMutator(messengerConnectionHolderImpl, str, false));
            }
        }, new Function0<Unit>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1.4
            public final /* synthetic */ MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1 a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                this.a.a.c.enqueue(new MessengerConnectionHolderImpl.DisconnectMutator(true));
            }
        }));
    }
}
