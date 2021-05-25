package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import io.reactivex.functions.Consumer;
public final class t<T> implements Consumer<PlatformActionsCoordinator.CoordinatorState> {
    public final /* synthetic */ ChannelFragment a;

    public t(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(PlatformActionsCoordinator.CoordinatorState coordinatorState) {
        ChannelFragment.access$getSamplePlatformActionsView$p(this.a).bind(coordinatorState.getStateProducersByKey());
    }
}
