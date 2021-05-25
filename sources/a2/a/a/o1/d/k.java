package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelItem;
import io.reactivex.functions.BiPredicate;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class k<T1, T2> implements BiPredicate<Pair<? extends ChannelItem, ? extends ChannelItem>, Pair<? extends ChannelItem, ? extends ChannelItem>> {
    public static final k a = new k();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiPredicate
    public boolean test(Pair<? extends ChannelItem, ? extends ChannelItem> pair, Pair<? extends ChannelItem, ? extends ChannelItem> pair2) {
        Pair<? extends ChannelItem, ? extends ChannelItem> pair3 = pair;
        Pair<? extends ChannelItem, ? extends ChannelItem> pair4 = pair2;
        Intrinsics.checkNotNullParameter(pair3, "<name for destructuring parameter 0>");
        Intrinsics.checkNotNullParameter(pair4, "<name for destructuring parameter 1>");
        ChannelItem channelItem = (ChannelItem) pair3.component1();
        ChannelItem channelItem2 = (ChannelItem) pair3.component2();
        ChannelItem channelItem3 = (ChannelItem) pair4.component1();
        ChannelItem channelItem4 = (ChannelItem) pair4.component2();
        Long l = null;
        if (Intrinsics.areEqual(channelItem != null ? Long.valueOf(channelItem.getId()) : null, channelItem3 != null ? Long.valueOf(channelItem3.getId()) : null)) {
            Long valueOf = channelItem2 != null ? Long.valueOf(channelItem2.getId()) : null;
            if (channelItem4 != null) {
                l = Long.valueOf(channelItem4.getId());
            }
            if (Intrinsics.areEqual(valueOf, l)) {
                return true;
            }
        }
        return false;
    }
}
