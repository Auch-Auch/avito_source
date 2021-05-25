package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<String> {
    public final /* synthetic */ ChannelFragment a;

    public c(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        ChannelReplySuggestsPresenter channelReplySuggestsPresenter = this.a.getChannelReplySuggestsPresenter();
        Intrinsics.checkNotNullExpressionValue(str2, "clickedSuggest");
        channelReplySuggestsPresenter.replySuggestClicked(str2);
    }
}
