package a2.a.a.f1.h.d;

import com.avito.android.in_app_calls.analytics.AppCallRating;
import com.avito.android.in_app_calls.ui.call.CallFragment;
import com.avito.android.in_app_calls.ui.call.CallPresenter;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<AppCallRating> {
    public final /* synthetic */ CallFragment a;

    public b(CallFragment callFragment) {
        this.a = callFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(AppCallRating appCallRating) {
        AppCallRating appCallRating2 = appCallRating;
        CallPresenter callPresenter = this.a.getCallPresenter();
        Intrinsics.checkNotNullExpressionValue(appCallRating2, "it");
        callPresenter.rateCall(appCallRating2);
    }
}
