package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "kotlin.jvm.PlatformType", "it", "", "accept", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$updateStateAndScheduleRefresh$1<T> implements Consumer<ChannelContextInteractor.State> {
    public final /* synthetic */ ChannelContextInteractorImpl.InitialDataRequestComposite.GetChannelMutator a;

    public ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$updateStateAndScheduleRefresh$1(ChannelContextInteractorImpl.InitialDataRequestComposite.GetChannelMutator getChannelMutator) {
        this.a = getChannelMutator;
    }

    public final void accept(ChannelContextInteractor.State state) {
        ChannelContextInteractorImpl.this.refresh();
    }
}
