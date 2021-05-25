package a2.a.a.o1.d.a0.a;

import com.avito.android.messenger.conversation.chat_header.ChatHeader;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextViewImpl;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Boolean> {
    public final /* synthetic */ ChannelContextViewImpl a;

    public c(ChannelContextViewImpl channelContextViewImpl) {
        this.a = channelContextViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, Tracker.Events.CREATIVE_COLLAPSE);
        if (bool2.booleanValue()) {
            ChatHeader.DefaultImpls.collapse$default(this.a.b, false, 1, null);
        } else {
            ChatHeader.DefaultImpls.expand$default(this.a.b, false, 1, null);
        }
    }
}
