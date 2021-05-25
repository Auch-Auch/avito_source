package com.avito.android.messenger.channels.mvi.view;

import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListFragment$inject$4$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ChannelsListPresenter a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsListFragment$inject$4$1(ChannelsListPresenter channelsListPresenter) {
        super(0);
        this.a = channelsListPresenter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.a.hideAdBanner();
    }
}
