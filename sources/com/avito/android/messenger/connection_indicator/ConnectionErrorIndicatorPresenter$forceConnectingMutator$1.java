package com.avito.android.messenger.connection_indicator;

import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "it", "invoke", "(Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;)Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ConnectionErrorIndicatorPresenter$forceConnectingMutator$1 extends Lambda implements Function1<ConnectionErrorIndicatorView.State, ConnectionErrorIndicatorView.State> {
    public final /* synthetic */ ConnectionErrorIndicatorPresenter a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionErrorIndicatorPresenter$forceConnectingMutator$1(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
        super(1);
        this.a = connectionErrorIndicatorPresenter;
    }

    @NotNull
    public final ConnectionErrorIndicatorView.State invoke(@NotNull ConnectionErrorIndicatorView.State state) {
        Intrinsics.checkNotNullParameter(state, "it");
        ConnectionErrorIndicatorPresenter.access$getMutatorsRelay$p(this.a).accept(new MutatorSingle("PerformReconnectMutator", new ConnectionErrorIndicatorPresenter$performReconnectMutator$1(this.a)));
        return ConnectionErrorIndicatorPresenter.access$getConnectingState$p(this.a);
    }
}
