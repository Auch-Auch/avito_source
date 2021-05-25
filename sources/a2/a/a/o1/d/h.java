package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<MessageMenuPresenter.State> {
    public final /* synthetic */ ChannelFragment a;

    public h(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(MessageMenuPresenter.State state) {
        MessageMenuPresenter.State state2 = state;
        MessageMenuView access$getMessageMenuView$p = ChannelFragment.access$getMessageMenuView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(state2, "state");
        access$getMessageMenuView$p.render(state2);
    }
}
