package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import io.reactivex.functions.Action;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
public final class e implements Action {
    public final /* synthetic */ ChannelsListInteractorImpl a;
    public final /* synthetic */ ChatTypingEvent b;

    public e(ChannelsListInteractorImpl channelsListInteractorImpl, ChatTypingEvent chatTypingEvent) {
        this.a = channelsListInteractorImpl;
        this.b = chatTypingEvent;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.getReducerQueue().plusAssign(new ChannelsListInteractorImpl.ChatTypingStartMutator(this.a, this.b));
    }
}
