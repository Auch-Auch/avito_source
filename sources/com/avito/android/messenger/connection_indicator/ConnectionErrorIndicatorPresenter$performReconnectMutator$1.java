package com.avito.android.messenger.connection_indicator;

import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "it", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;)Lio/reactivex/Single;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ConnectionErrorIndicatorPresenter$performReconnectMutator$1 extends Lambda implements Function1<ConnectionErrorIndicatorView.State, Single<ConnectionErrorIndicatorView.State>> {
    public final /* synthetic */ ConnectionErrorIndicatorPresenter a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionErrorIndicatorPresenter$performReconnectMutator$1(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
        super(1);
        this.a = connectionErrorIndicatorPresenter;
    }

    @NotNull
    public final Single<ConnectionErrorIndicatorView.State> invoke(@NotNull ConnectionErrorIndicatorView.State state) {
        Intrinsics.checkNotNullParameter(state, "it");
        Completable connect = ConnectionErrorIndicatorPresenter.access$getConnection$p(this.a).connect(true);
        ConnectionErrorIndicatorView.State.Hidden hidden = ConnectionErrorIndicatorView.State.Hidden.INSTANCE;
        Objects.requireNonNull(hidden, "null cannot be cast to non-null type com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView.State");
        Single<ConnectionErrorIndicatorView.State> onErrorReturn = connect.toSingleDefault(hidden).onErrorReturn(new Function<Throwable, ConnectionErrorIndicatorView.State>(this) { // from class: com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorPresenter$performReconnectMutator$1.1
            public final /* synthetic */ ConnectionErrorIndicatorPresenter$performReconnectMutator$1 a;

            {
                this.a = r1;
            }

            public final ConnectionErrorIndicatorView.State apply(@NotNull Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                return ConnectionErrorIndicatorPresenter.access$getDisconnectedState$p(this.a.a);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "connection.connect(force…urn { disconnectedState }");
        return onErrorReturn;
    }
}
