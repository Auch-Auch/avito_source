package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class q<T> implements Consumer<PlatformActionsState> {
    public final /* synthetic */ ChannelFragment a;

    public q(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(PlatformActionsState platformActionsState) {
        PlatformActionsState platformActionsState2 = platformActionsState;
        PlatformActionsCoordinator platformActionsCoordinator = this.a.getPlatformActionsCoordinator();
        Object consumerKey = ChannelFragment.access$getSamplePlatformActionsView$p(this.a).getConsumerKey();
        Intrinsics.checkNotNullExpressionValue(platformActionsState2, "state");
        platformActionsCoordinator.stateConsumed(consumerKey, platformActionsState2);
    }
}
