package a2.a.a.f1.h.d;

import com.avito.android.in_app_calls.ui.call.CallFragment;
import com.avito.android.in_app_calls.ui.call.CallPresenter;
import com.avito.android.in_app_calls.ui.call.CallView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<CallPresenter.State> {
    public final /* synthetic */ CallFragment a;

    public a(CallFragment callFragment) {
        this.a = callFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CallPresenter.State state) {
        CallPresenter.State state2 = state;
        CallView access$getCallView$p = CallFragment.access$getCallView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(state2, "state");
        access$getCallView$p.render(state2);
        if (this.a.getFeatures().getCallsDebugMode().invoke().booleanValue()) {
            CallFragment.access$getCallDebugInfoView$p(this.a).render(state2);
        }
    }
}
