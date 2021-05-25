package com.avito.android.messenger.connection_indicator;

import android.view.View;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorPresenter;
import com.jakewharton.rxrelay2.Relay;
public final class ConnectionErrorIndicatorPresenter$disconnectedState$2$1 implements View.OnClickListener {
    public final /* synthetic */ ConnectionErrorIndicatorPresenter.b a;

    public ConnectionErrorIndicatorPresenter$disconnectedState$2$1(ConnectionErrorIndicatorPresenter.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Relay access$getMutatorsRelay$p = ConnectionErrorIndicatorPresenter.access$getMutatorsRelay$p(this.a.a);
        Mutator mutator = new Mutator("ForceConnectingMutator", new ConnectionErrorIndicatorPresenter$forceConnectingMutator$1(this.a.a));
        access$getMutatorsRelay$p.accept(new MutatorSingle(mutator.getName(), new ConnectionErrorIndicatorPresenter$disconnectedState$2$1$$special$$inlined$plusAssign$1(mutator)));
    }
}
