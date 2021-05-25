package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class g<T> implements Consumer<Unit> {
    public final /* synthetic */ ChannelFragment a;

    public g(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.getLegacyPlatformActionsPresenter().onBottomSheetOpened();
    }
}
