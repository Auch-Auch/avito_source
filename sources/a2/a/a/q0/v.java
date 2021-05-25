package a2.a.a.q0;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.extended_profile.adapter.error.ErrorItem;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class v<T> implements Consumer<Throwable> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public v(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ErrorHelper errorHelper = this.a.z;
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        String recycle = errorHelper.recycle(th2);
        this.a.l = d.listOf(new ErrorItem(null, null, recycle, 3, null));
        this.a.h(ExtendedProfileTracker.TrackFlow.EXTENDED_PROFILE_FAILURE);
    }
}
