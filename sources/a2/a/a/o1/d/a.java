package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.ChannelActivityFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ChannelActivityFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ChannelActivityFragment channelActivityFragment) {
        super(0);
        this.a = channelActivityFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.o.onUnbind();
        return Unit.INSTANCE;
    }
}
