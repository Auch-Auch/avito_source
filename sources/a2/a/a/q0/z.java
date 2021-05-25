package a2.a.a.q0;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class z<T> implements Consumer<Throwable> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public z(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ExtendedProfileViewModelImpl.access$hideProgressAsDialog(this.a);
        ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
        ErrorHelper errorHelper = extendedProfileViewModelImpl.z;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        ExtendedProfileViewModelImpl.access$showSnackbar(extendedProfileViewModelImpl, errorHelper.recycle(th2));
    }
}
