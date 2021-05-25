package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractorImpl;
import java.util.concurrent.Callable;
import kotlin.Unit;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
public final class f<V> implements Callable<Unit> {
    public final /* synthetic */ ChannelsListInteractorImpl a;
    public final /* synthetic */ ChatTypingEvent b;

    public f(ChannelsListInteractorImpl channelsListInteractorImpl, ChatTypingEvent chatTypingEvent) {
        this.a = channelsListInteractorImpl;
        this.b = chatTypingEvent;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Unit call() {
        this.a.getReducerQueue().plusAssign(new ChannelsListInteractorImpl.ChatTypingStopMutator(this.a, this.b));
        return Unit.INSTANCE;
    }
}
