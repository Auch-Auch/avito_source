package a2.a.a.o1.b.b.e;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.messenger.channels.mvi.view.ChannelListItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ChannelListItem a;
    public final /* synthetic */ LifecycleOwner b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ChannelListItem channelListItem, LifecycleOwner lifecycleOwner) {
        super(0);
        this.a = channelListItem;
        this.b = lifecycleOwner;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.getHideSwipeViewsStream().postValue(0);
        this.a.getItemClickListener().invoke();
        return Unit.INSTANCE;
    }
}
