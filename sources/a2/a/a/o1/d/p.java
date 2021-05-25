package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
public final class p<T> implements Consumer<Set<? extends Object>> {
    public final /* synthetic */ ChannelFragment a;

    public p(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Set<? extends Object> set) {
        Set<? extends Object> set2 = set;
        PlatformActionsCoordinator platformActionsCoordinator = this.a.getPlatformActionsCoordinator();
        Object consumerKey = ChannelFragment.access$getSamplePlatformActionsView$p(this.a).getConsumerKey();
        Intrinsics.checkNotNullExpressionValue(set2, "consumedStateKeys");
        platformActionsCoordinator.consumerUnbound(consumerKey, set2);
    }
}
