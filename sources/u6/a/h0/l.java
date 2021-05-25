package u6.a.h0;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {2223}, m = "elementAt", n = {"$this$elementAt", FirebaseAnalytics.Param.INDEX, "$this$elementAtOrElse$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "count$iv"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "I$1"})
public final class l extends ContinuationImpl {
    public /* synthetic */ Object a;
    public int b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public int i;
    public int j;

    public l(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return ChannelsKt.elementAt(null, 0, this);
    }
}
