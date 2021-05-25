package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class o<T> implements Consumer<Map<Object, ? extends PlatformActionsState>> {
    public final /* synthetic */ ChannelFragment a;

    public o(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Map<Object, ? extends PlatformActionsState> map) {
        Map<Object, ? extends PlatformActionsState> map2 = map;
        PlatformActionsCoordinator platformActionsCoordinator = this.a.getPlatformActionsCoordinator();
        Object consumerKey = ChannelFragment.access$getSamplePlatformActionsView$p(this.a).getConsumerKey();
        Intrinsics.checkNotNullExpressionValue(map2, "previouslyConsumedStatesByKey");
        platformActionsCoordinator.consumerBound(consumerKey, map2);
    }
}
