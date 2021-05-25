package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<LegacyPlatformActionsPresenter.State> {
    public final /* synthetic */ ChannelFragment a;

    public f(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LegacyPlatformActionsPresenter.State state) {
        LegacyPlatformActionsPresenter.State state2 = state;
        LegacyPlatformActionsView access$getLegacyPlatformActionsView$p = ChannelFragment.access$getLegacyPlatformActionsView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(state2, "state");
        access$getLegacyPlatformActionsView$p.render(state2);
        Logs.verbose$default("ChannelFragment", "Rendered state: " + state2, null, 4, null);
    }
}
