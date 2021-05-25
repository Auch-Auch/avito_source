package u6.a.h0;

import com.avito.android.analytics.screens.InternalConstsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0}, l = {313}, m = InternalConstsKt.FIRST_IMAGE, n = {"$this$first", "$this$consume$iv", "cause$iv", "$this$consume", "iterator"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class t extends ContinuationImpl {
    public /* synthetic */ Object a;
    public int b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public t(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return ChannelsKt.first(null, this);
    }
}
