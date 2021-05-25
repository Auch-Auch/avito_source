package ru.avito.messenger.internal.connection;

import a7.a.b.a.m.i;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0014\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lru/avito/messenger/MessengerApi;", "T", "La7/a/b/a/m/i;", "<name for destructuring parameter 0>", "Lio/reactivex/ObservableSource;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$StateWatchDogMutator;", "kotlin.jvm.PlatformType", "apply", "(La7/a/b/a/m/i;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessengerConnectionHolderImpl$monitorStateFreeze$1<T, R> implements Function<i, ObservableSource<? extends MessengerConnectionHolderImpl.StateWatchDogMutator>> {
    public final /* synthetic */ MessengerConnectionHolderImpl a;

    public MessengerConnectionHolderImpl$monitorStateFreeze$1(MessengerConnectionHolderImpl messengerConnectionHolderImpl) {
        this.a = messengerConnectionHolderImpl;
    }

    public final ObservableSource<? extends MessengerConnectionHolderImpl.StateWatchDogMutator> apply(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<name for destructuring parameter 0>");
        boolean z = iVar.a;
        final String str = iVar.b;
        boolean z2 = iVar.c;
        if (z) {
            if ((str.length() > 0) && z2) {
                return this.a.getStateObservable().distinctUntilChanged().switchMapMaybe(new Function<MessengerConnectionHolder.State, MaybeSource<? extends MessengerConnectionHolderImpl.StateWatchDogMutator>>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$monitorStateFreeze$1.1
                    public final /* synthetic */ MessengerConnectionHolderImpl$monitorStateFreeze$1 a;

                    {
                        this.a = r1;
                    }

                    public final MaybeSource<? extends MessengerConnectionHolderImpl.StateWatchDogMutator> apply(@NotNull final MessengerConnectionHolder.State state) {
                        Intrinsics.checkNotNullParameter(state, "originalState");
                        if (state instanceof MessengerConnectionHolder.State.Connecting) {
                            return Maybe.timer(15, TimeUnit.SECONDS, this.a.a.i.computation()).map(new Function<Long, MessengerConnectionHolderImpl.StateWatchDogMutator>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl.monitorStateFreeze.1.1.1
                                public final /* synthetic */ AnonymousClass1 a;

                                {
                                    this.a = r1;
                                }

                                public final MessengerConnectionHolderImpl.StateWatchDogMutator apply(@NotNull Long l) {
                                    Intrinsics.checkNotNullParameter(l, "it");
                                    MessengerConnectionHolder.State state2 = state;
                                    Intrinsics.checkNotNullExpressionValue(state2, "originalState");
                                    return new MessengerConnectionHolderImpl.StateWatchDogMutator(state2, new Function0<Unit>(this) { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl.monitorStateFreeze.1.1.1.1
                                        public final /* synthetic */ AnonymousClass1 a;

                                        {
                                            this.a = r1;
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final void invoke() {
                                            AnonymousClass1 r0 = this.a.a;
                                            MessengerConnectionHolderImpl messengerConnectionHolderImpl = r0.a.a;
                                            messengerConnectionHolderImpl.c.enqueue(new MessengerConnectionHolderImpl.PerformConnectMutator(messengerConnectionHolderImpl, str, true));
                                        }
                                    });
                                }
                            });
                        }
                        return Maybe.empty();
                    }
                });
            }
        }
        return Observable.empty();
    }
}
