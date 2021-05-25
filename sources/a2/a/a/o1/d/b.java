package a2.a.a.o1.d;

import a2.b.a.a.a;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<ChannelReplySuggestsView.State> {
    public final /* synthetic */ ChannelFragment a;

    public b(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ChannelReplySuggestsView.State state) {
        ChannelReplySuggestsView.State state2 = state;
        ChannelReplySuggestsView access$getChannelReplySuggestsView$p = ChannelFragment.access$getChannelReplySuggestsView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(state2, "state");
        access$getChannelReplySuggestsView$p.render(state2);
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" Rendered ");
        sb.append(state2);
        Logs.info$default("ChannelFragment", sb.toString(), null, 4, null);
    }
}
