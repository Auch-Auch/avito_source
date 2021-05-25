package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelItem;
import io.reactivex.functions.Predicate;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Predicate<Pair<? extends ChannelItem, ? extends ChannelItem>> {
    public static final j a = new j();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Pair<? extends ChannelItem, ? extends ChannelItem> pair) {
        Pair<? extends ChannelItem, ? extends ChannelItem> pair2 = pair;
        Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
        ChannelItem channelItem = (ChannelItem) pair2.component1();
        ChannelItem channelItem2 = (ChannelItem) pair2.component2();
        return (channelItem == null || channelItem2 == null || channelItem.getId() == channelItem2.getId()) ? false : true;
    }
}
