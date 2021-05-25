package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.ChannelItem;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
public final class l<T> implements Consumer<Pair<? extends ChannelItem, ? extends ChannelItem>> {
    public final /* synthetic */ ChannelFragment a;

    public l(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Pair<? extends ChannelItem, ? extends ChannelItem> pair) {
        Pair<? extends ChannelItem, ? extends ChannelItem> pair2 = pair;
        ChannelItem channelItem = (ChannelItem) pair2.component1();
        ChannelItem channelItem2 = (ChannelItem) pair2.component2();
        if (channelItem != null && channelItem2 != null) {
            this.a.getNewMessagesPresenter().onNewListItems(channelItem, channelItem2);
        }
    }
}
