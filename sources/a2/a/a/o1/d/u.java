package a2.a.a.o1.d;

import android.content.ActivityNotFoundException;
import android.content.Context;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class u extends Lambda implements Function1<Exception, Unit> {
    public final /* synthetic */ ChannelFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(ChannelFragment channelFragment) {
        super(1);
        this.a = channelFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        Intrinsics.checkNotNullParameter(exc2, "it");
        if (exc2 instanceof ActivityNotFoundException) {
            ChannelFragment channelFragment = this.a;
            int i = R.string.cant_do_call;
            Context context = channelFragment.getContext();
            if (context != null) {
                ToastsKt.showToast(context, i, 0);
            }
        } else {
            Logs.error("ChannelFragment", "Could not start dialer activity", exc2);
            ChannelFragment channelFragment2 = this.a;
            int i2 = R.string.unknown_error;
            Context context2 = channelFragment2.getContext();
            if (context2 != null) {
                ToastsKt.showToast(context2, i2, 0);
            }
        }
        return Unit.INSTANCE;
    }
}
